/**
 * Created by rigel on 1/23/17.
 */
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class WhitespaceInterpreter {

    // transforms space characters to ['s','t','n'] chars;
    public static String unbleach(String code) {
        return code != null ? code.replace(' ', 's').replace('\t', 't').replace('\n', 'n') : null;
    }

    // solution
    public static String execute(String code, InputStream input) {

        if ((code.length() == 0 )) {
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
                           for (int j = 0; j < Integer.valueOf(num); j++) {
                               stack.pop();
                           }
                       }
                   }


                   break;
               case "snt" :
               case "snn" :

               case "tsss" :
               case "tsst" :
               case "tssn" :
               case "tsts" :
               case "tstt" :

               case "tts" :
               case "ttt" :

               case "tnss" :
                   char a = (char) stack.pop().intValue();
                   output = String.valueOf(a);
                   break;
               case "tnst" :
                   output= String.valueOf((char)stack.pop().intValue());
                   break;
               case "tnts" :
               case "tntt" :

               case "nss" :
               case "nts" :
               case "nsn" :
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
        System.err.println(code);
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
                        System.err.println("ERROR "+ sb.toString());
        }
        strList.stream().forEach(System.err::println);
        return strList;
    }

    public static void parseNumber(String code) {
        Pattern pattern = Pattern.compile("[ss|sts|stn]([s|t][st]{1,})n");
        Matcher matcher = pattern.matcher(code);
        while (matcher.find()) {
            matcher.group(0);
            String group = matcher.group(1);
            group.substring(0,1);
            String num = group.substring(1);
            int i = Integer.parseInt(num, 2);
            System.err.println(i);

        }
    }

}


public class WhitespaceInterpreterTest {

    @Test
    public void testPush() {
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
    public void testOutNumbers() {
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

//    @Test(expected = Exception.class)
    public void testFlowEdge() {
        System.out.println("Testing simple flow control edge case");
        WhitespaceInterpreter.execute("", null);
    }

    @Test
    public void testOutLetters() {
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
    public void testOutLettersWithComments() {
        System.out.println("Testing output of letters A through C with comments");
        String[][] tests = {
            {"blahhhh   \targgggghhh     \t\n\t\n  \n\n\n", "A"},
//            {" I heart \t  cats  \t \n\t\n  \n\n\n", "B"},
            {"   \t  welcome  \t\t\n\t\n to the\nnew\nworld\n", "C"},
        };
        Arrays.stream(tests).forEach(s -> WhitespaceInterpreter.parseStr(s[0]));
        for (String[] test : tests) {
            assertEquals(test[1], WhitespaceInterpreter.execute(test[0], null));
        }
    }

    @Test
    public void testStack() {
        System.out.println("Testing stack functionality");
        String[][] tests = {
            {"   \t\t\n   \t\t\n\t\n \t\t\n \t\n\n\n", "33"},
//            {"   \t\t\n \n \t\n \t\t\n \t\n\n\n", "33"},
//            {"   \t\n   \t \n   \t\t\n \t  \t \n\t\n \t\n\n\n", "1"},
//            {"   \t\n   \t \n   \t\t\n \t  \t\n\t\n \t\n\n\n", "2"},
//            {"   \t\n   \t \n   \t\t\n \t   \n\t\n \t\n\n\n", "3"},
//            {"   \t\t\n   \t \n \n\t\t\n \t\t\n \t\n\n\n", "32"},
//            {"   \t\t\n   \t \n \n\t \n\n\t\n \t\n\n\n", "2"},
//            {"   \t\t\n   \t \n   \t\n   \t  \n   \t\t \n   \t \t\n   \t\t\t\n \n\t \t\n \t\t\n\t\n \t\t\n \t\t\n \t\t\n \t\n\n\n", "5123"},
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
}
