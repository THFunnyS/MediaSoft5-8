package MediaSoft_5.Services;

import MediaSoft_5.DTO.VisitorRequestDTO;
import MediaSoft_5.DTO.VisitorResponseDTO;
import MediaSoft_5.Entity.Visitor;
import MediaSoft_5.Mapper.VisitorMapper;
import MediaSoft_5.Repository.VisitorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class VisitorServiceTest {
    @Mock
    private VisitorRepository repo;

    @Mock
    private VisitorMapper mapper;

    @InjectMocks
    private VisitorService service;

    @Test
    void testSave() {
        VisitorRequestDTO dto = new VisitorRequestDTO("Alice", 25, "F");
        Visitor visitor = new Visitor();
        when(mapper.toEntity(dto)).thenReturn(visitor);

        service.save(dto);

        verify(repo).save(visitor);
    }

    @Test
    void testFindById_Found() {
        Visitor visitor = new Visitor(1L, "Alice", 25, "F");
        when(repo.findById(1L)).thenReturn(Optional.of(visitor));
        VisitorResponseDTO dto = new VisitorResponseDTO(1L, "Alice", 25, "F");
        when(mapper.toDTO(visitor)).thenReturn(dto);

        VisitorResponseDTO result = service.findById(1L);

        assertEquals(dto, result);
    }

    @Test
    void testFindById_NotFound() {
        when(repo.findById(1L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> service.findById(1L));
    }

    @Test
    void testDelete() {
        service.delete(1L);
        verify(repo).deleteById(1L);
    }
}
