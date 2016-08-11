/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.io.IOException;
import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
/**
 *
 * @author hrs
 */
@ServerEndpoint(value = "/chat", encoders = NachrichtenSchreiber.class, decoders = NachrichtenLeser.class)
public class ChatEndPoint {

    @OnMessage
    public void onMessage(final Session session, final Nachricht nachricht) {
        try {
            for (Session s : session.getOpenSessions()) {
                if (s.isOpen()) {
                    s.getBasicRemote().sendObject(nachricht);
                }
            }
        } catch (IOException | EncodeException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
   

}
