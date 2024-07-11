package controller.manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.AccountDAO;
import model.DAO.CategoryDAO;
import model.DAO.CustomerDAO;
import model.DAO.OrderDAO;
import model.DAO.ProductDAO;
import model.DAO.SupplierDAO;
import model.entity.Account;
import model.entity.Cart;
import model.entity.Customer;
import model.entity.Product;
import utils.CartUtil;

@WebServlet(name = "CreateController", urlPatterns = {"/create"})
public class CreateController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String option = request.getParameter("option");
        if 
            (option.equals("order")) 
        {
            OrderDAO orderDAO = new OrderDAO();
            CustomerDAO customerDAO = new CustomerDAO();
            HashMap<Integer, Cart> cart = null;
            String freight = request.getParameter("freight");
            Date currentDate = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(currentDate);
            cal.add(Calendar.DAY_OF_YEAR, 1);
            Date requiredDate = cal.getTime();

            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("user");
            cart = (HashMap<Integer, Cart>) session.getAttribute(a.getAccountID() + "_cart");
            if (cart != null) {
                Customer b = customerDAO.getCustomerInforByName(a.getFullName());
                int id = orderDAO.createOrder(b.getCustomerID(), currentDate, requiredDate, currentDate, Double.parseDouble(freight), b.getAddress());
                for (Cart c : cart.values()) {
                    orderDAO.createOrderDetail(id, c.getProductID(), c.getUnitPrice(), c.getQuantity());
                }
                cart = null;
                session.setAttribute(a.getAccountID() + "_cart", cart);
                session.removeAttribute(a.getAccountID() + "_cart");
                cart = (HashMap<Integer, Cart>) session.getAttribute(a.getAccountID() + "_cart");
                CartUtil cartUtil = new CartUtil();
                cartUtil.removeAllItemsFromCookie(request, response);
                request.setAttribute("message", cart);
                request.getRequestDispatcher("reviews").forward(request, response);
            } else {
                request.setAttribute("message", "Don't have products to create order.");
                request.getRequestDispatcher("viewCart").forward(request, response);
            }
        } 
        else if 
                (option.equals("orderDetail")) 
        {
            OrderDAO orderDAO = new OrderDAO();
            CustomerDAO customerDAO = new CustomerDAO();
            String cid = request.getParameter("customerID");
            String freight = request.getParameter("freight");
            if (cid != null && freight != null) {

                Customer cus = customerDAO.getCustomerInforByID(cid);

                ProductDAO productDAO = new ProductDAO();
                String[] itemIds = request.getParameterValues("item");
                String[] quantities = request.getParameterValues("quantity");
                if (itemIds != null && quantities != null) {
                    Date currentDate = new Date();
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(currentDate);
                    cal.add(Calendar.DAY_OF_YEAR, 1);
                    Date requiredDate = cal.getTime();
                    int oid = orderDAO.createOrder(cus.getCustomerID(), currentDate, requiredDate, currentDate, Double.parseDouble(freight), cus.getAddress());
                    for (int i = 0; i < itemIds.length; i++) {
                        int itemId = Integer.parseInt(itemIds[i]);
                        int quantity = Integer.parseInt(quantities[i]);
                        Product p = productDAO.getProductsById(itemIds[i]);
                        orderDAO.createOrderDetail(oid, itemId, p.getUnitPrice(), quantity);
                    }
                }
                response.sendRedirect("ordersAD");
            }
            response.sendRedirect("home");

        } else if 
                (option.equals("product")) 
        {
            String productName = request.getParameter("productName");
            String supplierName = request.getParameter("supplierName");
            String categoryName = request.getParameter("categoryName");
            String quantityPerUnit = request.getParameter("quantityPerUnit");
            double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
            String productImage = request.getParameter("productImage");

            ProductDAO productDAO = new ProductDAO();
            CategoryDAO categoryDAO = new CategoryDAO();
            SupplierDAO supplierDAO = new SupplierDAO();
            int categoryID = categoryDAO.getIDCategoryByName(categoryName);
            int supplierID = supplierDAO.getIDSupplierByName(supplierName);
            if (categoryID != 0 && supplierID != 0) {
                productDAO.createProducts(productName, supplierID, categoryID, quantityPerUnit, unitPrice, productImage);
                response.sendRedirect("home");
            }
            response.sendRedirect("view?option=product");
        } 
        else if 
                (option.equals("account")) 
        {
            String fullName = request.getParameter("fullName");
            String userName = request.getParameter("userName");
            String phone = request.getParameter("phone");
            String type = request.getParameter("type");
            String address = request.getParameter("address");
            String password = request.getParameter("password");
            CustomerDAO customerDAO = new CustomerDAO();
            AccountDAO accountDAO = new AccountDAO();
            if (address == null) {
                request.getRequestDispatcher("home").forward(request, response);
            }
            try {
                Account a = accountDAO.checkAccountExit(userName);
                if (a == null) {
                    customerDAO.createAccount(password, fullName, address, phone);
                    if ("1".equals(type)) {
                        accountDAO.createAccountAD(userName, password, fullName);
                    } else if ("2".equals(type)) {
                        accountDAO.createAccount(userName, password, fullName);
                    }
                    request.getRequestDispatcher("accountsAD").forward(request, response);
                } else {
                    request.setAttribute("error", "username is exits");
                    request.getRequestDispatcher("view?option=createAccount").forward(request, response);
                }
            } catch (Exception e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("view?option=createAccount").forward(request, response);
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
