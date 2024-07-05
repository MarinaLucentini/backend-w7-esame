package marinalucentini.gestioneEventi.Exception;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
@RestControllerAdvice
public class HandlerException {
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleBadRequest(BadRequestException ex) {
        if (ex.getObjectErrorList() != null) {

            String message = ex.getObjectErrorList().stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.joining(". "));
            return new ErrorDto(message, LocalDateTime.now());

        } else {

            return new ErrorDto(ex.getMessage(), LocalDateTime.now());
        }

    }
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleNotFound(ChangeSetPersister.NotFoundException ex){
        return new ErrorDto(ex.getMessage(), LocalDateTime.now());
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleGenericError(Exception ex){
        return  new ErrorDto(ex.getMessage(), LocalDateTime.now());
    }
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus (HttpStatus.FORBIDDEN)
    public ErrorDto handleUnauthorized(UnauthorizedException ex){
        return new ErrorDto(ex.getMessage(), LocalDateTime.now());
    }
}
