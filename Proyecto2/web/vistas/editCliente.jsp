
<%@page import="Modelo.Cliente"%>
<%@page import="ModeloDAO.ClienteDAO"%>
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
              ClienteDAO dao=new ClienteDAO();
              int id=Integer.parseInt((String)request.getAttribute("idcli"));
              Cliente c=(Cliente)dao.list(id);
          %>
            <h1>Modificar Persona</h1>
            <form action="ControladorCliente">
                    DNI:<br>
                    <input class="form-control" type="text" name="txtDni" value="<%=c.getDni()%>"><br>
                    Nombre: <br>
                    <input class="form-control" type="text" name="txtNom" value="<%=c.getNombre()%>"><br>
                    Apellido: <br>
                    <input class="form-control" type="text" name="txtApe" value="<%=c.getApellido()%>"><br>
                    Direccion : <br>
                    <input class="form-control" type="text" name="txtDir" value="<%=c.getDireccion()%>"><br>
                    Celular : <br>
                    <input class="form-control" type="text" name="txtCel" value="<%=c.getCelular()%>"><br>
                
                <input type="hidden" name="txtid" value="<%=c.getId()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="ControladorCliente?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
