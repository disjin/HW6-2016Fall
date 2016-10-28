<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pokemon"%>
<% Pokemon pokemon = (Pokemon) request.getAttribute("pokemon"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update A New Pokemon</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <h1>Update A New Pokemon Record</h1>
        <hr class="style">
        
        <form name="updateForm" action="updatePokemon" method="get">
            
            <table class="update">
                <tr>
                    <td class="right">
                      Pokemon ID:  
                    </td>
                    <td class="left">
                        <input type="text" name="id" value="<%= pokemon.getPokemonID() %>" readonly/>
                    </td>
                </tr>
                <tr>
                    <td class="right">
                      Pokemon Name:  
                    </td>
                    <td class="left">
                      <input type="text" name="name" value="<%= pokemon.getPokemonName() %>" />
                    </td>
                </tr>
                <tr>
                    <td class="right">
                      Pokemon Type:  
                    </td>
                    <td class="left">
                      <input type="text" name="type" value="<%= pokemon.getPokemonType() %>" />
                    </td>
                </tr>
                <tr>
                    <td class="right">
                      Weight: 
                    </td>
                    <td class="left">
                      <input type="text" name="weight" value="<%= pokemon.getWeight() %>" />
                    </td>
                </tr>
                <tr>
                    <td class="right">
                       Height:  
                    </td>
                    <td class="left">
                       <input type="text" name="height" value="<%= pokemon.getHeight() %>" />
                    </td>
                </tr>
                <tr>
                    <td class="right">
                       CP: 
                    </td>
                    <td class="left">
                       <input type="text" name="CP" value="<%= pokemon.getCP() %>" />
                    </td>
                </tr>                
            </table>
            
            
            
           
           
            <br>
            <input type="submit" name="submit" value="Update" />
            
        </form>
    </body>
</html>
