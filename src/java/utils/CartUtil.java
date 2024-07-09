package utils;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.Cart;

public class CartUtil {

    public HashMap<Integer, Cart> getCartFromCookie(Cookie cookieCart) {
        HashMap<Integer, Cart> cart = new HashMap<>();
        String[] arrItemDetail;
        int productID, quantity;
        String productName, productImage, categoryName;
        double unitPrice;
        Cart item;
        Base64.Decoder base64Decoder = Base64.getDecoder();

        String encodedString = new String(base64Decoder.decode(cookieCart.getValue().getBytes()));
        String[] itemsList = encodedString.split("\\|");

        for (String strItem : itemsList) {
            arrItemDetail = strItem.split(",");
            productID = Integer.parseInt(arrItemDetail[0].trim());
            productName = arrItemDetail[1].trim();
            productImage = arrItemDetail[2].trim();
            categoryName = arrItemDetail[3].trim();
            unitPrice = Double.parseDouble(arrItemDetail[4].trim());
            quantity = Integer.parseInt(arrItemDetail[5].trim());

            item = new Cart(productID, productName, productImage, categoryName, unitPrice, quantity);
            cart.put(productID, item);
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
        String cookieName = "cart";
        Cookie cookieCart = getCookieByName(request, cookieName);

        if (cookieCart != null) {
            cookieCart.setValue(strItemsInCart);
        } else {
            cookieCart = new Cookie(cookieName, strItemsInCart);
        }

        cookieCart.setMaxAge(43200);
        response.addCookie(cookieCart);
    }

    public String convertCartToString(List<Cart> itemsList) {
        StringBuilder strItemsInCart = new StringBuilder();

        for (Cart item : itemsList) {
            strItemsInCart.append(item.getProductID()).append(",")
                    .append(item.getProductName()).append(",")
                    .append(item.getProductImage()).append(",")
                    .append(item.getCategoryName()).append(",")
                    .append(item.getUnitPrice()).append(",")
                    .append(item.getQuantity()).append("|");
        }

        Base64.Encoder base64Encoder = Base64.getEncoder();
        return base64Encoder.encodeToString(strItemsInCart.toString().getBytes());
    }
}
