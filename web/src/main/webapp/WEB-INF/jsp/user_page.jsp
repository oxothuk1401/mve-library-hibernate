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
    <fmt:message bundle="${loc}" key="local.searchresultbook" var="searchresultbook"/>
    <fmt:message bundle="${loc}" key="local.search" var="search"/>
    <fmt:message bundle="${loc}" key="local.exit" var="exit"/>
    <fmt:message bundle="${loc}" key="local.nameUser" var="nameUser"/>
    <fmt:message bundle="${loc}" key="local.id" var="id"/>
    <fmt:message bundle="${loc}" key="local.access" var="access"/>
    <fmt:message bundle="${loc}" key="local.author" var="author"/>
    <fmt:message bundle="${loc}" key="local.title" var="title"/>
    <fmt:message bundle="${loc}" key="local.date" var="date"/>
    <fmt:message bundle="${loc}" key="local.location" var="location"/>
    <fmt:message bundle="${loc}" key="local.amount" var="amount"/>
    <fmt:message bundle="${loc}" key="local.sorting" var="sorting"/>
    <fmt:message bundle="${loc}" key="local.searchin" var="searchin"/>
    <fmt:message bundle="${loc}" key="local.entersearch" var="entersearch"/>
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
        <pre>                                                  ${searchin}         ${sorting}</pre>
        <td width="1100" border="0" align="center" height="10">
            <form action="Controller" method="post" onsubmit="return TestSearch(this.searching.value)">
                <script src = "assets/search.js"></script>
                <input type="submit" value="${search}"/>
                <select name="command" size="1">
                    <option selected value="author">${author}
                    <option value="title">${title}
                    <option value="date">${date}
                </select>
                <select name="sorted" size="1">
                    <option selected value="author">${author}
                    <option value="title">${title}
                    <option value="date">${date}
                </select>
                <input type="text" name="searching" size="90" value="" placeholder=${entersearch}><br>
            </form>
            <c:out value="${requestScope.errorMessage}"/>
            <c:out value="${requestScope.message}"/>
        </td>
    </tr>
</table>
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
</table>

</body>

</html>
     