package com.mx.bankaya.challenge.service;

import com.mx.bankaya.challenge.entity.Request;
import com.mx.bankaya.challenge.repository.IRequestRepository;
import com.mx.bankaya.challenge.utils.IPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Service that manages the Request information
 * @author Sarahy Ramirez
 */
@Service
public class RequestServiceImpl implements IRequestService{

    @Autowired
    IRequestRepository iRequestRepository;

    @Autowired
    IPUtil ipUtil;

    /**
     * Process the Request information that it will be saved
     * @param method
     */
    @Override
    public void processRequest(String method) {

        Request request =  new Request();

        request.setIp(ipUtil.getIPRequest());
        request.setDate(new Date());
        request.setMethod(method);

        iRequestRepository.save(request);
    }
}
