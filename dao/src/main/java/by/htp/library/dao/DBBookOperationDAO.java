package by.htp.library.dao;

import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.Book;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.omg.CORBA.Object;

import java.util.List;

/**
 * Created by oxothuk1401 on 07.10.2016.
 */
public class DBBookOperationDAO extends OperationDAO implements BookOperationDAO  {
    @Override
    public List<Book> checkSearch(String searching) throws DAOException {

        return null;
    }

    @Override
    public List<Book> getBook() throws DAOException {
        Session session = HibernateUtil.openSession();
        Query query  = session.createQuery("from Book");
        List<Book> listBooks = (List<Book>) query.list();
        return listBooks;
    }

    @Override
    public Class getPersistentClass() {
        return Book.class;
    }
}
