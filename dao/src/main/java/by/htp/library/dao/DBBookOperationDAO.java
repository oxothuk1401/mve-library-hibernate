package by.htp.library.dao;

import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.Book;

import java.util.List;

/**
 * Created by oxothuk1401 on 07.10.2016.
 */
public class DBBookOperationDAO extends OperationDAO implements BookOperationDAO {
    @Override
    public List<Book> checkSearch(String searching) throws DAOException {
        return null;
    }
}
