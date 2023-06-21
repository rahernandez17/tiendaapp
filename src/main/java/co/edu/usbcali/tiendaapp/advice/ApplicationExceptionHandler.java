package co.edu.usbcali.tiendaapp.advice;

import co.edu.usbcali.tiendaapp.exception.*;
import co.edu.usbcali.tiendaapp.response.SimpleResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


import java.util.List;
import java.util.Map;


@RestControllerAdvice
@Log4j2
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public SimpleResponse<Map<String, List<String>>> handleInvalidArgument(
            MethodArgumentNotValidException ex, WebRequest request
    ) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .toList();

        return SimpleResponse.<Map<String, List<String>>>builder()
                .codigo(HttpStatus.BAD_REQUEST.value())
                .mensaje("Error en los datos ingresados")
                .valor(Map.of("errors", errors))
                .path(request.getContextPath())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public SimpleResponse<Object> handleNotReadable(HttpMessageNotReadableException ex, WebRequest request) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.BAD_REQUEST.value())
                .mensaje(ex.getMessage())
                .path(request.getContextPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ClienteException.class)
    public SimpleResponse<Object> clienteException(ClienteException ex, WebRequest request) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .path(request.getContextPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CategoriaException.class)
    public SimpleResponse<Object> categoriaException(CategoriaException ex, WebRequest request) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .path(request.getContextPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DetallePedidoException.class)
    public SimpleResponse<Object> detallePedidoException(DetallePedidoException ex, WebRequest request) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .path(request.getContextPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EstadoPedidoException.class)
    public SimpleResponse<Object> estadoPedidoException(EstadoPedidoException ex, WebRequest request) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .path(request.getContextPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(PedidoException.class)
    public SimpleResponse<Object> pedidoException(PedidoException ex, WebRequest request) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .path(request.getContextPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ProductoException.class)
    public SimpleResponse<Object> productoException(ProductoException ex, WebRequest request) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .path(request.getContextPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(TipoDocumentoException.class)
    public SimpleResponse<Object> tipoDocumentoException(TipoDocumentoException ex, WebRequest request) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .path(request.getContextPath())
                .build();
    }
}
