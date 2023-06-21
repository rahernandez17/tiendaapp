package co.edu.usbcali.tiendaapp.service.impl;

import co.edu.usbcali.tiendaapp.domain.Categoria;
import co.edu.usbcali.tiendaapp.exception.CategoriaException;
import co.edu.usbcali.tiendaapp.mapper.CategoriaMapper;
import co.edu.usbcali.tiendaapp.repository.CategoriaRepository;
import co.edu.usbcali.tiendaapp.request.ActualizaCategoriaRequest;
import co.edu.usbcali.tiendaapp.request.EliminaCategoriaRequest;
import co.edu.usbcali.tiendaapp.request.GuardaCategoriaRequest;
import co.edu.usbcali.tiendaapp.response.CategoriaResponse;
import co.edu.usbcali.tiendaapp.service.CategoriaService;
import co.edu.usbcali.tiendaapp.utility.ValidacionUtility;
import co.edu.usbcali.tiendaapp.utility.message.CategoriaServiceMessage;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    private final CategoriaMapper categoriaMapper;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    @Override
    public List<CategoriaResponse> obtenerTodos() {
        return categoriaMapper.domainToResponseList(categoriaRepository.findAll());
    }

    @Override
    public CategoriaResponse buscarPorId(Integer id) throws CategoriaException {
        ValidacionUtility.integerIsNullOrLessZero(id,
                new CategoriaException(CategoriaServiceMessage.ID_NO_VALIDO_MSG));

        return categoriaRepository
                .findById(id)
                .map(categoriaMapper::domainToResponse)
                .orElseThrow(() -> new CategoriaException(String
                        .format(CategoriaServiceMessage.CATEGORIA_NO_ENCONTRADA_POR_ID, id))
                );
    }

    @Override
    public Categoria buscarCategoriaPorId(Integer id) throws CategoriaException {
        ValidacionUtility.integerIsNullOrLessZero(id,
                new CategoriaException(CategoriaServiceMessage.ID_NO_VALIDO_MSG));

        return categoriaRepository
                .findById(id)
                .orElseThrow(() -> new CategoriaException(String
                        .format(CategoriaServiceMessage.CATEGORIA_NO_ENCONTRADA_POR_ID, id))
                );
    }

    @Override
    public CategoriaResponse guardar(
            @NotNull(message = CategoriaServiceMessage.CATEGORIA_NULA) GuardaCategoriaRequest guardaCategoriaRequest
    ) throws CategoriaException {
        if (Boolean.TRUE.equals(categoriaRepository
                .existsByNombreIgnoreCase(guardaCategoriaRequest.getNombre()))) {
            throw new CategoriaException(String
                    .format(CategoriaServiceMessage.NOMBRE_EXISTE, guardaCategoriaRequest.getNombre()));
        }

        Categoria categoria = categoriaMapper.guardaCategoriaRequestToDomain(guardaCategoriaRequest);

        return categoriaMapper.domainToResponse(categoriaRepository.save(categoria));
    }

    @Override
    public CategoriaResponse actualizar(
            @NotNull(message = CategoriaServiceMessage.CATEGORIA_NULA)
            ActualizaCategoriaRequest actualizaCategoriaRequest
    ) throws CategoriaException {
        if (!categoriaRepository.existsById(actualizaCategoriaRequest.getId())) {
            throw new CategoriaException(String
                    .format(CategoriaServiceMessage.CATEGORIA_NO_ENCONTRADA_POR_ID, actualizaCategoriaRequest.getId()));
        }

        if (Boolean.TRUE.equals(categoriaRepository
                .existsByIdNotAndNombreIgnoreCase(
                        actualizaCategoriaRequest.getId(), actualizaCategoriaRequest.getNombre()))
        ) {
            throw new CategoriaException(String
                    .format(CategoriaServiceMessage.NOMBRE_EXISTE, actualizaCategoriaRequest.getNombre()));
        }

        Categoria categoria = categoriaMapper.actualizaCategoriaRequestToDomain(actualizaCategoriaRequest);

        return categoriaMapper.domainToResponse(categoriaRepository.save(categoria));
    }

    @Override
    public void eliminar(
            @NotNull(message = CategoriaServiceMessage.CATEGORIA_NULA)
            EliminaCategoriaRequest eliminaCategoriaRequest
    ) throws CategoriaException {
        Categoria categoria = buscarCategoriaPorId(eliminaCategoriaRequest.getId());

        if (!categoria.getProductos().isEmpty()) {
            throw new CategoriaException(String
                    .format(CategoriaServiceMessage.CATEGORIA_EXISTE_EN_PRODUCTOS, categoria.getNombre()));
        }

        categoriaRepository.delete(categoria);
    }
}
