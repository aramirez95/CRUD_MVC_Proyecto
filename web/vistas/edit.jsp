<%-- 
    Document   : edit
    Created on : Nov 24, 2024, 5:19:19 PM
    Author     : Andres Ramirez
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Usuarios"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
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
            <%
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                int id_Usuario = Integer.parseInt((String)request.getAttribute("idusu"));
                Usuarios usuario = (Usuarios)usuarioDAO.list(id_Usuario);
            %>
            <div class="col-lg-6">
                <br>
                <h1>Editar Usuario</h1>
                <br>
                <form action="Controlador">
                    ID Usuario: <br>
                    <input type="text" name="TxtIDUsuario" value="<%= usuario.getIdUsuario() %>" class="form-control"><br>
                    Nombres: <br>
                    <input type="text" name="TxtNombres" value="<%= usuario.getNombre() %>" class="form-control"><br>
                    Email: <br>
                    <input type="text" name="TxtEmail" value="<%= usuario.getEmail() %>" class="form-control"><br>
                    Clave: <br>
                    <input type="password" name="TxtClave" value="<%= usuario.getClave() %>" class="form-control"><br>
                    Tipo Usuario: <br>
                    <input type="text" name="TxttipoUsuario" value="<%= usuario.getTipoUsuario() %>" class="form-control"><br>
                    Area: <br>
                    <input type="text" name="TxtArea" value="<%= usuario.getAreas() %>" class="form-control"><br>
                    Estado: <br>
                    <input type="text" name="TxtEstado" value="<%= usuario.getEstado() %>" class="form-control"><br> 
                    <br>
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    <br>
                    <br>
                    <a href="Controlador?accion=listar" class="btn btn-primary">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>