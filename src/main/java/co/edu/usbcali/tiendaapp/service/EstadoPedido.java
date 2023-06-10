package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.dto.EstadoPedidoDTO;

import java.util.List;

public interface EstadoPedido {

    List<EstadoPedidoDTO> obtenerTodos();

    EstadoPedidoDTO buscarPorId(Integer id);
}
