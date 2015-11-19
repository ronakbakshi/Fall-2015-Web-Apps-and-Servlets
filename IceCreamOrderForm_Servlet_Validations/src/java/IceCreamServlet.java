/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ronak Bakshi
 */
@WebServlet(name = "Ice cream order servlet", urlPatterns = {"/BakshiServlet"})
public class IceCreamServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            double SMALL_PRICE = 6.00;
            double MEDIUM_PRICE = 9.00;
            double LARGE_PRICE = 11.00;
            double CHOCOLATE = 1.00;
            double MINT = 1.25;
            double STRAWBERRY = 1.50;
            double VANILLA = 1.50;
            double CARAMEL = 0.50;
            double SFSTRAWBERRY = 0.70;
            int MAX = 25;
            int MIN = 45;
            double price = 0.00;
            boolean allDataEntered = true;
            long randonTime = Math.round(Math.random() * (MAX - MIN + 1)) + MIN;
            int quantity = 0;
            String message = "";
            String selectedFlavour = request.getParameter("flavor");
            if (null != selectedFlavour) {
                switch (selectedFlavour) {
                    case "Chocolate":
                        price += CHOCOLATE;
                        allDataEntered = true;
                        break;
                    case "Mint Chocolate Chip":
                        price += MINT;
                        allDataEntered = true;
                        break;
                    case "Strawberry":
                        price += STRAWBERRY;
                        allDataEntered = true;
                        break;
                    case "Vanilla":
                        price += VANILLA;
                        break;
                    default:
                        allDataEntered = false;
                        message += "Flavor not selected.<br>";
                        break;
                }
            }
            String size = request.getParameter("size");
            if ("small".equals(size)) {
                price += SMALL_PRICE;
            } else if ("medium".equals(size)) {
                price += MEDIUM_PRICE;
            } else if ("large".equals(size)) {
                price += LARGE_PRICE;
            } else {
                allDataEntered = false;
                message += "Size not selected.<br>";
            }
            if (!request.getParameter("quantity").isEmpty()) {
                quantity = Integer.parseInt(request.getParameter("quantity"));
                if ((quantity >= 1) && (quantity <= 10)) {
                    price = (quantity * price);
                }
                else
                {
                    allDataEntered = false;
                    message += "Please enter quantity between 1 and 10.<br>"; 
                }
            } else {
                allDataEntered = false;
                message += "Quantity not entered.<br>";
            }
            if (allDataEntered) {
                if ("caramel".equals(request.getParameter("caramel"))) {
                    price += (quantity * CARAMEL);
                }
                if ("SFstrawberry".equals(request.getParameter("SFstrawberry"))) {
                    price += (quantity * SFSTRAWBERRY);
                }
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"IceCream02Servlet.css\">");
            out.println("<head>");
            out.println("<title>Servlet BakshiServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Bearcat Ice Cream Order Confirmation</h2>");

            if (!allDataEntered) {
                out.println("<div id=\"divID\">" + message + "</div>");
            } else {

                out.println("<div class=\"divClass\">The total cost of your order is $" + String.format("%.2f", price) + "</div>");
                if(quantity == 1)
                {
                    out.println("<div class=\"divClass\">Your " + selectedFlavour + " ice cream  will be delivered in about " + randonTime + " minutes.</div>");
                }
                else
                {
                    out.println("<div class=\"divClass\">Your " + selectedFlavour + " ice creams  will be delivered in about " + randonTime + " minutes.</div>");
                }
            }
            out.println("</body>");
            out.println("</html>");
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