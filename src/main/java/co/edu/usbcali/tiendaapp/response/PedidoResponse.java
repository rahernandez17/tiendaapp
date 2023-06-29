package co.edu.usbcali.tiendaapp.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoResponse {

    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;

    private BigDecimal total;

    private Integer clienteId;

    private String nombresCliente;

    private String apellidosCliente;

    private Integer estadoPedidoId;

    private String descripcionEstadoPedido;
}
