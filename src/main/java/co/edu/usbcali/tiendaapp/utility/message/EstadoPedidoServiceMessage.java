package co.edu.usbcali.tiendaapp.utility.message;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EstadoPedidoServiceMessage {

    public static final String ID_NO_VALIDO_MSG = "Debe ingresar un id válido";

    public static final String ESTADO_PEDIDO_NO_ENCONTRADA_POR_ID = "No se ha encontrado el estado de pedido con ID {%s}";
}
