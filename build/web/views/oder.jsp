<%@ page import="java.sql.*, java.util.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("userID") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    int userType = (int) session.getAttribute("userType");
    int userID = (int) session.getAttribute("userID");

    String sql = userType == 1 ? "SELECT * FROM Orders" : "SELECT * FROM Orders WHERE CustomerID = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        if (userType != 1) {
            stmt.setInt(1, userID);
        }

        ResultSet rs = stmt.executeQuery();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Order Management</title>
</head>
<body>
    <h1>Order Management</h1>
    <table border="1">
        <tr>
            <th>Order ID</th>
            <th>Customer ID</th>
            <th>Order Date</th>
            <th>Required Date</th>
            <th>Shipped Date</th>
            <th>Freight</th>
            <th>Ship Address</th>
            <th>Actions</th>
        </tr>
        <%
        while (rs.next()) {
            int orderID = rs.getInt("OrderID");
            int customerID = rs.getInt("CustomerID");
            String orderDate = rs.getDate("OrderDate").toString();
            String requiredDate = rs.getDate("RequiredDate").toString();
            String shippedDate = rs.getDate("ShippedDate").toString();
            float freight = rs.getFloat("Freight");
            String shipAddress = rs.getString("ShipAddress");
        %>
        <tr>
            <td><%= orderID %></td>
            <td><%= customerID %></td>
            <td><%= orderDate %></td>
            <td><%= requiredDate %></td>
            <td><%= shippedDate %></td>
            <td><%= freight %></td>
            <td><%= shipAddress %></td>
            <td>
                <form action="orders" method="post" style="display:inline;">
                    <input type="hidden" name="_method" value="put">
                    <input type="hidden" name="orderID" value="<%= orderID %>">
                    <input type="hidden" name="customerID" value="<%= customerID %>">
                    <button type="submit">Update</button>
                </form>
                <form action="orders" method="post" style="display:inline;">
                    <input type="hidden" name="_method" value="delete">
                    <input type="hidden" name="orderID" value="<%= orderID %>">
                    <input type="hidden" name="customerID" value="<%= customerID %>">
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
        <%
        }
        %>
    </table>
    <br>
    <a href="orderForm.jsp">Create New Order</a>
</body>
</html>
