package controller.manage.account;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.CustomerDAO;
import model.entity.Account;
import model.entity.Customer;

/**
 *
 * @author toki
 */
@WebServlet(name = "ViewProfileController", urlPatterns = {"/infor"})
public class ViewProfileController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
        String option = request.getParameter("option");
        if (option != null && option.equals("edit")) {

        } else {
            request.setAttribute("readonly", "readonly");
        }
        request.getRequestDispatcher("views/profile.jsp").forward(request, response);
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
