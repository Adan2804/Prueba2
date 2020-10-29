
package Modelo;

public class RegistroCompra {
    
    int idregistrocompra;
    String marca;
    double costounidadcompra;
    double preciounidadventa;
    int cantidad;
    double subtotal;
    Producto idproducto;
    Compra idcompra;

    public RegistroCompra() {
    }

    public RegistroCompra(String marca, double costounidadcompra, double preciounidadventa, int cantidad, double subtotal, Producto idproducto, Compra idcompra) {
        this.marca = marca;
        this.costounidadcompra = costounidadcompra;
        this.preciounidadventa = preciounidadventa;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.idproducto = idproducto;
        this.idcompra = idcompra;
    }

    public int getIdregistrocompra() {
        return idregistrocompra;
    }

    public void setIdregistrocompra(int idregistrocompra) {
        this.idregistrocompra = idregistrocompra;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCostounidadcompra() {
        return costounidadcompra;
    }

    public void setCostounidadcompra(double costounidadcompra) {
        this.costounidadcompra = costounidadcompra;
    }

    public double getPreciounidadventa() {
        return preciounidadventa;
    }

    public void setPreciounidadventa(double preciounidadventa) {
        this.preciounidadventa = preciounidadventa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    public Compra getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Compra idcompra) {
        this.idcompra = idcompra;
    }


    
    
    
}
