<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="mytag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.registrlists" 	var="registrlists" />
<fmt:message bundle="${loc}" key="local.Deleteuser" 	var="Deleteuser" />

</head>
<body>
	<table width="1100" border="0" align="center" cellspacing="0" cellpadding="10">

		<table width="1100" border="1" align="center">

			<tr bgcolor="#CCCCCC">
				<td align="center"><strong>ID</strong></td>
				<td align="center"><strong>Доступность</strong></td>
				<td align="center"><strong>Автор</strong></td>
				<td align="center"><strong>Название</strong></td>
				<td align="center"><strong>Дата публикации</strong></td>
				<td align="center"><strong>Местонахождение</strong></td>
				<td align="center"><strong>Колличество</strong></td>
			</tr>
			<c:forEach var="book" items="${bookbean}">
				<tr>
					<td><c:out value="${ book.id }" /></td>
					<td><c:out value="${ book.access }" /></td>
					<td><c:out value="${ book.author }" /></td>
					<td><c:out value="${ book.title }" /></td>
					<td><c:out value="${ book.date }" /></td>
					<td><c:out value="${ book.location }" /></td>
					<td><c:out value="${ book.number }" /></td>
				</tr>
			</c:forEach>
		</table>
	
</body>
</html>