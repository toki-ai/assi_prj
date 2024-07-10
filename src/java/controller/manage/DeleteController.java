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
import model.DAO.CustomerDAO;
import model.DAO.OrderDAO;
import model.DAO.ProductDAO;
import model.entity.Account;
import model.entity.Customer;
import model.entity.Order;

@WebServlet(name = "DeleteController", urlPatterns = {"/delete"})
public class DeleteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String option = request.getParameter("option");
        if (option.equals("order")) {
            String oid = request.getParameter("oid");
            if (oid != null) {
                OrderDAO orderDAO = new OrderDAO();
                orderDAO.deleteOrderDetail(oid);
                orderDAO.deleteOrder(oid);
                HttpSession session = request.getSession();
                int role = (int) session.getAttribute("role");
                if (role == 1) {
                    response.sendRedirect("ordersAD");
                } else if (role == 2) {
                    response.sendRedirect("reviews");
                }

            }
        } else if (option.equals("product")) {
            String pid = request.getParameter("pid");
            if (pid != null) {
                ProductDAO productDAO = new ProductDAO();
                productDAO.deleteProduct(pid);
                response.sendRedirect("home");
            }
        } else if (option.equals("account")) {
            AccountDAO accountDAO = new AccountDAO();
            CustomerDAO customerDAO = new CustomerDAO();
            String aid = request.getParameter("aid");
            Account a = accountDAO.getAccountByID(aid);
            Customer cus = customerDAO.getCustomerInforByName(a.getFullName());
            String cid = String.valueOf(cus.getCustomerID());
            if (aid != null) {
                accountDAO.deleteAccount(aid);
            }
            if (cid != null) {
                OrderDAO orderDAO = new OrderDAO();
                int cusID = Integer.parseInt(cid);
                customerDAO.deleteCustomer(cusID);
                List<Order> list = orderDAO.getOrderByUserID(cusID);
                for (Order o : list) {
                    String oid = Integer.toString(o.getOrderID());
                    orderDAO.deleteOrderDetail(oid);
                    orderDAO.deleteOrder(oid);
                }
            }
            HttpSession session = request.getSession();
            int role = (int) session.getAttribute("role");
            if (role == 1) {
                response.sendRedirect("accountsAD");
            } else if (role == 2) {
                session.removeAttribute("user");
                session.removeAttribute("role");
                response.sendRedirect("home");
            }
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
