package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.EstadoPedido;
import co.edu.usbcali.tiendaapp.dto.EstadoPedidoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstadoPedidoMapper {

    EstadoPedidoDTO domainToDto(EstadoPedido estadoPedido);

    EstadoPedido dtoToDomain(EstadoPedidoDTO estadoPedidoDTO);

    List<EstadoPedidoDTO> domainToDtoList(List<EstadoPedido> estadosPedidos);

    List<EstadoPedido> dtoToDomainList(List<EstadoPedidoDTO> estadosPedidosDtos);
}
