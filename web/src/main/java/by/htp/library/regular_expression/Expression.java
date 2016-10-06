package by.htp.library.regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {

    private static final String LOGIN_VALIDATION = "([a-zA-Z0-9А-Яа-я]+){2,20}";
    private static final String PASSWORD_VALIDATION = ".{2,30}";

    public static boolean loginValidation(String login) {
        Pattern p = Pattern.compile(LOGIN_VALIDATION);
        Matcher m = p.matcher(login);
        if (m.matches()) {
            return false;
        }
        return true;
    }

    public static boolean passwordValidation(String password) {
        Pattern p = Pattern.compile(PASSWORD_VALIDATION);
        Matcher m = p.matcher(password);
        if (m.matches()) {
            return false;
        }
        return true;
    }


}
