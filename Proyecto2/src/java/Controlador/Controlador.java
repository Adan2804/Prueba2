package Controlador;

import Config.Fecha;
import Modelo.Carrito;
import Modelo.Cliente;
import Modelo.DetalleCompra;
import Modelo.Pedido;
import Modelo.Producto;
import Modelo.Empleado;
import ModeloDAO.CompraDAO;
import ModeloDAO.ProDAO;
import ModeloDAO.ProductoDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    ProDAO proD = new ProDAO();
    ProductoDAO pdao = new ProductoDAO();
    Producto p = new Producto();
    List<Producto> productos = new ArrayList<>();
    List<Carrito> listaCarrito = new ArrayList<>();

    //CompraDAO cdao = new CompraDAO();
    //Cliente cl = new Cliente();
    Fecha fechaSistem = new Fecha();
    //Empleado em = new Empleado();
    //ProDAO pro = new ProDAO();

    int item;
    double totalPagar = 0.0;
    int cantidad = 1;
    int idp;
    Carrito car;

    //double subtotal = 0.0;
    //int idcompra;
    //int idpago;
    //double montopagar;
   // int idProducto = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        productos = proD.listar();
        switch (accion) {

            case "Comprar":

                totalPagar = 0.0;
                idp = Integer.parseInt(request.getParameter("id"));
                p = proD.listarId(idp);
                item = item + 1;
                car = new Carrito();
                car.setItem(item);
                car.setIdProducto(p.getId());
                car.setNombres(p.getNombre());
                car.setDescripcion(p.getTipo());
                car.setPrecioCompra(p.getPrecio());
                car.setCantidad(cantidad);
                car.setSubTotal(cantidad * p.getPrecio());
                //car.setIdempleado(em.getId());
                //car.setIdcliente(cl.getId());
                listaCarrito.add(car);
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar = totalPagar + listaCarrito.get(i).getSubTotal();
                }
                request.setAttribute("totalPagar", totalPagar);
                request.setAttribute("carrito", listaCarrito);
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;

            case "AgregarCarrito":

                int pos = 0;
                cantidad = 1;

                idp = Integer.parseInt(request.getParameter("id"));
                p = proD.listarId(idp);

                if (listaCarrito.size() > 0) {
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        if (idp == listaCarrito.get(i).getIdProducto()) {
                            pos = i;
                        }
                    }
                    if (idp == listaCarrito.get(pos).getIdProducto()) {
                        cantidad = listaCarrito.get(pos).getCantidad() + cantidad;
                        double subtotal = listaCarrito.get(pos).getPrecioCompra() * cantidad;
                        listaCarrito.get(pos).setCantidad(cantidad);
                        listaCarrito.get(pos).setSubTotal(subtotal);
                    } else {
                        item = item + 1;
                        car = new Carrito();
                        car.setItem(item);
                        car.setIdProducto(p.getId());
                        car.setNombres(p.getNombre());
                        car.setDescripcion(p.getTipo());
                        car.setPrecioCompra(p.getPrecio());
                        car.setCantidad(cantidad);
                        car.setSubTotal(cantidad * p.getPrecio());
                        //car.setIdempleado(em.getId());
                        //car.setIdcliente(cl.getId());
                        listaCarrito.add(car);
                    }
                } else {
                    item = item + 1;
                    car = new Carrito();
                    car.setItem(item);
                    car.setIdProducto(p.getId());
                    car.setNombres(p.getNombre());
                    car.setDescripcion(p.getTipo());
                    car.setPrecioCompra(p.getPrecio());
                    car.setCantidad(cantidad);
                    car.setSubTotal(cantidad * p.getPrecio());
                    //car.setIdempleado(em.getId());
                    //car.setIdcliente(cl.getId());

                    listaCarrito.add(car);
                }
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
                break;

            case "Delete":
                int idproducto = Integer.parseInt(request.getParameter("idp"));
                for (int i = 0; i < listaCarrito.size(); i++) {
                    if (listaCarrito.get(i).getIdProducto() == idproducto) {
                        listaCarrito.remove(i);
                    }
                }
                break;

            case "ActualizarCantidad":
                int idpro = Integer.parseInt(request.getParameter("idp"));
                int cant = Integer.parseInt(request.getParameter("Cantidad"));
                for (int i = 0; i < listaCarrito.size(); i++) {
                    if (listaCarrito.get(i).getIdProducto() == idpro) {
                        listaCarrito.get(i).setCantidad(cant);
                        double st = listaCarrito.get(i).getPrecioCompra() * cant;
                        listaCarrito.get(i).setSubTotal(st);
                    }
                }
                break;

            case "Carrito":
                totalPagar = 0.0;
                request.setAttribute("carrito", listaCarrito);
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar = totalPagar + listaCarrito.get(i).getSubTotal();
                }
                request.setAttribute("totalPagar", totalPagar);
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;

            case "Nuevo":
                listaCarrito = new ArrayList<>();
                request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
                break;

            case "GenerarCompra":

                /*int idpago = cdao.IdPago();
                if (cl.getId() != 0 && listaCarrito.size() != 0 && montopagar > 0) {
                    if (totalPagar > 0.0) {
                        Pedido co = new Pedido();

                        co.setMonto(totalPagar);
                        co.setCantidad(listaCarrito);
                        co.setFecha(fechaSistem.FechaBD());
                        co.setEstado("Cancelado - En Proceso de Envio");
                        co.setId(em.getId());
                        co.setIdpago(idpago);
                        co.setId(cl.getId());

                        montopagar = 0;

                        idcompra = cdao.IdCompra();
                        for (int i = 0; i < listaCarrito.size(); i++) {
                            DetalleCompra dc = new DetalleCompra();
                            dc.setTotal_precio_r(totalPagar);
                            dc.setPrecio_r(subtotal);
                            dc.setPedido_id_p(idp);
                            dc.setProducto_id_pr(listaCarrito.get(i).getIdProducto());
                            dc.setPedido_empleado_id_em(listaCarrito.get(i).getIdempleado());
                            dc.setPedido_cliente_id_c(listaCarrito.get(i).getIdcliente());

                            cdao.guardarCompra(co);
                        }
                        listaCarrito = new ArrayList<>();
                        /*List compra = cdao.misCompras(cl.getId());
                        request.setAttribute("myCompras", compra);*/
                //request.getRequestDispatcher("vistas/mensaje.jsp").forward(request, response);
                /*} else {
                        request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
                    }
                } else {
                    request.getRequestDispatcher("Controlador?accion=carrito").forward(request, response);
                }*/
                Cliente cliente = new Cliente();
                Empleado empleado = new Empleado();
                empleado.setId(1);
                cliente.setId(1);
                CompraDAO dao = new CompraDAO();
                //Pedido m = new Pedido(cliente, idpago, accion, montopagar, accion, listaCarrito, empleado)
                //Pedido compra = new Pedido(cliente, 1, Fecha.FechaBD(), totalPagar, "Cancelado", listaCarrito, empleado);
                Pedido compra = new Pedido(cliente, 1, Fecha.FechaBD(), totalPagar, "Cancelado", empleado, listaCarrito);
                int res = dao.GenerarCompra(compra);
                if (res!=0&&totalPagar>0) {
                    request.getRequestDispatcher("vistas/mensaje.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("vistas/error.jsp").forward(request, response);
                }

                break;
            case "Buscar":
                String nombre = request.getParameter("txtbuscar");
                productos = proD.buscar(nombre);
                request.setAttribute("cont", listaCarrito.size());
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("Comprar.jsp").forward(request, response);
                break;

            default:
                request.setAttribute("cont", listaCarrito.size());
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("Comprar.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
