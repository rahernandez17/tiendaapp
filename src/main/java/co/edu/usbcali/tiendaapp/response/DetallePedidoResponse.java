package co.edu.usbcali.tiendaapp.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePedidoResponse {

    private Integer id;

    private BigDecimal cantidad;

    private BigDecimal valor;

    private Integer pedidoId;

    private Integer productoId;

    private String nombreProducto;
}
