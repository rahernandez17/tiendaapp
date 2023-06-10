package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.dto.PedidoDTO;

import java.util.List;

public interface PedidoService {

    List<PedidoDTO> obtenerTodos();

    PedidoDTO buscarPorId(Integer id);

    PedidoDTO guardar(PedidoDTO pedidoDTO);

    PedidoDTO actualizar(PedidoDTO pedidoDTO);
}
