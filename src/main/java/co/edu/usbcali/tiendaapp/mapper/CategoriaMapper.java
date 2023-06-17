package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.Categoria;
import co.edu.usbcali.tiendaapp.dto.CategoriaDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaDTO domainToDto(Categoria categoria);

    Categoria dtoToDomain(CategoriaDTO categoriaDTO);

    List<CategoriaDTO> domainToDtoList(List<Categoria> categorias);

    List<Categoria> dtoToDomainList(List<CategoriaDTO> categoriasDTO);
}
