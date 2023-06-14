package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.domain.Producto;
import co.edu.usbcali.tiendaapp.dto.ProductoDTO;
import co.edu.usbcali.tiendaapp.exception.CategoriaException;
import co.edu.usbcali.tiendaapp.exception.ProductoException;

import java.util.List;

public interface ProductoService {

    List<ProductoDTO> obtenerTodos();

    ProductoDTO buscarPorId(Integer id) throws ProductoException;

    Producto buscarProductoPorId(Integer id) throws ProductoException;

    ProductoDTO guardar(ProductoDTO productoDTO) throws CategoriaException, ProductoException;

    ProductoDTO actualizar(ProductoDTO productoDTO) throws CategoriaException, ProductoException;
}
