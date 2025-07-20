package MediaSoft_5.Services;

import MediaSoft_5.DTO.VisitorRequestDTO;
import MediaSoft_5.DTO.VisitorResponseDTO;
import MediaSoft_5.Entity.Visitor;
import MediaSoft_5.Mapper.VisitorMapper;
import MediaSoft_5.Repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitorService {
    private final VisitorRepository repo;
    private final VisitorMapper mapper;

    public void save(VisitorRequestDTO dto) { repo.save(mapper.toEntity(dto)); }

    public List<VisitorResponseDTO> findAll() { return repo.findAll().stream().map(mapper::toDTO).toList(); }

    public VisitorResponseDTO findById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElseThrow();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
