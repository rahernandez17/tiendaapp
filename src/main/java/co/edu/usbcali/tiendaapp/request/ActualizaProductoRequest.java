package co.edu.usbcali.tiendaapp.request;

import co.edu.usbcali.tiendaapp.utility.message.ProductoServiceMessage;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActualizaProductoRequest {

    @NotNull(message = ProductoServiceMessage.ID_REQUERIDO)
    private Integer id;

    // @NotBlank(message = ProductoServiceMessage.REFERENCIA_REQUERIDA)
    @Length(max = 10, message = ProductoServiceMessage.REFERENCIA_LENGTH)
    private String referencia;

    // @NotBlank(message = ProductoServiceMessage.NOMBRE_REQUERIDO)
    @Length(max = 50, message = ProductoServiceMessage.NOMBRE_LENGTH)
    private String nombre;

    private String descripcion;

    // @NotNull(message = ProductoServiceMessage.PRECIO_UNITARIO_REQUERIDO)
    @Min(value = 1, message = ProductoServiceMessage.PRECIO_UNITARIO_POSITIVO)
    private BigDecimal precioUnitario;

    // @NotNull(message = ProductoServiceMessage.UNIDADES_DISPONIBLES_REQUERIDO)
    @Min(value = 0, message = ProductoServiceMessage.UNIDADES_DISPONIBLES_POSITIVO)
    private BigDecimal unidadesDisponibles;

    // @NotNull(message = ProductoServiceMessage.CATEGORIA_ID_REQUERIDO)
    @Min(value = 0, message = ProductoServiceMessage.CATEGORIA_ID_POSITIVO)
    private Integer categoriaId;
}
