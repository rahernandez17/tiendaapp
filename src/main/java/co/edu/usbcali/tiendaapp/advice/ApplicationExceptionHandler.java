package co.edu.usbcali.tiendaapp.advice;

import co.edu.usbcali.tiendaapp.exception.*;
import co.edu.usbcali.tiendaapp.response.SimpleResponse;
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
    public SimpleResponse<Object> handleInvalidArgument(
            MethodArgumentNotValidException ex, HttpServletRequest request
    ) {
        Map<String, String> errorMap = ex.getBindingResult().getFieldErrors().stream()
                .collect(
                        Collectors.toMap(
                                FieldError::getField,
                                item -> Objects.isNull(item.getDefaultMessage()) ? "" : item.getDefaultMessage()
                        )
                );

        return SimpleResponse.builder()
                .codigo(HttpStatus.BAD_REQUEST.value())
                .mensaje("Alunos de los campos diligenciados poseen errores")
                .errores(errorMap)
                .ruta(request.getContextPath() + request.getServletPath())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public SimpleResponse<Object> handleNotReadable(HttpMessageNotReadableException ex, HttpServletRequest request) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.BAD_REQUEST.value())
                .mensaje(ex.getMessage())
                .ruta(request.getContextPath() + request.getServletPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ClienteException.class)
    public SimpleResponse<Object> clienteException(ClienteException ex, HttpServletRequest request) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .ruta(request.getContextPath() + request.getServletPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CategoriaException.class)
    public SimpleResponse<Object> categoriaException(CategoriaException ex, HttpServletRequest request) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .ruta(request.getContextPath() + request.getServletPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DetallePedidoException.class)
    public SimpleResponse<Object> detallePedidoException(DetallePedidoException ex, HttpServletRequest request) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .ruta(request.getContextPath() + request.getServletPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EstadoPedidoException.class)
    public SimpleResponse<Object> estadoPedidoException(EstadoPedidoException ex, HttpServletRequest request) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .ruta(request.getContextPath() + request.getServletPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(PedidoException.class)
    public SimpleResponse<Object> pedidoException(PedidoException ex, HttpServletRequest request) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .ruta(request.getContextPath() + request.getServletPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ProductoException.class)
    public SimpleResponse<Object> productoException(ProductoException ex, HttpServletRequest request) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .ruta(request.getContextPath() + request.getServletPath())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(TipoDocumentoException.class)
    public SimpleResponse<Object> tipoDocumentoException(TipoDocumentoException ex, HttpServletRequest request) {
        return SimpleResponse.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensaje(ex.getMessage())
                .ruta(request.getContextPath() + request.getServletPath())
                .build();
    }
}
