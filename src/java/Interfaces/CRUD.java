package Interfaces;

import Modelo.Usuarios;
import java.util.List;
/**
 *
 * @author Andres Ramirez
 */
public interface CRUD {
    public List listar();
    public Usuarios list(int id_Usuario);
    public boolean add(Usuarios user);
    public boolean edit(Usuarios user);
    public boolean eliminar(int id_Usuario);
    
}
