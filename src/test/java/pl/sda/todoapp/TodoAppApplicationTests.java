package pl.sda.todoapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import pl.sda.todoapp.controller.HomeController;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
class TodoAppApplicationTests {

    @Autowired
    private HomeController homeController;

    @Test
    void contextLoads() {
        assertThat(homeController).isNotNull();
    }
}
