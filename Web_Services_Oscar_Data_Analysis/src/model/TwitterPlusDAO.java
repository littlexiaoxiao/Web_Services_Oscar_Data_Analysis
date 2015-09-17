package model;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.DefaultHttpClientConnection;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.params.SyncBasicHttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.ImmutableHttpProcessor;
import org.apache.http.protocol.RequestConnControl;
import org.apache.http.protocol.RequestContent;
import org.apache.http.protocol.RequestExpectContinue;
import org.apache.http.protocol.RequestTargetHost;
import org.apache.http.protocol.RequestUserAgent;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import databean.SearchTweetBean;

public class TwitterPlusDAO {
    private String twitter_consumer_key;
    private String twitter_consumer_secret;
    public String twitter_endpoint_host;

    public TwitterPlusDAO() {
        this.twitter_consumer_key = "vhichu7R2dVyDOSomjQbw";
        this.twitter_consumer_secret = "fWcYCGSm4FHuuA41VwrhOD58qwngFkfnkysLe7ZpRM";
        this.twitter_endpoint_host = "api.twitter.com";
    }

    public String encode(String value) {
        String encoded = null;
        try {
            encoded = URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException ignore) {
        }
        StringBuilder buf = new StringBuilder(encoded.length());
        char focus;
        for (int i = 0; i < encoded.length(); i++) {
            focus = encoded.charAt(i);
            if (focus == '*') {
                buf.append("%2A");
            } else if (focus == '+') {
                buf.append("%20");
            } else if (focus == '%' && (i + 1) < encoded.length()
                    && encoded.charAt(i + 1) == '7'
                    && encoded.charAt(i + 2) == 'E') {
                buf.append('~');
                i += 2;
            } else {
                buf.append(focus);
            }
        }
        return buf.toString();
    }

    private static String computeSignature(String baseString, String keyString)
        throws GeneralSecurityException, UnsupportedEncodingException {
        SecretKey secretKey = null;

        byte[] keyBytes = keyString.getBytes();
        secretKey = new SecretKeySpec(keyBytes, "HmacSHA1");

        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(secretKey);

        byte[] text = baseString.getBytes();

        return new String(Base64.encodeBase64(mac.doFinal(text))).trim();
    }

    private String connectAPI(String get_or_post, String twitter_endpoint_path,
            String oauth_token, String oauth_token_secret, String q, String text, String id) {
        // this particular request uses POST

        // I think this is the signature method used for all Twitter API calls
        String oauth_signature_method = "HMAC-SHA1";

        // generate any fairly random alphanumeric string as the "nonce". Nonce
        // = Number used ONCE.
        String uuid_string = UUID.randomUUID().toString();
        uuid_string = uuid_string.replaceAll("-", "");
        String oauth_nonce = uuid_string; // any relatively random alphanumeric
        // string will work here

        // get the timestamp
        Calendar tempcal = Calendar.getInstance();
        long ts = tempcal.getTimeInMillis();// get current time in milliseconds
        String oauth_timestamp = (new Long(ts / 1000)).toString();
        // then divide by 1000 to get seconds

        // assemble the proper parameter string, which must be in alphabetical
        // order, using your consumer key
        String parameter_string = "";
        if (oauth_token.length() != 0 && q.length() != 0) {
            parameter_string = "lang=en&oauth_consumer_key="
                + twitter_consumer_key + "&oauth_nonce=" + oauth_nonce
                + "&oauth_signature_method=" + oauth_signature_method
                + "&oauth_timestamp=" + oauth_timestamp + "&oauth_token="
                + encode(oauth_token) + "&oauth_version=1.0&q=" + encode(q)
                + "&result_type=popular";
        } else if (oauth_token.length() != 0 && text.length() != 0 && id.length() == 0) {
            parameter_string = "oauth_consumer_key=" + twitter_consumer_key + "&oauth_nonce=" + oauth_nonce + "&oauth_signature_method=" + oauth_signature_method + 
                "&oauth_timestamp=" + oauth_timestamp + "&oauth_token=" + encode(oauth_token) + "&oauth_version=1.0&status=" + encode(text);

        } else if (oauth_token.length() != 0 && id.length() != 0 && text.length() == 0) {
            parameter_string = "oauth_consumer_key=" + twitter_consumer_key
                + "&oauth_nonce=" + oauth_nonce + "&oauth_signature_method="
                + oauth_signature_method + "&oauth_timestamp="
                + oauth_timestamp + "&oauth_token=" + encode(oauth_token)
                + "&oauth_version=1.0";

        } else if (oauth_token.length() != 0 && id.length() != 0 && text.length() != 0) {
            parameter_string = "oauth_consumer_key=" + twitter_consumer_key + "&oauth_nonce=" + oauth_nonce + "&oauth_signature_method=" + oauth_signature_method + 
                "&oauth_timestamp=" + oauth_timestamp + "&oauth_token=" + encode(oauth_token) + "&oauth_version=1.0&status=" + encode(text);

        } else if (oauth_token.length() != 0) {
            parameter_string = "oauth_consumer_key=" + twitter_consumer_key
                + "&oauth_nonce=" + oauth_nonce + "&oauth_signature_method="
                + oauth_signature_method + "&oauth_timestamp="
                + oauth_timestamp + "&oauth_token=" + encode(oauth_token)
                + "&oauth_version=1.0";
        } else {
            parameter_string = "oauth_consumer_key=" + twitter_consumer_key
                + "&oauth_nonce=" + oauth_nonce + "&oauth_signature_method="
                + oauth_signature_method + "&oauth_timestamp="
                + oauth_timestamp + "&oauth_version=1.0";
        }
        System.out.println("parameter_string=" + parameter_string);
        // print out parameter string for error checking, if you want

        // specify the proper twitter API endpoint at which to direct this
        // request
        String twitter_endpoint = "https://" + twitter_endpoint_host
            + twitter_endpoint_path;

        System.out.println("!!!!!!!!!!!!!!!!!!!! URL is: " + twitter_endpoint);

        // assemble the string to be signed. It is METHOD & percent-encoded
        // endpoint & percent-encoded parameter string
        // Java's native URLEncoder.encode function will not work. It is the
        // wrong RFC specification (which does "+" where "%20" should be)...
        // the encode() function included in this class compensates to conform
        // to RFC 3986 (which twitter requires)

        String signature_base_string = "";
        if(id.length()!=0 && text.length() == 0)
        {
            signature_base_string = get_or_post + "&"
                + encode(twitter_endpoint) + "&" + encode("id=") + id + encode("&") + encode(parameter_string);
        }
        else if(id.length()!=0 && text.length()!=0)
        {
            signature_base_string = get_or_post + "&"
                + encode(twitter_endpoint) + "&in_reply_to_status_id" + encode("=") + id + encode("&") + encode(parameter_string);
        }
        else
        {
            signature_base_string = get_or_post + "&"
                + encode(twitter_endpoint) + "&" + encode(parameter_string);
        }

        // now that we've got the string we want to sign (see directly above)
        // HmacSHA1 hash it against the consumer secret
        String oauth_signature = "";
        try {
            if (oauth_token_secret.length() != 0) {
                oauth_signature = computeSignature(signature_base_string,
                        twitter_consumer_secret + "&" + encode(oauth_token_secret)); 
            } else {
                oauth_signature = computeSignature(signature_base_string,
                        twitter_consumer_secret + "&");
            }
            // note the & at the end. Normally the user access_token would go
            // here, but we don't know it yet for request_token
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // each request to the twitter API 1.1 requires an "Authorization: BLAH"
        // header. The following is what BLAH should look like
        String authorization_header_string = "";
        if (oauth_token.length() == 0) {
            authorization_header_string = "OAuth oauth_consumer_key=\""
                + twitter_consumer_key
                + "\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\""
                + oauth_timestamp + "\",oauth_nonce=\"" + oauth_nonce
                + "\",oauth_version=\"1.0\",oauth_signature=\""
                + encode(oauth_signature) + "\"";
            System.out.println("authorization_header_string="
                    + authorization_header_string);
        } else {
            authorization_header_string = "OAuth oauth_consumer_key=\""
                + twitter_consumer_key
                + "\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\""
                + oauth_timestamp + "\",oauth_nonce=\"" + oauth_nonce
                + "\",oauth_version=\"1.0\",oauth_signature=\""
                + encode(oauth_signature) + "\",oauth_token=\""
                + encode(oauth_token) + "\"";
            System.out.println("authorization_header_string="
                    + authorization_header_string);
        }
        return authorization_header_string;
    }

    private HttpResponse getResponse(DefaultHttpClientConnection conn,
            String get_or_post, String twitter_endpoint_path,
            String twitter_endpoint_host, String authorization_header_string, String verifier_or_pin, String q, String text, String id) {
        // I'm using Apache HTTPCore to make the connection and process the
        // request. In theory, you could use HTTPClient, but HTTPClient defaults
        // to the wrong RFC encoding, which has to be tweaked.
        HttpParams params = new SyncBasicHttpParams();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, "UTF-8");
        HttpProtocolParams.setUserAgent(params, "HttpCore/1.1");
        HttpProtocolParams.setUseExpectContinue(params, false);

        HttpProcessor httpproc = new ImmutableHttpProcessor(
                new HttpRequestInterceptor[] {
                    // Required protocol interceptors
                    new RequestContent(), new RequestTargetHost(),
                      // Recommended protocol interceptors
                      new RequestConnControl(), new RequestUserAgent(),
                      new RequestExpectContinue() });

        HttpRequestExecutor httpexecutor = new HttpRequestExecutor();
        HttpContext context = new BasicHttpContext(null);
        HttpHost host = new HttpHost(twitter_endpoint_host, 443);
        // use 80 if you want regular HTTP (not HTTPS)

        context.setAttribute(ExecutionContext.HTTP_CONNECTION, conn);
        context.setAttribute(ExecutionContext.HTTP_TARGET_HOST, host);

        try {
            // initialize the HTTPS connection
            SSLContext sslcontext = SSLContext.getInstance("TLS");
            sslcontext.init(null, null, null);
            SSLSocketFactory ssf = sslcontext.getSocketFactory();
            Socket socket = ssf.createSocket();
            socket.connect(
                    new InetSocketAddress(host.getHostName(), host.getPort()),
                    0);
            conn.bind(socket, params);

            // for HTTP, use this instead of the above.
            // Socket socket = new Socket(host.getHostName(),
            // host.getPort());
            // conn.bind(socket, params);

            if (q.length() != 0) {
                twitter_endpoint_path += "?lang=en&result_type=popular&q=" + encode(q);
            }
            BasicHttpEntityEnclosingRequest request = new BasicHttpEntityEnclosingRequest(
                    get_or_post, twitter_endpoint_path);

            if (verifier_or_pin.length() != 0) {
                request.setEntity(new StringEntity("oauth_verifier="
                            + encode(verifier_or_pin),
                            "application/x-www-form-urlencoded", "UTF-8"));
            } else if (q.length() != 0) {

            } else if (id.length() != 0 && text.length() == 0) {
                request.setEntity(new StringEntity("id=" + encode(id),
                            "application/x-www-form-urlencoded", "UTF-8"));

            } else if (text.length() != 0 && id.length() == 0) {
                request.setEntity(new StringEntity("status=" + encode(text),
                            "application/x-www-form-urlencoded", "UTF-8"));
            } else if (text.length() != 0 && id.length() != 0) {
                request.setEntity(new StringEntity("status=" + encode(text) + "&&in_reply_to_status_id=" + id,
                            "application/x-www-form-urlencoded", "UTF-8"));
            } else {
                request.setEntity(new StringEntity("",
                            "application/x-www-form-urlencoded", "UTF-8"));
            }

            request.setParams(params);
            request.addHeader("Authorization", authorization_header_string);


            httpexecutor.preProcess(request, httpproc, context);
            HttpResponse response = httpexecutor
                .execute(request, conn, context);
            response.setParams(params);
            httpexecutor.postProcess(response, httpproc, context);
            return response;
        } catch (HttpException he) {
            System.out.println(he.getMessage());
            return null;
        } catch (NoSuchAlgorithmException nsae) {
            System.out.println(nsae.getMessage());
            return null;
        } catch (KeyManagementException kme) {
            System.out.println(kme.getMessage());
            return null;
        } catch (IOException ioe) {
            // TODO Auto-generated catch block
            ioe.printStackTrace();
            System.out.println(ioe.getMessage());
            return null;
        }
    }

    public JSONObject startTwitterAuthentication() {
        JSONObject jsonresponse = new JSONObject();
        String get_or_post = "POST";
        String twitter_endpoint_path = "/oauth/request_token";
        String oauth_token = "";
        String oauth_token_secret = "";
        String q = "";
        String verifier_or_post = "";
        String text = "";
        String id = "";
        String authorization_header_string = connectAPI(get_or_post,
                twitter_endpoint_path, oauth_token, oauth_token_secret, q, text, id);

        DefaultHttpClientConnection conn = new DefaultHttpClientConnection();

        try {
            try {
                HttpResponse myResponse = getResponse(conn, get_or_post,
                        twitter_endpoint_path, twitter_endpoint_host,
                        authorization_header_string, verifier_or_post, q, text, id);
                if (myResponse.getStatusLine().toString().indexOf("200") == -1) {
                    // return indicating as such

                    System.out.println("Cannot connect.");
                    jsonresponse.put("response_status", "error");
                    jsonresponse
                        .put("message",
                                "Twitter request_token request failed. Response was !200.");
                } else {
                    // returned 200 (good)
                    String responseBody = EntityUtils.toString(myResponse
                            .getEntity());
                    System.out
                        .println("endpoint startTwitterAuthentication responsebody="
                                + responseBody); // print out the response

                    if (responseBody.indexOf("oauth_callback_confirmed=") == -1) {

                        jsonresponse.put("response_status", "error");
                        jsonresponse
                            .put("message",
                                    "Twitter request_token request failed. response was 200 but did not contain oauth_callback_confirmed");
                    } else {
                        // this assumes that oauth_callback_confirmed is always
                        // the last of the three values returned. I don't know
                        // 100% that is true, but it seems to be.
                        String occ_val = responseBody.substring(responseBody
                                .indexOf("oauth_callback_confirmed=") + 25);
                        if (!occ_val.equals("true")) {
                            jsonresponse.put("response_status", "error");
                            jsonresponse
                                .put("message",
                                        "Twitter request_token response was 200 and contained oauth_callback_confirmed but it was not \"true\".");
                        } else { // everything seems a-ok. look for values and
                            // return them.

                            // using the tokenizer takes away the need for the
                            // values to be in any particular order.
                            StringTokenizer st = new StringTokenizer(
                                    responseBody, "&");
                            String currenttoken = "";
                            while (st.hasMoreTokens()) {
                                currenttoken = st.nextToken();
                                if (currenttoken.startsWith("oauth_token="))
                                    oauth_token = currenttoken
                                        .substring(currenttoken
                                                .indexOf("=") + 1);
                                else if (currenttoken
                                        .startsWith("oauth_token_secret="))
                                    oauth_token_secret = currenttoken
                                        .substring(currenttoken
                                                .indexOf("=") + 1);
                                else if (currenttoken
                                        .startsWith("oauth_callback_confirmed=")) {
                                    // oauth_callback_confirmed =
                                    // currenttoken.substring(currenttoken.indexOf("=")
                                    // + 1);
                                } else {
                                    System.out
                                        .println("Warning... twitter returned a key we weren't looking for.");
                                }
                            }
                            if (oauth_token.equals("")
                                    || oauth_token_secret.equals("")) {
                                // if either key is empty, that's weird and bad

                                jsonresponse.put("response_status", "error");
                                jsonresponse
                                    .put("message",
                                            "oauth tokens in response were invalid");
                            } else {
                                // otherwise, we're all good. Return the
                                // values (did not include
                                // oauth_token_confirmed here. no need)

                                jsonresponse.put("response_status", "success");
                                jsonresponse.put("oauth_token", oauth_token);
                                // jsonresponse.put("oauth_token_secret",
                                // oauth_token);
                            }
                        }
                    }
                }

            } finally {
                conn.close();
            }
        } catch (JSONException jsone) {

        } catch (IOException ioe) {

        }
        return jsonresponse;
    }

    public JSONObject getTwitterAccessTokenFromAuthorizationCode(
            String verifier_or_pin, String oauth_token) {
        JSONObject jsonresponse = new JSONObject();

        String get_or_post = "POST";
        String twitter_endpoint_path = "/oauth/access_token";
        String oauth_token_secret = "";
        String q = "";
        String text = "";
        String id = "";
        String authorization_header_string = connectAPI(get_or_post,
                twitter_endpoint_path, oauth_token, oauth_token_secret, q, text, id);

        DefaultHttpClientConnection conn = new DefaultHttpClientConnection();

        String access_token = "";
        String access_token_secret = "";
        String user_id = "";
        String screen_name = "";

        try {
            try {
                HttpResponse myResponse = getResponse(conn, get_or_post,
                        twitter_endpoint_path, twitter_endpoint_host,
                        authorization_header_string, verifier_or_pin, q, text, id);

                if (myResponse.getStatusLine().toString().indexOf("200") == -1) {
                    jsonresponse.put("response_status", "error");
                    jsonresponse
                        .put("message",
                                "getTwitterAccessTokenFromAuthorizationCode request failed. Response was !200.");
                } else {
                    String responseBody = EntityUtils.toString(myResponse
                            .getEntity());
                    StringTokenizer st = new StringTokenizer(responseBody, "&");
                    String currenttoken = "";
                    while (st.hasMoreTokens()) {
                        currenttoken = st.nextToken();
                        if (currenttoken.startsWith("oauth_token="))
                            access_token = currenttoken.substring(currenttoken
                                    .indexOf("=") + 1);
                        else if (currenttoken.startsWith("oauth_token_secret="))
                            access_token_secret = currenttoken
                                .substring(currenttoken.indexOf("=") + 1);
                        else if (currenttoken.startsWith("user_id="))
                            user_id = currenttoken.substring(currenttoken
                                    .indexOf("=") + 1);
                        else if (currenttoken.startsWith("screen_name="))
                            screen_name = currenttoken.substring(currenttoken
                                    .indexOf("=") + 1);

                    }
                }
                if (access_token.equals("") || access_token_secret.equals("")) {
                    jsonresponse.put("response_status", "error");
                    jsonresponse
                        .put("message",
                                "code into access token failed. oauth tokens in response were invalid");
                } else {
                    System.out.println("My access token is:" + access_token);
                    jsonresponse.put("response_status", "success");
                    jsonresponse.put("access_token", access_token);
                    jsonresponse
                        .put("access_token_secret", access_token_secret);
                    jsonresponse.put("user_id", user_id);
                    jsonresponse.put("screen_name", screen_name);
                }
            } finally {
                conn.close();
            }
        } catch (JSONException jsone) {

        } catch (IOException ioe) {

        }
        return jsonresponse;
            }

    public JSONObject searchTweets(String q, String access_token,
            String access_token_secret) {
        JSONObject jsonresponse = new JSONObject();

        String oauth_token = access_token;
        String oauth_token_secret = access_token_secret;
        String verifier_or_pin = "";

        String get_or_post = "GET";
        String twitter_endpoint_path = "/1.1/search/tweets.json";
        String text = "";
        String id = "";
        String authorization_header_string = connectAPI(get_or_post,
                twitter_endpoint_path, oauth_token, oauth_token_secret, q, text, id);

        DefaultHttpClientConnection conn = new DefaultHttpClientConnection();

        try {
            try {
                HttpResponse myResponse = getResponse(conn, get_or_post,
                        twitter_endpoint_path, twitter_endpoint_host,
                        authorization_header_string, verifier_or_pin, q, text, id);
                if (myResponse.getStatusLine().toString().indexOf("500") != -1) {
                    jsonresponse.put("response_status", "error");
                    jsonresponse.put("message", "Twitter auth error.");
                } else {
                    // if successful, the response should be a JSONObject of
                    // tweets
                    JSONObject jo = new JSONObject(
                            EntityUtils.toString(myResponse.getEntity()));
                    if (jo.has("errors")) {
                        jsonresponse.put("response_status", "error");
                        String message_from_twitter = jo.getJSONArray("errors")
                            .getJSONObject(0).getString("message");
                        if (message_from_twitter
                                .equals("Invalid or expired token")
                                || message_from_twitter
                                .equals("Could not authenticate you"))
                            jsonresponse.put("message", "Twitter auth error.");
                        else
                            jsonresponse.put("message",
                                    jo.getJSONArray("errors").getJSONObject(0)
                                    .getString("message"));
                    } else {
                        jsonresponse.put("twitter_jo", jo); 
                    }
                }
            } finally {
                conn.close();
            }
        } catch (JSONException jsone) {

        } catch (IOException ioe) {

        }
        return jsonresponse;
    }


    public JSONObject updateStatus(String access_token, String access_token_secret, String text)
    {
        JSONObject jsonresponse = new JSONObject();

        String oauth_token = access_token;
        String oauth_token_secret = access_token_secret;
        String verifier_or_pin = "";
        // generate authorization header
        String get_or_post = "POST";

        String twitter_endpoint_path = "/1.1/statuses/update.json";
        String q = "";
        String id = "";
        String authorization_header_string = connectAPI(get_or_post, twitter_endpoint_path, oauth_token, oauth_token_secret, q, text, id	);


        DefaultHttpClientConnection conn = new DefaultHttpClientConnection();

        try 
        {
            try 
            {
                HttpResponse myResponse = getResponse(conn, get_or_post, twitter_endpoint_path, twitter_endpoint_host, authorization_header_string, verifier_or_pin, q, text, id);
                if(myResponse.getStatusLine().toString().indexOf("500")!= -1)
                {
                    jsonresponse.put("response_status", "error");
                    jsonresponse.put("message", "Twitter auth error.");
                }
                else
                {
                    JSONObject jo = new JSONObject(EntityUtils.toString(myResponse.getEntity()));
                    if(jo.has("error"))
                    {
                        jsonresponse.put("response_status", "error");
                        String m = jo.getJSONArray("errors").getJSONObject(0).getString("message");
                        if(m.equals("Invalid or expired token") || m.equals("Could not authenticate you"))
                        {
                            jsonresponse.put("message", "Twitter auth error.");
                        }
                        else
                        {
                            jsonresponse.put("message", jo.getJSONArray("errors").getJSONObject(0).getString("message"));
                        }
                    }
                    else
                    {
                        jsonresponse.put("twitter_jo", jo);
                    }
                }
            }   

            finally 
            {
                conn.close();
            }	
        } 
        catch(JSONException jsone)
        {
            jsone.printStackTrace();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        return jsonresponse;
    }

    public JSONObject replyStatus(String access_token, String access_token_secret, String text, String id)
    {
        JSONObject jsonresponse = new JSONObject();

        String oauth_token = access_token;
        String oauth_token_secret = access_token_secret;
        String verifier_or_pin = "";
        // generate authorization header
        String get_or_post = "POST";

        String twitter_endpoint_path = "/1.1/statuses/update.json";
        String q = "";
        String authorization_header_string = connectAPI(get_or_post, twitter_endpoint_path, oauth_token, oauth_token_secret, q, text, id	);


        DefaultHttpClientConnection conn = new DefaultHttpClientConnection();

        try 
        {
            try 
            {
                HttpResponse myResponse = getResponse(conn, get_or_post, twitter_endpoint_path, twitter_endpoint_host, authorization_header_string, verifier_or_pin, q, text, id);
                if(myResponse.getStatusLine().toString().indexOf("500")!= -1)
                {
                    jsonresponse.put("response_status", "error");
                    jsonresponse.put("message", "Twitter auth error.");
                }
                else
                {
                    JSONObject jo = new JSONObject(EntityUtils.toString(myResponse.getEntity()));
                    if(jo.has("error"))
                    {
                        jsonresponse.put("response_status", "error");
                        String m = jo.getJSONArray("errors").getJSONObject(0).getString("message");
                        if(m.equals("Invalid or expired token") || m.equals("Could not authenticate you"))
                        {
                            jsonresponse.put("message", "Twitter auth error.");
                        }
                        else
                        {
                            jsonresponse.put("message", jo.getJSONArray("errors").getJSONObject(0).getString("message"));
                        }
                    }
                    else
                    {
                        jsonresponse.put("twitter_jo", jo);
                    }
                }
            }   

            finally 
            {
                conn.close();
            }	
        } 
        catch(JSONException jsone)
        {
            jsone.printStackTrace();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        return jsonresponse;
    }



    public JSONObject favoriteStatus(String access_token, String access_token_secret, String id)
    {
        JSONObject jsonresponse = new JSONObject();

        String oauth_token = access_token;
        String oauth_token_secret = access_token_secret;
        String verifier_or_pin = "";
        String text = "";
        String q = "";

        // generate authorization header
        String get_or_post = "POST";			
        String twitter_endpoint_path = "/1.1/favorites/create.json";
        String authorization_header_string = connectAPI(get_or_post, twitter_endpoint_path, oauth_token, oauth_token_secret, q, text, id);

        DefaultHttpClientConnection conn = new DefaultHttpClientConnection();

        try 
        {
            try 
            {
                HttpResponse myResponse = getResponse(conn, get_or_post, twitter_endpoint_path, twitter_endpoint_host, authorization_header_string, verifier_or_pin, q, text, id);
                if(myResponse.getStatusLine().toString().indexOf("500")!= -1)
                {
                    jsonresponse.put("response_status", "error");
                    jsonresponse.put("message", "Twitter auth error.");
                }
                else
                {
                    JSONObject jo = new JSONObject(EntityUtils.toString(myResponse.getEntity()));
                    if(jo.has("error"))
                    {
                        jsonresponse.put("response_status", "error");
                        String m = jo.getJSONArray("errors").getJSONObject(0).getString("message");
                        if(m.equals("Invalid or expired token") || m.equals("Could not authenticate you"))
                        {
                            jsonresponse.put("message", "Twitter auth error.");
                        }
                        else
                        {
                            jsonresponse.put("message", jo.getJSONArray("errors").getJSONObject(0).getString("message"));
                        }
                    }
                    else
                    {
                        jsonresponse.put("twitter_jo", jo);
                    }
                }
            }   

            finally 
            {
                conn.close();
            }	
        } 
        catch(JSONException jsone)
        {
            jsone.printStackTrace();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        return jsonresponse;
    }


    public SearchTweetBean getTweets(JSONObject jo) {
        SearchTweetBean searchTweets = null;
        ObjectMapper mapperTweets = new ObjectMapper();
        try {
            searchTweets = mapperTweets.readValue(jo.toString(), SearchTweetBean.class);
        } catch (Exception e) {
            System.out.println(e);
        }
        return searchTweets;
    }

    //-------------------for Movies trend on twitter-- added on FEB 11st, by Joven ---------------------------------
    public int getRetweetCountTotal(JSONObject jo) {
        int reTweetCount = 0;
        SearchTweetBean searchKeywordBean = getTweets(jo);
        List<databean.SearchTweetBean.TwitterJo.Status> statuses = searchKeywordBean.getTwitterJo().getStatuses();
        for(int i=0; i <statuses.size(); i++) {
            reTweetCount = reTweetCount + statuses.get(i).getRetweetCount();
        }
        return reTweetCount;
    }

}
