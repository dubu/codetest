package com.dubu; /**
 * Created by rigel on 1/23/17.
 *
 *
 *
 * https://www.codewars.com/kata/whitespace-interpreter/train/java
 */
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

class WhitespaceInterpreter {


    // transforms space characters to ['s','t','n'] chars;
    public static String unbleach(String code) {
        return code != null ? code.replace(' ', 's').replace('\t', 't').replace('\n', 'n') : null;
    }

    public static String execute(String code , InputStream input , OutputStream output){

        System.out.println(unbleach(code));

        try {
            int i;
            StringBuffer buffer = new StringBuffer();
            byte[] b = new byte[4096];
            while( (i = input.read(b)) != -1){
                String s = new String(b, 0, i);
                System.out.println(s);
                buffer.append(s);
            }
            String str = buffer.toString();
            System.out.println(str);
        } catch (Exception e) {

            System.out.println("exception");
        }


        try {
            String execute = execute(code, null);
            output.write(Integer.parseInt("1"));
            output.flush();
            return execute;
        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            try {
                output.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "1";
    }


    // solution
    public static String execute(String code, InputStream input) {

        if ((code == null || code == "")) {
//            throw new ArrayIndexOutOfBoundsException();
            throw new NullPointerException("tre");
//            throw new Exception();
        }

//        parseNumber(code);

        String output = "";
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> heap = new HashMap<>();

        List<String> strList= parseStr(code);
        for (int i = 0; i < strList.size(); i++) {
            String str = strList.get(i);
            switch (str){
                case "ss" :
                    stack.push(Integer.valueOf(strList.get(i+1)));
                    break;
                case "sts" :
                    // Duplicate the nth value from the top of the stack.

                    Integer intVal= 0 ;
                    int numValue =Integer.valueOf(strList.get(i + 1));
                    if(numValue<0 ){
                       intVal = stack.get(-numValue);
                    }else{
                        intVal = stack.get(stack.size() - numValue -1);
                    }

                    stack.push(intVal);
                    break;
                case "stn" :
                    //discard
                    if(strList.size() <= i || strList.size()< 0){
                        stack.removeAllElements();

                    }else{
                        String num = strList.get(i+1);
                        if(num.contains("t")||num.contains("s")||num.contains("n")){
                            // pass

                        }else{
                            if (stack.empty()) {
                                // pass
                            }else{
                                Integer peek = stack.peek();
                                for (int j = 0; j < Integer.valueOf(num)+1; j++) {
                                    stack.pop();
                                }
                                stack.push(peek);
                            }
                        }
                    }


                    break;
                case "sns" :
                    if(stack.empty()){
                       // pass
                    }else{
                        Integer peek = stack.peek();
                        stack.push(peek);
                    }
                    break;
                case "snt" :
                    int temp;
                    Integer pop1 = stack.pop();
                    Integer pop2 = stack.pop();
                    stack.push(pop1);
                    stack.push(pop2);
                    break;
                case "snn" :
                    stack.pop();

                    break;


                case "tsss" :
                case "tsst" :
                case "tssn" :
                case "tsts" :
                case "tstt" :


                case "tts" :
                case "ttt" :


                case "tnss" :
                    // Pop a value off the stack and output it as a character.
                    if (stack.empty()) {
                       //pass
                    }else{
                        char a = (char) stack.pop().intValue();
                        output = String.valueOf(a);
                    }

                    break;
                case "tnst" :
                    output= output + String.valueOf(stack.pop().intValue());
                    break;
                case "tnts" :
                case "tntt" :

                case "nss" :
                    //Mark a location in the program with label n.
                    break;
                case "nts" :
                case "nsn" :

                    break;
                case "ntt" :
                case "ntn" :
                case "nnn":

                    break;
                default:
                    // number
                    break;




            }
        }


        String unbleach = unbleach(code);
        System.out.printf(unbleach);



        // ... you code ...
        return output;
    }

    public static List<String> parseStr(String str) {
        String code = unbleach(str);
//        System.err.println(code);
        List<String> strList = new ArrayList<>();

//        strList = strList.stream().filter(s -> s.equals("s") || s.equals("t") || s.equals("n")).collect(Collectors.toList());

        char[] chars = code.toCharArray();
        StringBuilder sb= new StringBuilder();
        boolean numberFlag = false;
        boolean labelFlag = false;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if(Arrays.asList('t','s','n').contains(aChar))
                sb.append(aChar);


            // number
            Pattern pattern = Pattern.compile("([s|t][st]{1,})n");
            Matcher matcher = pattern.matcher(sb.toString());
            if (matcher.find() && numberFlag) {
                matcher.group(0);
                String group = matcher.group(1);
                String sign = group.substring(0, 1);
                String numStr = group.substring(1);
                numStr = numStr.replaceAll("t", "1");
                numStr = numStr.replaceAll("s", "0");
                int num = Integer.parseInt(numStr, 2);

                if (sign.equals("t")) {
                    strList.add(String.valueOf(-num));
                } else {
                    strList.add(String.valueOf(num));
                }
                sb = new StringBuilder();
                numberFlag = false;
//                        System.err.println(i);
            } else {
//                        System.err.println("ERR");
            }

            switch (sb.toString()){
                case "ss":
                case "sts":
                case "stn":
                    if(numberFlag){
                        //pass
                    }else{
                        strList.add(sb.toString());
                        sb = new StringBuilder();
                        numberFlag = true;
                    }
                    break;
                case "sns":
                case "snt":
                case "snn":
                case "tsss":
                case "tsst":
                case "tssn":
                case "tsts":
                case "tstt":
                case "tts":
                case "ttt":
                case "tnss":
                case "tnst":
                case "tnts":
                case "tntt":
                    if(numberFlag){
                        //pass
                    }else {
                        strList.add(sb.toString());
                        sb = new StringBuilder();
                    }
                    break;
                case "nnn":
                    strList.add(sb.toString());
                    sb = new StringBuilder();
                    break;
                case "nss":
                case "nst":
                case "nts":
                case "ntt":
                case "ntn":
                    if(numberFlag){
                        //pass
                    }else{
                        strList.add(sb.toString());
                        sb = new StringBuilder();
                        labelFlag= true;
                    }
                    break;

                default:
//                    System.err.println("ERROR" + sb.toString());
                    break;
            }
        }
        if ((sb.toString().length()>0)) {
//            System.err.println("ERROR "+ sb.toString());
        }
//        strList.stream().forEach(System.err::println);
        return strList;
    }


}


public class WhitespaceInterpreterTest {

    @Test
    public void testPush() throws Exception {
        System.out.println("Testing push, output of numbers 0 through 3");
        String[][] tests = {
            {"   \t\n\t\n \t\n\n\n", "1"},
            {"   \t \n\t\n \t\n\n\n", "2"},
            {"   \t\t\n\t\n \t\n\n\n", "3"},
            {"    \n\t\n \t\n\n\n", "0"}
        };
        Arrays.stream(tests).forEach(s -> WhitespaceInterpreter.parseStr(s[0]));
        for (String[] test : tests) {
            assertEquals(test[1], WhitespaceInterpreter.execute(test[0], null));
        }
    }

    @Test
    public void testOutNumbers() throws Exception {
        System.out.println("Testing ouput of numbers -1 through -3");
        String[][] tests = {
            {"  \t\t\n\t\n \t\n\n\n", "-1"},
            {"  \t\t \n\t\n \t\n\n\n", "-2"},
            {"  \t\t\t\n\t\n \t\n\n\n", "-3"},
        };

        Arrays.stream(tests).forEach(s -> WhitespaceInterpreter.parseStr(s[0]));

        for (String[] test : tests) {
            assertEquals(test[1], WhitespaceInterpreter.execute(test[0], null));
        }
    }

    @Test(expected = Exception.class)
    public void testFlowEdge() throws Exception {
        System.out.println("Testing simple flow control edge case");
        WhitespaceInterpreter.execute("", null);
        throw  new ArrayIndexOutOfBoundsException();
    }

    @Test
    public void testOutLetters() throws Exception {
        System.out.println("Testing output of letters A through C");
        String[][] tests = {
            {"   \t     \t\n\t\n  \n\n\n", "A"},
            {"   \t    \t \n\t\n  \n\n\n", "B"},
            {"   \t    \t\t\n\t\n  \n\n\n", "C"},
        };
        Arrays.stream(tests).forEach(s -> WhitespaceInterpreter.parseStr(s[0]));
        for (String[] test : tests) {
            assertEquals(test[1], WhitespaceInterpreter.execute(test[0], null));
        }
    }

    @Test
    public void testOutLettersWithComments() throws Exception {
        System.out.println("Testing output of letters A through C with comments");
        String[][] tests = {
            {"blahhhh   \targgggghhh     \t\n\t\n  \n\n\n", "A"},
//            {" I heart \t  cats  \t \n\t\n  \n\n\n", "B"},   //wrong
            {"   \t  welcome  \t\t\n\t\n  o the\nnew\nworld\n", "C"},  // wrong
        };
        Arrays.stream(tests).forEach(s -> WhitespaceInterpreter.parseStr(s[0]));
        for (String[] test : tests) {
            assertEquals(test[1], WhitespaceInterpreter.execute(test[0], null));
        }
    }

    @Test
    public void testStack() throws Exception {
        System.out.println("Testing stack functionality");
        String[][] tests = {
            {"   \t\t\n   \t\t\n\t\n \t\t\n \t\n\n\n", "33"},
            {"   \t\t\n \n \t\n \t\t\n \t\n\n\n", "33"},
            {"   \t\n   \t \n   \t\t\n \t  \t \n\t\n \t\n\n\n", "1"},
            {"   \t\n   \t \n   \t\t\n \t  \t\n\t\n \t\n\n\n", "2"},
            {"   \t\n   \t \n   \t\t\n \t   \n\t\n \t\n\n\n", "3"},
            {"   \t\t\n   \t \n \n\t\t\n \t\t\n \t\n\n\n", "32"},
            {"   \t\t\n   \t \n \n\t \n\n\t\n \t\n\n\n", "2"},
            {"   \t\t\n   \t \n   \t\n   \t  \n   \t\t \n   \t \t\n   \t\t\t\n \n\t \t\n \t\t\n\t\n \t\t\n \t\t\n \t\t\n \t\n\n\n", "5123"},
        };

        Arrays.stream(tests).forEach(s -> WhitespaceInterpreter.parseStr(s[0]));

        for (String[] test : tests) {
            assertEquals(test[1], WhitespaceInterpreter.execute(test[0], null));
        }
    }


    @Test
    public void testNumberParse() throws Exception {
        String code =  "   \t\t\n \n \t\n \t\t\n \t\n\n\n";
        WhitespaceInterpreter.parseStr(code);


    }


    @Test
    public void testTwoNumberChar() throws Exception {

        int i = Integer.parseInt("0100100010", 2);
        System.out.println(256- i%256);

    }


    @Test
    public void TestThreeArgu() throws Exception {
        String[][] tests = {
                {"   \t\t\n   \t\t\n\t\n \t\t\n \t\n\n\n", "33"},
                {"   \t\t\n \n \t\n \t\t\n \t\n\n\n", "33"},
                {"   \t\n   \t \n   \t\t\n \t  \t \n\t\n \t\n\n\n", "1"},
                {"   \t\n   \t \n   \t\t\n \t  \t\n\t\n \t\n\n\n", "2"},
                {"   \t\n   \t \n   \t\t\n \t   \n\t\n \t\n\n\n", "3"},
                {"   \t\t\n   \t \n \n\t\t\n \t\t\n \t\n\n\n", "32"},
                {"   \t\t\n   \t \n \n\t \n\n\t\n \t\n\n\n", "2"},
                {"   \t\t\n   \t \n   \t\n   \t  \n   \t\t \n   \t \t\n   \t\t\t\n \n\t \t\n \t\t\n\t\n \t\t\n \t\t\n \t\t\n \t\n\n\n", "5123"},
        };
        InputStream input  = null;
        OutputStream stream = null;
        String output = WhitespaceInterpreter.execute("       ", input, stream);

    }

    @Test
    public void testPass() throws Exception {

       String str = "ssstntnstnnn";
       String[] strArr = {"ssstntnstnnn"};
        String[] strNull = {};
//       com.dubu.WhitespaceInterpreter.execute("ssttnsssnssstnssstsnsssttnnssntnstsnsnttsnnsnnnsssnnnn", null, null);
//        assertEquals(1, com.dubu.WhitespaceInterpreter.execute(null, null, null));
//        assertEquals(1, com.dubu.WhitespaceInterpreter.execute(str, null, null));

//        com.dubu.WhitespaceInterpreter.execute("nsssnssstntnstnnnntnnnn", null, null);
        WhitespaceInterpreter.execute("ssstnssstnssstsnttsttttnstnssstnssstsnttstttnnn", null, null);
    }
}
