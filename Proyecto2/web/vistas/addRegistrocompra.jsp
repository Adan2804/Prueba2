
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
                 <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th class="text-center">MARCA</th>
                                <th class="text-center">C/U DEL GAS</th>
                                <th class="text-center">V/U DEL GAS</th>
                                <th class="text-center">CANTIDAD</th>
                                <th class="text-center">SUB TOTAL</th>
                                <th class="text-center">PRODUCTO</th>

                            </tr>
                        </thead>
                        <%
                            int filas= (int)request.getAttribute("filas");
                            for(int i=0; i<filas;i++) {
                                
                        %>
                        <tbody>
                            <tr>
                                <td class="text-center"><input class="form-control" type="text" name="txtMar"<%=+i%>></td>
                                <td class="text-center"><input class="form-control" type="text" name="txtCos"><br></td>
                                <td class="text-center"><input class="form-control" type="text" name="txtVen"><br></td>
                                <td class="text-center"><input class="form-control" type="text" name="txtCan"><br></td>
                                <td class="text-center"><input class="form-control" type="text" name="txtPro"><br></td>

                            </tr>
                            <%}%>
                        </tbody>
                    </table>
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar compra de inventario</h1>
                <form action="ControladorCompra">

                    
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar detalles">
                    <a href="ControladorCompra?accion=listar1">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
