package by.htp.library.command.impl;

import by.htp.library.command.Command;
import by.htp.library.controller.PageName;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeLocal implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession ses = request.getSession(true);
		ses.setAttribute("local", request.getParameter("local"));
		if (ses.getAttribute("userPage") != null) {
			try {
				response.sendRedirect(ses.getAttribute("userPage").toString());
			} catch (IOException e) {
				System.out.println(e + "wrong url");
			}
		} else {
			try {
				request.getRequestDispatcher(PageName.INDEX_PAGE).forward(request, response);
			} catch (ServletException | IOException e) {
			}
		}
		return null;
	}

}
