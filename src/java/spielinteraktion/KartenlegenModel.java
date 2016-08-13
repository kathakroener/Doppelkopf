/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spielinteraktion;

import Doppelkopf.Karte;
import Doppelkopf.Spieler;

/**
 *
 * @author hrs
 */
public class KartenlegenModel {
    
    Spieler spieler;
    Karte karte;
    
    

    public Spieler getSpieler() {
        return spieler;
    }

    public void setSpieler(Spieler spieler) {
        this.spieler = spieler;
    }

    public Karte getKarte() {
        return karte;
    }

    public void setKarte(Karte karte) {
        this.karte = karte;
    }
    
    
}
