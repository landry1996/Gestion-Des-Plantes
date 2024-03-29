package net.plante.gestion_des_plantes.error;

import net.plante.gestion_des_plantes.enums.Code;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class ErrorHandle {


    @ExceptionHandler(PlantErrorException.class)
    public ResponseEntity<ErrorMessage> handleException(PlantErrorException exception) {
        final HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;

        final ErrorMessage errorMessage = ErrorMessage.builder()
                .status(Code.INTERNAL_SERVE_ERROR.value)
                .httpStatus(internalServerError)
                .message(exception.getMessage())
                .timestamp(LocalDate.now())
                .build();
        return new ResponseEntity<>(errorMessage, internalServerError);
    }

    @ExceptionHandler(PlantNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleException(PlantNotFoundException exception) {
        final HttpStatus notFound = HttpStatus.NOT_FOUND;

        final ErrorMessage errorMessage = ErrorMessage.builder()
                .status(Code.NOT_FOUND.value)
                .httpStatus(notFound)
                .message(exception.getMessage())
                .timestamp(LocalDate.now())
                .build();
        return new ResponseEntity<>(errorMessage, notFound);
    }

    @ExceptionHandler(PlantAlreadyExistException.class)
    public ResponseEntity<ErrorMessage> handleException(PlantAlreadyExistException exception) {
        final HttpStatus alreadyReported = HttpStatus.ALREADY_REPORTED;
        final ErrorMessage errorMessage = ErrorMessage.builder()
                .status(Code.ALREADY_EXIST.value)
                .httpStatus(alreadyReported)
                .message(exception.getMessage())
                .timestamp(LocalDate.now())
                .build();
        return new ResponseEntity<>(errorMessage, alreadyReported);
    }
}
