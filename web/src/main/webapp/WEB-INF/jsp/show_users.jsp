<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="mytag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.Blockuser" var="blockUser"/>
    <fmt:message bundle="${loc}" key="local.UnLock" var="unLockUser"/>
    <fmt:message bundle="${loc}" key="local.registrlists" var="registrlists"/>
    <fmt:message bundle="${loc}" key="local.Deleteuser" var="deleteUser"/>
    <fmt:message bundle="${loc}" key="local.apply" var="apply"/>
    <fmt:message bundle="${loc}" key="local.enterusername" var="enterUsername"/>
</head>
<body>
<table width="500" border="0" align="center" cellspacing="0" cellpadding="10">
    <tr>
        <td width="100" align="left" height="50">
            <form action="Controller" method="post">
                ${enterUsername}
                <input type="text" name="user" size="20" value=""><br>
                <input type="radio" name="command" value="delete-user" checked>${deleteUser}<br>
                <input type="radio" name="command" value="block-user">${blockUser}<br>
                <input type="radio" name="command" value="unlock-user">${unLockUser}<br>
                <input type="submit" value="${apply}"/>
            </form>
            <c:out value="${requestScope.errorMessage}"/><br>
        </td>
    </tr>
</table>
<table width="1100" border="0" align="center" cellspacing="0" cellpadding="10">
    <tr>
        <td width="1100" align="center" height="50">
            <c:out value="${registrlists}"/><br><br>
            <jsp:useBean id="userbean" class="by.htp.library.controller.jspTeg.JspSet" scope="request"/>
            <mytag:jspset set="${userbean}"/>
        </td>
    </tr>
</table>

</body>
</html>