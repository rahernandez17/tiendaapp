package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.Pedido;
import co.edu.usbcali.tiendaapp.request.ActualizaPedidoRequest;
import co.edu.usbcali.tiendaapp.request.GuardaPedidoRequest;
import co.edu.usbcali.tiendaapp.response.PedidoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    @Mapping(source = "cliente.id", target = "clienteId")
    @Mapping(source = "cliente.nombres", target = "nombresCliente")
    @Mapping(source = "cliente.apellidos", target = "apellidosCliente")
    @Mapping(source = "estadoPedido.id", target = "estadoPedidoId")
    @Mapping(source = "estadoPedido.descripcion", target = "descripcionEstadoPedido")
    PedidoResponse domainToResponse(Pedido pedido);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "estadoPedido", ignore = true)
    Pedido requestGuardarToDomain(GuardaPedidoRequest guardaPedidoRequest);

    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "estadoPedido", ignore = true)
    Pedido requestActualizarToDomain(ActualizaPedidoRequest actualizaPedidoRequest);

    List<PedidoResponse> domainToResponseList(List<Pedido> pedidos);

}
