package com.calculatorsoap;

import com.baeldung.springsoap.gen.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class CalculatorEndpoint {
    private static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";

    private CalculatorRepository calculatorRepository;

    @Autowired
    public CalculatorEndpoint(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "calculatorRequest")
    @ResponsePayload
    public CalculatorResponse getResult(@RequestPayload CalculatorRequest request) {
        CalculatorResponse response = new CalculatorResponse();
        response.setResult(CalculatorRepository.findResult(request.getExpression()));

        return response;
    }
}
