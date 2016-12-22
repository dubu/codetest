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
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

class SecretDetective {

    public String recoverSecret(char[][] triplets) {


        List<String> rsList = new ArrayList<>();
        List<List<String>> tmpRss = new ArrayList<>();

        List<List<String>> validList = new ArrayList<>();
        List<List<String>> modList = new ArrayList<>();


//        Map<Integer,String> rsMap = new HashMap<>();

        for (int i = 0; i < triplets.length; i++) {

            char[] triplet = triplets[i];

            List<String> shortWord = new ArrayList<>();
            for (int j = 0; j < triplet.length; j++) {
                char c = triplet[j];
                shortWord.add(String.valueOf(c));
            }
            String debug = shortWord
                .stream()
                .map(s -> s)
                .collect(Collectors.joining());

            System.out.println(debug);

//            validList.add(shortWord);


            for (int j = 0; j < triplet.length; j++) {
                char c = triplet[j];

//                rsMap.put((int) c,String.valueOf(c));
                rsList.add(String.valueOf(c));
            }

        }


//        for (int i = 0; i < validList.size(); i++) {


        while (validList.size() != 0) {


            for (int i = 0; i < validList.size(); i++) {
                List<String> strings = validList.get(i);

                int valCnt = 0;
                for (int j = 0; j < strings.size(); j++) {
                    String s = strings.get(j);

                    if (rsList.contains(s)) {
                        valCnt++;
                    }

                }

                String el0 = strings.get(0);
                String el1 = strings.get(1);
                String el2 = strings.get(2);

                if (valCnt == 3) {
                    if (rsList.indexOf(el2) > rsList.indexOf(el1) && rsList.indexOf(el1) > rsList.indexOf(el0)) {
                        validList.remove(strings);
                    }


                }else if (valCnt == 2) {

                    // 남은게
                    // 맨왼쪽
                    // 중간
                    // 맨오른쪽

                    if(!rsList.contains(el0)){
                        int pos = rsList.indexOf(el1);
                        rsList.set(pos, el0);

                    }else if(!rsList.contains(el1)){
                        int pos = rsList.indexOf(el2);
                        rsList.set(pos, el1);

                    }else if(!rsList.contains(el2)){
                        int pos = rsList.indexOf(el1);
                        rsList.set(pos+1, el2);
                    }

                    validList.remove(strings);


                }else if (valCnt == 1) {
                    // 일치하는거 기준
                    // 맨왼쪽일때
                    // 맨오른쪽

                    if(rsList.contains(el0)){
                        int pos = rsList.indexOf(el0);
                        rsList.set(pos+1, el2);
                        rsList.set(pos+1, el1);

                    }else if(rsList.contains(el1)){
                        int pos = rsList.indexOf(el1);
                        rsList.set(pos+1, el2);
                        rsList.set(pos, el0);

                    }else if(rsList.contains(el2)){
                        int pos = rsList.indexOf(el2);
                        rsList.set(pos, el1);
                        rsList.set(pos, el0);
                    }

                    validList.remove(strings);


                }else if (valCnt == 0) {
                    // pass
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

public class SecretRecoveryTest {

    private SecretDetective detective;

    @Before public void setup() {
        detective = new SecretDetective();
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

