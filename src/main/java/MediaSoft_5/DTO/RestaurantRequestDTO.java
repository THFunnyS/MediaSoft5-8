package MediaSoft_5.DTO;

import MediaSoft_5.CuisineType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RestaurantRequestDTO(@NotBlank String name,
                                   @NotBlank String description,
                                   @NotNull CuisineType cuisineType,
                                   @DecimalMin("0.0") BigDecimal averageBill) {    }
