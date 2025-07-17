package MediaSoft_5.DTO;

import MediaSoft_5.CuisineType;

import java.math.BigDecimal;

public record RestaurantResponseDTO(Long id,
                                    String name,
                                    String description,
                                    CuisineType cuisineType,
                                    BigDecimal averageBill,
                                    BigDecimal userRating) { }
