<%-- 
    Document   : resultado
    Created on : 22/04/2018, 13:29:22
    Author     : Marcos
--%>

<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="AlgSlopeOne.Usuario"%>
<%@page import="AlgSlopeOne.SlopeOne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
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
                Com base nas suas avaliações prevemos para o item abaixo: <%=(request.getAttribute("previsao"))%>
                <br>
            </div>
            <div id="formulario">
                <form method="post">
                    <table>
                        <tr>
                            <td>
                                <img id="imagemR" src="Imagem 6.jpg" />
                            </td>
                        </tr>
                        <tr>
                        <input id="method" type="int" name="method" value="2">
                    </table>                    
                    <input id="botao" onclick="location.href='/index.jsp'" name="voltar" type="submit" value="Voltar">
                </form>          
            </div>
        </div>
    </body>
</html>
