package by.htp.library.dao;

import org.hibernate.Session;
import org.omg.CORBA.Object;

import java.io.Serializable;
import java.util.List;

/**
 * Created by oxothuk1401 on 06.10.2016.
 */
public abstract class OperationDAO<T> {
    Session session = HibernateUtil.openSession();

    public T add(T t){
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return t;
    }
    public T delete(T t){
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return t;
    }
    public Object get(int id){
        Object obj = null;
        obj = (Object) session.load(Object.class, id);
        if (session.isOpen()) {
            session.close();
        }
        return obj;
    }
    public List<Object> getAll(){
        List<Object> obj = null;
        obj = session.createCriteria(Object.class).list();
        if (session.isOpen()) {
            session.close();
        }
        return obj;
    }

}
