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

        if (Boolean.TRUE.equals(categoriaRepository.existsByNombreIgnoreCase(categoriaDTO.getNombre()))) {
            throw new CategoriaException(String.format(CategoriaServiceMessage.NOMBRE_EXISTE, categoriaDTO.getNombre()));
        }

        Categoria categoria = categoriaMapper.dtoToDomain(categoriaDTO);

        return categoriaMapper.domainToDto(categoriaRepository.save(categoria));
    }

    @Override
    public CategoriaDTO actualizar(CategoriaDTO categoriaDTO) throws CategoriaException {
        validarCategoria(categoriaDTO, true);

        if (!categoriaRepository.existsById(categoriaDTO.getId())) {
            throw new CategoriaException(String
                    .format(CategoriaServiceMessage.CATEGORIA_NO_ENCONTRADA_POR_ID, categoriaDTO.getId()));
        }

        if (Boolean.TRUE.equals(categoriaRepository
                .existsByIdNotAndNombreIgnoreCase(categoriaDTO.getId(), categoriaDTO.getNombre()))) {
            throw new CategoriaException(String.format(CategoriaServiceMessage.NOMBRE_EXISTE, categoriaDTO.getNombre()));
        }

        Categoria categoria = categoriaMapper.dtoToDomain(categoriaDTO);

        return categoriaMapper.domainToDto(categoriaRepository.save(categoria));
    }

    private void validarCategoria(CategoriaDTO categoriaDTO, Boolean esActualizar) throws CategoriaException {
        if (Boolean.TRUE.equals(esActualizar)) {
            ValidacionUtility.isNull(categoriaDTO.getId(),
                    new CategoriaException(CategoriaServiceMessage.ID_REQUERIDO));
        }

        ValidacionUtility.isNull(categoriaDTO,
                new CategoriaException(CategoriaServiceMessage.CATEGORIA_NULA));
        ValidacionUtility.stringIsNullOrBlank(categoriaDTO.getNombre(),
                new CategoriaException(CategoriaServiceMessage.NOMBRE_REQUERIDO));
        ValidacionUtility.stringIsNullOrBlank(categoriaDTO.getDescripcion(),
                new CategoriaException(CategoriaServiceMessage.DESCRIPCION_REQUERIDA));
    }
}
