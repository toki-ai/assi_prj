package controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.AccountDAO;
import model.DAO.CustomerDAO;
import model.entity.Account;

@WebServlet(name = "SignUpController", urlPatterns = {"/signup"})
public class SignUpController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String re_password = request.getParameter("re_password");
        if (username != "" && fullname != "" && address != "" && phone != "" && password != "" && re_password != "") {
            if (!password.equals(re_password)) {
                request.setAttribute("message", "Re password are uncorrect.");
                request.getRequestDispatcher("views/signup.jsp").forward(request, response);
            } else {
                AccountDAO accountDAO = new AccountDAO();
                Account a = accountDAO.checkAccountExit(username);
                if (a == null) {
                    accountDAO.createAccount(username, password, fullname);
                    CustomerDAO customerDAO = new CustomerDAO(); 
                    customerDAO.createAccount(password, fullname, address, phone);
                    response.sendRedirect("login");
                } else {
                    request.setAttribute("message", "Username are exits.");
                    request.getRequestDispatcher("views/signup.jsp").forward(request, response);
                }
            }
        }else{
            request.setAttribute("message", "Fill all value.");
            request.getRequestDispatcher("views/signup.jsp").forward(request, response);
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
