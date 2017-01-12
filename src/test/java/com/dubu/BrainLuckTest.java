package com.dubu;

/**
 * Created by dubu on 2017-01-11.
 * <p/>
 * https://www.codewars.com/kata/my-smallest-code-interpreter-aka-brainf-star-star-k/train/java
 * <p/>
 * <p/>
 * https://en.wikipedia.org/wiki/Brainfuck
 * <p/>
 * http://www.iamcal.com/misc/bf_debug/
 */

import org.assertj.core.internal.Characters;
import org.assertj.core.internal.Integers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.*;
import java.util.stream.Collectors;

class BrainLuck {

    private List<String> codeList;
    private List<Character> charList;

    public BrainLuck(String code) {
        this.codeList = Arrays.asList(code.split(""));
    }

    public String process(String input) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = new char[input.length()];

//        this.strList =  new LinkedList<>(Arrays.asList(input.split("")));
//        this.strList =  new LinkedList<>(Arrays.asList(input.toCharArray()));
//        List<char[]> chars = Arrays.asList(input.toCharArray());
        this.charList = input.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        int pos = 0;
        int storePos = 0;
        char val = 0;
        boolean flag = true;
//        for (String code : codeList) {
        for (int i = 0; i < codeList.size() ; i++) {
            String code = codeList.get(i);

            switch (code){
                case ">":
                    pos = ++pos;
                    break;
                case "<":
                    pos = --pos;
                    break;
                case "+":
                    val = ++val ;
                    break;
                case "-":
                    val = --val ;
                    break;
                case ".":
                    sb.append(val);
                    break;
                case ",":
                    char s = charList.remove(0);
                    val = s;
                    break;
                case "[":
                    storePos = i;
                    break;
                case "]":
                    System.out.println(Integer.valueOf(val));
                    if(val%257 == 256){
                        // pass
                    }else{
                        i = storePos;
                    }
                    break;
                default:
                    System.err.println("ERROR!");

            }
        }
        if(sb.length() == 0 ){
            return  "";
        }else{

            return sb.toString();
        }

    }

}

public class BrainLuckTest {

    @Test
    public void testAcAc() throws Exception {

        assertThat(new BrainLuck(",.>,.").process("ac"), is("ac"));
        assertThat(new BrainLuck(",+.>,+.").process("ac"), is("bd"));
    }

    @Test
    public void testEchoUntilByte255Encountered() {
        assertThat(new BrainLuck(",+[-.,+]").process("Codewars" + ((char) 255)), is("Codewars"));
    }

    @Test
    public void testEchoUntilByte0Encountered() {
        assertThat(new BrainLuck(",[.[-],]").process("Codewars" + ((char) 0)), is("Codewars"));
    }

    @Test
    public void testTwoNumbersMultiplier() {
        final char[] input = {8, 9};
        assertThat(new BrainLuck(",>,<[>[->+>+<<]>>[-<<+>>]<<<-]>>.").process(String.valueOf(input[0]) + String.valueOf(input[1])), is(String.valueOf((char) (input[0] * input[1]))));
    }


    @Test
    public void testArr() throws Exception {
        char[] chars = new char[1000];
        chars[50] = '1'; // 49
        chars[51] = '2';
        chars[52] = '3';
        chars[53] = '4';
        chars[54] = '5';
        chars[55] = '6';
        chars[56] = '7';

        assertEquals('6',chars[55]);
        assertEquals('7',chars[56]);
        assertEquals(55,chars[56]);
        assertEquals(49,chars[50]);

    }
}
