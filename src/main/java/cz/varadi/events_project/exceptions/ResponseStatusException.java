package cz.varadi.events_project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResponseStatusException extends RuntimeException {
    public ResponseStatusException(String message) {


        super(message);
    }
}
