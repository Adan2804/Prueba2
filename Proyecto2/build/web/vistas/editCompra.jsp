
<%@page import="Modelo.Compra"%>
<%@page import="ModeloDAO.ComprarDAO"%>
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
              ComprarDAO dao=new ComprarDAO();
              int id=Integer.parseInt((String)request.getAttribute("idcli"));
              Compra c=(Compra)dao.list(id);
          %>
            <h1>Modificar Persona</h1>
            <form action="ControladorCompra">
                    Proveedor:<br>
                    <input class="form-control" type="text" name="txtPro" value="<%=c.getProveedor()%>"><br>
                    Fecha: <br>
                    <input class="form-control" type="text" name="txtFec" value="<%=c.getFecha()%>"><br>
                    Costo total: <br>
                    <input class="form-control" type="text" name="txtCos" value="<%=c.getCostototal()%>"><br>
                    Stock<br>
                    <input class="form-control" type="text" name="txtCan" value="<%=c.getCantidadtotal()%>"><br>
                
                <input type="hidden" name="txtid" value="<%=c.getIdcompra()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="ControladorCompra?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
