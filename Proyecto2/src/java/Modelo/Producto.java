package Modelo;

import java.io.InputStream;

public class Producto {
    int Id;
    String Nombre;
    String Tipo;
    int Cantidad;
    double Precio;
    InputStream foto;

    public Producto() {
    }

    public Producto(int Id, String Nombre, String Tipo, int Cantidad, double Precio, InputStream foto) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.foto = foto;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

   
    
}
