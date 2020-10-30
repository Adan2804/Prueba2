package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import Modelo.Compra;
import java.util.List;
import ModeloDAO.ComprarDAO;

public final class listarCompra_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Compra de inventario</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <h1>Compra de inventario</h1>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-6\"><input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Nombre\" aria-label=\"Search\"></div>\n");
      out.write("                <div class=\"col-3\"><button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Buscar</button></div>\n");
      out.write("                <div class=\"col-3\"><a class=\"btn btn-success\" href=\"ControladorCompra?accion=add\">Agregar Nuevo</a></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col\">\n");
      out.write("\n");
      out.write("                    <br>\n");
      out.write("                    <br>\n");
      out.write("                    <table class=\"table table-bordered\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th class=\"text-center\">PROVEEDOR</th>\n");
      out.write("                                <th class=\"text-center\">FECHA</th>\n");
      out.write("                                <th class=\"text-center\">COSTO TOTAL</th>\n");
      out.write("                                <th class=\"text-center\">STOCK TOTAL</th>\n");
      out.write("                                <th class=\"text-center\">ACCIONES</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        ");

                            ComprarDAO dao = new ComprarDAO();
                            List<Compra> list = dao.listar();
                            Iterator<Compra> iter = list.iterator();
                            Compra pro = null;
                            while (iter.hasNext()) {
                                pro = iter.next();
                        
      out.write("\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td class=\"text-center\">");
      out.print( pro.getProveedor());
      out.write("</td>\n");
      out.write("                                <td class=\"text-center\">");
      out.print( pro.getFecha().substring(0,11));
      out.write("</td>\n");
      out.write("                                <td class=\"text-center\">");
      out.print( pro.getCostototal());
      out.write("</td>\n");
      out.write("                                <td class=\"text-center\">");
      out.print( pro.getCantidadtotal());
      out.write("</td>\n");
      out.write("                                <td class=\"text-center\">\n");
      out.write("                                    <a class=\"btn btn-warning\" href=\"ControladorCompra?accion=editar&id=");
      out.print( pro.getIdcompra());
      out.write("\">Editar</a>\n");
      out.write("                                    <a class=\"btn btn-danger\" href=\"ControladorCompra?accion=eliminar&id=");
      out.print( pro.getIdcompra());
      out.write("\">Remove</a>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
