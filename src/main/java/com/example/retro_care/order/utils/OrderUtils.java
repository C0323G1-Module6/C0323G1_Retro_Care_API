package com.example.retro_care.order.utils;

import com.example.retro_care.order.projection.CartProjection;
import java.text.NumberFormat;
import java.util.Locale;

import java.util.List;

public class OrderUtils {

    public static String generateHTMLForMail(List<CartProjection> carts, Long totalPrice) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        double fixedPrice = 0;


        StringBuilder html = new StringBuilder(
                "<p>Cảm ơn bạn vì đã tin tưởng và lựa chọn sản phẩm tại công ty chúng tôi. Chúng tôi chân thành cảm ơn bạn và hy vọng sẽ gặp lại bạn vào một ngày sớm nhất! <p>"+
                        "<div style='padding: 10px'>" +
                        "      <table style='width: 100%'>" +
                        "        <tr style='width: 100%'>" +
                        "          <td style='width: 50%'>" +
                        "            <label style='font-size: 40px; font-weight: bold'>" +
                        "              INVOICE-001-PUT CODE ORDER HERE" +
                        "</label>" +
                        "          </td>" +
                        "          <td style='width: 50%; text-align: right'>" +
                        "<h1 style='font-size: 40px; font-weight: bold; color:blue'>RetroCare</h1>" +
                        "          </td>" +
                        "        </tr>" +
                        "      </table>" +
                        "      <table style='width: 100%; margin: 10px 0px'>" +
                        "        <tr style='width: 100%'>" +
                        "          <td style='width: 33%; line-height: 25px'>" +
                        "            <label>From:</label><br />" +
                        "            <label style='font-weight: bold; font-size: 20px'>RetroCare</label>" +
                        "            <br />" +
                        "            C0323G1<br />" +
                        "          </td>" +
                        "          <td style='width: 33%; line-height: 25px>'" +
                        "            <label>To:</label><br />" +
                        "            <label style='font-weight: bold; font-size: 20px'>" + carts.get(0).getCustomerName() +"</label><br >" +
                        "            <label style='font-weight: bold; font-size: 20px'>" + carts.get(0).getAddress() +"</label><br >" +
                        "          </td>" +
                        "          <td style='width: 33%; margin: auto'>" +
                        "            <span style='background: #e1e1e1;" +
                        "                font-size: 30px;" +
                        "                font-weight: bold;" +
                        "                padding: 10px;" +
                        "                color: #343a40'>" +
                        "              Đã thanh toán</span>" +
                        "          </td>" +
                        "        </tr>" +
                        "      </table>" +
                        "      <table style='width: 100%'>" +
                        "        <tr style='background: #398bdc; color: white'>" +
                        "          <th style='padding: 10px'>Sản phẩm</th>" +
                        "          <th>Tên sản phẩm</th>" +
                        "          <th>Giá tiền(VND)</th>" +
                        "          <th>Số lượng</th>" +
                        "          <th>Thành tiền</th>" +
                        "        </tr>");
        for (CartProjection cart : carts) {
            String name = cart.getMedicineName();
            String image = cart.getMedicineImage();
            Double price = cart.getMedicinePrice();
            Integer quantity = cart.getQuantityInCart();
            Double totalProductPrice = price * quantity;
            fixedPrice += totalProductPrice;
            html.append(String.format("<tr>" +
                    "<td style='text-align:center' ><img src='%s' style='width:50px; height:50px' alt='%s'></td>" +
                    "<td style='text-align:center'>%s</td>" +
                    "<td style='text-align:center'>%s VND</td>" +
                    "<td style='text-align:center'>%d</td>" +
                    "<td style='text-align:center'>s VND</td>" +
                    "</tr>", image, name,name,numberFormat.format(price) , quantity, numberFormat.format(totalProductPrice)));
        }
        double discount = fixedPrice - totalPrice;
        String formattedFixedPrice = numberFormat.format(fixedPrice);
        String formattedDiscount = numberFormat.format(discount);
        String formattedTotalPrice = numberFormat.format(totalPrice);

        html.append(String.format(
                "<tr><td colspan='4'><h3>Tạm tính:<h3></td><td style='text-align:center'><h3>%s VND<h3></td></tr>" +
                        "<tr><td colspan='4'><h3>Giảm giá:<h3></td><td style='text-align:center'><h3>%s VND<h3></td></tr>" +
                        "<tr><td colspan='4'><h3>Thành tiền:<h3></td><td style='text-align:center'><h3>%s VND<h3></td></tr>" +
                "<tr><hr></tr>" +
                "<tr><td colspan='4'>Hình thức vận chuyển:</td><td><h4 style='text-align:center'>Giao hàng tiêu chuẩn</h4></td></tr>" +
                "<tr><td colspan='4'>Hình thức thanh toán:</td><td><h4 style='text-align:center'>PAYPAL</h4></td></tr>" +
                "</table>", formattedFixedPrice, formattedDiscount, formattedTotalPrice));
        html.append("<p>Nếu bạn cần thêm thông tin, vui lòng liên hệ hotline 1900-77-77-77 để được hỗ trợ. RetroCare xin cảm ơn!</p>" +
                "<p>Đội ngũ RetroCare!</p>" +
                "<small>(Đây là email tự động, vui lòng không trả lời email này)</small>");
        return html.toString();
    }
}
