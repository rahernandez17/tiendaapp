package co.edu.usbcali.tiendaapp.controller;

import co.edu.usbcali.tiendaapp.exception.*;
import co.edu.usbcali.tiendaapp.request.ActualizaPedidoRequest;
import co.edu.usbcali.tiendaapp.request.GuardaPedidoRequest;
import co.edu.usbcali.tiendaapp.response.ListSimpleResponse;
import co.edu.usbcali.tiendaapp.response.PedidoResponse;
import co.edu.usbcali.tiendaapp.response.SimpleResponse;
import co.edu.usbcali.tiendaapp.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
@Tag(
        name = "Pedido API",
        description = "Operaciones de lectura para los pedidos"
)
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Operation(
            operationId = "ObtenerTodos",
            summary = "Obtener todos los pedidos",
            description = "Obtener todos los pedidos"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/obtener-todos", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ListSimpleResponse<PedidoResponse>> obtenerTodos() {
        return new ResponseEntity<>(
                ListSimpleResponse.<PedidoResponse>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Obtenidos exitosamente")
                        .valor(pedidoService.obtenerTodos())
                        .build(), HttpStatus.OK);
    }

    @Operation(
            operationId = "ObtenerPorId",
            summary = "Obtener un pedido por id",
            description = "Obtener un pedido por id"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/obtener-por-id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SimpleResponse<PedidoResponse>> obtenerPorId(@PathVariable Integer id)
            throws PedidoException {
        return new ResponseEntity<>(
                SimpleResponse.<PedidoResponse>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Obtenido con éxito")
                        .valor(pedidoService.buscarPorId(id))
                        .build(), HttpStatus.OK);
    }

    @Operation(
            operationId = "Guardar",
            summary = "Guardar un pedido",
            description = "Guardar un pedido"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @ApiResponse(responseCode = "400", description = "HTTP Status 400 BAD REQUEST")
    @PostMapping(
            value = "/guardar",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SimpleResponse<PedidoResponse>> guardar(
            @RequestBody @Valid GuardaPedidoRequest guardaPedidoRequest
    ) throws PedidoException, EstadoPedidoException, ClienteException {
        return new ResponseEntity<>(
                SimpleResponse.<PedidoResponse>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Creado con éxito")
                        .valor(pedidoService.guardar(guardaPedidoRequest))
                        .build(), HttpStatus.OK);
    }

    @Operation(
            operationId = "Actualizar",
            summary = "Actualizar un pedido",
            description = "Actualizar un pedido"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @ApiResponse(responseCode = "400", description = "HTTP Status 400 BAD REQUEST")
    @PutMapping(
            value = "/actualizar",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SimpleResponse<PedidoResponse>> actualizar(
            @RequestBody @Valid ActualizaPedidoRequest actualizaPedidoRequest
    ) throws PedidoException, EstadoPedidoException, ClienteException {
        return new ResponseEntity<>(
                SimpleResponse.<PedidoResponse>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Actualizado con éxito")
                        .valor(pedidoService.actualizar(actualizaPedidoRequest))
                        .build(), HttpStatus.OK);
    }
}
