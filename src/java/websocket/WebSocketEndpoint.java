/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websocket;

import Doppelkopf.Runde;
import Doppelkopf.Spieler;
import Doppelkopf.Spielverwaltung;
import websocket.Model.Nachricht;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.Endpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import websocket.Model.Kartelegen;
import websocket.Model.Spielerverwaltung;

/**
 *
 * @author katha
 */
@ServerEndpoint(value = "/websocket/{typ}")
public class WebSocketEndpoint{
   
    
    private WebSocketEndpoint() {
    }
    
    public static WebSocketEndpoint getInstance() {
        return WebSocketEndpointHolder.INSTANCE;
    }
    
    private static class WebSocketEndpointHolder {

        private static final WebSocketEndpoint INSTANCE = new WebSocketEndpoint();
    }
    
    @OnOpen
    public void onOpen(Session session, @PathParam("typ") String aufgabenTyp) throws IOException {
//        session.getBasicRemote().sendText("Erfolg");
        
        if(aufgabenTyp.equals("chat")){
            WebSocketVerwaltung.getInstance().chatSetSession.add(session);
        }
//        session.getRequestURI().getPath()
        
        if(aufgabenTyp.equals("ansage")){
            WebSocketVerwaltung.getInstance().ansageSetSession.add(session);
        }
        
        if(aufgabenTyp.equals("kartelegen")){
            WebSocketVerwaltung.getInstance().kartelegenSetSession.add(session);
            
        }

        if(aufgabenTyp.equals("spielerverwaltung")){
            WebSocketVerwaltung.getInstance().spielSetSession.add(session);
            if(WebSocketVerwaltung.getInstance().spielSetSession.size() == 4){
                Spielverwaltung.getInstance().starteNeuesSpiel();
            }
        }
        
    }
        
    @OnMessage
    public void handleMessage(String text, Session session, @PathParam("typ") String aufgabenTyp) throws IOException, EncodeException {
        if(aufgabenTyp.equals("chat")){
            try {
                Nachricht nachricht = new Nachricht(text);
                String urlPfad = session.getRequestURI().getPath();
                for (Session s : session.getOpenSessions()) {
                    if (s.isOpen() && s.getRequestURI().getPath().equals(urlPfad)) {
                        s.getBasicRemote().sendObject(nachricht.toJSON());
                    }
                }
            } catch (IOException | EncodeException e) {
                System.out.println("Error " + e.getMessage());
            }
        }
        if(aufgabenTyp.equals("kartelegen")){
            Kartelegen kartenlegen = new Kartelegen(text);
        }
        if(aufgabenTyp.equals("ansage")){
            Kartelegen kartenlegen = new Kartelegen(text);
        }
        if(aufgabenTyp.equals("spielerverwaltung")){
            session.getBasicRemote().sendObject(Spielverwaltung.getInstance().spielerlistToJSON());  
        }
        
    }   
    
    public void verteileKarten(Runde runde){
        
    }
    
    public void neuerSpieler(){
        try {
                for (Session s : WebSocketVerwaltung.getInstance().spielSetSession) {
                    if (s.isOpen() ) {
                        s.getBasicRemote().sendObject(Spielverwaltung.getInstance().spielerlistToJSON());
                    }
                }
            } catch (IOException | EncodeException e) {
                System.out.println("Error " + e.getMessage());
            }
    }
}
