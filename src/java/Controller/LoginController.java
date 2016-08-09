/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author hrs
 */
public class LoginController {
    
    public String doLogin(String username, String passwort){
        if(checkLogin(username,passwort)){
            return "/Spiel";
        }else{
            return "/Login";
        }
    }
    
    private Boolean checkLogin(String username, String passwort){
        return true;
    }
    
}
