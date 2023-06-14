package co.edu.usbcali.tiendaapp.utility.message;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TipoDocumentoServiceMessage {

    public static final String ID_NO_VALIDO_MSG = "Debe ingresar un id válido";

    public static final String TIPO_DOCUMENTO_NO_ENCONTRADO_POR_ID = "No se ha encontrado el tipo de documento con ID %o";
}
