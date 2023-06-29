package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.TipoDocumento;
import co.edu.usbcali.tiendaapp.response.TipoDocumentoResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoDocumentoMapper {

    TipoDocumentoResponse domainToResponse(TipoDocumento tipoDocumento);

    List<TipoDocumentoResponse> domainToResponseList(List<TipoDocumento> tiposDocumentos);
}
