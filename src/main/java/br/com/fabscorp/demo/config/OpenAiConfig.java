package br.com.fabscorp.demo.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Configuration
public class OpenAiConfig {
    private Logger logger = Logger.getLogger(OpenAiConfig.class.getName());

    @Value("${openai.api.key}")
    String openAiApiKey;

    @Bean
    RestTemplate template() {
        logger.info("Initializing RestTemplate");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + openAiApiKey);
            return execution.execute(request, body);
        });
        return restTemplate;
    }
}
