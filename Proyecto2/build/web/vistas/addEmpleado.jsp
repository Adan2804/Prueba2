
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
                <h1>Agregar Persona</h1>
                <form action="ControladorEmpleado">
                    DNI:<br>
                    <input class="form-control" type="text" name="txtDni"><br>
                    Nombres: <br>
                    <input class="form-control" type="text" name="txtNom"><br>
                    Apellido:<br>
                    <input class="form-control" type="text" name="txtApe"><br>
                    Celular: <br>
                    <input class="form-control" type="text" name="txtCel"><br>
                    Tipo:<br>
                    <input class="form-control" type="text" name="txtTip"><br>
                    Usuario: <br>
                    <input class="form-control" type="text" name="txtUsu"><br>
                    Contraseña:<br>
                    <input class="form-control" type="text" name="txtCon"><br>
                    Email: <br>
                    <input class="form-control" type="text" name="txtEma"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="ControladorEmpleado?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
