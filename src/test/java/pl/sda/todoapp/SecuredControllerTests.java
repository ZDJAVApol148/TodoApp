package pl.sda.todoapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import pl.sda.todoapp.model.dto.TodoDto;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SecuredControllerTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void givenRequestOnPrivateService_shouldFailWith401() throws Exception {

        ResponseEntity resp =
                restTemplate.getForEntity("http://localhost:" + port + "/api/todo", TodoDto[].class);
        assertThat(resp.getStatusCode().equals(401));
    }

    @WithMockUser("spring")
    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
        ResponseEntity<TodoDto[]> resp =
                restTemplate.getForEntity("http://localhost:" + port + "/api/todo", TodoDto[].class);
        assertThat(resp.getStatusCode().equals(200));
//        mvc.perform(get("/api/todo")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
    }
}
