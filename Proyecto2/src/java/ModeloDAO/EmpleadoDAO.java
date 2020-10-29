package ModeloDAO;

import Config.CADO;
import Config.Conexion;
import Intefaces.EMPLEADOCRUD;
import Modelo.Empleado;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO implements EMPLEADOCRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Empleado emp = new Empleado();

    
     public Empleado validar(String usuario, String contra) {
        Empleado em = new Empleado();
        String sql = "select * from empleado where usuario_em=? and contra_em=?";
        try {

            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contra);
            rs = ps.executeQuery();

            while (rs.next()) {
                em.setId(rs.getInt("id_em"));
                em.setUsuario(rs.getString("usuario_em"));
                
            }

        } catch (Exception e) {
        }
        return em;
    }
    
    @Override
    public List listar() {
        ArrayList<Empleado> list = new ArrayList<>();
        String sql = "select * from empleado";
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado Em = new Empleado();
                Em.setId(rs.getInt("id_em"));
                Em.setNombre(rs.getString("nombre_em"));
                Em.setApellido(rs.getString("apellido_em"));
                Em.setCelular(rs.getString("celular_em"));
                Em.setTipo(rs.getString("tipo_em"));
                Em.setUsuario(rs.getString("usuario_em"));
                Em.setContra(rs.getString("contra_em"));
                Em.setEmail(rs.getString("email_em"));
                Em.setDni(rs.getString("dni_em"));
                list.add(Em);
            }
        } catch (Exception e) {
        }
        return list;

    }

    @Override
    public Empleado list(int id) {
        String sql = "select * from empleado where Id_em= " + id;
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setId(rs.getInt("id_em"));
                emp.setNombre(rs.getString("nombre_em"));
                emp.setApellido(rs.getString("apellido_em"));
                emp.setCelular(rs.getString("celular_em"));
                emp.setTipo(rs.getString("tipo_em"));
                emp.setUsuario(rs.getString("usuario_em"));
                emp.setContra(rs.getString("contra_em"));
                emp.setEmail(rs.getString("email_em"));
                emp.setDni(rs.getString("dni_em"));

            }
        } catch (Exception e) {
        }
        return emp;
    }

    @Override
    public boolean add(Empleado Emp) {
        String sql = "insert into empleado(dni_em, nombre_em, apellido_em, celular_em, tipo_em, usuario_em, contra_em, email_em)values('" + Emp.getDni() + "','" + Emp.getNombre() + "','" + Emp.getApellido() + "','" + Emp.getCelular() + "','" + Emp.getTipo() + "','" + Emp.getUsuario() + "','" + Emp.getContra() + "','" + Emp.getEmail() + "')";
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Empleado Emp) {
        String sql = "update empleado set nombre_em='" + Emp.getNombre() + "',apellido_em='" + Emp.getApellido() + "',celular_em='" + Emp.getCelular() + "',tipo_em='" + Emp.getTipo() + "',usuario_em='" + Emp.getUsuario() + "',contra_em='" + Emp.getContra()+ "',email_em='" + Emp.getEmail() +"',dni_em='" + Emp.getDni() +"' where id_em=" + Emp.getId();
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
        String sql = "delete from empleado where id_em=" + id;
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    

 public bean.Empleado ValidarUsuario(String usu, String cla)
    {
        ResultSet rs;
        String sql="SELECT * FROM empleado WHERE usuario_em ='" +
                usu + "' AND contra_em = '" + cla + "'";
        CADO ocado = new CADO();
        rs = ocado.recuperar(sql);
        try {
            rs.beforeFirst();
            if(rs.next()){
                bean.Empleado ousuario = new bean.Empleado();
                ousuario.setIdusuario(rs.getInt("id_em"));
                ousuario.setNombrecompleto(rs.getString("nombre_em"));
                ousuario.setLogin(rs.getString("usuario_em"));
                ousuario.setClave(rs.getString("contra_em"));
                return ousuario;
            }
            else{
                return null;
            }
        } catch (Exception ex) {
            return null;
        }        
    }    

}
