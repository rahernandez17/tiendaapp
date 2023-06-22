package co.edu.usbcali.tiendaapp.utility.message;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DetallePedidoServiceMessage {

    public static final String ID_NO_VALIDO_MSG = "Debe ingresar un id válido para el detalle";

    public static final String DETALLE_PEDIDO_NO_ENCONTRADA_POR_ID = "No se ha encontrado el detalle de pedido con ID {%s}";

    public static final String DETALLE_PEDIDO_NULO = "El detalle del pedido no puede ser nulo";

    public static final String CANTIDAD_REQUERIDA = "La cantidad es requerida";

    public static final String CANTIDAD_POSITIVA = "La cantidad debe ser positiva";

    public static final String VALOR_REQUERIDO = "El valor es requerido";

    public static final String VALOR_POSITIVO = "El valor debe ser positivo";

    public static final String PEDIDO_ID_REQUERIDO = "El id del pedido es requerido y debe ser positivo";

    public static final String PRODUCTO_ID_REQUERIDO = "El id del producto es requerido y debe ser positivo";

    public static final String ID_REQUERIDO = "Debe ingresar un id para actualizar un registro";

}
