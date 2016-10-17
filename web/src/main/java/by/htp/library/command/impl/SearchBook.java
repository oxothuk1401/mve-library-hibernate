package by.htp.library.command.impl;

import by.htp.library.command.Command;
import by.htp.library.controller.PageName;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.Book;
import by.htp.library.service.SearchService;
import by.htp.library.service.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class SearchBook implements Command {
    private static final String SEARCHING = "searching";
    private static final String COMMAND = "command";
    private static final String SORTED = "sorted";
    private static Logger log = Logger.getLogger(Login.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = PageName.ERROR_PAGE;
        HttpSession session = request.getSession();
        List<Book> list = null;
        String errorMessage = null;
        try {
            list = SearchService.checkSearch(request.getParameter(SEARCHING), request.getParameter(COMMAND), request.getParameter(SORTED));
            if (list != null){
                request.setAttribute("bookbean", list);
                if(session.getAttribute("role").toString().equals("admin")) {
                    page = PageName.ADMIN_PAGE;
                }else{
                    page = PageName.USER_PAGE;
                }
            }
        } catch (ServiceException e) {
            switch (session.getAttribute("local").toString()) {
//                case "ru": errorMessage = "Ничего не введено"; break;
                case "en": errorMessage = "Do not enter anything."; break;
                case "ru": errorMessage = "Ничего не введено."; break;
            }
            switch (session.getAttribute("role").toString()) {
                case "admin":  page = PageName.ADMIN_PAGE; break;
                case "user": page = PageName.USER_PAGE; break;
            }
        } catch (DAOException e) {
            switch (session.getAttribute("local").toString()) {
                case "ru": errorMessage = "Книга не найдена"; break;
                case "en": errorMessage = "Book not found"; break;
            }
            switch (session.getAttribute("role").toString()) {
                case "admin": page = PageName.ADMIN_PAGE; break;
                case "user": page = PageName.USER_PAGE; break;
            }
        }
        request.setAttribute("errorMessage", errorMessage);
        request.setAttribute("bookbean", list);
        return page;
    }
}


//    @Override
//    public String execute(HttpServletRequest request, HttpServletResponse response) {
//        HttpSession ses = request.getSession(true);
//        String page = null;
//        List<Book> searchBook = null;
//        TreeSet<String> set = null;
//        JspSet jsp = null;
//        String errorMessage = null;
//        try {
//            searchBook = SearchService.checkSearch(request.getParameter(SEARCHING));
//            if (searchBook != null) {
//                set = new TreeSet<>();
//                for (int i = 0; i < searchBook.size(); i++) {
//                    set.add(searchBook.get(i).getTitle() + "  " + searchBook.get(i).getAuthor() + "  " + searchBook.get(i).getAccess());
//                }
//                jsp = new JspSet(set);
//                request.setAttribute("userbean", jsp);
//                page = PageName.SEARCH_BOOK;
//            }