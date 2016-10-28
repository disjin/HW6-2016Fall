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


public class ReadQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery(){
        
        try{
        
            Properties props = new Properties(); //MWC
            InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            try {
                props.load(instr);
            } catch (IOException ex) {
                Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                instr.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String passwd = props.getProperty("user.password");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, passwd);
          } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        
    }
    
    public void doRead() {
        
        try {
            String query = "Select * from pokemon";
            
            PreparedStatement ps = conn.prepareStatement (query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLtable(){
        
        String table = "";
        
        table += "<table >";
        table += "<tr>"; 
        table += "<th>PokemonID</th>";
        table += "<th>PokemonName</th>"; 
        table += "<th>PokemonType</th>";
        table += "<th>Weight</th>";
        table += "<th>Height</th>"; 
        table += "<th>CP</th>";
        table += "<th>  </th>";
        table += "</tr>";
        
        try {
            while(this.results.next()){
                
                Pokemon pokemon = new Pokemon();
                pokemon.setPokemonID(this.results.getInt("pokemonID"));
                pokemon.setPokemonName(this.results.getString("pokemonName"));
                pokemon.setPokemonType(this.results.getString("pokemonType"));
                pokemon.setWeight(this.results.getDouble("weight"));
                pokemon.setHeight(this.results.getDouble("height"));
                pokemon.setCP(this.results.getInt("CP"));
                
                table += "<tr>";
                table += "<td>";
                table += pokemon.getPokemonID();
                table += "</td>";
                
                table += "<td>";
                table += pokemon.getPokemonName();
                table += "</td>";
                
                table += "<td>";
                table += pokemon.getPokemonType();
                table += "</td>";
                
                table += "<td>";
                table += pokemon.getWeight();
                table += "</td>";
                
                table += "<td>";
                table += pokemon.getHeight();
                table += "</td>";
                
                table += "<td>";
                table += pokemon.getCP();
                table += "</td>";
                
                table += "<td>";
                table += "<a href=update?pokemonID=" + pokemon.getPokemonID() + "> Update </a>" + "<a href=delete?pokemonID=" + pokemon.getPokemonID() + "> Delete </a>";
                table += "</tr>";
                
                
                
            }   } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        table += "</table>";
        
                    return table;
    }
}

