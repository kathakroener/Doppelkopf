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
    private int zaehler = 0;
    
    public void listKartenFuellen(){
        listKarten.add(new Karte(1, FARBE.KARO, 10, "/bilder/karozehn", BILD.ZEHN));
        listKarten.add(new Karte(3, FARBE.KARO, 2, "/bilder/karobube", BILD.BUBE));
        listKarten.add(new Karte(7, FARBE.KARO, 3, "/bilder/karodame", BILD.DAME));
        listKarten.add(new Karte(0, FARBE.KARO, 4, "/bilder/karokoenig", BILD.KOENIG));
        listKarten.add(new Karte(2, FARBE.KARO, 11, "/bilder/karoass", BILD.ASS));
        
        listKarten.add(new Karte(11, FARBE.HERZ, 10, "/bilder/herzzehn", BILD.ZEHN));
        listKarten.add(new Karte(4, FARBE.HERZ, 2, "/bilder/herzbube", BILD.BUBE));
        listKarten.add(new Karte(8, FARBE.HERZ, 3, "/bilder/herzdame", BILD.DAME));
        listKarten.add(new Karte(0, FARBE.HERZ, 4, "/bilder/herzkoenig", BILD.KOENIG));
        listKarten.add(new Karte(1, FARBE.HERZ, 11, "/bilder/herzass", BILD.ASS));
        
        listKarten.add(new Karte(3, FARBE.PIK, 10, "/bilder/pikzehn", BILD.ZEHN));
        listKarten.add(new Karte(5, FARBE.PIK, 2, "/bilder/pikbube", BILD.BUBE));
        listKarten.add(new Karte(9, FARBE.PIK, 3, "/bilder/pikdame", BILD.DAME));
        listKarten.add(new Karte(2, FARBE.PIK, 4, "/bilder/pikkoenig", BILD.KOENIG));
        listKarten.add(new Karte(4, FARBE.PIK, 11, "/bilder/pikass", BILD.ASS));
        
        listKarten.add(new Karte(6, FARBE.KREUZ, 10, "/bilder/kreuzzehn", BILD.ZEHN));
        listKarten.add(new Karte(6, FARBE.KREUZ, 2, "/bilder/kreuzbube", BILD.BUBE));
        listKarten.add(new Karte(10, FARBE.KREUZ, 3, "/bilder/kreuzdame", BILD.DAME));
        listKarten.add(new Karte(5, FARBE.KREUZ, 4, "/bilder/kreuzkoenig", BILD.KOENIG));
        listKarten.add(new Karte(7, FARBE.KREUZ, 11, "/bilder/kreuzass", BILD.ASS));
        
        listKarten.add(new Karte(1, FARBE.KARO, 10, "/bilder/karozehn", BILD.ZEHN));
        listKarten.add(new Karte(3, FARBE.KARO, 2, "/bilder/karobube", BILD.BUBE));
        listKarten.add(new Karte(7, FARBE.KARO, 3, "/bilder/karodame", BILD.DAME));
        listKarten.add(new Karte(0, FARBE.KARO, 4, "/bilder/karokoenig", BILD.KOENIG));
        listKarten.add(new Karte(2, FARBE.KARO, 11, "/bilder/karoass", BILD.ASS));
        
        listKarten.add(new Karte(11, FARBE.HERZ, 10, "/bilder/herzzehn", BILD.ZEHN));
        listKarten.add(new Karte(4, FARBE.HERZ, 2, "/bilder/herzbube", BILD.BUBE));
        listKarten.add(new Karte(8, FARBE.HERZ, 3, "/bilder/herzdame", BILD.DAME));
        listKarten.add(new Karte(0, FARBE.HERZ, 4, "/bilder/herzkoenig", BILD.KOENIG));
        listKarten.add(new Karte(1, FARBE.HERZ, 11, "/bilder/herzass", BILD.ASS));
        
        listKarten.add(new Karte(3, FARBE.PIK, 10, "/bilder/pikzehn", BILD.ZEHN));
        listKarten.add(new Karte(5, FARBE.PIK, 2, "/bilder/pikbube", BILD.BUBE));
        listKarten.add(new Karte(9, FARBE.PIK, 3, "/bilder/pikdame", BILD.DAME));
        listKarten.add(new Karte(2, FARBE.PIK, 4, "/bilder/pikkoenig", BILD.KOENIG));
        listKarten.add(new Karte(4, FARBE.PIK, 11, "/bilder/pikass", BILD.ASS));
        
        listKarten.add(new Karte(6, FARBE.KREUZ, 10, "/bilder/kreuzzehn", BILD.ZEHN));
        listKarten.add(new Karte(6, FARBE.KREUZ, 2, "/bilder/kreuzbube", BILD.BUBE));
        listKarten.add(new Karte(10, FARBE.KREUZ, 3, "/bilder/kreuzdame", BILD.DAME));
        listKarten.add(new Karte(5, FARBE.KREUZ, 4, "/bilder/kreuzkoenig", BILD.KOENIG));
        listKarten.add(new Karte(7, FARBE.KREUZ, 11, "/bilder/kreuzass", BILD.ASS));
    }
    
    public void auswertung(){
        
    }
    
    public void spielBeginnen(){
        if(listSpieler.size() == 4){
            
        }
    }
    
    public void kartenGeben(){
        Runde r = new Runde();
        ArrayList<Karte> spieler1 = new ArrayList<>();
        ArrayList<Karte> spieler2 = new ArrayList<>();
        ArrayList<Karte> spieler3 = new ArrayList<>();
        ArrayList<Karte> spieler0 = new ArrayList<>();
        int spielerNr = -1;
        Spieler kommtRaus = listSpieler.get(zaehler);
        r.setKommtRaus(kommtRaus);
        if(zaehler == 3){
            zaehler = 0;
        } else{
            zaehler++;
        }
        for(int i = 39; i >=0; i--){
            spielerNr = (int)(Math.random() * 4);
            Spieler bekommtKarte = listSpieler.get(spielerNr);
            switch(spielerNr){
                case 0: spieler0.add(listKarten.get(i));
                case 1: spieler1.add(listKarten.get(i));
                case 2: spieler2.add(listKarten.get(i));
                case 3: spieler3.add(listKarten.get(i));
            }
            listKarten.remove(i);
        }
        r.getMapBlattSpieler().put(spieler0, listSpieler.get(0));
        r.getMapBlattSpieler().put(spieler1, listSpieler.get(1));
        r.getMapBlattSpieler().put(spieler2, listSpieler.get(2));
        r.getMapBlattSpieler().put(spieler3, listSpieler.get(3));
    }
}
