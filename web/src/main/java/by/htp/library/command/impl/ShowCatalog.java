package by.htp.library.command.impl;

import by.htp.library.command.Command;
import by.htp.library.controller.PageName;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.Book;
import by.htp.library.service.ShowCatalogService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowCatalog implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response){
		String page = null;
		List<Book> list = null;
		try {
			list = ShowCatalogService.showBooks();
		} catch (DAOException e) {
			e.getMessage();
		}
		request.setAttribute("bookbean", list);
		return PageName.SHOW_CATALOG;
	}
}
