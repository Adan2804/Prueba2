/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import ModeloDAO.ProDAO;
import ModeloDAO.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class ControladorProducto extends HttpServlet {

    String listar="listarProducto.jsp";
    String add="vistas/addProducto.jsp";
    String edit="vistas/editProducto.jsp";
    Producto p=new Producto();
    ProductoDAO dao=new ProductoDAO();
    ProDAO im = new ProDAO();
    int id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorProducto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorProducto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
            String nom=request.getParameter("txtNom");
            String tip=request.getParameter("txtTip");
            int can=Integer.parseInt(request.getParameter("txtCan"));
            double pre=Double.parseDouble(request.getParameter("txtPre"));
            p.setNombre(nom);
            p.setTipo(tip);
            p.setCantidad(can);
            p.setPrecio(pre);
            dao.add(p);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("txtid"));
            String nom=request.getParameter("txtNom");
            String tip=request.getParameter("txtTip");
            int can=Integer.parseInt(request.getParameter("txtCan"));
            double pre=Double.parseDouble(request.getParameter("txtPre"));
            p.setId(id);
            p.setNombre(nom);
            p.setTipo(tip);
            p.setCantidad(can);
            p.setPrecio(pre);
            dao.edit(p);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            p.setId(id);
            dao.eliminar(id);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        switch(accion){
            case "Img":
                List<Producto> lista = im.listar();
                request.setAttribute("productos", lista);
                request.getRequestDispatcher("Comprar.jsp").forward(request, response);
            break;
            
            default:
                request.getRequestDispatcher("ControladorProducto?accion=Listar").forward(request, response);
                break;
        }
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
