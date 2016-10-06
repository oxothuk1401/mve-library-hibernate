package by.htp.library.dao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oxothuk1401 on 03.10.2016.
 */
public class FactoryTest {


    Factory factory;
    SQLCommandDAO sqlCommandDAO;

    @Before
    public void setUp() throws Exception {
        factory = Factory.getInstance();
        sqlCommandDAO = new SQLCommandDAO();
    }
    @Test
    public void getInstance1() throws Exception {
        assertNotNull(Factory.getInstance());
    }
    @Test
    public void getSqlCommandDAO() throws Exception {
        assertEquals(sqlCommandDAO.getClass(), factory.getSqlCommandDAO().getClass());
    }
}