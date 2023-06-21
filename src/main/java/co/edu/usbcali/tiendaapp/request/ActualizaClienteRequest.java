package co.edu.usbcali.tiendaapp.request;

import co.edu.usbcali.tiendaapp.utility.message.ClienteServiceMessage;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActualizaClienteRequest {

    @NotNull(message = ClienteServiceMessage.ID_REQUERIDO)
    private Integer id;

    // @NotEmpty(message = ClienteServiceMessage.NOMBRES_REQUERIDOS)
    @Length(max = 50, message = ClienteServiceMessage.NOMBRES_LENGTH)
    private String nombres;

    // @NotEmpty(message = ClienteServiceMessage.APELLIDOS_REQUERIDOS)
    @Length(max = 50, message = ClienteServiceMessage.APELLIDOS_LENGTH)
    private String apellidos;

    // @NotEmpty(message = ClienteServiceMessage.DOCUMENTO_REQUERIDO)
    @Length(max = 50, message = ClienteServiceMessage.DOCUMENTO_LENGTH)
    private String documento;

    // @NotEmpty(message = ClienteServiceMessage.ESTADO_REQUERIDO)
    @Length(max = 1, message = ClienteServiceMessage.ESTADO_SUPERA_LONGITUD)
    private String estado;

    // @NotNull(message = ClienteServiceMessage.TIPO_DOCUMENTO_ID_REQUERIDO)
    private Integer tipoDocumentoId;
}
