package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.domain.Pedido;
import co.edu.usbcali.tiendaapp.dto.PedidoDTO;
import co.edu.usbcali.tiendaapp.exception.ClienteException;
import co.edu.usbcali.tiendaapp.exception.EstadoPedidoException;
import co.edu.usbcali.tiendaapp.exception.PedidoException;

import java.util.List;

public interface PedidoService {

    List<PedidoDTO> obtenerTodos();

    PedidoDTO buscarPorId(Integer id) throws PedidoException;

    Pedido buscarPedidoPorId(Integer id) throws PedidoException;

    PedidoDTO guardar(PedidoDTO pedidoDTO) throws PedidoException, ClienteException, EstadoPedidoException;

    PedidoDTO actualizar(PedidoDTO pedidoDTO) throws PedidoException, ClienteException, EstadoPedidoException;
}
