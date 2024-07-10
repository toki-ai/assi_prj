/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.manage.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.CustomerDAO;
import model.DAO.OrderDAO;
import model.entity.Customer;
import model.entity.Order;
import model.entity.OrderDetail;

@WebServlet(name = "ViewOrderADController", urlPatterns = {"/ordersAD"})
public class ViewOrderADController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String params = request.getParameter("oid");
                OrderDAO orderDAO = new OrderDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        HttpSession session = request.getSession();
        if (params == null) {
            List<Order> listorder = orderDAO.getAllOrder();
            if (listorder.isEmpty()) {
                response.sendRedirect("home");
            } else {
                request.setAttribute("listOrders", listorder);
                Date currentDate = new Date();
                request.setAttribute("currentDate", currentDate);
                request.getRequestDispatcher("views/review.jsp").forward(request, response);
            }
        } else {
            String cid = request.getParameter("cid");
            List<OrderDetail> listD = orderDAO.getOrderDetailOrderID(params);
            Customer customer = customerDAO.getCustomerInforByID(cid); 
            Order order = orderDAO.getOrderByID(params);
            request.setAttribute("customer", customer);
            request.setAttribute("order", order);
            request.setAttribute("listDetail", listD);
            Date currentDate = new Date();
            request.setAttribute("currentDate", currentDate);
            request.getRequestDispatcher("views/invoice.jsp").forward(request, response);
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
