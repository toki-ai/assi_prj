package controller.manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.CustomerDAO;
import model.DAO.OrderDAO;
import model.entity.Account;
import model.entity.Cart;
import model.entity.Customer;
import utils.CartUtil;

@WebServlet(name = "CreateController", urlPatterns = {"/create"})
public class CreateController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String option = request.getParameter("option");
        if (option.equals("order")) {
            OrderDAO orderDAO = new OrderDAO();
            CustomerDAO customerDAO = new CustomerDAO();
            HashMap<Integer, Cart> cart = null;
            String freight = request.getParameter("freight");
            Date currentDate = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(currentDate);
            cal.add(Calendar.DAY_OF_YEAR, 1);
            Date requiredDate = cal.getTime();

            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("user");
            cart = (HashMap<Integer, Cart>) session.getAttribute(a.getAccountID() + "_cart");
            if (cart != null) {
                Customer b = customerDAO.getCustomerInforByName(a.getFullName());
                int id = orderDAO.createOrder(b.getCustomerID(), currentDate, requiredDate, currentDate, Double.parseDouble(freight), b.getAddress());
                for (Cart c : cart.values()) {
                    orderDAO.createOrderDetail(id, c.getProductID(), c.getUnitPrice(), c.getQuantity());
                }
                cart = null;
                session.setAttribute(a.getAccountID() + "_cart", cart);
                session.removeAttribute(a.getAccountID() + "_cart");
                cart = (HashMap<Integer, Cart>) session.getAttribute(a.getAccountID() + "_cart");
                CartUtil cartUtil = new CartUtil();
                cartUtil.removeAllItemsFromCookie(request, response);
                request.setAttribute("message", cart);
                request.getRequestDispatcher("reviews").forward(request, response);
            } else {
                request.setAttribute("message", "Don't have products to create order.");
                request.getRequestDispatcher("viewCart").forward(request, response);
            }
        }else if(option.equals("product")){
            
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
