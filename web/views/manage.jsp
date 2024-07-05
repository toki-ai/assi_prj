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
                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg navbar-dark mt-3 mb-5 shadow p-2" style="background-color: orange">
                    <!-- Container wrapper -->
                    <div class="container-fluid">
                        <h4>Categories:</h4>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent2">
                            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                                <!-- Link -->
                                <li class="nav-item acitve">
                                    <a class="nav-link" style="${pathId != null ? "color: white" : "color: blue"}" href="home">All</a>
                                </li>
                                <c:forEach items="${listCategory}" var="c">
                                    <li class="nav-item" >
                                        <a class="nav-link" style="${pathId == c.categoryID ? "color: blue;" : "color: white"}" href="category?id=${c.categoryID}">${c.categoryName}</a>
                                    </li>
                                </c:forEach>
                            </ul>

                            <!-- Search -->
                            <form class="w-auto py-1" style="margin-left: 100px; max-width: 12rem;">
                                <input type="search" class="form-control rounded-0" placeholder="Search" aria-label="Search">
                            </form>

                        </div>
                    </div>
                </nav>
                <!-- Navbar -->

                <!-- Products -->
                <section>
                    <div class="">
                        <c:forEach items="${listProducts}" var="p">    
                            <div class="cardAd row" style="max-width: 100%; height: 70px; padding:10px; border-bottom: 1px solid black;">                                 
                                <img src="${p.productImage}" style="object-fit: cover; max-height:50px; width: 50px; margin: 0 20px" />
                                <h5 class="col-lg-3 card-title" style="padding-top: 10px">${p.productName}</h5>
                                <a href="" class="col-lg-2 ">
                                    <p>${p.categoryName}</p>
                                </a>
                                <h6 class="col-lg-2 price">${p.unitPrice}</h6>
                                <div class="col-lg-4">
                                    <a href="detail?id=${p.productID}">
                                        <button>View</button>
                                    </a>                                   
                                    <button>Edit</button>
                                    <button>Delete</button>
                                </div>
                            </div>
                        </c:forEach>           
                    </div>
                </section>

                <!-- Pagination -->
                <nav aria-label="Page navigation example" class="d-flex justify-content-center mt-3">
                    <ul class="pagination">
                        <li class="page-item disabled">
                            <a class="page-link" href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li class="page-item active"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item"><a class="page-link" href="#">4</a></li>
                        <li class="page-item"><a class="page-link" href="#">5</a></li>
                        <li class="page-item">
                            <a class="page-link" href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>  
            </div>
        </main>
        <%@include file="layout/footer.jsp" %>
    </body>
</html>
