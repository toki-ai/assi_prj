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

@WebServlet(name = "CategoryController", urlPatterns = {"/category"})
public class CategoryController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String mess = request.getParameter("message");
        if (mess != null) {
            request.setAttribute("message", mess);
        }
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("user");
        if (a != null) {
            HashMap<Integer, OrderDetail> cart = (HashMap<Integer, OrderDetail>) session.getAttribute(a.getAccountID() + "_cart");
            if (cart != null) {
                request.setAttribute("cartSize", cart.size());
            } else {
                request.setAttribute("cartSize", 0);
            }
        } else {
            request.setAttribute("cartSize", 0);
        }
        String pathParam = request.getParameter("id");
        ProductDAO productDAO = new ProductDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        
        List<Product> listP = productDAO.getProductsByCategory(pathParam); 
        List<Category> listC = categoryDAO.getAllCategory();
        
        request.setAttribute("listProducts", listP);
        request.setAttribute("listCategory", listC);
        request.setAttribute("pathParam", pathParam);
        request.getRequestDispatcher("views/homepage.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
