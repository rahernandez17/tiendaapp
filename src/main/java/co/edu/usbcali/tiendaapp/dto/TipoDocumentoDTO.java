package co.edu.usbcali.tiendaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoDocumentoDTO {
    private Integer id;
    private String descripcion;
}
