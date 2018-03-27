<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="order" class="pl.motek.soa.Model.OrderListBean" scope="session"/>

<c:forEach begin = "1" end = "${param.amount}">
    <% order.removeItem(Integer.parseInt(request.getParameter("id"))); %>
</c:forEach>

<c:redirect url="shop.jsp"/>