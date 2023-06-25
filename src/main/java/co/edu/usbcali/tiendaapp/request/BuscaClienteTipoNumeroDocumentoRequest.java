package co.edu.usbcali.tiendaapp.request;

import co.edu.usbcali.tiendaapp.utility.message.ClienteServiceMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuscaClienteTipoNumeroDocumentoRequest {

    @NotBlank(message = ClienteServiceMessage.DOCUMENTO_REQUERIDO)
    private String documento;

    @NotNull(message = ClienteServiceMessage.TIPO_DOCUMENTO_ID_REQUERIDO)
    private Integer tipoDocumentoId;
}
