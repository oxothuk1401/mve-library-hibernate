<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>User-page</title>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.search" var="search"/>
    <fmt:message bundle="${loc}" key="local.exit" var="exit"/>
    <fmt:message bundle="${loc}" key="local.nameUser" var="nameUser"/>
    <fmt:message bundle="${loc}" key="local.author" var="author"/>
    <fmt:message bundle="${loc}" key="local.title" var="title"/>
    <fmt:message bundle="${loc}" key="local.date" var="date"/>
</head>
<body>

<table width="1100" border="0" align="center" cellspacing="0" cellpadding="5">
    <tr bgcolor="#BDBDBD">
        <td align="right" width="900" height="15">
            ${nameUser}
            <c:out value="${requestScope.login}"/>
        </td>
        <td width="100" height="15">
            <form action="Controller" method="post">
                <input type="hidden" name="command" value="logout"/>
                <input type="submit" value="${exit}"/>
            </form>
        </td>
    </tr>
</table>
<table width="1100" border="0" align="center" cellspacing="0" cellpadding="10">
    <tr bgcolor="">
        <td width="1100" align="center" height="30">
            <form action="Controller" method="post">
                <input type="submit" value="${search}"/>
                <select name="command" size="1">
                    <option selected value="author">${author}
                    <option value="title">${title}
                    <option value="date">${date}
                </select>
                <input type="text" name="searching" size="90" value=""><br>
            </form>

            <c:out value="${requestScope.errorMessage}"/>
            <c:out value="${requestScope.message}"/>
        </td>
        <td>
        </td>
    </tr>
</table>

</body>

</html>
     