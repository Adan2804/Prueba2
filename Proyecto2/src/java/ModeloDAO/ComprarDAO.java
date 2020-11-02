
package ModeloDAO;

import Config.Conexion;
import Modelo.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ComprarDAO {
    
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Compra c=new Compra();
    
    public List listar() {
        ArrayList<Compra>list=new ArrayList<>();
        String sql="select * from compra";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Compra co=new Compra();
                co.setIdcompra(rs.getInt("idcompra"));
                co.setProveedor(rs.getString("proveedor"));
                co.setFecha(rs.getString("fecha"));
                co.setCantidadtipos(rs.getInt("cantidadtipos"));
                co.setCostototal(rs.getDouble("costototal"));
                co.setCantidadtotal(rs.getInt("cantidadtotal"));
                
                list.add(co);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Compra list(int id) {
        String sql="select * from compra where idcompra="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                c.setIdcompra(rs.getInt("idcompra"));
                c.setProveedor(rs.getString("proveedor"));
                c.setFecha(rs.getString("fecha"));
                c.setCantidadtipos(rs.getInt("cantidadtipos"));
                c.setCostototal(rs.getDouble("costototal"));
                c.setCantidadtotal(rs.getInt("cantidadtotal"));

            }
        } catch (Exception e) {
        }
        return c;
    }

    public boolean add(Compra co) {
       String sql="insert into compra(proveedor, fecha, cantidadtipos, costototal, cantidadtotal)values('"+
               co.getProveedor()+"','"+
               co.getFecha()+"','"+
               co.getCantidadtipos()+"','"+
               co.getCostototal()+"','"+
               co.getCantidadtotal()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    public boolean edit(Compra co) {
        String sql="update compra set proveedor='"+co.getProveedor()+
                "',fecha='"+co.getFecha()+
                "',cantidadtipos='"+co.getCantidadtipos()+
                "',costototal="+co.getCostototal()+
                ",cantidadtotal="+co.getCantidadtotal()+
                " where idcompra="+co.getIdcompra();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public boolean eliminar(int id) {
        String sql="delete from compra where idcompra="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    
}
