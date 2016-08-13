/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DbModel.User;
import java.sql.SQLException;

/**
 *
 * @author katha
 */
public class LoginController {
    
    public Boolean checkLogin(String username, String passwort) throws ClassNotFoundException, SQLException{
        User user = DbController.getInstance().getUser(username);
        if(user == null){
            return false;
        }
        if(!user.getPasswort().equals(passwort)){
            return false;
        }
        return true;
    }
    
}
