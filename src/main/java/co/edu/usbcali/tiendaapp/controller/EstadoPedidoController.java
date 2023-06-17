package co.edu.usbcali.tiendaapp.controller;

import co.edu.usbcali.tiendaapp.dto.EstadoPedidoDTO;
import co.edu.usbcali.tiendaapp.exception.EstadoPedidoException;
import co.edu.usbcali.tiendaapp.response.ListSimpleResponse;
import co.edu.usbcali.tiendaapp.response.SimpleResponse;
import co.edu.usbcali.tiendaapp.service.EstadoPedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado-pedido")
public class EstadoPedidoController {

    private final EstadoPedidoService estadoPedidoService;

    public EstadoPedidoController(EstadoPedidoService estadoPedidoService) {
        this.estadoPedidoService = estadoPedidoService;
    }

    @GetMapping(value = "/obtener-todos", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ListSimpleResponse<EstadoPedidoDTO>> obtenerTodos() {
        return new ResponseEntity<>(
                ListSimpleResponse.<EstadoPedidoDTO>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Obtenidos con éxito")
                        .valor(estadoPedidoService.obtenerTodos())
                        .build(), HttpStatus.OK);
    }

    @GetMapping(value = "/obtener-por-id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SimpleResponse<EstadoPedidoDTO>> obtenerPorId(@PathVariable Integer id)
            throws EstadoPedidoException {
        return new ResponseEntity<>(
                SimpleResponse.<EstadoPedidoDTO>builder()
                        .codigo(HttpStatus.OK.value())
                        .mensaje("Obtenido con éxito")
                        .valor(estadoPedidoService.buscarPorId(id))
                        .build(), HttpStatus.OK);
    }
}
