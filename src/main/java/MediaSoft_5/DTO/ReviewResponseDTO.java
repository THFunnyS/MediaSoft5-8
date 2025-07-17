package MediaSoft_5.DTO;

public record ReviewResponseDTO(Long visitorId,
                                Long restaurantId,
                                int rating,
                                String text) { }
