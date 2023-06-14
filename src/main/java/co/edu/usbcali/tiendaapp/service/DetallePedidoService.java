package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.dto.DetallePedidoDTO;
import co.edu.usbcali.tiendaapp.exception.DetallePedidoException;
import co.edu.usbcali.tiendaapp.exception.PedidoException;
import co.edu.usbcali.tiendaapp.exception.ProductoException;

import java.util.List;

public interface DetallePedidoService {

    List<DetallePedidoDTO> obtenerTodos();

    DetallePedidoDTO buscarPorId(Integer id) throws DetallePedidoException;

    DetallePedidoDTO guardar(DetallePedidoDTO detallePedidoDTO)
            throws PedidoException, ProductoException, DetallePedidoException;

    DetallePedidoDTO actualizar(DetallePedidoDTO detallePedidoDTO)
            throws PedidoException, ProductoException, DetallePedidoException;
}
