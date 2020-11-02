package ModeloDAO;

import Config.Conexion;
import Modelo.Cliente;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cliente cl = new Cliente();

    public List listar() {
        ArrayList<Cliente> list = new ArrayList<>();
        String sql = "select * from cliente";
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setDni(rs.getString("dni_cl"));
                cli.setNombre(rs.getString("nombre_cl"));
                cli.setApellido(rs.getString("apellido_cl"));
                cli.setDireccion(rs.getString("direccion_cl"));
                cli.setCelular(rs.getString("celular_cl"));
                cli.setId(rs.getInt("id_cl"));
                list.add(cli);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Cliente list(int id) {
        String sql = "select * from cliente where id_cl= " + id;
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cl.setId(rs.getInt("id_cl"));
                cl.setDni(rs.getString("dni_cl"));
                cl.setNombre(rs.getString("nombre_cl"));
                cl.setApellido(rs.getString("apellido_cl"));
                cl.setDireccion(rs.getString("direccion_cl"));
                cl.setCelular(rs.getString("celular_cl"));

            }
        } catch (Exception e) {
        }
        return cl;
    }

    public boolean add(Cliente Cli) {
        String sql = "insert into cliente(dni_cl, nombre_cl, apellido_cl, direccion_cl, celular_cl)values('" + Cli.getDni() + "','" + Cli.getNombre() + "','" + Cli.getApellido() + "','" + Cli.getDireccion() + "','" + Cli.getCelular() + "')";
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public boolean edit(Cliente Cli) {
        String sql = "update cliente set dni_cl='" + Cli.getDni() + "',nombre_cl='" + Cli.getNombre() + "',apellido_cl='" + Cli.getApellido() + "',direccion_cl='" + Cli.getDireccion() + "',celular_cl='" + Cli.getCelular() + "' where id_cl=" + Cli.getId();
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }

        return false;
    }

    public boolean eliminar(int id) {
        String sql = "delete from cliente where id_cl=" + id;
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
      public Cliente check(String dni) {
           Cliente cli = new Cliente();
        String sql = "select * from cliente where dni_cl='"+dni+"'";
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
               
                cli.setDni(rs.getString("dni_cl"));
                cli.setNombre(rs.getString("nombre_cl"));
                cli.setApellido(rs.getString("apellido_cl"));
                cli.setDireccion(rs.getString("direccion_cl"));
                cli.setCelular(rs.getString("celular_cl"));
                cli.setId(rs.getInt("id_cl"));
            }
        } catch (Exception e) {
        }
        return cli;
    }
}
