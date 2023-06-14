package co.edu.usbcali.tiendaapp.mapper.manual;

import co.edu.usbcali.tiendaapp.domain.Producto;
import co.edu.usbcali.tiendaapp.dto.ProductoDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductoMapper {

    public static ProductoDTO domainToDto(Producto producto) {
        return ProductoDTO.builder()
                .id(producto.getId())
                .referencia(producto.getReferencia())
                .unidadesDisponibles(producto.getUnidadesDisponibles())
                .precioUnitario(producto.getPrecioUnitario())
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .categoriaId(Objects.nonNull(producto.getCategoria()) ?
                        producto.getCategoria().getId() : null)
                .build();
    }

    public static Producto dtoToDomain(ProductoDTO categoriaDTO) {
        return Producto.builder()
                .id(categoriaDTO.getId())
                .referencia(categoriaDTO.getReferencia())
                .unidadesDisponibles(categoriaDTO.getUnidadesDisponibles())
                .precioUnitario(categoriaDTO.getPrecioUnitario())
                .nombre(categoriaDTO.getNombre())
                .descripcion(categoriaDTO.getDescripcion())
                .build();
    }

    public static List<ProductoDTO> domainToDtoList(List<Producto> productos) {
        return productos.stream()
                .map(ProductoMapper::domainToDto)
                .toList();
    }

    public static List<Producto> dtoToDomainList(List<ProductoDTO> productosDtos) {
        return productosDtos.stream()
                .map(ProductoMapper::dtoToDomain)
                .toList();
    }
}
