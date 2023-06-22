package co.edu.usbcali.tiendaapp.advice;

import co.edu.usbcali.tiendaapp.exception.*;
import co.edu.usbcali.tiendaapp.response.SimpleErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public SimpleErrorResponse handleInvalidArgument(
            MethodArgumentNotValidException ex, HttpServletRequest request
    ) {
        Map<String, String> errorMap = ex.getBindingResult().getFieldErrors().stream()
                .collect(
                        Collectors.toMap(
                                FieldError::getField,
                                item -> Objects.isNull(item.getDefaultMessage()) ? "" : item.getDefaultMessage()
                        )
                );

        return SimpleErrorResponse.builder()
                .codigo(HttpStatus.BAD_REQUEST.value())
                .errores(errorMap)
                .ruta(request.getContextPath() + request.getServletPath())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public SimpleErrorResponse handleNotReadable(HttpMessageNotReadableException ex, HttpServletRequest request) {
        return SimpleErrorResponse.builder()
                .codigo(HttpStatus.BAD_REQUEST.value())
                .mensaje(ex.getMessage())
                .ruta(request.getContextPath() + request.getServletPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ClienteException.class)
    public SimpleErrorResponse clienteException(ClienteException ex, HttpServletRequest request) {
        return SimpleErrorResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .ruta(request.getContextPath() + request.getServletPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CategoriaException.class)
    public SimpleErrorResponse categoriaException(CategoriaException ex, HttpServletRequest request) {
        return SimpleErrorResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .ruta(request.getContextPath() + request.getServletPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DetallePedidoException.class)
    public SimpleErrorResponse detallePedidoException(DetallePedidoException ex, HttpServletRequest request) {
        return SimpleErrorResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .ruta(request.getContextPath() + request.getServletPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EstadoPedidoException.class)
    public SimpleErrorResponse estadoPedidoException(EstadoPedidoException ex, HttpServletRequest request) {
        return SimpleErrorResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .ruta(request.getContextPath() + request.getServletPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(PedidoException.class)
    public SimpleErrorResponse pedidoException(PedidoException ex, HttpServletRequest request) {
        return SimpleErrorResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .ruta(request.getContextPath() + request.getServletPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ProductoException.class)
    public SimpleErrorResponse productoException(ProductoException ex, HttpServletRequest request) {
        return SimpleErrorResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .ruta(request.getContextPath() + request.getServletPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(TipoDocumentoException.class)
    public SimpleErrorResponse tipoDocumentoException(TipoDocumentoException ex, HttpServletRequest request) {
        return SimpleErrorResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .ruta(request.getContextPath() + request.getServletPath())
                .build();
    }
}
