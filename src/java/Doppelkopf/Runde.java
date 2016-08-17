/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doppelkopf;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

/**
 *
 * @author katha
 */
public class Runde {
    private int punkteRe;
    private int punkteContra;
    private ArrayList<Stich> stiche;
    private LinkedHashMap<ANSAGEN, Spieler> mapAnsagenSpieler;
    private Spieler kommtRaus;
    private ArrayList<Spieler> listSpielerRe;
    private ArrayList<Spieler> listSpielerContra;
    public LinkedHashMap<Spieler, ArrayList<Karte>> mapBlattSpieler;
    private int tackenRe;

    public Runde(Spieler kommtRaus) {
        this.mapBlattSpieler = new LinkedHashMap<>();
        this.mapAnsagenSpieler = new LinkedHashMap<>();
        this.listSpielerRe = new ArrayList<>();
        this.listSpielerContra = new ArrayList<>();
        this.stiche = new ArrayList<>();
        this.kommtRaus = kommtRaus;
    }
    
    public void fuelleListenKontraRe(ArrayList<Spieler> listSpieler){
        for(Spieler spieler : listSpieler){
            boolean contra = true;
            for(Karte k : mapBlattSpieler.get(spieler)){
                    if(k.istKarteTrumpf() && k.getId() == 10){
                        contra = false;
                    }
            }
            if(contra){
                listSpielerContra.add(spieler);
            }else{
                listSpielerRe.add(spieler);
            }
        }
    }
    
    public void auswertung(){
        berechnePunkte();
        berechneTackenRe();
    }
    
    public void berechnePunkte(){
        for(Stich s : stiche){
            if(listSpielerRe.contains(s.getStichGehoert())){
                punkteRe += s.getPunkte();
            }
        }
        punkteContra = 240 - punkteRe;
    }
    
    public void berechneTackenRe(){
        tackenRe = 0;
        if(punkteRe <= 120){
            tackenRe = tackenRe - 2;  //keine 120, gegen
            if(punkteRe < 90){
                tackenRe--;
                if(punkteRe < 60){
                    tackenRe--;
                    if(punkteRe < 30){
                        tackenRe--;
                        if(punkteRe == 0){
                            tackenRe--;
                        }
                    }
                }
            }
        }
        if(punkteRe > 120){
            tackenRe++;
            if(punkteRe > 150){
                tackenRe++;
                if(punkteRe > 180){
                    tackenRe++;
                    if(punkteRe > 210){
                        tackenRe++;
                    }
                }
            }
        }
//        fuchsGefangen();
    }
    
    
    public void fuchsGefangen(){
        Karte fuchsGefunden = null;
        for(Stich s : stiche){
            for(Karte k : s.getMapKarteSpieler().values()){
                if(k.istKarteTrumpf() && k.getId() == 2){
                    
                    //überprüfen, ob der Stich eine höhere Karte als den Fuchs enthält
                    if(s.getHoechsteKarte().istKarteTrumpf() && s.getHoechsteKarte().getId() > 2){
                        //überprüfen, ob die höhere Karte aus dem gleichen Team kommt wie der Fuchs
                        if(this.listSpielerRe.contains(s.getStichGehoert()) && this.listSpielerContra.contains(s.getMapKarteSpieler().get(k))){
                            tackenRe++;
                        } else if(this.listSpielerContra.contains(s.getStichGehoert()) && this.listSpielerRe.contains(s.getMapKarteSpieler().get(k))){
                            tackenRe--;
                        }
                    }
                    
                    //überprüfen, ob mit dem ersten Fuchs ein zweiter gefangen wurde
                    if(fuchsGefunden != null && s.getHoechsteKarte().getId() == 2){
                        if(this.listSpielerRe.contains(s.getMapKarteSpieler().get(k)) && this.listSpielerContra.contains(s.getMapKarteSpieler().get(fuchsGefunden))){
                            tackenRe--;
                        } else if(this.listSpielerContra.contains(s.getMapKarteSpieler().get(k)) && this.listSpielerRe.contains(s.getMapKarteSpieler().get(fuchsGefunden))){
                            tackenRe++;
                        }
                    }
                    fuchsGefunden = k;
                }
            }
        }
    }
    
    public Stich getLetzterAbgeschlossenerStich(){
        if(this.getStiche().isEmpty()){
            return null;
        }else{
            if(this.getStiche().size() > 1 && !this.getStiche().get(this.getStiche().size() - 1).istAbgeschlossen()){
                return this.getStiche().get(this.getStiche().size() - 2);
            }
//            else if(this.getStiche().size() > 1 && this.getStiche().get(this.getStiche().size() - 1).istAbgeschlossen()){
//                return this.getStiche().get(this.getStiche().size() - 1);
//            }
            else{
                return null;
            }
            
        }
    }
    
    public Stich getAktuellerOffenerStich(){
        if(this.getStiche().isEmpty()){
            return null;
        }else{
            if(!this.getStiche().get(this.getStiche().size() - 1).istAbgeschlossen()){
                return this.getStiche().get(this.getStiche().size() - 1);
            }
            else{
                return null;
            }
        }
    }
    
    public boolean rundeBeendet(){
        if(stiche.size() == 10){
            return true;
        }
        return false;
    }
    
    public Karte getKarteMitId(Spieler spieler, int id){
        ArrayList<Karte> blattSpieler = this.mapBlattSpieler.get(spieler);
        if(blattSpieler != null){
            for(Karte karte : blattSpieler){
                if(karte.getId() == id){
                    return karte;
                }
            }
        }
        return null;
    }
    
    public String getAuswertungJsonString(){
        JsonArrayBuilder jsonArrayBuilderListSpielerRe = Json.createArrayBuilder();
        for(Spieler spieler : listSpielerRe){
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("name", spieler.getName());
            jsonArrayBuilderListSpielerRe.add(jsonObjectBuilder.build());
        } 
        JsonArrayBuilder jsonArrayBuilderListSpielerContra = Json.createArrayBuilder();
        for(Spieler spieler : listSpielerContra){
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("name", spieler.getName());
            jsonArrayBuilderListSpielerContra.add(jsonObjectBuilder.build());
        }
        
        return Json.createObjectBuilder()
                .add("rundenAuswertung", true)
                .add("auswertungRunde", new AuswertungRunde(this.punkteRe, this.punkteContra, this.mapAnsagenSpieler).getJsonObjectAuswertungRunde())
                .add("spielerRe", jsonArrayBuilderListSpielerRe.build())
                .add("spielerContra", jsonArrayBuilderListSpielerContra.build())
                .build().toString();   
    }
    
    public String blattToJSON(){
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        Spieler spieler0 = Spielverwaltung.getInstance().spielerPlatz0;
        Spieler spieler1 = Spielverwaltung.getInstance().spielerPlatz1;
        Spieler spieler2 = Spielverwaltung.getInstance().spielerPlatz2;
        Spieler spieler3 = Spielverwaltung.getInstance().spielerPlatz3;
        
        jsonObjectBuilder.add("kommtRaus", getKommtRaus().getName());
        
        jsonObjectBuilder.add("spielerRe", createJsonArrayForReSpieler(this.listSpielerRe));
        jsonObjectBuilder.add("spielerContra", createJsonArrayForContraSpieler(this.listSpielerContra));
        
        jsonObjectBuilder.add("0", createJsonArrayFromBlatt(this.mapBlattSpieler.get(spieler0)));
        jsonObjectBuilder.add("1", createJsonArrayFromBlatt(this.mapBlattSpieler.get(spieler1)));
        jsonObjectBuilder.add("2", createJsonArrayFromBlatt(this.mapBlattSpieler.get(spieler2)));
        jsonObjectBuilder.add("3", createJsonArrayFromBlatt(this.mapBlattSpieler.get(spieler3)));
        
        return jsonObjectBuilder.build().toString();
    }
    
    private JsonArray createJsonArrayFromBlatt(ArrayList<Karte> listKarte){
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        for(Karte karte : listKarte){
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("id", karte.getId());
            jsonObjectBuilder.add("bildpfad", karte.getBildpfad());
            jsonArrayBuilder.add(jsonObjectBuilder.build());
        }  
        return jsonArrayBuilder.build();
    }
    
    private JsonArray createJsonArrayForReSpieler(ArrayList<Spieler> listSpieler){
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        for(Spieler spieler : listSpieler){
            if(this.listSpielerRe.contains(spieler)){
                JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
                jsonObjectBuilder.add("name", spieler.getName());
                jsonArrayBuilder.add(jsonObjectBuilder.build());
            }
        }  
        return jsonArrayBuilder.build();
    }
    
    private JsonArray createJsonArrayForContraSpieler(ArrayList<Spieler> listSpieler){
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        for(Spieler spieler : listSpieler){
            if(this.listSpielerContra.contains(spieler)){
                JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
                jsonObjectBuilder.add("name", spieler.getName());
                jsonArrayBuilder.add(jsonObjectBuilder.build());
            }
        }  
        return jsonArrayBuilder.build();
    }

    public int getPunkteRe() {
        return punkteRe;
    }

    public void setPunkteRe(int punkteRe) {
        this.punkteRe = punkteRe;
    }

    public int getPunkteContra() {
        return punkteContra;
    }

    public void setPunkteContra(int punkteContra) {
        this.punkteContra = punkteContra;
    }

    public ArrayList<Stich> getStiche() {
        return stiche;
    }

    public void setStiche(ArrayList<Stich> stiche) {
        this.stiche = stiche;
    }

    public LinkedHashMap<ANSAGEN, Spieler> getMapAnsagenSpieler() {
        return mapAnsagenSpieler;
    }

    public void setMapAnsagenSpieler(LinkedHashMap<ANSAGEN, Spieler> mapAnsagenSpieler) {
        this.mapAnsagenSpieler = mapAnsagenSpieler;
    }

    public Spieler getKommtRaus() {
        return kommtRaus;
    }

    public void setKommtRaus(Spieler kommtRaus) {
        this.kommtRaus = kommtRaus;
    }

    public ArrayList<Spieler> getListSpielerRe() {
        return listSpielerRe;
    }

    public void setListSpielerRe(ArrayList<Spieler> listSpielerRe) {
        this.listSpielerRe = listSpielerRe;
    }

    public ArrayList<Spieler> getListSpielerContra() {
        return listSpielerContra;
    }

    public void setListSpielerContra(ArrayList<Spieler> listSpielerContra) {
        this.listSpielerContra = listSpielerContra;
    }
    
    public LinkedHashMap<Spieler, ArrayList<Karte>> getMapBlattSpieler() {
        return mapBlattSpieler;
    }

    public void setMapBlattSpieler(LinkedHashMap<Spieler, ArrayList<Karte>> mapBlattSpieler) {
        this.mapBlattSpieler = mapBlattSpieler;
    }

    public int getTackenRe() {
        return tackenRe;
    }

    public void setTackenRe(int tackenRe) {
        this.tackenRe = tackenRe;
    }    
}
