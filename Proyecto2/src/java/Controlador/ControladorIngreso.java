package Controlador;

import Modelo.Cliente;
import ModeloDAO.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorIngreso extends HttpServlet {

    Cliente c = new Cliente();
    ClienteDAO dao = new ClienteDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorIngreso</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorIngreso at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("Verificar")) {
            String dni = request.getParameter("txtDni");
            ClienteDAO dao = new ClienteDAO();
            List<Cliente> list = dao.listar();
            Iterator<Cliente> iter = list.iterator();
            Cliente Cli = null;
            int id = -1;
            while (iter.hasNext()) {
                Cli = iter.next();
                if (dni.equalsIgnoreCase(Cli.getDni())) {
                    id = Cli.getId();
                    break;
                };
            }
            if (id != -1) {
                RequestDispatcher vista = request.getRequestDispatcher("Comprar.jsp");
                vista.forward(request, response);
            } else {
                RequestDispatcher vista = request.getRequestDispatcher("RegistroCliente.jsp");
                vista.forward(request, response);
            }

        }
        
        
        
        

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
