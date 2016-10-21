package by.htp.library.dao;

import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.Book;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by oxothuk1401 on 07.10.2016.
 */
public class DBBookOperationDAO extends OperationDAO implements BookOperationDAO {
    private static Logger log = Logger.getLogger(DBUserOperationDAO.class.getName());

    @Override
    public List getAll() throws DAOException {
        try {
            Session session = HibernateUtil.getSession();
            Query query = session.createQuery("from Book");
            List<Book> listBooks = (List<Book>) query.list();
            if (listBooks == null) {
                throw new DAOException("List of books is empty");
            }
            return listBooks;
        } catch (DAOException e) {
            throw new DAOException("Error accessing database");
        }
    }

    @Override
    public List<Book> checkSearch(String searching, String command, String sorted) throws DAOException {
        try {
            List<Book> resault = null;
            Session session = HibernateUtil.getSession();
            Criteria criteria = session.createCriteria(getPersistentClass());
            criteria.add(Restrictions.like(command, searching, MatchMode.ANYWHERE));
//            criteria.add(Restrictions.like(command, searching + "%"));
            criteria.addOrder(Order.asc(sorted));
            resault = criteria.list();
            if (resault == null) {
                throw new DAOException();
            }
            return resault;
        } catch (DAOException e) {
            throw new DAOException("Error accessing database");
        }
    }


    @Override
    public Class getPersistentClass() {
        return Book.class;
    }
}
