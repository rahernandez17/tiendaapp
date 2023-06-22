package co.edu.usbcali.tiendaapp.controller;

import co.edu.usbcali.tiendaapp.exception.*;
import co.edu.usbcali.tiendaapp.request.ActualizaDetallePedidoRequest;
import co.edu.usbcali.tiendaapp.request.GuardaDetallePedidoRequest;
import co.edu.usbcali.tiendaapp.response.DetallePedidoResponse;
import co.edu.usbcali.tiendaapp.response.ListSimpleResponse;
import co.edu.usbcali.tiendaapp.response.SimpleResponse;
import co.edu.usbcali.tiendaapp.service.DetallePedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detalle-pedido")
@Tag(
        name = "Detalle Pedido API",
        description = "Operaciones CRUD para los detalles de pedido"
)
public class DetallePedidoController {

    private final DetallePedidoService detallePedidoService;

    public DetallePedidoController(DetallePedidoService detallePedidoService) {
        this.detallePedidoService = detallePedidoService;
    }

    @Operation(
            operationId = "ObtenerTodos",
            summary = "Obtener todos los detalles de pedido",
            description = "Obtener todos los detalles de pedido"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/obtener-todos", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ListSimpleResponse<DetallePedidoResponse>> obtenerTodos() {
        return new ResponseEntity<>(
                ListSimpleResponse.<DetallePedidoResponse>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Obtenidos exitosamente")
                        .valor(detallePedidoService.obtenerTodos())
                        .build(), HttpStatus.OK);
    }

    @Operation(
            operationId = "ObtenerPorId",
            summary = "Obtener un detalle de pedido por id",
            description = "Obtener un detalle de pedido por id"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/obtener-por-id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SimpleResponse<DetallePedidoResponse>> obtenerPorId(@PathVariable Integer id)
            throws DetallePedidoException {
        return new ResponseEntity<>(
                SimpleResponse.<DetallePedidoResponse>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Obtenido con éxito")
                        .valor(detallePedidoService.buscarPorId(id))
                        .build(), HttpStatus.OK);
    }

    @Operation(
            operationId = "Guardar",
            summary = "Guardar un detalle de pedido",
            description = "Guardar un detalle de pedido"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @ApiResponse(responseCode = "400", description = "HTTP Status 400 BAD REQUEST")
    @PostMapping(
            value = "/guardar",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SimpleResponse<DetallePedidoResponse>> guardar(
            @RequestBody @Valid GuardaDetallePedidoRequest guardaDetallePedidoRequest
    ) throws ProductoException, DetallePedidoException, PedidoException {
        return new ResponseEntity<>(
                SimpleResponse.<DetallePedidoResponse>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Creado con éxito")
                        .valor(detallePedidoService.guardar(guardaDetallePedidoRequest))
                        .build(), HttpStatus.OK);
    }

    @Operation(
            operationId = "Actualizar",
            summary = "Actualizar un detalle de pedido",
            description = "Actualizar un detalle de pedido"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @ApiResponse(responseCode = "400", description = "HTTP Status 400 BAD REQUEST")
    @PutMapping(
            value = "/actualizar",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SimpleResponse<DetallePedidoResponse>> actualizar(
            @RequestBody @Valid ActualizaDetallePedidoRequest actualizaDetallePedidoRequest
    ) throws ProductoException, DetallePedidoException, PedidoException {
        return new ResponseEntity<>(
                SimpleResponse.<DetallePedidoResponse>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Actualizado con éxito")
                        .valor(detallePedidoService.actualizar(actualizaDetallePedidoRequest))
                        .build(), HttpStatus.OK);
    }
}
