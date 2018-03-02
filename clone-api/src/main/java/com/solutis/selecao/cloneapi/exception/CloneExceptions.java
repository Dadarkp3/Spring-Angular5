package com.solutis.selecao.cloneapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CloneExceptions extends RuntimeException  {
    public CloneExceptions() {
        super();
    }
    public CloneExceptions(String message, Throwable cause) {
        super(message, cause);
    }
    public CloneExceptions(String message) {
        super(message);
    }
    public CloneExceptions(Throwable cause) {
        super(cause);
    }
}
