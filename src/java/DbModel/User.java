/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbModel;

/**
 *
 * @author katha
 */
public class User {
    
    String username;
    
    String passwort;
    
    int gesTacken;

    public User() {
    }

    public User(String username, String passwort, int gesTacken) {
        this.username = username;
        this.passwort = passwort;
        this.gesTacken = gesTacken;
    }    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public int getGesTacken() {
        return gesTacken;
    }

    public void setGesTacken(int gesTacken) {
        this.gesTacken = gesTacken;
    }

    
    
    
    
}
