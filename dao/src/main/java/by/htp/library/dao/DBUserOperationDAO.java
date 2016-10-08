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
    public User checkLogin(String login, String password) throws DAOException {
        User user = null;
        Session session = HibernateUtil.openSession();
        Criteria criteria = session.createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("login", login));
        criteria.add(Restrictions.eq("password", MD5.getMD5(password)));
        user = (User) criteria.uniqueResult();
        if (user == null) {
            throw new DAOException();
        }
        return user;
    }

    @Override
    public boolean checkRegister(String number, String password) throws DAOException {
        return false;
    }

    @Override
    public Class getPersistentClass() {
        return User.class;
    }
}
