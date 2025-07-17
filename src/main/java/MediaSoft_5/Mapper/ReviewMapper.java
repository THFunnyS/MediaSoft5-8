package MediaSoft_5.Mapper;

import MediaSoft_5.DTO.ReviewRequestDTO;
import MediaSoft_5.DTO.ReviewResponseDTO;
import MediaSoft_5.Entity.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    Review toEntity(ReviewRequestDTO dto);
    ReviewResponseDTO toDTO(Review review);
}
