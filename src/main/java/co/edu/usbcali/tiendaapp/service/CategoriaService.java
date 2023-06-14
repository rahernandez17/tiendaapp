package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.domain.Categoria;
import co.edu.usbcali.tiendaapp.dto.CategoriaDTO;
import co.edu.usbcali.tiendaapp.exception.CategoriaException;

import java.util.List;

public interface CategoriaService {

    List<CategoriaDTO> obtenerTodos();

    CategoriaDTO buscarPorId(Integer id) throws CategoriaException;

    Categoria buscarCategoriaPorId(Integer id) throws CategoriaException;

    CategoriaDTO guardar(CategoriaDTO categoriaDTO) throws CategoriaException;

    CategoriaDTO actualizar(CategoriaDTO categoriaDTO) throws CategoriaException;
}
