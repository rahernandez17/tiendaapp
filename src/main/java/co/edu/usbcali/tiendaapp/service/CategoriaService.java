package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.domain.Categoria;
import co.edu.usbcali.tiendaapp.exception.CategoriaException;
import co.edu.usbcali.tiendaapp.request.ActualizaCategoriaRequest;
import co.edu.usbcali.tiendaapp.request.EliminaCategoriaRequest;
import co.edu.usbcali.tiendaapp.request.GuardaCategoriaRequest;
import co.edu.usbcali.tiendaapp.response.CategoriaResponse;

import java.util.List;

public interface CategoriaService {

    List<CategoriaResponse> obtenerTodos();

    CategoriaResponse buscarPorId(Integer id) throws CategoriaException;

    Categoria buscarCategoriaPorId(Integer id) throws CategoriaException;

    CategoriaResponse guardar(GuardaCategoriaRequest categoriaDTO) throws CategoriaException;

    CategoriaResponse actualizar(ActualizaCategoriaRequest categoriaDTO) throws CategoriaException;

    void eliminar(EliminaCategoriaRequest eliminaCategoriaRequest) throws CategoriaException;
}
