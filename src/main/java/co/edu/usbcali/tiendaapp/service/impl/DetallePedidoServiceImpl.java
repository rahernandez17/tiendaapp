package co.edu.usbcali.tiendaapp.service.impl;

import co.edu.usbcali.tiendaapp.domain.DetallePedido;
import co.edu.usbcali.tiendaapp.dto.DetallePedidoDTO;
import co.edu.usbcali.tiendaapp.exception.DetallePedidoException;
import co.edu.usbcali.tiendaapp.exception.PedidoException;
import co.edu.usbcali.tiendaapp.exception.ProductoException;
import co.edu.usbcali.tiendaapp.mapper.DetallePedidoMapper;
import co.edu.usbcali.tiendaapp.repository.DetallePedidoRepository;
import co.edu.usbcali.tiendaapp.service.DetallePedidoService;
import co.edu.usbcali.tiendaapp.service.PedidoService;
import co.edu.usbcali.tiendaapp.service.ProductoService;
import co.edu.usbcali.tiendaapp.utility.ValidacionUtility;
import co.edu.usbcali.tiendaapp.utility.message.DetallePedidoServiceMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

    private final DetallePedidoRepository detallePedidoRepository;

    private final DetallePedidoMapper detallePedidoMapper;

    private final PedidoService pedidoService;

    private final ProductoService productoService;

    public DetallePedidoServiceImpl(DetallePedidoRepository detallePedidoRepository,
                                    DetallePedidoMapper detallePedidoMapper,
                                    PedidoService pedidoService,
                                    ProductoService productoService) {
        this.detallePedidoRepository = detallePedidoRepository;
        this.detallePedidoMapper = detallePedidoMapper;
        this.pedidoService = pedidoService;
        this.productoService = productoService;
    }

    @Override
    public List<DetallePedidoDTO> obtenerTodos() {
        return detallePedidoMapper.domainToDtoList(detallePedidoRepository.findAll());
    }

    @Override
    public DetallePedidoDTO buscarPorId(Integer id) throws DetallePedidoException {
        ValidacionUtility.integerIsNullOrLessZero(id,
                new DetallePedidoException(DetallePedidoServiceMessage.ID_NO_VALIDO_MSG));

        return detallePedidoRepository
                .findById(id)
                .map(detallePedidoMapper::domainToDto)
                .orElseThrow(() -> new DetallePedidoException(String
                        .format(DetallePedidoServiceMessage.DETALLE_PEDIDO_NO_ENCONTRADA_POR_ID, id))
                );
    }

    @Override
    public DetallePedidoDTO guardar(DetallePedidoDTO detallePedidoDTO)
            throws PedidoException, ProductoException, DetallePedidoException {
        validarDetallePedido(detallePedidoDTO, false);

        DetallePedido detallePedido = detallePedidoMapper.dtoToDomain(detallePedidoDTO);
        detallePedido.setPedido(pedidoService.buscarPedidoPorId(detallePedidoDTO.getPedidoId()));
        detallePedido.setProducto(productoService.buscarProductoPorId(detallePedidoDTO.getProductoId()));

        return detallePedidoMapper.domainToDto(detallePedidoRepository.save(detallePedido));
    }

    @Override
    public DetallePedidoDTO actualizar(DetallePedidoDTO detallePedidoDTO)
            throws PedidoException, ProductoException, DetallePedidoException {
        validarDetallePedido(detallePedidoDTO, true);

        DetallePedido detallePedido = detallePedidoMapper.dtoToDomain(detallePedidoDTO);
        detallePedido.setPedido(pedidoService.buscarPedidoPorId(detallePedidoDTO.getPedidoId()));
        detallePedido.setProducto(productoService.buscarProductoPorId(detallePedidoDTO.getProductoId()));

        return detallePedidoMapper.domainToDto(detallePedidoRepository.save(detallePedido));
    }

    private void validarDetallePedido(DetallePedidoDTO detallePedidoDTO, Boolean esActualizar)
            throws DetallePedidoException {
        if (Boolean.TRUE.equals(esActualizar)){
            ValidacionUtility.integerIsNullOrLessZero(detallePedidoDTO.getId(),
                    new DetallePedidoException(DetallePedidoServiceMessage.ID_NO_VALIDO_MSG));
        }

        ValidacionUtility.isNull(detallePedidoDTO,
                new DetallePedidoException(DetallePedidoServiceMessage.DETALLE_PEDIDO_NULO));
        ValidacionUtility.bigDecimalIsNullOrLessZero(detallePedidoDTO.getCantidad(),
                new DetallePedidoException(DetallePedidoServiceMessage.CANTIDAD_REQUERIDA));
        ValidacionUtility.bigDecimalIsNullOrLessZero(detallePedidoDTO.getValor(),
                new DetallePedidoException(DetallePedidoServiceMessage.VALOR_REQUERIDO));
        ValidacionUtility.integerIsNullOrLessZero(detallePedidoDTO.getPedidoId(),
                new DetallePedidoException(DetallePedidoServiceMessage.PEDIDO_ID_REQUERIDO));
        ValidacionUtility.integerIsNullOrLessZero(detallePedidoDTO.getProductoId(),
                new DetallePedidoException(DetallePedidoServiceMessage.PRODUCTO_ID_REQUERIDO));
    }
}
