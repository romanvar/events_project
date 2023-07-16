package cz.varadi.events_project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResponseStatusException extends RuntimeException {
    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such User")
    public ResponseStatusException(String message){
        super(message);
    }
}
