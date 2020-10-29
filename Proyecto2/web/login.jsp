<jsp:useBean id="msj" scope="request" class="java.lang.String"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>VALIDACIÓN DE USUARIO</h1>
        <form action="scontrolador">
            <input type="hidden" name="opcion" value="13">
            usuario: <input type="text" name="txtusuario">
            <br>
            clave: <input type="text" name="txtclave">
            <br>
            <input type="submit" value="Validar">
        </form>
        <%
            if(msj!=null)
                out.print(msj);
        %>
    </body>
</html>
