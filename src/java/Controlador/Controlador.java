package Controlador;

import Modelo.Usuarios;
import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres Ramirez
 */
public class Controlador extends HttpServlet {
    
    String listar = "vistas/listar.jsp";
    String add = "vistas/add.jsp";
    String edit = "vistas/edit.jsp";
    Usuarios usuario = new Usuarios();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    int ID_usuario;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String acceso = "";
        String action = request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso = listar;
        }
        else if(action.equalsIgnoreCase("add")){
            acceso = add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            String nombres = request.getParameter("TxtNombres");
            String email = request.getParameter("TxtEmail");
            String clave = request.getParameter("TxtClave");
            int tipo_usuario = Integer.parseInt(request.getParameter("TxttipoUsuario"));
            int area = Integer.parseInt(request.getParameter("TxtArea"));
            int estado = Integer.parseInt(request.getParameter("TxtEstado"));
            usuario.setNombre(nombres);
            usuario.setEmail(email);
            usuario.setClave(clave);
            usuario.setTipoUsuario(tipo_usuario);
            usuario.setAreas(area);
            usuario.setEstado(estado);
            usuarioDAO.add(usuario);
            acceso = listar;    
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idusu", request.getParameter("idUsuario"));
            acceso = edit;
        }else if(action.equalsIgnoreCase("Actualizar")){
            ID_usuario = Integer.parseInt(request.getParameter("TxtIDUsuario"));
            String nombres = request.getParameter("TxtNombres");
            String email = request.getParameter("TxtEmail");
            String clave = request.getParameter("TxtClave");
            int tipo_usuario = Integer.parseInt(request.getParameter("TxttipoUsuario"));
            int area = Integer.parseInt(request.getParameter("TxtArea"));
            int estado = Integer.parseInt(request.getParameter("TxtEstado"));
            usuario.setIdUsuario(ID_usuario);
            usuario.setNombre(nombres);
            usuario.setEmail(email);
            usuario.setClave(clave);
            usuario.setTipoUsuario(tipo_usuario);
            usuario.setAreas(area);
            usuario.setEstado(estado);
            usuarioDAO.edit(usuario);
            acceso = listar;  
        }else if(action.equalsIgnoreCase("eliminar")){
            ID_usuario = Integer.parseInt(request.getParameter("idUsuario"));
            usuario.setIdUsuario(ID_usuario);
            usuarioDAO.eliminar(ID_usuario);
            acceso = listar;  
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
