package co.edu.usbcali.tiendaapp.service.impl;

import co.edu.usbcali.tiendaapp.domain.Producto;
import co.edu.usbcali.tiendaapp.exception.CategoriaException;
import co.edu.usbcali.tiendaapp.exception.ProductoException;
import co.edu.usbcali.tiendaapp.mapper.ProductoMapper;
import co.edu.usbcali.tiendaapp.repository.ProductoRepository;
import co.edu.usbcali.tiendaapp.request.ActualizaProductoRequest;
import co.edu.usbcali.tiendaapp.request.GuardaProductoRequest;
import co.edu.usbcali.tiendaapp.response.ProductoResponse;
import co.edu.usbcali.tiendaapp.service.CategoriaService;
import co.edu.usbcali.tiendaapp.service.ProductoService;
import co.edu.usbcali.tiendaapp.utility.ValidacionUtility;
import co.edu.usbcali.tiendaapp.utility.message.ProductoServiceMessage;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    private final ProductoMapper productoMapper;

    private final CategoriaService categoriaService;

    public ProductoServiceImpl(ProductoRepository productoRepository,
                               ProductoMapper productoMapper,
                               CategoriaService categoriaService) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
        this.categoriaService = categoriaService;
    }

    @Override
    public List<ProductoResponse> obtenerTodos() {
        return productoMapper.domainToResponseList(productoRepository.findAll());
    }

    @Override
    public ProductoResponse buscarPorId(Integer id) throws ProductoException {
        ValidacionUtility.integerIsNullOrLessZero(id,
                new ProductoException(ProductoServiceMessage.ID_NO_VALIDO_MSG));

        return productoRepository
                .findById(id)
                .map(productoMapper::domainToResponse)
                .orElseThrow(() -> new ProductoException(String
                        .format(ProductoServiceMessage.PRODUCTO_NO_ENCONTRADA_POR_ID, id))
                );
    }

    @Override
    public Producto buscarProductoPorId(Integer id) throws ProductoException {
        ValidacionUtility.integerIsNullOrLessZero(id,
                new ProductoException(ProductoServiceMessage.ID_NO_VALIDO_MSG));

        return productoRepository
                .findById(id)
                .orElseThrow(() -> new ProductoException(String
                        .format(ProductoServiceMessage.PRODUCTO_NO_ENCONTRADA_POR_ID, id))
                );
    }

    @Override
    public ProductoResponse guardar(
            @NotNull(message = ProductoServiceMessage.PRODUCTO_NULO)
            GuardaProductoRequest guardaProductoRequest
    ) throws CategoriaException, ProductoException {
        Producto producto = productoMapper.requestGuardarToDomain(guardaProductoRequest);

        producto.setCategoria(categoriaService.buscarCategoriaPorId(guardaProductoRequest.getCategoriaId()));

        return productoMapper.domainToResponse(productoRepository.save(producto));
    }

    @Override
    public ProductoResponse actualizar(
            @NotNull(message = ProductoServiceMessage.PRODUCTO_NULO)
            ActualizaProductoRequest actualizaProductoRequest
    ) throws CategoriaException, ProductoException {
        if (!productoRepository.existsById(actualizaProductoRequest.getId())) {
            throw new ProductoException(String
                    .format(ProductoServiceMessage.PRODUCTO_NO_ENCONTRADA_POR_ID, actualizaProductoRequest.getId()));
        }

        Producto producto = productoMapper.requestActualizarToDomain(actualizaProductoRequest);
        producto.setCategoria(categoriaService.buscarCategoriaPorId(actualizaProductoRequest.getCategoriaId()));

        return productoMapper.domainToResponse(productoRepository.save(producto));
    }
}
