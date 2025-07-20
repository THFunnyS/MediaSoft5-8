package MediaSoft_5.Repository;

import MediaSoft_5.Entity.Restaurant;
import MediaSoft_5.Entity.Review;
import MediaSoft_5.Entity.ReviewId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface ReviewRepository extends JpaRepository<Review, ReviewId> {
    List<Review> findByRestaurantId(Long restaurantId);

    Page<Review> findAllByRestaurantId(Long restaurantId, Pageable pageable);
}
