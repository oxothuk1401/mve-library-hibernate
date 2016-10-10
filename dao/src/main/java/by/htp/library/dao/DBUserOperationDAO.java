package by.htp.library.dao;

import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by oxothuk1401 on 07.10.2016.
 */
public class DBUserOperationDAO extends OperationDAO implements UserOperationDAO {
   

    public User checkLogin(String login, String password) throws DAOException {
        Session session = HibernateUtil.openSession();
        Criteria criteria = session.createCriteria(getPersistentClass());
        User user = null;
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
    public String delete(String userDel) {
        User user = null;
        Session session = HibernateUtil.openSession();
        Criteria criteria = session.createCriteria(getPersistentClass());
        if(criteria.add(Restrictions.eq("login", userDel)).equals(true)) {
            return user.getLogin();
        }
        return null;
    }

    @Override
    public List getAll() throws DAOException {
            Session session = HibernateUtil.openSession();
        try {
            Query query = session.createQuery("from User");
            List<User> listUsers = (List<User>) query.list();
            session.close();
            if (listUsers == null) {
                throw new DAOException("List of users is empty");
            }
            return listUsers;
        } catch (Exception e) {
            throw new DAOException("Error accessing database");
        }
    }

    @Override
    public Class getPersistentClass() {
        return User.class;
    }
}
