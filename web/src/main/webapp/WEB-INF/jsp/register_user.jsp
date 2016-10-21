<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Library</title>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.registerUserLibrary" var="registerUserLibrary"/>
    <fmt:message bundle="${loc}" key="local.Phone" var="Phone"/>
    <fmt:message bundle="${loc}" key="local.enterpassword" var="enterpassword"/>
    <fmt:message bundle="${loc}" key="local.yourgender" var="yourgender"/>
    <fmt:message bundle="${loc}" key="local.male" var="male"/>
    <fmt:message bundle="${loc}" key="local.female" var="female"/>
    <fmt:message bundle="${loc}" key="local.send" var="send"/>
    <fmt:message bundle="${loc}" key="local.clear" var="clear"/>
    <fmt:message bundle="${loc}" key="local.tomain" var="tomain"/>
    <fmt:message bundle="${loc}" key="local.login" var="login"/>
    <fmt:message bundle="${loc}" key="local.locbutton.name.login" var="login_button"/>
</head>
<body>
<table width="300" height="0" border="1" align="center" cellspacing="0" cellpadding="0">
    <tr bgcolor="#A9A9A9">
        <td align="center" height="0"> ${registerUserLibrary}
        </td>
    </tr>
</table>
<table width="300" border="0" align="center" cellspacing="0" cellpadding="10">
    <tr bgcolor="#F2F2F2">
        <td align="center" width="300" height="85">
            <form action="Controller" method="post">
                <input type="hidden" name="command" value="register-user-form">
                <table border="0" cellspacing="1" cellpadding="1">
                    <tr>
                        <td align="left"><c:out value="${login}"/></td>
                        <td><input type="text" name="login" size="16"></td>
                    </tr>
                    <tr>
                        <td align="left"><c:out value="${enterpassword}"/></td>
                        <td><input type="password" name="password" size="17"></td>
                    </tr>
                    <tr>
                        <td align="right"><c:out value="${yourgender}"/></td>
                        <td>
                            <input type="radio" name="sex" value="man" checked> <c:out value="${male}"/><br>
                            <input type="radio" name="sex" value="woman"> <c:out value="${female}"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="center" colspan="2">
                            <input type="submit" name="submit" value="<c:out value="${send}" />">
                            <input type="reset" name="reset" value="<c:out value="${clear}" />">

                        </td>
                    </tr>
                </table>
            </form>
            <form action="Controller" method="post">
                <input type="hidden" name="command" value="return-page">
                <input type="submit" value="${tomain}"/>
            </form>
            <c:out value="${requestScope.errorMessage}"/>
        </td>
    </tr>
</table>

</body>
</html>