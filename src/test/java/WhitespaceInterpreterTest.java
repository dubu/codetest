/**
 * Created by rigel on 1/23/17.
 */
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

 class WhitespaceInterpreter {

    // transforms space characters to ['s','t','n'] chars;
    public static String unbleach(String code) {
        return code != null ? code.replace(' ', 's').replace('\t', 't').replace('\n', 'n') : null;
    }

    // solution
    public static String execute(String code, InputStream input) {


        /*

ss stn tnst nnn 1

       1.s  stack
       ss[num]
       sts[num]
       stn[num]
       sns
       snt
       snn


       2.ts math
       tsss
       tsst
       tssn
       tsts
       tstt

       3.tt  heap access
       tts
       ttt

       4.tn in/ output
       tnss
       tnst
       tnts
       tntt

       5.n  flow
       nss[label]
       nst[label]
       nsn[label]
       nts[label]
       ntt[label]
       ntn[label]
       nnn


       sign
       t[num]n = -3
       s[num]n = +3


       number
       sn = 0
       tn = 0

       tssn =  00
       tssssn = 0000
       ttstsn = 1010

      label
      tts
      sssssss
      ts


         */


        String unbleach = unbleach(code);
        System.out.printf(unbleach);


        String output = "";
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> heap = new HashMap<>();
        // ... you code ...
        return output;
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
        for (String[] test : tests) {
            assertEquals(test[1], WhitespaceInterpreter.execute(test[0], null));
        }
    }

    @Test(expected = Exception.class)
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
        for (String[] test : tests) {
            assertEquals(test[1], WhitespaceInterpreter.execute(test[0], null));
        }
    }

    @Test
    public void testOutLettersWithComments() {
        System.out.println("Testing output of letters A through C with comments");
        String[][] tests = {
            {"blahhhh   \targgggghhh     \t\n\t\n  \n\n\n", "A"},
            {" I heart \t  cats  \t \n\t\n  \n\n\n", "B"},
            {"   \t  welcome  \t\t\n\t\n to the\nnew\nworld\n", "C"},
        };
        for (String[] test : tests) {
            assertEquals(test[1], WhitespaceInterpreter.execute(test[0], null));
        }
    }

    @Test
    public void testStack() {
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
        for (String[] test : tests) {
            assertEquals(test[1], WhitespaceInterpreter.execute(test[0], null));
        }
    }
}
