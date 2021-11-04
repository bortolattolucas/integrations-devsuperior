package tech.lucasbortolatto.integrations.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.lucasbortolatto.integrations.dto.EmailDTO;
import tech.lucasbortolatto.integrations.services.EmailService;

@RestController
@RequestMapping(value = "/emails")
public class EmailResource {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<Void> send(@RequestBody EmailDTO dto) {
        emailService.sendEmail(dto);
        return ResponseEntity.noContent().build();
    }
}
