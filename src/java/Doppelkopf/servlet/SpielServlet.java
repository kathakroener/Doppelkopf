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
import javax.servlet.http.HttpSession;

/**
 *
 * @author hrs
 */
@WebServlet(name = "SpielServlet", urlPatterns = {"/Spiel"})
public class SpielServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SpielServlet</title>");    
            out.println("<script src='js/jquery-3.1.0.js'></script>");
            out.println("<script src='js/bootstrap.js'></script>");
            out.println("<script src='js/chat.js'></script>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-theme.css\">");
            out.println("<style>");
            out.println(".row.content {height: 40%}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            HttpSession session = request.getSession();
            
            out.println("<label id=\"senderUsername\">" + session.getAttribute("username") + "</label>");
            out.println("<div class=\"container-fluid text-center\" style=\"height=20%;\">\n" +
"  <div class=\"row content\">\n" +
"    <div class=\"col-sm-3 sidenav\" style=\"background-color:blue;height:100%\">\n" +

"    </div>\n" +
"    <div class=\"col-sm-6 text-left\">\n" +
"<div class=\"well well-lg\">\n" +
"        <p>WELLE</p>\n" +
"      </div>\n" +
"<div class=\"well well-lg\">\n" +
"        <p>WELLE</p>\n" +
"      </div>\n" +
"    </div>\n" +
"    <div class=\"col-sm-3 sidenav\">\n" +
"      <div class=\"well well-lg\">\n" +
"        <p style=\"text-align='center';\">WELLE</p>\n" +
"      </div>\n" +
"    </div>\n" +
"  </div>\n" +
"</div>\n" +
"  \n" +
"<div class=\"container-fluid text-center\">\n" +
"  <div class=\"row content\">\n" +
"    <div class=\"col-sm-3 sidenav\">\n" +
"      <p><a href=\"#\">Link</a></p>\n" +
"      <p><a href=\"#\">Link</a></p>\n" +
"      <p><a href=\"#\">Link</a></p>\n" +
"    </div>\n" +
"    <div class=\"col-sm-6 text-left\">\n" +
"<div class=\"well well-lg\">\n" +
"        <p>WELLE</p>\n" +
"      </div>\n" +
"<div class=\"well well-lg\">\n" +
"        <p>WELLE</p>\n" +
"      </div>\n" +
"    </div>\n" +
"    <div class=\"col-sm-3 sidenav\">\n" +
"      <div class=\"well well-lg\">\n" +
"        <p style=\"text-align='center';\">WELLE</p>\n" +
"      </div>\n" +
"      <div class=\"well\">\n" +
"        <p>ADS</p>\n" +
"      </div>\n" +
"    </div>\n" +
"  </div>\n" +
"</div>\n" +
"\n" +
"<div class=\"container-fluid text-center\">\n" +
"  <div class=\"row content\">\n" +
"    <div class=\"col-sm-3 sidenav\">\n" +
"      <p><a href=\"#\">Link</a></p>\n" +
"      <p><a href=\"#\">Link</a></p>\n" +
"      <p><a href=\"#\">Link</a></p>\n" +
"    </div>\n" +
"    <div class=\"col-sm-6 text-left\">\n" +
"<div class=\"well well-lg\">\n" +
"        <p>WELLE</p>\n" +
"      </div>\n" +
"<div class=\"well well-lg\">\n" +
"        <p>WELLE</p>\n" +
"      </div>\n" +
"    </div>\n" +
"    <div id=\"chat\" class=\"col-sm-3 \">\n" +
"        <table id=\"chatVerlauf\" class=\"table table-bordered\"></table>\n" +                  
"<div class=\"form-group\">\n" +
"  <input type=\"text\" class=\"form-control\" id=\"inputChatEingabe\" placeholder=\"Deine Nachricht\">\n" +
" <button id=\"buttonSendMessage\" type=\"submit\" class=\"btn btn-default\">Send</button>\n" +
                    "</div>\n" +
//"      </div>\n" +
"    </div>\n" +
"  </div>\n" +
"</div>");
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
