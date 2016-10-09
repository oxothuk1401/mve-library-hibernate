package by.htp.library.command.impl;

import by.htp.library.command.Command;
import by.htp.library.controller.PageName;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;
import by.htp.library.service.UserService;
import by.htp.library.service.exception.ServiceException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login implements Command {
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		StringBuilder sb = new StringBuilder();
		HttpSession ses = request.getSession(true);
		String page = PageName.INDEX_PAGE;
		User user = null;
		String url = null;
		String errorMessage = null;
		try {
			user = UserService.checkLogin(request.getParameter(LOGIN), request.getParameter(PASSWORD));
			switch (user.getRole()) {
			case "user":
				ses.setAttribute("login", user);
				ses.setAttribute("role", user.getRole());
				request.setAttribute("login", user.getLogin());
				sb.append("http://127.0.0.1:8080/Library/Controller?command=login&login=");
				sb.append(request.getParameter(LOGIN));
				sb.append("&password=");
				sb.append(request.getParameter(PASSWORD));
				url = sb.toString();
				ses.setAttribute("userPage", url);
				page = PageName.USER_PAGE;
				break;
			case "admin":
				ses.setAttribute("login", user);
				ses.setAttribute("role", user.getRole());
				request.setAttribute("login", user.getLogin());
				sb.append("http://127.0.0.1:8080/Library/Controller?command=login&login=");
				sb.append(request.getParameter(LOGIN));
				sb.append("&password=");
				sb.append(request.getParameter(PASSWORD));
				url = sb.toString();
				ses.setAttribute("userPage", url);
				page = PageName.ADMIN_PAGE;
				break;
			default:
				String NotUsers = "No such user found! Register now";
				request.setAttribute("NotUsers", NotUsers);
				break;
			}
		} catch (ServiceException e) {
			switch (ses.getAttribute("local").toString()) {
			case "ru": errorMessage = "\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd, \ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd \ufffd\ufffd\ufffd \ufffd\ufffd\ufffd\ufffd\ufffd \ufffd \ufffd\ufffd\ufffd\ufffd\ufffd\ufffd";break;
			case "en": errorMessage = "Please, enter your login and password";break;

			}
		} catch (DAOException e) {
			switch (ses.getAttribute("local").toString()) {
			case "ru": errorMessage = "\ufffd\ufffd\ufffd\ufffd\ufffd \ufffd\ufffd\ufffd \ufffd\ufffd\ufffd\ufffd\ufffd\ufffd \ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd \ufffd\ufffd \ufffd\ufffd\ufffd\ufffd\ufffd!";break;
			case "en": errorMessage = "Login or password entered is not correct!";break;
			}
		}
		request.setAttribute("errorMessage", errorMessage);
		return page;
	}
}
