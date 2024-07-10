<%-- 
    Document   : product
    Created on : Jul 10, 2024, 2:54:23 PM
    Author     : toki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>   
        <%@include file="layout/fontAndIcon.jsp" %>
    </head>
    <%@include file="layout/styleProduct.jsp" %>
    <body>
        <%@include file="layout/nav.jsp" %>
        <h1 style='margin-top: 80px; text-align: center; font-family: "Josefin Sans", sans-serif; font-weight: 600; padding-top: 10px; color:orange; text-shadow: 1px 1px 2px #ffffff;'>
            Add Products
        </h1>
        <div class="container1">
            <form action="create?option=product" method="POST">
                <div class="image-upload">
                    <label for="file-input">
                        <img id="preview-image" src="placeholder-image.png" alt="Upload Image">
                    </label>
                    <input id="file-input" type="file" style="display: none;" />
                </div>
                <div class="form-group">
                    <label for="image-url">Image URL</label>
                    <input type="text" id="image-url" name="productImage" placeholder="Enter image URL">
                </div>
                <div class="row" style='width: 100%'>
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12" style=''>
                        <div class="form-group">
                            <label for="productName">Product name</label>
                            <input type="text" class="form-control" 
                                   name="productName"
                                   >
                        </div>
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12" style=''>
                        <div class="form-group">
                            <label for="quantityPerUnit">Quantity Per Unit</label>
                            <input type="text" class="form-control" 
                                   name="quantityPerUnit"
                                   >
                        </div>
                    </div>
                    <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col-12" style=''>
                        <label for="categoryName">Category</label>
                        <select id="categoryName" name="categoryName" style='width: 95%; padding: 5px;'>
                            <c:forEach items="${listCategory}" var="c">
                                <option value="${c.categoryName}">${c.categoryName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col-12" style=''>
                        <label for="supplierName">Supplier</label>
                        <select id="supplierName" name="supplierName" style='width: 95%; padding: 5px;'>
                            <c:forEach items="${listSupplier}" var="s">
                                <option value="${s.companyName}">${s.companyName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12" style=''>
                        <div class="form-group">
                            <label for="unitPrice">Unit Price</label>
                            <input type="number" id="unitPrice" name="unitPrice" step="0.01" min="0"  class="form-control"
                                   >
                        </div>
                    </div>
                </div>        
                <div class="form-buttons">
                    <button type="submit" class="save-button">SAVE</button>
                    <button type="button" class="cancel-button" onclick="cancelAction()">CANCEL</button>
                </div>
            </form>
        </div>
        <script>
            document.getElementById('image-url').addEventListener('input', function () {
                var imageUrl = this.value;
                var previewImage = document.getElementById('preview-image');
                previewImage.src = imageUrl;
            });
            function cancelAction() {
                if (confirm("Are you sure you want to cancel and go back to the view page?")) {
                    window.location.href = 'home';
                }
            }
        </script>
    </body>
</html>
