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
@WebServlet(name = "A Ice Cream Servlet", urlPatterns = {"/iceCreamServlet"})
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
        double SMALL_PRICE = 6.00;
        double MEDIUM_PRICE = 9.00;
        double LARGE_PRICE = 11.00;
        double CHOCOLATE = 1.00;
        double MINT = 1.25;
        double STRAWBERRY = 1.50;
        double VANILLA = 1.50;
        double CARAMEL = 0.50;
        double SFSTRAWBERRY = 0.70;
        double orderPrice = 0.0;
        int MAX = 25;
        int MIN = 45;
        long randomtime;
        double totalPrice;
        randomtime = Math.round(Math.random() * (MAX - MIN + 1)) + MIN;

        String flavor = request.getParameter("flavor");
        String size = request.getParameter("size");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String toppingCaramel = request.getParameter("toppingCaramel");
        String toppingStrawberry = request.getParameter("toppingStrawberry");

        switch (flavor) {
            case "chocolate":
                orderPrice += CHOCOLATE;
                break;
            case "mint":
                orderPrice += MINT;
                break;
            case "strawberry":
                orderPrice += STRAWBERRY;
                break;
            case "vanilla":
                orderPrice += VANILLA;
                break;
        }

        switch (size) {
            case "small":
                orderPrice += SMALL_PRICE;
                break;
            case "medium":
                orderPrice += MEDIUM_PRICE;
                break;
            case "large":
                orderPrice += LARGE_PRICE;
                break;

        }

        if ("caramel".equals(toppingCaramel)) {
            orderPrice += CARAMEL;
        }

        if ("strawberry".equals(toppingStrawberry)) {
            orderPrice += SFSTRAWBERRY;
        }

        totalPrice = (orderPrice) * quantity;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(String.format("%.2f", totalPrice) + "\n" + randomtime);
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
