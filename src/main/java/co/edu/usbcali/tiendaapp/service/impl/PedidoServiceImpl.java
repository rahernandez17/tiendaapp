package co.edu.usbcali.tiendaapp.service.impl;

import co.edu.usbcali.tiendaapp.domain.Pedido;
import co.edu.usbcali.tiendaapp.dto.PedidoDTO;
import co.edu.usbcali.tiendaapp.exception.ClienteException;
import co.edu.usbcali.tiendaapp.exception.EstadoPedidoException;
import co.edu.usbcali.tiendaapp.exception.PedidoException;
import co.edu.usbcali.tiendaapp.mapper.PedidoMapper;
import co.edu.usbcali.tiendaapp.repository.PedidoRepository;
import co.edu.usbcali.tiendaapp.service.ClienteService;
import co.edu.usbcali.tiendaapp.service.EstadoPedidoService;
import co.edu.usbcali.tiendaapp.service.PedidoService;
import co.edu.usbcali.tiendaapp.utility.ValidacionUtility;
import co.edu.usbcali.tiendaapp.utility.message.PedidoServiceMessage;
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
    public List<PedidoDTO> obtenerTodos() {
        return pedidoMapper.domainToDtoList(pedidoRepository.findAll());
    }

    @Override
    public PedidoDTO buscarPorId(Integer id) throws PedidoException {
        ValidacionUtility.integerIsNullOrLessZero(id, new PedidoException(PedidoServiceMessage.ID_NO_VALIDO_MSG));

        return pedidoRepository
                .findById(id)
                .map(pedidoMapper::domainToDto)
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
    public PedidoDTO guardar(PedidoDTO pedidoDTO) throws ClienteException, EstadoPedidoException, PedidoException {
        validarPedido(pedidoDTO, false);

        Pedido pedido = pedidoMapper.dtoToDomain(pedidoDTO);
        pedido.setCliente(clienteService.buscarClientePorId(pedidoDTO.getClienteId()));
        pedido.setEstadoPedido(estadoPedidoService.buscarEstadoPedidoPorId(pedidoDTO.getEstadoPedidoId()));

        return pedidoMapper.domainToDto(pedidoRepository.save(pedido));
    }

    @Override
    public PedidoDTO actualizar(PedidoDTO pedidoDTO) throws ClienteException, EstadoPedidoException, PedidoException {
        validarPedido(pedidoDTO, true);

        Pedido pedido = pedidoMapper.dtoToDomain(pedidoDTO);
        pedido.setCliente(clienteService.buscarClientePorId(pedidoDTO.getClienteId()));
        pedido.setEstadoPedido(estadoPedidoService.buscarEstadoPedidoPorId(pedidoDTO.getEstadoPedidoId()));

        return pedidoMapper.domainToDto(pedidoRepository.save(pedido));
    }

    private void validarPedido(PedidoDTO pedidoDTO, Boolean esActualizar) throws PedidoException {
        if (Boolean.TRUE.equals(esActualizar)){
            ValidacionUtility.isNull(pedidoDTO.getId(),
                    new PedidoException(PedidoServiceMessage.ID_REQUERIDO));
        }

        ValidacionUtility.isNull(pedidoDTO,
                new PedidoException(PedidoServiceMessage.PEDIDO_NULO));
        ValidacionUtility.isNull(pedidoDTO.getFecha(),
                new PedidoException(PedidoServiceMessage.FECHA_REQUERIDA));
        ValidacionUtility.bigDecimalIsNullOrLessZero(pedidoDTO.getTotal(),
                new PedidoException(PedidoServiceMessage.TOTAL_REQUERIDO));
        ValidacionUtility.integerIsNullOrLessZero(pedidoDTO.getClienteId(),
                new PedidoException(PedidoServiceMessage.CLIENTE_ID_REQUERIDO));
        ValidacionUtility.integerIsNullOrLessZero(pedidoDTO.getEstadoPedidoId(),
                new PedidoException(PedidoServiceMessage.ESTADO_PEDIDO_ID_REQUERIDO));
    }
}
