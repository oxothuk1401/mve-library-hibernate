package by.htp.library.command.impl;

import by.htp.library.command.Command;
import by.htp.library.controller.PageName;
import by.htp.library.controller.jspTeg.JspSet;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.service.ShowUsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ShowUsers implements Command {
	private static final String SHOWUSERS = "showusers";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		List<String> list = new ArrayList<>();
		String page = null;
		TreeSet<String> set = null;
		JspSet jsp = null;
		try {
			list = ShowUsersService.showUsers(request.getParameter(SHOWUSERS));
		} catch (DAOException e) {
			e.getMessage();
		}
		if (list != null) {
			set = new TreeSet<>();
			for (int i = 0; i < list.size(); i++) {
				set.add(list.get(i));
			}
			jsp = new JspSet(set);
			request.setAttribute("userbean", jsp);
			return page = PageName.SHOW_USERS;
		}

		return page;
	}
}
