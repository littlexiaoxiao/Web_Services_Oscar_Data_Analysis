package databean;

import java.util.List;

public class SearchFlikrBean{
    private Photos photos;
    private String stat;

    public Photos getPhotos(){
        return this.photos;
    }
    public void setPhotos(Photos photos){
        this.photos = photos;
    }
    public String getStat(){
        return this.stat;
    }
    public void setStat(String stat){
        this.stat = stat;
    }

    public static class Photos{
        private Number page;
        private Number pages;
        private Number perpage;
        private List photo;
        private String total;

        public Number getPage(){
            return this.page;
        }
        public void setPage(Number page){
            this.page = page;
        }
        public Number getPages(){
            return this.pages;
        }
        public void setPages(Number pages){
            this.pages = pages;
        }
        public Number getPerpage(){
            return this.perpage;
        }
        public void setPerpage(Number perpage){
            this.perpage = perpage;
        }
        public List getPhoto(){
            return this.photo;
        }
        public void setPhoto(List photo){
            this.photo = photo;
        }
        public String getTotal(){
            return this.total;
        }
        public void setTotal(String total){
            this.total = total;
        }
    }

    public static class Photo{
        private Number farm;
        private String id;
        private Number isfamily;
        private Number isfriend;
        private Number ispublic;
        private String owner;
        private String secret;
        private String server;
        private String title;

        public Number getFarm(){
            return this.farm;
        }
        public void setFarm(Number farm){
            this.farm = farm;
        }
        public String getId(){
            return this.id;
        }
        public void setId(String id){
            this.id = id;
        }
        public Number getIsfamily(){
            return this.isfamily;
        }
        public void setIsfamily(Number isfamily){
            this.isfamily = isfamily;
        }
        public Number getIsfriend(){
            return this.isfriend;
        }
        public void setIsfriend(Number isfriend){
            this.isfriend = isfriend;
        }
        public Number getIspublic(){
            return this.ispublic;
        }
        public void setIspublic(Number ispublic){
            this.ispublic = ispublic;
        }
        public String getOwner(){
            return this.owner;
        }
        public void setOwner(String owner){
            this.owner = owner;
        }
        public String getSecret(){
            return this.secret;
        }
        public void setSecret(String secret){
            this.secret = secret;
        }
        public String getServer(){
            return this.server;
        }
        public void setServer(String server){
            this.server = server;
        }
        public String getTitle(){
            return this.title;
        }
        public void setTitle(String title){
            this.title = title;
        }
    }

}
