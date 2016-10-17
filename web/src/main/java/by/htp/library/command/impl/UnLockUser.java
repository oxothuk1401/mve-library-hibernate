package by.htp.library.command.impl;

import by.htp.library.command.Command;
import by.htp.library.controller.PageName;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;
import by.htp.library.service.UserServiceOperation;
import by.htp.library.service.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by oxothuk1401 on 17.10.2016.
 */
public class UnLockUser implements Command {
    private static Logger log = Logger.getLogger(BlockUser.class.getName());
    private static final String USER = "user";
    private static final String COMMAND = "command";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession ses = request.getSession(true);
        String page = PageName.ADMIN_PAGE;
        User user;
        String errorMessage = null;
        try {
            user = UserServiceOperation.userOperation(request.getParameter(USER), request.getParameter(COMMAND));
            if (user != null) {
                switch (request.getSession(true).getAttribute("local").toString()) {
                    case "ru": errorMessage = "Пользователь " + request.getParameter(USER).toString() + " разблокирован успешно";  break;
                    case "en": errorMessage = "User " + request.getParameter(USER).toString() + " is unlock successfully"; break;
                }
            }
        } catch (DAOException e) {
            switch (ses.getAttribute("local").toString()) {
                case "ru":errorMessage = "Пользователь не найден"; break;
                case "en": errorMessage = " This user is not found"; break;
            }
        } catch (ServiceException e) {
            switch (ses.getAttribute("local").toString()) {
                case "ru": errorMessage = "Введите имя пользователя для разблокирования"; break;
                case "en": errorMessage = "Enter username to unlock"; break;
            }
        }
        request.setAttribute("errorMessage", errorMessage);
        return page;

    }

}