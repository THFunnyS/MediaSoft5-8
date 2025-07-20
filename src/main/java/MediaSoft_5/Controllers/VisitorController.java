package MediaSoft_5.Controllers;

import MediaSoft_5.DTO.VisitorRequestDTO;
import MediaSoft_5.DTO.VisitorResponseDTO;
import MediaSoft_5.Services.VisitorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class VisitorController {
    private final VisitorService service;

    @PostMapping
    public void create(@RequestBody @Valid VisitorRequestDTO dto){
        service.save(dto);
    }

    @GetMapping
    public List<VisitorResponseDTO> getAll(){
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
