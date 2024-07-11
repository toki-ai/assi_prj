<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Report</title>
        <%@include file="layout/fontAndIcon.jsp" %>
        <link rel="stylesheet" href="../assets/invoice.css"/>
    </head>
    <%@include file="layout/styleReport.jsp" %>
    <body>
        <%@include file="layout/nav.jsp" %>
        <div class="container1" style="margin-top: 100px; min-height: 420px">
            <div class="header" style="display: flex; justify-content: right">
                <form action="reportsAD">
                    <div>
                        <input type="date" name="startDate" required class="date-picker" value="${startDate}" required pattern="\d{4}-\d{2}-\d{2}"/>
                        <input type="date" name="endDate" required class="date-picker" value="${endDate}"/>
                        <input type="submit" value="Generate Report">
                    </div>
                </form>    
            </div>
            <div class="table-responsive">
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>TOTAL SOLD</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${productList}" var="p">
                            <tr>
                                <td>${p.productId}</td>
                                <td>${p.productName}</td>
                                <td>${p.totalPriceSold}</td>
                            </tr>
                        </c:forEach>                   
                    </tbody>
                </table>
            </div>
                        </div>
        <%@include file="layout/footer.jsp" %>
    </body>
</html>

