<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Library</title>
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.login" 					var="login" />
<fmt:message bundle="${loc}" key="local.password" 				var="password" />
<fmt:message bundle="${loc}" key="local.library" 				var="library" />
<fmt:message bundle="${loc}" key="local.registration" 			var="registration" />
<fmt:message bundle="${loc}" key="local.locbutton.name.login" 	var="login_button" />
</head>
<body>
	<table width="300" border="1" align="center" >
	<tr bgcolor="#A9A9A9">
	<td align="center"> ${library}
	</td>
	<td align="right" width="3" height="0">
				 <form action="Controller"	method="post">
					<input type="hidden" name="command" value="change-local" /> 
					<input type="hidden" name="local" value="ru" /> 
					<input type="image" src="jpj/rus1.jpg">
				</form>
	</td>
	<td align="left" width="3" height="0">
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="change-local" /> 
					<input type="hidden" name="local" value="en" /> 
					<input type="image" src="jpj/en.jpg">
				</form>
	</td>
	</tr>
	</table>
	<table width="300" border="0" align="center" cellspacing="0" cellpadding="10">
			<tr bgcolor="#F2F2F2">
			<td align="center" width="50" height="85">
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="login" />
					<c:out value="${login}" />	<br /> 
					<input type="text" name="login" size="15" value="" /> <br />
					<c:out value="${password}" /> <br />
					<input type="password" name="password" size="17" value="" /><br /> 
					<input type="submit" value="${login_button}" />
				</form>
				<form  action="Controller"  method="post">
					<input type="hidden" name="command" value="register-page"> 
					<input type="submit" value="${registration}" />
				</form>
				<c:out value="${requestScope.errorMessage}" />
				<c:out value="${requestScope.NotUsers}" />
				<c:out value="${requestScope.message}" />
			</td>
		</tr>
	</table>
	
</body>
</html>