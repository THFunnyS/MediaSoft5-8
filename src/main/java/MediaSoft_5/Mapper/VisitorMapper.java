package MediaSoft_5.Mapper;

import MediaSoft_5.DTO.VisitorRequestDTO;
import MediaSoft_5.DTO.VisitorResponseDTO;
import MediaSoft_5.Entity.Visitor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitorMapper {
    Visitor toEntity(VisitorRequestDTO dto);
    VisitorResponseDTO toDTO(Visitor visitor);
}
