package co.edu.usbcali.tiendaapp.utility.message;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoriaServiceMessage {

    public static final String ID_NO_VALIDO_MSG = "Debe ingresar un id válido para la categoría";

    public static final String CATEGORIA_NO_ENCONTRADA_POR_ID = "No se ha encontrado la categoría con ID {%s}";

    public static final String CATEGORIA_NULA = "La categoría no puede ser nula";

    public static final String NOMBRE_REQUERIDO = "El nombre es requerido";

    public static final String NOMBRE_EXISTE = "Ya existe una categoría con el nombre %s";

    public static final String NOMBRE_LENGTH = "El nombre debe contener máximo {max} carácteres de longitud";


    public static final String ID_REQUERIDO = "Debe ingresar un id para actualizar un registro";

    public static final String CATEGORIA_EXISTE_EN_PRODUCTOS = "No se puede eliminar la categoría {%s} porque está asociada a uno o más productos";
}
