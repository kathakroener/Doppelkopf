/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doppelkopf;

import java.util.ArrayList;

/**
 *
 * @author katha
 */
public class Spieler {
    private String name;
    private boolean istRe;
    private ArrayList<Karte> blatt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIstRe() {
        return istRe;
    }

    public void setIstRe(boolean istRe) {
        this.istRe = istRe;
    }

    public ArrayList<Karte> getBlatt() {
        return blatt;
    }

    public void setBlatt(ArrayList<Karte> blatt) {
        this.blatt = blatt;
    }
    
    
}
