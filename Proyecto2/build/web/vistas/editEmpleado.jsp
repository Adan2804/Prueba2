
<%@page import="Modelo.Empleado"%>
<%@page import="ModeloDAO.EmpleadoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <%
                    EmpleadoDAO dao = new EmpleadoDAO();
                    int id = Integer.parseInt((String) request.getAttribute("idper"));
                    Empleado e = (Empleado) dao.list(id);
                %>
                <h1>Modificar Empleado</h1>
                <form action="ControladorEmpleado">
                    DNI:<br>
                    <input class="form-control" type="text" name="txtDni" value="<%= e.getDni()%>"><br>
                    Nombres: <br>
                    <input class="form-control" type="text" name="txtNom" value="<%= e.getNombre()%>"><br>
                    Apellido:<br>
                    <input class="form-control" type="text" name="txtApe" value="<%= e.getApellido()%>"><br>
                    Celular: <br>
                    <input class="form-control" type="text" name="txtCel" value="<%= e.getCelular()%>"><br>
                    Tipo:<br>
                    <input class="form-control" type="text" name="txtTip" value="<%= e.getTipo()%>"><br>
                    Usuario: <br>
                    <input class="form-control" type="text" name="txtUsu" value="<%= e.getUsuario()%>"><br>
                    Contraseña:<br>
                    <input class="form-control" type="text" name="txtCon" value="<%= e.getContra()%>"><br>
                    Email: <br>
                    <input class="form-control" type="text" name="txtEma" value="<%= e.getEmail()%>"><br>

                    <input type="hidden" name="txtid" value="<%= e.getId()%>">
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                    <a href="ControladorEmpleado?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
