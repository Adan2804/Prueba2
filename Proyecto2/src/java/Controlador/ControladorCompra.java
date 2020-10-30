
package Controlador;

import Config.Fecha;
import Modelo.Compra;
import ModeloDAO.ComprarDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorCompra extends HttpServlet {


   String listar="listarCompra.jsp";
    String add="vistas/addCompra.jsp";
    String edit="vistas/editCompra.jsp";
    Compra c=new Compra();
    ComprarDAO dao=new ComprarDAO();
    Fecha fecha = new Fecha();
    int id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;            
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            
            String pro=request.getParameter("txtPro");
            
            String fec = fecha.FechaBD();
            
            double cos=Double.parseDouble(request.getParameter("txtCos"));
            int can=Integer.parseInt(request.getParameter("txtCan"));

            c.setProveedor(pro);
            c.setFecha(fec);
            c.setCostototal(cos);
            c.setCantidadtotal(can);
            
            dao.add(c);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idcli",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("txtid"));
            String pro=request.getParameter("txtPro");
            String fec = request.getParameter("txtFec");
            double cos=Double.parseDouble(request.getParameter("txtCos"));
            int can=Integer.parseInt(request.getParameter("txtCan"));
            
            c.setIdcompra(id);
            c.setProveedor(pro);
            c.setFecha(fec);
            c.setCostototal(cos);
            c.setCantidadtotal(can);
            dao.edit(c);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            c.setIdcompra(id);
            dao.eliminar(id);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}