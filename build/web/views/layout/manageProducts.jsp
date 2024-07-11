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

            <form action="search" class="w-auto py-1" style="margin-left: 100px; max-width: 12rem; display: flex">
                <input value="${inputSearch}" type="text" class="form-control rounded-0" placeholder="Search" name="inputSearch" aria-label="Search">
                <button type="submit">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </button>
            </form>
                <div style="margin-left: 200px; color: white; cursor: pointer">
                    <i class="fa-solid fa-plus"></i>
                    <a style="color: white; text-decoration: none" href="view?option=createProduct">Add products</a>
                </div>
        </div>
    </div>
</nav>
<!-- Navbar -->

<!-- Products -->
<section>
    <div class="">
        <table class="table" >
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Image</th>
                    <th scope="col">Product Name</th>
                    <th scope="col">UnitPrice</th>
                    <th scope="col">Option</th>
                </tr>
            </thead>
            <tbody id="content">
            <c:forEach items="${listProducts}" var="p">    
                <tr class="product">
                    <th scope="row" style="width: 100px">${p.productID}</th>
                    <td style="width: 150px">
                        <img src="${p.productImage}" style="object-fit: cover; max-height:50px; width: 50px;" />
                    </td>
                    <td>
                        <h6 class="card-title" style="padding-top: 10px">${p.productName}</h6>
                    </td>
                    <td>
                        <h6 class="col-lg-2 price">${p.unitPrice}</h6>
                    </td>
                    <td>
                        <a style="margin: 0 30px" href="detail?id=${p.productID}">
                            <i class="fa-solid fa-pen-to-square"></i>
                        </a> 
                        <a href="delete?option=product&pid=${p.productID}" onclick="return confirmDelete()">
                            <i style="color: red" class="fa-solid fa-trash"></i>
                        </a> 
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>

