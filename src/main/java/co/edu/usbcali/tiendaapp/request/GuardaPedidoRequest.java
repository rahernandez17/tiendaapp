package co.edu.usbcali.tiendaapp.request;

import co.edu.usbcali.tiendaapp.utility.message.PedidoServiceMessage;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuardaPedidoRequest {

    @NotNull(message = PedidoServiceMessage.FECHA_REQUERIDA)
    private Instant fecha;

    @NotNull(message = PedidoServiceMessage.TOTAL_REQUERIDO)
    @Min(value = 1, message = PedidoServiceMessage.TOTAL_POSITIVO)
    private BigDecimal total;

    @NotNull(message = PedidoServiceMessage.CLIENTE_ID_REQUERIDO)
    private Integer clienteId;

    @NotNull(message = PedidoServiceMessage.ESTADO_PEDIDO_ID_REQUERIDO)
    private Integer estadoPedidoId;
}
