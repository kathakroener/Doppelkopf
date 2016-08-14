/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websocket.Model;

import Doppelkopf.Spielverwaltung;
import java.util.HashMap;
import java.util.Map;
import javax.json.Json;

/**
 *
 * @author hrs
 */
public class Spielerverwaltung {
    
    Map<String,String> mapSpielerPlatz;
    
    private Spielerverwaltung() {
        mapSpielerPlatz = new HashMap<String,String>();
    }
    
    public static Spielerverwaltung getInstance() {
        return SpielerverwaltungHolder.INSTANCE;
    }
    
    private static class SpielerverwaltungHolder {

        private static final Spielerverwaltung INSTANCE = new Spielerverwaltung();
    }

    public Map<String, String> getMapSpielerPlatz() {
        return mapSpielerPlatz;
    }

    public void setMapSpielerPlatz(Map<String, String> mapSpielerPlatz) {
        this.mapSpielerPlatz = mapSpielerPlatz;
    }
    
    public void fuegehinzuMapSpielerPlatz(String username, String platz){
        this.mapSpielerPlatz.put(username, platz);
    }
    
    
}
