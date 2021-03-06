package com.dubu;

/**
 * https://www.codewars.com/kata/evaluate-mathematical-expression/train/java
 * <p/>
 * Created by rigel on 11/7/16.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class MathEvaluatorExpressionTest {
    @Test
    public void testAddition() {
        assertEquals(new MathEvaluatorExpression().calculate("1+1"), 2d, 0.01);
    }

    @Test
    public void testSubtraction() {
        assertEquals(new MathEvaluatorExpression().calculate("1 - 1"), 0d, 0.01);
    }

    @Test
    public void testMultiplication() {
        assertEquals(new MathEvaluatorExpression().calculate("1* 1"), 1d, 0.01);
    }

    @Test
    public void testDivision() {
        assertEquals(new MathEvaluatorExpression().calculate("1 /1"), 1d, 0.01);
    }

    @Test
    public void testNegative() {
        assertEquals(new MathEvaluatorExpression().calculate("-123"), -123d, 0.01);
    }

    @Test
    public void testLiteral() {
        assertEquals(new MathEvaluatorExpression().calculate("123"), 123d, 0.01);
    }

    @Test
    public void testExpression() {
        assertEquals(new MathEvaluatorExpression().calculate("2 /2+3 * 4.75- -6"), 21.25, 0.01);
    }

    @Test
    public void testSimple() {
        assertEquals(new MathEvaluatorExpression().calculate("12* 123"), 1476d, 0.01);
    }

    @Test
    public void testComplex() {
        assertEquals(new MathEvaluatorExpression().calculate("2 / (2 + 3) * 4.33 - -6"), 7.732, 0.01);
    }

    @Test
    public void testBrace() throws Exception {

        assertEquals(new MathEvaluatorExpression().calculate(" ((1+1)+1)+1+1"), 5, 0.01);


    }

    @Test
    public void testToArray() throws Exception {

//        String str = "2 / (2 + 3) * 4.33 - -6";

        List<String> strings = new MathEvaluatorExpression().toMathStringArray("2 / (2 + 3) * 4.33 - -6");

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

    @Test
    public void testDiscoverBrace() throws Exception {

//        List<String> strings = new MathEvaluatorExpression().toMathStringArray("2 / (2 + 3) * 4.33 - -6");
//        String rsStr = discoverBrace(strings);
//        System.out.println(rsStr);

//        assertEquals(new MathEvaluatorExpression().discoverBrace(new MathEvaluatorExpression().toMathStringArray("25 + 45")).stream().reduce((a, b) -> a + " "+b).get(), "25 45 +");
        assertEquals(new MathEvaluatorExpression().discoverBrace(new MathEvaluatorExpression().toMathStringArray("(20+40) * 60")).stream().reduce((a, b) -> a + " "+b).get(), "20 40 + 60 *");
//        assertEquals(new MathEvaluatorExpression().discoverBrace(new MathEvaluatorExpression().toMathStringArray("20 * (40 + 60)")).stream().reduce((a, b) -> a + " "+b).get(), "20 40 60 + *");

//        (4+8)*(6-5)/(3-2)*(2+2)
//        [4, 8, +, 6, 5, -, *, 3, 2, -, 2, 2, +, *, /]

           // 2 2 2 + + 2 +
//         (2+2+2) +2

//        2+2+2+2+2*10
        // 2 2 2 2 2 2 ++++  2 10 *

        // 괄호 먼저
        // * / 먼저
        // 같으면 앞에 부터


    }



}

class MathEvaluatorExpression {

    public List<String> discoverBrace(List<String> strings) {


        List<String> leftList  = new ArrayList<>();
        List<String> rightList  = new ArrayList<>();
        List<String> calMarkList = Arrays.asList("+", "-", "*", "/");

        for (int i = 0; i < strings.size(); i++) {
            String item = strings.get(i);

            if(calMarkList.contains(item)){
                rightList.add(item);

            }else{
                leftList.add(item);
            }

        }

        leftList.addAll(rightList);


        leftList.stream().reduce((a, b) -> a + " "+b).get();
        return leftList;
    }

    public List<String> toMathStringArray(String str) {
//        String str = "11 22 443 23429 ";
//        str = "11.121 / { 22 443 23429 ";
//        str = "2 / (2 + 3) * 4.33 - -6";

        List<String> rs = new ArrayList<String>();

        str = str.replace("---", "-");
        str = str.replace("--", "+");

        List<String> padingCharList = Arrays.asList("(", ")", "{", "}", "[", "]", "+", "-", "*", "/");


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
        List<String> braceList =  Arrays.asList("(", ")", "{", "}", "[", "]");


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

                    String value = cc(braceLessList);

                    arrList.set(eIdx,value);
                    // push null empty space
                    for (int j = startIdx; j < eIdx ; j++) {

                        arrList.set(j ,null);
                    }
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

        return Double.valueOf("99");

    }

    private String cc(List<String> braceLessList) {

        // !!
        // CodeTest.evaluate()

        // 1 +1

        for (int i = 0; i < braceLessList.size(); i++) {
            String s = braceLessList.get(i);

        }

        return null;
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
