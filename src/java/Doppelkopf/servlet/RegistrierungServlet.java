/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doppelkopf.servlet;

import Controller.DbController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/login.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-theme.css\">");
            out.println("</head>");
            out.println("<body>");
            if(response.getHeader("alertText") != null){
                out.println("<div class=\"alert alert-danger\">\n" +
"  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
"  <strong>Fehler!</strong> " + response.getHeader("alertText") + "\n" +
"</div>");
            }
            out.println(""+
"<dic class=\"container\">"+
"<form action='"+request.getContextPath()+"/Registrierung' class=\"form-signin\" method='POST' role=\"form\">\n" +
"<h1 class=\"form-signin-heading\">Registrierung</h1>\n" +
"<h2 class=\"form-signin-heading\">Kurrelaner Dullentreff</h2>\n" +

"      <label class=\"sr-only\" for=\"username\">Username:</label>\n" +
"      <input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\" placeholder=\"Username\">\n" +


"      <label class=\"sr-only\" for=\"passwort\">Password:</label>\n" +
"      <input type=\"password\" class=\"form-control\" id=\"passwort\" name=\"passwort\" placeholder=\"Passwort\">\n" +


"      <label class=\"sr-only\" for=\"passwort2\">Password:</label>\n" +
"      <input type=\"password\" class=\"form-control\" id=\"passwort2\" name=\"passwort2\" placeholder=\"Passwort\">\n" +

"    <button type=\"submit\" class=\"btn btn-lg btn-primary btn-block\">Registrieren</button>\n" +
"    <a href=\"Login\">Zurück zum Login</a>" +
"  </form>" +
"</div>" );
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
        String username = request.getParameter("username");
        String passwort = request.getParameter("passwort");
        String passwortWiederholung = request.getParameter("passwort2");
        if(passwort.equals(passwortWiederholung)){
            try {
                if(username.length() <= 15 && !username.contains(" ")){
                    if(DbController.getInstance().getUser(request.getParameter("username")) == null){
                        DbController.getInstance().insertUser(username, passwort);
                        response.sendRedirect(request.getContextPath() + "/Login");
                    }else{
                        //Error-Meldung Nutzer gibt es schon
                        response.addHeader("alertText", "Username existiert bereits!");
                    }
                }else{
                    response.addHeader("alertText", "Bitte einen Usernamen mit höchstens 15 Zeichen nehmen und ohne Leerzeichen eingeben.");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(RegistrierungServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            //Error-Meldung Passwörter nicht gleich
            response.addHeader("alertText", "Die beiden eingegebenen Passwörter stimmen nicht überein!");
        }
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
