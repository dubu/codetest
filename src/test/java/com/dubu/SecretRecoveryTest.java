package com.dubu;

/**
 * Created by rigel on 12/19/16.
 *
 * level 4
 * https://www.codewars.com/kata/recover-a-secret-string-from-random-triplets/train/java
 *
 */
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class SecretDetective {

    public String recoverSecret(char[][] triplets) {

        //regx


        List<String> integers = Arrays.asList("a","b","c");


        System.out.println(integers.stream().collect(Collectors.joining(":")));

//        .collect(Collectors.joining());

        return null;
    }

}

public class SecretRecoveryTest {

    private SecretDetective detective;

    @Before public void setup() {
        detective = new SecretDetective();
    }


    @Test
    public void testRegx() throws Exception {

        // pattern.compile
        // string
        // matcher


        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("abd");
        arrayList.add("cad");


        Pattern pattern = Pattern.compile("a[bc]d");

        Matcher matcher = pattern.matcher(arrayList.get(1));

        System.out.println(matcher.find());



    }

    @Test public void secret1() {

        /*
        char[][] triplets = {
            {'t','u','p'},
            {'w','h','i'},
            {'t','s','u'},
            {'a','t','s'},
            {'h','a','p'},
            {'t','i','s'},
            {'w','h','s'}
        };
        assertEquals("whatisup", detective.recoverSecret(triplets));
*/
/*

        char[][] triplets = {
            {'t','s','f'},
            {'a','s','u'},
            {'m','a','f'},
            {'a','i','n'},
            {'s','u','n'},
            {'m','f','u'},
            {'a','t','h'},
            {'t','h','i'},
            {'h','i','f'},
            {'m','h','f'},
            {'a','u','n'},
            {'m','a','t'},
            {'f','u','n'},
            {'h','s','n'},
            {'a','i','s'},
            {'m','s','n'},
            {'m','s','u'},
        };
        assertEquals("mathisfun", detective.recoverSecret(triplets));

*/



        char[][] triplets = {
            {'g','a','s'},
            {'o','g','s'},
            {'c','n','t'},
            {'c','o','n'},
            {'a','t','s'},
            {'g','r','t'},
            {'r','t','s'},
            {'c','r','a'},
            {'g','a','t'},
            {'n','g','s'},
            {'o','a','s'},

        };
        assertEquals("congrats", detective.recoverSecret(triplets));

    }
}

