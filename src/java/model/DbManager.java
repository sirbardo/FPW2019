/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bardoz
 */
public class DbManager {

    private static DbManager instance;

    private DbManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbManager.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    public static DbManager getInstance(){
        if (instance == null)
            instance = new DbManager();

        return instance;
    } 

    public Connection getDbConnection(){
        String db = "jdbc:mysql://localhost:3306/fpw19_DbFrongiaLaerte?zeroDateTimeBehavior=convertToNull";
        
        try {
           Connection conn = DriverManager.getConnection(db, "fpw19_FrongiaLaerte", "freePeerReview");
           return conn;
        }catch (SQLException ex){
            Logger.getLogger(DbManager.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
