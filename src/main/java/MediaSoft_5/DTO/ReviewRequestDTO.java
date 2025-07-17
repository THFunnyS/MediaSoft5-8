package MediaSoft_5.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReviewRequestDTO(@NotNull Long visitorId,
                               @NotNull Long restaurantId,
                               @Min(1) @Max(5) int rating,
                               @NotBlank String text) {}