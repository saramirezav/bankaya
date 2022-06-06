package com.mx.bankaya.challenge.configuration;


import com.mx.bankaya.challenge.service.IRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.MethodEndpoint;

/**
 * Class that manages a Global Endpoint Interceptor
 * @author Sarahy Ramirez
 */
@Component
public class InterceptorEndpoint implements EndpointInterceptor {

    private final Logger logger = LoggerFactory.getLogger(InterceptorEndpoint.class);

    @Autowired
    IRequestService iRequestService;

    /**
     * Manages handleRequest
     * @param messageContext
     * @param endpoint
     * @return boolean
     */
    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
        logger.info("handleRequest");
        String method = ((MethodEndpoint) endpoint).getMethod().getName();
        iRequestService.processRequest(method);
        return true;
    }

    /**
     * Manages handleResponse
     * @param messageContext
     * @param endpoint
     * @return boolean
     */
    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
        logger.info("handleResponse");
        return true;
    }

    /**
     * Manages handleFault
     * @param messageContext
     * @param endpoint
     * @return boolean
     */
    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
        logger.info("handleFault");
        return true;
    }

    /**
     * Manages afterCompletion
     * @param messageContext
     * @param endpoint
     * @param ex
     */
    @Override
    public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
        logger.info("afterCompletion");
    }
}
