package com.calculatorsoap.client;

import static org.junit.Assert.assertEquals;

import com.baeldung.springsoap.client.gen.CalculatorResponse;
import com.baeldung.springsoap.client.gen.Expression;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CalculatorClientConfig.class, loader = AnnotationConfigContextLoader.class)
public class CalculatorClientLiveTest {

    @Autowired
    CalculatorClient client;

    @Test
    public void givenCountryService_whenCountryPoland_thenCapitalIsWarsaw() {
        Expression value = new Expression();
        value.setNum0(1);
        value.setNum1(2);
        value.setOperation(new String("+"));
        CalculatorResponse response = client.getResult(value);
        assertEquals(3, response.getResult(), 0.00001);
    }
}