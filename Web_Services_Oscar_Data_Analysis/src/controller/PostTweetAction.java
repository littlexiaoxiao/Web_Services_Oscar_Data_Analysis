package controller;

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

public class PostTweetAction extends Action {
	private TwitterPlusDAO twitterPlusDAO;
	private HistoryDAO historyDAO;

    public PostTweetAction(Model model) {
		twitterPlusDAO = model.getTwitterPlusDAO();
		historyDAO = model.getHistoryDAO();
    }

    public String getName() { return "PostTweet.do"; }

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
		HttpSession session = request.getSession();
		String movieName = (String) request.getParameter("movieName");
		System.out.println("movie name is: " + movieName);
		String movie = (String) request.getParameter("movie");
		System.out.println("movie is:" + movie);
		session.setAttribute("movieName", movieName);
		session.setAttribute("movie", movie);
		
		try {
			String myTweet = request.getParameter("post");
			System.out.println("The message i want to post is: " + myTweet);
			JSONObject user = (JSONObject) session.getAttribute("user");
			session.setAttribute("user", user);
			
			//check if tweet exceeded 140 characters
			if(myTweet.length() <= 140)
			{
				JSONObject tweet = twitterPlusDAO.updateStatus( (String) user.getString("access_token"), (String) user.getString("access_token_secret"), myTweet);
				//write to our database
				historyDAO.addHistory(myTweet, movie, "Post");
				request.setAttribute("tweet", tweet);
			}
			else
			{
				//alert user
			}
			
			return "get-tweet.do";
		} catch (Exception e) {
			System.out.println(e);
			return "error.jsp";
		}
	}
}
