/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.AccountDAO;
import model.DAO.CategoryDAO;
import model.DAO.CustomerDAO;
import model.DAO.ProductDAO;
import model.DAO.SupplierDAO;
import model.entity.Account;
import model.entity.Category;
import model.entity.Customer;
import model.entity.Product;
import model.entity.Supplier;

/**
 *
 * @author toki
 */
@WebServlet(name = "RedirectController", urlPatterns = {"/view"})
public class RedirectController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String option = request.getParameter("option");
        if ("editProfile".equals(option)) {
            CustomerDAO customerDAO = new CustomerDAO();
            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("user");
            Customer b = customerDAO.getCustomerInforByName(a.getFullName());
            request.setAttribute("account", a);
            request.setAttribute("customer", b);
            if (a == null) {
                response.sendRedirect("views/login.jsp");
                return;
            }
            if (b == null) {
                request.setAttribute("error", "Customer information not found.");
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
                return;
            }
            request.setAttribute("account", a);
            request.setAttribute("customer", b);
            String phone = b.getPhone();
            if (phone != null && phone.startsWith("555-")) {
                phone = phone.substring(4);
            }
            request.setAttribute("phone", phone);
            request.getRequestDispatcher("views/profile.jsp").forward(request, response);
        }
        else if ("editAccount".equals(option)) {
            AccountDAO accountDAO = new AccountDAO();
            CustomerDAO customerDAO = new CustomerDAO();
            String aid = request.getParameter("aid");
            Account a = accountDAO.getAccountByID(aid);
            Customer b = customerDAO.getCustomerInforByName(a.getFullName());
            request.setAttribute("account", a);
            request.setAttribute("customer", b);
            String phone = b.getPhone();
            if (phone != null && phone.startsWith("555-")) {
                phone = phone.substring(4);
            }
            request.setAttribute("phone", phone);
            request.getRequestDispatcher("views/editAccount.jsp").forward(request, response);
        }
        else if("createProduct".equals(option)) {
            CategoryDAO categoryDAO = new CategoryDAO();
            List<Category> listC = categoryDAO.getAllCategory();
            request.setAttribute("listCategory", listC);
            SupplierDAO supplierDAO = new SupplierDAO();
            List<Supplier> listS = supplierDAO.getAllSupplier();
            request.setAttribute("listSupplier", listS);
            request.getRequestDispatcher("views/createProduct.jsp").forward(request, response);
        }
        else if("createAccount".equals(option)) {
            request.getRequestDispatcher("views/createAccount.jsp").forward(request, response);
        }
        else if("createOrder".equals(option)){
            ProductDAO productDAO = new ProductDAO();
            CustomerDAO customerDAO = new CustomerDAO();
            List<Customer> customers = customerDAO.getAllCustomer();
            List<Product> products = productDAO.getAllProducts();
            request.setAttribute("products", products);
            request.setAttribute("customers", customers);
            request.getRequestDispatcher("views/createOrder.jsp").forward(request, response);
        }
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
