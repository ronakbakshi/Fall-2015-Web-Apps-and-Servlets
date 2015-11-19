/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project09;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ronak Bakshi
 */
@WebServlet(name = "PlanetServlet", urlPatterns = {"/PlanetServlet"})
public class PlanetServlet extends HttpServlet {

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

        double averageDistanceFromSun = Double.parseDouble(request.getParameter("distance"));
        double diameter = Double.parseDouble(request.getParameter("diameter"));
        double gravity = Double.parseDouble(request.getParameter("gravity"));
        SolarSystem solarsystem = new SolarSystem();
        ArrayList<Planet> planetList = solarsystem.getPlanets();
        double averageDistanceFromSuninList;
        double diameterinLinst;
        double gravityinList;

        // Represent menu items in JSON and send response to client
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try (JsonGenerator gen = Json.createGenerator(out)) {
                gen.writeStartObject();
                gen.writeStartArray("planetList");
                for (Planet p : planetList) {
                    averageDistanceFromSuninList = p.getAverageDistanceFromSun();
                    diameterinLinst = p.getDiameter();
                    gravityinList = p.getGravity();
                    if ((averageDistanceFromSuninList > averageDistanceFromSun) && (diameterinLinst > diameter) && (gravityinList > gravity)) {
                        gen.writeStartObject();
                        gen.write("name", p.getName());
                        gen.write("averageDistanceFromSun", p.getAverageDistanceFromSun());
                        gen.write("periodOfRevolution", p.getPeriodOfRevolution());
                        gen.write("diameter", p.getDiameter());
                        gen.write("mass", p.getMass());
                        gen.write("gravity", p.getGravity());
                        gen.writeEnd();
                    }
                }
                gen.writeEnd();
                gen.writeEnd();
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
