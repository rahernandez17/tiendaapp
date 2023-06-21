package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.domain.Cliente;
import co.edu.usbcali.tiendaapp.exception.ClienteException;
import co.edu.usbcali.tiendaapp.exception.TipoDocumentoException;
import co.edu.usbcali.tiendaapp.request.ActualizaClienteRequest;
import co.edu.usbcali.tiendaapp.request.BuscaClienteTipoNumeroDocumentoRequest;
import co.edu.usbcali.tiendaapp.request.GuardaClienteRequest;
import co.edu.usbcali.tiendaapp.response.ClienteResponse;

import java.util.List;

public interface ClienteService {

    List<ClienteResponse> obtenerTodos();

    ClienteResponse buscarPorId(Integer id) throws ClienteException;

    Cliente buscarClientePorId(Integer id) throws ClienteException;

    ClienteResponse buscarPorTipoNumeroDocumento(
            BuscaClienteTipoNumeroDocumentoRequest buscaClienteTipoNumeroDocumentoRequest
    ) throws ClienteException;

    ClienteResponse guardar(GuardaClienteRequest guardaClienteRequest)
            throws ClienteException, TipoDocumentoException;

    ClienteResponse actualizar(ActualizaClienteRequest actualizaClienteRequest)
            throws ClienteException, TipoDocumentoException;
}
