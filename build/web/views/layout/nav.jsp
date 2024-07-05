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
                <li class="nav-item active">
                    <a class="nav-link " href="https://mdbootstrap.com/">Pizza</a>
                </li>
                <li class="nav-item">
                    <select name="Categories" id="cars">
                        <option value="" disabled selected style="display: none;">Categories</option>
                        <option value="volvo">Volvo</option>
                        <option value="saab">Saab</option>
                        <option value="opel">Opel</option>
                        <option value="audi">Audi</option>
                    </select>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="https://mdbootstrap.com/docs/standard/getting-started/installation/">Reviews</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="https://mdbootstrap.com/education/bootstrap/">Orders</a>
                </li>
            </ul>    
        </div>
        <!-- Right -->
        <div class="d-flex align-items-center">
            <a class="nav-link me-3" href="#">
                <i class="fa-regular fa-circle-user"></i>
            </a>
            <p>Hello ${userName}</p>
            <a href="/FindingNemo" class="border rounded px-2 nav-link">
                logout
            </a>
        </div>
        <!-- Right elements -->

    </div>
    <!-- Container wrapper -->
</nav>
<!-- Navbar -->
