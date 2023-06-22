package co.edu.usbcali.tiendaapp.service.impl;

import co.edu.usbcali.tiendaapp.domain.Pedido;
import co.edu.usbcali.tiendaapp.exception.ClienteException;
import co.edu.usbcali.tiendaapp.exception.EstadoPedidoException;
import co.edu.usbcali.tiendaapp.exception.PedidoException;
import co.edu.usbcali.tiendaapp.mapper.PedidoMapper;
import co.edu.usbcali.tiendaapp.repository.PedidoRepository;
import co.edu.usbcali.tiendaapp.request.ActualizaPedidoRequest;
import co.edu.usbcali.tiendaapp.request.GuardaPedidoRequest;
import co.edu.usbcali.tiendaapp.response.PedidoResponse;
import co.edu.usbcali.tiendaapp.service.ClienteService;
import co.edu.usbcali.tiendaapp.service.EstadoPedidoService;
import co.edu.usbcali.tiendaapp.service.PedidoService;
import co.edu.usbcali.tiendaapp.utility.ValidacionUtility;
import co.edu.usbcali.tiendaapp.utility.message.PedidoServiceMessage;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    private final PedidoMapper pedidoMapper;

    private final ClienteService clienteService;

    private final EstadoPedidoService estadoPedidoService;

    public PedidoServiceImpl(
            PedidoRepository pedidoRepository,
            PedidoMapper pedidoMapper,
            ClienteService clienteService,
            EstadoPedidoService estadoPedidoService) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoMapper = pedidoMapper;
        this.clienteService = clienteService;
        this.estadoPedidoService = estadoPedidoService;
    }

    @Override
    public List<PedidoResponse> obtenerTodos() {
        return pedidoMapper.domainToResponseList(pedidoRepository.findAll());
    }

    @Override
    public PedidoResponse buscarPorId(Integer id) throws PedidoException {
        ValidacionUtility.integerIsNullOrLessZero(id, new PedidoException(PedidoServiceMessage.ID_NO_VALIDO_MSG));

        return pedidoRepository
                .findById(id)
                .map(pedidoMapper::domainToResponse)
                .orElseThrow(() -> new PedidoException(String
                        .format(PedidoServiceMessage.PEDIDO_NO_ENCONTRADA_POR_ID, id)));
    }

    @Override
    public Pedido buscarPedidoPorId(Integer id) throws PedidoException {
        ValidacionUtility.integerIsNullOrLessZero(id, new PedidoException(PedidoServiceMessage.ID_NO_VALIDO_MSG));

        return pedidoRepository
                .findById(id)
                .orElseThrow(() -> new PedidoException(String
                        .format(PedidoServiceMessage.PEDIDO_NO_ENCONTRADA_POR_ID, id)));
    }

    @Override
    public PedidoResponse guardar(
            @NotNull(message = PedidoServiceMessage.PEDIDO_NULO)
            GuardaPedidoRequest guardaPedidoRequest
    ) throws ClienteException, EstadoPedidoException, PedidoException {
        Pedido pedido = pedidoMapper.requestGuardarToDomain(guardaPedidoRequest);
        pedido.setCliente(clienteService.buscarClientePorId(guardaPedidoRequest.getClienteId()));
        pedido.setEstadoPedido(estadoPedidoService.buscarEstadoPedidoPorId(guardaPedidoRequest.getEstadoPedidoId()));

        return pedidoMapper.domainToResponse(pedidoRepository.save(pedido));
    }

    @Override
    public PedidoResponse actualizar(
            @NotNull(message = PedidoServiceMessage.PEDIDO_NULO)
            ActualizaPedidoRequest actualizaPedidoRequest
    ) throws ClienteException, EstadoPedidoException, PedidoException {
        if (!pedidoRepository.existsById(actualizaPedidoRequest.getId())) {
            throw new PedidoException(String
                    .format(PedidoServiceMessage.PEDIDO_NO_ENCONTRADA_POR_ID, actualizaPedidoRequest.getId()));
        }

        Pedido pedido = pedidoMapper.requestActualizarToDomain(actualizaPedidoRequest);
        pedido.setCliente(clienteService.buscarClientePorId(actualizaPedidoRequest.getClienteId()));
        pedido.setEstadoPedido(estadoPedidoService.buscarEstadoPedidoPorId(actualizaPedidoRequest.getEstadoPedidoId()));

        return pedidoMapper.domainToResponse(pedidoRepository.save(pedido));
    }
}
