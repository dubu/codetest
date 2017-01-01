package com.dubu;

/**
 * Created by rigel on 12/13/16.
 * <p>
 * https://www.codewars.com/kata/did-you-mean-dot-dot-dot/train/java
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Dictionary {
    private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

    public String findMostSimilar(String to) {

//        String str = "cherry";
//        String[] strings = {"cherry", "pineapple", "melon", "strawberry", "raspberry"};
        String[] strings = words;

        int storeInt =  Integer.MAX_VALUE;
        String storeStr = "";
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];

        //    String to = "coddwars";
            String formatStr = String.format("[^%s]*([%s]*)[^%s]*",to,to,to);
            Pattern pattern = Pattern.compile(formatStr);
            Matcher matcher = pattern.matcher(str);

            int matchCnt  = 0 ;
            while (matcher.find() && matcher.group(1).length() > 0) {
//            System.out.println(matcher.group());
//            System.out.println(matcher.group(0));
                if ((matcher.groupCount() > 0)) {
//                    int diff = str.length() - matcher.group(1).length();

                    matchCnt =  matchCnt + matcher.group(1).length();
                    System.err.println(String.format("%s %s %s %s ", str, matcher.group(1), matcher.group(1).length(), storeStr));
                }

            }
//            if (matchCnt > storeInt) {
//                storeInt = matchCnt;
//                storeStr = str;
//            } else if (matchCnt == storeInt && str.length() < storeStr.length()) {
//                storeInt = matchCnt;
//                storeStr = str;
//            }
            if(to.length() >= matchCnt  && to.length() - matchCnt <= storeInt ){
                storeInt = to.length() - matchCnt;
                storeStr = str;
            }else if(to.length() >= matchCnt  && to.length() - matchCnt == storeInt && storeStr.length() > str.length()){
                storeInt = to.length() - matchCnt;
                storeStr = str;
            }

        }
        System.out.println(storeStr);

        return storeStr;
    }
}

public class DictionaryTest {

    @Test
    public void testRegx() throws Exception {
//        String str = "cherry";
        String[] strings = {"codewars", "wars"};

        int storeInt =  0;
        String storeStr = "";
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];

            String to = "coddwars";
            String formatStr = String.format("[^%s]*([%s]*)[^%s]*",to,to,to);
            Pattern pattern = Pattern.compile(formatStr);
            Matcher matcher = pattern.matcher(str);

            int matchCnt  = 0 ;
            while (matcher.find() && matcher.group(1).length() > 0) {
//            System.out.println(matcher.group());
//            System.out.println(matcher.group(0));
                if ((matcher.groupCount() > 0)) {
//                    int diff = str.length() - matcher.group(1).length();

                    matchCnt =  matchCnt + matcher.group(1).length();
                }

            }
            if (matchCnt > storeInt) {
                storeInt = matchCnt;
                storeStr = str;
                    System.err.println(String.format("%s %s %s %s ", str, matcher.group(1), matcher.group(1).length(), storeStr));
            }

        }
        System.out.println(storeStr);

    }

    @Test
    public void testBerries() {
        Dictionary dictionary = new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});
        assertEquals("strawberry", dictionary.findMostSimilar("strawbery"));
//        assertEquals("cherry", dictionary.findMostSimilar("berry"));
    }

    @Test
    public void testLanguages() {
        Dictionary dictionary = new Dictionary(new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
        assertEquals("java", dictionary.findMostSimilar("heaven"));
        assertEquals("javascript", dictionary.findMostSimilar("javascript"));
    }

    @Test
    public void testpass() {
        Dictionary dictionary = new Dictionary(new String[]{"codewars", "wars"});
        assertEquals("codewars", dictionary.findMostSimilar("coddwars"));
    }
}

