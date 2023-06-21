package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.domain.Producto;
import co.edu.usbcali.tiendaapp.exception.CategoriaException;
import co.edu.usbcali.tiendaapp.exception.ProductoException;
import co.edu.usbcali.tiendaapp.request.ActualizaProductoRequest;
import co.edu.usbcali.tiendaapp.request.GuardaProductoRequest;
import co.edu.usbcali.tiendaapp.response.ProductoResponse;

import java.util.List;

public interface ProductoService {

    List<ProductoResponse> obtenerTodos();

    ProductoResponse buscarPorId(Integer id) throws ProductoException;

    Producto buscarProductoPorId(Integer id) throws ProductoException;

    ProductoResponse guardar(GuardaProductoRequest guardaProductoRequest)
            throws CategoriaException, ProductoException;

    ProductoResponse actualizar(ActualizaProductoRequest actualizaProductoRequest)
            throws CategoriaException, ProductoException;
}
