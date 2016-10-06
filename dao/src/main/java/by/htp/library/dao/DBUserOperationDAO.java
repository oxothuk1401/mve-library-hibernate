package by.htp.library.dao;

import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;

/**
 * Created by oxothuk1401 on 07.10.2016.
 */
public class DBUserOperationDAO extends OperationDAO implements UserOperationDAO {
    @Override
    public User checkLogin(String login, String password) throws DAOException {
        User user = null;
        return user;
    }

    @Override
    public boolean checkRegister(String number, String password) throws DAOException {
        return false;
    }
}
