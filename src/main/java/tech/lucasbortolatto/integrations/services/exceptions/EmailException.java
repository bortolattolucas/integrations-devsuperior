package tech.lucasbortolatto.integrations.services.exceptions;

public class EmailException extends RuntimeException{

    public EmailException(String message) {
        super(message);
    }
}
