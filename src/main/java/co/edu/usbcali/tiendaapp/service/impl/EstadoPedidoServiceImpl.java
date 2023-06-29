package co.edu.usbcali.tiendaapp.service.impl;

import co.edu.usbcali.tiendaapp.domain.EstadoPedido;
import co.edu.usbcali.tiendaapp.exception.EstadoPedidoException;
import co.edu.usbcali.tiendaapp.mapper.EstadoPedidoMapper;
import co.edu.usbcali.tiendaapp.repository.EstadoPedidoRepository;
import co.edu.usbcali.tiendaapp.response.EstadoPedidoResponse;
import co.edu.usbcali.tiendaapp.service.EstadoPedidoService;
import co.edu.usbcali.tiendaapp.utility.ValidacionUtility;
import co.edu.usbcali.tiendaapp.utility.message.EstadoPedidoServiceMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoPedidoServiceImpl implements EstadoPedidoService {

    private final EstadoPedidoRepository estadoPedidoRepository;

    private final EstadoPedidoMapper estadoPedidoMapper;

    public EstadoPedidoServiceImpl(EstadoPedidoRepository estadoPedidoRepository,
                                   EstadoPedidoMapper estadoPedidoMapper) {
        this.estadoPedidoRepository = estadoPedidoRepository;
        this.estadoPedidoMapper = estadoPedidoMapper;
    }

    @Override
    public List<EstadoPedidoResponse> obtenerTodos() {
        return estadoPedidoMapper.domainToResponseList(estadoPedidoRepository.findAll());
    }

    @Override
    public EstadoPedidoResponse buscarPorId(Integer id) throws EstadoPedidoException {
        ValidacionUtility.integerIsNullOrLessZero(id,
                new EstadoPedidoException(EstadoPedidoServiceMessage.ID_NO_VALIDO_MSG));

        return estadoPedidoRepository
                .findById(id)
                .map(estadoPedidoMapper::domainToResponse)
                .orElseThrow(() -> new EstadoPedidoException(String
                        .format(EstadoPedidoServiceMessage.ESTADO_PEDIDO_NO_ENCONTRADA_POR_ID, id))
                );
    }

    @Override
    public EstadoPedido buscarEstadoPedidoPorId(Integer id) throws EstadoPedidoException {
        ValidacionUtility.integerIsNullOrLessZero(id,
                new EstadoPedidoException(EstadoPedidoServiceMessage.ID_NO_VALIDO_MSG));

        return estadoPedidoRepository
                .findById(id)
                .orElseThrow(() -> new EstadoPedidoException(String
                        .format(EstadoPedidoServiceMessage.ESTADO_PEDIDO_NO_ENCONTRADA_POR_ID, id))
                );
    }
}
