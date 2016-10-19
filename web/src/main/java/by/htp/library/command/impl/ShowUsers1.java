package by.htp.library.command.impl;

import by.htp.library.command.Command;
import by.htp.library.controller.PageName;
import by.htp.library.controller.jspTeg.JspSet;
import by.htp.library.entity.User;
import by.htp.library.service.ShowUsers1Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by oxothuk1401 on 18.10.2016.
 */
public class ShowUsers1 implements Command {
    private String POSITION = "position";
    private String AMOUNT = "amount";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<User> list = ShowUsers1Service.showUsers1(request.getParameter(POSITION), request.getParameter(AMOUNT));
        String pagees = PageName.ERROR_PAGE;
        TreeSet<Object> set = null;
        JspSet jsp = null;
        if (list != null) {
            set = new TreeSet<>();
            for (int i = 0; i < list.size(); i++) {
                set.add(list.get(i).toString());
//                set.add("ID = " + list.get(i).getId() + " Login = " + list.get(i).getLogin() + " Role = " + list.get(i).getRole());
            }
            jsp = new JspSet(set);
            request.setAttribute("userbean", jsp);
            return pagees = PageName.SHOW_USERS1;
        }
        return pagees;
    }
}