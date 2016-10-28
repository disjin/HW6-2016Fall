package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pokemon;


public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private Pokemon pokemon = new Pokemon();
    private int pokemonID;
    
    public ReadRecord (int pokemonID) {
    
    try{
        
            Properties props = new Properties(); //MWC
            InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            try {
                props.load(instr);
            } catch (IOException ex) {
                Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                instr.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String passwd = props.getProperty("user.password");
            
            this.pokemonID = pokemonID;
            
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, passwd);
          } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        
    }
    
    public void doRead () {
    
        try {
            //set up a string to hold our query
            String query = "SELECT * FROM pokemon WHERE pokemonID = ?";
            
            //create a preparedstatement using our query string
            PreparedStatement ps = conn.prepareStatement(query);
            
            
            //fill in the preparedstatment
            ps.setInt(1, pokemonID);
            
            //execute the query
            this.results = ps.executeQuery();
            
            this.results.next();
        
            pokemon.setPokemonID(this.results.getInt("pokemonID"));
            pokemon.setPokemonName(this.results.getString("pokemonName"));
            pokemon.setPokemonType(this.results.getString("pokemonType"));
            pokemon.setWeight(this.results.getDouble("weight"));
            pokemon.setHeight(this.results.getDouble("height"));
            pokemon.setCP(this.results.getInt("cp"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public Pokemon getPokemon() {
    
        return this.pokemon;
        
    }
}
