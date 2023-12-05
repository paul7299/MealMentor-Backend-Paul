package dat3.openai_demo.service;

import dat3.openai_demo.dtos.ChatCompletionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@WebFluxTest(OpenAiService.class)
public class OpenAIServiceTest {
    OpenAiService openAiService;

    public OpenAIServiceTest() {
        openAiService = new OpenAiService();
    }

    @Test
    public void testConnectionToOpenAI() {
        assertThrows(ResponseStatusException.class, () -> {
            try {
                openAiService.makeRequest("user prompt", "system message");
            } catch (ResponseStatusException e) {
                assertEquals(HttpStatusCode.valueOf(500), e.getStatusCode());
                throw e;
            }
        });
    }

    @Configuration
    static class TestConfig {

        @Bean
        public WebClient.Builder webClientBuilder() {
            return WebClient.builder();
        }
    }
}
