
package Modelo;


public class DetalleCompra {
    
    int id_r;
    double total_precio_r;
    double precio_r;
    int pedido_id_p;
    int producto_id_pr;
    int pedido_empleado_id_em;
    int pedido_cliente_id_c;
    Producto producto;

    public DetalleCompra() {
    }

    public DetalleCompra(int id_r, double total_precio_r, double precio_r, int pedido_id_p, int producto_id_pr, int pedido_empleado_id_em, int pedido_cliente_id_c, Producto producto) {
        this.id_r = id_r;
        this.total_precio_r = total_precio_r;
        this.precio_r = precio_r;
        this.pedido_id_p = pedido_id_p;
        this.producto_id_pr = producto_id_pr;
        this.pedido_empleado_id_em = pedido_empleado_id_em;
        this.pedido_cliente_id_c = pedido_cliente_id_c;
        this.producto = producto;
    }

    public int getId_r() {
        return id_r;
    }

    public void setId_r(int id_r) {
        this.id_r = id_r;
    }

    public double getTotal_precio_r() {
        return total_precio_r;
    }

    public void setTotal_precio_r(double total_precio_r) {
        this.total_precio_r = total_precio_r;
    }

    public double getPrecio_r() {
        return precio_r;
    }

    public void setPrecio_r(double precio_r) {
        this.precio_r = precio_r;
    }

    public int getPedido_id_p() {
        return pedido_id_p;
    }

    public void setPedido_id_p(int pedido_id_p) {
        this.pedido_id_p = pedido_id_p;
    }

    public int getProducto_id_pr() {
        return producto_id_pr;
    }

    public void setProducto_id_pr(int producto_id_pr) {
        this.producto_id_pr = producto_id_pr;
    }

    public int getPedido_empleado_id_em() {
        return pedido_empleado_id_em;
    }

    public void setPedido_empleado_id_em(int pedido_empleado_id_em) {
        this.pedido_empleado_id_em = pedido_empleado_id_em;
    }

    public int getPedido_cliente_id_c() {
        return pedido_cliente_id_c;
    }

    public void setPedido_cliente_id_c(int pedido_cliente_id_c) {
        this.pedido_cliente_id_c = pedido_cliente_id_c;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
    
}
