/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doppelkopf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author katha
 */
@WebServlet(name = "RegistrierungServlet", urlPatterns = {"/Registrierung"})
public class RegistrierungServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrierungServlet</title>");  
            out.println("<script src='js/jquery-3.1.0.js'></script>");
            out.println("<script src='js/bootstrap.js'></script>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-theme.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrierungServlet at " + request.getContextPath() + "</h1>");
            out.println("<form action='"+request.getContextPath()+"/Registrierung' method='POST' role=\"form\">\n" +
"    <div class=\"form-group\">\n" +
"      <label class=\"sr-only\" for=\"username\">Username:</label>\n" +
"      <input type=\"text\" class=\"form-control\" id=\"username\" placeholder=\"Username\">\n" +
"    </div>\n" +
"    <div class=\"form-group\">\n" +
"      <label class=\"sr-only\" for=\"passwort\">Password:</label>\n" +
"      <input type=\"password\" class=\"form-control\" id=\"passwort\" placeholder=\"Passwort\">\n" +
"    </div>\n" +
    "<div class=\"form-group\">\n" +
"      <label class=\"sr-only\" for=\"passwort2\">Password:</label>\n" +
"      <input type=\"password\" class=\"form-control\" id=\"passwort2\" placeholder=\"Passwort\">\n" +
"    </div>\n" +
"    <button type=\"submit\" class=\"btn btn-default\">Registrieren</button>\n" +
"  </form>");
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
