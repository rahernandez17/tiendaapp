package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.Cliente;
import co.edu.usbcali.tiendaapp.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(source = "tipoDocumento.id", target = "tipoDocumentoId")
    ClienteDTO domainToDto(Cliente cliente);

    @Mapping(target = "tipoDocumento", ignore = true)
    Cliente dtoToDomain(ClienteDTO clienteDTO);

    List<ClienteDTO> domainToDtoList(List<Cliente> clientes);

    List<Cliente> dtoToDomainList(List<ClienteDTO> clientesDtos);
}
