package co.edu.usbcali.tiendaapp.service.impl;

import co.edu.usbcali.tiendaapp.domain.Cliente;
import co.edu.usbcali.tiendaapp.exception.ClienteException;
import co.edu.usbcali.tiendaapp.exception.TipoDocumentoException;
import co.edu.usbcali.tiendaapp.mapper.ClienteMapper;
import co.edu.usbcali.tiendaapp.repository.ClienteRepository;
import co.edu.usbcali.tiendaapp.request.ActualizaClienteRequest;
import co.edu.usbcali.tiendaapp.request.BuscaClienteTipoNumeroDocumentoRequest;
import co.edu.usbcali.tiendaapp.request.GuardaClienteRequest;
import co.edu.usbcali.tiendaapp.response.ClienteResponse;
import co.edu.usbcali.tiendaapp.service.ClienteService;
import co.edu.usbcali.tiendaapp.service.TipoDocumentoService;
import co.edu.usbcali.tiendaapp.utility.message.ClienteServiceMessage;
import co.edu.usbcali.tiendaapp.utility.ValidacionUtility;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper;

    private final TipoDocumentoService tipoDocumentoService;

    public ClienteServiceImpl(ClienteRepository clienteRepository,
                              ClienteMapper clienteMapper,
                              TipoDocumentoService tipoDocumentoService) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @Override
    public List<ClienteResponse> obtenerTodos() {
        return clienteMapper.domainToResponseList(clienteRepository.findAll());
    }

    @Override
    public ClienteResponse buscarPorId(Integer id) throws ClienteException {
        ValidacionUtility.integerIsNullOrLessZero(id, new ClienteException(ClienteServiceMessage.ID_NO_VALIDO_MSG));

        return clienteRepository
                .findById(id)
                .map(clienteMapper::domainToResponse)
                .orElseThrow(() -> new ClienteException(String
                        .format(ClienteServiceMessage.CLIENTE_NO_ENCONTRADO_POR_ID, id))
                );
    }

    @Override
    public Cliente buscarClientePorId(Integer id) throws ClienteException {
        ValidacionUtility.integerIsNullOrLessZero(id, new ClienteException(ClienteServiceMessage.ID_NO_VALIDO_MSG));

        return clienteRepository
                .findById(id)
                .orElseThrow(() -> new ClienteException(String
                        .format(ClienteServiceMessage.CLIENTE_NO_ENCONTRADO_POR_ID, id))
                );
    }

    @Override
    public ClienteResponse buscarPorTipoNumeroDocumento(
            @NotNull(message = ClienteServiceMessage.CLIENTE_NULO)
            BuscaClienteTipoNumeroDocumentoRequest buscaClienteTipoNumeroDocumentoRequest
    ) throws ClienteException {
        return clienteRepository
                .findByTipoDocumentoIdAndDocumento(
                        buscaClienteTipoNumeroDocumentoRequest.getTipoDocumentoId(),
                        buscaClienteTipoNumeroDocumentoRequest.getDocumento()
                )
                .map(clienteMapper::domainToResponse)
                .orElseThrow(() -> new ClienteException(String
                        .format(ClienteServiceMessage.CLIENTE_NO_ENCONTRADO_POR_TIPO_NUMERO_DOCUMENTO,
                                buscaClienteTipoNumeroDocumentoRequest.getDocumento()))
                );
    }

    @Override
    public ClienteResponse guardar(
            @NotNull(message = ClienteServiceMessage.CLIENTE_NULO)
            GuardaClienteRequest guardaClienteRequest
    ) throws ClienteException, TipoDocumentoException {
        Cliente cliente = clienteMapper.requestGuardarToDomain(guardaClienteRequest);
        cliente.setTipoDocumento(tipoDocumentoService
                .buscarTipoDocumentoPorId(guardaClienteRequest.getTipoDocumentoId()));

        return clienteMapper.domainToResponse(clienteRepository.save(cliente));
    }

    @Override
    public ClienteResponse actualizar(
            @NotNull(message = ClienteServiceMessage.CLIENTE_NULO)
            ActualizaClienteRequest actualizaClienteRequest
    ) throws ClienteException, TipoDocumentoException {
        if (!clienteRepository.existsById(actualizaClienteRequest.getId())) {
            throw new ClienteException(String
                    .format(ClienteServiceMessage.CLIENTE_NO_ENCONTRADO_POR_ID, actualizaClienteRequest.getId()));
        }

        Cliente cliente = clienteMapper.requestActualizarToDomain(actualizaClienteRequest);
        cliente.setTipoDocumento(tipoDocumentoService
                .buscarTipoDocumentoPorId(actualizaClienteRequest.getTipoDocumentoId()));

        return clienteMapper.domainToResponse(clienteRepository.save(cliente));
    }
}
