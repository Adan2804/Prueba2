
package ModeloDAO;

import Config.Conexion;
import Modelo.Compra;
import Modelo.Producto;
import Modelo.RegistroCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegistroCompraDAO {
    
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    RegistroCompra r=new RegistroCompra();
    
    public List listar() {
        ArrayList<RegistroCompra>list=new ArrayList<>();
        String sql="select * from registrocompra";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                RegistroCompra rc=new RegistroCompra();
                rc.setIdregistrocompra(rs.getInt("idregistrocompra"));
                rc.setMarca(rs.getString("marca"));
                rc.setCostounidadcompra(rs.getDouble("costounidadcompra"));
                rc.setPreciounidadventa(rs.getDouble("preciounidadventa"));
                rc.setCantidad(rs.getInt("cantidad"));
                rc.setSubtotal(rs.getDouble("subtotal"));
                
                Producto producto = new Producto();
                producto.setId(rs.getInt("producto_id_pr"));
                rc.setProducto(producto);
                
                Compra compra = new Compra();
                compra.setIdcompra(rs.getInt("compra_id_co"));
                rc.setCompra(compra);
                
                list.add(rc);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public RegistroCompra list(int id) {
        String sql="select * from registrocompra where idregistrocompra="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                r.setIdregistrocompra(rs.getInt("idregistrocompra"));
                r.setMarca(rs.getString("marca"));
                r.setCostounidadcompra(rs.getDouble("costounidadcompra"));
                r.setPreciounidadventa(rs.getDouble("preciounidadventa"));
                r.setCantidad(rs.getInt("cantidad"));
                r.setSubtotal(rs.getDouble("subtotal"));
                
                Producto producto = new Producto();
                producto.setId(rs.getInt("producto_id_pr"));
                r.setProducto(producto);
                
                Compra compra = new Compra();
                compra.setIdcompra(rs.getInt("compra_id_co"));
                r.setCompra(compra);


            }
        } catch (Exception e) {
        }
        return r;
    }

    public boolean add(RegistroCompra rc) {
       String sql="insert into registrocompra(marca, costounidadcompra, preciounidadventa, cantidad, subtotal, producto_id_pr, compra_id_co)values('"+
               rc.getMarca()+"','"+
               rc.getCostounidadcompra()+"','"+
               rc.getPreciounidadventa()+"','"+
               rc.getCantidad()+"','"+
               rc.getSubtotal()+"','"+
               rc.getProducto().getId()+"','"+
               rc.getCompra().getIdcompra()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    public boolean edit(RegistroCompra rc) {
        String sql="update registrocompra set marca='"+rc.getMarca()+
                "',costounidadcompra='"+rc.getCostounidadcompra()+
                "',preciounidadventa='"+rc.getPreciounidadventa()+
                "',cantidad='"+rc.getCantidad()+
                "',subtotal='"+rc.getSubtotal()+
                "',producto_id_pr='"+rc.getProducto().getId()+
                "',compra_id_co='"+rc.getCompra().getIdcompra()+
                "' where idregistrocompra="+rc.getIdregistrocompra();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public boolean eliminar(int id) {
        String sql="delete from registrocompra where idregistrocompra="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    
    
    
}
