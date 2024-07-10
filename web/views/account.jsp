<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account manage</title>
        <link rel="stylesheet" href="../assets/homepage.css"/>
        <%@include file="layout/fontAndIcon.jsp" %>
    </head>
    <body>
        <%@include file="layout/nav.jsp" %>
        <main style="margin-top: 100px">
            <div class="container">
                <%@include file="layout/manageAccount.jsp" %>
            </div>
        </main>
        <%@include file="layout/footer.jsp" %>
        <script>
            function confirmDelete() {
                return confirm('Are you sure you want to delete this product?');
            }
        </script>
    </body>
</html>
