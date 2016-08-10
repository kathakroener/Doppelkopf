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
public class Spiel {
    private ArrayList<Runde> listRunden;
    private ArrayList<Spieler> listSpieler;
    private ArrayList<Karte> listKarten;
    
    public void listKartenFuellen(){
        listKarten.add(new Karte(1, FARBE.KARO, true, 10, "/bilder/karozehn", BILD.ZEHN));
        listKarten.add(new Karte(3, FARBE.KARO, true, 2, "/bilder/karobube", BILD.BUBE));
        listKarten.add(new Karte(7, FARBE.KARO, true, 3, "/bilder/karodame", BILD.DAME));
        listKarten.add(new Karte(0, FARBE.KARO, true, 4, "/bilder/karokoenig", BILD.KOENIG));
        listKarten.add(new Karte(2, FARBE.KARO, true, 11, "/bilder/karoass", BILD.ASS));
        
        listKarten.add(new Karte(11, FARBE.HERZ, true, 10, "/bilder/herzzehn", BILD.ZEHN));
        listKarten.add(new Karte(4, FARBE.HERZ, true, 2, "/bilder/herzbube", BILD.BUBE));
        listKarten.add(new Karte(8, FARBE.HERZ, true, 3, "/bilder/herzdame", BILD.DAME));
        listKarten.add(new Karte(0, FARBE.HERZ, true, 4, "/bilder/herzkoenig", BILD.KOENIG));
        listKarten.add(new Karte(1, FARBE.HERZ, true, 11, "/bilder/herzass", BILD.ASS));
        
        listKarten.add(new Karte(3, FARBE.PIK, true, 10, "/bilder/pikzehn", BILD.ZEHN));
        listKarten.add(new Karte(5, FARBE.PIK, true, 2, "/bilder/pikbube", BILD.BUBE));
        listKarten.add(new Karte(9, FARBE.PIK, true, 3, "/bilder/pikdame", BILD.DAME));
        listKarten.add(new Karte(2, FARBE.PIK, true, 4, "/bilder/pikkoenig", BILD.KOENIG));
        listKarten.add(new Karte(4, FARBE.PIK, true, 11, "/bilder/pikass", BILD.ASS));
        
        listKarten.add(new Karte(6, FARBE.KREUZ, true, 10, "/bilder/kreuzzehn", BILD.ZEHN));
        listKarten.add(new Karte(6, FARBE.KREUZ, true, 2, "/bilder/kreuzbube", BILD.BUBE));
        listKarten.add(new Karte(10, FARBE.KREUZ, true, 3, "/bilder/kreuzdame", BILD.DAME));
        listKarten.add(new Karte(5, FARBE.KREUZ, true, 4, "/bilder/kreuzkoenig", BILD.KOENIG));
        listKarten.add(new Karte(7, FARBE.KREUZ, true, 11, "/bilder/kreuzass", BILD.ASS));
        
        listKarten.add(new Karte(1, FARBE.KARO, true, 10, "/bilder/karozehn", BILD.ZEHN));
        listKarten.add(new Karte(3, FARBE.KARO, true, 2, "/bilder/karobube", BILD.BUBE));
        listKarten.add(new Karte(7, FARBE.KARO, true, 3, "/bilder/karodame", BILD.DAME));
        listKarten.add(new Karte(0, FARBE.KARO, true, 4, "/bilder/karokoenig", BILD.KOENIG));
        listKarten.add(new Karte(2, FARBE.KARO, true, 11, "/bilder/karoass", BILD.ASS));
        
        listKarten.add(new Karte(11, FARBE.HERZ, true, 10, "/bilder/herzzehn", BILD.ZEHN));
        listKarten.add(new Karte(4, FARBE.HERZ, true, 2, "/bilder/herzbube", BILD.BUBE));
        listKarten.add(new Karte(8, FARBE.HERZ, true, 3, "/bilder/herzdame", BILD.DAME));
        listKarten.add(new Karte(0, FARBE.HERZ, true, 4, "/bilder/herzkoenig", BILD.KOENIG));
        listKarten.add(new Karte(1, FARBE.HERZ, true, 11, "/bilder/herzass", BILD.ASS));
        
        listKarten.add(new Karte(3, FARBE.PIK, true, 10, "/bilder/pikzehn", BILD.ZEHN));
        listKarten.add(new Karte(5, FARBE.PIK, true, 2, "/bilder/pikbube", BILD.BUBE));
        listKarten.add(new Karte(9, FARBE.PIK, true, 3, "/bilder/pikdame", BILD.DAME));
        listKarten.add(new Karte(2, FARBE.PIK, true, 4, "/bilder/pikkoenig", BILD.KOENIG));
        listKarten.add(new Karte(4, FARBE.PIK, true, 11, "/bilder/pikass", BILD.ASS));
        
        listKarten.add(new Karte(6, FARBE.KREUZ, true, 10, "/bilder/kreuzzehn", BILD.ZEHN));
        listKarten.add(new Karte(6, FARBE.KREUZ, true, 2, "/bilder/kreuzbube", BILD.BUBE));
        listKarten.add(new Karte(10, FARBE.KREUZ, true, 3, "/bilder/kreuzdame", BILD.DAME));
        listKarten.add(new Karte(5, FARBE.KREUZ, true, 4, "/bilder/kreuzkoenig", BILD.KOENIG));
        listKarten.add(new Karte(7, FARBE.KREUZ, true, 11, "/bilder/kreuzass", BILD.ASS));
    }
    
    public void auswertung(){
        
    }
    
    public void spielBeginnen(){
        if(listSpieler.size() == 4){
            
        }
    }
    
    public void kartenGeben(){
        
    }
}
