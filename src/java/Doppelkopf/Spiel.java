/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doppelkopf;

import DbModel.User;
import java.util.ArrayList;
import websocket.WebSocketEndpoint;

/**
 *
 * @author katha
 */
public class Spiel {
    private ArrayList<Runde> listRunden;
    private ArrayList<Spieler> listSpieler;
    private ArrayList<Karte> listKarten;
    private int zaehler = 0;

    public Spiel(ArrayList<Spieler> teilnehmendeSpieler) {
        listRunden = new ArrayList();
        listSpieler = teilnehmendeSpieler;
        kartenGeben();
    }
    
    public int getPlatz(User user){
        for(int i = 0; i < 4; i++){
            if(listSpieler.get(i).getName().equals(user.getUsername())){
                return i;
            }
        }
        return -1;
    }
    
    public void listKartenFuellen(){
        
        listKarten.add(new Karte(11, FARBE.HERZ, 10, "/bilder/herzzehn", BILD.ZEHN));
        listKarten.add(new Karte(11, FARBE.HERZ, 10, "/bilder/herzzehn", BILD.ZEHN));
        
        listKarten.add(new Karte(10, FARBE.KREUZ, 3, "/bilder/kreuzdame", BILD.DAME));
        listKarten.add(new Karte(10, FARBE.KREUZ, 3, "/bilder/kreuzdame", BILD.DAME));
        listKarten.add(new Karte(9, FARBE.PIK, 3, "/bilder/pikdame", BILD.DAME));
        listKarten.add(new Karte(9, FARBE.PIK, 3, "/bilder/pikdame", BILD.DAME));
        listKarten.add(new Karte(8, FARBE.HERZ, 3, "/bilder/herzdame", BILD.DAME));
        listKarten.add(new Karte(8, FARBE.HERZ, 3, "/bilder/herzdame", BILD.DAME));
        listKarten.add(new Karte(7, FARBE.KARO, 3, "/bilder/karodame", BILD.DAME));
        listKarten.add(new Karte(7, FARBE.KARO, 3, "/bilder/karodame", BILD.DAME));
        
        listKarten.add(new Karte(6, FARBE.KREUZ, 2, "/bilder/kreuzbube", BILD.BUBE));
        listKarten.add(new Karte(6, FARBE.KREUZ, 2, "/bilder/kreuzbube", BILD.BUBE));
        listKarten.add(new Karte(5, FARBE.PIK, 2, "/bilder/pikbube", BILD.BUBE));
        listKarten.add(new Karte(5, FARBE.PIK, 2, "/bilder/pikbube", BILD.BUBE));
        listKarten.add(new Karte(4, FARBE.HERZ, 2, "/bilder/herzbube", BILD.BUBE));
        listKarten.add(new Karte(4, FARBE.HERZ, 2, "/bilder/herzbube", BILD.BUBE));
        listKarten.add(new Karte(3, FARBE.KARO, 2, "/bilder/karobube", BILD.BUBE));
        listKarten.add(new Karte(3, FARBE.KARO, 2, "/bilder/karobube", BILD.BUBE));
        
        listKarten.add(new Karte(2, FARBE.KARO, 11, "/bilder/karoass", BILD.ASS));
        listKarten.add(new Karte(2, FARBE.KARO, 11, "/bilder/karoass", BILD.ASS));
        listKarten.add(new Karte(1, FARBE.KARO, 10, "/bilder/karozehn", BILD.ZEHN));
        listKarten.add(new Karte(1, FARBE.KARO, 10, "/bilder/karozehn", BILD.ZEHN));
        listKarten.add(new Karte(0, FARBE.KARO, 4, "/bilder/karokoenig", BILD.KOENIG));
        listKarten.add(new Karte(0, FARBE.KARO, 4, "/bilder/karokoenig", BILD.KOENIG));
        
        listKarten.add(new Karte(7, FARBE.KREUZ, 11, "/bilder/kreuzass", BILD.ASS));
        listKarten.add(new Karte(7, FARBE.KREUZ, 11, "/bilder/kreuzass", BILD.ASS));
        listKarten.add(new Karte(6, FARBE.KREUZ, 10, "/bilder/kreuzzehn", BILD.ZEHN));
        listKarten.add(new Karte(6, FARBE.KREUZ, 10, "/bilder/kreuzzehn", BILD.ZEHN));
        listKarten.add(new Karte(5, FARBE.KREUZ, 4, "/bilder/kreuzkoenig", BILD.KOENIG));
        listKarten.add(new Karte(5, FARBE.KREUZ, 4, "/bilder/kreuzkoenig", BILD.KOENIG));
        listKarten.add(new Karte(4, FARBE.PIK, 11, "/bilder/pikass", BILD.ASS));
        listKarten.add(new Karte(4, FARBE.PIK, 11, "/bilder/pikass", BILD.ASS));
        listKarten.add(new Karte(3, FARBE.PIK, 10, "/bilder/pikzehn", BILD.ZEHN));
        listKarten.add(new Karte(3, FARBE.PIK, 10, "/bilder/pikzehn", BILD.ZEHN));
        listKarten.add(new Karte(2, FARBE.PIK, 4, "/bilder/pikkoenig", BILD.KOENIG));
        listKarten.add(new Karte(2, FARBE.PIK, 4, "/bilder/pikkoenig", BILD.KOENIG));
        listKarten.add(new Karte(1, FARBE.HERZ, 11, "/bilder/herzass", BILD.ASS));
        listKarten.add(new Karte(1, FARBE.HERZ, 11, "/bilder/herzass", BILD.ASS));
        listKarten.add(new Karte(0, FARBE.HERZ, 4, "/bilder/herzkoenig", BILD.KOENIG));
        listKarten.add(new Karte(0, FARBE.HERZ, 4, "/bilder/herzkoenig", BILD.KOENIG));
    }
    
    public void auswertung(){
        
    }
    
    public void kartenGeben(){
        Runde runde = new Runde();
        ArrayList<Karte> kartenSpieler0 = new ArrayList<>();
        ArrayList<Karte> kartenSpieler1 = new ArrayList<>();
        ArrayList<Karte> kartenSpieler2 = new ArrayList<>();
        ArrayList<Karte> kartenSpieler3 = new ArrayList<>();
        
        int spielerNr = -1;
        Spieler kommtRaus = listSpieler.get(zaehler);
        runde.setKommtRaus(kommtRaus);
        if(zaehler == 3){
            zaehler = 0;
        } else{
            zaehler++;
        }
        
        for(int i = 39; i >=0; i--){
            spielerNr = (int)(Math.random() * 4);
            Spieler bekommtKarte = listSpieler.get(spielerNr);
            switch(spielerNr){
                case 0:
                    if(kartenSpieler0.size() < 10){
                        kartenSpieler0.add(listKarten.get(i));
                        listKarten.remove(i);
                    }else{
                        i++;
                    }
                case 1: 
                    if(kartenSpieler1.size() < 10){
                        kartenSpieler1.add(listKarten.get(i));
                        listKarten.remove(i);
                    }else{
                        i++;
                    }
                case 2: 
                    if(kartenSpieler2.size() < 10){
                        kartenSpieler2.add(listKarten.get(i));
                        listKarten.remove(i);
                    }else{
                        i++;
                    }
                case 3: 
                    if(kartenSpieler3.size() < 10){
                        kartenSpieler3.add(listKarten.get(i));
                        listKarten.remove(i);
                    }else{
                        i++;
                    }
            } 
        }
        
        runde.getMapBlattSpieler().put(kartenSpieler0, listSpieler.get(0));
        runde.getMapBlattSpieler().put(kartenSpieler1, listSpieler.get(1));
        runde.getMapBlattSpieler().put(kartenSpieler2, listSpieler.get(2));
        runde.getMapBlattSpieler().put(kartenSpieler3, listSpieler.get(3));
        
        WebSocketEndpoint.getInstance().verteileKarten(runde);
    }
}
