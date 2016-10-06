package by.htp.library.dao;

import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oxothuk1401 on 07.10.2016.
 */
public class DBBookOperationDAO extends OperationDAO implements BookOperationDAO {
    @Override
    public List<Book> checkSearch(String searching) throws DAOException {
        return null;
    }

    @Override
    public List<Book> getBook() throws DAOException {
        List<Book> listBooks = null;
        System.out.println("DAOFACTORY");
        Factory factory = Factory.getInstance();
        DBBookOperationDAO dbBookOperationDAO = (DBBookOperationDAO) factory.getBookOperationDAO();

        listBooks.add((Book) dbBookOperationDAO.getBook());
        return listBooks;
    }

}
