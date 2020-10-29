package Controlador;

import bean.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ModeloDAO.EmpleadoDAO;

public class scontrolador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {

            RequestDispatcher rd;
            int opcion = Integer.parseInt(request.getParameter("opcion"));
            switch(opcion)
            {
                case 0: //carga el login del sistema
                    response.sendRedirect("login.jsp");
                    break;                
                case -1:
                    response.sendRedirect("administrador.jsp");
                    break;
                
                case 12:
                    response.sendRedirect("login.jsp");
                    break;
                case 13: //verificar si las credenciales de usuario en fmlogin.jsp son validas
                    EmpleadoDAO ousuario = new EmpleadoDAO();
                    Empleado bean = ousuario.ValidarUsuario(request.getParameter("txtusuario"),
                            request.getParameter("txtclave"));
                    //si es correcto 
                    if(bean!=null)
                    {
                    /////// creamos la sesion
                        HttpSession osesion = request.getSession();
                    /////// guardamos en sesion los datos del usuario
                        osesion.setAttribute("nombreusuario", bean.getNombrecompleto());
                    /////// ir al menu
                        response.sendRedirect("scontrolador?opcion=-1");
                        //response.sendRedirect("menuprincipal.jsp");
                    }
                    else
                    {
                    //si no es correcto
                    //guardar mensaje INCORRECTO para mostrar
                        request.setAttribute("msj", "Datos incorrectos...");
                    /////// ir a fmlogin
                        rd = request.getRequestDispatcher("login.jsp");                        
                        rd.forward(request, response);
                    }                    
                    break;
              
                }
            }
        }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
