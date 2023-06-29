package co.edu.usbcali.tiendaapp.utility;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidacionUtility {

    public static <T extends Exception> void isNull(Object valor, T excepcion) throws T {
        if (Objects.isNull(valor)) {
            throw excepcion;
        }
    }

    public static <T extends Exception> void integerIsNullOrLessZero(Integer valor, T excepcion) throws T {
        isNull(valor, excepcion);
        if (valor.compareTo(0) <= 0) {
            throw excepcion;
        }
    }
}
