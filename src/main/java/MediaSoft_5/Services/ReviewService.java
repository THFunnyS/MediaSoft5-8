package MediaSoft_5.Services;

import MediaSoft_5.Entity.Review;
import MediaSoft_5.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository repo;
    private final RestaurantService restaurantService;

    public void save(Review r) {
        repo.save(r);
        updateRestaurantRating(r.getRestaurantId());
    }

    public void remove(Review r) { repo.remove(r); }
    public List<Review> findAll() { return repo.findAll(); }

    private void updateRestaurantRating(Long restaurantId) {
        List<Review> reviews = repo.findByRestaurantId(restaurantId);
        BigDecimal average = BigDecimal.valueOf(
                reviews.stream().mapToInt(Review::getRating).average().orElse(0.0)
        );
        restaurantService.updateRating(restaurantId, average);
    }
}
