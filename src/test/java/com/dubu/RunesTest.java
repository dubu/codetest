package com.dubu;

import static org.junit.Assert.assertEquals;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dubu on 2016-12-18.
 *
 * https://www.codewars.com/kata/find-the-unknown-digit/train/java
 */
public class RunesTest {

    @Test
    public void testSample() {
        assertEquals( "Answer for expression '1+1=?' " , 2 , Runes.solveExpression("1+1=?") );
        assertEquals( "Answer for expression '123*45?=5?088' " , 6 , Runes.solveExpression("123*45?=5?088") );
        assertEquals( "Answer for expression '-5?*-1=5?' " , 0 , Runes.solveExpression("-5?*-1=5?") );
        assertEquals( "Answer for expression '19--45=5?' " , -1 , Runes.solveExpression("19--45=5?") );
        assertEquals( "Answer for expression '??*??=302?' " , 5 , Runes.solveExpression("??*??=302?") );
        assertEquals( "Answer for expression '?*11=??' " , 2 , Runes.solveExpression("?*11=??") );
    }
}

class Runes {

    public static int solveExpression( final String expression ) {
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

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);

            switch (s){
                case "+" :
                    numLIst.add(sb.toString());
                    sb =  null;
                    break;
                case "-" :

                    break;
                case "*" :

                    break;
                case "/" :

                    break;
                case "?" :

                    break;

                case "=" :

                    break;

                default:

                    if(sb == null){
                        sb =new StringBuffer();
                    }
                    sb.append(s);
                    System.out.println(s);
            }

        }
        return missingDigit;
    }

}
