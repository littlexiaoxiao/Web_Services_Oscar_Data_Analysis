package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;
import org.json.JSONObject;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databean.SearchTweetBean;
import model.*;

public class GetTweetAction extends Action {
    private TwitterPlusDAO twitterPlusDAO;
    private FlickrDAO flickrDAO;
    private HistoryDAO historyDAO;

    public GetTweetAction(Model model) {
        twitterPlusDAO = model.getTwitterPlusDAO();
        flickrDAO = model.getFlickrDAO();
        historyDAO = model.getHistoryDAO();
    }

    public String getName() {
        return "get-tweet.do";
    }

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        HttpSession session = request.getSession();

        try {
            // flickr info
            String movieName = "";
            if (request.getParameter("movieName") != null) {
                movieName = request.getParameter("movieName");
            } else {
                movieName = (String) session.getAttribute("movieName");
            }
            String movieName0 = "";
            if (request.getParameter("movie") != null) {
                movieName0 = request.getParameter("movie");
            } else {
                movieName0 = (String) session.getAttribute("movie");
            }
            System.out.println(movieName0);
            request.setAttribute("wordFreq", historyDAO.getWordsByTag(movieName0));
//            return "simple.jsp";

            session.setAttribute("movieName", movieName);
            System.out.println("Lalalala I got the movie name is! " + movieName);

            ArrayList<String> movies = new ArrayList<String>();
            movies.add(movieName);
            ArrayList<String> imgUrls;

            imgUrls = flickrDAO.getImgUrls(movies);
            request.setAttribute("imgUrls", imgUrls);

            // tweet info
            String movie = "";
            if (request.getParameter("movie") != null) {
                movie = request.getParameter("movie");
            } else {
                movie = (String) session.getAttribute("movie");
            }
            session.setAttribute("movie", movie);
            JSONObject user = (JSONObject) session.getAttribute("user");
            session.setAttribute("user", user);
            JSONObject tweet = twitterPlusDAO.searchTweets(movie,
                    (String) user.get("access_token"),
                    (String) user.get("access_token_secret"));
            SearchTweetBean tweets = twitterPlusDAO.getTweets(tweet);
            List<databean.SearchTweetBean.TwitterJo.Status> statuses = tweets.getTwitterJo().getStatuses();
            request.setAttribute("statuses", statuses);

            return "movie-detail.jsp";
        } catch (Exception e) {
            System.out.println(e);
            return "error.jsp";
        }
    }
}
