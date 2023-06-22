package co.edu.usbcali.tiendaapp.request;

import co.edu.usbcali.tiendaapp.utility.message.DetallePedidoServiceMessage;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuardaDetallePedidoRequest {

    @NotNull(message = DetallePedidoServiceMessage.CANTIDAD_REQUERIDA)
    @Positive(message = DetallePedidoServiceMessage.CANTIDAD_POSITIVA)
    private BigDecimal cantidad;

    @NotNull(message = DetallePedidoServiceMessage.VALOR_REQUERIDO)
    @Positive(message = DetallePedidoServiceMessage.VALOR_POSITIVO)
    private BigDecimal valor;

    @NotNull(message = DetallePedidoServiceMessage.PEDIDO_ID_REQUERIDO)
    private Integer pedidoId;

    @NotNull(message = DetallePedidoServiceMessage.PRODUCTO_ID_REQUERIDO)
    private Integer productoId;
}
