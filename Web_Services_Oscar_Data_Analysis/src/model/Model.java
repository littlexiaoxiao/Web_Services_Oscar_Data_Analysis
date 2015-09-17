package model;

import java.sql.Date;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.RollbackException;

import databean.*;

import java.io.File;

public class Model {
    private FlickrDAO flickDAO;
    private TwitterPlusDAO twitterPlusDAO;
    private HistoryDAO historyDAO;

    public Model(ServletConfig config) throws ServletException {
        try {
            String jdbcDriver = config.getInitParameter("jdbcDriverName");
            String jdbcURL    = config.getInitParameter("jdbcURL");

            ConnectionPool pool = new ConnectionPool(jdbcDriver,jdbcURL);

            historyDAO  = new HistoryDAO("history", pool);
            flickDAO = new FlickrDAO();
            twitterPlusDAO = new TwitterPlusDAO();

            /* for testing
            ArrayList<String> hs = new ArrayList<String>();
            hs.add("pittsburgh");
            
            historyDAO.addHistory("this is a post", "the imitation game", "Post");
            historyDAO.addHistory("", "the imitation game", "Like");
            historyDAO.getNumPerDay("the imitation game", "Post");
            historyDAO.getWordsByTag("the imitation game");
            historyDAO.getPopMovieCount("the imitation game");

            //flickDAO.getImgUrls(hs);
            */

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }	

    public FlickrDAO getFlickrDAO() { return flickDAO;}      
    public TwitterPlusDAO getTwitterPlusDAO() { return twitterPlusDAO;}
    public HistoryDAO getHistoryDAO() { return historyDAO;}      

}
