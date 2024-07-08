package controller.homepage;

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
import model.entity.OrderDetail;
import utils.CartUtil;

@WebServlet(name = "ViewCartController", urlPatterns = {"/viewCart"})
public class ViewCartController extends HttpServlet {

    private final String viewCartPage = "views/cart.jsp"; // Change this to your cart view page

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = viewCartPage;
        List<OrderDetail> itemsInCart = null;
        HashMap<Integer, OrderDetail> cart = null;
        Cookie cookieCart = null;
        try {
            CartUtil cartUtils = new CartUtil();
            HttpSession sessionCart = request.getSession();
            cart = (HashMap<Integer, OrderDetail>) sessionCart.getAttribute("Cart");
            if (cart == null) {
                cookieCart = cartUtils.getCookieByName(request, "Cart");
                if (cookieCart != null) {
                    cart = cartUtils.getCartFromCookie(cookieCart);
                    if (cart != null) {
                        itemsInCart = new ArrayList<>(cart.values());
                        sessionCart.setAttribute("Cart", cart);
                    }
                }
            } else {
                itemsInCart = new ArrayList<>(cart.values());
            }
            request.setAttribute("Cart", itemsInCart);
        } catch (Exception e) {
            log("ViewCartController has error: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
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
