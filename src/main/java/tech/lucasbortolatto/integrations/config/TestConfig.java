package tech.lucasbortolatto.integrations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import tech.lucasbortolatto.integrations.services.EmailService;
import tech.lucasbortolatto.integrations.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {

    @Bean
    public EmailService emailService() {
        return new MockEmailService();
    }
}
