package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.Producto;
import co.edu.usbcali.tiendaapp.request.ActualizaProductoRequest;
import co.edu.usbcali.tiendaapp.request.GuardaProductoRequest;
import co.edu.usbcali.tiendaapp.response.ProductoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "categoria", ignore = true)
    Producto requestGuardarToDomain(GuardaProductoRequest guardaProductoRequest);

    @Mapping(target = "categoria", ignore = true)
    Producto requestActualizarToDomain(ActualizaProductoRequest actualizaProductoRequest);

    @Mapping(source = "categoria.nombre", target = "nombreCategoria")
    @Mapping(source = "categoria.id", target = "categoriaId")
    ProductoResponse domainToResponse(Producto producto);

    List<ProductoResponse> domainToResponseList(List<Producto> productos);
}
