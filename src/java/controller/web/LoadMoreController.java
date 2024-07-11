/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.CategoryDAO;
import model.DAO.ProductDAO;
import model.entity.Account;
import model.entity.Category;
import model.entity.OrderDetail;
import model.entity.Product;

@WebServlet(name = "LoadMoreController", urlPatterns = {"/load"})
public class LoadMoreController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String count = request.getParameter("count"); 
        int count1 = Integer.parseInt(count);

        ProductDAO productDAO = new ProductDAO();
        List<Product> listP = productDAO.getLoadMoreProduct(count1);

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
            for (Product p : listP) {
                out.println("<div class=\"product col-lg-3 col-md-6 mb-4\">\n"
                        + "                    <div class=\"card\">                                 \n"
                        + "                        <img src=\"" + p.getProductImage() + "\" style=\"height: 200px; object-fit: cover;\" class=\"w-100\"/>\n"
                        + "                        <div class=\"card-body\" class=\"w-100\">\n"
                        + "                            <a href=\"\" class=\"text-reset\">\n"
                        + "                                <h5 class=\"card-title mb-2\">" + p.getProductName() + "</h5>\n"
                        + "                            </a>\n"
                        + "                            <a href=\"\" class=\"text-reset \">\n"
                        + "                                <p>" + p.getCategoryName() + "</p>\n"
                        + "                            </a>\n"
                        + "                            <h6 class=\"mb-3 price\">" + p.getUnitPrice() + "</h6>\n"
                        + "                        </div>\n"
                        + "                        <div>\n"
                        + "                            <a href=\"addCart?id=" + p.getProductID() + "\">Add to cart</a>\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                </div>");
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
