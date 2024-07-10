package controller.manage.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.Account;
import model.entity.Cart;
import utils.CartUtil;

@WebServlet(name = "ViewCartController", urlPatterns = {"/viewCart"})
public class ViewCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Cart> cartValue = null;
        HashMap<Integer, Cart> cart = null;
        Cookie cookieCart = null;
        CartUtil cartUtils = new CartUtil();

        try {
            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("user");
            if (a != null) {
                cart = (HashMap<Integer, Cart>) session.getAttribute(a.getAccountID() + "_cart");
                if (cart == null) {
                    cookieCart = cartUtils.getCookieByName(request, "cart");
                    if (cookieCart != null) {
                        cart = cartUtils.getCartFromCookie(cookieCart);
                        if (cart != null) {
                            cartValue = new ArrayList<>(cart.values());
                            request.setAttribute("cartSize", cart.size());
                            session.setAttribute(a.getAccountID() + "_cart", cart);
                        }
                    } else {
                        request.setAttribute("cartSize", 0);
                    }
                } else {
                    request.setAttribute("cartSize", cart.size());
                    cartValue = new ArrayList<>(cart.values());
                }
            }
            request.setAttribute("cart", cartValue);
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            log("ViewCartController has error: " + e.getMessage());
        }
        
            request.getRequestDispatcher("views/cart.jsp").forward(request, response);
        
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
        return "View Cart Controller";
    }
}
