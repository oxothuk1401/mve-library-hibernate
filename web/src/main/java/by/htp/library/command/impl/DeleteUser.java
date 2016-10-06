//package by.htp.library.command.impl;
//
//import by.htp.library.command.Command;
//import by.htp.library.controller.PageName;
//import by.htp.library.dao.exception.DAOException;
//import by.htp.library.service.DeleteUserService;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class DeleteUser implements Command {
//	private static final String USER = "user";
//
//	@Override
//	public String execute(HttpServletRequest request, HttpServletResponse response) {
//		String page = PageName.ADMIN_PAGE;
//		boolean delete;
//		String errorMessage=null;
//		try {
//			delete = DeleteUserService.deliteUser(request.getParameter(USER));
//			if (delete == true) {
//				switch (request.getSession(true).getAttribute("local").toString()) {
//					case "ru": errorMessage = "Пользователь " + request.getParameter(USER).toString() + " удален успешно"; break;
//					case "en": errorMessage = "User " + request.getParameter(USER).toString() + " is deleted successfully"; break;
//				}
//			}
//		} catch (DAOException e) {
//			errorMessage = e.getMessage();
//		}
//		request.setAttribute("errorMessage", errorMessage);
//		return page;
//	}
//
//}
