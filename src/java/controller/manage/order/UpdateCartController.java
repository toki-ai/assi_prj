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

@WebServlet(name = "UpdateCartController", urlPatterns = {"/updateCart"})
public class UpdateCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = null, itemId;
        int newQuantity;
        Cart item = null;
        HashMap<Integer, Cart> cart = null;
        try {
            itemId = request.getParameter("pid");
            newQuantity = Integer.parseInt(request.getParameter("quantity"));
            if (itemId != null) {
                newQuantity = newQuantity + 1;
            } else {
                itemId = request.getParameter("mid");
                newQuantity = newQuantity -1;
            }
            if (itemId != null) {
                HttpSession session = request.getSession();
                Account a = (Account) session.getAttribute("user");
                cart = (HashMap<Integer, Cart>) session.getAttribute(a.getAccountID() + "_cart");

                if (newQuantity == 0) {
                    request.getRequestDispatcher("removeCart?id=" + itemId).forward(request, response);
                    return;
                }

                item = cart.get(Integer.parseInt(itemId));
                item.setQuantity(newQuantity);
                session.setAttribute(a.getAccountID() + "_cart", cart);
                message = "Your cart has been updated successfully.";
                request.setAttribute("message", message);
            }
        } catch (Exception e) {
            log("UpdateCartController has error: " + e.getMessage());
            message = e.getMessage();
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
        return "Update Cart Controller";
    }
}
