package ModeloDAO;

import Interfaces.CRUD;
import Modelo.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Config.Conexion;
/**
 *
 * @author Andres Ramirez
 */
public class UsuarioDAO implements CRUD{

    Conexion conexion = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuarios u = new Usuarios();
    
    
    @Override
    public List listar() {
        ArrayList<Usuarios> list = new ArrayList<>();
        String sql="Select * from usuarios";
        try{
            con = conexion.ConectarBaseDeDatos();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()){
                Usuarios usuario = new Usuarios();
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setEmail(rs.getString(3));
                usuario.setClave(rs.getString(4));
                usuario.setTipoUsuario(rs.getInt(5));
                usuario.setAreas(rs.getInt(6));
                usuario.setEstado(rs.getInt(7));
                list.add(usuario);
            }
            
        }catch(Exception e){
            System.out.println("Error al generar lista: " + e);
        }
        return list;
    }

    @Override
    public Usuarios list(int id_Usuario) {
       String sql= "Select * from usuarios where ID_usuario=" + id_Usuario;
       try{
           con = conexion.ConectarBaseDeDatos();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           
           while (rs.next()){
 
                u.setIdUsuario(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setEmail(rs.getString(3));
                u.setClave(rs.getString(4));
                u.setTipoUsuario(rs.getInt(5));
                u.setAreas(rs.getInt(6));
                u.setEstado(rs.getInt(7));
            }
           
       }catch (SQLException ex){
           System.out.println("Error al Editar Registro de Usuario " + ex);
       }
       return u;
    }

    @Override
    public boolean add(Usuarios user) {
        String sql = "Insert Into usuarios (nombres, email, clave, ID_tipo_usuario, ID_area_usuario, ID_estado_usuario) Values (?,?,?,?,?,?)";
        try{
            con = conexion.ConectarBaseDeDatos();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getClave());
            ps.setInt(4, user.getTipoUsuario());
            ps.setInt(5, user.getAreas());
            ps.setInt(6, user.getEstado());
            ps.executeUpdate();

        }catch(SQLException e){
            System.out.println("Error al Crear Registro de Usuario " + e);
        }
        return false;
    }

    @Override
    public boolean edit(Usuarios user) {
        String sql = "Update usuarios set nombres=?, email=?, clave=?, ID_tipo_usuario=?, ID_area_usuario=?, ID_estado_usuario=? where ID_Usuario=?";
        try{
            con = conexion.ConectarBaseDeDatos();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getClave());
            ps.setInt(4, user.getTipoUsuario());
            ps.setInt(5, user.getAreas());
            ps.setInt(6, user.getEstado());
            ps.setInt(7, user.getIdUsuario());
            ps.executeUpdate();

        }catch(SQLException e){
            System.out.println("Error al Actualizar Registro de Usuario " + e);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id_Usuario) {
       String sql = "delete from usuarios where ID_Usuario=" + id_Usuario;
       try{
            con = conexion.ConectarBaseDeDatos();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        }catch(SQLException e){
            System.out.println("Error al Actualizar Registro de Usuario " + e);
        }
        return false;
    }
    
}
