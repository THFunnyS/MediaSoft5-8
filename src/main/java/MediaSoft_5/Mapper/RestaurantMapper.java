package MediaSoft_5.Mapper;

import MediaSoft_5.DTO.RestaurantRequestDTO;
import MediaSoft_5.DTO.RestaurantResponseDTO;
import MediaSoft_5.Entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userRating", constant = "0")
    Restaurant toEntity(RestaurantRequestDTO dto);
    RestaurantResponseDTO toDTO(Restaurant restaurant);
}
