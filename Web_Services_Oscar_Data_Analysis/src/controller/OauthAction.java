package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;
import org.json.JSONObject;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;


//import formbean.LoginForm;
import model.Model;
import model.TwitterPlusDAO;

public class OauthAction extends Action {
	private TwitterPlusDAO twitterPlusDAO;

	public OauthAction(Model model) {
		twitterPlusDAO = model.getTwitterPlusDAO();

	}

	public String getName() {
		return "oauth.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		HttpSession session = request.getSession();
		try {
			String oauth_token = (String) request.getParameter("oauth_token");
			String oauth_verifier = (String) request.getParameter("oauth_verifier");
			JSONObject user = twitterPlusDAO.getTwitterAccessTokenFromAuthorizationCode(oauth_verifier, oauth_token);
			session.setAttribute("user", user);

			return "showHomePage.do";
		} catch (Exception e) {
			System.out.println(e);
			return "error.jsp";
		}
	}
}
