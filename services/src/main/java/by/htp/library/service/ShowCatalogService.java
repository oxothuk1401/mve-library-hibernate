package by.htp.library.service;

import java.util.List;
import by.htp.library.dao.Factory;
import by.htp.library.dao.SQLCommandDAO;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.Book;

public final class ShowCatalogService {

    public final static List<Book> showBooks(String showusers) throws DAOException {
        Factory factory = Factory.getInstance();
        SQLCommandDAO sqlCommandDAO = factory.getSqlCommandDAO();
        return sqlCommandDAO.getBooks();
    }
}
