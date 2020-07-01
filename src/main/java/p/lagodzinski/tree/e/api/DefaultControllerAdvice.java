package p.lagodzinski.tree.e.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import p.lagodzinski.tree.e.api.dto.ErrorDTO;
import p.lagodzinski.tree.e.services.DivideByZeroException;

@ControllerAdvice
public class DefaultControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(value = DivideByZeroException.class)
    public ErrorDTO handleConstraintViolationException(final DivideByZeroException exception) {
        return new ErrorDTO(exception.getMessage());
    }

}
