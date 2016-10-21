package by.htp.library.command.impl;

import by.htp.library.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by oxothuk1401 on 28.09.2016.
 */
public class ReturnPage implements Command{
    private final static String PREVIOUS_PAGE = "previousPage";
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        try {
            response.sendRedirect((String) request.getSession().getAttribute(PREVIOUS_PAGE));
//            response.sendRedirect("Controller?command=login&login=admin&password=admin");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
//        return request.getSession(true).getAttribute(PREVIOUS_PAGE).toString();
    }
}
