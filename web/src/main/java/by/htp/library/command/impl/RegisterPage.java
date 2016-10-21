package by.htp.library.command.impl;

import by.htp.library.command.Command;
import by.htp.library.controller.PageName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterPage implements Command {
	private final static String PREVIOUS_PAGE = "previousPage";
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		request.getSession(true).setAttribute(PREVIOUS_PAGE, PageName.INDEX_PAGE);
		return PageName.REGISTER_PAGE;
	}
}