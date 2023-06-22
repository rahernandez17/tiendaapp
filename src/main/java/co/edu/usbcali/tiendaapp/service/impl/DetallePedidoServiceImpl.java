package co.edu.usbcali.tiendaapp.service.impl;

import co.edu.usbcali.tiendaapp.domain.DetallePedido;
import co.edu.usbcali.tiendaapp.exception.DetallePedidoException;
import co.edu.usbcali.tiendaapp.exception.PedidoException;
import co.edu.usbcali.tiendaapp.exception.ProductoException;
import co.edu.usbcali.tiendaapp.mapper.DetallePedidoMapper;
import co.edu.usbcali.tiendaapp.repository.DetallePedidoRepository;
import co.edu.usbcali.tiendaapp.request.ActualizaDetallePedidoRequest;
import co.edu.usbcali.tiendaapp.request.GuardaDetallePedidoRequest;
import co.edu.usbcali.tiendaapp.response.DetallePedidoResponse;
import co.edu.usbcali.tiendaapp.service.DetallePedidoService;
import co.edu.usbcali.tiendaapp.service.PedidoService;
import co.edu.usbcali.tiendaapp.service.ProductoService;
import co.edu.usbcali.tiendaapp.utility.ValidacionUtility;
import co.edu.usbcali.tiendaapp.utility.message.DetallePedidoServiceMessage;
import jakarta.validation.constraints.NotNull;
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
    public List<DetallePedidoResponse> obtenerTodos() {
        return detallePedidoMapper.domainToResponseList(detallePedidoRepository.findAll());
    }

    @Override
    public DetallePedidoResponse buscarPorId(Integer id) throws DetallePedidoException {
        ValidacionUtility.integerIsNullOrLessZero(id,
                new DetallePedidoException(DetallePedidoServiceMessage.ID_NO_VALIDO_MSG));

        return detallePedidoRepository
                .findById(id)
                .map(detallePedidoMapper::domainToResponse)
                .orElseThrow(() -> new DetallePedidoException(String
                        .format(DetallePedidoServiceMessage.DETALLE_PEDIDO_NO_ENCONTRADA_POR_ID, id))
                );
    }

    @Override
    public DetallePedidoResponse guardar(
            @NotNull(message = DetallePedidoServiceMessage.DETALLE_PEDIDO_NULO)
            GuardaDetallePedidoRequest guardaDetallePedidoRequest
    ) throws PedidoException, ProductoException, DetallePedidoException {
        DetallePedido detallePedido = detallePedidoMapper.requestGuardarToDomain(guardaDetallePedidoRequest);
        detallePedido.setPedido(pedidoService.buscarPedidoPorId(guardaDetallePedidoRequest.getPedidoId()));
        detallePedido.setProducto(productoService.buscarProductoPorId(guardaDetallePedidoRequest.getProductoId()));

        return detallePedidoMapper.domainToResponse(detallePedidoRepository.save(detallePedido));
    }

    @Override
    public DetallePedidoResponse actualizar(
            @NotNull(message = DetallePedidoServiceMessage.DETALLE_PEDIDO_NULO)
            ActualizaDetallePedidoRequest actualizaDetallePedidoRequest
    ) throws PedidoException, ProductoException, DetallePedidoException {
        if (!detallePedidoRepository.existsById(actualizaDetallePedidoRequest.getId())) {
            throw new DetallePedidoException(String
                    .format(DetallePedidoServiceMessage.DETALLE_PEDIDO_NO_ENCONTRADA_POR_ID,
                            actualizaDetallePedidoRequest.getId()));
        }

        DetallePedido detallePedido = detallePedidoMapper.requestActualizarToDomain(actualizaDetallePedidoRequest);
        detallePedido.setPedido(pedidoService.buscarPedidoPorId(actualizaDetallePedidoRequest.getPedidoId()));
        detallePedido.setProducto(productoService.buscarProductoPorId(actualizaDetallePedidoRequest.getProductoId()));

        return detallePedidoMapper.domainToResponse(detallePedidoRepository.save(detallePedido));
    }
}
