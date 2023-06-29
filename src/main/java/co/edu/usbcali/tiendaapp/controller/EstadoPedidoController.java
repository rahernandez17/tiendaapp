package co.edu.usbcali.tiendaapp.controller;

import co.edu.usbcali.tiendaapp.exception.EstadoPedidoException;
import co.edu.usbcali.tiendaapp.response.EstadoPedidoResponse;
import co.edu.usbcali.tiendaapp.response.ListSimpleResponse;
import co.edu.usbcali.tiendaapp.response.SimpleResponse;
import co.edu.usbcali.tiendaapp.service.EstadoPedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado-pedido")
@Tag(
        name = "Estado Pedido API",
        description = "Operaciones de lectura para los tipos de estado de pedido"
)
public class EstadoPedidoController {

    private final EstadoPedidoService estadoPedidoService;

    public EstadoPedidoController(EstadoPedidoService estadoPedidoService) {
        this.estadoPedidoService = estadoPedidoService;
    }

    @Operation(
            operationId = "ObtenerTodos",
            summary = "Obtener todos los estados de pedido",
            description = "Obtener todos los estados de pedido"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/obtener-todos", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ListSimpleResponse<EstadoPedidoResponse>> obtenerTodos() {
        return new ResponseEntity<>(
                ListSimpleResponse.<EstadoPedidoResponse>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Obtenidos con éxito")
                        .valor(estadoPedidoService.obtenerTodos())
                        .build(), HttpStatus.OK);
    }

    @Operation(
            operationId = "ObtenerPorId",
            summary = "Obtener un estado de pedido por id",
            description = "Obtener un estado de pedido por id"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @ApiResponse(responseCode = "404", description = "HTTP Status 404 NOT FOUND")
    @GetMapping(value = "/obtener-por-id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SimpleResponse<EstadoPedidoResponse>> obtenerPorId(@PathVariable Integer id)
            throws EstadoPedidoException {
        return new ResponseEntity<>(
                SimpleResponse.<EstadoPedidoResponse>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Obtenido con éxito")
                        .valor(estadoPedidoService.buscarPorId(id))
                        .build(), HttpStatus.OK);
    }
}
