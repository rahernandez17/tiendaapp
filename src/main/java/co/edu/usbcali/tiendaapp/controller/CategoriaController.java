package co.edu.usbcali.tiendaapp.controller;

import co.edu.usbcali.tiendaapp.exception.CategoriaException;
import co.edu.usbcali.tiendaapp.request.ActualizaCategoriaRequest;
import co.edu.usbcali.tiendaapp.request.EliminaCategoriaRequest;
import co.edu.usbcali.tiendaapp.request.GuardaCategoriaRequest;
import co.edu.usbcali.tiendaapp.response.CategoriaResponse;
import co.edu.usbcali.tiendaapp.response.ListSimpleResponse;
import co.edu.usbcali.tiendaapp.response.SimpleResponse;
import co.edu.usbcali.tiendaapp.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/categoria")
@Tag(
        name = "Categoria API",
        description = "Operaciones CRUD para las categorías"
)
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @Operation(
            operationId = "ObtenerTodos",
            summary = "Obtener todas las categorías",
            description = "Obtener todas las categorías"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/obtener-todos", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ListSimpleResponse<CategoriaResponse>> obtenerTodos() {
        return new ResponseEntity<>(
                ListSimpleResponse.<CategoriaResponse>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Obtenidos exitosamente")
                        .valor(categoriaService.obtenerTodos())
                        .build(), HttpStatus.OK);
    }

    @Operation(
            operationId = "ObtenerPorId",
            summary = "Obtener una categoría por id",
            description = "Obtener una categoría por id"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/obtener-por-id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SimpleResponse<CategoriaResponse>> obtenerPorId(@PathVariable Integer id)
            throws CategoriaException {
        return new ResponseEntity<>(
                SimpleResponse.<CategoriaResponse>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Obtenido con éxito")
                        .valor(categoriaService.buscarPorId(id))
                        .build(), HttpStatus.OK);
    }

    @Operation(
            operationId = "Guardar",
            summary = "Guardar una categoría",
            description = "Guardar una categoría"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @ApiResponse(responseCode = "400", description = "HTTP Status 400 BAD REQUEST")
    @PostMapping(
            value = "/guardar",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SimpleResponse<CategoriaResponse>> guardar(
            @RequestBody @Valid GuardaCategoriaRequest categoriaDTO
    ) throws CategoriaException {
        return new ResponseEntity<>(
                SimpleResponse.<CategoriaResponse>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Creado con éxito")
                        .valor(categoriaService.guardar(categoriaDTO))
                        .build(), HttpStatus.OK);
    }

    @Operation(
            operationId = "Actualizar",
            summary = "Actualizar una categoría",
            description = "Actualizar una categoría"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @ApiResponse(responseCode = "400", description = "HTTP Status 400 BAD REQUEST")
    @PutMapping(
            value = "/actualizar",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SimpleResponse<CategoriaResponse>> actualizar(
            @RequestBody @Valid ActualizaCategoriaRequest categoriaDTO
    ) throws CategoriaException {
        return new ResponseEntity<>(
                SimpleResponse.<CategoriaResponse>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Actualizado con éxito")
                        .valor(categoriaService.actualizar(categoriaDTO))
                        .build(), HttpStatus.OK);
    }

    @Operation(
            operationId = "EliminarPorId",
            summary = "Eliminar una categoría por id",
            description = "Eliminar una categoría por id"
    )
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @DeleteMapping(value = "/eliminar-por-id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SimpleResponse<Object>> eliminarPorId(
            @RequestBody @Valid EliminaCategoriaRequest eliminaCategoriaRequest
    ) throws CategoriaException {
        categoriaService.eliminar(eliminaCategoriaRequest);
        return new ResponseEntity<>(
                SimpleResponse.builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Eliminado con éxito")
                        .build(), HttpStatus.OK);
    }
}
