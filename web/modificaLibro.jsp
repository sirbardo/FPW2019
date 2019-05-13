<%-- 
    Document   : modificaLibro
    Created on : 6-mag-2019, 9.58.52
    Author     : davide
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>modifica Libro</title>
    </head>
    <body>
        <h1>Modifica Libro</h1>
        <form action="modificaLibro.html" method="post">
            <label for="titolo">Titolo</label>
            <input type="text" name="titolo" id="titolo" 
                   value="${libro.getTitolo()}"><br/>
            <label for="testo">Testo</label>
            <textarea id="testo" name="testo">
                ${libro.getTesto()}
            </textarea>
            <input type="hidden" name="lid" value="${libro.getId()}"><br/>
            <button type="submit" name="modifica">Salva</button>
        </form>
    </body>
</html>
