<%-- 
    Document   : profilo_utente
    Created on : Apr 15, 2019, 10:21:04 AM
    Author     : bardoz
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Sign up</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Laerte Frongia">
        <meta name="keywords" content="FPW, Progetto, HTML, CSS, Java">
        <meta name="description" content="Pagina di registrazione delle esercitazioni di FPW">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>

        <!-- Include header here -->
        <jsp:include page="header.jsp"/>

        <!-- Include navbar here -->
        <jsp:include page="nav.jsp"/>

        <div id="main_content">
            <aside>
                <div>
                    <ol>
                        <li>Articolo 1</li>
                        <li>Articolo 2</li>
                        <li>Articolo 3</li>
                        <li>Articolo 4</li>
                    </ol> 
                </div> 
            </aside>

            <main>
                <p>
                    Benvenuto, ${param["userName"]}!
                </p>
            </main>

        </div>
        <footer>
            <p>Developed by Laerte Frongia</p>
        </footer>
    </body>
</html>


