package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.DetallePedido;
import co.edu.usbcali.tiendaapp.dto.DetallePedidoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetallePedidoMapper {

    @Mapping(source = "pedido.id", target = "pedidoId")
    @Mapping(source = "producto.id", target = "productoId")
    DetallePedidoDTO domainToDto(DetallePedido detallePedido);

    @Mapping(target = "producto", ignore = true)
    @Mapping(target = "pedido", ignore = true)
    DetallePedido dtoToDomain(DetallePedidoDTO detallePedidoDTO);

    List<DetallePedidoDTO> domainToDtoList(List<DetallePedido> detallesPedidos);

    List<DetallePedido> dtoToDomainList(List<DetallePedidoDTO> detallesPedidosDtos);
}
