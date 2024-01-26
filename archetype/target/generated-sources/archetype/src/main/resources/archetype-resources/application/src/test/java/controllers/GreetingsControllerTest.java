#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controllers;

import ${package}.ApplicationConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(ApplicationConfiguration.class)
@ActiveProfiles("test")
public class GreetingsControllerTest {

    private final WebTestClient webTestClient;

    @Autowired
    public GreetingsControllerTest(WebTestClient webTestClient) {
        this.webTestClient = webTestClient;
    }

    @Test
    void testGreetings() {
        String expectedMessage = "Hello";

        webTestClient.get()
                .uri("/api/v1/greetings")

                .header("x-api-key", "0bce61bd-add5-4712-bb76-75d6ba4d8525")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).value(result -> assertEquals(expectedMessage, result));
    }

    @Test
    void testGreetingsWithName() {
        String expectedMessage = "Hello John";

        webTestClient.get()
                .uri("/api/v1/greetings/John")

                .header("x-api-key", "0bce61bd-add5-4712-bb76-75d6ba4d8525")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).value(result -> assertEquals(expectedMessage, result));
    }

    @Test
    void testGreetingsWithWrongApiKey() {
        webTestClient.get()
                .uri("/api/v1/greetings/John")

                .header("x-api-key", "wrong-api-key")
                .exchange()
                .expectStatus().is4xxClientError();

    }


}
