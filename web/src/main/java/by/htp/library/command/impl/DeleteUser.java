package by.htp.library.command.impl;

import by.htp.library.command.Command;
import by.htp.library.controller.PageName;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;
import by.htp.library.service.UserServiceOperation;
import by.htp.library.service.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteUser implements Command {
	private static Logger log = Logger.getLogger(Login.class.getName());
	private static final String USER = "user";
	private static final String COMMAND = "command";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession ses = request.getSession(true);
		String page = PageName.ADMIN_PAGE;
		User user;
		String errorMessage=null;
		try {
			user = UserServiceOperation.userOperation(request.getParameter(USER),request.getParameter(COMMAND));
			if (user !=null) {
				switch (request.getSession(true).getAttribute("local").toString()) {
					case "ru": errorMessage = "Пользователь " + request.getParameter(USER).toString() + " удален успешно"; break;
					case "en": errorMessage = "User " + request.getParameter(USER).toString() + " is deleted successfully"; break;
				}
			}
		} catch (DAOException e) {
			switch (ses.getAttribute("local").toString()) {
				case "ru":	errorMessage = "Пользователь не найден";break;
				case "en":	errorMessage = " This user is not found";break;
			}
		} catch (ServiceException e) {
			switch (ses.getAttribute("local").toString()) {
				case "ru":	errorMessage = "Введите имя пользователя для удаления";break;
				case "en":	errorMessage = "Enter username to remove";break;
			}
		}
		request.setAttribute("errorMessage", errorMessage);
			return page;

	}

}
