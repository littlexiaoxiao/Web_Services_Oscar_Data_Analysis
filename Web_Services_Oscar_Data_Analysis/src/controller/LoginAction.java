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

public class LoginAction extends Action {
	private TwitterPlusDAO twitterPlusDAO;

	public LoginAction(Model model) {
		twitterPlusDAO = model.getTwitterPlusDAO();

	}

	public String getName() {
		return "login.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		try {
			JSONObject obj = twitterPlusDAO.startTwitterAuthentication();
			String targetURL = "https://api.twitter.com/oauth/authorize?oauth_token=";
			String oauth_token = (String) obj.get("oauth_token");
			targetURL += oauth_token;
			System.out.println(targetURL);

			return targetURL;
		} catch (Exception e) {
			System.out.println(e);
			return "error.jsp";
		}
	}
}
