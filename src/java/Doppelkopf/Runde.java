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
    
    public void berechnePunkte(){
        for(Stich s : stiche){
            if(s.getStichGehoert().isIstRe()){
                punkteRe += s.getPunkte();
            }
        }
        punkteContra = 240 - punkteRe;
    }
    
    
    public int berechneTackenRe(){
        int tacken = 0;
        if(punkteRe <= 120){
            tacken = tacken - 2;  //keine 120, gegen
            if(punkteRe < 90){
                tacken--;
                if(punkteRe < 60){
                    tacken--;
                    if(punkteRe < 30){
                        tacken--;
                        if(punkteRe == 0){
                            tacken--;
                        }
                    }
                }
            }
        }
        if(punkteRe > 120){
            tacken++;
            if(punkteRe > 150){
                tacken++;
                if(punkteRe > 180){
                    tacken++;
                    if(punkteRe > 210){
                        tacken++;
                    }
                }
            }
        }
        for(int i = 0; i < stiche.size(); i++){
            if(stiche.get(i).getFuchsGefangen() == 1){
                tacken++;
            }
            if(stiche.get(i).getFuchsGefangen() == 2){
                tacken--;
            }
        }
        return tacken;
    }
}
