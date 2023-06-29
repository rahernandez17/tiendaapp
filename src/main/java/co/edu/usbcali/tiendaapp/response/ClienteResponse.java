package co.edu.usbcali.tiendaapp.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteResponse {

    private Integer id;

    private String nombres;

    private String apellidos;

    private String documento;

    private String estado;

    private Integer tipoDocumentoId;

    private String descripcionTipoDocumento;
}
