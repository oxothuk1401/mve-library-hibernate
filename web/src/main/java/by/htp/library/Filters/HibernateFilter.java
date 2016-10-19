package by.htp.library.Filters;


import by.htp.library.command.impl.Login;
import by.htp.library.dao.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by oxothuk1401 on 15.10.2016.
 */
public class HibernateFilter implements Filter {
    private static Logger log = Logger.getLogger(Login.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        Session session = HibernateUtil.getSession();
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        HibernateUtil.releaseSession(session);
    }

    @Override
    public void destroy() {

    }
}
