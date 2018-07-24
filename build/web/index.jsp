<%-- 
    Document   : index
    Created on : 21/04/2018, 16:05:32
    Author     : Marcos
--%>


<%@page import="AlgSlopeOne.Usuario"%>
<%@page import="AlgSlopeOne.SlopeOne"%>
<%@page import="java.awt.HeadlessException" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="formatos.css">
        <title>Pagina Teste</title>

        <script>
            function divShow() {
                var divResult = document.getElementById("result");
                divResult.style.display = "block";
            }

        </script>
    </head>
    <body>
            <div id="principal">
                <div id="titulo">
                    <h1>Avalie os itens abaixo</h1>
                </div>
                <form id="form" action="servletSlopeOne" method="post" autocomplete="off">
                    <table>
                        <tr>
                            <td>
                                <h2>Rack</h2>
                                <img id="imagem" src="Imagem 1.jpg" />
                            </td>                                
                            <td>
                                <h2>Cadeira</h2>
                                <img id="imagem" src="Imagem 2.jpg" />
                            </td>
                            <td>
                                <h2>Pia</h2>
                                <img id="imagem" src="Imagem 3.jpg" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input id="campo" size="40" type="float" name="input1">
                            </td>
                            <td>
                                <input id="campo" size="40" type="float" name="input2">
                            </td>
                            <td>
                                <input id="campo" size="40" type="float" name="input3">
                            </td>
                        </tr>                            
                        <tr>
                            <td>
                                <h2>Estante</h2>
                                <img id="imagem" src="Imagem 4.jpg" />
                            </td>
                            <td>   
                                <h2>Cama</h2>
                                <img id="imagem" src="Imagem 5.jpg" />
                            </td>
                            <td>
                                <h2>Armário</h2>  
                                <img id="imagem" src="Imagem 6.jpg" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input id="campo" size="40" type="float" name="input4">
                            </td>
                            <td>
                                <input id="campo" size="40" type="float" name="input5">
                            </td>
                            <td>
                                <input id="campo" size="40" type="float" name="input6">
                            </td>
                        </tr>
                        <input id="method" type="int" name="method" value="1">
                        </tr>
                    </table>
                    <input id="botao" name="enviar" type="submit" value="Enviar">
                </form>
            </div>
    </body>
</html>
