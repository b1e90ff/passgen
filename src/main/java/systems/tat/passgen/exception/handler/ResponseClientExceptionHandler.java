package systems.tat.passgen.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import systems.tat.passgen.exception.ClientNotFoundException;
import systems.tat.passgen.model.ExceptionMessage;


@ControllerAdvice
@ResponseStatus
public class ResponseClientExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ExceptionMessage> clientNotFoundException(ClientNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ExceptionMessage.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.NOT_FOUND)
                        .build());
    }

    /*
    ToDo: Find another way to handle this / more exception
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ExceptionMessage.builder()
                        .message(ex.getBindingResult().getAllErrors().stream().findFirst().get().getDefaultMessage())
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
    }
}