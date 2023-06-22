package co.edu.usbcali.tiendaapp.mock;

import co.edu.usbcali.tiendaapp.domain.Categoria;
import co.edu.usbcali.tiendaapp.request.GuardaCategoriaRequest;
import co.edu.usbcali.tiendaapp.response.CategoriaResponse;

import java.util.Arrays;
import java.util.List;

public class CategoriaMock {

    public static String CATEGORIA_NOMBRE_EXISTE = "CATEGORIA 1";

    public static Categoria CATEGORIA_UNO = Categoria.builder()
            .id(1)
            .nombre(CATEGORIA_NOMBRE_EXISTE)
            .descripcion("C1D")
            .build();
    public static Categoria CATEGORIA_DOS = Categoria.builder()
            .id(2)
            .nombre("C2")
            .descripcion("C2D")
            .build();

    public static List<Categoria> CATEGORIA_LIST = Arrays
            .asList(CATEGORIA_UNO, CATEGORIA_DOS);

    public static CategoriaResponse CATEGORIA_RESPONSE_UNO = CategoriaResponse.builder()
            .id(1)
            .nombre(CATEGORIA_NOMBRE_EXISTE)
            .descripcion("C1D")
            .build();

    public static CategoriaResponse CATEGORIA_RESPONSE_DOS = CategoriaResponse.builder()
            .id(2)
            .nombre("C2")
            .descripcion("C2D")
            .build();

    public static List<CategoriaResponse> CATEGORIA_RESPONSE_LIST = Arrays
            .asList(CATEGORIA_RESPONSE_UNO, CATEGORIA_RESPONSE_DOS);

    public static GuardaCategoriaRequest CATEGORIA_GUARDA_REQUEST = GuardaCategoriaRequest.builder()
            .nombre(CATEGORIA_NOMBRE_EXISTE)
            .descripcion("C1D")
            .build();
}
