package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.DetallePedido;
import co.edu.usbcali.tiendaapp.dto.DetallePedidoDTO;
import co.edu.usbcali.tiendaapp.request.ActualizaDetallePedidoRequest;
import co.edu.usbcali.tiendaapp.request.GuardaDetallePedidoRequest;
import co.edu.usbcali.tiendaapp.response.DetallePedidoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetallePedidoMapper {

    @Mapping(source = "pedido.id", target = "pedidoId")
    @Mapping(source = "producto.id", target = "productoId")
    @Mapping(source = "producto.nombre", target = "nombreProducto")
    DetallePedidoResponse domainToResponse(DetallePedido detallePedido);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "producto", ignore = true)
    @Mapping(target = "pedido", ignore = true)
    DetallePedido requestGuardarToDomain(GuardaDetallePedidoRequest guardaDetallePedidoRequest);

    @Mapping(target = "producto", ignore = true)
    @Mapping(target = "pedido", ignore = true)
    DetallePedido requestActualizarToDomain(ActualizaDetallePedidoRequest actualizaDetallePedidoRequest);

    List<DetallePedidoResponse> domainToResponseList(List<DetallePedido> detallesPedidos);
}
