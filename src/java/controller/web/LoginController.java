/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.homepage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.AccountDAO;
import model.entity.Account;

/**
 *
 * @author toki
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        Cookie array[] = request.getCookies();
        if (array != null) {
            for (Cookie o : array) {
                if (o.getName().equals("userC")) {
                    request.setAttribute("userC", o.getValue());
                }
                if (o.getName().equals("passC")) {
                    request.setAttribute("passC", o.getValue());
                }
            }
        }
        request.getRequestDispatcher("views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checked = request.getParameter("checkRemember");
        AccountDAO accountDAO = new AccountDAO();
        Account acc = accountDAO.getAccountByUsernameAndPassword(username, password);
        if (acc == null) {
            request.setAttribute("message", "Login failed.");
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(3600);
            session.setAttribute("user", acc);
            session.setAttribute("role", acc.getType());
            Cookie userC = new Cookie("userC", username);
            Cookie passC = new Cookie("passC", password);
            if (checked != null) {
                passC.setMaxAge(86400); //1 ngày
            } else {
                passC.setMaxAge(0);
            }
            userC.setMaxAge(86400);
            response.addCookie(userC);
            response.addCookie(passC);
            response.sendRedirect("home");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
