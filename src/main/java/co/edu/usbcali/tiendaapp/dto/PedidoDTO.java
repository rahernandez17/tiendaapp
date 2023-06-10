package co.edu.usbcali.tiendaapp.dto;

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
public class PedidoDTO {
    private Integer id;
    private Instant fecha;
    private BigDecimal total;
    private Integer clienteId;
    private Integer estadoPedidoId;
}
