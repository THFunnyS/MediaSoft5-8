package MediaSoft_5.Controllers;

import MediaSoft_5.DTO.ReviewRequestDTO;
import MediaSoft_5.DTO.ReviewResponseDTO;
import MediaSoft_5.Services.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService service;

    @GetMapping("/paged")
    public Page<ReviewResponseDTO> getPagedReviews(
            @RequestParam Long restaurantId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "DESC") Sort.Direction sort
    ) {
        return service.findPaged(restaurantId, page, size, sort);
    }
}
