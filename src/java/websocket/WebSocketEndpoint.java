/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websocket;

import websocket.Model.Nachricht;
import java.io.IOException;
import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import websocket.Model.Kartelegen;

/**
 *
 * @author hrs
 */
@ServerEndpoint(value = "/websocket/{typ}")
public class WebSocketEndpoint {
    
    @OnMessage
    public void handleMessage(String text, Session session, @PathParam("typ") String aufgabenTyp) {
        if(aufgabenTyp.equals("chat")){
            try {
                Nachricht nachricht = new Nachricht(text);
                for (Session s : session.getOpenSessions()) {
                    
                    if (s.isOpen() ) {
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
    }   
    
    public void verteileKarten()
}
