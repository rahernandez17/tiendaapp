package co.edu.usbcali.tiendaapp.mapper.manual;

import co.edu.usbcali.tiendaapp.domain.DetallePedido;
import co.edu.usbcali.tiendaapp.dto.DetallePedidoDTO;

import java.util.List;
import java.util.Objects;

public class DetallePedidoMapper {

    public static DetallePedidoDTO domainToDto(DetallePedido detallePedido) {
        return DetallePedidoDTO.builder()
                .id(detallePedido.getId())
                .valor(detallePedido.getValor())
                .cantidad(detallePedido.getCantidad())
                .pedidoId(Objects.nonNull(detallePedido.getPedido()) ?
                        detallePedido.getPedido().getId() : null)
                .productoId(Objects.nonNull(detallePedido.getProducto()) ?
                        detallePedido.getProducto().getId() : null)
                .build();
    }

    public static DetallePedido dtoToDomain(DetallePedidoDTO detallePedidoDTO) {
        return DetallePedido.builder()
                .id(detallePedidoDTO.getId())
                .valor(detallePedidoDTO.getValor())
                .cantidad(detallePedidoDTO.getCantidad())
                .build();
    }

    public static List<DetallePedidoDTO> domainToDtoList(List<DetallePedido> detallesPedidos) {
        return detallesPedidos.stream()
                .map(DetallePedidoMapper::domainToDto)
                .toList();
    }

    public static List<DetallePedido> dtoToDomainList(List<DetallePedidoDTO> detallesPedidosDtos) {
        return detallesPedidosDtos.stream()
                .map(DetallePedidoMapper::dtoToDomain)
                .toList();
    }
}
