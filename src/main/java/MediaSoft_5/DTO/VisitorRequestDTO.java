package MediaSoft_5.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record VisitorRequestDTO(@NotBlank String name,
                                @Min(0) int age,
                                @Pattern(regexp = "M|F") String gender) {}
