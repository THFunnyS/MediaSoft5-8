package MediaSoft_5.Entity;

import MediaSoft_5.CuisineType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    private Long id;
    private String name;
    private String description;
    private CuisineType cuisineType;
    private BigDecimal averageBill;
    private BigDecimal userRating = BigDecimal.ZERO;
}
