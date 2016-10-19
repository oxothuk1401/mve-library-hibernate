package by.htp.library.controller;

import by.htp.library.command.Command;
import by.htp.library.command.CommandHelper;
import by.htp.library.controller.exception.CommandException;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String COMMAND_NAME = "command";
	private final CommandHelper commandHelper = new CommandHelper();
	private static Logger log = Logger.getLogger(Controller.class.getName());
	public Controller() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession(true).getAttribute("local") == null){
			request.getSession(true).setAttribute("local", "ru");
		}
		String commndName;
		Command command;
		String page;
		try {
			commndName = request.getParameter(COMMAND_NAME);
			command = commandHelper.getCommand(commndName);
			page = command.execute(request, response);

		} catch (CommandException e) {
			page = PageName.ERROR_PAGE;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		if (dispatcher != null) {
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
			} catch (IOException e) {
			}
		}
	}
//		String commandName;
//		Command command;
//		try {
//			commandName = request.getParameter(COMMAND_NAME);
//			command = commandHelper.getCommand(commandName);
//			command.execute(request, response);
//		} catch (CommandException e) {
//			request.getSession().invalidate();
//			request.getRequestDispatcher(PageName.ERROR_PAGE).toString();
//		}
//	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession(true).getAttribute("local") == null){
			request.getSession(true).setAttribute("local", "ru");
		}
		String commndName;
		Command command;
		String page;
		try {
			commndName = request.getParameter(COMMAND_NAME);
			command = commandHelper.getCommand(commndName);
			page = command.execute(request, response);

		} catch (CommandException e) {
			page = PageName.ERROR_PAGE;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		if (dispatcher != null) {
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
			} catch (IOException e) {
			}
		}
	}
}
