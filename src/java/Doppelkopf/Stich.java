/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doppelkopf;

/**
 *
 * @author katha
 */
public class Stich {
    private Karte spieler1;
    private Karte spieler2;
    private Karte spieler3;
    private Karte spieler4;
    private int punkte;
    private int fuchsGefangen; // 0 = nichts, 1 = Re hat Fuchs gefangen, 2 = Contra hat Fuchs gefangen
    private boolean stichGehoertTeam; // 0 = Contra, 1 = Re
    
    public void zaehlen(){
        punkte = spieler1.getWert() + spieler2.getWert() + spieler3.getWert() + spieler4.getWert();
    }
    
    public void stichGehoert(){
        Karte hoechste = spieler1;
        if(spieler2.getId() > hoechste.getId()){
            hoechste = spieler2;
        } else if(spieler3.getId() > hoechste.getId()){
            hoechste = spieler3;
        } else if(spieler4.getId() > hoechste.getId()){
            hoechste = spieler4;
        }
    }

    public Karte getSpieler1() {
        return spieler1;
    }

    public void setSpieler1(Karte spieler1) {
        this.spieler1 = spieler1;
    }

    public Karte getSpieler2() {
        return spieler2;
    }

    public void setSpieler2(Karte spieler2) {
        this.spieler2 = spieler2;
    }

    public Karte getSpieler3() {
        return spieler3;
    }

    public void setSpieler3(Karte spieler3) {
        this.spieler3 = spieler3;
    }

    public Karte getSpieler4() {
        return spieler4;
    }

    public void setSpieler4(Karte spieler4) {
        this.spieler4 = spieler4;
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
    
    
}
