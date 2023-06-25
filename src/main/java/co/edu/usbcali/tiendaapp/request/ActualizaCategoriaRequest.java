package co.edu.usbcali.tiendaapp.request;

import co.edu.usbcali.tiendaapp.utility.message.CategoriaServiceMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActualizaCategoriaRequest {

    @NotNull(message = CategoriaServiceMessage.ID_REQUERIDO)
    private Integer id;

    @NotBlank(message = CategoriaServiceMessage.NOMBRE_REQUERIDO)
    @Length(max = 10, message = CategoriaServiceMessage.NOMBRE_LENGTH)
    private String nombre;

    private String descripcion;
}
