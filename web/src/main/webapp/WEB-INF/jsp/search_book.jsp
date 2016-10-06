<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="mytag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.searchresultbook" var="searchresultbook" />
</head>
	<body>
	<table width="1100" border="0" align="center" cellspacing="0" cellpadding="10">
			<td width="1100" align="center">
				${searchresultbook} <br>
			</td>
			
	</table>
	<jsp:useBean id="userbean" class="by.htp.library.controller.jspTeg.JspSet" scope= "request"/>
	<mytag:jspset2 set = "${userbean}"/>
</body>
</html>