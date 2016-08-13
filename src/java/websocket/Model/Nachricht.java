/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websocket.Model;

import java.io.StringReader;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.Decoder;

/**
 *
 * @author katha
 */
public class Nachricht  {
    
    private String text;
    private String sender;
    private Date empfangen;
    
    public Nachricht(String jsonNachricht){
        JsonObject obj = Json.createReader(new StringReader(jsonNachricht)).readObject();
        this.text = obj.getString("text");
        this.sender = obj.getString("sender");
        this.setEmpfangen(new Date());
    }
    
    public String toJSON(){
        return Json.createObjectBuilder()
                .add("text", this.getText())
                .add("sender", this.getSender())
                .add("empfangen", this.getFormatEmpfangen()).build()
                .toString();
    }

    public Nachricht() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Date getEmpfangen() {
        return empfangen;
    }

    public void setEmpfangen(Date empfangen) {
        this.empfangen = empfangen;
    }
    
    public String getFormatEmpfangen(){
        String returnString = "";
        if(empfangen.getHours() < 10){
            returnString += "0";
        }
        returnString += Integer.toString(empfangen.getHours()) + ":";
        if(empfangen.getMinutes() < 10){
            returnString += "0";
        }
        returnString += Integer.toString(empfangen.getMinutes()) + ":";
        if(empfangen.getSeconds() < 10){
            returnString += "0";
        }
        returnString += Integer.toString(empfangen.getSeconds());
        return returnString;
    }
}
