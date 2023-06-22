package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.exception.DetallePedidoException;
import co.edu.usbcali.tiendaapp.exception.PedidoException;
import co.edu.usbcali.tiendaapp.exception.ProductoException;
import co.edu.usbcali.tiendaapp.request.ActualizaDetallePedidoRequest;
import co.edu.usbcali.tiendaapp.request.GuardaDetallePedidoRequest;
import co.edu.usbcali.tiendaapp.response.DetallePedidoResponse;

import java.util.List;

public interface DetallePedidoService {

    List<DetallePedidoResponse> obtenerTodos();

    DetallePedidoResponse buscarPorId(Integer id) throws DetallePedidoException;

    DetallePedidoResponse guardar(GuardaDetallePedidoRequest guardaDetallePedidoRequest)
            throws PedidoException, ProductoException, DetallePedidoException;

    DetallePedidoResponse actualizar(ActualizaDetallePedidoRequest actualizaDetallePedidoRequest)
            throws PedidoException, ProductoException, DetallePedidoException;
}
