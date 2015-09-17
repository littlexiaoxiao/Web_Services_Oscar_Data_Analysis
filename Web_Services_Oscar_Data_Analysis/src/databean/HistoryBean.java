package databean;
import org.genericdao.PrimaryKey;

import java.util.Date;

@PrimaryKey("hid")
public class HistoryBean{
    private int hid;
    private Date date;
    private String comment;
    private String hashtag;
    private String type;
    
    public int getHid()   {  return hid;}
    public Date getDate() {  return date;}
    public String getComment(){  return comment;}
    public String getHashtag(){  return hashtag;}
    public String getType(){  return type;}

    public void setHid(int i)   {  hid = i;}
    public void setDate(Date i) {  date = i;}
    public void setComment(String i){  comment = i;}
    public void setHashtag(String i){  hashtag = i;}
    public void setType(String i){ type = i;}
}
