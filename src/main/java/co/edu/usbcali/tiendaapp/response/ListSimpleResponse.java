package co.edu.usbcali.tiendaapp.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListSimpleResponse<T> {

    private Integer codigo;

    private String mensaje;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<T> valor;
}
