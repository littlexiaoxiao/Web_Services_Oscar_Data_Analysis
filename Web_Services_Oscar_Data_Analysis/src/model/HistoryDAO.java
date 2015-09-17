package model;

import java.util.Date;
import java.util.Vector;
import java.util.HashMap;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import databean.HistoryBean;

public class HistoryDAO extends GenericDAO<HistoryBean> {
    private IOModel ioModel;
    public HistoryDAO(String tableName, ConnectionPool pool) throws DAOException {
        super(HistoryBean.class, tableName, pool);
        ioModel = new IOModel();
    }


    //------------Write operations---------
    // Add record of posting a tweet, default time is current.
    public void addHistory( String comment, String hashtag, String type ) throws RollbackException{
        HistoryBean hb = new HistoryBean();
        hb.setComment(comment);
        hb.setHashtag(hashtag.toLowerCase());
        hb.setType(type);
        hb.setDate(new Date());
        create(hb);
    }

    //------------Read operations---------
    //TODO: not done yet.
    public HistoryBean[] getNumPerDay( String hashtag, String type ) throws RollbackException{
        HistoryBean[] hbs = match(
                MatchArg.and(
                    MatchArg.equals("hashtag", hashtag),
                    MatchArg.equals("type",  type)));

        System.err.printf("in get numper day, hbs.len = %d\n", hbs.length);
        return hbs;
    }

    public HashMap<String, Integer> getWordsByTag( String hashtag ) throws RollbackException{
        String type = "Post";
        HistoryBean[] hbs = match(
                MatchArg.and(
                    MatchArg.equals("hashtag", hashtag.toLowerCase()),
                    MatchArg.equals("type",  type)));

        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        int fcount;
        Vector<String> tokens = null;
        for( int i = 0; i < hbs.length; i ++){
            System.err.printf("i = %d, comment = %s\n", i, hbs[i].getComment());
            tokens = ioModel.tokenizeComment(hbs[i].getComment());
            for(String token : tokens){
                fcount = hash.containsKey(token)? hash.get(token):0;
                hash.put(token, fcount+1);
            }
        }
        System.err.printf("in get numper day, hbs.len = %d\n", hbs.length);
        printHash(hash);
        return hash;
    }
    private void printHash(HashMap<String, Integer> hash){
        System.err.printf("In print hash\n");

        for(String key : hash.keySet()){
            System.err.printf("key=%s, v= %d\n", key, hash.get(key));
        }
    }

    public  HashMap<Date, HashMap<String, Integer>> GetPopMovieCount(String keyword) throws RollbackException {
        HashMap<Date, HashMap<String, Integer>> postCounts = new HashMap<Date, HashMap<String, Integer>>();
        //		  String query = "select hashtag, date from history where hashtag =" +keyword+" ORDER BY date";
        //		    //how to select the last 7 days?
        //		    HistoryBean[] historyData =  executeQuery(query);	
        HistoryBean[] historyData = getNumPerDay( "keyword", "post" );
        for (int i = 0; i < historyData.length; i++) {
            if (!postCounts.containsKey(historyData[i].getDate())) {
                HashMap<String, Integer> dayClicks = new HashMap<String, Integer>();
                postCounts.put(historyData[i].getDate(), dayClicks);
            }

            if(postCounts.get(historyData[i].getDate()).containsKey(historyData[i].getDate())) {
                postCounts.get(historyData[i].getDate()).put(historyData[i].getHashtag(),
                        postCounts.get(historyData[i].getDate()).get(historyData[i].getHashtag()) + 1); 
            }else {
                postCounts.get(historyData[i].getDate()).put(historyData[i].getHashtag(), 1);
            }
        }			
        return postCounts;
    } 	  

    //---------------------------added by r44 FEB 15TH :search for get count of this week------------------
    public int[] getPopMovieCount(String hashtag) throws Exception{
        String type = "Post";
        int count[] = new int[7];
        HistoryBean[] hbs = match(
                MatchArg.and(
                    MatchArg.equals("hashtag", hashtag),
                    MatchArg.equals("type",  type)));

        Date newerDate = new Date();
        for(int i = 0; i < hbs.length; ++i){


        	Date olderDate = hbs[i].getDate();
            System.out.println(newerDate + " - " + olderDate );
            int diffInDays = (int)( (newerDate.getTime() - olderDate.getTime()) / (1000 * 60 * 60 * 24) );
//            System.out.printf("i=%d, d=%d\n", i, diffInDays);
            if(diffInDays >= 0 && diffInDays < 7)
                count[diffInDays] += 1;
        }
        return count;
    }

}
