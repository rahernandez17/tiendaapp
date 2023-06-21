package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.Categoria;
import co.edu.usbcali.tiendaapp.dto.CategoriaDTO;
import co.edu.usbcali.tiendaapp.request.ActualizaCategoriaRequest;
import co.edu.usbcali.tiendaapp.request.GuardaCategoriaRequest;
import co.edu.usbcali.tiendaapp.response.CategoriaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaResponse domainToResponse(Categoria categoria);

    @Mapping(target = "productos", ignore = true)
    Categoria guardaCategoriaRequestToDomain(GuardaCategoriaRequest guardaCategoriaRequest);

    @Mapping(target = "productos", ignore = true)
    Categoria actualizaCategoriaRequestToDomain(ActualizaCategoriaRequest actualizaCategoriaRequest);

    List<CategoriaResponse> domainToResponseList(List<Categoria> categorias);
}
