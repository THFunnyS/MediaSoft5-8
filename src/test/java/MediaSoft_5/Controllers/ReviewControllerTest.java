package MediaSoft_5.Controllers;

import MediaSoft_5.DTO.ReviewResponseDTO;
import MediaSoft_5.Services.ReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ReviewControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private ReviewService service;
    @Test
    void testGetPagedReviews() throws Exception {
        ReviewResponseDTO review = new ReviewResponseDTO(1L, 1L, 5, "Good!");
        Page<ReviewResponseDTO> page = new PageImpl<>(List.of(review));

        when(service.findPaged(1L, 0, 5, Sort.Direction.DESC)).thenReturn(page);

        mockMvc.perform(get("/api/reviews/paged")
                        .param("restaurantId", "1")
                        .param("page", "0")
                        .param("size", "5")
                        .param("sort", "DESC"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].rating").value(5));
    }
}