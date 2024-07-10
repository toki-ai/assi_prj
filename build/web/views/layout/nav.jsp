<!-- Navbar -->
<nav class="navbar fixed-top navbar-expand-lg navbar-light" style="background-color: #fff6d7; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); ">
    <!-- Container wrapper -->
    <div class="container">   

        <div class="d-flex align-items-center" id="navbarSupportedContent1">      
            <!-- Left -->
            <img class="navbar-brand mt-2 mt-sm-0" 
                 src="https://i.pinimg.com/564x/07/8d/fd/078dfd8731b5a987beb15bc5003389a0.jpg"
                 height="50"
                 alt="Pizza Logo"
                 style="transform: scale(1.5);"
                 />
            <h2 style='font-family: "Josefin Sans", sans-serif; font-weight: 600; padding-top: 10px; color:orange; text-shadow: 1px 1px 2px #ffffff;'>
                Pizza 2'P
            </h2>
        </div>
        <div class="d-flex align-items-center">
            <!-- Mid -->
            <ul class="navbar-nav me-auto mb-2 mb-lg-0" style='margin-left: 40px'>           
                <c:if test="${sessionScope.role == 1}">
                    <li class="nav-item active">
                        <a class="nav-link " href="home">Manage Products</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="accountsAD">Manage Accounts</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="reviews">Manage Orders</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="reportsAD">Report</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.role == 2}">
                    <li class="nav-item active">
                        <a class="nav-link " href="home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="infor">Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="reviews">Reviews</a>
                    </li>
                </c:if>
            </ul>    
        </div>
        <!-- Right -->
        <div class="d-flex align-items-center">
            <c:if test="${sessionScope.user != null}">
                <a class="nav-link me-3" href="#">
                    <i class="fa-regular fa-circle-user"></i>
                </a>
                <p>Hello ${sessionScope.user.userName}</p>
                <a href="logout" class="border rounded px-2 nav-link">
                    Logout
                </a>
            </c:if>
            <c:if test="${sessionScope.user == null}">
                <a href="login" class="border rounded px-2 nav-link">
                    Login
                </a>
            </c:if>
            <c:if test="${sessionScope.role == 2}">
                <a href="viewCart" style="margin-left: 20px" class="border rounded px-2 nav-link">
                    <i class="fa-solid fa-cart-shopping"></i> 
                    <span style="margin: 0 5px; background-color: orange; color: white; border-radius: 50%; padding: 0 5px; ">${cartSize}</span>
                </a>
            </c:if>
        </div>
    </div>
</nav>
