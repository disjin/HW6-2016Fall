<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Pokemon</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>

        <div class="wrap"> <!--div to hold all other divs -->

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>

            <div class="main"> <!--main div-->

                <h1>Add A New Pokemon</h1>
                <hr class="style">

                <form name="addForm" action="addPokemon" method="get">

                    <table>
                        <tr>
                            <td class="right">
                                Pokemon Name:  
                            </td>
                            <td class="left">
                                <input type="text" name="name" value="" />
                            </td>
                        </tr>
                        <tr>
                            <td class="right">
                                Pokemon Type:  
                            </td>
                            <td class="left">
                                <input type="text" name="type" value="" />
                            </td>
                        </tr>
                        <tr>
                            <td class="right">
                                Weight: 
                            </td>
                            <td class="left">
                                <input type="text" name="weight" value="" />
                            </td>
                        </tr>
                        <tr>
                            <td class="right">
                                Height:  
                            </td>
                            <td class="left">
                                <input type="text" name="height" value="" />
                            </td>
                        </tr>
                        <tr>
                            <td class="right">
                                CP: 
                            </td>
                            <td class="left">
                                <input type="text" name="CP" value="" />
                            </td>
                        </tr>                
                    </table>





                    <br>
                    <input type="submit" name="submit" value="Submit" />

                </form>

            </div> <!--close main div -->

            <%@ include file="includes/footer.jsp" %>

        </div> <!-- close the wrap div -->

    </body>
</html>
