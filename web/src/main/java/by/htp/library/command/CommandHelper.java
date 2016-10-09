package by.htp.library.command;

import by.htp.library.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandHelper {
	private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

	public CommandHelper() {
		commands.put(CommandName.LOGIN, new Login());
		commands.put(CommandName.LOGOUT, new Logout());
		commands.put(CommandName.REGISTER_PAGE, new RegisterPage());
//		commands.put(CommandName.REGISTER_USER_FORM, new RegisterUserForm());
		commands.put(CommandName.SHOW_CATALOG, new ShowCatalog());
		commands.put(CommandName.SHOW_USERS, new ShowUsers());
//		commands.put(CommandName.SEARCH, new SearchBook());
//		commands.put(CommandName.DELETE_USER, new DeleteUser());
		commands.put(CommandName.CHANGE_LOCAL, new ChangeLocal());
//		commands.put(CommandName.RETURN_PAGE, new ReturnPage());
	}

	public Command getCommand(String commandName) {
		Command command = null;
		CommandName key = null;

		commandName = commandName.replace('-', '_').toUpperCase();
		key = CommandName.valueOf(commandName);
		command = commands.get(key);
		if (command == null) {
			command = new UnknownCommand();
		}
		return command;
	}
}
