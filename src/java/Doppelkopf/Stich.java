/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doppelkopf;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author katha
 */
public class Stich {
    private LinkedHashMap<Spieler, Karte> mapKarteSpieler;
    private int punkte;
    private Spieler stichGehoert;
    private Karte hoechsteKarte;

    public Stich() {
        this.punkte = 0;
        this.stichGehoert = null;
        this.hoechsteKarte = null;
        this.mapKarteSpieler = new LinkedHashMap();
    }

    public Stich auswerten(){
        for(Entry<Spieler, Karte> entrySpielerKarte : mapKarteSpieler.entrySet()){
            if(stichGehoert == null || hoechsteKarte == null 
                    || (entrySpielerKarte.getValue().istKarteTrumpf() && entrySpielerKarte.getValue().getId() > hoechsteKarte.getId())){
                stichGehoert = entrySpielerKarte.getKey();
                hoechsteKarte = entrySpielerKarte.getValue();
            }else if(!this.getErsteKarte().istKarteTrumpf()){
                if((!entrySpielerKarte.getValue().istKarteTrumpf()
                        && entrySpielerKarte.getValue().getFarbe() == this.getErsteKarte().getFarbe() 
                        && entrySpielerKarte.getValue().getId() > hoechsteKarte.getId())
                        || entrySpielerKarte.getValue().istKarteTrumpf()){
                    stichGehoert = entrySpielerKarte.getKey();
                    hoechsteKarte = entrySpielerKarte.getValue();
                }
            }
        }
        for(Karte k : mapKarteSpieler.values()){
            punkte += k.getWert();
        }
        return this;
    }
    
    public boolean istAbgeschlossen(){
        if(this.getStichGehoert() == null){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean wirdRichtigBedient(Karte gespielteKarte, Spieler spieler){
        ArrayList<Karte> kartenVonSpieler = null;

        //Blatt des übergebenen Spielers ermitteln        
        kartenVonSpieler = Spielverwaltung.getInstance().aktSpiel.getLetzteRunde().getMapBlattSpieler().get(spieler);
        if(gespielteKarte == null){
            System.out.println("gespielteKarte == null");
        }
        //TRUMPF: überprüfen, ob mit ausgewählter Karte falsch bedient würde
        if(!gespielteKarte.istKarteTrumpf() && spielerHatTrumpf(kartenVonSpieler) 
                && this.getErsteKarte().istKarteTrumpf()){
            return false;            
        }else if(!this.getErsteKarte().istKarteTrumpf() 
                && spielerHatFehlFarbe(kartenVonSpieler, this.getErsteKarte().getFarbe())
                &&(gespielteKarte.istKarteTrumpf() || gespielteKarte.getFarbe() != this.getErsteKarte().getFarbe())){
            return false;
        }else{
            //gelegte Karte aus dem Blatt des Spielers entfernen    
//            kartenVonSpieler.remove(gespielteKarte);


            return true;
        }
    }
    
    public boolean spielerHatTrumpf(ArrayList<Karte> kartenVonSpieler){
        //überprüfen, ob Spieler noch Trumpf auf der Hand hat
        for(Karte karte : kartenVonSpieler){
            if(karte.istKarteTrumpf()){
                return true;
            }
        }
        return false;
    }
    
    public boolean spielerHatFehlFarbe(ArrayList<Karte> kartenVonSpieler, FARBE farbe){
        for(Karte karte : kartenVonSpieler){
            if(!karte.istKarteTrumpf() && karte.getFarbe() == farbe){
                return true;
            }
        }
        return false;
    }
    
    public Karte getErsteKarte(){
        Spieler kamRaus;
        if(this.getMapKarteSpieler().isEmpty()){
            return null;
        }
        if(Spielverwaltung.getInstance().aktSpiel.getLetzteRunde().getLetzterAbgeschlossenerStich() == null){
            kamRaus = Spielverwaltung.getInstance().aktSpiel.getLetzteRunde().getKommtRaus();
        } else{
            kamRaus= Spielverwaltung.getInstance().aktSpiel.getLetzteRunde().getLetzterAbgeschlossenerStich().getStichGehoert();
        }
        
        return this.mapKarteSpieler.get(kamRaus);
        
//        for(Karte k : this.getMapKarteSpieler().keySet()){
//            if(k.istKarteTrumpf()){
//                System.out.println("Trumpf muss bedient werden!");
//                return false;
//            } else if(!gespielteKarte.getFarbe().equals(k.getFarbe())){
//                System.out.println(k.getFarbe() + "muss bedient werden!");
//                return false;
//            }
//            break;
//        }
    }
    
    public String getJsonFormat(Spieler spieler, Karte karte){
        String tmpStichGehoert = "";
        if(this.stichGehoert != null){
            tmpStichGehoert = this.stichGehoert.getName();
        }
        return Json.createObjectBuilder()
                .add("rundenAuswertung", false)
                .add("stichGehoert", tmpStichGehoert)
                .add("user", spieler.getName())
                .add("kartenId", karte.getId())
                .add("bildpfad", karte.getBildpfad())
                .build().toString();   
    }
    
    
    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    public LinkedHashMap<Spieler, Karte> getMapKarteSpieler() {
        return mapKarteSpieler;
    }

    public void setMapKarteSpieler(LinkedHashMap<Spieler, Karte> mapKarteSpieler) {
        this.mapKarteSpieler = mapKarteSpieler;
    }

    public Spieler getStichGehoert() {
        return stichGehoert;
    }

    public void setStichGehoert(Spieler stichGehoert) {
        this.stichGehoert = stichGehoert;
    }

    public Karte getHoechsteKarte() {
        return hoechsteKarte;
    }

    public void setHoechsteKarte(Karte hoechsteKarte) {
        this.hoechsteKarte = hoechsteKarte;
    }

}
