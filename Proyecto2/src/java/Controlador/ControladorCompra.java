
package Controlador;

import Config.Fecha;
import Modelo.Compra;
import Modelo.RegistroCompra;
import ModeloDAO.ComprarDAO;
import ModeloDAO.RegistroCompraDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorCompra extends HttpServlet {


    String listar1="listarCompra.jsp";
    String add1="vistas/addCompra.jsp";
    String edit1="vistas/editCompra.jsp";
    String listar2="listarRegistrocompra.jsp";
    String add2="vistas/addRegistrocompra.jsp";
    String edit2="vistas/editRegistrocompra.jsp";
    
    Compra c=new Compra();
    ComprarDAO dao=new ComprarDAO();
    RegistroCompra r = new RegistroCompra();
    RegistroCompraDAO rdao = new RegistroCompraDAO();
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
        if(action.equalsIgnoreCase("listar1")){
            acceso=listar1;            
        }
        else if (action.equalsIgnoreCase("listar2")){
            
        }else if(action.equalsIgnoreCase("add1")){
            acceso=add1;
        }
        else if (action.equalsIgnoreCase("add2")){
            
        }
        else if(action.equalsIgnoreCase("Agregar compra")){
            
            String pro=request.getParameter("txtPro");
            
            String fec = fecha.FechaBD();
            
            int cant=Integer.parseInt(request.getParameter("txtCant"));
            double cos=Double.parseDouble(request.getParameter("txtCos"));
            int can=Integer.parseInt(request.getParameter("txtCan"));

            c.setProveedor(pro);
            c.setFecha(fec);
            c.setCantidadtipos(cant);
            c.setCostototal(cos);
            c.setCantidadtotal(can);
            
            dao.add(c);
            acceso=add2;
        }
        else if (action.equalsIgnoreCase("Agregar detalles")){
            
        }
        else if(action.equalsIgnoreCase("editar1")){
            request.setAttribute("idcli",request.getParameter("id"));
            acceso=edit1;
        }
        else if (action.equalsIgnoreCase("editar2")){
            
        }
        else if(action.equalsIgnoreCase("Actualizar compra")){
            id=Integer.parseInt(request.getParameter("txtid"));
            String pro=request.getParameter("txtPro");
            String fec = request.getParameter("txtFec");
            int cant=Integer.parseInt(request.getParameter("txtCant"));
            double cos=Double.parseDouble(request.getParameter("txtCos"));
            int can=Integer.parseInt(request.getParameter("txtCan"));
            
            //Enviar cantidad tipos
            request.setAttribute("filas",cant);
           
            
            c.setIdcompra(id);
            c.setProveedor(pro);
            c.setFecha(fec);
            c.setCantidadtipos(cant);
            c.setCostototal(cos);
            c.setCantidadtotal(can);
            dao.edit(c);
            acceso=listar1;
            
        }
        else if (action.equalsIgnoreCase("Actualizar2")){
            
        }
        else if(action.equalsIgnoreCase("eliminar1")){
            id=Integer.parseInt(request.getParameter("id"));
            c.setIdcompra(id);
            dao.eliminar(id);
            acceso=listar1;
        }
        else if (action.equalsIgnoreCase("eliminar2")){
            
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