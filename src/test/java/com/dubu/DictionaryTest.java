package com.dubu;

/**
 * Created by rigel on 12/13/16.
 *
 * https://www.codewars.com/kata/did-you-mean-dot-dot-dot/train/java
 *
 *
 */
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

class Dictionary {
    private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

    public String findMostSimilar(String to) {

        // exatly same


        // count word


        // positon

        return null;
    }
}

public class DictionaryTest {

    @Test
    public void testRegx() throws Exception {
//        String str = "cherry";
        String[] strings = {"cherry", "pineapple", "melon", "strawberry", "raspberry"};

        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];

            Pattern pattern = Pattern.compile("[^berry]*([berry]*)[^berry]*");
            Matcher matcher = pattern.matcher(str);

            while(matcher.find() && matcher.group(1).length() > 0){
//            System.out.println(matcher.group());
//            System.out.println(matcher.group(0));
                if ((matcher.groupCount() > 0)) {

                    System.err.println(String.format("%s %s %s %s ",str, matcher.group(1) ,matcher.group(1).length()  ,str.length()- matcher.group(1).length()));
                }

            }
        }

    }

    @Test
    public void testBerries() {
        Dictionary dictionary = new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});
        assertEquals("strawberry", dictionary.findMostSimilar("strawbery"));
        assertEquals("cherry", dictionary.findMostSimilar("berry"));
    }

    @Test
    public void testLanguages() {
        Dictionary dictionary = new Dictionary(new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
        assertEquals("java", dictionary.findMostSimilar("heaven"));
        assertEquals("javascript", dictionary.findMostSimilar("javascript"));
    }

}

