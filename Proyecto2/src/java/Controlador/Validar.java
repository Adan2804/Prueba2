package Controlador;

import Modelo.Cliente;
import Modelo.Empleado;
import ModeloDAO.ClienteDAO;
import ModeloDAO.EmpleadoDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validar extends HttpServlet {

    EmpleadoDAO edao = new EmpleadoDAO();
    Empleado em = new Empleado();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion.equalsIgnoreCase("ingresar")) {
            String user = request.getParameter("txtUsu");
            String pass = request.getParameter("txtCon");
            em = edao.validar(user, pass);
            
            if (em.getUsuario() != null) {
                //request.setAttribute("usuario", em);
                 RequestDispatcher vista=request.getRequestDispatcher("administrador.jsp");
                 vista.forward(request, response);
            } else {
                RequestDispatcher vista=request.getRequestDispatcher("login.jsp");
                 vista.forward(request, response);
            }

        } else if(accion.equalsIgnoreCase("Verificar")){
            Cliente cli =new Cliente();
            String dni = request.getParameter("txtDni");
            ClienteDAO dao= new ClienteDAO();
            cli=dao.check(dni);
            if (cli.getDni()!=null) {
                //request.setAttribute("usuario", em);
                 RequestDispatcher vista=request.getRequestDispatcher("Comprar.jsp");
                 vista.forward(request, response);
            } else {
                RequestDispatcher vista=request.getRequestDispatcher("RegistroCliente.jsp");
                 vista.forward(request, response);
            }
            
        }
        else {
            RequestDispatcher vista=request.getRequestDispatcher("login.jsp");
                 vista.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
