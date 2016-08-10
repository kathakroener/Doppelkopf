/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doppelkopf;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author katha
 */
public class Stich {
    private LinkedHashMap<Karte, Spieler> mapKarteSpieler;
    private int punkte;
    private Spieler stichGehoert;
    private Karte hoechste;
    
    
    public void zaehlen(){
        for(Karte k : mapKarteSpieler.keySet()){
            punkte += k.getWert();
        }
    }
    
    public void stichGehoert(){
        hoechste = null;
        stichGehoert = null;
        for(Karte k : mapKarteSpieler.keySet()){
            if(stichGehoert == null || k.getId() > hoechste.getId()){
                stichGehoert = mapKarteSpieler.get(k);
                hoechste = k;
            }
        }
    }
    

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    public Map<Karte, Spieler> getMapKarteSpieler() {
        return mapKarteSpieler;
    }

    public void setMapKarteSpieler(LinkedHashMap<Karte, Spieler> mapKarteSpieler) {
        this.mapKarteSpieler = mapKarteSpieler;
    }

    public Spieler getStichGehoert() {
        return stichGehoert;
    }

    public void setStichGehoert(Spieler stichGehoert) {
        this.stichGehoert = stichGehoert;
    }

    public Karte getHoechste() {
        return hoechste;
    }

    public void setHoechste(Karte hoechste) {
        this.hoechste = hoechste;
    }
    
    
}
