
package Controlador;

import Modelo.Cliente;
import ModeloDAO.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorCliente extends HttpServlet {

    String listar="listarCliente.jsp";
    String add="vistas/addCliente.jsp";
    String edit="vistas/editCliente.jsp";
    Cliente c=new Cliente();
    ClienteDAO dao=new ClienteDAO();
    int id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCliente at " + request.getContextPath() + "</h1>");
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
            String dni=request.getParameter("txtDni");
            String nom=request.getParameter("txtNom");
            String ape=request.getParameter("txtApe");
            String dir=request.getParameter("txtDir");
            String cel=request.getParameter("txtCel");
            c.setDni(dni);
            c.setNombre(nom);
            c.setApellido(ape);
            c.setDireccion(dir);
            c.setCelular(cel);
            dao.add(c);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("Agregar1")){
            String dni=request.getParameter("txtDni");
            String nom=request.getParameter("txtNom");
            String ape=request.getParameter("txtApe");
            String dir=request.getParameter("txtDir");
            String cel=request.getParameter("txtCel");
            c.setDni(dni);
            c.setNombre(nom);
            c.setApellido(ape);
            c.setDireccion(dir);
            c.setCelular(cel);
            dao.add(c);
            acceso="Comprar.jsp";
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idcli",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("txtid"));
            String dni=request.getParameter("txtDni");
            String nom=request.getParameter("txtNom");
            String ape=request.getParameter("txtApe");
            String dir=request.getParameter("txtDir");
            String cel=request.getParameter("txtCel");
            c.setId(id);
            c.setDni(dni);
            c.setNombre(nom);
            c.setApellido(ape);
            c.setDireccion(dir);
            c.setCelular(cel);
            dao.edit(c);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            c.setId(id);
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