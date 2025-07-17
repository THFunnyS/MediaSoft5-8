package MediaSoft_5.Controllers;

import MediaSoft_5.DTO.ReviewRequestDTO;
import MediaSoft_5.DTO.ReviewResponseDTO;
import MediaSoft_5.Services.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService service;

    @PostMapping
    public void create(@RequestBody @Valid ReviewRequestDTO dto){
        service.save(dto);
    }

    @GetMapping
    public List<ReviewResponseDTO> getAll(){
        return service.findAll();
    }
}
