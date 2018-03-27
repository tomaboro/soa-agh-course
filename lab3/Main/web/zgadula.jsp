<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import = "java.io.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Zgadula</title>
</head>
<body>
<c:if test="${param.random == null}">
    <c:set var="random" scope="request"><%= (new Random()).nextInt(100) %> </c:set>
    <c:set var="tries" value="${0}" scope="request"/>
</c:if>
<c:if test="${param.random != null}">
    <fmt:parseNumber var="random" scope="request" value="${param.random}"/>
    <c:set var="tries"  scope="request" value="${param.tries}" />
</c:if>
<fmt:parseNumber var="guess" scope="request" value="${param.guess}"/>

<c:if test="${guess != null}">
    <c:if test="${guess < random}">
        <c:out value="Twoja liczba (${guess}) jest mniejsza niż zagadka (${random}) :("/>
    </c:if>
    <c:if test="${guess > random}">
        <c:out value="Twoja liczba (${guess}) jest większa niż zagadka (${random}) :("/>
    </c:if>
    <c:if test="${guess == random}">
        <c:out value="Twoja liczba (${guess}) to zagadka ! :D"/><br/>
        <c:out value="Zgadles po ${tries} probach"/><br/>
        <c:out value="Odświerz stronę aby zagrać ponownie!"/><br/>
    </c:if>
</c:if>

<c:if test="${guess != random}">
    <form method="POST" action="zgadula.jsp">
        Podaj liczbę:
        <input type="number" name="guess"/>
        <input type="hidden" name="random" value= <c:out value="${random}"/> >
        <input type="hidden" name="tries" value= <c:out value="${tries + 1}"/> >
        <input type="submit" value="Zgaduj!">
    </form>
</c:if>

</body>
</html>