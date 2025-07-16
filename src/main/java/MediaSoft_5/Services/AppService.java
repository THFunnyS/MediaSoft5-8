package MediaSoft_5.Services;

import MediaSoft_5.CuisineType;
import MediaSoft_5.Entity.Restaurant;
import MediaSoft_5.Entity.Review;
import MediaSoft_5.Entity.Visitor;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class AppService {
    private final VisitorService visitorService;
    private final RestaurantService restaurantService;
    private final ReviewService reviewService;

    private final AtomicLong idGen = new AtomicLong();

    @PostConstruct
    public void init() {
        visitorService.save(new Visitor(idGen.incrementAndGet(), (String) null, 25, "M"));
        visitorService.save(new Visitor(idGen.incrementAndGet(), "Anna", 30, "F"));

        restaurantService.save(new Restaurant(idGen.incrementAndGet(), "Pizza Italia", "Best Italian pizza", CuisineType.ITALIAN, BigDecimal.valueOf(800), BigDecimal.ZERO));
        restaurantService.save(new Restaurant(idGen.incrementAndGet(), "Sushi House", "Fresh sushi and rolls", CuisineType.JAPANESE, BigDecimal.valueOf(1000), BigDecimal.ZERO));

        reviewService.save(new Review(1L, 3L, 5, "Amazing!"));
        reviewService.save(new Review(2L, 3L, 4, "Tasty but a bit expensive."));
    }

    public void test() {
        System.out.println("Visitors:");
        visitorService.findAll().forEach(System.out::println);

        System.out.println("\nRestaurants:");
        restaurantService.findAll().forEach(System.out::println);

        System.out.println("\nReviews:");
        reviewService.findAll().forEach(System.out::println);
    }
}
