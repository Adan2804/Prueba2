
package Intefaces;

import Modelo.Producto;
import java.util.List;


public interface PRODUCTOCRUD {
    public List listar();
    public Producto list(int id);
    public boolean add(Producto pr);
    public boolean edit(Producto pr);
    public boolean eliminar(int id);
}
