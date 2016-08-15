/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websocket;

import Doppelkopf.Karte;
import Doppelkopf.Runde;
import Doppelkopf.Spieler;
import Doppelkopf.Spielverwaltung;
import Doppelkopf.Stich;
import websocket.Model.Nachricht;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonObject;
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
        
        if(aufgabenTyp.equals("kartenverteilen")){
            WebSocketVerwaltung.getInstance().kartenVerteilenSetSession.add(session);
        }

        if(aufgabenTyp.equals("spielerverwaltung")){
            WebSocketVerwaltung.getInstance().spielSetSession.add(session);
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
            JsonObject obj = Json.createReader(new StringReader(text)).readObject();
            Spieler spieler = Spielverwaltung.getInstance().getAktSpiel().getSpielerMitUsername(obj.getString("user"));
            Karte karte = Spielverwaltung.getInstance().getAktSpiel().getLetzteRunde().getKarteMitId(spieler, Integer.parseInt(obj.getString("kartenId")));
            
            Stich letzterAbgeschlossenerStich = Spielverwaltung.getInstance().getAktSpiel().getLetzteRunde().getLetzterAbgeschlossenerStich();
            Stich aktuellerOffenerStich = Spielverwaltung.getInstance().getAktSpiel().getLetzteRunde().getAktuellerOffenerStich();

            if(aktuellerOffenerStich == null){ // Erste Karte in einem Stich
                legeKarte(text,session);
                Stich stich = new Stich();
                stich.getMapKarteSpieler().put(spieler, karte);
                ArrayList<Stich> stiche = Spielverwaltung.getInstance().getAktSpiel().getLetzteRunde().getStiche();
                stiche.add(stich);
                Spielverwaltung.getInstance().getAktSpiel().getLetzteRunde().setStiche(stiche);
            }
            else if(aktuellerOffenerStich.wirdRichtigBedient(karte,spieler)){// Kommt nicht raus. Wird richtig bedient?
                legeKarte(text,session);
                //gelegte Karte zum Stich hinzufügen
                Spielverwaltung.getInstance().getAktSpiel().getLetzteRunde().getAktuellerOffenerStich().getMapKarteSpieler().put(spieler, karte);
                if(Spielverwaltung.getInstance().getAktSpiel().getLetzteRunde().getAktuellerOffenerStich().getMapKarteSpieler().size() == 4){
                    //Alle haben gelegt
                    Spielverwaltung.getInstance().getAktSpiel().getLetzteRunde().getAktuellerOffenerStich().auswerten();
                    sendeStichErgebnis(Spielverwaltung.getInstance().getAktSpiel().getLetzteRunde().getLetzterAbgeschlossenerStich(), session);
                }
            }
        }
        if(aufgabenTyp.equals("kartenverteilen")){
            Spielverwaltung.getInstance().anzSpielerBereit++;
            if(Spielverwaltung.getInstance().anzSpielerBereit == 4){
                Spielverwaltung.getInstance().starteNeuesSpiel();
                Spielverwaltung.getInstance().anzSpielerBereit = 0;
                Runde runde = Spielverwaltung.getInstance().getAktSpiel().kartenGeben();
                try {
                    String urlPfad = session.getRequestURI().getPath();
                    for (Session s : session.getOpenSessions()) {
                        if (s.isOpen() && s.getRequestURI().getPath().equals(urlPfad)) {
                            s.getBasicRemote().sendObject(runde.blattToJSON());
                        }
                    }
                } catch (IOException | EncodeException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
        }
        if(aufgabenTyp.equals("ansage")){
            Kartelegen kartenlegen = new Kartelegen(text);
        }
        if(aufgabenTyp.equals("spielerverwaltung")){
            session.getBasicRemote().sendObject(Spielverwaltung.getInstance().spielerlistToJSON());  
        }
        
    }   
    
    public void sendeStichErgebnis(Stich stich, Session session){
        try {
            String urlPfad = session.getRequestURI().getPath();
            for (Session s : session.getOpenSessions()) {
                if (s.isOpen() && s.getRequestURI().getPath().equals(urlPfad)) {
                    s.getBasicRemote().sendObject(text);
                }
            }
        } catch (IOException | EncodeException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    
    public void legeKarte(String text, Session session){
        try {
                String urlPfad = session.getRequestURI().getPath();
                for (Session s : session.getOpenSessions()) {
                    if (s.isOpen() && s.getRequestURI().getPath().equals(urlPfad)) {
                        s.getBasicRemote().sendObject(text);
                    }
                }
                } catch (IOException | EncodeException e) {
                    System.out.println("Error " + e.getMessage());
                }
    }
    
    public void verteileKarten(Runde runde, Set<Session> sessions) throws IOException, EncodeException{
        for (Session s : sessions) {
            if (s.isOpen()) {
                s.getBasicRemote().sendObject(runde.blattToJSON());
            }
        }
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
