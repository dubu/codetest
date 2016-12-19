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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class SecretRecoveryTest {

    private SecretDetective detective;

    @Before public void setup() {
        detective = new SecretDetective();
    }

    @Test public void secret1() {
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
    }
}

class SecretDetective {

    public String recoverSecret(char[][] triplets) {


        List<String> rsList = new ArrayList<>();

//        Map<Integer,String> rsMap = new HashMap<>();

        for (int i = 0; i < triplets.length; i++) {

            char[] triplet = triplets[i];

            List<String> shortWord = new ArrayList<>();
            for (int j = 0; j < triplet.length; j++) {
                char c = triplet[j];
                shortWord.add(String.valueOf(c));
            }


            if(i > 0){
                String lEdge =  rsList.get(0);
                String rEdge =  rsList.get(rsList.size()-1);

                // left expand
                if(shortWord.indexOf(lEdge) !=  -1){
                    int idx = shortWord.indexOf(lEdge);
                    if(idx == 2 ){

                        rsList.add(0,shortWord.get(0));
                        rsList.add(0,shortWord.get(1));
                    }else if(idx == 1){
                        rsList.add(0,shortWord.get(0));
                    }
                }

            }



            Character[] values = { 1, 3, 7 };
            List<Character> list = Arrays.asList(values);


            if(i == 0) {
                for (int j = 0; j < triplet.length; j++) {
                    char c = triplet[j];

//                rsMap.put((int) c,String.valueOf(c));
                    rsList.add(String.valueOf(c));

                }
            }

        }




        String collect = rsList
            .stream()
            .map(s -> s)
            .collect(Collectors.joining());

        System.out.println(collect);
        return collect;
    }

}