package MediaSoft_5.Controllers;

import MediaSoft_5.CuisineType;
import MediaSoft_5.DTO.RestaurantRequestDTO;
import MediaSoft_5.DTO.RestaurantResponseDTO;
import MediaSoft_5.Repository.RestaurantRepository;
import MediaSoft_5.Repository.ReviewRepository;
import MediaSoft_5.Services.RestaurantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class RestaurantControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RestaurantService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreate() throws Exception {
        RestaurantRequestDTO dto = new RestaurantRequestDTO("Test", "Address", CuisineType.ITALIAN,BigDecimal.TEN);
        mockMvc.perform(post("/api/restaurants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());

        verify(service).save(dto);
    }

    @Test
    void testGetAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(
                new RestaurantResponseDTO(1L, "Test", "Addr",CuisineType.ITALIAN, BigDecimal.TEN, BigDecimal.ONE)
        ));

        mockMvc.perform(get("/api/restaurants"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1));
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(delete("/api/restaurants/1"))
                .andExpect(status().isOk());

        verify(service).delete(1L);
    }
}