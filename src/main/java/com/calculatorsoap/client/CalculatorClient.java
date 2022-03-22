package com.calculatorsoap.client;

import com.baeldung.springsoap.client.gen.Expression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.baeldung.springsoap.client.gen.CalculatorRequest;
import com.baeldung.springsoap.client.gen.CalculatorResponse;

public class CalculatorClient extends WebServiceGatewaySupport {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorClient.class);

    public CalculatorResponse getResult(Expression value) {

        CalculatorRequest request = new CalculatorRequest();
        request.setExpression(value);

        logger.info("Requesting information for " + value.toString());

        CalculatorResponse response = (CalculatorResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }

}