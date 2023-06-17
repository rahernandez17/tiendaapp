package co.edu.usbcali.tiendaapp.controller;

import co.edu.usbcali.tiendaapp.dto.CategoriaDTO;
import co.edu.usbcali.tiendaapp.exception.CategoriaException;
import co.edu.usbcali.tiendaapp.response.ListSimpleResponse;
import co.edu.usbcali.tiendaapp.response.SimpleResponse;
import co.edu.usbcali.tiendaapp.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping(value = "/obtener-todos", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ListSimpleResponse<CategoriaDTO>> obtenerTodos() {
        return new ResponseEntity<>(
                ListSimpleResponse.<CategoriaDTO>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Obtenidos exitosamente")
                        .valor(categoriaService.obtenerTodos())
                        .build(), HttpStatus.OK);
    }

    @GetMapping(value = "/obtener-por-id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SimpleResponse<CategoriaDTO>> obtenerPorId(@PathVariable Integer id)
            throws CategoriaException {
        return new ResponseEntity<>(
                SimpleResponse.<CategoriaDTO>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Obtenido con éxito")
                        .valor(categoriaService.buscarPorId(id))
                        .build(), HttpStatus.OK);
    }

    @PostMapping(
            value = "/guardar",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SimpleResponse<CategoriaDTO>> guardar(@RequestBody CategoriaDTO categoriaDTO)
            throws CategoriaException {
        return new ResponseEntity<>(
                SimpleResponse.<CategoriaDTO>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Creado con éxito")
                        .valor(categoriaService.guardar(categoriaDTO))
                        .build(), HttpStatus.OK);
    }

    @PutMapping(
            value = "/actualizar",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<SimpleResponse<CategoriaDTO>> actualizar(@RequestBody CategoriaDTO categoriaDTO)
            throws CategoriaException {
        return new ResponseEntity<>(
                SimpleResponse.<CategoriaDTO>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Actualizado con éxito")
                        .valor(categoriaService.actualizar(categoriaDTO))
                        .build(), HttpStatus.OK);
    }
}
