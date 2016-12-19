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
import java.util.List;
import java.util.stream.Collectors;

class SecretDetective {

    public String recoverSecret(char[][] triplets) {


        List<String> rsList = new ArrayList<>();

        List<List<String>> validList = new ArrayList<>();


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

            validList.add(shortWord);


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

                // right expand
                if(shortWord.indexOf(rEdge) !=  -1){
                    int idx = shortWord.indexOf(rEdge);
                    if(idx == 0 ){

                        rsList.add(shortWord.get(1));
                        rsList.add(shortWord.get(2));
                    }else if(idx == 1){
                        rsList.add(shortWord.get(2));
                    }
                }

//                if(rsList.indexOf(shortWord.get(2)) - rsList.indexOf(shortWord.get(0)) == 2 && rsList.indexOf(shortWord.get(1)) - rsList.indexOf(shortWord.get(0)) == 1 ){

                if(false){

                }else{
                    // insert
                    if(rsList.contains(shortWord.get(0)) && rsList.contains(shortWord.get(2))){

                        if(rsList.indexOf(shortWord.get(2)) - rsList.indexOf(shortWord.get(0)) == 1){
                            rsList.add(rsList.indexOf(shortWord.get(2)),shortWord.get(1));
                        }


                    }

                    // add right
//                    if(rsList.contains(shortWord.get(0)) && rsList.contains(shortWord.get(1))){
//
//                        if(rsList.indexOf(shortWord.get(1)) - rsList.indexOf(shortWord.get(0)) == 1){
//                            rsList.add(rsList.indexOf(shortWord.get(1)),shortWord.get(2));
//                        }
//
//                    }

                    // add left
//                    if(rsList.contains(shortWord.get(1)) && rsList.contains(shortWord.get(2))){
//
//                        if(rsList.indexOf(shortWord.get(2)) - rsList.indexOf(shortWord.get(1)) == 1){
//                            rsList.add(rsList.indexOf(shortWord.get(1)),shortWord.get(0));
//                        }
//
//                    }
                }


            }

            if(i == 0) {
                for (int j = 0; j < triplet.length; j++) {
                    char c = triplet[j];

//                rsMap.put((int) c,String.valueOf(c));
                    rsList.add(String.valueOf(c));

                }
            }

        }


        for (int i = 0; i < validList.size(); i++) {
            List<String> strings = validList.get(i);

            int valCnt = 0;
            for (int j = 0; j < strings.size(); j++) {
                String s = strings.get(j);

                if (rsList.contains(s)) {
                    valCnt++;
                }

            }
            if(valCnt == 3){
                validList.remove(strings);
            }

            if(valCnt == 2){

            }

            if(valCnt == 1){

                if (rsList.contains(strings.get(0))) {
                    rsList.add(rsList.indexOf(strings.get(0))+1,strings.get(1));
                    rsList.add(rsList.indexOf(strings.get(0))+2,strings.get(2));
                }else if (rsList.contains(strings.get(2))) {
                    rsList.add(rsList.indexOf(strings.get(2)),strings.get(0));
                    rsList.add(rsList.indexOf(strings.get(2)),strings.get(1));
                }

            }

        }

        // mod input re calculate




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
//        char[][] triplets = {
//            {'t','u','p'},
//            {'w','h','i'},
//            {'t','s','u'},
//            {'a','t','s'},
//            {'h','a','p'},
//            {'t','i','s'},
//            {'w','h','s'}
//        };


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

//        assertEquals("whatisup", detective.recoverSecret(triplets));
        assertEquals("mathisfun", detective.recoverSecret(triplets));
    }
}

