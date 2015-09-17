package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;
import org.json.JSONObject;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databean.SearchTweetBean;
import model.HistoryDAO;
//import formbean.LoginForm;
import model.Model;
import model.TwitterPlusDAO;

public class FavoriteTweetAction extends Action {
	private TwitterPlusDAO twitterPlusDAO;
	private HistoryDAO historyDAO;
	
	public FavoriteTweetAction(Model model) {
		twitterPlusDAO = model.getTwitterPlusDAO();
		historyDAO = model.getHistoryDAO();
	}

	public String getName() {
		return "favoriteTweet.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		String idString = (String) request.getParameter("hiddenID");
		System.out.println("fav id is: " + idString);
		HttpSession session = request.getSession();
		String movieName = (String) request.getParameter("movieName");
		String movie = (String) request.getParameter("movie");
		session.setAttribute("movieName", movieName);
		session.setAttribute("movie", movie);

		try {
			JSONObject user = (JSONObject) session.getAttribute("user");
			session.setAttribute("user", user);
			JSONObject tweet = twitterPlusDAO.favoriteStatus(
					(String) user.getString("access_token"),
					(String) user.getString("access_token_secret"), idString);
			
			historyDAO.addHistory("", movie, "Like");
			
			request.setAttribute("tweet", tweet);

			return "get-tweet.do";
		} catch (Exception e) {
			System.out.println(e);
			return "error.jsp";
		}
	}
}
