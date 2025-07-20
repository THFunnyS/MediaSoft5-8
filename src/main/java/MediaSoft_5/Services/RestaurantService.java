package MediaSoft_5.Services;

import MediaSoft_5.DTO.RestaurantRequestDTO;
import MediaSoft_5.DTO.RestaurantResponseDTO;
import MediaSoft_5.Entity.Restaurant;
import MediaSoft_5.Mapper.RestaurantMapper;
import MediaSoft_5.Repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository repo;
    private final RestaurantMapper mapper;

    public void save(RestaurantRequestDTO dto) { repo.save(mapper.toEntity(dto)); }
    public List<RestaurantResponseDTO> findAll() { return repo.findAll().stream().map(mapper::toDTO).toList(); }

    public RestaurantResponseDTO findById(Long id) {
        return repo.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public void updateRating(Long restaurantId, BigDecimal newRating) {
        Restaurant restaurant = repo.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        restaurant.setUserRating(newRating);
        repo.save(restaurant);
    }

    public List<Restaurant> findWithRatingAbove(BigDecimal rating) {
        return repo.findByUserRatingGreaterThanEqual(rating);
    }
}
