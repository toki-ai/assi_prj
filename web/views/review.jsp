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
        <div style="margin-top: 100px; margin-left: 200px">
            <c:if test="${sessionScope.user.type == 2}">
                <a href="viewCart">Create New Order</a>
            </c:if>
            <c:if test="${sessionScope.user.type == 1}">
                <a href="view?option=createOrder">Create New Order</a>
            </c:if>
        </div>  
        <div style="display: flex; align-items: top; justify-content: center; margin-top: 0px; min-height: 400px">
            <div>
                <h2 style='font-family: "Josefin Sans", sans-serif; font-weight: 600; padding-top: 10px; color:orange; text-shadow: 1px 1px 2px #ffffff;'
                    >
                    Current order
                </h2>
                <table border="1" style="text-align: center; border-color: lightgray">
                    <tr>
                        <th style="padding: 5px 10px ">Order ID</th>
                            <c:if test="${sessionScope.user.type == 1}">
                            <th style="padding: 5px 10px ">Customer ID</th>
                            </c:if>
                        <th style="padding: 5px 20px ">Order Date</th>
                        <th style="padding: 5px 20px ">Required Date</th>
                        <th style="padding: 5px 20px ">Shipped Date</th>
                        <th style="padding: 5px 20px ">Freight</th>
                        <th style="padding: 5px 20px ">Ship Address</th>
                        <th style="padding: 5px 20px ">Actions</th>
                    </tr>
                    <c:forEach items="${listOrders}" var="o">     
                        <c:if test="${o.requiredDate.time >= currentDate.time}">
                            <c:if test="${sessionScope.user.type == 1}"> 
                                <%@include file="layout/orderTableAD.jsp" %>
                            </c:if>
                            <c:if test="${sessionScope.user.type == 2}">  
                                <%@include file="layout/orderTable.jsp" %>
                            </c:if>
                        </c:if>
                    </c:forEach>
                </table>

                <h2 style='margin-top: 30px; font-family: "Josefin Sans", sans-serif; font-weight: 600; padding-top: 10px; color:orange; text-shadow: 1px 1px 2px #ffffff;'
                    >
                    History order 
                </h2>
                <table border="1" style="text-align: center; border-color: lightgray">
                    <tr>
                        <th style="padding: 5px 10px ">Order ID</th>
                            <c:if test="${sessionScope.user.type == 1}">
                            <th style="padding: 5px 10px ">Customer ID</th>
                            </c:if>
                        <th style="padding: 5px 20px ">Order Date</th>
                        <th style="padding: 5px 20px ">Required Date</th>
                        <th style="padding: 5px 20px ">Shipped Date</th>
                        <th style="padding: 5px 20px ">Freight</th>
                        <th style="padding: 5px 20px ">Ship Address</th>
                        <th style="padding: 5px 20px ">Actions</th>
                    </tr>

                    <c:forEach items="${listOrders}" var="o">
                        <c:if test="${o.requiredDate.before(currentDate)}">                            
                            <c:if test="${sessionScope.user.type == 1}"> 
                                <%@include file="layout/orderTableAD.jsp" %>
                            </c:if>
                            <c:if test="${sessionScope.user.type == 2}">  
                                <%@include file="layout/orderTable.jsp" %>
                            </c:if>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
        </div>
        <%@include file="layout/footer.jsp" %>
        <script>
            function confirmDelete() {
                return confirm('Are you sure you want to delete this product?');
            }
        </script>
    </body>
</html>
