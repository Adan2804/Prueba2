<!--
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

    -->
    <!DOCTYPE html>
<html>

<head>
	<title>LOGIN</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
		integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<link rel="stylesheet" href="css.css">
	<script src="https://kit.fontawesome.com/yourcode.js"></script>

</head>


<body class="bg-gradient-primary">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-4 ">

				<div class="card o-hidden border-0 shadow-lg my-4">
					<div class="card-body p-1">
						<!-- Nested Row within Card Body -->
						<div class="row">

							<div class="col-lg-12">
								<div class="p-4">
									<div class="text-center">
										<svg width="7em" height="7em" viewBox="0 0 16 16" class="bi bi-person-fill"
											fill="currentColor" xmlns="http://www.w3.org/2000/svg">
											<path fill-rule="evenodd"
												d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
										</svg>

									</div>
									<form class="user" action="Validar">
										<div class="form-group">
											<input type="text" name="txtUsu" class="form-control" placeholder="Usuario">
										</div>
										<div class="form-group">
											<input type="text" name="txtCon" class="form-control"
												placeholder="Contraseña">
										</div>
										<div class="form-group">
											<div class="custom-control custom-checkbox small">
												<input type="checkbox" class="custom-control-input" id="customCheck">
												<label class="custom-control-label" for="customCheck">Recordar</label>
											</div>
										</div>
									</div>
									<input type="submit" name="accion" value="ingresar"class="btn btn-primary btn-user btn-block">	
										
										<hr>
										<a href="#" class="btn btn-google btn-user btn-block">
											<i class="fab fa-google fa-fw"></i> ingresar con Google
										</a>
										<a href="#" class="btn btn-facebook btn-user btn-block">
											<i class="fab fa-facebook-f fa-fw"></i> Ingresar con Facebook
										</a>
									</form>
									<hr>
									<div class="text-center">
										<a class="small" href="#">Olvidó contraseña?</a>
									</div>
									<div class="text-center">
										<a class="small" href="#">Crear una cuenta!</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>
	<footer>

		<br>
	</footer>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
		integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
		crossorigin="anonymous"></script>
</body>

</html>