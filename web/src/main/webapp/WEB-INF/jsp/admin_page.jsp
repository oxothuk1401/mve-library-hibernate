<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="mytag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Admin-page</title>
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.search" var="search" />
<fmt:message bundle="${loc}" key="local.exit" var="exit" />
<fmt:message bundle="${loc}" key="local.nameAdmin" var="nameAdmin" />
<fmt:message bundle="${loc}" key="local.addbook" var="addbook" />
<fmt:message bundle="${loc}" key="local.viewcatalog" var="viewcatalog" />
<fmt:message bundle="${loc}" key="local.viewusers" var="viewusers" />

</head>
<body>	
	<table width="1100" border="0" align="center" cellspacing="0" cellpadding="5">
			<tr bgcolor="#BDBDBD">
			<td align="right" width="900" height="15">
			${nameAdmin}
			<c:out value="${requestScope.login}"/>
			</td>
			<td width="100" height="15">
			<form action="Controller" method="post">
						<input type="hidden" name="command" value="logout" />
						<input type="submit" value="${exit}" /> 
			</form>
			</td>
			</tr>
			</table>
		<table width="1100" border="0" align="center" cellspacing="0" cellpadding="10">
			<tr bgcolor="">
				<td width="1100" align="center" height="50">
					<form action="Controller" method="post">
						<input type="hidden" name="command" value="search"> 
						<input type="submit" value="${search}" /> 
						<input type="text" name="searching" size="90" value=""><br>
					</form>
					<c:out value="${requestScope.errorMessage}" />
				</td>
			</tr>
		</table><br>
		<table width="1100" border="0" align="center" cellspacing="0" cellpadding="0">
		<tr>
			<td width="220" align="left" height="0">
					<form action="Controller" method="post">
						<input type="hidden" name="command" value="add-book">
						<input type="submit" value="${addbook}" />
					</form>
			</td>
		</tr>
		<tr>
			<td width="220" align="left" height="0">
					<form action="Controller" method="post">
						<input type="hidden" name="command" value="show-catalog">
						<input type="submit" value="${viewcatalog}" />
					</form>
			
			</td>
		</tr>
		<tr>
			<td width="220" align="left" height=0>
					<form action="Controller" method="post">
						<input type="hidden" name="command" value="show-users">
						<input type="submit" value="${viewusers}" />
					</form>
			</td>
		</tr>
		</table>
   </body>

</html>
     