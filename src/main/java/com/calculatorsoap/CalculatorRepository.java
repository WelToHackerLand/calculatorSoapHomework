package com.calculatorsoap;

import com.baeldung.springsoap.gen.*;
import org.springframework.stereotype.Component;

@Component
public class CalculatorRepository {

    public static Double findResult(Expression expression) {
        return 1.0;
    }
}