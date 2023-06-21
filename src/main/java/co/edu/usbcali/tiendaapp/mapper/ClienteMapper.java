package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.Cliente;
import co.edu.usbcali.tiendaapp.request.ActualizaClienteRequest;
import co.edu.usbcali.tiendaapp.request.GuardaClienteRequest;
import co.edu.usbcali.tiendaapp.response.ClienteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(source = "tipoDocumento.id", target = "tipoDocumentoId")
    @Mapping(source = "tipoDocumento.descripcion", target = "descripcionTipoDocumento")
    ClienteResponse domainToResponse(Cliente cliente);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tipoDocumento", ignore = true)
    Cliente requestGuardarToDomain(GuardaClienteRequest guardaClienteRequest);

    @Mapping(target = "tipoDocumento", ignore = true)
    Cliente requestActualizarToDomain(ActualizaClienteRequest actualizaClienteRequest);

    List<ClienteResponse> domainToResponseList(List<Cliente> clientes);
}
