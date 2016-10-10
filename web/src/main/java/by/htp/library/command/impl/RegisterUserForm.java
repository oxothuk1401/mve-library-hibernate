package by.htp.library.command.impl;

import by.htp.library.command.Command;
import by.htp.library.controller.PageName;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.service.RegisterService;
import by.htp.library.service.exception.ServiceException;
import org.hibernate.TransactionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterUserForm implements Command {

	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response){
		HttpSession ses = request.getSession(true);
		String page = PageName.REGISTER_PAGE;
		String errorMessage = null;
		String str = null;
		try {
			boolean newUser = RegisterService.checkRegister(request.getParameter(LOGIN),
					request.getParameter(PASSWORD));
			if (newUser == true) {
				ses.setAttribute(LOGIN, newUser);
				ses.setAttribute("userPage", PageName.INDEX_PAGE);
				switch (ses.getAttribute("local").toString()) {
				case "ru": str = "Вы успешно зарегистрированы. Авторизуйтесь."; break;
				case "en": str = "You have successfully registered.Log in."; break;
				}
				request.setAttribute("message", str);
				page = (String) ses.getAttribute("userPage");
			}
		} catch (ServiceException e) {
			switch (ses.getAttribute("local").toString()) {
			case "ru": errorMessage = "Пожалуйста заполните все поля.";break;
			case "en": errorMessage = "Please complete all fields.";break;
			}
		} catch (DAOException e) {
			switch (ses.getAttribute("local").toString()) {
			case "ru": errorMessage = "Этот логин занят.";break;
			case "en": errorMessage = "This login is busy.";break;
			}
		} catch (TransactionException e) {
			switch (ses.getAttribute("local").toString()) {
//				!!!!!!!!!!!!!!!!!!!!!!!!!!
			case "ru": errorMessage = "Transaction error.";break;
			case "en": errorMessage = "Transaction error.";break;
			}
		}
		request.setAttribute("errorMessage", errorMessage);
		return page;
	}
}
