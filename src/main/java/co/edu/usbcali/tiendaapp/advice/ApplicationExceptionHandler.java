package co.edu.usbcali.tiendaapp.advice;

import co.edu.usbcali.tiendaapp.exception.*;
import co.edu.usbcali.tiendaapp.response.SimpleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public SimpleResponse<Object> handleInvalidArgument(MethodArgumentNotValidException ex) {
        StringBuilder errorStrBuild = new StringBuilder();

        ex.getBindingResult().getFieldErrors().forEach(error ->
            errorStrBuild
                    .append(error.getField())
                    .append(": ")
                    .append(error.getDefaultMessage())
                    .append("\n")
        );

        return SimpleResponse.builder()
                .codigo(HttpStatus.BAD_REQUEST.value())
                .mensaje(errorStrBuild.toString())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public SimpleResponse<Object> handleNotReadable(HttpMessageNotReadableException ex) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.BAD_REQUEST.value())
                .mensaje(ex.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ClienteException.class)
    public SimpleResponse<Object> clienteException(ClienteException ex) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CategoriaException.class)
    public SimpleResponse<Object> categoriaException(CategoriaException ex) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DetallePedidoException.class)
    public SimpleResponse<Object> detallePedidoException(DetallePedidoException ex) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EstadoPedidoException.class)
    public SimpleResponse<Object> estadoPedidoException(EstadoPedidoException ex) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(PedidoException.class)
    public SimpleResponse<Object> pedidoException(PedidoException ex) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ProductoException.class)
    public SimpleResponse<Object> productoException(ProductoException ex) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(TipoDocumentoException.class)
    public SimpleResponse<Object> tipoDocumentoException(TipoDocumentoException ex) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .build();
    }
}
