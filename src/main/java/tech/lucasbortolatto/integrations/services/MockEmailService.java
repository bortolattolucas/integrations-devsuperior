package tech.lucasbortolatto.integrations.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.lucasbortolatto.integrations.dto.EmailDTO;

public class MockEmailService implements EmailService {

    private static Logger LOGGER = LoggerFactory.getLogger(MockEmailService.class);

    public void sendEmail(EmailDTO emailDTO) {
        LOGGER.info("(Mock) Sending email to: " + emailDTO.getTo());
        LOGGER.info("(Mock) Email sent!");
    }
}
