package co.edu.usbcali.tiendaapp.utility.message;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoriaServiceMessage {
    public static final String ID_NO_VALIDO_MSG = "Debe ingresar un id válido";

    public static final String CATEGORIA_NO_ENCONTRADA_POR_ID = "No se ha encontrado la categoría con ID {%o}";

    public static final String CATEGORIA_NULA = "La categoría no puede ser nula";

    public static final String NOMBRE_REQUERIDO = "El nombre es requerido";

    public static final String DESCRIPCION_REQUERIDA = "La descripción es requerida";

    public static final String ID_REQUERIDO = "Debe ingresar un id para actualizar un registro";
}
