package by.htp.library.dao;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.SQLGrammarException;
import java.util.List;

/**
 * Created by oxothuk1401 on 07.10.2016.
 */

public class DBUserOperationDAO extends OperationDAO implements UserOperationDAO {
        private static Logger log = Logger.getLogger(DBUserOperationDAO.class.getName());

    public User checkLogin(String login, String password) throws DAOException {
        Session session = HibernateUtil.getSession();
        log.error("checkLogin sesion = " + session.hashCode());
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
    public boolean checkRegister(String login, String password) throws DAOException {
        Session session = HibernateUtil.getSession();
//        log.error("checkRegister sesion = " + session.hashCode());
        Criteria criteria = session.createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("login", login));
        if(criteria.uniqueResult() != null){
            throw new DAOException();
        }else{
            User user = new User();
            user.setLogin(login);
            user.setPassword(MD5.getMD5(password));
            user.setRole("user");
            user.setBlacklist("unblock");
            add(user);
            return true;
        }
    }

    @Override
    public boolean deleteUser(String userLogin) throws DAOException {

        Criteria criteria = HibernateUtil.getSession().createCriteria(getPersistentClass());
        try {
            User user = null;
            criteria.add(Restrictions.eq("login", userLogin));
            user = (User) criteria.uniqueResult();
            delete(user.getId());
            return true;
        } catch (SQLGrammarException e) {
            throw new DAOException();
        }
    }

    @Override
    public List getAll() throws DAOException {
        Session session = HibernateUtil.getSession();
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
