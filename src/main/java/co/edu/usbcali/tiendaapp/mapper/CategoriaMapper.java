package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.Categoria;
import co.edu.usbcali.tiendaapp.request.ActualizaCategoriaRequest;
import co.edu.usbcali.tiendaapp.request.GuardaCategoriaRequest;
import co.edu.usbcali.tiendaapp.response.CategoriaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaResponse domainToResponse(Categoria categoria);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "productos", ignore = true)
    Categoria requestGuardarToDomain(GuardaCategoriaRequest guardaCategoriaRequest);

    @Mapping(target = "productos", ignore = true)
    Categoria requestActualizarToDomain(ActualizaCategoriaRequest actualizaCategoriaRequest);

    List<CategoriaResponse> domainToResponseList(List<Categoria> categorias);
}
