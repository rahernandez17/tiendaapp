package co.edu.usbcali.tiendaapp.service.impl;

import co.edu.usbcali.tiendaapp.domain.Categoria;
import co.edu.usbcali.tiendaapp.dto.CategoriaDTO;
import co.edu.usbcali.tiendaapp.exception.CategoriaException;
import co.edu.usbcali.tiendaapp.mapper.CategoriaMapper;
import co.edu.usbcali.tiendaapp.repository.CategoriaRepository;
import co.edu.usbcali.tiendaapp.service.CategoriaService;
import co.edu.usbcali.tiendaapp.utility.ValidacionUtility;
import co.edu.usbcali.tiendaapp.utility.message.CategoriaServiceMessage;
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
    public List<CategoriaDTO> obtenerTodos() {
        return categoriaMapper.domainToDtoList(categoriaRepository.findAll());
    }

    @Override
    public CategoriaDTO buscarPorId(Integer id) throws CategoriaException {
        ValidacionUtility.integerIsNullOrLessZero(id,
                new CategoriaException(CategoriaServiceMessage.ID_NO_VALIDO_MSG));

        return categoriaRepository
                .findById(id)
                .map(categoriaMapper::domainToDto)
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
    public CategoriaDTO guardar(CategoriaDTO categoriaDTO) throws CategoriaException {
        validarCategoria(categoriaDTO, false);

        Categoria categoria = categoriaMapper.dtoToDomain(categoriaDTO);

        return categoriaMapper.domainToDto(categoriaRepository.save(categoria));
    }

    @Override
    public CategoriaDTO actualizar(CategoriaDTO categoriaDTO) throws CategoriaException {
        validarCategoria(categoriaDTO, true);

        Categoria categoria = categoriaMapper.dtoToDomain(categoriaDTO);

        return categoriaMapper.domainToDto(categoriaRepository.save(categoria));
    }

    private void validarCategoria(CategoriaDTO clienteDTO, Boolean esActualizar) throws CategoriaException {
        if (Boolean.TRUE.equals(esActualizar)){
            ValidacionUtility.integerIsNullOrLessZero(clienteDTO.getId(),
                    new CategoriaException(CategoriaServiceMessage.ID_NO_VALIDO_MSG));
        }

        ValidacionUtility.isNull(clienteDTO,
                new CategoriaException(CategoriaServiceMessage.CATEGORIA_NULA));
        ValidacionUtility.stringIsNullOrBlank(clienteDTO.getNombre(),
                new CategoriaException(CategoriaServiceMessage.NOMBRE_REQUERIDO));
        ValidacionUtility.stringIsNullOrBlank(clienteDTO.getDescripcion(),
                new CategoriaException(CategoriaServiceMessage.DESCRIPCION_REQUERIDA));
    }
}
