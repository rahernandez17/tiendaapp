package co.edu.usbcali.tiendaapp.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimpleErrorResponse {

    private Integer codigo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String mensaje;

    private String ruta;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, String> errores;
}
