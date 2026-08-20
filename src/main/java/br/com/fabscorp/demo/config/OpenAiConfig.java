package br.com.fabscorp.demo.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import java.util.logging.Logger;

@Configuration
public class OpenAiConfig {
    private Logger logger = Logger.getLogger(OpenAiConfig.class.getName());
    @Value("${openai.api.key}")
    String openAiApiKey;
}
