package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class CADO 
{   
    private Connection conectar()
    {        
        String cadenaConexion="";
    
        String tipoBase = "mysql";
        String servidorBD = "localhost";
        String puertoBD = "3306";
        String BD = "proyecto";

        cadenaConexion="jdbc:"+tipoBase+"://"+
                servidorBD+":"+puertoBD+"/"+BD;

        Properties parametros = new Properties();
        parametros.put("user", "root");
        parametros.put("password", "ramos123");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(cadenaConexion, parametros);
        }catch(Exception e){
            return null;
        }
    }
    
    public String ejecutar(String sql)
    {
        Statement st;
        try{
            st = this.conectar().createStatement();                     
            st.executeUpdate(sql);
            return "Operacion realizada";
        }catch(Exception e){
            return "ERROR ::: " + e.getMessage();
        }
    }
    
    public ResultSet recuperar(String sql)
    {
        Statement st;
        try{
            st = this.conectar().createStatement(ResultSet.CONCUR_READ_ONLY,
                    ResultSet.TYPE_SCROLL_INSENSITIVE);                     
            return st.executeQuery(sql);
        }catch(Exception e){
            return null;
        }
    }
}
