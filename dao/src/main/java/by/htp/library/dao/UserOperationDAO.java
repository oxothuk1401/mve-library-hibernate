package by.htp.library.dao;

import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;
import org.omg.CORBA.Object;

import java.util.List;

/**
 * Created by oxothuk1401 on 07.10.2016.
 */
public interface UserOperationDAO<T> {

    User checkLogin(String login, String password) throws DAOException;

    boolean checkRegister(String number, String password) throws DAOException;

    T delete(T t);

    Object get(int id);

    List<Object> getAll();
}
