package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.Categoria;
import co.edu.usbcali.tiendaapp.dto.CategoriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaDTO domainToDto(Categoria categoria);

    // @Mapping(target = "productos", ignore = true)
    Categoria dtoToDomain(CategoriaDTO categoriaDTO);

    List<CategoriaDTO> domainToDtoList(List<Categoria> categorias);

    List<Categoria> dtoToDomainList(List<CategoriaDTO> categoriasDTO);
}
