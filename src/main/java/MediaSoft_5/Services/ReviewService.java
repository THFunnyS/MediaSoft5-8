package MediaSoft_5.Services;

import MediaSoft_5.DTO.ReviewRequestDTO;
import MediaSoft_5.DTO.ReviewResponseDTO;
import MediaSoft_5.Entity.Review;
import MediaSoft_5.Entity.ReviewId;
import MediaSoft_5.Mapper.ReviewMapper;
import MediaSoft_5.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository repo;
    private final RestaurantService restaurantService;
    private final ReviewMapper mapper;

    public void save(ReviewRequestDTO dto) {
        repo.save(mapper.toEntity(dto));
        updateRestaurantRating(dto.restaurantId());
    }

    public List<ReviewResponseDTO> findAll() { return repo.findAll().stream().map(mapper::toDTO).toList(); }

    public ReviewResponseDTO findById(Long visitorId, Long restaurantId) {
        ReviewId id = new ReviewId(visitorId, restaurantId);
        return repo.findById(id).map(mapper::toDTO).orElseThrow();
    }

    public void delete(Long visitorId, Long restaurantId) {
        repo.deleteById(new ReviewId(visitorId, restaurantId));
    }

    private void updateRestaurantRating(Long restaurantId) {
        List<Review> reviews = repo.findByRestaurantId(restaurantId);
        BigDecimal average = BigDecimal.valueOf(
                reviews.stream().mapToInt(Review::getRating).average().orElse(0.0)
        );
        restaurantService.updateRating(restaurantId, average);
    }

    public Page<ReviewResponseDTO> findPaged(Long restaurantId, int page, int size, Sort.Direction sortDirection) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "rating"));
        return repo.findAllByRestaurantId(restaurantId, pageable)
                .map(mapper::toDTO);
    }

}
