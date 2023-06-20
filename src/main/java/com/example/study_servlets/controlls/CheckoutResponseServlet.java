package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/CheckoutResponseServlet")
public class CheckoutResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PrintWriter printWriter = response.getWriter();

            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>Document</title>\r\n" + //
                    "</head>\r\n" + //
                    "<body>\r\n" + //
                    "    <h2>Billing Address</h2>\r\n" + //
                    "\r\n" + //
                    "    <div>\r\n" + //
                    "        <form action=\"CheckoutResponseServlet\">\r\n" + //
                    "            <div>\r\n" + //
                    "                First name <input type=\"text\" name=\"firstname\" >\r\n" + // 
                    "            </div>\r\n" + //
                    "            <br>\r\n" + //
                    "            <div>\r\n" + //
                    "                Last name <input type=\"text\" name=\"lastname\" >\r\n" + //
                    "            </div>\r\n" + //
                    "            <br>\r\n" + //
                    "            <div>\r\n" + //
                    "                Username <input type=\"text\" name=\"username\" placeholder=\"Username\" >\r\n" + //
                    "            </div>\r\n" + //
                    "            <br>\r\n" + //
                    "            <div>\r\n" + //
                    "                Email (Optional) <input type=\"email\" name=\"email\" placeholder=\"hyuntak@snu.ac.kr\">\r\n" + //
                    "            </div>\r\n" + //
                    "            <br>\r\n" + //
                    "            <div>\r\n" + //
                    "                Address <input type=\"text\" name=\"address\" placeholder=\"Mapo-gu, Seoul\">\r\n" + //
                    "            </div>\r\n" + //
                    "            <br>\r\n" + //
                    "            <div>\r\n" + //
                    "                Address 2 (Optional) <input type=\"text\" name=\"address2\" placeholder=\"1234 Apartment\">\r\n" + //
                    "            </div>\r\n" + //
                    "            <br>\r\n" + //
                    "            <div>\r\n" + //
                    "                <label for=\"countries\">Country</label>\r\n" + //
                    "    \r\n" + //
                    "                <select name=\"countries\" id=\"countries\">\r\n" + //
                    "                    <option value=\"choose...\" selected>Choose...</option>\r\n" + //
                    "                    <option value=\"unitedstates\">United States</option>\r\n" + //
                    "                    <option value=\"southofkorea\">South of Korea</option>\r\n" + //
                    "                    <option value=\"japan\">Japan</option>\r\n" + //
                    "                    <option value=\"china\">China</option>\r\n" + //
                    "                    <option value=\"germany\">Germany</option>\r\n" + //
                    "                </select>\r\n" + //
                    "            </div>\r\n" + //
                    "            <br>\r\n" + //
                    "            <div>\r\n" + //
                    "                <label for=\"state\">State</label>\r\n" + //
                    "    \r\n" + //
                    "                <select name=\"state\" id=\"state\">\r\n" + //
                    "                    <option value=\"choose...\" selected>Choose...</option>\r\n" + //
                    "                    <option value=\"washington,d.c.\">Washington, D.C.</option>\r\n" + //
                    "                    <option value=\"seoul\">Seoul</option>\r\n" + //
                    "                    <option value=\"tokyo\">Tokyo</option>\r\n" + //
                    "                    <option value=\"beijing\">Beijing</option>\r\n" + //
                    "                    <option value=\"berlin\">Berlin</option>\r\n" + //
                    "                </select>\r\n" + //
                    "            </div>\r\n" + //
                    "            <br>\r\n" + //
                    "            <div>\r\n" + //
                    "                ZIP <input type=\"text\" name=\"zip\" placeholder=\"12345\">\r\n" + //
                    "            </div>\r\n" + //
                    "            <hr>\r\n" + //
                    "            <div>\r\n" + //
                    "                <input type=\"checkbox\" name=\"shippingaddress\"> Shipping address is the same as my biliing address\r\n" + //
                    "            </div>\r\n" + //
                    "            <div>\r\n" + //
                    "                <input type=\"checkbox\" name=\"savethisinformation\"> Save this information for next time\r\n" + //
                    "            </div>\r\n" + //
                    "            <hr>\r\n" + //
                    "\r\n" + //
                    "            <h2>Payment</h2>\r\n" + //
                    "            <div><input type=\"radio\" name=\"payments\" value=\"creditcard\"> Credit card</div>\r\n" + //
                    "            <div><input type=\"radio\" name=\"payments\" value=\"debitcard\"> Debit card</div>\r\n" + //
                    "            <div><input type=\"radio\" name=\"payments\" value=\"paypal\"> Paypal</div>\r\n" + //
                    "            <br>\r\n" + //
                    "            <div>\r\n" + //
                    "                Name on card <input type=\"text\" name=\"nameoncard\" >\r\n" + //
                    "            </div>\r\n" + //
                    "            <br>\r\n" + //
                    "            <div>\r\n" + //
                    "                Credit card number <input type=\"text\" name=\"creditcard\" >\r\n" + //
                    "            </div>\r\n" + //
                    "            <br>\r\n" + //
                    "            <div>\r\n" + //
                    "                Expiration <input type=\"date\" name=\"expiration\">\r\n" + //
                    "            </div>\r\n" + //
                    "            <br>\r\n" + //
                    "            <div>\r\n" + //
                    "                CVV <input type=\"text\" name=\"cvv\">\r\n" + //
                    "            </div>\r\n" + //
                    "            <hr>\r\n" + //
                    "            <br>\r\n" + //
                    "            <div>\r\n" + //
                    "                <button type=\"submit\">Continued to checkout</button>\r\n" + //
                    "            </div>\r\n" + //
                    "        </form>\r\n" + //
                    "\r\n" + //
                    "</body>\r\n" + //
                    "</html>";

            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
