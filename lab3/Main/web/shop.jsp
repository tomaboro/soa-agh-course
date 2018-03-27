<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%--
  Created by IntelliJ IDEA.
  User: motek
  Date: 26.03.18
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sklep</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <jsp:useBean id="order" class="pl.motek.soa.Model.OrderListBean" scope="session"/>
    <c:import var = "products" url = "http://localhost:8080/Main_war_exploded/products.xml"/>
    <x:parse xml = "${products}" var = "output"/>

    <h1>Sklep</h1>
    <table>
        <tr>
            <th>Nazwa</th>
            <th>Cena</th>
            <th>Kup</th>
        </tr>
        <x:forEach select="$output/computer_parts/part" var="part">
            <tr>
                <td> <x:out select = "$part/name" /> </td>
                <td> <x:out select= "$part/price" /> </td>
                <td>
                    <form method="POST" action="add.jsp">
                        <input type="number" name="amount" min="0"/>
                        <input type="hidden" name="id" value = <x:out select= "$part/@id"/> >
                        <input type="submit" value="Kup">
                    </form>
                </td>
            </tr>
        </x:forEach>
    </table>

    <h1>Koszyk</h1>

    <table>
        <tr>
            <th>Nazwa</th>
            <th>Ilość</th>
            <th>Cena</th>
            <th>Usuń</th>
        </tr>
        <c:forEach var="orderID" items="${order.orders.keys()}" >
            <tr>
                <td><x:out select="$output/computer_parts/part[$orderID]/name" /></td>
                <td><c:out value="${order.orders.get(orderID)}"/></td>
                <td><x:out select="$output/computer_parts/part[$orderID]/price" /></td>
                <td>
                    <form method="POST" action="remove.jsp">
                        <input type="number" name="amount" min="0" max="${order.orders.get(orderID)}" maxlength="3"/>
                        <input type="hidden" name="id" value = <c:out value = "${orderID}"/> >
                        <input type="submit" value="Usuń">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
