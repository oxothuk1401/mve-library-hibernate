package by.htp.library.service;

import by.htp.library.dao.BookOperationDAO;
import by.htp.library.dao.Factory;
import by.htp.library.dao.HibernateUtil;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

import java.util.List;

public class SearchService {

    public final static List<Book> checkSearch(String searching, String command, String sorted) throws DAOException {
        List result = null;
        Factory factory = Factory.getInstance();
        BookOperationDAO bookOperationDAO = factory.getBookOperationDAO();
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            result = bookOperationDAO.checkSearch(searching, command, sorted);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new TransactionException("");
        }
        return result;
    }
}


