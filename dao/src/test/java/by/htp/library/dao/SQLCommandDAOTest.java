package by.htp.library.dao;

import by.htp.library.dao.connectionpool.ConnectionPool;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by oxothuk1401 on 03.10.2016.
 */
public class SQLCommandDAOTest {
    ConnectionPool connectionPool = null;
    SQLCommandDAO sqlCommandDAO;
    @Before
    public void setUp() throws Exception {
        connectionPool = ConnectionPool.getInstance();
        connectionPool.initPoolData();
    }
    @Ignore
    @Test
    public void checkLogin() throws Exception {

    }
    @Ignore
    @Test
    public void checkRegister() throws Exception {

    }
    @Ignore
    @Test
    public void deleteUser() throws Exception {

    }
    @Ignore
    @Test
    public void getUsers() throws Exception {
        assertNotNull(sqlCommandDAO.getUsers());
    }
    @Ignore
    @Test
    public void getBooks() throws Exception {
        assertNotNull(sqlCommandDAO.getBooks());
    }
    @Ignore
    @Test
    public void checkSearch() throws Exception {
        assertNotNull(sqlCommandDAO.checkSearch(""));
    }

}