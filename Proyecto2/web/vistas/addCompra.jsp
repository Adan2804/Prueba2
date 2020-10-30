
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
                <h1>Agregar compra de inventario</h1>
                <form action="ControladorCompra">
                    Proveedor:<br>
                    <input class="form-control" type="text" name="txtPro"><br>
                    Costo Total:<br>
                    <input class="form-control" type="text" name="txtCos"><br>
                    Stock Total: <br>
                    <input class="form-control" type="text" name="txtCan"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="ControladorProducto?accion=listar">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
