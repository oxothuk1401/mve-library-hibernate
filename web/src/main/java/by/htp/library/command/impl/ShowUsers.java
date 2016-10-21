package by.htp.library.command.impl;

import by.htp.library.command.Command;
import by.htp.library.controller.PageName;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;
import by.htp.library.jsp_bean.JSPUserBean;
import by.htp.library.service.CountAllUsers;
import by.htp.library.service.ShowUsersService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by oxothuk1401 on 18.10.2016.
 */
public class ShowUsers implements Command {
    private String POSITION = "position";
    private String AMOUNT = "amount";
    private static Logger log = Logger.getLogger(Login.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession ses = request.getSession(true);
        String page = PageName.ERROR_PAGE;
        String errorMessage = null;
        int position = Integer.parseInt(request.getParameter(POSITION));
        int amount = Integer.parseInt(request.getParameter(AMOUNT));
        int countAllUsers = CountAllUsers.countAllUsers();
        List<User> listUsers = null;
        try {
            listUsers = ShowUsersService.showUsers(request.getParameter(POSITION), request.getParameter(AMOUNT));
            if (listUsers != null) {
                JSPUserBean jspUserBean = new JSPUserBean(listUsers, countAllUsers, amount, position);
                request.setAttribute("countAllUsers", countAllUsers);
                request.setAttribute("userbean", jspUserBean);
                return PageName.SHOW_USERS;
            }
        }catch (DAOException e){
            switch (ses.getAttribute("local").toString()) {
                case "en": errorMessage = "Error connection with Data Base";break;
                case "ru": errorMessage = "Ошибка соединения с базой данных";break;
            }
        }
        request.setAttribute("errorMessage", errorMessage);
        return page;
    }
}