package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.domain.EstadoPedido;
import co.edu.usbcali.tiendaapp.exception.EstadoPedidoException;
import co.edu.usbcali.tiendaapp.response.EstadoPedidoResponse;

import java.util.List;

public interface EstadoPedidoService {

    List<EstadoPedidoResponse> obtenerTodos();

    EstadoPedidoResponse buscarPorId(Integer id) throws EstadoPedidoException;

    EstadoPedido buscarEstadoPedidoPorId(Integer id) throws EstadoPedidoException;
}
