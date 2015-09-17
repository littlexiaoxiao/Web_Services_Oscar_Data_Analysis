package controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;
import org.json.JSONObject;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;






import model.HistoryDAO;
//import formbean.LoginForm;
import model.Model;
import model.TwitterPlusDAO;

public class ReplyTweetAction extends Action {
	private TwitterPlusDAO twitterPlusDAO;
	private HistoryDAO historyDAO;

    public ReplyTweetAction(Model model) {
		twitterPlusDAO = model.getTwitterPlusDAO();
		historyDAO = model.getHistoryDAO();
    }

    public String getName() { return "replyTweet.do"; }
    

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);

		HttpSession session = request.getSession();
		String movieName = (String) request.getParameter("movieName");
		String movie = (String) request.getParameter("movie");
		session.setAttribute("movieName", movieName);
		session.setAttribute("movie", movie);
        
		try {
			String text = "@" + request.getParameter("hiddenName") + " " + request.getParameter("comment");
			String id = request.getParameter("hiddenID");
			
			System.out.println("the text i want to post is: " + text);
			System.out.println("the hid is: " + id);
			JSONObject user = (JSONObject) session.getAttribute("user");
			
			//check if tweet exceeds 140 characters
			if(text.length() <= 140)
			{
				JSONObject tweet = twitterPlusDAO.replyStatus( (String) user.getString("access_token"), (String) user.getString("access_token_secret"), text, id);
				//write to local database
				historyDAO.addHistory(text, movie, "Reply");
				request.setAttribute("tweet", tweet);
			}
			else
			{
				//do something... pop up box maybe?
				//alert user character limit exceeded
			}
			
			return "get-tweet.do";
		} catch (Exception e) {
			System.out.println(e);
			return "error.jsp";
		}
	}
}
