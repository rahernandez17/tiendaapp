package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.dto.DetallePedidoDTO;

import java.util.List;

public interface DetallePedidoService {

    List<DetallePedidoDTO> obtenerTodos();

    DetallePedidoDTO buscarPorId(Integer id);

    DetallePedidoDTO guardar(DetallePedidoDTO detallePedidoDTO);

    DetallePedidoDTO actualizar(DetallePedidoDTO detallePedidoDTO);
}
