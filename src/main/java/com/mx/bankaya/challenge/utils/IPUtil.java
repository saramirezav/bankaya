package com.mx.bankaya.challenge.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Class that manages IP
 * @author Sarahy Ramirez
 */
@Component
public class IPUtil {

    /**
     * Gets the IP request
     * @return ip (String)
     */
    public String getIPRequest(){

        return ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest()
                .getRemoteAddr();
    }
}
