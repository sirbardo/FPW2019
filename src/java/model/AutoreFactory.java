/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author davide
 */
public class AutoreFactory {

    private static AutoreFactory singleton;

    private AutoreFactory() {

    }

    public static AutoreFactory getInstance() {
        if (singleton == null) {
            singleton = new AutoreFactory();
        }

        return singleton;
    }

    public List<Autore> getAutori() {
        List<Autore> autori = new ArrayList<>();

        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from autori";
            ResultSet set = stmt.executeQuery(sql);
            while (set.next()) {
                Autore autore = new Autore();
                autore.setId(set.getInt("id_autore"));
                autore.setNome(set.getString("nome"));
                autore.setCognome(set.getString("cognome"));
                autore.setEmail(set.getString("email"));
                autore.setPassword(set.getString("password"));
                autori.add(autore);
            }

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutoreFactory.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return autori;
    }

    public Autore getAutoreById(int id) {
        List<Autore> autori = this.getAutori();
        for (Autore a : autori) {
            if (a.getId() == id) {
                return a;
            }
        }

        return null;
    }

    public Autore getAutoreByEmailPassword(String email, String password) {
        try {
            Boolean loggedIn;

            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from autori where email = ? and password = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet set = stmt.executeQuery();

            loggedIn = set.next(); // Controllo se c'è almeno una riga
            if (loggedIn) {
                Autore autore = new Autore();
                autore.setId(set.getInt("id_autore"));
                autore.setNome(set.getString("nome"));
                autore.setCognome(set.getString("cognome"));
                autore.setEmail(set.getString("email"));
                autore.setPassword(set.getString("password"));
                stmt.close();
                conn.close();
                return autore;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoreFactory.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Boolean deleteAutore(int id) {

        Connection conn = null;
        try {
            conn = DbManager.getInstance().getDbConnection();

            conn.setAutoCommit(false);

            String libri = "DELETE FROM libri WHERE autore = ?";
            PreparedStatement stmt = conn.prepareStatement(libri);
            stmt.setInt(1, id);

            stmt.executeUpdate();

            String autore = "DELETE FROM autori WHERE id_autore = ?";

            stmt.setInt(1, id);
            stmt.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true); //Per completezza
            stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            Logger.getLogger(AutoreFactory.class.getName()).log(Level.SEVERE, null, e);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(AutoreFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return false;

        }
        return null;

    }
}
