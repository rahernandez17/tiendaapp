package co.edu.usbcali.tiendaapp.controller;

import co.edu.usbcali.tiendaapp.exception.CategoriaException;
import co.edu.usbcali.tiendaapp.exception.ProductoException;
import co.edu.usbcali.tiendaapp.request.ActualizaProductoRequest;
import co.edu.usbcali.tiendaapp.request.GuardaProductoRequest;
import co.edu.usbcali.tiendaapp.response.ListSimpleResponse;
import co.edu.usbcali.tiendaapp.response.ProductoResponse;
import co.edu.usbcali.tiendaapp.response.SimpleResponse;
import co.edu.usbcali.tiendaapp.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @Operation(
            operationId = "ObtenerTodos",
            summary = "Obtener todos los productos",
            description = "Obtener todos los productos"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/obtener-todos", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ListSimpleResponse<ProductoResponse>> obtenerTodos() {
        return new ResponseEntity<>(
                ListSimpleResponse.<ProductoResponse>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Obtenidos exitosamente")
                        .valor(productoService.obtenerTodos())
                        .build(), HttpStatus.OK);
    }

    @Operation(
            operationId = "ObtenerPorId",
            summary = "Obtener un producto por id",
            description = "Obtener un producto por id"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/obtener-por-id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SimpleResponse<ProductoResponse>> obtenerPorId(@PathVariable Integer id)
            throws ProductoException {
        return new ResponseEntity<>(
                SimpleResponse.<ProductoResponse>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Obtenido con éxito")
                        .valor(productoService.buscarPorId(id))
                        .build(), HttpStatus.OK);
    }

    @Operation(
            operationId = "Guardar",
            summary = "Guardar un producto",
            description = "Guardar un producto"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @ApiResponse(responseCode = "400", description = "HTTP Status 400 BAD REQUEST")
    @PostMapping(
            value = "/guardar",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SimpleResponse<ProductoResponse>> guardar(
            @RequestBody @Valid GuardaProductoRequest guardaProductoRequest
    ) throws ProductoException, CategoriaException {
        return new ResponseEntity<>(
                SimpleResponse.<ProductoResponse>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Creado con éxito")
                        .valor(productoService.guardar(guardaProductoRequest))
                        .build(), HttpStatus.OK);
    }

    @Operation(
            operationId = "Actualizar",
            summary = "Actualizar un producto",
            description = "Actualizar un producto"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @ApiResponse(responseCode = "400", description = "HTTP Status 400 BAD REQUEST")
    @PutMapping(
            value = "/actualizar",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SimpleResponse<ProductoResponse>> actualizar(
            @RequestBody @Valid ActualizaProductoRequest actualizaProductoRequest
    ) throws ProductoException, CategoriaException {
        return new ResponseEntity<>(
                SimpleResponse.<ProductoResponse>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Actualizado con éxito")
                        .valor(productoService.actualizar(actualizaProductoRequest))
                        .build(), HttpStatus.OK);
    }
}
