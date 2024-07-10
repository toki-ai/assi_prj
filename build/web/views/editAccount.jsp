<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Account</title>
        <%@include file="layout/fontAndIcon.jsp" %>
        <link rel="stylesheet" href="../assets/invoice.css"/>
    </head>
    <%@include file="layout/styleInfor.jsp" %>

    <body>
        <%@include file="layout/nav.jsp" %>
        <div class="container" style="margin-top: 70px">
            <h1>${error}</h1>
            <form action="update?option=account" method="POST">
                <div class="row gutters">                  
                    <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
                        <div class="card h-100">
                            <div class="card-body">
                                <div class="account-settings">
                                    <div class="user-profile">
                                        <div class="user-avatar">
                                            <img src="https://i.pinimg.com/564x/08/20/73/082073dd36587d57d24dbdc2f49f3dd0.jpg" alt="Maxwell Admin">
                                        </div>
                                        <h5 class="full-name">${account.fullName}</h5>
                                        <h6 class="user-name">@${account.userName}</h6>
                                    </div>     
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
                        <div class="card h-100">
                            <div class="card-body">
                                <div class="row gutters">
                                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                        <h6 class="mb-2 text-primary">Personal Details</h6>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12" style='display: none'>
                                        <div class="form-group">
                                            <label for="fullName">Account ID</label>
                                            <input type="text" class="form-control" 
                                                   name='accountID' value='${account.accountID}'>
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12" style='display: none'>
                                        <div class="form-group">
                                            <label for="fullName">Customer ID</label>
                                            <input type="text" class="form-control" 
                                                   name='customerID' value='${customer.customerID}'
                                                   >
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="fullName">Full Name</label>
                                            <input type="text" class="form-control" id="fullName" placeholder="Enter full name"
                                                   name='fullName' value='${account.fullName}'
                                                   required
                                                   >
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="eMail">Username</label>
                                            <input type="text" class="form-control" id="eMail" placeholder="Enter username"
                                                   name='userName' value='${account.userName}'
                                                   required
                                                   >
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="phone">Phone</label>
                                            <input type="number" class="form-control" id="phone" placeholder="Enter phone number"
                                                   name='phone' value='${phone}'
                                                   required
                                                   >
                                        </div>
                                    </div> 
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <label for="phone">Type</label>
                                        <div class="form-group">
                                            <select id="type" name="type" style='width: 95%; padding: 5px;'>
                                                <option value="1">Staff</option>
                                                <option value="2">User</option>
                                            </select>    
                                        </div>
                                    </div>    
                                </div>
                                <div class="row gutters">
                                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                        <h6 class="mt-3 mb-2 text-primary">Address</h6>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="ciTy">Address</label>
                                            <input type="text" class="form-control" id="" placeholder="Enter address"
                                                   name="address" value='${customer.address}'
                                                   required>
                                        </div>
                                    </div>
                                </div>
                                <div class="row gutters">
                                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                        <h6 class="mt-3 mb-2 text-primary">Password</h6>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="ciTy">Password</label>
                                            <input type="password" class="form-control" id="ciTy" placeholder="Enter password"
                                                   name="password" value="${account.password}"
                                                   required>
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="sTate">Repeat</label>
                                            <input type="password" class="form-control" id="sTate" placeholder="Enter re-password"
                                                   name="re-password" value="${account.password}"
                                                   required>
                                            <small id="passwordMatchError" style="color: red; display: none;">Passwords do not match!</small>
                                        </div>
                                    </div>
                                </div>
                                <div class="row gutters">
                                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div style="height: 50px; width: 100%; display: flex; justify-content: right;">
                                            <button type="button" class="cancel-button" onclick="cancelAction()">Cancel</button>
                                            <button type="submit" class="btn btn-primary">Submit edit</button>
                                        </div>
                                    </div>  
                                </div>
                            </div>
                        </div>
                    </div>     
                </div>
            </form>
        </div>
        <%@include file="layout/footer.jsp" %>  
        <script>
            document.addEventListener('DOMContentLoaded', function () {
                var password = document.getElementById('ciTy');
                var rePassword = document.getElementById('sTate');
                var errorText = document.getElementById('passwordMatchError');

                function checkPasswordMatch() {
                    if (password.value !== rePassword.value) {
                        errorText.style.display = 'block';
                        rePassword.value = '';
                        rePassword.focus();
                    } else {
                        errorText.style.display = 'none';
                    }
                }

                rePassword.addEventListener('blur', checkPasswordMatch);
            });
            function cancelAction() {
                if (confirm("Are you sure you want to cancel and go back to the view page?")) {
                    window.location.href = 'accountsAD';
                }
            }
        </script>
    </body>
</html>
