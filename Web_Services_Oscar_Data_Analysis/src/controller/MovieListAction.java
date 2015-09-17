package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Model;

public class MovieListAction extends Action {

    public MovieListAction(Model model) {
    }
    public String getName() {    return "movieList.do";}

    public String perform(HttpServletRequest request) {
    	
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);

        return "movie-list.jsp";

    }
}
