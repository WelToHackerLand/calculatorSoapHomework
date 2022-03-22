package com.calculatorsoap;

import com.baeldung.springsoap.gen.*;
import org.springframework.stereotype.Component;

@Component
public class CalculatorRepository {

    public static Double findResult(Expression expression) throws Exception {
        Double num0 = expression.getNum0();
        Double num1 = expression.getNum1();
        String operator = expression.getOperation();
        if (operator.equals("+")) {
            return num0 + num1;
        }
        else if (operator.equals("-")) {
            return num0 - num1;
        }
        else if (operator.equals("/")) {
            try {
                return num0 / num1;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (operator.equals("*")) {
            return num0 * num1;
        }
        throw new Exception("issue with expression");
    }
}