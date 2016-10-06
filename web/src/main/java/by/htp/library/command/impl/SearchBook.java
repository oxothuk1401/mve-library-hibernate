//package by.htp.library.command.impl;
//
//import by.htp.library.command.Command;
//import by.htp.library.controller.PageName;
//import by.htp.library.controller.jspTeg.JspSet;
//import by.htp.library.dao.exception.DAOException;
//import by.htp.library.entity.Book;
//import by.htp.library.service.SearchService;
//import by.htp.library.service.exception.ServiceException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.util.List;
//import java.util.TreeSet;
//
//public class SearchBook implements Command {
//    private static final String SEARCHING = "searching";
//
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
//                    set.add(searchBook.get(i).getTitle() + "  " + "  " + searchBook.get(i).getDate());
//                }
//                jsp = new JspSet(set);
//                request.setAttribute("userbean", jsp);
//                page = PageName.SEARCH_BOOK;
//            }
//
//        } catch (ServiceException e) {
//            switch (ses.getAttribute("local").toString()) {
//                case "ru": errorMessage = "Ничего не введено"; break;
//                case "en": errorMessage = "Do not enter anything."; break;
//            }
//            switch (ses.getAttribute("role").toString()) {
//                case "admin":  page = PageName.ADMIN_PAGE; break;
//                case "user": page = PageName.USER_PAGE; break;
//            }
//        } catch (DAOException e) {
//            switch (ses.getAttribute("local").toString()) {
//                case "ru": errorMessage = "Книга не найдена"; break;
//                case "en": errorMessage = "Book not found"; break;
//            }
//            switch (ses.getAttribute("role").toString()) {
//                case "admin": page = PageName.ADMIN_PAGE; break;
//                case "user": page = PageName.USER_PAGE; break;
//            }
//        }
//        request.setAttribute("errorMessage", errorMessage);
//        return page;
//    }
//}
