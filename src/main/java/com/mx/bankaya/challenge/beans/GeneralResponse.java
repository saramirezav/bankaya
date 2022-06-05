package com.mx.bankaya.challenge.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResponse {

    private int code;
    private String mensaje;
    private Object response;
}
