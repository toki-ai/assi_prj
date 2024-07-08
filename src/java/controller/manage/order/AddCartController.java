package controller.manage.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.ProductDAO;
import model.entity.Account;
import model.entity.OrderDetail;
import model.entity.Product;
import utils.CartUtil;

@WebServlet(name = "AddCartController", urlPatterns = {"/addCart"})
public class AddCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String productID = request.getParameter("pid");
        String message = null;
        HashMap<Integer, OrderDetail> innerCart = null;
        ProductDAO productDAO = new ProductDAO();
        CartUtil cartUtil = new CartUtil();
        
        try {
            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("user");
            innerCart = (HashMap<Integer, OrderDetail>) session.getAttribute(a.getAccountID() + "_cart");
            if (innerCart == null) {
                innerCart = new HashMap<Integer, OrderDetail>();
                session.setAttribute(a.getAccountID() + "_cart", innerCart);
            }

            int pid = Integer.parseInt(productID);
            OrderDetail currentItem = innerCart.get(pid);
            if (currentItem == null) {
                Product selectProduct = productDAO.getProductsById(productID);
                OrderDetail newOrder = new OrderDetail(1, selectProduct.getProductID(), selectProduct.getProductName(), selectProduct.getUnitPrice(), 1);
                innerCart.put(selectProduct.getProductID(), newOrder);
                message = "Added to cart successfully";
            } else {
                currentItem.setQuantity(currentItem.getQuantity() + 1);
                message = "Updated cart successfully";
            }
            session.setAttribute(a.getAccountID() + "_cart", innerCart);
            List<OrderDetail> orderDetailsList = new ArrayList<>(innerCart.values());
            String strItemsInCart = cartUtil.convertCartToString(orderDetailsList);
            cartUtil.saveCartToCookie(request, response, strItemsInCart);
        } catch (NumberFormatException e) {
            message = e.getMessage();
        } catch (Exception e) {
            message = e.getMessage();
        }
        request.setAttribute("message", message);
        request.getRequestDispatcher("home").forward(request, response);
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
