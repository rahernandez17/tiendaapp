package co.edu.usbcali.tiendaapp.mapper.manual;

import co.edu.usbcali.tiendaapp.domain.Pedido;
import co.edu.usbcali.tiendaapp.dto.PedidoDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PedidoMapper {

    public static PedidoDTO domainToDto(Pedido pedido) {
        return PedidoDTO.builder()
                .id(pedido.getId())
                .fecha(pedido.getFecha())
                .total(pedido.getTotal())
                .estadoPedidoId(Objects.nonNull(pedido.getEstadoPedido()) ?
                        pedido.getEstadoPedido().getId(): null)
                .clienteId(Objects.nonNull(pedido.getCliente()) ?
                        pedido.getCliente().getId() : null)
                .build();
    }

    public static Pedido dtoToDomain(PedidoDTO pedidoDTO) {
        return Pedido.builder()
                .id(pedidoDTO.getId())
                .fecha(pedidoDTO.getFecha())
                .total(pedidoDTO.getTotal())
                .build();
    }

    public static List<PedidoDTO> domainToDtoList(List<Pedido> pedidos) {
        return pedidos.stream()
                .map(PedidoMapper::domainToDto)
                .toList();
    }

    public static List<Pedido> dtoToDomainList(List<PedidoDTO> pedidosDtos) {
        return pedidosDtos.stream()
                .map(PedidoMapper::dtoToDomain)
                .toList();
    }
}
