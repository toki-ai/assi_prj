<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark mt-3 mb-5 shadow p-2" style="background-color: orange">
    <div class="container-fluid">
        <h4>Categories:</h4>
        <div class="collapse navbar-collapse" id="navbarSupportedContent2">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item acitve">
                    <a class="nav-link" style="${pathParam != null ? "color: white" : "color: blue"}" href="home">All</a>
                </li>
                <c:forEach items="${listCategory}" var="c">
                    <li class="nav-item" >
                        <a class="nav-link" style="${pathParam == c.categoryID ? "color: blue;" : "color: white"}" href="category?id=${c.categoryID}">${c.categoryName}</a>
                    </li>
                </c:forEach>
            </ul>
            <!-- Search -->
            <form action="search" class="w-auto py-1" style="margin-left: 100px; max-width: 12rem; display: flex">
                <input value="${inputSearch}" type="text" class="form-control rounded-0" placeholder="Search" name="inputSearch" aria-label="Search">
                <button type="submit">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </button>
            </form>                        
        </div>
    </div>
</nav>

<!-- Products -->
<section>
    <div class="text-center">
        <div class="row" id="content">
            <c:forEach items="${listProducts}" var="p">
                <div class="product col-lg-3 col-md-6 mb-4">
                    <div class="card">                                 
                        <img src="${p.productImage}" style="height: 200px; object-fit: cover;" class="w-100"/>
                        <div class="card-body" class="w-100">
                            <a href="" class="text-reset">
                                <h5 class="card-title mb-2">${p.productName}</h5>
                            </a>
                            <a href="" class="text-reset ">
                                <p>${p.categoryName}</p>
                            </a>
                            <h6 class="mb-3 price">${p.unitPrice}</h6>
                        </div>
                        <div>
                            <a href="addCart?id=${p.productID}">Add to cart</a>
                        </div>
                    </div>
                </div>
            </c:forEach>           
        </div>
    </div>
</section>
