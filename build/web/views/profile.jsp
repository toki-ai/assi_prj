<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Order Management</title>
        <%@include file="layout/fontAndIcon.jsp" %>
        <link rel="stylesheet" href="../assets/invoice.css"/>
    </head>
    <%@include file="layout/styleInfor.jsp" %>

    <body>
        <%@include file="layout/nav.jsp" %>
        <div class="container" style="margin-top: 70px">
            <h1>${error}</h1>
            <form action="update?option=profile&aid=${account.accountID}&cid=${customer.customerID}" method="POST">
                <div class="row gutters">                  
                    <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
                        <div class="card h-100">
                            <div class="card-body">
                                <div class="account-settings">
                                    <div class="user-profile">
                                        <div class="user-avatar">
                                            <img src="https://i.pinimg.com/564x/08/20/73/082073dd36587d57d24dbdc2f49f3dd0.jpg" alt="Maxwell Admin">
                                        </div>
                                        <h5 class="user-name">${account.fullName}</h5>
                                        <h6 class="user-username">@${account.userName}</h6>
                                    </div>     
                                </div>
                            </div>
                        </div>
                    </div>
                    <c:if test="${readonly != null}">
                        <%@include file="layout/profileReadOnly.jsp" %>
                    </c:if>       
                    <c:if test="${readonly == null}">
                        <%@include file="layout/profileEdit.jsp" %>
                    </c:if>     
                </div>
            </form>
        </div>
        <%@include file="layout/footer.jsp" %>
        <script>
            function confirmDelete() {
                return confirm('Are you sure you want to delete this account?');
            }
        </script>
    </body>
</html>
