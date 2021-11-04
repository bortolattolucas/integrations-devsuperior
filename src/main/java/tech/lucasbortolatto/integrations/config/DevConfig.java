package tech.lucasbortolatto.integrations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import tech.lucasbortolatto.integrations.services.EmailService;
import tech.lucasbortolatto.integrations.services.SendGridEmailService;

@Configuration
@Profile("dev")
public class DevConfig {

    @Bean
    public EmailService emailService() {
        return new SendGridEmailService();
    }
}
