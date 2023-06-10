package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.dto.ProductoDTO;

import java.util.List;

public interface ProductoService {

    List<ProductoDTO> obtenerTodos();

    ProductoDTO buscarPorId(Integer id);

    ProductoDTO guardar(ProductoDTO productoDTO);

    ProductoDTO actualizar(ProductoDTO productoDTO);
}
