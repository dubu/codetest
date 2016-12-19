package com.dubu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by dubu on 2016-12-18.
 *
 * https://www.codewars.com/kata/find-the-unknown-digit/train/java
 */
public class RunesTest {

    @Test
    public void testSample() {
//        assertEquals( "Answer for expression '1+1=?' " , 2 , Runes.solveExpression("1+1=?") );
//        assertEquals( "Answer for expression '123*45?=5?088' " , 6 , Runes.solveExpression("123*45?=5?088") );
//        assertEquals( "Answer for expression '-5?*-1=5?' " , 0 , Runes.solveExpression("-5?*-1=5?") );
//        assertEquals( "Answer for expression '19--45=5?' " , -1 , Runes.solveExpression("19--45=5?") );
//        assertEquals( "Answer for expression '??*??=302?' " , 5 , Runes.solveExpression("??*??=302?") );
//        assertEquals( "Answer for expression '?*11=??' " , 2 , Runes.solveExpression("?*11=??") );
        assertEquals( "Answer for expression '123?45-?=123?45' " , 0 , Runes.solveExpression("123?45-?=123?45") );
    }
}

class Runes {

    public static int solveExpression( final String expression ) {

//        System.out.println(expression);

        int missingDigit = -1;

        //Write code to determine the missing digit or unknown rune
        //Expression will always be in the form
        //(number)[opperator](number)=(number)
        //Unknown digit will not be the same as any other digits used in expression

        List<String> list = new ArrayList<>();
        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            list.add(String.valueOf(aChar));
        }

        System.out.println(list);



        List<String> numLIst = new ArrayList<>();
        String calcMark = "";
        String right = "";


        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);

            switch (s){
                case "+" :
                    numLIst.add(sb.toString());
                    calcMark = "+";
                    sb =  null;
                    break;

                case "*" :
                    numLIst.add(sb.toString());
                    calcMark = "*";
                    sb =  null;
                    break;
                case "/" :
                    numLIst.add(sb.toString());
                    calcMark = "/";
                    sb =  null;
                    break;
//                case "?" :
//                    numLIst.add(sb.toString());
//                    calcMark = "+";
//                    sb =  null;
//                    break;

                case "=" :

                    numLIst.add(sb.toString());
                    right = expression.substring(expression.indexOf("=")+1);
//                    System.out.println(right);
                    break;

                case "-" :

//                    if(numLIst.size() >0){
                    if(sb != null && sb.length() >0){
                        if(sb != null){
                            numLIst.add(sb.toString());

                        }else{
                            sb = new StringBuffer();
                            sb.append(s);
                        }
                        if(calcMark == null){
                            calcMark = "-";
                            sb =  null;
                        }

                        break;
                    }
                default:

                    if(sb == null){
                        sb = new StringBuffer();
                    }
                    sb.append(s);
//                    System.out.println(numLIst);
            }

        }

        for (int i = 0; i < 10; i++) {


            String e1 = numLIst.get(0).replaceAll("\\?", String.valueOf(i));
            String e2 = numLIst.get(1).replaceAll("\\?", String.valueOf(i));
            String answer = right.replaceAll("\\?", String.valueOf(i));

            if(Integer.valueOf(answer) == 0 && answer.length() >1){
                continue;
            }

            if(expression.contains(String.valueOf(i))){
                continue;
            }

            switch (calcMark) {
                case "+":
                    if(Long.valueOf(e1) + Long.valueOf(e2) == Long.valueOf(answer)){
                        return i;
                    }

                    break;
                case "-":
                    if(Long.valueOf(e1) - Long.valueOf(e2) == Long.valueOf(answer)){
                        return i;
                    }
                    break;

                case "*":
                    if(Long.valueOf(e1) * Long.valueOf(e2) == Long.valueOf(answer)){
                        return i;
                    }
                    break;
                case "/":
                    if(Long.valueOf(e1) / Long.valueOf(e2) == Long.valueOf(answer)){
                        return i;
                    }
                    break;
            }


        }

        return missingDigit;
    }

}
