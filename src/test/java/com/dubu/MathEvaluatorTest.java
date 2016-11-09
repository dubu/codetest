package com.dubu;

/**
 * https://www.codewars.com/kata/evaluate-mathematical-expression/train/java
 * <p/>
 * Created by rigel on 11/7/16.
 */

import org.assertj.core.util.Lists;
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

    @Test
    public void testToArray() throws Exception {

//        String str = "2 / (2 + 3) * 4.33 - -6";

        List<String> strings = new MathEvaluator().toMathStringArray("2 / (2 + 3) * 4.33 - -6");

        strings.stream().forEach(System.out::println);


    }



    @Test
    public void testGroup() throws Exception {

        // Define regex to find the word 'quick' or 'lazy' or 'dog'
        String regex = "(\\d+)";
        String text = "11 22 443 23429 ";

        // Obtain the required matcher
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int groupCount = matcher.groupCount();
        System.out.println("Number of group = " + groupCount);

        // Find every match and print it
        while (matcher.find()) {
            for (int i = 0; i <= groupCount; i++) {
                // Group i substring
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }

    }
}

class MathEvaluator {

    public List<String> toMathStringArray(String str) {
//        String str = "11 22 443 23429 ";
//        str = "11.121 / { 22 443 23429 ";
//        str = "2 / (2 + 3) * 4.33 - -6";

        List<String> rs = new ArrayList<String>();

        str = str.replace("---", "-");
        str = str.replace("--", "+");

        ArrayList<String> padingCharList = Lists.newArrayList("\\(", "\\)", "\\{", "\\}", "\\[", "\\]", "\\+", "\\-", "\\*", "\\/");


        for (int i = 0; i < padingCharList.size(); i++) {
            String s = padingCharList.get(i);
            str = str.replaceAll(s, " "+s+" ");
        }

//        str = str.replaceAll("\\(", " \\( ");
//        str = str.replaceAll("\\)", " \\) ");
//        str = str.replaceAll("\\-", " \\- ");

//        Pattern p = Pattern.compile("[d.\\/\\+\\*\\/\\]\\(\\)\\[\\]\\]\\{\\}");
//        Pattern pattern = Pattern.compile(".*([\\d.\\/\\+\\*\\/\\]\\(\\)\\[\\]\\]\\{\\}]+).*");
//        Pattern pattern = Pattern.compile("(\\d+)");
        Pattern pattern = Pattern.compile("([\\d.\\/\\+\\*\\/\\]\\(\\)\\[\\]\\]\\{\\}\\-]+)");

        Matcher matcher = pattern.matcher(str);


        int groupCount = matcher.groupCount();


        while(matcher.find()) {


            for (int i = 0; i < groupCount; i++) {


//                System.out.println(matcher.group(i));
                rs.add(matcher.group(i));
            }

        }

        return rs;
    }

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
        // 덩어리 array로 만든다
        // 가로를 푼다 .
        // * / 먼저 하고 더한다
        // 숫자와 계산을 분리한다
        // 연산


        return c;

    }


    public double c(String braces) {


//        List<Character> arrList = braces.chars().mapToObj((i) -> Character.valueOf((char) i)).collect(Collectors.toList());

        List<String> arrList = toMathStringArray(braces);

        List<String> rs = new ArrayList();
        List<Integer> idxList = new ArrayList();

        String reducWord = null;
        int startIdx = 0;
        List<String> braceList =  Lists.newArrayList("(", ")", "{", "}", "[", "]");
        for (int i = 0; i < arrList.size(); i++) {

            String bh = arrList.get(i);

            //if (bh.equals('(') ||bh.equals(')')) {
            if (braceList.contains(bh)) {

                if (bh.equals(reducWord)) {

                    int eIdx = arrList.indexOf(bh);


//                    String braceLessStr = braces.substring(startIdx, eIdx);
//                    String rsStr = cc(braceLessStr);
//                    braceLessStr.replace(braceLessStr, rsStr);


                    List<String> braceLessList = arrList.subList(startIdx, eIdx);

                   // cc 줄여

                    //return braceLessList




                    rs.remove(rs.size() - 1);

                    if (rs.size() == 0) {
                        reducWord = null;

                    } else {
                        reducWord = getCloseString(rs.get(rs.size() - 1));
                        startIdx = idxList.get(idxList.size() - 1);
                    }

                } else {
                    rs.add(bh);

                    reducWord = getCloseString(bh);
                    startIdx = i;
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

    private static String getCloseString(String str) {

        char c = str.toCharArray()[0];
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
        return String.valueOf(reducWord);
    }




}
