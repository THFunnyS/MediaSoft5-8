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

    public void updateRating(Long restaurantId, BigDecimal newRating) {
        List<Restaurant> all = repo.findAll();
        for (Restaurant r : all) {
            if (restaurantId.equals(r.getId())) {
                r.setUserRating(newRating);
                break;
            }
        }
    }
}
