package co.edu.usbcali.tiendaapp.request;

import co.edu.usbcali.tiendaapp.utility.message.CategoriaServiceMessage;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EliminaCategoriaRequest {

    @NotNull(message = CategoriaServiceMessage.ID_REQUERIDO)
    private Integer id;
}
