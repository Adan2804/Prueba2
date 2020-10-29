package ModeloDAO;

import Config.Conexion;
import Modelo.Cliente;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Intefaces.CLIENTECRUD;

public class ClienteDAO implements CLIENTECRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cliente cl = new Cliente();

    @Override
    public List listar() {
        ArrayList<Cliente> list = new ArrayList<>();
        String sql = "select * from cliente";
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setDni(rs.getString("dni_c"));
                cli.setNombre(rs.getString("nombre_c"));
                cli.setApellido(rs.getString("apellido_c"));
                cli.setDireccion(rs.getString("direccion_c"));
                cli.setCelular(rs.getString("celular_c"));
                cli.setId(rs.getInt("id_c"));
                list.add(cli);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Cliente list(int id) {
        String sql = "select * from cliente where id_c= " + id;
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cl.setId(rs.getInt("id_c"));
                cl.setDni(rs.getString("dni_c"));
                cl.setNombre(rs.getString("nombre_c"));
                cl.setApellido(rs.getString("apellido_c"));
                cl.setDireccion(rs.getString("direccion_c"));
                cl.setCelular(rs.getString("celular_c"));

            }
        } catch (Exception e) {
        }
        return cl;
    }

    @Override
    public boolean add(Cliente Cli) {
        String sql = "insert into cliente(dni_c, nombre_c, apellido_c, direccion_c, celular_c)values('" + Cli.getDni() + "','" + Cli.getNombre() + "','" + Cli.getApellido() + "','" + Cli.getDireccion() + "','" + Cli.getCelular() + "')";
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Cliente Cli) {
        String sql = "update cliente set dni_c='" + Cli.getDni() + "',nombre_c='" + Cli.getNombre() + "',apellido_c='" + Cli.getApellido() + "',direccion_c='" + Cli.getDireccion() + "',celular_c='" + Cli.getCelular() + "' where id_c=" + Cli.getId();
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }

        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from cliente where id_c=" + id;
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
