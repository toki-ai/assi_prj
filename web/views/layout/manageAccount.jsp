<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark mt-3 mb-5 shadow p-2" style="background-color: orange">
    <!-- Container wrapper -->
    <div class="container-fluid">
        <h4>Type:</h4>
        <div class="collapse navbar-collapse" id="navbarSupportedContent2">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item acitve">
                    <a class="nav-link" style="${inputSearch != null || customerList != null ? "color: blue" : "color: white"}" href="accountsAD">User</a>
                </li>
                <li class="nav-item" >
                    <a class="nav-link" style="${inputSearch != null || customerList != null ? "color: white;" : "color: blue"}" 
                       href="accountsAD?option=staff">Staff</a>
                </li>
            </ul>
            <form action="searchAcc" class="w-auto py-1" style="margin-left: 100px; max-width: 12rem; display: flex">
                <input value="${inputSearch}" type="text" class="form-control rounded-0" placeholder="Search" name="inputSearch" aria-label="Search">
                <button type="submit">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </button>
            </form>

        </div>
    </div>
</nav>
<!-- Navbar -->

<!-- Products -->
<section>
    <div class="" style="min-height: 250px">
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Account ID</th>
                    <th scope="col">Fullname </th>
                    <th scope="col">Username</th>
                    <th scope="col">Password</th>
            <c:if test="${customerList != null}">
                <th scope="col">Phone</th>
                <th scope="col">Address</th>
            </c:if>
            <th scope="col">Option</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${customerList != null && accountList!= null}">
                <c:forEach var="account" items="${accountList}" varStatus="status">
                    <tr>
                        <td style="width: 150px">
                            <h6 class="card-title" style="padding-top: 10px">${account.accountID}</h6>
                        </td>
                        <td style="width: 150px">
                            <h6 class="card-title" style="padding-top: 10px">${account.fullName}</h6>
                        </td>
                        <td style="width: 150px">
                            <h6 class="card-title" style="padding-top: 10px">${account.userName}</h6>
                        </td>
                        <td style="width: 150px">
                            <h6 class="card-title" style="padding-top: 10px">${account.password}</h6>
                        </td>
                        <td style="width: 150px">
                            <h6 class="card-title" style="padding-top: 10px">${customerList[status.index].phone}</h6>
                        </td>
                        <td style="width: 150px">
                            <h6 class="card-title" style="padding-top: 10px">${customerList[status.index].address}</h6>
                        </td>
                        <td>
                            <a style="margin: 0 30px" href="detail?id=${p.productID}">
                                <i class="fa-solid fa-pen-to-square"></i>
                            </a> 
                            <a href="detail?id=${p.productID}">
                                <i style="color: red" class="fa-solid fa-trash"></i>
                            </a> 
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${customerList == null && accountList!= null}">
                <c:forEach var="account" items="${accountList}" varStatus="status">
                    <tr>
                        <td style="width: 150px">
                            <h6 class="card-title" style="padding-top: 10px">${account.accountID}</h6>
                        </td>
                        <td style="width: 150px">
                            <h6 class="card-title" style="padding-top: 10px">${account.fullName}</h6>
                        </td>
                        <td style="width: 150px">
                            <h6 class="card-title" style="padding-top: 10px">${account.userName}</h6>
                        </td>
                        <td style="width: 150px">
                            <h6 class="card-title" style="padding-top: 10px">${account.password}</h6>
                        </td>
                        <td style="width: 150px">
                            <h6 class="card-title" style="padding-top: 10px">${customerList[status.index].phone}</h6>
                        </td>
                        <td style="width: 150px">
                            <h6 class="card-title" style="padding-top: 10px">${customerList[status.index].address}</h6>
                        </td>
                        <td>
                            <a style="margin: 0 30px" href="detail?id=${p.productID}">
                                <i class="fa-solid fa-pen-to-square"></i>
                            </a> 
                            <a href="detail?id=${p.productID}">
                                <i style="color: red" class="fa-solid fa-trash"></i>
                            </a> 
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
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
