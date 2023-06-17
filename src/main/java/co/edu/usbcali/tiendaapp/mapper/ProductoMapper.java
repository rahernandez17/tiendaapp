package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.Producto;
import co.edu.usbcali.tiendaapp.dto.ProductoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    @Mapping(source = "categoria.id", target = "categoriaId")
    ProductoDTO domainToDto(Producto producto);

    @Mapping(target = "categoria", ignore = true)
    Producto dtoToDomain(ProductoDTO productoDTO);

    List<ProductoDTO> domainToDtoList(List<Producto> productos);

    List<Producto> dtoToDomainList(List<ProductoDTO> productosDtos);
}
