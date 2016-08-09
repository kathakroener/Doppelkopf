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
    private int fuchsGefangen; // 0 = nichts, 1 = Re hat Fuchs gefangen, 2 = Contra hat Fuchs gefangen
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
    
    public void fuchsGefangen(){
        boolean fuchsGefunden = false;
        for(Karte fuchs : mapKarteSpieler.keySet()){
            if(fuchs.isIstTrumpf() && fuchs.getId() == 2){
                fuchsGefunden = true;
                for(Karte hoeherAlsFuchs : mapKarteSpieler.keySet()){
                    if(hoeherAlsFuchs.isIstTrumpf() && hoeherAlsFuchs.getId() > 2){
                        if(mapKarteSpieler.get(hoeherAlsFuchs).isIstRe() == true && mapKarteSpieler.get(fuchs).isIstRe() == false){
                            fuchsGefangen = 1;
                        } else if(mapKarteSpieler.get(hoeherAlsFuchs).isIstRe() == false && mapKarteSpieler.get(fuchs).isIstRe() == true){
                            fuchsGefangen = 2;
                        }
                    }
                }  
            } else{
                fuchsGefangen = 0;
            }
        }
    }


    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    public int getFuchsGefangen() {
        return fuchsGefangen;
    }

    public void setFuchsGefangen(int fuchsGefangen) {
        this.fuchsGefangen = fuchsGefangen;
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
    
    
}
