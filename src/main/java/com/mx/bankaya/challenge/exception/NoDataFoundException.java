package com.mx.bankaya.challenge.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Setter
@Getter
@ToString
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException(String mensaje) {
        this.mensaje = mensaje;
    }

    private String mensaje;
}
