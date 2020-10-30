
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Compra"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.ComprarDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra de inventario</title>
    </head>
    <body>
        <div class="container-fluid">
            <h1>Compra de inventario</h1>
            <div class="row">
                <div class="col-6"><input class="form-control mr-sm-2" type="search" placeholder="Nombre" aria-label="Search"></div>
                <div class="col-3"><button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button></div>
                <div class="col-3"><a class="btn btn-success" href="ControladorCompra?accion=add">Agregar Nuevo</a></div>
            </div>
            <div class="row">
                <div class="col">

                    <br>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th class="text-center">PROVEEDOR</th>
                                <th class="text-center">FECHA</th>
                                <th class="text-center">COSTO TOTAL</th>
                                <th class="text-center">STOCK TOTAL</th>
                                <th class="text-center">ACCIONES</th>
                            </tr>
                        </thead>
                        <%
                            ComprarDAO dao = new ComprarDAO();
                            List<Compra> list = dao.listar();
                            Iterator<Compra> iter = list.iterator();
                            Compra pro = null;
                            while (iter.hasNext()) {
                                pro = iter.next();
                        %>
                        <tbody>
                            <tr>
                                <td class="text-center"><%= pro.getProveedor()%></td>
                                <td class="text-center"><%= pro.getFecha().substring(0,11)%></td>
                                <td class="text-center"><%= pro.getCostototal()%></td>
                                <td class="text-center"><%= pro.getCantidadtotal()%></td>
                                <td class="text-center">
                                    <a class="btn btn-warning" href="ControladorCompra?accion=editar&id=<%= pro.getIdcompra()%>">Editar</a>
                                    <a class="btn btn-danger" href="ControladorCompra?accion=eliminar&id=<%= pro.getIdcompra()%>">Remove</a>
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>

            </div>

        </div>
</html>
