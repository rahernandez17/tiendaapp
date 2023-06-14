package co.edu.usbcali.tiendaapp.mapper.manual;

import co.edu.usbcali.tiendaapp.domain.Cliente;
import co.edu.usbcali.tiendaapp.dto.ClienteDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteMapper {

    public static ClienteDTO domainToDto(Cliente cliente) {
        return ClienteDTO.builder()
                .id(cliente.getId())
                .nombres(cliente.getNombres())
                .apellidos(cliente.getApellidos())
                .estado(cliente.getEstado())
                .documento(cliente.getDocumento())
                .tipoDocumentoId(Objects.nonNull(cliente.getTipoDocumento()) ?
                        cliente.getTipoDocumento().getId() : null)
                .build();
    }

    public static Cliente dtoToDomain(ClienteDTO categoriaDTO) {
        return Cliente.builder()
                .id(categoriaDTO.getId())
                .nombres(categoriaDTO.getNombres())
                .apellidos(categoriaDTO.getApellidos())
                .estado(categoriaDTO.getEstado())
                .documento(categoriaDTO.getDocumento())
                .build();
    }

    public static List<ClienteDTO> domainToDtoList(List<Cliente> clientes) {
        return clientes.stream()
                .map(ClienteMapper::domainToDto)
                .toList();
    }

    public static List<Cliente> dtoToDomainList(List<ClienteDTO> clientesDtos) {
        return clientesDtos.stream()
                .map(ClienteMapper::dtoToDomain)
                .toList();
    }
}
