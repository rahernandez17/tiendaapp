package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.domain.Categoria;
import co.edu.usbcali.tiendaapp.exception.CategoriaException;
import co.edu.usbcali.tiendaapp.mapper.CategoriaMapper;
import co.edu.usbcali.tiendaapp.mock.CategoriaMock;
import co.edu.usbcali.tiendaapp.repository.CategoriaRepository;
import co.edu.usbcali.tiendaapp.request.GuardaCategoriaRequest;
import co.edu.usbcali.tiendaapp.response.CategoriaResponse;
import co.edu.usbcali.tiendaapp.service.impl.CategoriaServiceImpl;
import co.edu.usbcali.tiendaapp.utility.message.CategoriaServiceMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CategoriaServiceImplTest {

    @InjectMocks
    private CategoriaServiceImpl categoriaService;

    @Mock
    private CategoriaRepository categoriaRepository;

    @Mock
    private CategoriaMapper categoriaMapper;

    @Test
    @DisplayName("obtenerTodosOk")
    void obtenerTodosOk() {
        // Preparar
        when(categoriaRepository.findAll())
                .thenReturn(CategoriaMock.CATEGORIA_LIST);
        when(categoriaMapper.domainToResponseList(anyList()))
                .thenReturn(CategoriaMock.CATEGORIA_RESPONSE_LIST);

        // Actuar
        List<CategoriaResponse> categorias = categoriaService.obtenerTodos();

        // Afirmar
        Assertions.assertEquals(categorias.size(), CategoriaMock.CATEGORIA_LIST.size());
        Assertions.assertEquals(categorias.get(0).getId(), CategoriaMock.CATEGORIA_LIST.get(0).getId());
    }

    @Test
    @DisplayName("buscarPorIdOk")
    void buscarPorIdOk() throws CategoriaException {
        // Preparar
        when(categoriaRepository.findById(anyInt()))
                .thenReturn(Optional.of(CategoriaMock.CATEGORIA_UNO));
        when(categoriaMapper.domainToResponse(any(Categoria.class)))
                .thenReturn(CategoriaMock.CATEGORIA_RESPONSE_UNO);

        // Actuar
        CategoriaResponse categoriaResponse = categoriaService.buscarPorId(1);

        // Afirmar
        Assertions.assertEquals(categoriaResponse.getId(), CategoriaMock.CATEGORIA_UNO.getId());
    }

    @Test
    @DisplayName("buscarPorIdNoOk")
    void buscarPorIdNoOk() {
        // Preparar
        String expectedMessage = String
                .format(CategoriaServiceMessage.CATEGORIA_NO_ENCONTRADA_POR_ID, 10);

        // Actuar
        CategoriaException exception = Assertions.assertThrows(CategoriaException.class,
                () -> categoriaService.buscarPorId(10));

        // Afirmar
        Assertions.assertEquals(exception.getMessage(), expectedMessage);
    }

    @Test
    @DisplayName("guardarOk")
    void guardarOk() throws CategoriaException {
        // Preparar
        when(categoriaRepository.save(any(Categoria.class)))
                .thenReturn(CategoriaMock.CATEGORIA_UNO);
        when(categoriaMapper.requestGuardarToDomain(any(GuardaCategoriaRequest.class)))
                .thenReturn(CategoriaMock.CATEGORIA_UNO);
        when(categoriaMapper.domainToResponse(any(Categoria.class)))
                .thenReturn(CategoriaMock.CATEGORIA_RESPONSE_UNO);

        // Actuar
        CategoriaResponse categoriaResponse = categoriaService.guardar(CategoriaMock.CATEGORIA_GUARDA_REQUEST);

        // Afirmar
        Assertions.assertNotNull(categoriaResponse.getId());
        Assertions.assertEquals(CategoriaMock.CATEGORIA_GUARDA_REQUEST.getNombre(), categoriaResponse.getNombre());
    }

    @Test
    @DisplayName("guardarNoOkExisteNombre")
    void guardarNoOkExisteNombre() {
        // Preparar
        when(categoriaRepository.existsByNombreIgnoreCase(CategoriaMock.CATEGORIA_NOMBRE_EXISTE))
                .thenReturn(true);

        String expectedMessage = String
                .format(CategoriaServiceMessage.NOMBRE_EXISTE, CategoriaMock.CATEGORIA_NOMBRE_EXISTE);

        // Actuar
        CategoriaException exception = Assertions.assertThrows(CategoriaException.class,
                () -> categoriaService.guardar(CategoriaMock.CATEGORIA_GUARDA_REQUEST));

        // Afirmar
        Assertions.assertEquals(exception.getMessage(), expectedMessage);
    }
}
