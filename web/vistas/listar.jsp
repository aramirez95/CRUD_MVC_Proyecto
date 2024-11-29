<%-- 
    Document   : listar
    Created on : Nov 24, 2024, 5:18:48 PM
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
            <h1>Usuarios Registrados</h1>
            <a href="Controlador?accion=add" class="btn btn-success">Registrar Nuevo Usuario</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID Usuario</th>
                        <th class="text-center">Nombres</th>
                        <th class="text-center">Email</th>
                        <th class="text-center">Clave</th>
                        <th class="text-center">ID Area</th>
                        <th class="text-center">ID Tipo de Usuario</th>
                        <th class="text-center">ID Estado</th>
                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>
                
                <% 
                    UsuarioDAO dao = new  UsuarioDAO();
                    List<Usuarios> list = dao.listar();
                    Iterator<Usuarios> iter = list.iterator();
                    Usuarios user = null;
                    while(iter.hasNext()){
                        user = iter.next();
                %>
                
                <tbody>
                    <tr>
                        <td class="text-center"><%= user.getIdUsuario() %></td>
                        <td><%= user.getNombre() %></td>
                        <td><%= user.getEmail() %></td>
                        <td><%= user.getClave() %></td>
                        <td class="text-center"><%= user.getTipoUsuario() %></td>
                        <td class="text-center"><%= user.getAreas() %></td>
                        <td class="text-center"><%= user.getEstado() %></td>
                        <td class="text-center">
                            <a href="Controlador?accion=editar&idUsuario=<%= user.getIdUsuario()%>" class="btn btn-warning">Editar</a>
                            <a href="Controlador?accion=eliminar&idUsuario=<%= user.getIdUsuario()%>" class="btn btn-danger">Remover</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </body>
</html>
