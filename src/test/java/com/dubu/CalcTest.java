package com.dubu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by rigel on 1/11/17.
 */
class Calc {

    public double evaluate(String expr) {
        // TODO: Your awesome code here
        if(expr.length() == 0) return 0;

        Double val = Double.valueOf(0);
        String[] split = expr.split(" ");
        List<String> list = new ArrayList<>();
        List<String> signList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];

            switch (s) {
                case "+":
//                   val = val + list.get(list.size()-1) + Integer.valueOf(s) ;
//                    break;
                case "-":
//                    val = val + list.get(list.size()-1) - Integer.valueOf(s) ;
//                    break;
                case "*":
//                    val = val + list.get(list.size()-1) * Integer.valueOf(s) ;
//                    break;
                case "/":
//                    val = val + list.get(list.size()-1) / Integer.valueOf(s) ;
//                    break;
                    signList.add(s);
                default:
                    if (signList.size() > 0) {
                        String sign = signList.get(signList.size() - 1);

                        Double left;
                        Double right;
                        switch (sign) {
                            case "+":
                                right =Double.valueOf(list.remove(list.size() - 1));
                                left =Double.valueOf(list.remove(list.size() - 1));
                                val = val + left + right;
                                break;
                            case "-":
                                right =Double.valueOf(list.remove(list.size() - 1));
                                left  =Double.valueOf(list.remove(list.size() - 1));
                                val = val + left - right;
                                break;
                            case "*":
                                right =Double.valueOf(list.remove(list.size() - 1));
                                left =Double.valueOf(list.remove(list.size() - 1));
                                val = val + left * right;
                                break;
                            case "/":
                                right =Double.valueOf(list.remove(list.size() - 1));
                                left =Double.valueOf(list.remove(list.size() - 1));
                                val = val + left / right;
                                break;
                        }

                    } else {
                        list.add(s);
                    }

            }
        }

        System.out.println(String.format("%s %s",list.size(), signList.size()));
        if(list.size()>0){
            return Double.valueOf(list.get(list.size()-1));
        }
        return val;
    }
}


public class CalcTest {

    private Calc calc = new Calc();

    @Test
    public void shouldWorkWithEmptyString() {
        assertEquals("Should work with empty string", 0, calc.evaluate(""), 0);
    }

    @Test
    public void shouldParseNumbers() {
        assertEquals("Should parse numbers", 3, calc.evaluate("1 2 3"), 0);
    }

    @Test
    public void shouldParseFloatNumbers() {
        assertEquals("Should parse float numbers", 3.5, calc.evaluate("1 2 3.5"), 0);
    }

    @Test
    public void shouldSupportAddition() {
        assertEquals("Should support addition", 4, calc.evaluate("1 3 +"), 0);
    }

    @Test
    public void shouldSupportMultiplication() {
        assertEquals("Should support multiplication", 3, calc.evaluate("1 3 *"), 0);
    }

    @Test
    public void shouldSupportSubstraction() {
        assertEquals("Should support substraction", -2, calc.evaluate("1 3 -"), 0);
    }

    @Test
    public void shouldSupportDivision() {
        assertEquals("Should support division", 2, calc.evaluate("4 2 /"), 0);
    }
}
