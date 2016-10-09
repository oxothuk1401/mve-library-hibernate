package by.htp.library.dao;

import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.Book;


import java.util.List;

/**
 * Created by oxothuk1401 on 07.10.2016.
 */
public interface BookOperationDAO<T> {

//    List<Book> checkSearch(String searching) throws DAOException;


    T add(T t);

    T delete(T t);

    T update(T t);

    T get(long id);

    List<T> getAll() throws DAOException;

}
