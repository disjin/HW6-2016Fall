/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pokemon;

/**
 *
 * @author apple
 */
public class AddQuery {
    
    private Connection conn;
    
    public AddQuery() {
    
        try{
        
            Properties props = new Properties(); //MWC
            InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            try {
                props.load(instr);
            } catch (IOException ex) {
                Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                instr.close();
            } catch (IOException ex) {
                Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String passwd = props.getProperty("user.password");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, passwd);
          } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
          }
    
    
    }
    
    public void doAdd (Pokemon pokemon){
    
        try {
            String query = "Insert INTO pokemon (pokemonName, pokemonType, weight, height, CP) VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, pokemon.getPokemonName());
            ps.setString(2, pokemon.getPokemonType());
            ps.setDouble(3, pokemon.getWeight());
            ps.setDouble(4, pokemon.getHeight());
            ps.setInt(5, pokemon.getCP());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
