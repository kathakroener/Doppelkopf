/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DbModel.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author katha
 */
public class DbController {
    
    private DbController() {
    }
    
    public static DbController getInstance() {
        return DbControllerHolder.INSTANCE;
    }
    
    private static class DbControllerHolder {

        private static final DbController INSTANCE = new DbController();
    }
    
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        // create a mysql database connection
            String myUrl = "jdbc:mysql://62.75.142.111:3306/Doppelkopf";
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(myUrl, "root", "43mitmilch");
    }
    
    public User getUser(String username) throws ClassNotFoundException, SQLException{
        ResultSet rs = null;
        Connection conn = null;
        try{
            conn = getConnection();
            String query = "SELECT * FROM `user` WHERE username = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, username);
            rs = preparedStmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        User user = null;
        String passwort;
        while(rs.next()){
            user = new User();
            user.setUsername(rs.getString("username"));
            user.setPasswort(rs.getString("passwort"));
            user.setGesTacken(rs.getInt("gesTacken"));
        }
        conn.close();  
        return user;
    }
    
    public boolean insertUser(String username, String passwort) throws SQLException, ClassNotFoundException{
        Connection conn = getConnection();
        try{
          String query = "INSERT INTO `user`(`username`, `passwort`, `gesTacken`) VALUES (?,?,?)";
          PreparedStatement preparedStmt;
          preparedStmt = conn.prepareStatement(query);
          preparedStmt.setString(1, username);
          preparedStmt.setString(2, passwort);
          preparedStmt.setInt(3, 0);
          preparedStmt.executeUpdate();
          preparedStmt.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            conn.close();
            return false;
        }
        conn.close();
        return true;
    }
}
