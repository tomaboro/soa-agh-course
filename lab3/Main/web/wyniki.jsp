<%--
  Created by IntelliJ IDEA.
  User: motek
  Date: 21.03.18
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Doradca Piwny</title>
</head>
<body>
<c:forEach var="marka" items="${wybor}">
    ${marka}<br/>
</c:forEach>
</body>
</html>