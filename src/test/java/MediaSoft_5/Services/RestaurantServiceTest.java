package MediaSoft_5.Services;

import MediaSoft_5.DTO.RestaurantRequestDTO;
import MediaSoft_5.DTO.RestaurantResponseDTO;
import MediaSoft_5.Entity.Restaurant;
import MediaSoft_5.Mapper.RestaurantMapper;
import MediaSoft_5.Repository.RestaurantRepository;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTest {
    @Mock
    private RestaurantRepository repo;
    @Mock
    private RestaurantMapper mapper;
    @InjectMocks
    private RestaurantService service;

    @Test
    void testSave() {
        RestaurantRequestDTO dto = new RestaurantRequestDTO("Pizza House", "Nice", null, BigDecimal.TEN);
        Restaurant restaurant = new Restaurant();
        when(mapper.toEntity(dto)).thenReturn(restaurant);

        service.save(dto);

        verify(repo).save(restaurant);
    }

    @Test
    void testFindById_Success() {
        Restaurant restaurant = new Restaurant(1L, "Test", "Desc", null, BigDecimal.TEN, BigDecimal.ONE, List.of());
        when(repo.findById(1L)).thenReturn(Optional.of(restaurant));
        RestaurantResponseDTO responseDTO = new RestaurantResponseDTO(1L, "Test", "Desc", null, BigDecimal.TEN, BigDecimal.ONE);
        when(mapper.toDTO(restaurant)).thenReturn(responseDTO);

        RestaurantResponseDTO result = service.findById(1L);

        assertEquals(responseDTO, result);
    }

    @Test
    void testFindById_NotFound() {
        when(repo.findById(1L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> service.findById(1L));
    }

    @Test
    void testUpdateRating() {
        Restaurant restaurant = new Restaurant(1L, "Test", "Desc", null, BigDecimal.TEN, BigDecimal.ZERO, List.of());
        when(repo.findById(1L)).thenReturn(Optional.of(restaurant));

        service.updateRating(1L, BigDecimal.valueOf(4.5));

        assertEquals(BigDecimal.valueOf(4.5), restaurant.getUserRating());
        verify(repo).save(restaurant);
    }

    @Test
    void testFindWithRatingAbove() {
        BigDecimal threshold = BigDecimal.valueOf(4.0);
        List<Restaurant> list = List.of(new Restaurant());
        when(repo.findByUserRatingGreaterThanEqual(threshold)).thenReturn(list);

        List<Restaurant> result = service.findWithRatingAbove(threshold);

        assertEquals(list, result);
    }
}
