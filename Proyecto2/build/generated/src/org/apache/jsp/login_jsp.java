package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!--\n");
      out.write("    \n");
      out.write("    <!DOCTYPE html>\n");
      out.write("    <html>\n");
      out.write("        <head>\n");
      out.write("            <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("            <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">\n");
      out.write("            <title>JSP Page</title>\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("\n");
      out.write("            <div class=\"container mt-4 col-lg-4\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <div class=\"car-body text-center\">\n");
      out.write("                        <form class=\"form-sign\" action=\"Validar\" >\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <h3>Login</h3>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Usuario: </label>\n");
      out.write("                                <input type=\"text\" name=\"txtUsu\" class=\"form-control\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Password: </label>\n");
      out.write("                                <input type=\"text\" name=\"txtCon\" class=\"form-control\">\n");
      out.write("                            </div>\n");
      out.write("                            <input type=\"submit\" name=\"accion\" value=\"ingresar\" class=\"btn btn-primary btn-block\">\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("         </body>\n");
      out.write("    </html>\n");
      out.write("\n");
      out.write("    -->\n");
      out.write("    <!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\t<title>LOGIN</title>\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\n");
      out.write("\t<!-- Bootstrap CSS -->\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\"\n");
      out.write("\t\tintegrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css.css\">\n");
      out.write("\t<script src=\"https://kit.fontawesome.com/yourcode.js\"></script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("\n");
      out.write("<body class=\"bg-gradient-primary\">\n");
      out.write("\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\n");
      out.write("\t\t<!-- Outer Row -->\n");
      out.write("\t\t<div class=\"row justify-content-center\">\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"col-xl-4 \">\n");
      out.write("\n");
      out.write("\t\t\t\t<div class=\"card o-hidden border-0 shadow-lg my-4\">\n");
      out.write("\t\t\t\t\t<div class=\"card-body p-1\">\n");
      out.write("\t\t\t\t\t\t<!-- Nested Row within Card Body -->\n");
      out.write("\t\t\t\t\t\t<div class=\"row\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-lg-12\">\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"p-4\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"text-center\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<svg width=\"7em\" height=\"7em\" viewBox=\"0 0 16 16\" class=\"bi bi-person-fill\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tfill=\"currentColor\" xmlns=\"http://www.w3.org/2000/svg\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<path fill-rule=\"evenodd\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\td=\"M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z\" />\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</svg>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t<form class=\"user\" action=\"Validar\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"txtUsu\" class=\"form-control\" placeholder=\"Usuario\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"txtCon\" class=\"form-control\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tplaceholder=\"Contraseña\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"custom-control custom-checkbox small\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" class=\"custom-control-input\" id=\"customCheck\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"custom-control-label\" for=\"customCheck\">Recordar</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"submit\" name=\"accion\" value=\"ingresar\"class=\"btn btn-primary btn-user btn-block\">\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<hr>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-google btn-user btn-block\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<i class=\"fab fa-google fa-fw\"></i> ingresar con Google\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-facebook btn-user btn-block\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<i class=\"fab fa-facebook-f fa-fw\"></i> Ingresar con Facebook\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t\t\t\t\t<hr>\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"text-center\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a class=\"small\" href=\"#\">Olvidó contraseña?</a>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"text-center\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a class=\"small\" href=\"#\">Crear una cuenta!</a>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t<footer>\n");
      out.write("\n");
      out.write("\t\t<br>\n");
      out.write("\t</footer>\n");
      out.write("\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"\n");
      out.write("\t\tintegrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\"\n");
      out.write("\t\tcrossorigin=\"anonymous\"></script>\n");
      out.write("\t<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js\"\n");
      out.write("\t\tintegrity=\"sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx\"\n");
      out.write("\t\tcrossorigin=\"anonymous\"></script>\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"\n");
      out.write("\t\tintegrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\"\n");
      out.write("\t\tcrossorigin=\"anonymous\"></script>\n");
      out.write("\t<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"\n");
      out.write("\t\tintegrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\"\n");
      out.write("\t\tcrossorigin=\"anonymous\"></script>\n");
      out.write("\t<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js\"\n");
      out.write("\t\tintegrity=\"sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s\"\n");
      out.write("\t\tcrossorigin=\"anonymous\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
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
