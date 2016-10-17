package by.htp.library.command.impl;

import by.htp.library.command.Command;
import by.htp.library.controller.PageName;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;
import by.htp.library.service.ShowUsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowUsers implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        HttpSession session = request.getSession();
        List<User> list = null;
        try {
            list = ShowUsersService.showUsers();
        } catch (DAOException e) {
            e.getMessage();
        }
        request.setAttribute("userbean", list);
        return PageName.SHOW_USERS;
    }
}
//        List<User> list = new ArrayList<>();
//        String page = null;
//        TreeSet<Object> set = null;
//        JspSet jsp = null;
//        try {
//            list = ShowUsersService.showUsers();
//        } catch (DAOException e) {
//            e.getStackTrace();
//        }
//
//        if (list != null) {
//            set = new TreeSet<>();
//            for (int i = 0; i < list.size(); i++) {
//                    set.add(list.get(i).getLogin());
//            }
//            jsp = new JspSet(set);
//            request.setAttribute("userbean", jsp);
//            return page = PageName.SHOW_USERS;
//        }
//
//        return page;
//    }
//}
