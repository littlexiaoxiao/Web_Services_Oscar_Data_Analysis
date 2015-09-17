package model;

import java.io.*;
import java.net.*;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import databean.SearchFlikrBean;
import databean.ImageInfoBean;
//import databean.SearchFlikrBean.Photo;

public class FlickrDAO {
    private static String downloadDir = new String("./download/");
    private static String jsonDir = new String( downloadDir + "json/");
    private static String imgDir = new String( downloadDir + "img/");
    private static String searchJsonFile = new String( jsonDir + "search.json" );
    private static String infoJsonFile = new String( jsonDir + "info.json" );
    private static String fileType = new String( "json" );
    private static String apiKey = new String( "32ec3f01ee1e6a1174746656e271acfc" );
    
    private static String startDay = new String("2012-1-1");
    private static String endDay = new String("2015-2-9");

    private String concateStrings(ArrayList<String> hashtags){
        StringBuilder br = new StringBuilder();
        String prefix = "";
        for( String s : hashtags ){
            br.append(prefix);
            prefix = "%2C"; // = ","
            br.append(s);
        }
        return br.toString();
    }

    public String getSearchJson(ArrayList<String> hashtags) throws Exception{
        String hashs = concateStrings(hashtags);
        System.err.println(hashs);
        String url = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=" + apiKey  
            + "&tags=" + hashs 
            + "&format=" + fileType 
            + "&min_upload_date=" + startDay 
            + "&max_upload_date=" + endDay 
            + "&sort=relevance"
            + "&&nojsoncallback=1";
        return url;
    }

    public SearchFlikrBean getSearchFlickrBean(ArrayList<String> hashtags) throws Exception {
        String targetUrl = getSearchJson(hashtags);
        URL jsonURL = new URL(targetUrl);
        ObjectMapper mapperPhotos = new ObjectMapper();	
        SearchFlikrBean searchFlikr = mapperPhotos.readValue(jsonURL, SearchFlikrBean.class);
        System.out.println("in get search flickr bean, total = " + searchFlikr.getPhotos().getTotal() 
                + "\n\turl = " + targetUrl);
        return searchFlikr;
    }


    //---------------------------added by r44 FEB 9TH :search for get Flickr imgs------------------
    // get total url of jpg given Search results
    public ArrayList<String> getImgByUrl(SearchFlikrBean sfb) throws Exception{
        ArrayList<String> urls = new ArrayList<String>();
        String farmId = null;
        String serverId = null;
        String imgId = null;
        String secret = null;
        String filename = null;
        String url = null;
        List photoList = sfb.getPhotos().getPhoto();
        System.err.printf("In getimgbyUrl, list size = %d\n", photoList.size());
        for(int i = 0; i < photoList.size(); i ++){
            LinkedHashMap ph = (LinkedHashMap) photoList.get(i);
            farmId = ph.get("farm").toString();
            serverId = ph.get("server").toString();
            imgId = ph.get("id").toString();
            secret = ph.get("secret").toString();
            filename = imgId + "_" + secret + ".jpg";
            url = "https://farm" + farmId + ".staticflickr.com/" + serverId + "/" + filename; 
            urls.add(url);
            //System.err.printf("Processing:\t%s, size = %d\n", url, urls.size());
        }
        return urls;
    }

    //---------------------------added by Joven FEB 9TH :search for top movie results------------------
    // get total search result num of keyword
    public String getSearchTotal(String keyword) throws Exception {
        ArrayList<String> hs = new ArrayList<String>();
        hs.add(keyword);
        String targetUrl = getSearchJson(hs);
        URL jsonURL = new URL(targetUrl);
        SearchFlikrBean searchFlikr = null;
        ObjectMapper mapperPhotos = new ObjectMapper();	
        searchFlikr = mapperPhotos.readValue(jsonURL, SearchFlikrBean.class);
        String total = searchFlikr.getPhotos().getTotal();
        System.out.println("++++++++" + total);
        return total;
    }
    //---------------------------added by Joven FEB 9TH :search for top movie results------------------

    public String getSearchTotal(ArrayList<String> hashtags) throws Exception {
        String targetUrl = getSearchJson(hashtags);
        URL jsonURL = new URL(targetUrl);
        System.out.println(targetUrl);
        SearchFlikrBean searchFlikr = null;
        ObjectMapper mapperPhotos = new ObjectMapper();	
        searchFlikr = mapperPhotos.readValue(jsonURL, SearchFlikrBean.class);
        String total = searchFlikr.getPhotos().getTotal();
        return total;
    }

//    public ImageInfoBean getInfoJson(String imgId) throws Exception{
//        String targetUrl = "https://api.flickr.com/services/rest/?method=flickr.photos.getInfo&api_key=" 
//                            + apiKey + "&photo_id="+imgId+"&format=" + fileType +"&nojsoncallback=1";           
//        System.out.println(targetUrl);
//        URL jsonURL = new URL(targetUrl);
//        ImageInfoBean imageInfoBean = null;
//        ObjectMapper mapperImageInfo = new ObjectMapper();	
//        imageInfoBean = mapperImageInfo.readValue(jsonURL, ImageInfoBean.class);
//        return imageInfoBean;
//    }

    //---------------------------added by r44 FEB 9TH :search for get Flickr imgs------------------
    // get total url of jpg file given many tags
    public ArrayList<String> getImgUrls(ArrayList<String> hashtags) throws Exception{
        SearchFlikrBean sfb = getSearchFlickrBean(hashtags); 
        return getImgByUrl(sfb);
    }

}
