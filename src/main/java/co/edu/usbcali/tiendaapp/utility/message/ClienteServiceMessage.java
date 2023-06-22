package co.edu.usbcali.tiendaapp.utility.message;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteServiceMessage {

    public static final String ID_NO_VALIDO_MSG = "Debe ingresar un id válido para el cliente";

    public static final String CLIENTE_NO_ENCONTRADO_POR_ID = "No se ha encontrado el cliente con ID {%s}";

    public static final String CLIENTE_NULO = "El cliente no puede ser nulo";

    public static final String NOMBRES_REQUERIDOS = "Los nombres son requeridos";

    public static final String NOMBRES_LENGTH = "Los nombres deben contener máximo {max} carácteres de longitud";

    public static final String APELLIDOS_REQUERIDOS = "Los apellidos son requeridos";

    public static final String APELLIDOS_LENGTH = "Los apellidos deben contener máximo {max} carácteres de longitud";

    public static final String DOCUMENTO_REQUERIDO = "El documento es requerido";

    public static final String DOCUMENTO_LENGTH = "El documento debe contener máximo {max} carácteres de longitud";

    public static final String ESTADO_REQUERIDO = "El estado es requerido";

    public static final String ESTADO_SUPERA_LONGITUD = "El estado solo puede tener {max} carácter(es)";

    public static final String TIPO_DOCUMENTO_ID_REQUERIDO = "El id del tipo de documento es requerido y debe ser positivo";

    public static final String ID_REQUERIDO = "Debe ingresar un id para actualizar un registro";

    public static final String CLIENTE_NO_ENCONTRADO_POR_TIPO_NUMERO_DOCUMENTO = "No se encontró el cliente con número de documento {%s}";
}
