package co.edu.usbcali.tiendaapp.controller;

import co.edu.usbcali.tiendaapp.dto.ClienteDTO;
import co.edu.usbcali.tiendaapp.exception.ClienteException;
import co.edu.usbcali.tiendaapp.exception.TipoDocumentoException;
import co.edu.usbcali.tiendaapp.response.ListSimpleResponse;
import co.edu.usbcali.tiendaapp.response.SimpleResponse;
import co.edu.usbcali.tiendaapp.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cliente")
@Tag(
        name = "Cliente API",
        description = "Operaciones CRUD para los clientes"
)
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Operation(
            operationId = "ObtenerTodos",
            summary = "Obtener todos los clientes",
            description = "Obtener todos los clientes"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/obtener-todos", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ListSimpleResponse<ClienteDTO>> obtenerTodos() {
        return new ResponseEntity<>(
                ListSimpleResponse.<ClienteDTO>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Obtenidos exitosamente")
                        .valor(clienteService.obtenerTodos())
                        .build(), HttpStatus.OK);
    }

    @Operation(
            operationId = "ObtenerPorId",
            summary = "Obtener un cliente por id",
            description = "Obtener un cliente por id"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/obtener-por-id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SimpleResponse<ClienteDTO>> obtenerPorId(@PathVariable Integer id)
            throws ClienteException {
        return new ResponseEntity<>(
                SimpleResponse.<ClienteDTO>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Obtenido con éxito")
                        .valor(clienteService.buscarPorId(id))
                        .build(), HttpStatus.OK);
    }

    @Operation(
            operationId = "Guardar",
            summary = "Guardar un cliente",
            description = "Guardar un cliente"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @ApiResponse(responseCode = "400", description = "HTTP Status 400 BAD REQUEST")
    @PostMapping(
            value = "/guardar",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SimpleResponse<ClienteDTO>> guardar(@RequestBody ClienteDTO clienteDTO)
            throws TipoDocumentoException, ClienteException {
        return new ResponseEntity<>(
                SimpleResponse.<ClienteDTO>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Creado con éxito")
                        .valor(clienteService.guardar(clienteDTO))
                        .build(), HttpStatus.OK);
    }

    @Operation(
            operationId = "Actualizar",
            summary = "Actualizar un cliente",
            description = "Actualizar un cliente"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @ApiResponse(responseCode = "400", description = "HTTP Status 400 BAD REQUEST")
    @PutMapping(
            value = "/actualizar",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SimpleResponse<ClienteDTO>> actualizar(@RequestBody ClienteDTO clienteDTO)
            throws TipoDocumentoException, ClienteException {
        return new ResponseEntity<>(
                SimpleResponse.<ClienteDTO>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Actualizado con éxito")
                        .valor(clienteService.actualizar(clienteDTO))
                        .build(), HttpStatus.OK);
    }
}
