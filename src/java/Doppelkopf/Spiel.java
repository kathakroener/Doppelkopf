/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doppelkopf;

import DbModel.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.websocket.EncodeException;
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

    public Spiel(ArrayList<Spieler> teilnehmendeSpieler){
        listRunden = new ArrayList();
        listSpieler = teilnehmendeSpieler;
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
        listKarten = new ArrayList<Karte>();
        listKarten.add(new Karte(11, FARBE.HERZ, 10, "bilder/herzzehn.jpg", BILD.ZEHN));
        listKarten.add(new Karte(11, FARBE.HERZ, 10, "bilder/herzzehn.jpg", BILD.ZEHN));
        
        listKarten.add(new Karte(10, FARBE.KREUZ, 3, "bilder/kreuzdame.jpg", BILD.DAME));
        listKarten.add(new Karte(10, FARBE.KREUZ, 3, "bilder/kreuzdame.jpg", BILD.DAME));
        listKarten.add(new Karte(9, FARBE.PIK, 3, "bilder/pikdame.jpg", BILD.DAME));
        listKarten.add(new Karte(9, FARBE.PIK, 3, "bilder/pikdame.jpg", BILD.DAME));
        listKarten.add(new Karte(8, FARBE.HERZ, 3, "bilder/herzdame.jpg", BILD.DAME));
        listKarten.add(new Karte(8, FARBE.HERZ, 3, "bilder/herzdame.jpg", BILD.DAME));
        listKarten.add(new Karte(7, FARBE.KARO, 3, "bilder/karodame.jpg", BILD.DAME));
        listKarten.add(new Karte(7, FARBE.KARO, 3, "bilder/karodame.jpg", BILD.DAME));
        
        listKarten.add(new Karte(6, FARBE.KREUZ, 2, "bilder/kreuzbube.jpg", BILD.BUBE));
        listKarten.add(new Karte(6, FARBE.KREUZ, 2, "bilder/kreuzbube.jpg", BILD.BUBE));
        listKarten.add(new Karte(5, FARBE.PIK, 2, "bilder/pikbube.jpg", BILD.BUBE));
        listKarten.add(new Karte(5, FARBE.PIK, 2, "bilder/pikbube.jpg", BILD.BUBE));
        listKarten.add(new Karte(4, FARBE.HERZ, 2, "bilder/herzbube.jpg", BILD.BUBE));
        listKarten.add(new Karte(4, FARBE.HERZ, 2, "bilder/herzbube.jpg", BILD.BUBE));
        listKarten.add(new Karte(3, FARBE.KARO, 2, "bilder/karobube.jpg", BILD.BUBE));
        listKarten.add(new Karte(3, FARBE.KARO, 2, "bilder/karobube.jpg", BILD.BUBE));
        
        listKarten.add(new Karte(2, FARBE.KARO, 11, "bilder/karoass.jpg", BILD.ASS));
        listKarten.add(new Karte(2, FARBE.KARO, 11, "bilder/karoass.jpg", BILD.ASS));
        listKarten.add(new Karte(1, FARBE.KARO, 10, "bilder/karozehn.jpg", BILD.ZEHN));
        listKarten.add(new Karte(1, FARBE.KARO, 10, "bilder/karozehn.jpg", BILD.ZEHN));
        listKarten.add(new Karte(0, FARBE.KARO, 4, "bilder/karokoenig.jpg", BILD.KOENIG));
        listKarten.add(new Karte(0, FARBE.KARO, 4, "bilder/karokoenig.jpg", BILD.KOENIG));
        
        listKarten.add(new Karte(-1, FARBE.KREUZ, 11, "bilder/kreuzass.jpg", BILD.ASS));
        listKarten.add(new Karte(-1, FARBE.KREUZ, 11, "bilder/kreuzass.jpg", BILD.ASS));
        listKarten.add(new Karte(-2, FARBE.KREUZ, 10, "bilder/kreuzzehn.jpg", BILD.ZEHN));
        listKarten.add(new Karte(-2, FARBE.KREUZ, 10, "bilder/kreuzzehn.jpg", BILD.ZEHN));
        listKarten.add(new Karte(-3, FARBE.KREUZ, 4, "bilder/kreuzkoenig.jpg", BILD.KOENIG));
        listKarten.add(new Karte(-3, FARBE.KREUZ, 4, "bilder/kreuzkoenig.jpg", BILD.KOENIG));
        listKarten.add(new Karte(-4, FARBE.PIK, 11, "bilder/pikass.jpg", BILD.ASS));
        listKarten.add(new Karte(-4, FARBE.PIK, 11, "bilder/pikass.jpg", BILD.ASS));
        listKarten.add(new Karte(-5, FARBE.PIK, 10, "bilder/pikzehn.jpg", BILD.ZEHN));
        listKarten.add(new Karte(-5, FARBE.PIK, 10, "bilder/pikzehn.jpg", BILD.ZEHN));
        listKarten.add(new Karte(-6, FARBE.PIK, 4, "bilder/pikkoenig.jpg", BILD.KOENIG));
        listKarten.add(new Karte(-6, FARBE.PIK, 4, "bilder/pikkoenig.jpg", BILD.KOENIG));
        listKarten.add(new Karte(-7, FARBE.HERZ, 11, "bilder/herzass.jpg", BILD.ASS));
        listKarten.add(new Karte(-7, FARBE.HERZ, 11, "bilder/herzass.jpg", BILD.ASS));
        listKarten.add(new Karte(-8, FARBE.HERZ, 4, "bilder/herzkoenig.jpg", BILD.KOENIG));
        listKarten.add(new Karte(-8, FARBE.HERZ, 4, "bilder/herzkoenig.jpg", BILD.KOENIG));
    }
    
    public void auswertung(){
        
    }
    
    public Spieler getSpielerMitUsername(String username){
        for(Spieler spieler : this.listSpieler){
            if(spieler.getName().equals(username)){
                return spieler;
            }
        }
        return null;
    }
    
    
    
    public Runde kartenGeben() throws IOException, EncodeException{
        listKartenFuellen();
        Spieler kommtRaus = listSpieler.get(zaehler);
        Runde runde = new Runde(kommtRaus);
        if(zaehler == 3){
            zaehler = 0;
        } else{
            zaehler++;
        }
        
        ArrayList<Karte> kartenSpieler0 = new ArrayList<>();
        ArrayList<Karte> kartenSpieler1 = new ArrayList<>();
        ArrayList<Karte> kartenSpieler2 = new ArrayList<>();
        ArrayList<Karte> kartenSpieler3 = new ArrayList<>();
        
        int spielerNr;

        for(int i = 39; i >= 0; i--){
            spielerNr = (int)(Math.random() * 4);
            Spieler bekommtKarte = listSpieler.get(spielerNr);
            if(i == listKarten.size()){
                System.out.println("Fehler");
            }
            switch(spielerNr){
                case 0:
                    if(kartenSpieler0.size() < 10){
                        kartenSpieler0.add(listKarten.get(i));
                        listKarten.remove(i);
                    }else{
                        i++;
                    }
                    break;
                case 1: 
                    if(kartenSpieler1.size() < 10){
                        kartenSpieler1.add(listKarten.get(i));
                        listKarten.remove(i);
                    }else{
                        i++;
                    }
                    break;
                case 2: 
                    if(kartenSpieler2.size() < 10){
                        kartenSpieler2.add(listKarten.get(i));
                        listKarten.remove(i);
                    }else{
                        i++;
                    }
                    break;
                case 3: 
                    if(kartenSpieler3.size() < 10){
                        kartenSpieler3.add(listKarten.get(i));
                        listKarten.remove(i);
                    }else{
                        i++;
                    }
                    break;
            } 
        }
        
        runde.getMapBlattSpieler().put(listSpieler.get(0), kartenSpieler0);
        runde.getMapBlattSpieler().put(listSpieler.get(1), kartenSpieler1);
        runde.getMapBlattSpieler().put(listSpieler.get(2), kartenSpieler2);
        runde.getMapBlattSpieler().put(listSpieler.get(3), kartenSpieler3);
        runde.fuelleListenKontraRe(listSpieler);
        this.listRunden.add(runde);
        return runde;
//        WebSocketEndpoint.getInstance().verteileKarten(runde);
    }
    
    public Runde getLetzteRunde(){
        if(this.listRunden.isEmpty()){
            return null;
        }else{
            return this.listRunden.get(this.listRunden.size() - 1 );
        }
    }

    public ArrayList<Runde> getListRunden() {
        return listRunden;
    }

    public void setListRunden(ArrayList<Runde> listRunden) {
        this.listRunden = listRunden;
    }

    public ArrayList<Spieler> getListSpieler() {
        return listSpieler;
    }

    public void setListSpieler(ArrayList<Spieler> listSpieler) {
        this.listSpieler = listSpieler;
    }

    public ArrayList<Karte> getListKarten() {
        return listKarten;
    }

    public void setListKarten(ArrayList<Karte> listKarten) {
        this.listKarten = listKarten;
    }
    
    
}
