package by.htp.library.dao;

import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.Book;

import java.util.List;

public class Factory {
    private static final Factory instance = new Factory();

    private BookOperationDAO bookOperationDAO = new DBBookOperationDAO();
    private UserOperationDAO userOperationDAO = new DBUserOperationDAO();
    private AuthorOperationDAO authorOperationDAO = new DBAuthorOperationDAO();

    private Factory() {
    }

    public static Factory getInstance() {
        return instance;
    }

    public BookOperationDAO getBookOperationDAO() { return bookOperationDAO; }

    public UserOperationDAO getUserOperationDAO() {
        return userOperationDAO;
    }

    public AuthorOperationDAO getAuthorOperationDAO() {
        return authorOperationDAO;
    }
}
