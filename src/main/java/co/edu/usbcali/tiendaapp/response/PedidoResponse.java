package co.edu.usbcali.tiendaapp.response;

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
public class PedidoResponse {

    private Integer id;

    private Instant fecha;

    private BigDecimal total;

    private Integer clienteId;

    private String nombresCliente;

    private String apellidosCliente;

    private Integer estadoPedidoId;

    private String descripcionEstadoPedido;
}
