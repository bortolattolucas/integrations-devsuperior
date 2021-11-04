package tech.lucasbortolatto.integrations.services;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.lucasbortolatto.integrations.dto.EmailDTO;
import tech.lucasbortolatto.integrations.services.exceptions.EmailException;

import java.io.IOException;

@Service
public class EmailService {

    @Autowired
    private SendGrid sendGrid;

    private static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    public void sendEmail(EmailDTO emailDTO) {
        Email from = new Email(emailDTO.getFromEmail(), emailDTO.getFromName());
        Email to = new Email(emailDTO.getTo());
        Content content = new Content(emailDTO.getContentType(), emailDTO.getBody());
        Mail mail = new Mail(from, emailDTO.getSubject(), to, content);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            LOGGER.info("Sending email to: " + emailDTO.getTo());
            // na linha abaixo manda a request e pega a response do envio do email
            Response response = sendGrid.api(request);
            if (response.getStatusCode() >= 400 && response.getStatusCode() <= 500) {
                LOGGER.error("Error sending email: " + response.getBody());
                throw new EmailException(response.getBody());
            }
            LOGGER.info("Email sent! Status = " + response.getStatusCode());
        } catch (IOException e) {
            throw new EmailException(e.getMessage());
        }
    }
}
