package MediaSoft_5.Services;

import MediaSoft_5.DTO.ReviewRequestDTO;
import MediaSoft_5.DTO.ReviewResponseDTO;
import MediaSoft_5.Entity.Review;
import MediaSoft_5.Entity.ReviewId;
import MediaSoft_5.Mapper.ReviewMapper;
import MediaSoft_5.Repository.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class ReviewServiceTest {
    @Mock
    private ReviewRepository repo;

    @Mock
    private RestaurantService restaurantService;

    @Mock
    private ReviewMapper mapper;

    @InjectMocks
    private ReviewService service;


    @Test
    void testSaveAndUpdateRating() {
        ReviewRequestDTO dto = new ReviewRequestDTO(1L, 2L, 5, "Great!");
        Review review = new Review();
        when(mapper.toEntity(dto)).thenReturn(review);
        when(repo.findByRestaurantId(2L)).thenReturn(List.of(review));

        service.save(dto);

        verify(repo).save(review);
        verify(restaurantService).updateRating(eq(2L), any(BigDecimal.class));
    }

    @Test
    void testFindById() {
        ReviewId id = new ReviewId(1L, 2L);
        Review review = new Review();
        ReviewResponseDTO dto = new ReviewResponseDTO(1L, 2L, 5, "Good");
        when(repo.findById(id)).thenReturn(Optional.of(review));
        when(mapper.toDTO(review)).thenReturn(dto);

        ReviewResponseDTO result = service.findById(1L, 2L);

        assertEquals(dto, result);
    }

    @Test
    void testDelete() {
        service.delete(1L, 2L);
        verify(repo).deleteById(new ReviewId(1L, 2L));
    }
}
