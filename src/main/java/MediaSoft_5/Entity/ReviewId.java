package MediaSoft_5.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import java.io.Serializable;
import java.util.Objects;

public class ReviewId implements Serializable {

    private Long visitorId;

    private Long restaurantId;

    public ReviewId() {}

    public ReviewId(Long visitorId, Long restaurantId) {
        this.visitorId = visitorId;
        this.restaurantId = restaurantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReviewId)) return false;
        ReviewId that = (ReviewId) o;
        return Objects.equals(visitorId, that.visitorId) &&
                Objects.equals(restaurantId, that.restaurantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitorId, restaurantId);
    }
}
