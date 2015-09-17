package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;
import databean.*;

public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void init() throws ServletException {
        Model model = new Model(getServletConfig());

        Action.add(new LoginAction(model)); // TODO: Modify to login by Twitter.
        Action.add(new OauthAction(model));
        Action.add(new ShowHomePage(model));
        Action.add(new MovieListAction(model));
        Action.add(new GetTweetAction(model));
        Action.add(new PostTweetAction(model));
        Action.add(new ReplyTweetAction(model));
        Action.add(new FavoriteTweetAction(model));
        Action.add(new AnalyzeTrendAction(model));
        Action.add(new LogoutAction());

        /*
         * TODO: 1. Get the list of movies. 2. Show the info of one movie. 3.
         * Data analysis for all movies. 4. Data analysis for one movie.
         */
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String nextPage = performTheAction(request);
        sendToNextPage(nextPage, request, response);
    }

    /*
     * Extracts the requested action and (depending on whether the user is
     * logged in) perform it (or make the user login).
     * 
     * @param request
     * 
     * @return the next page (the view)
     */
    private String performTheAction(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        String action = getActionName(servletPath);
        HttpSession session = request.getSession(true);

        System.out.println("In performTheAction: " + action);

        if (action.equals("login.do")) {
            return Action.perform(action, request);
        }

        /*
         * if (customer == null && employee == null) { return "index.jsp"; }
         */

        // Let the logged in user run his chosen action
        return Action.perform(action, request);
    }

    private void sendToNextPage(String nextPage, HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        System.out.println("In sendToNextPage: " + nextPage);
        if (nextPage == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND,
                    request.getServletPath());
            return;
        }

        if (nextPage.endsWith(".do")) {
            response.sendRedirect(nextPage);
            return;
        }

        if (nextPage.endsWith(".jsp")) {
            RequestDispatcher d = request.getRequestDispatcher(nextPage);
            d.forward(request, response);
            return;
        }

        if (nextPage.startsWith("http://") || nextPage.startsWith("https://")) {
            response.sendRedirect(nextPage);
            return;
        }

        // For *.html.
        RequestDispatcher d = request.getRequestDispatcher(nextPage);
        d.forward(request, response);

        return;

    }

    /*
     * Returns the path component after the last slash removing any "extension"
     * if present.
     */
    private String getActionName(String path) {
        // We're guaranteed that the path will start with a slash
        int slash = path.lastIndexOf('/');
        return path.substring(slash + 1);
    }
}
