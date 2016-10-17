<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="mytag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.searchresultbook" var="searchresultbook"/>
    <fmt:message bundle="${loc}" key="local.id" var="id"/>
    <fmt:message bundle="${loc}" key="local.access" var="access"/>
    <fmt:message bundle="${loc}" key="local.author" var="author"/>
    <fmt:message bundle="${loc}" key="local.title" var="title"/>
    <fmt:message bundle="${loc}" key="local.date" var="date"/>
    <fmt:message bundle="${loc}" key="local.location" var="location"/>
    <fmt:message bundle="${loc}" key="local.amount" var="amount"/>
</head>
<body>
<table width="1100" border="0" align="center" cellspacing="0" cellpadding="10">
    <td width="1100" align="center">
        ${searchresultbook} <br>
    </td>
    <table width="1100" border="1" align="center">

        <tr bgcolor="#CCCCCC">
            <td align="center"><strong>${id}</strong></td>
            <td align="center"><strong>${access}</strong></td>
            <td align="center"><strong>${author}</strong></td>
            <td align="center"><strong>${title}</strong></td>
            <td align="center"><strong>${date}</strong></td>
            <td align="center"><strong>${location}</strong></td>
            <td align="center"><strong>${amount}</strong></td>
        </tr>
        <c:forEach var="book" items="${bookbean}">
            <tr>
                <td><c:out value="${ book.id }"/></td>
                <td><c:out value="${ book.access }"/></td>
                <td><c:out value="${ book.author }"/></td>
                <td><c:out value="${ book.title }"/></td>
                <td><c:out value="${ book.date }"/></td>
                <td><c:out value="${ book.location }"/></td>
                <td><c:out value="${ book.amount }"/></td>
            </tr>
        </c:forEach>
    </table>
    <%--</table>--%>
    <%--<jsp:useBean id="userbean" class="by.htp.library.controller.jspTeg.JspSet" scope= "request"/>--%>
    <%--<mytag:jspset2 set = "${userbean}"/>--%>
</body>
</html>