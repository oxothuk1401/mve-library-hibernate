package by.htp.library.dao;

import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.Book;
import org.omg.CORBA.Object;

import java.util.List;

/**
 * Created by oxothuk1401 on 07.10.2016.
 */
public interface BookOperationDAO<T> {

    List<Book> checkSearch(String searching) throws DAOException;

    List<Book> getBook() throws DAOException;

    T add(T t);

    T delete(T t);

    Object get(int id);

    List<Object> getAll();
}
