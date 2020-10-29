
package Controlador;

import Modelo.Empleado;
import ModeloDAO.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class ControladorEmpleado extends HttpServlet {

    String listar="listarEmpleado.jsp";
    String add="vistas/addEmpleado.jsp";
    String edit="vistas/editEmpleado.jsp";
    Empleado e=new Empleado();
    EmpleadoDAO dao=new EmpleadoDAO();
    int id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorEmpleado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorEmpleado at " + request.getContextPath() + "</h1>");
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
            String cel=request.getParameter("txtCel");
            String tip=request.getParameter("txtTip");
            String usu=request.getParameter("txtUsu");
            String con=request.getParameter("txtCon");
            String ema=request.getParameter("txtEma");
            e.setDni(dni);
            e.setNombre(nom);
            e.setApellido(ape);
            e.setCelular(cel);
            e.setTipo(tip);
            e.setUsuario(usu);
            e.setContra(con);
            e.setEmail(ema);
            dao.add(e);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("txtid"));
            String dni=request.getParameter("txtDni");
            String nom=request.getParameter("txtNom");
            String ape=request.getParameter("txtApe");
            String cel=request.getParameter("txtCel");
            String tip=request.getParameter("txtTip");
            String usu=request.getParameter("txtUsu");
            String con=request.getParameter("txtCon");
            String ema=request.getParameter("txtEma");
            e.setId(id);
            e.setDni(dni);
            e.setNombre(nom);
            e.setApellido(ape);
            e.setCelular(cel);
            e.setTipo(tip);
            e.setUsuario(usu);
            e.setContra(con);
            e.setEmail(ema);
            dao.edit(e);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            e.setId(id);
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
