package co.edu.usbcali.tiendaapp.service.impl;

import co.edu.usbcali.tiendaapp.domain.Producto;
import co.edu.usbcali.tiendaapp.dto.ProductoDTO;
import co.edu.usbcali.tiendaapp.exception.CategoriaException;
import co.edu.usbcali.tiendaapp.exception.ProductoException;
import co.edu.usbcali.tiendaapp.mapper.ProductoMapper;
import co.edu.usbcali.tiendaapp.repository.ProductoRepository;
import co.edu.usbcali.tiendaapp.service.CategoriaService;
import co.edu.usbcali.tiendaapp.service.ProductoService;
import co.edu.usbcali.tiendaapp.utility.ValidacionUtility;
import co.edu.usbcali.tiendaapp.utility.message.ProductoServiceMessage;
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
    public List<ProductoDTO> obtenerTodos() {
        return productoMapper.domainToDtoList(productoRepository.findAll());
    }

    @Override
    public ProductoDTO buscarPorId(Integer id) throws ProductoException {
        ValidacionUtility.integerIsNullOrLessZero(id,
                new ProductoException(ProductoServiceMessage.ID_NO_VALIDO_MSG));

        return productoRepository
                .findById(id)
                .map(productoMapper::domainToDto)
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
    public ProductoDTO guardar(ProductoDTO productoDTO) throws CategoriaException, ProductoException {
        validarProducto(productoDTO, false);

        Producto producto = productoMapper.dtoToDomain(productoDTO);
        producto.setCategoria(categoriaService.buscarCategoriaPorId(productoDTO.getCategoriaId()));

        return productoMapper.domainToDto(productoRepository.save(producto));
    }

    @Override
    public ProductoDTO actualizar(ProductoDTO productoDTO) throws CategoriaException, ProductoException {
        validarProducto(productoDTO, true);

        Producto producto = productoMapper.dtoToDomain(productoDTO);
        producto.setCategoria(categoriaService.buscarCategoriaPorId(productoDTO.getCategoriaId()));

        return productoMapper.domainToDto(productoRepository.save(producto));
    }

    private void validarProducto(ProductoDTO productoDTO, Boolean esActualizar) throws ProductoException {
        if (Boolean.TRUE.equals(esActualizar)){
            ValidacionUtility.integerIsNullOrLessZero(productoDTO.getId(),
                    new ProductoException(ProductoServiceMessage.ID_NO_VALIDO_MSG));
        }

        ValidacionUtility.isNull(productoDTO,
                new ProductoException(ProductoServiceMessage.PRODUCTO_NULO));
        ValidacionUtility.stringIsNullOrBlank(productoDTO.getReferencia(),
                new ProductoException(ProductoServiceMessage.REFERENCIA_REQUERIDA));
        ValidacionUtility.stringIsNullOrBlank(productoDTO.getNombre(),
                new ProductoException(ProductoServiceMessage.NOMBRE_REQUERIDO));
        ValidacionUtility.stringIsNullOrBlank(productoDTO.getDescripcion(),
                new ProductoException(ProductoServiceMessage.DESCRIPCION_REQUERIDA));
        ValidacionUtility.bigDecimalIsNullOrLessZero(productoDTO.getPrecioUnitario(),
                new ProductoException(ProductoServiceMessage.PRECIO_UNITARIO_REQUERIDO));
        ValidacionUtility.bigDecimalIsNullOrLessZero(productoDTO.getUnidadesDisponibles(),
                new ProductoException(ProductoServiceMessage.UNIDADES_DISPONIBLES_REQUERIDO));
        ValidacionUtility.integerIsNullOrLessZero(productoDTO.getCategoriaId(),
                new ProductoException(ProductoServiceMessage.CATEGORIA_ID_REQUERIDO));
    }
}
