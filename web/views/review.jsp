<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Order Management</title>
        <%@include file="layout/fontAndIcon.jsp" %>
        <link rel="stylesheet" href="../assets/invoice.css"/>
    </head>
    <body>
        <%@include file="layout/nav.jsp" %>
        <div style="margin-top: 70px">
            <a href="cards">Create New Order</a>
        </div>     
        <div>
            <h1>Current order of Customer ${id}</h1>
            <table border="1">
                <tr>
                    <th>Order ID</th>
                    <th>Customer ID</th>
                    <th>Order Date</th>
                    <th>Required Date</th>
                    <th>Shipped Date</th>
                    <th>Freight</th>
                    <th>Ship Address</th>
                    <th>Actions</th>
                </tr>
                <c:forEach items="${listOrders}" var="o">     
                    <c:if test="${o.orderDate.time >= currentDate.time}">
                        <tr>
                            <td>${o.orderID}</td>
                            <td>${o.customerID}</td>
                            <td>${o.orderDate}</td>
                            <td>${o.requiredDate}</td>
                            <td>${o.shippedDate}</td>
                            <td>${o.freight}</td>
                            <td>${o.shipAddress}</td>
                            <td>
                                <a href="reviews?id=${o.orderID}">
                                    View order detail. 
                                </a>                                
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>

            <h1>History order of Customer ${id}</h1>
            <table border="1">
                <tr>
                    <th>Order ID</th>
                    <th>Customer ID</th>
                    <th>Order Date</th>
                    <th>Required Date</th>
                    <th>Shipped Date</th>
                    <th>Freight</th>
                    <th>Ship Address</th>
                    <th>Actions</th>
                </tr>
                <c:forEach items="${listOrders}" var="o">
                    <c:if test="${o.orderDate.time < currentDate.time}">
                        <tr>
                            <td>${o.orderID}</td>
                            <td>${o.customerID}</td>
                            <td>${o.orderDate}</td>
                            <td>${o.requiredDate}</td>
                            <td>${o.shippedDate}</td>
                            <td>${o.freight}</td>
                            <td>${o.shipAddress}</td>
                            <td>
                                <a href="reviews?id=${o.orderID}">
                                    View order detail. 
                                </a>   
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div>
        <br>
    </body>
</html>
