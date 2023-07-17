package cz.varadi.events_project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class UserNotFoundExceptionHandler {
    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException e) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        UserException userException = new UserException(
                e.getMessage(),
                e,
                httpStatus,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(userException, httpStatus);
    }
}
