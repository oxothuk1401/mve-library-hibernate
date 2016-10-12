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

    boolean checkRegister(String login, String password) throws DAOException;

    boolean deleteUser(String user) throws DAOException;







    List<T> getAll() throws DAOException;

}
