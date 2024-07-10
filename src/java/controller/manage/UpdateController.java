package controller.manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.AccountDAO;
import model.DAO.CustomerDAO;
import model.entity.Account;
import model.entity.Customer;
import model.entity.OrderDetail;

@WebServlet(name = "UpdateController", urlPatterns = {"/update"})
public class UpdateController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String option = request.getParameter("option");
        CustomerDAO customerDAO = new CustomerDAO();
        AccountDAO accountDAO = new AccountDAO();

        if (option.equals("order")) {
//            HttpSession session = request.getSession();
//            Account a = (Account) session.getAttribute("user");
//            Customer b = customerDAO.getCustomerInforByName(a.getFullName());
//            if (a != null) {
//                HashMap<Integer, OrderDetail> cart = (HashMap<Integer, OrderDetail>) session.getAttribute(a.getAccountID() + "_cart");
//                if (cart != null) {
//                    request.setAttribute("cartSize", cart.size());
//                } else {
//                    request.setAttribute("cartSize", 0);
//                }
//            } else {accountID
//                request.setAttribute("cartSize", 0);
//            }
//            request.setAttribute("account", a);
//            request.setAttribute("cusomer", b);
//            request.getRequestDispatcher("views/editOrderDetail.jsp").forward(request, response);
        } else if (option.equals("profile")) {
            String accountID = request.getParameter("accountID");
            String customerID = request.getParameter("customerID");
            String fullName = request.getParameter("fullName");
            String userName = request.getParameter("userName");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String password = request.getParameter("password");
            String rePassword = request.getParameter("re-password");

            if (!password.equals(rePassword)) {
                request.setAttribute("error", "Passwords do not match!");
                request.getRequestDispatcher("view?option=profile").forward(request, response);
                return;
            }
            try {
                accountDAO.updateAccountInfo(accountID, userName, password, fullName, 2);
                customerDAO.updateCustomerInfor(customerID, password, fullName, address, phone);
                request.getRequestDispatcher("infor").forward(request, response);
            } catch (Exception e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("view?option=profile").forward(request, response);
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
