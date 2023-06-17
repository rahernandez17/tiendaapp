package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.Pedido;
import co.edu.usbcali.tiendaapp.dto.PedidoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    @Mapping(source = "cliente.id", target = "clienteId")
    @Mapping(source = "estadoPedido.id", target = "estadoPedidoId")
    PedidoDTO domainToDto(Pedido pedido);

    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "estadoPedido", ignore = true)
    Pedido dtoToDomain(PedidoDTO pedidoDTO);

    List<PedidoDTO> domainToDtoList(List<Pedido> pedidos);

    List<Pedido> dtoToDomainList(List<PedidoDTO> pedidosDtos);
}
