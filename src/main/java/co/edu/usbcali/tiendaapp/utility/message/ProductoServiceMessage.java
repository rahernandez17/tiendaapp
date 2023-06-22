package co.edu.usbcali.tiendaapp.utility.message;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductoServiceMessage {

    public static final String ID_NO_VALIDO_MSG = "Debe ingresar un id válido para el producto";

    public static final String PRODUCTO_NO_ENCONTRADA_POR_ID = "No se ha encontrado el producto con ID {%s}";

    public static final String PRODUCTO_NULO = "El producto no puede ser nulo";

    public static final String REFERENCIA_REQUERIDA = "La referencia es requerida";

    public static final String REFERENCIA_LENGTH = "La referencia debe contener máximo {max} carácteres de lonmgitud";

    public static final String NOMBRE_REQUERIDO = "El nombre es requerido";

    public static final String NOMBRE_LENGTH = "El nombre debe contener máximo {max} carácteres de longitud";

    public static final String PRECIO_UNITARIO_REQUERIDO = "El precio unitario es requerido";

    public static final String PRECIO_UNITARIO_POSITIVO = "El precio unitario debe ser positivo";

    public static final String UNIDADES_DISPONIBLES_REQUERIDO = "Las unidades disponibles son requeridas";

    public static final String UNIDADES_DISPONIBLES_POSITIVO = "Las unidades disponibles deben ser positivas";

    public static final String CATEGORIA_ID_REQUERIDO = "El id de la categoría es requerido";

    public static final String CATEGORIA_ID_POSITIVO = "El id de la categoría debe ser positivo";

    public static final String ID_REQUERIDO = "Debe ingresar un id para actualizar un registro";

}
