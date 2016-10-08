package by.htp.library.dao;

import org.omg.CORBA.Object;

import java.util.List;

/**
 * Created by oxothuk1401 on 07.10.2016.
 */
public interface AuthorOperationDAO<T> {

    T add(T t);

    T delete(T t);



}
