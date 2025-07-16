package MediaSoft_5.Repository;

import MediaSoft_5.Entity.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaurantRepository {
    private final List<Restaurant> data = new ArrayList<>();

    public void save(Restaurant r) { data.add(r); }
    public void remove(Restaurant r) { data.remove(r); }
    public List<Restaurant> findAll() { return List.copyOf(data); }
}
