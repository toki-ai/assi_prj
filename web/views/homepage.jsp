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
                </c:if>
                <c:if test="${sessionScope.user.type == 1}">
                    <%@include file="layout/manageProducts.jsp" %>
                </c:if>
            </div>
        </main>
        <!--Main layout-->
        <%@include file="layout/footer.jsp" %>
        <script>
        document.addEventListener("DOMContentLoaded", function() {
            var notification = document.getElementById("notification");
            var message = notification.innerText;
            if (message) {
                notification.style.display = "block";
                setTimeout(function() {
                    notification.style.display = "none";
                }, 3000); 
            }
        });
    </script>
    </body>
</html>
