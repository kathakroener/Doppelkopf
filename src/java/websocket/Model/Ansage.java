/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websocket.Model;

import Doppelkopf.ANSAGEN;
import Doppelkopf.Spieler;

/**
 *
 * @author katha
 */
public class Ansage {
    Spieler spieler;
    ANSAGEN ansage;

    public Ansage() {
    }
    
    public Ansage(String jsonText) {
    }

    public Spieler getSpieler() {
        return spieler;
    }

    public void setSpieler(Spieler spieler) {
        this.spieler = spieler;
    }

    public ANSAGEN getAnsage() {
        return ansage;
    }

    public void setAnsage(ANSAGEN ansage) {
        this.ansage = ansage;
    }
    
    
}
