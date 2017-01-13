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

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.*;
import java.util.stream.Collectors;

class BrainLuck {

    private List<String> codeList;
    private List<Character> inputList;
    private List<Character> mem;
    private Integer tmpPos = null;
    private String lstCode = null;
    private char tmpVal;

    public BrainLuck(String code) {
//        System.out.println(code);
        this.codeList = Arrays.asList(code.split(""));
    }

    public String process(String input) {
        intTmp();
        System.out.println(input.toCharArray());

        Character[] myarray = new Character[100];
        Arrays.fill(myarray, '\0');
//        this.mem = Arrays.asList( '\0','\0','\0','\0');
        this.mem = Arrays.asList( myarray);
        StringBuilder sb = new StringBuilder();
        this.inputList = input.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        input.chars().mapToObj(c -> (char) c).forEach(s -> System.out.print(Integer.valueOf(s)));
        int pos = 0;
//        int storePos = 0;
        char val = 0;
        Stack braceStack = new Stack();



        for (int i = 0; i < codeList.size() ; i++) {
            String code = codeList.get(i);

//            if(pos < 0 || pos >3){
//                System.err.println("out of position");
//            }


            // dup
            if(code.equals(lstCode)){
                switch (code) {
                    case ">":
                        tmpPos = ++tmpPos;
                        break;
                    case "<":
                        tmpPos = --tmpPos;
                        break;
                    case "+":
                        tmpVal = ++tmpVal;
                        break;
                    case "-":
                        tmpVal = --tmpVal;
                        break;
                }

                continue;
            }else{

                // lazy calculate
                switch (lstCode) {
                    case ">":
                        pos = pos + tmpPos;
                        val = mem.get(pos);
                        intTmp();
                        break;
                    case "<":
                        pos = pos - tmpPos;
                        val = mem.get(pos);
                        intTmp();
                        break;
                    case "+":
                        val = (char) (val + tmpVal);
                        intTmp();
                        break;
                    case "-":
                        val = (char) (val - tmpVal);
                        intTmp();
                        break;
                }
//                if ("><+-".contains(code)) {
//                    continue;
//                   }

            }

            // first time
            switch (code){
                case ">":
                    mem.set(pos,val);
                    saveTmp(code,pos,val);
//                    pos = ++pos;
//                    val =  mem.get(pos);
                    break;
                case "<":
                    mem.set(pos,val);
                    saveTmp(code,pos,val);
//                    pos = --pos;
//                    val =  mem.get(pos);
                    break;
                case "+":
                    saveTmp(code,pos,'\1');
//                    val = ++val ;
                    break;
                case "-":
                    saveTmp(code,pos,'\1');
//                    val = --val ;
                    break;
                case ".":
                    sb.append(val);
                    break;
                case ",":
                    char s = inputList.remove(0);
                    val = s;
                    break;
                case "[":
//                    storePos = i;
                    braceStack.push(i);
                    break;
                case "]":
//                    System.out.println(Integer.valueOf(val));
                    if(val <0 ){
                        System.err.println("invaild value");
                    }
                    if(val == 0 || val == 256){
//                        if(val%256 == 0){
                        braceStack.pop();
                        // pass
                    }else{
                        int peek = (int) braceStack.peek();
                        i = peek;
                    }
                    break;
                default:
//                    System.err.println("ERROR!");

            }
        }
        if(sb.length() == 0 ){
            return  "";
        }else{

            return sb.toString();
        }

    }

    private void intTmp() {
        tmpPos = null;
        tmpVal = '\0';
        lstCode = "";
    }

    private void saveTmp(String code, int pos, char val) {
        this.lstCode = code;
        this.tmpPos = pos;
        this.tmpVal = val;

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

//    @Test
    public void testRot13() throws Exception {

        String code = ",[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>++++++++++++++<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>>+++++[<----->-]<<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>++++++++++++++<-[>+<-[>+<-[>+<-[>+<-[>+<-[>++++++++++++++<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>>+++++[<----->-]<<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>++++++++++++++<-[>+<-]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]>.[-]<,]";
        assertThat(new BrainLuck(code).process("12"), is("no"));
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


    @Test
    public void testPop() throws Exception {
        Stack s  = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        s.push(10);


//        for (int i = 0; i < s.size(); i++) {
//            System.out.println(s.pop());
//        }

        while (!s.empty()){
            System.out.println(s.pop());
        }

    }


    public void testStep1() throws Exception {

        final char[] input = {8, 9};
        String code = ",>,<\n" +
            " >\n" +
            " [->+>+<<]\n" +
            " <\n" +
            ".>.>.>. ";


        new BrainLuck(code).process(String.valueOf(input[0]) + String.valueOf(input[1]));

//        assertThat(new BrainLuck(code).process(String.valueOf(input[0]) + String.valueOf(input[1])), is(String.valueOf("\t\t")));

    }


//    @Test
    public void testHelloWorld() {
        String code = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.";
        assertThat(new BrainLuck(code).process( "" ), is(String.valueOf((char) (8 * 9))));

    }

    @Test
    public void testArrayInitZero() throws Exception {
        char[] myarray = new char[10000];
        Arrays.fill(myarray, '\0');
        System.out.println(myarray);

    }

    ////    test line ////


//    @Test
    public void testFibo() {
        String code = "++\n" +
            ">+>>>>++++++++++++++++++++++++++++++++++++++++++++\n" +
            ">++++++++++++++++++++++++++++++++<<<<<<[>[>>>>>>+>\n" +
            "+<<<<<<<-]>>>>>>>[<<<<<<<+>>>>>>>-]<[>++++++++++[-\n" +
            "<-[>>+>+<<<-]>>>[<<<+>>>-]+<[>[-]<[-]]>[<<[>>>+<<<\n" +
            "-]>>[-]]<<]>>>[>>+>+<<<-]>>>[<<<+>>>-]+<[>[-]<[-]]\n" +
            ">[<<+>>[-]]<<<<<<<]>>>>>[+++++++++++++++++++++++++\n" +
            "+++++++++++++++++++++++.[-]]++++++++++<[->-<]>++++\n" +
            "++++++++++++++++++++++++++++++++++++++++++++.[-]<<\n" +
            "<<<<<<<<<<[>>>+>+<<<<-]>>>>[<<<<+>>>>-]<-[>>.>.<<<\n" +
            "[-]]<<[>>+>+<<<-]>>>[<<<+>>>-]<<[<+>-]>[<+>-]<<<-]";
        assertThat(new BrainLuck(code).process(""), is(String.valueOf((char) (8 * 9))));

    }


    //    @Test
    public void testPibonachi() throws Exception {

        final char[] input = {10};
        String code = ",>+>>>>++++++++++++++++++++++++++++++++++++++++++++>++++++++++++++++++++++++++++++++<<<<<<[>[>>>>>>+>+<<<<<<<-]>>>>>>>[<<<<<<<+>>>>>>>-]<[>++++++++++[-<-[>>+>+<<<-]>>>[<<<+>>>-]+<[>[-]<[-]]>[<<[>>>+<<<-]>>[-]]<<]>>>[>>+>+<<<-]>>>[<<<+>>>-]+<[>[-]<[-]]>[<<+>>[-]]<<<<<<<]>>>>>[++++++++++++++++++++++++++++++++++++++++++++++++.[-]]++++++++++<[->-<]>++++++++++++++++++++++++++++++++++++++++++++++++.[-]<<<<<<<<<<<<[>>>+>+<<<<-]>>>>[<<<<+>>>>-]<-[>>.>.<<<[-]]<<[>>+>+<<<-]>>>[<<<+>>>-]<<[<+>-]>[<+>-]<<<-]";

        assertThat(new BrainLuck(code).process(String.valueOf(input[0]) ),is(String.valueOf((char) (8 * 9))));

    }



//    @Test
    public void testTwoNumbersMultiplier() {
        final char[] input = {8, 9};
        assertThat(new BrainLuck(",>,<[>[->+>+<<]>>[-<<+>>]<<<-]>>.").process(String.valueOf(input[0]) + String.valueOf(input[1])), is(String.valueOf((char) (input[0] * input[1]))));
    }
}
