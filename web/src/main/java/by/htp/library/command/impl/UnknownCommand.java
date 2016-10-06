package by.htp.library.command.impl;

import by.htp.library.command.Command;
import by.htp.library.controller.PageName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UnknownCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return PageName.ERROR_PAGE;
    }
}
