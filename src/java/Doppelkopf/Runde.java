/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doppelkopf;

import java.util.ArrayList;
import java.util.LinkedHashMap;

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
    private ArrayList<Spieler> re;
    private ArrayList<Spieler> contra;
    private LinkedHashMap<ArrayList<Karte>, Spieler> mapBlattSpieler;
    private int tackenRe;
    
    
    public void istRe(){
        for(ArrayList<Karte> blatt : mapBlattSpieler.keySet()){
            for(Karte k : blatt){
                if(k.isIstTrumpf() && k.getId() == 10){
                    re.add(mapBlattSpieler.get(blatt));
                }
            }
        }
    }
    
    public void istContra(){
        if(!re.isEmpty()){
            for(Spieler sp : mapBlattSpieler.values()){
                if(!re.contains(sp)){
                    contra.add(sp);
                }
            }
        }
    }
    
    public void berechnePunkte(){
        for(Stich s : stiche){
            if(re.contains(s.getStichGehoert())){
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
        fuchsGefangen();
    }
    
    
    public void fuchsGefangen(){
        Karte fuchsGefunden = null;
        for(Stich s : stiche){
            for(Karte k : s.getMapKarteSpieler().keySet()){
                if(k.isIstTrumpf() && k.getId() == 2){
                    if(s.getHoechste().isIstTrumpf() && s.getHoechste().getId() > 2){
                        if(re.contains(s.getStichGehoert()) && contra.contains(s.getMapKarteSpieler().get(k))){
                            tackenRe++;
                        } else if(contra.contains(s.getStichGehoert()) && re.contains(s.getMapKarteSpieler().get(k))){
                            tackenRe--;
                        }
                    }
                    if(fuchsGefunden != null){
                        if(re.contains(s.getMapKarteSpieler().get(k)) && contra.contains(s.getMapKarteSpieler().get(fuchsGefunden))){
                            tackenRe--;
                        } else if(contra.contains(s.getMapKarteSpieler().get(k)) && re.contains(s.getMapKarteSpieler().get(fuchsGefunden))){
                            tackenRe++;
                        }
                    }
                    fuchsGefunden = k;
                }
            }
        }
    }
    

    
    public boolean rundeBeendet(){
        if(stiche.size() == 10){
            return true;
        }
        return false;
    }
    
    public Runde(){
    }

    public Runde(int punkteRe, int punkteContra, ArrayList<Stich> stiche, LinkedHashMap<ANSAGEN, Spieler> mapAnsagenSpieler, Spieler kommtRaus, ArrayList<Spieler> re, ArrayList<Spieler> contra, LinkedHashMap<ArrayList<Karte>, Spieler> mapBlattSpieler) {
        this.punkteRe = punkteRe;
        this.punkteContra = punkteContra;
        this.stiche = stiche;
        this.mapAnsagenSpieler = mapAnsagenSpieler;
        this.kommtRaus = kommtRaus;
        this.re = re;
        this.contra = contra;
        this.mapBlattSpieler = mapBlattSpieler;
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

    public ArrayList<Spieler> getRe() {
        return re;
    }

    public void setRe(ArrayList<Spieler> re) {
        this.re = re;
    }

    public ArrayList<Spieler> getContra() {
        return contra;
    }

    public void setContra(ArrayList<Spieler> contra) {
        this.contra = contra;
    }

    public LinkedHashMap<ArrayList<Karte>, Spieler> getMapBlattSpieler() {
        return mapBlattSpieler;
    }

    public void setMapBlattSpieler(LinkedHashMap<ArrayList<Karte>, Spieler> mapBlattSpieler) {
        this.mapBlattSpieler = mapBlattSpieler;
    }

    public int getTackenRe() {
        return tackenRe;
    }

    public void setTackenRe(int tackenRe) {
        this.tackenRe = tackenRe;
    }
    
    
}
