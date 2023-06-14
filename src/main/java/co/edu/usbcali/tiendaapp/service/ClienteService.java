package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.domain.Cliente;
import co.edu.usbcali.tiendaapp.dto.ClienteDTO;
import co.edu.usbcali.tiendaapp.exception.ClienteException;
import co.edu.usbcali.tiendaapp.exception.TipoDocumentoException;

import java.util.List;

public interface ClienteService {

    List<ClienteDTO> obtenerTodos();

    ClienteDTO buscarPorId(Integer id) throws ClienteException;

    Cliente buscarClientePorId(Integer id) throws ClienteException;

    ClienteDTO guardar(ClienteDTO clienteDTO) throws ClienteException, TipoDocumentoException;

    ClienteDTO actualizar(ClienteDTO clienteDTO) throws ClienteException, TipoDocumentoException;
}
