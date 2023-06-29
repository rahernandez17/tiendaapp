package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.EstadoPedido;
import co.edu.usbcali.tiendaapp.dto.EstadoPedidoDTO;
import co.edu.usbcali.tiendaapp.response.EstadoPedidoResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstadoPedidoMapper {

    EstadoPedidoResponse domainToResponse(EstadoPedido estadoPedido);

    List<EstadoPedidoResponse> domainToResponseList(List<EstadoPedido> estadosPedidos);
}
