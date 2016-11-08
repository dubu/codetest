package com.dubu;

/**
 * https://www.codewars.com/kata/evaluate-mathematical-expression/train/java
 * <p/>
 * Created by rigel on 11/7/16.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class MathEvaluatorTest {
    @Test
    public void testAddition() {
        assertEquals(new MathEvaluator().calculate("1+1"), 2d, 0.01);
    }

    @Test
    public void testSubtraction() {
        assertEquals(new MathEvaluator().calculate("1 - 1"), 0d, 0.01);
    }

    @Test
    public void testMultiplication() {
        assertEquals(new MathEvaluator().calculate("1* 1"), 1d, 0.01);
    }

    @Test
    public void testDivision() {
        assertEquals(new MathEvaluator().calculate("1 /1"), 1d, 0.01);
    }

    @Test
    public void testNegative() {
        assertEquals(new MathEvaluator().calculate("-123"), -123d, 0.01);
    }

    @Test
    public void testLiteral() {
        assertEquals(new MathEvaluator().calculate("123"), 123d, 0.01);
    }

    @Test
    public void testExpression() {
        assertEquals(new MathEvaluator().calculate("2 /2+3 * 4.75- -6"), 21.25, 0.01);
    }

    @Test
    public void testSimple() {
        assertEquals(new MathEvaluator().calculate("12* 123"), 1476d, 0.01);
    }

    @Test
    public void testComplex() {
        assertEquals(new MathEvaluator().calculate("2 / (2 + 3) * 4.33 - -6"), 7.732, 0.01);
    }

    @Test
    public void testBrace() throws Exception {

        assertEquals(new MathEvaluator().calculate(" ((1+1)+1)+1+1"), 5, 0.01);


    }
}

class MathEvaluator {

    public double calculate(String expression) {

        expression = expression.replace("---", "-");
        expression = expression.replace("--", "+");

//        Pattern p = Pattern.compile("\\[\\]\\(\\)\\{\\}");
//
//        Matcher m = p.matcher(expression);
//
//        if (m.find()) {
//
//
//        }

        double c = c(expression);


        // 전처리 공백제거 - 음수부호 중복처리
        // 가로를 푼다 .
        // * / 먼저 하고 더한다
        // 숫자와 계산을 분리한다
        // 연산


        return c;

    }


    public double c(String braces) {


        List<Character> arrList = braces.chars().mapToObj((i) -> Character.valueOf((char) i)).collect(Collectors.toList());
        List<Character> rs = new ArrayList();

        List<Integer> idxList = new ArrayList();


        Character reducWord = 0;
        int startIdx = 0;
        for (int i = 0; i < arrList.size(); i++) {

            Character bh = arrList.get(i);

            if (bh.equals('(') ||bh.equals(')')) {


                if (bh.equals(reducWord)) {

                    int eIdx = arrList.indexOf(bh);
                    String braceLessStr = braces.substring(startIdx, eIdx);

                    String rsStr = cc(braceLessStr);

                    braceLessStr.replace(braceLessStr, rsStr);

                    rs.remove(rs.size() - 1);

                    if (rs.size() == 0) {
                        reducWord = 0;

                    } else {
                        reducWord = getCloseString(rs.get(rs.size() - 1));
                        startIdx = idxList.get(idxList.size() - 1);
                    }

                } else {
                    rs.add(bh);

                    reducWord = getCloseString(bh);
                    startIdx = arrList.indexOf(bh);
                    idxList.add(startIdx);

                }


            }





        }

        return Double.valueOf(braces);


    }

    private String cc(String braceLessStr) {


        String  rs = "1+1";


        String.format("%1$" + String.valueOf(braceLessStr.length() - rs.length()) + "s", rs);

        return  braceLessStr;
    }

    private static char getCloseString(char c) {
        char reducWord = 0;
        switch (c) {
            case '(':
                reducWord = ')';
                break;
            case '{':
                reducWord = '}';
                break;
            case '[':
                reducWord = ']';
                break;
        }
        return reducWord;
    }

}
