package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.dto.CategoriaDTO;

import java.util.List;

public interface CategoriaService {

    List<CategoriaDTO> obtenerTodos();

    CategoriaDTO buscarPorId(Integer id);

    CategoriaDTO guardar(CategoriaDTO categoriaDTO);

    CategoriaDTO actualizar(CategoriaDTO categoriaDTO);
}
