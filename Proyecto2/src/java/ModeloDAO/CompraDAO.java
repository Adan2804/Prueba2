package ModeloDAO;

import Config.Conexion;
import Modelo.Carrito;
import Modelo.DetalleCompra;
import Modelo.Pedido;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompraDAO {

    //Producto pr = new Producto();
    Conexion cn = new Conexion();
    //Pedido pe = new Pedido();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r=0;

    public int GenerarCompra(Pedido compra) {
        int idcompras;
        String sql="insert into pedidos(precio_p, fecha_hora_p, estado_p, empleado_id_em, pago_id_pa, cliente_id_cl)values(?,?,?,?,?,?)";
        try {
            
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setDouble(1, compra.getMonto());
            ps.setString(2, compra.getFecha());
            ps.setString(3, compra.getEstado());
            ps.setInt(4, compra.getEmpleado().getId());
            ps.setInt(5, compra.getIdpago());
            ps.setInt(6, compra.getCliente().getId());
            r=ps.executeUpdate();
            
            sql="select @IDENTIFY AS id_p";
            rs=ps.executeQuery(sql);
            rs.next();
            idcompras=rs.getInt("id_p");
            rs.close();
            
            for (Carrito detalle : compra.getDetallecompras()) {
                sql="insert into registro(total_precio_r, precio_r, pedido_id_p, producto_id_pr, pedido_empleado_id_em, pedido_cliente_id_c)values(?,?,?,?,?,?)";
                ps=con.prepareStatement(sql);
                ps.setDouble(1, compra.getMonto());
                ps.setDouble(2, detalle.getSubTotal());
                ps.setInt(3, idcompras);
                ps.setInt(4, detalle.getIdProducto());
                ps.setInt(5, compra.getEmpleado().getId());
                ps.setInt(6, compra.getCliente().getId());
                r=ps.executeUpdate();
            }
            
            
        } catch (Exception e) {
        }

        return r;
    }
    
    
    
    public int IdCompra() {
        int idc = 0;
        String sql = "select max(id_p) from pedidos";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idc = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return idc;
    }
    
    public int guardarCompra(Pedido co) {
        String sql = "insert into pedidos(precio_p, cantidad_p, fecha_hora_p, estado_p, empleado_id_em, pago_id_pa,cliente_id_cl)values(?,?,?,?,?,?,?)";
        try {
            
            ps.setDouble(1, co.getMonto());
            ps.setInt(2, co.getDetallecompras().size());
            ps.setString(3, co.getFecha());
            ps.setString(4, co.getEstado());
            ps.setInt(5, co.getEmpleado().getId());
            ps.setInt(6, co.getIdpago());
            ps.setInt(7, co.getCliente().getId());
           
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return 1;
    }

    public int guardarDetalleCompra(DetalleCompra dc) {
        String sql = "insert into registro(total_precio_r, precio_r, pedido_id_p, producto_id_pr, pedido_empleado_id_em, pedido_cliente_id_c)values(?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, dc.getTotal_precio_r());
            ps.setDouble(2, dc.getPrecio_r());
            ps.setInt(3, dc.getPedido_id_p());
            ps.setInt(4, dc.getProducto_id_pr());
            ps.setInt(5, dc.getPedido_empleado_id_em());
            ps.setInt(6, dc.getPedido_cliente_id_c());
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
        }
        return 1;
    }
    
    public int Pagar(double monto) {
        String sql = "insert into pago(monto_pa)values(?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, monto);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return 1;
    }
    
    public int IdPago() {
        int idpago = 0;
        String sql = "select max(id_pa) from pago";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idpago = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return idpago;
    }
    
}
