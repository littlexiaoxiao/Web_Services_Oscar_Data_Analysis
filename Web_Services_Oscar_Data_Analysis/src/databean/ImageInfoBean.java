
package databean;

import java.util.List;

import databean.SearchFlikrBean.Photo;

public class ImageInfoBean{
    private Photo photo;
    private String stat;

    public Photo getPhoto(){
        return this.photo;
    }
    public void setPhoto(Photo photo){
        this.photo = photo;
    }
    public String getStat(){
        return this.stat;
    }
    public void setStat(String stat){
        this.stat = stat;
    }

    public static class Comments{
        private String _content;

        public String get_content(){
            return this._content;
        }
        public void set_content(String _content){
            this._content = _content;
        }
    }

    public static class Dates{
        private String lastupdate;
        private String posted;
        private String taken;
        private Number takengranularity;
        private String takenunknown;

        public String getLastupdate(){
            return this.lastupdate;
        }
        public void setLastupdate(String lastupdate){
            this.lastupdate = lastupdate;
        }
        public String getPosted(){
            return this.posted;
        }
        public void setPosted(String posted){
            this.posted = posted;
        }
        public String getTaken(){
            return this.taken;
        }
        public void setTaken(String taken){
            this.taken = taken;
        }
        public Number getTakengranularity(){
            return this.takengranularity;
        }
    }

    public static class Description{
        private String _content;

        public String get_content(){
            return this._content;
        }
        public void set_content(String _content){
            this._content = _content;
        }
    }

    public static class Editability{
        private Number canaddmeta;
        private Number cancomment;

        public Number getCanaddmeta(){
            return this.canaddmeta;
        }
        public void setCanaddmeta(Number canaddmeta){
            this.canaddmeta = canaddmeta;
        }
        public Number getCancomment(){
            return this.cancomment;
        }
        public void setCancomment(Number cancomment){
            this.cancomment = cancomment;
        }
    }

    public static class Notes{
        private List note;

        public List getNote(){
            return this.note;
        }
        public void setNote(List note){
            this.note = note;
        }
    }

    public static class Owner{
        private Number iconfarm;
        private String iconserver;
        private String location;
        private String nsid;
        private String path_alias;
        private String realname;
        private String username;

        public Number getIconfarm(){
            return this.iconfarm;
        }
        public void setIconfarm(Number iconfarm){
            this.iconfarm = iconfarm;
        }
        public String getIconserver(){
            return this.iconserver;
        }
        public void setIconserver(String iconserver){
            this.iconserver = iconserver;
        }
        public String getLocation(){
            return this.location;
        }
        public void setLocation(String location){
            this.location = location;
        }
        public String getNsid(){
            return this.nsid;
        }
        public void setNsid(String nsid){
            this.nsid = nsid;
        }
        public String getPath_alias(){
            return this.path_alias;
        }
        public void setPath_alias(String path_alias){
            this.path_alias = path_alias;
        }
        public String getRealname(){
            return this.realname;
        }
        public void setRealname(String realname){
            this.realname = realname;
        }
        public String getUsername(){
            return this.username;
        }
        public void setUsername(String username){
            this.username = username;
        }
    }

    public static class People{
        private Number haspeople;

        public Number getHaspeople(){
            return this.haspeople;
        }
        public void setHaspeople(Number haspeople){
            this.haspeople = haspeople;
        }
    }

    public static class Photo{
        private Comments comments;
        private Dates dates;
        private String dateuploaded;
        private Description description;
        private Editability editability;
        private Number farm;
        private String id;
        private Number isfavorite;
        private String license;
        private String media;
        private Notes notes;
        private Owner owner;
        private People people;
        private Publiceditability publiceditability;
        private Number rotation;
        private String safety_level;
        private String secret;
        private String server;
        private Tags tags;
        private Title title;
        private Urls urls;
        private Usage usage;
        private String views;
        private Visibility visibility;

        public Comments getComments(){
            return this.comments;
        }
        public void setComments(Comments comments){
            this.comments = comments;
        }
        public Dates getDates(){
            return this.dates;
        }
        public void setDates(Dates dates){
            this.dates = dates;
        }
        public String getDateuploaded(){
            return this.dateuploaded;
        }
        public void setDateuploaded(String dateuploaded){
            this.dateuploaded = dateuploaded;
        }
        public Description getDescription(){
            return this.description;
        }
        public void setDescription(Description description){
            this.description = description;
        }
        public Editability getEditability(){
            return this.editability;
        }
        public void setEditability(Editability editability){
            this.editability = editability;
        }
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
        public Number getIsfavorite(){
            return this.isfavorite;
        }
        public void setIsfavorite(Number isfavorite){
            this.isfavorite = isfavorite;
        }
        public String getLicense(){
            return this.license;
        }
        public void setLicense(String license){
            this.license = license;
        }
        public String getMedia(){
            return this.media;
        }
        public void setMedia(String media){
            this.media = media;
        }
        public Notes getNotes(){
            return this.notes;
        }
        public void setNotes(Notes notes){
            this.notes = notes;
        }
        public Owner getOwner(){
            return this.owner;
        }
        public void setOwner(Owner owner){
            this.owner = owner;
        }
        public People getPeople(){
            return this.people;
        }
        public void setPeople(People people){
            this.people = people;
        }
        public Publiceditability getPubliceditability(){
            return this.publiceditability;
        }
        public void setPubliceditability(Publiceditability publiceditability){
            this.publiceditability = publiceditability;
        }
        public Number getRotation(){
            return this.rotation;
        }
        public void setRotation(Number rotation){
            this.rotation = rotation;
        }
        public String getSafety_level(){
            return this.safety_level;
        }
        public void setSafety_level(String safety_level){
            this.safety_level = safety_level;
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
        public Tags getTags(){
            return this.tags;
        }
        public void setTags(Tags tags){
            this.tags = tags;
        }
        public Title getTitle(){
            return this.title;
        }
        public void setTitle(Title title){
            this.title = title;
        }
        public Urls getUrls(){
            return this.urls;
        }
        public void setUrls(Urls urls){
            this.urls = urls;
        }
        public Usage getUsage(){
            return this.usage;
        }
        public void setUsage(Usage usage){
            this.usage = usage;
        }
        public String getViews(){
            return this.views;
        }
        public void setViews(String views){
            this.views = views;
        }
        public Visibility getVisibility(){
            return this.visibility;
        }
        public void setVisibility(Visibility visibility){
            this.visibility = visibility;
        }
    }

    public static class Publiceditability{
        private Number canaddmeta;
        private Number cancomment;

        public Number getCanaddmeta(){
            return this.canaddmeta;
        }
        public void setCanaddmeta(Number canaddmeta){
            this.canaddmeta = canaddmeta;
        }
        public Number getCancomment(){
            return this.cancomment;
        }
        public void setCancomment(Number cancomment){
            this.cancomment = cancomment;
        }
    }

    public static class Tag{
        private String _content;
        private String author;
        private String authorname;
        private String id;
        private Number machine_tag;
        private String raw;

        public String get_content(){
            return this._content;
        }
        public void set_content(String _content){
            this._content = _content;
        }
        public String getAuthor(){
            return this.author;
        }
        public void setAuthor(String author){
            this.author = author;
        }
        public String getAuthorname(){
            return this.authorname;
        }
        public void setAuthorname(String authorname){
            this.authorname = authorname;
        }
        public String getId(){
            return this.id;
        }
        public void setId(String id){
            this.id = id;
        }
        public Number getMachine_tag(){
            return this.machine_tag;
        }
        public void setMachine_tag(Number machine_tag){
            this.machine_tag = machine_tag;
        }
        public String getRaw(){
            return this.raw;
        }
        public void setRaw(String raw){
            this.raw = raw;
        }
    }

    public static class Tags{
        private List tag;

        public List getTag(){
            return this.tag;
        }
        public void setTag(List tag){
            this.tag = tag;
        }
    }

    public static class Title{
        private String _content;

        public String get_content(){
            return this._content;
        }
        public void set_content(String _content){
            this._content = _content;
        }
    }

    public static class Url{
        private String _content;
        private String type;

        public String get_content(){
            return this._content;
        }
        public void set_content(String _content){
            this._content = _content;
        }
        public String getType(){
            return this.type;
        }
        public void setType(String type){
            this.type = type;
        }
    }

    public static class Urls{
        private List url;

        public List getUrl(){
            return this.url;
        }
        public void setUrl(List url){
            this.url = url;
        }
    }

    public static class Usage{
        private Number canblog;
        private Number candownload;
        private Number canprint;
        private Number canshare;

        public Number getCanblog(){
            return this.canblog;
        }
        public void setCanblog(Number canblog){
            this.canblog = canblog;
        }
        public Number getCandownload(){
            return this.candownload;
        }
        public void setCandownload(Number candownload){
            this.candownload = candownload;
        }
        public Number getCanprint(){
            return this.canprint;
        }
        public void setCanprint(Number canprint){
            this.canprint = canprint;
        }
        public Number getCanshare(){
            return this.canshare;
        }
        public void setCanshare(Number canshare){
            this.canshare = canshare;
        }
    }

    public static class Visibility{
        private Number isfamily;
        private Number isfriend;
        private Number ispublic;

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
    }
}
