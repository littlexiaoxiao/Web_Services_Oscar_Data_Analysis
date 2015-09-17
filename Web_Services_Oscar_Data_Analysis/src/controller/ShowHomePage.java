package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;
import org.json.JSONObject;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import model.Model;
import model.TwitterPlusDAO;

public class ShowHomePage extends Action {

    public ShowHomePage(Model model) {
    }
    public String getName() {    return "showHomePage.do";}

    public String perform(HttpServletRequest request) {
        List<String> movieList = new ArrayList<String>();
        movieList.add("American Sniper");
        movieList.add("The Imitation Game");
        movieList.add("Birdman");
        movieList.add("Boyhood");
        movieList.add("The Theory of Everything");
        movieList.add("The Grand Budapest Hotel");
        movieList.add("Whiplash");
        movieList.add("Foxcatcher");
        movieList.add("Interstellar");
        movieList.add("The Judge");
        String[] movieNameList = {"americansniper2014",
            "theimitationgame2014",
            "'birdman'2014",
            "boyhood2014",
            "thetheoryofeverything2014",
            "thegrandbudapesthotel",
            "whiplash",
            "foxcatcher2014",
            "interstellar2014",
            "thejudge2014"};
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        HttpSession session = request.getSession();
        try {
            session.setAttribute("movieList", movieList);
            session.setAttribute("movieNameList", movieNameList);
            JSONObject user = (JSONObject) session.getAttribute("user");
            session.setAttribute("user", user);
            return "homepage.jsp";
        } catch (Exception e) {
            System.out.println(e);
            return "error.jsp";
        }
    }
}
