package utils;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.OrderDetail;

public class CartUtil {

    public HashMap<Integer, OrderDetail> getCartFromCookie(Cookie cookieCart) {
        HashMap<Integer, OrderDetail> cart = new HashMap<>();
        String[] arrItemDetail;
        int orderID, productID, quantity;
        String productName;
        double unitPrice;
        OrderDetail item;
        Base64.Decoder base64Decoder = Base64.getDecoder();

        String encodedString = new String(base64Decoder.decode(cookieCart.getValue().getBytes()));
        String[] itemsList = encodedString.split("\\|");

        for (String strItem : itemsList) {
            arrItemDetail = strItem.split(",");
            orderID = Integer.parseInt(arrItemDetail[0].trim());
            productID = Integer.parseInt(arrItemDetail[1].trim());
            productName = arrItemDetail[2].trim();
            quantity = Integer.parseInt(arrItemDetail[3].trim());
            unitPrice = Double.parseDouble(arrItemDetail[4].trim());

            item = new OrderDetail(orderID, productID, productName, unitPrice, quantity);
            cart.put(orderID, item);
        }
        return cart;
    }

    public Cookie getCookieByName(HttpServletRequest request, String cookieName) {
        Cookie[] arrCookies = request.getCookies();
        if (arrCookies != null) {
            for (Cookie cookie : arrCookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    public void saveCartToCookie(HttpServletRequest request, HttpServletResponse response, String strItemsInCart) {
        String cookieName = "Cart";
        Cookie cookieCart = getCookieByName(request, cookieName);

        if (cookieCart != null) {
            cookieCart.setValue(strItemsInCart);
        } else {
            cookieCart = new Cookie(cookieName, strItemsInCart);
        }

        cookieCart.setMaxAge(43200);

        response.addCookie(cookieCart);
    }

    public String convertCartToString(List<OrderDetail> itemsList) {
        StringBuilder strItemsInCart = new StringBuilder();

        for (OrderDetail item : itemsList) {
            strItemsInCart.append(item.getOrderID()).append(",")
                    .append(item.getProductID()).append(",")
                    .append(item.getProductName()).append(",")
                    .append(item.getQuantity()).append(",")
                    .append(item.getUnitPrice()).append("|");
        }

        Base64.Encoder base64Encoder = Base64.getEncoder();
        String encodedString = base64Encoder.encodeToString(strItemsInCart.toString().getBytes());

        return encodedString;
    }
}
