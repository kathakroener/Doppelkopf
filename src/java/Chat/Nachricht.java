/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.util.Date;
import javax.websocket.Decoder;

/**
 *
 * @author hrs
 */
public class Nachricht  {
    
    private String text;
    private String sender;
    private Date empfangen;

    public Nachricht(String text, String sender) {
        this.text = text;
        this.sender = sender;
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

    @Override
    public String toString(){ // Eckige Klammern! Wahrscheinlich für JSON-Format
        return "Nachricht [" + "text=" + text + ", sender=" + sender + ", empfangen=" + empfangen + ']';
    }
    
    
    
}
