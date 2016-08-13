/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spielinteraktion;

import Chat.Nachricht;
import Chat.NachrichtenLeser;
import Chat.NachrichtenSchreiber;
import Doppelkopf.Karte;
import Doppelkopf.Spieler;
import java.io.IOException;
import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author katha
 */
@ServerEndpoint(value = "/Kartenlegen")
public class KartenlegenEndPoint {
    
    @OnMessage
    public void onMessage(final Session session, final KartenlegenModel kartenlegenModel) {
        try {
            for (Session s : session.getOpenSessions()) {
                if (s.isOpen() ) {
                    s.getBasicRemote().sendObject(kartenlegenModel);
                }
            }
        } catch (IOException | EncodeException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
