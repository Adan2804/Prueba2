
<%@page import="Modelo.Producto"%>
<%@page import="ModeloDAO.ProDAO"%>
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
              ProDAO dao=new ProDAO();
              int id=Integer.parseInt((String)request.getAttribute("idper"));
              Producto p=(Producto)dao.listarId(id);
          %>
            <h1>Modificar Producto</h1>
            <form action="ControladorProducto">
                Nombre:<br>
                    <input class="form-control" type="text" name="txtNom" value="<%= p.getNombre()%>"><br>
                    Tipo: <br>
                    <input class="form-control" type="text" name="txtTip" value="<%= p.getTipo()%>"><br>
                    Stock:<br>
                    <input class="form-control" type="text" name="txtCan" value="<%= p.getCantidad()%>"><br>
                    Precio: <br>
                    <input class="form-control" type="text" name="txtPre" value="<%= p.getPrecio()%>"><br>
                
                <input type="hidden" name="txtid" value="<%= p.getId()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="ControladorProducto?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
