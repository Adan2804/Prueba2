
package ModeloDAO;

import Config.Conexion;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Producto p=new Producto();
    
    public List listar() {
        ArrayList<Producto>list=new ArrayList<>();
        String sql="select * from producto";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto pr=new Producto();
                pr.setId(rs.getInt("id_pr"));
                pr.setNombre(rs.getString("nombre_pr"));
                pr.setTipo(rs.getString("tipo_pr"));
                pr.setCantidad(rs.getInt("cantidad_pr"));
                pr.setPrecio(rs.getDouble("precio_pr"));
                pr.setFoto(rs.getBinaryStream("FOTO"));
                
                list.add(pr);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Producto list(int id) {
        String sql="select * from producto where id_pr="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                p.setId(rs.getInt("id_pr"));
                p.setNombre(rs.getString("nombre_pr"));
                p.setTipo(rs.getString("tipo_pr"));
                p.setCantidad(rs.getInt("cantidad_pr"));
                p.setPrecio(rs.getDouble("precio_pr"));
                p.setFoto(rs.getBinaryStream("FOTO"));
            }
        } catch (Exception e) {
        }
        return p;
    }

    public boolean add(Producto pr) {
       String sql="insert into producto(nombre_pr, tipo_pr, cantidad_pr, precio_pr, FOTO)values('"+pr.getNombre()+"','"+pr.getTipo()+"','"+pr.getCantidad()+"','"+pr.getPrecio()+"','"+pr.getFoto()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    public boolean edit(Producto pr) {
        String sql="update producto set nombre_pr='"+pr.getNombre()+"',tipo_pr='"+pr.getTipo()+"',cantidad_pr='"+pr.getCantidad()+"',precio_pr='"+pr.getPrecio()+"'where id_pr="+pr.getId();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public boolean eliminar(int id) {
        String sql="delete from producto where id_pr="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
      
}
