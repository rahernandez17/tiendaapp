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
public class ProductoResponse {

    private Integer id;

    private String referencia;

    private String nombre;

    private String descripcion;

    private BigDecimal precioUnitario;

    private BigDecimal unidadesDisponibles;

    private Integer categoriaId;

    private String nombreCategoria;
}
