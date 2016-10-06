package by.htp.library.dao;

import by.htp.library.dao.connectionpool.ConnectionPool;
import by.htp.library.dao.connectionpool.exception.ConnectionPoolException;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 * Created by oxothuk1401 on 07.10.2016.
 */
public class DBUserOperationDAO extends OperationDAO implements UserOperationDAO {
    private final static String CHECK_LOGIN = "SELECT * FROM Users";
    ConnectionPool connectionPool = ConnectionPool.getInstance();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @Override
    public User checkLogin(String login, String password) throws DAOException {
        User user = null;
        try {
            connection = connectionPool.takeConnection();
            try {
                preparedStatement = connection.prepareStatement(CHECK_LOGIN);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
//                    if (login.equals(resultSet.getString(2)) && password.equals(resultSet.getString(3))) {
                    if (login.equals(resultSet.getString(2)) && MD5.getMD5(password).equals(resultSet.getString(3))) {
                        user = new User();
                        user.setId(resultSet.getInt(1));
                        user.setLogin(resultSet.getString(2));
                        user.setPassword(resultSet.getString(3));
                        user.setRole(resultSet.getString(4));
                        break;
                    }
                }
                if (user == null) {
                    throw new DAOException();
                }
                connection.close();
            } catch (SQLException e) {
                throw new DAOException("Error accessing database");
            }
        } catch (ConnectionPoolException e) {
            throw new DAOException("Has reached the maximum number of connections", e);
        }

        return user;
    }

    @Override
    public boolean checkRegister(String number, String password) throws DAOException {
        return false;
    }


}
