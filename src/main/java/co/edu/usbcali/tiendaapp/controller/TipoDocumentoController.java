package co.edu.usbcali.tiendaapp.controller;

import co.edu.usbcali.tiendaapp.dto.TipoDocumentoDTO;
import co.edu.usbcali.tiendaapp.exception.TipoDocumentoException;
import co.edu.usbcali.tiendaapp.response.ListSimpleResponse;
import co.edu.usbcali.tiendaapp.response.SimpleResponse;
import co.edu.usbcali.tiendaapp.service.TipoDocumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tipo-documento")
@Tag(
        name = "Tipo Documento API",
        description = "Operaciones de lectura para los tipos de documento"
)
public class TipoDocumentoController {

    private final TipoDocumentoService tipoDocumentoService;

    public TipoDocumentoController(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @Operation(
            operationId = "ObtenerTodos",
            summary = "Obtener todos los tipos de documentos",
            description = "Obtener todos los tipos de documentos"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/obtener-todos", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ListSimpleResponse<TipoDocumentoDTO>> obtenerTodos() {
        return new ResponseEntity<>(
                ListSimpleResponse.<TipoDocumentoDTO>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Obtenidos con éxito")
                        .valor(tipoDocumentoService.obtenerTodos())
                        .build(), HttpStatus.OK);
    }

    @Operation(
            operationId = "ObtenerPorId",
            summary = "Obtener un tipo de documento por id",
            description = "Obtener un tipo de documento por id"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @ApiResponse(responseCode = "404", description = "HTTP Status 404 NOT FOUND")
    @GetMapping(value = "/obtener-por-id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SimpleResponse<TipoDocumentoDTO>> obtenerPorId(@PathVariable Integer id)
            throws TipoDocumentoException {
        return new ResponseEntity<>(
                SimpleResponse.<TipoDocumentoDTO>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Obtenido con éxito")
                        .valor(tipoDocumentoService.buscarPorId(id))
                        .build(), HttpStatus.OK);
    }
}
