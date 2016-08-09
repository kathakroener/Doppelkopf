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
public class Runde {
    private int re;
    private int contra;
    private ArrayList<Stich> stiche;
    
    public int berechnePunkte(){
        
    }
    
    
    public int berechneTacken(){
        int tacken = 0;
        if(re <= 120){
            tacken = tacken - 2;  //keine 120, gegen
            if(re < 90){
                tacken--;
                if(re < 60){
                    tacken--;
                    if(re < 30){
                        tacken--;
                        if(re == 0){
                            tacken--;
                        }
                    }
                }
            }
        }
        if(re > 120){
            tacken++;
            if(re > 150){
                tacken++;
                if(re > 180){
                    tacken++;
                    if(re > 210){
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
