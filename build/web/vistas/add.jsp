<%-- 
    Document   : add
    Created on : Nov 24, 2024, 5:19:04 PM
    Author     : Andres Ramirez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Proyecto SGC - SENA</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <br>
                <h1>Agregar Usuario</h1>
                <br>
                <form action="Controlador">
                    Nombres: <br>
                    <input type="text" name="TxtNombres" class="form-control"><br>
                    Email: <br>
                    <input type="text" name="TxtEmail" class="form-control"><br>
                    Clave: <br>
                    <input type="password" name="TxtClave" class="form-control"><br>
                    Tipo Usuario: <br>
                    <input type="text" name="TxttipoUsuario" class="form-control"><br>
                    Area: <br>
                    <input type="text" name="TxtArea" class="form-control"><br>
                    Estado: <br>
                    <input type="text" name="TxtEstado" class="form-control"><br>  
                   
                    <input type="submit" name="accion" value="Agregar" class="btn btn-success">
                    <br>  
                     <br> 
                    <a href="Controlador?accion=listar" class="btn btn-primary">Regresar</a>
                </form>
            </div>
        </div>
        
    </body>
</html>
