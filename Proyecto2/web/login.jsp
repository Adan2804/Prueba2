
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="container mt-4 col-lg-4">
            <div class="card">
                <div class="car-body text-center">
                    <form class="form-sign" action="Validar" >
                        <div class="form-group">
                            <h3>Login</h3>
                        </div>
                        <div class="form-group">
                            <label>Usuario: </label>
                            <input type="text" name="txtUsu" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Password: </label>
                            <input type="text" name="txtCon" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="ingresar" class="btn btn-primary btn-block">
                    </form>
                </div>
            </div>
        </div>
     </body>
</html>
