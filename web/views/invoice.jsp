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
        <div style="margin-top: 100px" class="container mt-6 mb-7">
            <a href="reviews" style="margin-top: 100px">Back</a>
            <div class="row justify-content-center">
                <div class="col-lg-12 col-xl-7">
                    <div class="card">
                        <div class="card-body p-5">
                            <h2>
                                Hey ${username},
                            </h2>
                            <p class="fs-sm">
                                This is the receipt for a payment of <strong>$312.00</strong> (USD) you made to Spacial Themes.
                            </p>

                            <div class="border-top border-gray-200 pt-4 mt-4">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="text-muted mb-2">Order No.</div>
                                        <strong>#${order.orderID}</strong>
                                    </div>
                                    <div class="col-md-6 text-md-end">
                                        <div class="text-muted mb-2">Order Date</div>
                                        <strong>${order.orderDate}</strong>
                                    </div>
                                </div>
                            </div>

                            <div class="border-top border-gray-200 mt-4 py-4">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="text-muted mb-2">Client</div>
                                        <strong>
                                            ${customer.contactName}
                                        </strong>
                                        <p class="fs-sm">
                                            ${customer.address}                                              
                                        </p>
                                        <p class="fs-sm">
                                            ${customer.phone}                                              
                                        </p>
                                    </div>
                                    <div class="col-md-6 text-md-end">
                                        <div class="text-muted mb-2">Payment To</div>
                                        <strong>
                                            Pizza 2'P
                                        </strong>
                                        <p class="fs-sm">
                                            9th Avenue, San Francisco 99383                                           
                                        </p>
                                        <p class="fs-sm">
                                            5555-5555                                              
                                        </p>
                                    </div>
                                </div>
                            </div>

                            <table class="table border-bottom border-gray-200 mt-3">
                                <thead>
                                    <tr>
                                        <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm px-0">Description</th>
                                        <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm text-end px-0">Amount</th>
                                        <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm text-end px-0">Price</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listDetail}" var="p">
                                        <c:set var="productTotal" value="${p.unitPrice * p.quantity}" />
                                        <c:set var="total" value="${total + productTotal}" />
                                        <tr>
                                            <td class="px-0">${p.productName}</td>
                                            <td class="text-end px-0">${p.quantity}</td>
                                            <td class="text-end px-0">${p.unitPrice * p.quantity}</td>
                                        </tr>   
                                    </c:forEach>
                                </tbody>
                            </table>

                            <div class="mt-5">
                                <c:set var="total" value="${total + order.freight}" />
                                <div class="d-flex justify-content-end">
                                    <p class="text-muted me-3">Freight:</p>
                                    <span>${order.freight}</span>
                                </div>
                                <div class="d-flex justify-content-end">
                                    <p class="text-muted me-3">Ship Date:</p>
                                    <span>${order.shippedDate}</span>
                                </div>
                                <div class="d-flex justify-content-end mt-3">
                                    <h5 class="me-3">Total:</h5>
                                    <h5 class="text-success">
                                        <fmt:formatNumber value="${total}" type="currency" currencyCode="USD" maxFractionDigits="2"/>
                                    </h5>
                                </div>
                            </div>
                        </div>
                        <c:set var="orderTimestamp" value="${order.shippedDate.time}" />
                        <c:set var="currentTimestamp" value="${currentDate.time}" />
                        <c:if test="${orderTimestamp >= currentTimestamp}">
                            <div style="height: 50px; width: 100%">
                                <a href="delete?oid=${order.orderID}">Cancel this order</a>
                                <button>Edit this order</button>
                            </div>
                        </c:if>
                        <c:if test="${orderTimestamp < currentTimestamp}">
                            <div style="height: 50px; width: 100%; background-color: green; color: white; text-align: center; padding-top: 15px">
                                This order competed. 
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
