package com.dubu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

class Calc {

    public double evaluate(String expr) {
        System.out.println(expr);
        if (expr.length() == 0) return 0;

        Double val = Double.valueOf(0);
        String[] split = expr.split(" ");
        List<Double> list = new ArrayList<>();
        List<String> signList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];

            switch (s) {
                case "+":
                case "-":
                case "*":
                case "/":
                    signList.add(s);
                default:
                    if (signList.size() > 0) {
                        String sign = signList.get(signList.size() - 1);

                        Double left;
                        Double right;
                        switch (sign) {
                            case "+":
                                signList.remove(signList.size()-1);
                                right = Double.valueOf(list.remove(list.size() - 1));
                                left = Double.valueOf(list.remove(list.size() - 1));
//                                val = val + left + right;
                                list.add(left + right);
                                break;
                            case "-":
                                signList.remove(signList.size()-1);
                                right = Double.valueOf(list.remove(list.size() - 1));
                                left = Double.valueOf(list.remove(list.size() - 1));
                                list.add(left - right);
                                break;
                            case "*":
                                signList.remove(signList.size()-1);
                                right = Double.valueOf(list.remove(list.size() - 1));
                                left = Double.valueOf(list.remove(list.size() - 1));
                                list.add(left * right);
                                break;
                            case "/":
                                signList.remove(signList.size()-1);
                                right = Double.valueOf(list.remove(list.size() - 1));
                                left = Double.valueOf(list.remove(list.size() - 1));
                                list.add(left / right);
                                break;
                        }

                    } else {
                        list.add(Double.valueOf(s));
                    }

            }
        }

//        System.out.println(String.format("%s %s", list.size(), signList.size()));
        if (list.size() > 0) {
            return Double.valueOf(list.get(list.size() - 1));
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


    @Test
    public void shouldSupportDivisionaaa() {
        assertEquals("Should support division", 7, calc.evaluate("5 1 2 + 4 * + 3 - 2 /"), 0);
    }
//    5 1 2 + 4 * + 3 - 2 /
}
