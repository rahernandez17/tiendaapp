package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.domain.Pedido;
import co.edu.usbcali.tiendaapp.exception.ClienteException;
import co.edu.usbcali.tiendaapp.exception.EstadoPedidoException;
import co.edu.usbcali.tiendaapp.exception.PedidoException;
import co.edu.usbcali.tiendaapp.request.ActualizaPedidoRequest;
import co.edu.usbcali.tiendaapp.request.GuardaPedidoRequest;
import co.edu.usbcali.tiendaapp.response.PedidoResponse;

import java.util.List;

public interface PedidoService {

    List<PedidoResponse> obtenerTodos();

    PedidoResponse buscarPorId(Integer id) throws PedidoException;

    Pedido buscarPedidoPorId(Integer id) throws PedidoException;

    PedidoResponse guardar(GuardaPedidoRequest guardaPedidoRequest)
            throws PedidoException, ClienteException, EstadoPedidoException;

    PedidoResponse actualizar(ActualizaPedidoRequest actualizaPedidoRequest)
            throws PedidoException, ClienteException, EstadoPedidoException;
}
