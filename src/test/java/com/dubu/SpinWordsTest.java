package com.dubu;

/**
 * Created by dubu on 2016-12-24.
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;

class SpinWords {

    public String spinWords(String sentence) {
        StringBuilder builder = new StringBuilder();
        String[] split = sentence.split("\\s");

        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            StringBuilder sb = null;
            if(i>0){
                builder.append(" ");
            }
            if (s.length() > 4) {
                sb = new StringBuilder(s).reverse();
                builder.append(String.valueOf(sb));
            }else{
                builder.append(s);
            }

        }
        return builder.toString();
    }
}

public class SpinWordsTest {
    @Test
    public void test() {
        assertEquals("emocleW", new SpinWords().spinWords("Welcome"));
        assertEquals("Hey wollef sroirraw", new SpinWords().spinWords("Hey fellow warriors"));
    }

}

