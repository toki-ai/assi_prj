<%@page import="model.entity.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <title>Order Management</title>
    <%@include file="layout/fontAndIcon.jsp" %>
</head>
<body>
    <%@include file="layout/nav.jsp" %>
    <div style="margin-top: 120px; display: flex; justify-content: center; align-items: top; min-height: 400px">
        <div style="text-align: center">
            <h1 style="margin-bottom: 20px">Order Details</h1>
            <div style="width: 800px; padding: 20px; border: 1px solid lightgray; border-radius: 10px">
                <form action="create?option=orderDetail" method="POST">             
                    <select name="customerID" data-mdb-select-init style="margin: 20px; border: none; outline: none">
                        <option value="">Select a customer</option>
                        <c:forEach items="${customers}" var="c">
                            <option value="${c.customerID}">${c.contactName}</option>
                        </c:forEach> 
                    </select>
                    <select name="freight" data-mdb-select-init style="margin: 20px; border: none; outline: none">
                        <option value="5" selected>Standard-Delivery - $5.00</option>
                        <option value="10">Express Delivery - $10.00</option>
                        <option value="3">Economy Delivery - $3.00</option>
                    </select>
                    <div id="orderDetailsContainer"></div>
                    <div style="margin-top: 20px">
                        <button type="button" onclick="addOrderDetail()">Add Order Detail</button>
                        <input type="submit" value="Save">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%@include file="layout/footer.jsp" %>
    <script>
        function addOrderDetail() {
            var container = document.getElementById("orderDetailsContainer");
            var orderDetailForm = document.createElement("div");

            orderDetailForm.innerHTML = `
                <div class="order-detail">
                    <label for="item">Item:</label>
                    <select name="item" required style="margin-right: 20px">
                        <option value="">Select a product</option>
            <%
                List<Product> products = (List<Product>) request.getAttribute("products");
                for (Product product : products) {
            %>
                            <option value="<%= product.getProductID() %>"><%= product.getProductName() %></option>
            <% } %>
                    </select>
                    <label for="quantity">Quantity:</label>
                    <input id="quantity" min="0" type="number" name="quantity" required>
                    <button type="button" onclick="removeOrderDetail(this)">Remove</button>
                </div>
            `;
            container.appendChild(orderDetailForm);
        }

        function removeOrderDetail(button) {
            var orderDetailForm = button.parentNode;
            orderDetailForm.remove();
        }; 
    </script>
</body>
</html>
