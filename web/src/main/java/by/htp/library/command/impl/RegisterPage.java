package by.htp.library.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.library.command.Command;
import by.htp.library.controller.PageName;

public class RegisterPage implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession ses = request.getSession(true);
		ses.setAttribute("userPage", "index.jsp");
		return PageName.REGISTER_PAGE;
	}
}