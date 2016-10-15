package by.htp.library.command.impl;

import by.htp.library.command.Command;
import by.htp.library.controller.PageName;
import by.htp.library.dao.HibernateUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		String page = PageName.INDEX_PAGE;
		return page;
	}

}
