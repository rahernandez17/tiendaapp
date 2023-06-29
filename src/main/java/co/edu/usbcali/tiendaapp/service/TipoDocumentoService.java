package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.domain.TipoDocumento;
import co.edu.usbcali.tiendaapp.exception.TipoDocumentoException;
import co.edu.usbcali.tiendaapp.response.TipoDocumentoResponse;

import java.util.List;

public interface TipoDocumentoService {

    List<TipoDocumentoResponse> obtenerTodos();

    TipoDocumentoResponse buscarPorId(Integer id) throws TipoDocumentoException;

    TipoDocumento buscarTipoDocumentoPorId(Integer id) throws TipoDocumentoException;
}
