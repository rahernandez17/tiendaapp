package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.dto.TipoDocumentoDTO;

import java.util.List;

public interface TipoDocumentoService {

    List<TipoDocumentoDTO> obtenerTodos();

    TipoDocumentoDTO buscarPorId(Integer id);
}
