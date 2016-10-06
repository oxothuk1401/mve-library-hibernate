package by.htp.library.service;

import java.util.List;

import by.htp.library.dao.BookOperationDAO;
import by.htp.library.dao.DBBookOperationDAO;
import by.htp.library.dao.Factory;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.Book;

public final class ShowCatalogService {

    public final static List<Book> showBooks(String showusers) throws DAOException {
        System.out.println("hi");
        Factory factory = Factory.getInstance();
        BookOperationDAO bookOperationDAO = factory.getBookOperationDAO();
        List<Book> listBooks = bookOperationDAO.getBook();

        return listBooks;
    }
}
