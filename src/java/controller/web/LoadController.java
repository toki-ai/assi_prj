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

@WebServlet(name = "LoadController", urlPatterns = {"/home"})
public class LoadController extends HttpServlet {

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
        ProductDAO productDAO = new ProductDAO();
        CategoryDAO categoryDAO = new CategoryDAO();

        List<Product> listP = productDAO.getAllProducts();
        List<Category> listC = categoryDAO.getAllCategory();

        request.setAttribute("listProducts", listP);
        request.setAttribute("listCategory", listC);
        request.getRequestDispatcher("views/homepage.jsp").forward(request, response);
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
