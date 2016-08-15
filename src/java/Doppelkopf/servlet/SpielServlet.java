/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doppelkopf.servlet;

import Doppelkopf.Spielverwaltung;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import websocket.Model.Spielerverwaltung;

/**
 *
 * @author katha
 */
@WebServlet(name = "SpielServlet", urlPatterns = {"/Spiel"})
public class SpielServlet extends HttpServlet {
    
    String spielerLinks = "offline";
    String spielerOben = "offline";
    String spielerRechts = "offline";
    

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
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        platzZuordnung((Integer) session.getAttribute("platz")); 
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SpielServlet</title>");    
            out.println("<script src='js/jquery-3.1.0.js'></script>");
            out.println("<script src='js/bootstrap.js'></script>");
            out.println("<script src='js/chat.js'></script>");
            out.println("<script src='js/spielerverwaltung.js'></script>");
            out.println("<script src='js/kartenVerteilen.js'></script>");
            out.println("<script src='js/spiel.js'></script>");
            out.println("<script src='js/jquery-ui.js'></script>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">");        
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-theme.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/spiel.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/jquery-ui.css\">");
            out.println("<style>");
            out.println(".row.content {height: 40%}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            
            
            out.println("<label id=\"senderUsername\">" + session.getAttribute("username") + "</label>");
            out.println("<label id=\"eigenerPlatz\">" + session.getAttribute("platz") + "</label>");
            out.println("<div class=\"container-fluid text-center\" style=\"height=20%;\">\n" +
"  <div class=\"row content\">\n" +
"    <div class=\"col-sm-3 sidenav\" style=\"background-color:blue;height:100%\">\n" +

"    </div>\n" +
"    <div class=\"col-sm-6 text-left\">\n" +
                    "      <div class=\"well well-lg\">\n" +
                    
"        <p id=\"pSpielerOben\" style=\"text-align='center';\">" + this.spielerOben + "</p>\n" +
                    
"      </div>\n" +

"    </div>\n" +
"    <div class=\"col-sm-3 sidenav\">\n" +

"    </div>\n" +
"  </div>\n" +
"</div>\n" +
"  \n" +
"<div class=\"container-fluid text-center\">\n" +
"  <div class=\"row content\">\n" +
"    <div class=\"col-sm-3 sidenav\">\n" +
"      <div class=\"well well-lg\">\n" +
"        <p id=\"pSpielerLinks\" style=\"text-align='center';\">" + this.spielerLinks + "</p>\n" +
"      </div>\n" +
"    </div>\n" +
"    <div id=\"spieltisch\" class=\"col-sm-6 text-left\">\n" + 
                    "<div id=\"divKarteOben\"> <img id=\"imgKarteOben\" src=\"bilder/rahmen.jpg\" class=\"img-rounded karteNutzer\"></div> "+ 
                    "<div style=\"padding-bottom: 15%;\">\n" +
                    "<div id=\"divKarteLinks\"> <img id=\"imgKarteLinks\" src=\"bilder/rahmen.jpg\" class=\"img-rounded karteNutzer\"></div> "+ 
                    "<div id=\"divKarteRechts\"><img id=\"imgKarteRechts\" src=\"bilder/rahmen.jpg\" class=\"img-rounded karteNutzer\"> </div> "+ 
                    "</div></br>\n" +
                    "<div id=\"divKarteUnten\"> <img id=\"imgKarteUnten\" src=\"bilder/rahmen.jpg\" class=\"img-rounded karteNutzer\"></div> "+ 

"    </div>\n" +
"    <div class=\"col-sm-3 sidenav\">\n" +
"      <div class=\"well well-lg\">\n" +
"        <p id=\"pSpielerRechts\" style=\"text-align='center';\">" + this.spielerRechts + "</p>\n" +
"      </div>\n" +
"    </div>\n" +
"  </div>\n" +
"</div>\n" +
"\n" +
"<div class=\"container-fluid text-center\">\n" +
"  <div class=\"row content\">\n" +
"    <div class=\"col-sm-3 sidenav\">\n" +
"    </div>\n" +
"    <div class=\"col-sm-6\">\n"+
                    "    <div id=\"spielfeldNutzer\">\n"+
                    
                     "<table id=\"tabelleBilderNutzer\"><tr style='height = 100%;'>"+
                    "<td class=\"spalteTabelleBilder\"><a id=\"linkEigeneKarte9\" href=\"#\"><img id=\"eigeneKarte9\" src=\"bilder/rahmen.jpg\" class=\"img-rounded karteNutzer\"></a></td>" +
                    "<td class=\"spalteTabelleBilder\"><a id=\"linkEigeneKarte8\" href=\"#\"><img id=\"eigeneKarte8\" src=\"bilder/rahmen.jpg\" class=\"img-rounded karteNutzer\"></a></td>" +
                    "<td class=\"spalteTabelleBilder\"><a id=\"linkEigeneKarte7\" href=\"#\"><img id=\"eigeneKarte7\" src=\"bilder/rahmen.jpg\" class=\"img-rounded karteNutzer\"></a></td>" +
                    "<td class=\"spalteTabelleBilder\"><a id=\"linkEigeneKarte6\" href=\"#\"><img id=\"eigeneKarte6\" src=\"bilder/rahmen.jpg\" class=\"img-rounded karteNutzer\"></a></td>" +
                    "<td class=\"spalteTabelleBilder\"><a id=\"linkEigeneKarte5\" href=\"#\"><img id=\"eigeneKarte5\" src=\"bilder/rahmen.jpg\" class=\"img-rounded karteNutzer\"></a></td>" +
                    "<td class=\"spalteTabelleBilder\"><a id=\"linkEigeneKarte4\" href=\"#\"><img id=\"eigeneKarte4\" src=\"bilder/rahmen.jpg\" class=\"img-rounded karteNutzer\"></a></td>" +
                    "<td class=\"spalteTabelleBilder\"><a id=\"linkEigeneKarte3\" href=\"#\"><img id=\"eigeneKarte3\" src=\"bilder/rahmen.jpg\" class=\"img-rounded karteNutzer\"></a></td>" +
                    "<td class=\"spalteTabelleBilder\"><a id=\"linkEigeneKarte2\" href=\"#\"><img id=\"eigeneKarte2\" src=\"bilder/rahmen.jpg\" class=\"img-rounded karteNutzer\"></a></td>" +
                    "<td class=\"spalteTabelleBilder\"><a id=\"linkEigeneKarte1\" href=\"#\"><img id=\"eigeneKarte1\" src=\"bilder/rahmen.jpg\" class=\"img-rounded karteNutzer\"></a></td>" +
                    "<td class=\"spalteTabelleBilder\"><a id=\"linkEigeneKarte0\" href=\"#\"><img id=\"eigeneKarte0\" src=\"bilder/rahmen.jpg\" class=\"img-rounded karteNutzer\"></a></td>" +
                    "</tr></table>" +
                    "    </div>\n" +

"    </div>\n" +
                    
"    <div id=\"chat\" class=\"col-sm-3 \">\n"+
        "<div id=\"chatVerlauf\" class=\"table table-bordered\"></div>\n"+
               
"       <div class=\"form-group\">\n" +
"  <input type=\"text\" class=\"form-control\" id=\"inputChatEingabe\" placeholder=\"Deine Nachricht\">\n" +
" <button id=\"buttonSendMessage\" type=\"submit\" class=\"btn btn-default\">Send</button>\n" +
                    "</div>\n" +

"  </div>\n" +
"</div>"+
"<!-- Modal -->\n" +
"<div id=\"modalBereitZuSpielen\" class=\"modal fade\" role=\"dialog\">\n" +
"  <div class=\"modal-dialog\">\n" +
"\n" +
"    <!-- Modal content-->\n" +
"    <div class=\"modal-content\">\n" +
"      <div class=\"modal-header\">\n" +
"        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n" +
"        <h4 class=\"modal-title\">Es sind vier Spieler anwesend</h4>\n" +
"      </div>\n" +
"      <div class=\"modal-body\">\n" +
"        <p>Bist du bereit zu spielen?</p>\n" +
"      </div>\n" +
"      <div class=\"modal-footer\">\n" +
"        <button id=\"buttonBereitZuSpielen\" type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Bereit</button>\n" +
"      </div>\n" +
"    </div>\n" +
"\n" +
"  </div>\n" +
"</div>"
            );
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
        // ToDo: SpielerUpdate senden!!!
        
        if(request.getSession().getAttribute("username") == null){
            response.addHeader("alertText", "Sie sind nicht eingeloggt");
            response.sendRedirect(request.getContextPath() + "/Login");
        }else{
            processRequest(request, response);
        }
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
    
    
    public void platzZuordnung(int platz){
        if(platz == 0){
            if(Spielverwaltung.getInstance().getSpielerPlatz1()!=null){
                this.spielerLinks = Spielverwaltung.getInstance().getSpielerPlatz1().getName();
            }else{
                this.spielerLinks = "offline";
            }
            if(Spielverwaltung.getInstance().getSpielerPlatz2()!=null){
                this.spielerOben = Spielverwaltung.getInstance().getSpielerPlatz2().getName();
            }else{
                this.spielerOben = "offline";
            }
            if(Spielverwaltung.getInstance().getSpielerPlatz3()!=null){
                this.spielerRechts = Spielverwaltung.getInstance().getSpielerPlatz3().getName();
            }else{
                this.spielerRechts = "offline";
            }
        }
        if(platz == 1){
            if(Spielverwaltung.getInstance().getSpielerPlatz2()!=null){
                this.spielerLinks = Spielverwaltung.getInstance().getSpielerPlatz2().getName();
            }else{
                this.spielerLinks = "offline";
            }
            if(Spielverwaltung.getInstance().getSpielerPlatz3()!=null){
                this.spielerOben = Spielverwaltung.getInstance().getSpielerPlatz3().getName();
            }else{
                this.spielerOben = "offline";
            }
            if(Spielverwaltung.getInstance().getSpielerPlatz0()!=null){
                this.spielerRechts = Spielverwaltung.getInstance().getSpielerPlatz0().getName();
            }else{
                this.spielerRechts = "offline";
            }
        }
        if(platz == 2){
            if(Spielverwaltung.getInstance().getSpielerPlatz3()!=null){
                this.spielerLinks = Spielverwaltung.getInstance().getSpielerPlatz3().getName();
            }else{
                this.spielerLinks = "offline";
            }
            if(Spielverwaltung.getInstance().getSpielerPlatz0()!=null){
                this.spielerOben = Spielverwaltung.getInstance().getSpielerPlatz0().getName();
            }else{
                this.spielerOben = "offline";
            }
            if(Spielverwaltung.getInstance().getSpielerPlatz1()!=null){
                this.spielerRechts = Spielverwaltung.getInstance().getSpielerPlatz1().getName();
            }else{
                this.spielerRechts = "offline";
            }
        }
        if(platz == 3){
            if(Spielverwaltung.getInstance().getSpielerPlatz0()!=null){
                this.spielerLinks = Spielverwaltung.getInstance().getSpielerPlatz0().getName();
            }else{
                this.spielerLinks = "offline";
            }
            if(Spielverwaltung.getInstance().getSpielerPlatz1()!=null){
                this.spielerOben = Spielverwaltung.getInstance().getSpielerPlatz1().getName();
            }else{
                this.spielerOben = "offline";
            }
            if(Spielverwaltung.getInstance().getSpielerPlatz2()!=null){
                this.spielerRechts = Spielverwaltung.getInstance().getSpielerPlatz2().getName();
            }else{
                this.spielerRechts = "offline";
            }
        }
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
