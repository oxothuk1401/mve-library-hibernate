package by.htp.library.dao;

import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.Book;
import org.hibernate.Query;
import org.hibernate.Session;
import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oxothuk1401 on 07.10.2016.
 */
public class DBBookOperationDAO implements BookOperationDAO {
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
    public java.lang.Object add(java.lang.Object o) {
        return null;
    }

    @Override
    public java.lang.Object delete(java.lang.Object o) {
        return null;
    }

    @Override
    public Object get(int id) {
        return null;
    }

    @Override
    public List<Object> getAll() {
        return null;
    }

}
