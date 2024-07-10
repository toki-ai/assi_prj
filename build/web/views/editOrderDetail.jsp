<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
        <link rel="stylesheet" href="../assets/cart.css"/>
        <%@ include file="layout/fontAndIcon.jsp" %>
    </head>
    <body style="background-color: #d2c9ff;">
        <%@ include file="layout/nav.jsp" %>
        <section class="h-100 h-custom" style="background-color: #d2c9ff; margin-top: 40px">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12">
                        <div class="card card-registration card-registration-2" style="border-radius: 15px;">
                            <div class="card-body p-0">
                                <div class="px-5 py-2">
                                    <h6 class="mb-0"><a href="home" class="text-body"><i
                                                class="fas fa-long-arrow-alt-left me-2"></i>Back to shop</a></h6>
                                </div>
                                <div class="row g-0" style="min-height: 500px;">
                                    <div class="col-lg-8">
                                        <div class="px-5 pt-2">
                                            <h1>${message}</h1>
                                            <div class="d-flex justify-content-between align-items-center" style="margin-bottom: 35px">
                                                <h1 class="fw-bold mb-0">Edit order</h1>
                                                <h6 class="mb-0 text-muted">${cartSize} items</h6>
                                            </div>  
                                            <hr class="my-4">
                                            <c:forEach var="c" items="${cart}">
                                                <c:set var="productTotal" value="${c.unitPrice * c.quantity}" />
                                                <c:set var="itemTotal" value="${itemTotal + productTotal}" />
                                                <div class="row mb-4 d-flex justify-content-between align-items-center">
                                                    <div class="col-md-2 col-lg-2 col-xl-2 rounded-3">
                                                        <img src="${c.productImage}" class="img-fluid rounded-3" alt="${c.productName}">
                                                    </div>
                                                    <div class="col-md-3 col-lg-3 col-xl-3">
                                                        <h6 class="text-muted">${c.categoryName}</h6>
                                                        <h6 class="mb-0">${c.productName}</h6>
                                                    </div>
                                                    <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                                        <a class="btn btn-link px-2" href="updateCart?mid=${c.productID}&quantity=${c.quantity}">
                                                            <i class="fas fa-minus"></i>
                                                        </a>
                                                        <input min="0" name="quantity" value="${c.quantity}" type="number" 
                                                               style="width: 50px; height: 40px; border-radius: 5px; text-align: center;"/>
                                                        <a class="btn btn-link px-2" href="updateCart?pid=${c.productID}&quantity=${c.quantity}">
                                                            <i class="fas fa-plus"></i>
                                                        </a>
                                                    </div>
                                                    <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                        <h6 class="mb-0">$ ${c.unitPrice * c.quantity}</h6>
                                                    </div>
                                                    <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                        <a href="removeCart?id=${c.productID}" class="text-muted"><i class="fas fa-times"></i></a>
                                                    </div>
                                                </div>
                                                <hr class="my-4">
                                            </c:forEach>                    
                                        </div>
                                    </div>
                                    <div class="col-lg-4 bg-body-tertiary">
                                        <div class="px-5 pt-2">
                                            <h3 class="fw-bold mb-5 mt-2 pt-1">Summary</h3>
                                            <hr class="my-4">
                                            <div class="d-flex justify-content-between mb-4">
                                                <h5 class="text-uppercase">${cartSize} items</h5>
                                                <fmt:formatNumber value="${itemTotal}" type="currency" currencyCode="USD" maxFractionDigits="2"/>
                                            </div>
                                            <h5 class="text-uppercase mb-3">Shipping</h5>
                                            <div class="mb-4 pb-2">
                                                <select id="shippingOptions" data-mdb-select-init>
                                                    <option value="5" selected>Standard-Delivery- $5.00</option>
                                                    <option value="10">Express Delivery- $10.00</option>
                                                    <option value="3">Economy Delivery- $3.00</option>
                                                </select>
                                            </div>
                                            <hr class="my-4">
                                            <div class="d-flex justify-content-between mb-5">
                                                <h5 class="text-uppercase">Total price</h5>
                                                <h5 id="totalPrice">$ ${itemTotal}</h5>                                             
                                            </div>
                                            <div data-mdb-button-init data-mdb-ripple-init class="btn btn-dark btn-block btn-lg"
                                                 data-mdb-ripple-color="dark">
                                                <a id="createOrderLink" href="create?option=order&freight=5" style="font-style: none; color: white">Create new Order</a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <%@ include file="layout/footer.jsp" %>
        <script>
            document.addEventListener('DOMContentLoaded', () => {
                const shippingOptions = document.getElementById('shippingOptions');
                const createOrderLink = document.getElementById('createOrderLink');
                const totalPriceElement = document.getElementById('totalPrice');
                let itemTotal = parseFloat(totalPriceElement.textContent.replace('$', ''));
                let currentFreight = parseFloat(shippingOptions.value);

                const updateDefaultValues = () => {
                    const baseHref = 'create?option=order&freight=';
                    createOrderLink.href = baseHref + currentFreight;
                    const newTotal = itemTotal + currentFreight;
                    totalPriceElement.textContent = '$' + newTotal.toFixed(2);
                };

                updateDefaultValues();

                shippingOptions.addEventListener('change', function () {
                    currentFreight = parseFloat(this.value);
                    updateDefaultValues();
                });
            });
        </script>
    </body>
</html>
