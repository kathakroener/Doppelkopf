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
public class Karte {
    private int id;
    private FARBE farbe;
    private int wert;
    private String bildpfad;
    private BILD bild;
    
    public boolean istKarteTrumpf(){
        String karte = farbe.name() + bild.name();
        System.out.println(karte);
        for(TRUMPF t : TRUMPF.values()){
            if(t.name().equals(karte)){
                id = t.ordinal();
                return true;
            }
        }
        for(FEHL f : FEHL.values()){
            if(f.name().equals(karte)){
                id = f.ordinal();
                return false;
            }
        }
        return false;
    }
    
    
    
    
    
    public Karte(int id, FARBE farbe, int wert, String bildpfad, BILD bild) {
        this.id = id;
        this.farbe = farbe;
        this.wert = wert;
        this.bildpfad = bildpfad;
        this.bild = bild;
    }
    
    public Karte(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FARBE getFarbe() {
        return farbe;
    }

    public void setFarbe(FARBE farbe) {
        this.farbe = farbe;
    }

    public int getWert() {
        return wert;
    }

    public void setWert(int wert) {
        this.wert = wert;
    }

    public String getBildpfad() {
        return bildpfad;
    }

    public void setBildpfad(String bildpfad) {
        this.bildpfad = bildpfad;
    }

    public BILD getBild() {
        return bild;
    }

    public void setBild(BILD bild) {
        this.bild = bild;
    }
    
    
}
