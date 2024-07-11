<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
        <link rel="stylesheet" href="../assets/homepage.css"/>
        <%@include file="layout/fontAndIcon.jsp" %>
    </head>
    <body>
        <%@include file="layout/nav.jsp" %>
        <%@include file="layout/slider.jsp" %>
        <main>
            <div class="container">
                <h1 id="notification">${message}</h1>
                <c:if test="${sessionScope.user.type == 2 || sessionScope.user.type == null}">
                    <%@include file="layout/products.jsp" %>
                    <div class="d-flex justify-content-center mt-3">
                        <button onclick="loadMore()">Load More</button>
                    </div>
                </c:if>
                <c:if test="${sessionScope.user.type == 1}">
                    <%@include file="layout/manageProducts.jsp" %>
                </c:if>
        </main>
        <%@include file="layout/footer.jsp" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script>
                            document.addEventListener("DOMContentLoaded", function () {
                                var notification = document.getElementById("notification");
                                var message = notification.innerText;
                                if (message) {
                                    notification.style.display = "block";
                                    setTimeout(function () {
                                        notification.style.display = "none";
                                    }, 3000);
                                }
                            });

                            function confirmDelete() {
                                return confirm('Are you sure you want to delete this product?');
                            }

                            function loadMore() {
                                var amount = document.getElementsByClassName("product").length;
                                $.ajax({
                                    type: "GET",
                                    url: "/FindingNemo/load",
                                    data: {
                                        count: amount
                                    },
                                    success: function (result) {
                                        var row = document.getElementById("content");
                                        row.innerHTML += result;
                                    }
                                });
                            }

        </script>
    </body>
</html>
