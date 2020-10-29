
package Intefaces;

import Modelo.Cliente;
import java.util.List;


public interface CLIENTECRUD {
    
    public List listar();
    public Cliente list(int id);
    public boolean add(Cliente Cli);
    public boolean edit(Cliente Cli);
    public boolean eliminar(int id);
    
}
