package MediaSoft_5.Services;

import MediaSoft_5.Entity.Restaurant;
import MediaSoft_5.Repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository repo;

    public void save(Restaurant r) { repo.save(r); }
    public void remove(Restaurant r) { repo.remove(r); }
    public List<Restaurant> findAll() { return repo.findAll(); }

    public void updateRating(Long restaurantId, BigDecimal newRating) {
        repo.findAll().stream()
                .filter(r -> r.getId().equals(restaurantId))
                .findFirst()
                .ifPresent(r -> r.setUserRating(newRating));
    }
}
