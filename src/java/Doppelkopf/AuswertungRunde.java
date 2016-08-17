/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doppelkopf;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
    
    ArrayList<ANSAGEN> reAnsagenList;
    ArrayList<ANSAGEN> contraAnsagenList;

    public AuswertungRunde(int punkteRe, int punkteContra, ArrayList<ANSAGEN> reAnsagenList, ArrayList<ANSAGEN> contraAnsagenList) {
        this.punkteRe = punkteRe;
        this.punkteContra = punkteContra;
        
        this.reAnsagenList = reAnsagenList;
        this.contraAnsagenList = contraAnsagenList;
        
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
            if(this.contraAnsagenList.contains(ANSAGEN.KEINE120)){
                this.contraKeine120++;
            }
            if(punkteRe < 90){
                this.contraKeine90 = 1;
                if(this.contraAnsagenList.contains(ANSAGEN.KEINE90)){
                    this.contraKeine90++;
                }
                if(punkteRe < 60){
                    this.contraKeine60 = 1;
                    if(this.contraAnsagenList.contains(ANSAGEN.KEINE60)){
                        this.contraKeine60++;
                    }
                    if(punkteRe < 30){
                        this.contraKeine30 = 1;
                        if(this.contraAnsagenList.contains(ANSAGEN.KEINE30)){
                            this.contraKeine30++;
                        }
                        if(punkteRe == 0){
                            this.contraSchwarz = 1;
                            if(this.contraAnsagenList.contains(ANSAGEN.SCHWARZ)){
                                this.contraSchwarz++;
                            }
                        }
                    }
                }
            }
        }else{
            if(punkteContra < 120){
                this.reKeine120 = 1;
                if(this.reAnsagenList.contains(ANSAGEN.KEINE120)){
                    this.reKeine120++;
                }
                if(punkteContra < 90){
                    this.reKeine90 = 1;
                    if(this.reAnsagenList.contains(ANSAGEN.KEINE90)){
                        this.reKeine90++;
                    }
                    if(punkteContra < 60){
                        this.reKeine60 = 1;
                        if(this.reAnsagenList.contains(ANSAGEN.KEINE60)){
                            this.reKeine60++;
                        }
                        if(punkteContra < 30){
                            this.reKeine30 = 1;
                            if(this.reAnsagenList.contains(ANSAGEN.KEINE30)){
                                this.reKeine30++;
                            }
                            if(punkteContra == 0){
                                this.reSchwarz = 1;
                                if(this.reAnsagenList.contains(ANSAGEN.SCHWARZ)){
                                    this.reSchwarz++;
                                }
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

    public int getPunkteRe() {
        return punkteRe;
    }

    public void setPunkteRe(int punkteRe) {
        this.punkteRe = punkteRe;
    }

    public int getPunkteContra() {
        return punkteContra;
    }

    public void setPunkteContra(int punkteContra) {
        this.punkteContra = punkteContra;
    }

    public int getReKeine120() {
        return reKeine120;
    }

    public void setReKeine120(int reKeine120) {
        this.reKeine120 = reKeine120;
    }

    public int getContraKeine120() {
        return contraKeine120;
    }

    public void setContraKeine120(int contraKeine120) {
        this.contraKeine120 = contraKeine120;
    }

    public int getReKeine90() {
        return reKeine90;
    }

    public void setReKeine90(int reKeine90) {
        this.reKeine90 = reKeine90;
    }

    public int getContraKeine90() {
        return contraKeine90;
    }

    public void setContraKeine90(int contraKeine90) {
        this.contraKeine90 = contraKeine90;
    }

    public int getReKeine60() {
        return reKeine60;
    }

    public void setReKeine60(int reKeine60) {
        this.reKeine60 = reKeine60;
    }

    public int getContraKeine60() {
        return contraKeine60;
    }

    public void setContraKeine60(int contraKeine60) {
        this.contraKeine60 = contraKeine60;
    }

    public int getReKeine30() {
        return reKeine30;
    }

    public void setReKeine30(int reKeine30) {
        this.reKeine30 = reKeine30;
    }

    public int getContraKeine30() {
        return contraKeine30;
    }

    public void setContraKeine30(int contraKeine30) {
        this.contraKeine30 = contraKeine30;
    }

    public int getReSchwarz() {
        return reSchwarz;
    }

    public void setReSchwarz(int reSchwarz) {
        this.reSchwarz = reSchwarz;
    }

    public int getContraSchwarz() {
        return contraSchwarz;
    }

    public void setContraSchwarz(int contraSchwarz) {
        this.contraSchwarz = contraSchwarz;
    }

    public int getReCharlieAmEnde() {
        return reCharlieAmEnde;
    }

    public void setReCharlieAmEnde(int reCharlieAmEnde) {
        this.reCharlieAmEnde = reCharlieAmEnde;
    }

    public int getContraCharlieAmEnde() {
        return contraCharlieAmEnde;
    }

    public void setContraCharlieAmEnde(int contraCharlieAmEnde) {
        this.contraCharlieAmEnde = contraCharlieAmEnde;
    }

    public int getReDoppelKopf() {
        return reDoppelKopf;
    }

    public void setReDoppelKopf(int reDoppelKopf) {
        this.reDoppelKopf = reDoppelKopf;
    }

    public int getContraDoppelkopf() {
        return contraDoppelkopf;
    }

    public void setContraDoppelkopf(int contraDoppelkopf) {
        this.contraDoppelkopf = contraDoppelkopf;
    }

    public int getReFuchsGefangen() {
        return reFuchsGefangen;
    }

    public void setReFuchsGefangen(int reFuchsGefangen) {
        this.reFuchsGefangen = reFuchsGefangen;
    }

    public int getContraFuchsGefangen() {
        return contraFuchsGefangen;
    }

    public void setContraFuchsGefangen(int contraFuchsGefangen) {
        this.contraFuchsGefangen = contraFuchsGefangen;
    }

    public int getReGesamt() {
        return reGesamt;
    }

    public void setReGesamt(int reGesamt) {
        this.reGesamt = reGesamt;
    }

    public int getContraGesamt() {
        return contraGesamt;
    }

    public void setContraGesamt(int contraGesamt) {
        this.contraGesamt = contraGesamt;
    }

    public ArrayList<ANSAGEN> getReAnsagenList() {
        return reAnsagenList;
    }

    public void setReAnsagenList(ArrayList<ANSAGEN> reAnsagenList) {
        this.reAnsagenList = reAnsagenList;
    }

    public ArrayList<ANSAGEN> getContraAnsagenList() {
        return contraAnsagenList;
    }

    public void setContraAnsagenList(ArrayList<ANSAGEN> contraAnsagenList) {
        this.contraAnsagenList = contraAnsagenList;
    }
    
    
}
