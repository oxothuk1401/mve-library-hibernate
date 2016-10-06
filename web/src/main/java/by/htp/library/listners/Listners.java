package by.htp.library.listners;

import by.htp.library.dao.connectionpool.ConnectionPool;
import by.htp.library.dao.connectionpool.exception.ConnectionPoolException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listners implements ServletContextListener {
	private ConnectionPool connectionPool = ConnectionPool.getInstance();
	private final static Logger LOG = LogManager.getLogger("by.htp.library.listners");

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		StringBuilder sb = new StringBuilder();
		sb.append("Message: ");
		sb.append("<");
		sb.append("Connection close");
		sb.append(">  ");
		sb.append("Date: ");
		sb.append("<");
		sb.append(new java.util.Date());
		sb.append(">  ");
		sb.append("Class: ");
		sb.append("<");
		sb.append(Listners.class.toString());
		sb.append(">\t");
		LOG.info(sb.toString());
		connectionPool.dispose();

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		StringBuilder sb = new StringBuilder();
		try {
			connectionPool.initPoolData();
			sb.append("Message: ");
			sb.append("<");
			sb.append("Init Pool Data loaded");
			sb.append(">  ");
			sb.append("Date: ");
			sb.append("<");
			sb.append(new java.util.Date());
			sb.append(">  ");
			sb.append("Class: ");
			sb.append("<");
			sb.append(Listners.class.toString());
			sb.append(">\t");
			LOG.info(sb.toString());
		} catch (ConnectionPoolException e) {
			sb.append("Message: ");
			sb.append("<");
			sb.append("Cnnection Pool Exception");
			sb.append(">  ");
			sb.append("Date: ");
			sb.append("<");
			sb.append(new java.util.Date());
			sb.append(">  ");
			sb.append("Class: ");
			sb.append("<");
			sb.append(Listners.class.toString());
			sb.append(">\t");
			LOG.info(sb.toString());
		}
	}
}
