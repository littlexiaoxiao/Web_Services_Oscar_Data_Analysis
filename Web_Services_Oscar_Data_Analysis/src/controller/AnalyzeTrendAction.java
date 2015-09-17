package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;
import org.json.JSONObject;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databean.SearchTweetBean;
import model.FlickrDAO;
import model.HistoryDAO;
//import formbean.LoginForm;
import model.Model;
import model.TwitterPlusDAO;

public class AnalyzeTrendAction extends Action {
	private FlickrDAO flickrDAO;
	private TwitterPlusDAO twitterPlusDAO;
	private HistoryDAO historyDAO;
	
	public AnalyzeTrendAction(Model model) {
    	flickrDAO = model.getFlickrDAO();
    	twitterPlusDAO  = model.getTwitterPlusDAO();
    	historyDAO = model.getHistoryDAO();
    }

    public String getName() { return "AnalyzeTrend.do"; }

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        HttpSession session = request.getSession();

        try{
        	  String[] movieList = {
              		"American Sniper",
                      "The Imitation Game",
                      "Birdman",
                      "Boyhood",
                      "The Theory of Everything",
                      "The Grand Budapest Hotel",
                      "Whiplash",
                      "Foxcatcher",
                      "Interstellar",
                      "The Judge"};
        	  request.setAttribute("movieList", movieList);  
        	  
              String[] movielistKeyword = {
              		"American%20Sniper",
                      "The%20Imitation%20Game",
                      "Birdman",
                      "Boyhood",
                      "The%20Theory%20of%20Everything",
                      "The%20Grand%20Budapest%20Hotel",
                      "Whiplash",
                      "Foxcatcher",
                      "Interstellar",
                      "The%20Judge"};
        	//---------------------------added by Joven FEB 9TH --flickr pop movies---------------------
        	// top 10 Oscar moives on flickr;
        	String[] searchTotalFlicr = new String[10];          
            for(int i=0;i<10;i++) {
            	searchTotalFlicr[i]=flickrDAO.getSearchTotal(movielistKeyword[i]);
            }           
           	request.setAttribute("searchTotalFlicr", searchTotalFlicr);  
          
        	//---------------------------added by Joven FEB 11st --twitter pop movies-------------------   
           // top 10 Oscar moives on twitter;
        	JSONObject user = (JSONObject) session.getAttribute("user");
  			session.setAttribute("user", user);
  			int[] searchTotalTwitter = new int[10];
  			JSONObject[] tweetPostObject = new JSONObject[10];

  			 for(int i=0;i<10;i++) {
  				tweetPostObject[i] = twitterPlusDAO.searchTweets(movielistKeyword[i],
  						(String) user.get("access_token"),
  						(String) user.get("access_token_secret"));
  				searchTotalTwitter[i] = twitterPlusDAO.getRetweetCountTotal(tweetPostObject[i]);
             }
  			request.setAttribute("searchTotalTwitter", searchTotalTwitter);  
  		
          //---------------------------added by Joven FEB 11st --our website's pop movies-------------------   			
  			int[] historyTrendCount1 = historyDAO.getPopMovieCount(movieList[0].toLowerCase());
  			int[] historyTrendCount2 = historyDAO.getPopMovieCount(movieList[1].toLowerCase());
  			int[] historyTrendCount3 = historyDAO.getPopMovieCount(movieList[2].toLowerCase());
  			int[] historyTrendCount4 = historyDAO.getPopMovieCount(movieList[3].toLowerCase());
  			int[] historyTrendCount5 = historyDAO.getPopMovieCount(movieList[4].toLowerCase());
  			int[] historyTrendCount6 = historyDAO.getPopMovieCount(movieList[5].toLowerCase());
  			int[] historyTrendCount7 = historyDAO.getPopMovieCount(movieList[6].toLowerCase());
  			int[] historyTrendCount8 = historyDAO.getPopMovieCount(movieList[7].toLowerCase());
  			int[] historyTrendCount9 = historyDAO.getPopMovieCount(movieList[8].toLowerCase());
  			int[] historyTrendCount10 = historyDAO.getPopMovieCount(movieList[9].toLowerCase());
  			
//  			for(int i=0;i<7;i++){
//  		     System.out.println("+__+++++_the last 7 days of 1st movie___=  "+historyTrendCount2[i]);
//  			}
  			  		     
  			 request.setAttribute("historyTrendCount1", historyTrendCount1);  
          	 request.setAttribute("historyTrendCount2", historyTrendCount2);  
          	 request.setAttribute("historyTrendCount3", historyTrendCount3);  
          	 request.setAttribute("historyTrendCount4", historyTrendCount4);  
          	 request.setAttribute("historyTrendCount5", historyTrendCount5);  
          	 request.setAttribute("historyTrendCount6", historyTrendCount6);  
          	 request.setAttribute("historyTrendCount7", historyTrendCount7);  
          	 request.setAttribute("historyTrendCount8", historyTrendCount8);  
          	 request.setAttribute("historyTrendCount9", historyTrendCount9);  
          	 request.setAttribute("historyTrendCount10", historyTrendCount10);  
          	return "movie-trend.jsp";                   

        } catch (Exception e) {
        	e.printStackTrace();
        	System.out.println("++++++++++bugs+++++++");
        	return  "movie-trend.jsp";
        }
          }
   
}
