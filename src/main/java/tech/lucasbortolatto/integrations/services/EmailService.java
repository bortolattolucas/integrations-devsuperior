package tech.lucasbortolatto.integrations.services;

import tech.lucasbortolatto.integrations.dto.EmailDTO;

public interface EmailService {

    void sendEmail(EmailDTO emailDTO);
}
