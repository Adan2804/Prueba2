
package Intefaces;

import Modelo.Empleado;
import java.util.List;

public interface EMPLEADOCRUD {
    
    public List listar();
    public Empleado list(int id);
    public boolean add(Empleado Emp);
    public boolean edit(Empleado Emp);
    public boolean eliminar(int id);
    
}
