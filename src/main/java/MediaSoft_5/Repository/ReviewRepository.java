package MediaSoft_5.Repository;

import MediaSoft_5.Entity.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ReviewRepository {
    private final List<Review> data = new ArrayList<>();

    public void save(Review r) { data.add(r); }
    public void remove(Review r) { data.remove(r); }
    public List<Review> findAll() { return List.copyOf(data); }
    public List<Review> findByRestaurantId(Long id) {
        return data.stream().filter(r -> r.getRestaurantId().equals(id)).collect(Collectors.toList());
    }
}
