package co.edu.usbcali.tiendaapp.utility.message;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PedidoServiceMessage {

    public static final String ID_NO_VALIDO_MSG = "Debe ingresar un id válido para el pedido";

    public static final String PEDIDO_NO_ENCONTRADA_POR_ID = "No se ha encontrado el pedido con ID {%s}";

    public static final String PEDIDO_NULO = "El pedido no puede ser nulo";

    public static final String FECHA_REQUERIDA = "La fecha es requerida";

    public static final String TOTAL_REQUERIDO = "El total es requerido";

    public static final String TOTAL_POSITIVO = "El total debe ser positivo";

    public static final String CLIENTE_ID_REQUERIDO = "El id del cliente es requerido y debe ser positivo";

    public static final String ESTADO_PEDIDO_ID_REQUERIDO = "El id del estado del pedido es requerido y debe ser positivo";

    public static final String ID_REQUERIDO = "Debe ingresar un id para actualizar un registro";
}
