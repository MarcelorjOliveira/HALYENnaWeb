<%-- 
    Document   : basicexercises
    Created on : 08/11/2014, 22:44:29
    Author     : marcelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercícios básicos</title>
    </head>
    <body>
        <form action="roda" name="formBasicExercises" method="post">
            ${title}<br>
            <textarea style="resize:none" name="resolution" cols="70" rows="40" resize="none" >${resolution}</textarea><br>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
