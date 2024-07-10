package controller.manage.order;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.Account;
import model.entity.Cart;
import utils.CartUtil;

@WebServlet(name = "RemoveCartController", urlPatterns = {"/removeCart"})
public class RemoveCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String itemId = null;
        String message = null;
        HashMap<Integer, Cart> cart = null;
        try {
            itemId = request.getParameter("id");
            if (itemId != null) {
                HttpSession session = request.getSession();
                Account a = (Account) session.getAttribute("user");
                cart = (HashMap<Integer, Cart>) session.getAttribute(a.getAccountID() + "_cart");
                cart.remove(Integer.parseInt(itemId));
                
                CartUtil cartUtil = new CartUtil();
                cartUtil.removeItemFromCookie(request, response, Integer.parseInt(itemId));
                
                message = "Removed successfully.";
                session.setAttribute(a.getAccountID() + "_cart", cart);
            }
        } catch (Exception e) {
            message = e.getMessage();
            log("RemoveCartController has error: " + e.getMessage());
        }       
        request.setAttribute("message", message);
        request.getRequestDispatcher("viewCart").forward(request, response);
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
