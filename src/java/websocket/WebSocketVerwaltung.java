/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websocket;

import java.util.HashSet;
import java.util.Set;
import javax.websocket.Session;

/**
 *
 * @author katha
 */
public class WebSocketVerwaltung {
    
    Set<Session> chatSetSession; 
    Set<Session> spielSetSession;
    Set<Session> ansageSetSession;
    Set<Session> kartelegenSetSession;
    Set<Session> kartenVerteilenSetSession;
    
    private WebSocketVerwaltung() {
        this.chatSetSession = new HashSet<Session>();
        this.spielSetSession = new HashSet<Session>();
        this.ansageSetSession = new HashSet<Session>();
        this.kartelegenSetSession = new HashSet<Session>();
        this.kartenVerteilenSetSession = new HashSet<Session>();
    }
    
    public static WebSocketVerwaltung getInstance() {
        return WebSocketVerwaltungHolder.INSTANCE;
    }
    
    private static class WebSocketVerwaltungHolder {

        private static final WebSocketVerwaltung INSTANCE = new WebSocketVerwaltung();
    }

    public Set<Session> getChatSetSession() {
        return chatSetSession;
    }

    public void setChatSetSession(Set<Session> chatSetSession) {
        this.chatSetSession = chatSetSession;
    }

    public Set<Session> getSpielSetSession() {
        return spielSetSession;
    }

    public void setSpielSetSession(Set<Session> spielSetSession) {
        this.spielSetSession = spielSetSession;
    }

    public Set<Session> getAnsageSetSession() {
        return ansageSetSession;
    }

    public void setAnsageSetSession(Set<Session> ansageSetSession) {
        this.ansageSetSession = ansageSetSession;
    }

    public Set<Session> getKartelegenSetSession() {
        return kartelegenSetSession;
    }

    public void setKartelegenSetSession(Set<Session> kartelegenSetSession) {
        this.kartelegenSetSession = kartelegenSetSession;
    }

    public Set<Session> getKartenVerteilenSetSession() {
        return kartenVerteilenSetSession;
    }

    public void setKartenVerteilenSetSession(Set<Session> kartenVerteilenSetSession) {
        this.kartenVerteilenSetSession = kartenVerteilenSetSession;
    }   
}
