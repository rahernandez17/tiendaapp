package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.TipoDocumento;
import co.edu.usbcali.tiendaapp.dto.TipoDocumentoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoDocumentoMapper {

    TipoDocumentoDTO domainToDto(TipoDocumento tipoDocumento);

    TipoDocumento dtoToDomain(TipoDocumentoDTO tipoDocumentoDTO);

    List<TipoDocumentoDTO> domainToDtoList(List<TipoDocumento> tiposDocumentos);

    List<TipoDocumento> dtoToDomainList(List<TipoDocumentoDTO> tiposDocumentosDtos);
}
