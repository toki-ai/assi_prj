<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Report</title>
        <%@include file="layout/fontAndIcon.jsp" %>
        <link rel="stylesheet" href="../assets/invoice.css"/>
    </head>
    <%@include file="layout/styleReport.jsp" %>
    <body>
        <%@include file="layout/nav.jsp" %>
        <div class="container1" style="margin-top: 100px">
            <div class="header">
                <input type="text" placeholder="Search Report">
                <div>
                    <input type="date" class="date-picker" />
                    <input type="date" class="date-picker" />
                    <button class="export-button">View Report</button>
                </div>
            </div>
            <div class="table-responsive">
                <table>
                    <thead>
                        <tr>
                            <th>DATE</th>
                            <th>NO. ORDERS</th>
                            <th>PRODUCTS SOLD</th>
                            <th>TAX</th>
                            <th>TOTAL</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Oct 25, 2024</td>
                            <td>14</td>
                            <td>19</td>
                            <td>$84.00</td>
                            <td>$558.00</td>
                        </tr>
                        <tr>
                            <td>Oct 25, 2024</td>
                            <td>11</td>
                            <td>13</td>
                            <td>$42.00</td>
                            <td>$280.00</td>
                        </tr>
                        <tr>
                            <td>Jun 20, 2024</td>
                            <td>19</td>
                            <td>24</td>
                            <td>$86.00</td>
                            <td>$572.00</td>
                        </tr>
                        <tr>
                            <td>Nov 10, 2024</td>
                            <td>2</td>
                            <td>5</td>
                            <td>$72.00</td>
                            <td>$478.00</td>
                        </tr>
                        <tr>
                            <td>Jun 24, 2024</td>
                            <td>16</td>
                            <td>18</td>
                            <td>$67.00</td>
                            <td>$448.00</td>
                        </tr>
                        <tr>
                            <td>Aug 19, 2024</td>
                            <td>8</td>
                            <td>12</td>
                            <td>$76.00</td>
                            <td>$508.00</td>
                        </tr>
                        <tr>
                            <td>Jun 24, 2024</td>
                            <td>20</td>
                            <td>22</td>
                            <td>$28.00</td>
                            <td>$189.00</td>
                        </tr>
                        <tr>
                            <td>Jun 24, 2024</td>
                            <td>3</td>
                            <td>8</td>
                            <td>$27.00</td>
                            <td>$178.00</td>
                        </tr>
                        <tr>
                            <td>Oct 25, 2024</td>
                            <td>17</td>
                            <td>19</td>
                            <td>$61.00</td>
                            <td>$406.00</td>
                        </tr>
                        <tr>
                            <td>Mar 10, 2024</td>
                            <td>19</td>
                            <td>24</td>
                            <td>$67.00</td>
                            <td>$446.00</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="pagination">
                <select>
                    <option>10</option>
                    <option>20</option>
                    <option>30</option>
                </select>
                <div class="page-number">
                    <a href="#">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                </div>
            </div>
        </div>
        <%@include file="layout/footer.jsp" %>
    </body>
</html>

