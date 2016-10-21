<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Pokemon</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <h1>Add A New Pokemon</h1>
        <hr class="style">
        
        <form name="addForm" action="addPokemon" method="get">
            
            <label>Pokemon Name:</label>
            <input type="text" name="name" value="" />
            <br>
            <label>Pokemon Type:</label>
            <input type="text" name="type" value="" />
            <br>
            <label>Weight:</label>
            <input type="text" name="weight" value="" />
            <br>
            <label>Height:</label>
            <input type="text" name="height" value="" />
            <br>
            <label>CP:</label>
            <input type="text" name="CP" value="" />
            <br>
            <input type="submit" name="submit" value="Submit" />
            
        </form>
    </body>
</html>
