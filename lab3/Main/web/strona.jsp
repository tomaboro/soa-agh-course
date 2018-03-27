<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Lista Filmów</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <jsp:useBean id="listaFilmow" class="pl.motek.soa.Model.MoviesListBean" />
    <h1>Lista filmów</h1>
    <table>
        <tr>
            <th>Tytuł</th>
            <th>Gatunek</th>
            <th>Rok</th>
            <th>Dochód</th>
        </tr>
        <c:forEach var="film" items="${listaFilmow.movies}">
            <tr>
                <td>${film.title}</td>
                <c:choose>
                    <c:when test="${film.genere.equals(\"wojenny\")}"><td bgcolor="#7fffd4"></c:when>
                    <c:otherwise><td></c:otherwise>
                </c:choose>
                ${film.genere}</td>
                <td>${film.year}</td>
                <td>
                    <fmt:setLocale value = "en_US"/>
                    <fmt:formatNumber value = "${film.gain}" type = "currency"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>