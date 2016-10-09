package by.htp.library.dao;

import by.htp.library.dao.connectionpool.ConnectionPool;
import by.htp.library.dao.connectionpool.exception.ConnectionPoolException;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by oxothuk1401 on 07.10.2016.
 */
public class DBUserOperationDAO extends OperationDAO implements UserOperationDAO {
    private final static Logger LOG = LogManager.getLogger("by.htp.library.listners");
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
    public List getAll() {
        Session session = HibernateUtil.openSession();
        Query query  = session.createQuery("from User");
        List<User> listUsers = (List<User>) query.list();
        return listUsers;
    }

    @Override
    public Class getPersistentClass() {
        return User.class;
    }
}
