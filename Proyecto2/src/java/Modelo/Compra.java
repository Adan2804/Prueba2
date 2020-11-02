
package Modelo;

public class Compra {
    
    int idcompra;
    String proveedor;
    String fecha;
    int cantidadtipos;
    double costototal;
    int cantidadtotal;

    public Compra() {
    }
    

    public Compra(String proveedor, String fecha, double costototal, int cantidadtotal) {
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.costototal = costototal;
        this.cantidadtotal = cantidadtotal;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidadtipos() {
        return cantidadtipos;
    }

    public void setCantidadtipos(int cantidadtipos) {
        this.cantidadtipos = cantidadtipos;
    }

    public double getCostototal() {
        return costototal;
    }

    public void setCostototal(double costototal) {
        this.costototal = costototal;
    }

    public int getCantidadtotal() {
        return cantidadtotal;
    }

    public void setCantidadtotal(int cantidadtotal) {
        this.cantidadtotal = cantidadtotal;
    }
    
    
    
    
}
