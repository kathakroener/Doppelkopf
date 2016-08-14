/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doppelkopf;

import DbModel.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.websocket.Session;
import websocket.WebSocketEndpoint;

/**
 *
 * @author hrs
 */
public class Spielverwaltung {
    Spiel aktSpiel;
    Spieler spielerPlatz0;
    Spieler spielerPlatz1;
    Spieler spielerPlatz2;
    Spieler spielerPlatz3;

    public int doLogin(User user){        
        if(spielerPlatz0 == null || spielerPlatz0.equals(user.getUsername())){
            spielerPlatz0 = new Spieler(user.getUsername());
            WebSocketEndpoint.getInstance().neuerSpieler();
            return 0;
        }
        if(spielerPlatz1 == null || spielerPlatz1.equals(user.getUsername())){
            spielerPlatz1 = new Spieler(user.getUsername());
            WebSocketEndpoint.getInstance().neuerSpieler();
            return 1;
        }
        if(spielerPlatz2 == null || spielerPlatz2.equals(user.getUsername())){
            spielerPlatz2 = new Spieler(user.getUsername());
            WebSocketEndpoint.getInstance().neuerSpieler();
            return 2;
        }
        if(spielerPlatz3 == null || spielerPlatz3.equals(user.getUsername())){
            spielerPlatz3 = new Spieler(user.getUsername());
            WebSocketEndpoint.getInstance().neuerSpieler();
            return 3;
        }
        return -1;
    }
    
    public void starteNeuesSpiel(){
        ArrayList<Spieler> listSpieler = new ArrayList();
        listSpieler.add(spielerPlatz0);
        listSpieler.add(spielerPlatz1);
        listSpieler.add(spielerPlatz2);
        listSpieler.add(spielerPlatz3);
        
        aktSpiel = new Spiel(listSpieler);
    }
    
    private Spielverwaltung() {
        this.aktSpiel = null;
        this.spielerPlatz0 = null;
        this.spielerPlatz1 = null;
        this.spielerPlatz2 = null;
        this.spielerPlatz3 = null;
    }
    
    public static Spielverwaltung getInstance() {
        return SpielVerwaltungHolder.INSTANCE;
    }
    
    private static class SpielVerwaltungHolder {
        private static final Spielverwaltung INSTANCE = new Spielverwaltung();
    }

    public Spiel getAktSpiel() {
        return aktSpiel;
    }

    public void setAktSpiel(Spiel aktSpiel) {
        this.aktSpiel = aktSpiel;
    }

    public Spieler getSpielerPlatz0() {
        return spielerPlatz0;
    }

    public void setSpielerPlatz0(Spieler spielerPlatz0) {
        this.spielerPlatz0 = spielerPlatz0;
    }

    public Spieler getSpielerPlatz1() {
        return spielerPlatz1;
    }

    public void setSpielerPlatz1(Spieler spielerPlatz1) {
        this.spielerPlatz1 = spielerPlatz1;
    }

    public Spieler getSpielerPlatz2() {
        return spielerPlatz2;
    }

    public void setSpielerPlatz2(Spieler spielerPlatz2) {
        this.spielerPlatz2 = spielerPlatz2;
    }

    public Spieler getSpielerPlatz3() {
        return spielerPlatz3;
    }

    public void setSpielerPlatz3(Spieler spielerPlatz3) {
        this.spielerPlatz3 = spielerPlatz3;
    } 
    
    public String spielerlistToJSON(){
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        if(this.getSpielerPlatz0() != null){
            jsonObjectBuilder.add("Spieler0", this.getSpielerPlatz0().getName());
        }else{
            jsonObjectBuilder.add("Spieler0", "");
        }
        if(this.getSpielerPlatz1() != null){
            jsonObjectBuilder.add("Spieler1", this.getSpielerPlatz1().getName());
        }else{
            jsonObjectBuilder.add("Spieler1", "");
        }
        if(this.getSpielerPlatz2() != null){
            jsonObjectBuilder.add("Spieler2", this.getSpielerPlatz2().getName());
        }else{
            jsonObjectBuilder.add("Spieler2", "");
        }
        if(this.getSpielerPlatz3() != null){
            jsonObjectBuilder.add("Spieler3", this.getSpielerPlatz3().getName());
        }else{
            jsonObjectBuilder.add("Spieler3", "");
        }       
        return jsonObjectBuilder.build().toString();
    }
}
