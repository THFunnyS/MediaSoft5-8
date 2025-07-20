package MediaSoft_5.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(ReviewId.class)
public class Review {
    @Id
    private Long visitorId;
    @Id
    private Long restaurantId;
    @ManyToOne
    @JoinColumn(name = "visitorId", insertable = false, updatable = false)
    private Visitor visitor;

    @ManyToOne
    @JoinColumn(name = "restaurantId", insertable = false, updatable = false)
    private Restaurant restaurant;
    private int rating;
    private String text;
}
