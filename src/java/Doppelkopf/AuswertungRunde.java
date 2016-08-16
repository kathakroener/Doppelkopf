/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doppelkopf;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author katha
 */
public class AuswertungRunde {
    
    int punkteRe;
    int punkteContra;
    
    int reKeine120;
    int contraKeine120;
    
    int reKeine90;
    int contraKeine90;
    
    int reKeine60;
    int contraKeine60;
    
    int reKeine30;
    int contraKeine30;
    
    int reSchwarz;
    int contraSchwarz;
    
    int reCharlieAmEnde;
    int contraCharlieAmEnde;
    
    int reDoppelKopf;
    int contraDoppelkopf;
    
    int reFuchsGefangen;
    int contraFuchsGefangen;
    
    int reGesamt;
    int contraGesamt;
    
    LinkedHashMap<ANSAGEN, Spieler> mapAnsagenSpieler;

    public AuswertungRunde(int punkteRe, int punkteContra, LinkedHashMap<ANSAGEN, Spieler> mapAnsagenSpieler) {
        this.punkteRe = punkteRe;
        this.punkteContra = punkteContra;
        this.mapAnsagenSpieler = mapAnsagenSpieler;
        
        this.reKeine120 = 0;
        this.reKeine90 = 0;
        this.reKeine60 = 0;
        this.reKeine30 = 0;
        this.reSchwarz= 0;
        
        this.contraKeine120 = 0;
        this.contraKeine90 = 0;
        this.contraKeine60 = 0;
        this.contraKeine30 = 0;
        this.contraSchwarz= 0;
        
        if(punkteRe < 120){
            this.contraKeine120 = 2;
            if(punkteRe < 90){
                this.contraKeine90 = 1;
                if(punkteRe < 60){
                    this.contraKeine60 = 1;
                    if(punkteRe < 30){
                        this.contraKeine30 = 1;
                        if(punkteRe == 0){
                            this.contraSchwarz = 1;
                        }
                    }
                }
            }
        }else{
            if(punkteContra < 120){
                this.reKeine120 = 1;
                if(punkteContra < 90){
                    this.reKeine90 = 1;
                    if(punkteContra < 60){
                        this.reKeine60 = 1;
                        if(punkteContra < 30){
                            this.reKeine30 = 1;
                            if(punkteContra == 0){
                                this.reSchwarz = 1;
                            }
                        }
                    }
                }
            }
        }
        
        this.reCharlieAmEnde = 0;
        this.contraCharlieAmEnde = 0;
    
        this.reDoppelKopf = 0;
        this.contraDoppelkopf = 0;
    
        this.reFuchsGefangen = 0;
        this.contraFuchsGefangen = 0;
        
        this.reGesamt = this.reKeine120 + this.reKeine90 + this.reKeine60 + this.reKeine30 + this.reSchwarz;
        this.contraGesamt = this.contraKeine120 + this.contraKeine90 + this.contraKeine60 + this.contraKeine30 + this.contraSchwarz;
    }
    
    public JsonObject getJsonObjectAuswertungRunde(){
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        
        jsonObjectBuilder.add("punkteRe", this.punkteRe);
        jsonObjectBuilder.add("punkteContra", this.punkteContra);
        
        jsonObjectBuilder.add("reKeine120", this.reKeine120);
        jsonObjectBuilder.add("contraKeine120", this.contraKeine120);
        
        jsonObjectBuilder.add("reKeine90", this.reKeine90);
        jsonObjectBuilder.add("contraKeine90", this.contraKeine90);
        
        jsonObjectBuilder.add("reKeine60", this.reKeine60);
        jsonObjectBuilder.add("contraKeine60", this.contraKeine60);
        
        jsonObjectBuilder.add("reKeine30", this.reKeine30);
        jsonObjectBuilder.add("contraKeine30", this.contraKeine30);
        
        jsonObjectBuilder.add("reSchwarz", this.reSchwarz);
        jsonObjectBuilder.add("contraSchwarz", this.contraSchwarz);
        
        jsonObjectBuilder.add("reCharlieAmEnde", this.reCharlieAmEnde);
        jsonObjectBuilder.add("contraCharlieAmEnde", this.contraCharlieAmEnde);
        
        jsonObjectBuilder.add("reDoppelKopf", this.reDoppelKopf);
        jsonObjectBuilder.add("contraDoppelkopf", this.contraDoppelkopf);
        
        jsonObjectBuilder.add("reFuchsGefangen", this.reFuchsGefangen);
        jsonObjectBuilder.add("contraFuchsGefangen", this.contraFuchsGefangen);
        
        jsonObjectBuilder.add("reGesamt", this.reGesamt);
        jsonObjectBuilder.add("contraGesamt", this.contraGesamt);
        
        return jsonObjectBuilder.build();
    }
}
