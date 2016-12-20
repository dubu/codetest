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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

                // insert
                if(rsList.contains(shortWord.get(0)) && rsList.contains(shortWord.get(2))){

                    if(rsList.indexOf(shortWord.get(2)) - rsList.indexOf(shortWord.get(0)) == 1){
                        rsList.add(rsList.indexOf(shortWord.get(2)),shortWord.get(1));
                    }


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


//        for (int i = 0; i < validList.size(); i++) {


        while(validList.size() != 0) {
            int chkCnt =  validList.size() + rsList.size();
//            int chkCnt =  validList.size() ;


            for (int i = 0; i < validList.size(); i++) {
                List<String> strings = validList.get(i);

                int valCnt = 0;
                for (int j = 0; j < strings.size(); j++) {
                    String s = strings.get(j);

                    if (rsList.contains(s)) {
                        valCnt++;
                    }

                }
                if (valCnt == 3) {
                    if(rsList.indexOf(strings.get(2)) >rsList.indexOf(strings.get(1)) && rsList.indexOf(strings.get(1)) >rsList.indexOf(strings.get(0))){
                        validList.remove(strings);
                    }


                }

//                chkCnt = validList.size() ;

            }

            // having hang up
            if(chkCnt == validList.size() + rsList.size() && tmpRss.size() == 0){

//                if(tmpRss.size() > 0){
//                    rsList = tmpRss.remove(0);
//                    continue;
//                }


                for (int j = 0; j < validList.size(); j++) {
                    List<String> stringList = validList.get(j);

                    if(rsList.contains(stringList.get(0)) && rsList.contains(stringList.get(2))&& !rsList.contains(stringList.get(1)) ){
                        modList.add(stringList);
                    }
                }
                // sort
                final List<String> finalRsList = rsList;
                Collections.sort(modList, new Comparator<List<String>>() {
                    @Override
                    public int compare(List<String> o1, List<String> o2) {
                        return (finalRsList.indexOf(o1.get(2))- finalRsList.indexOf(o1.get(0))) - (finalRsList.indexOf(o2.get(2))- finalRsList.indexOf(o2.get(0)));
                    }
                });

//                System.out.println(modList);

                int mLift = rsList.indexOf(modList.get(0).get(0));
                int mRight = rsList.indexOf(modList.get(0).get(2));


                for (int i = mLift; i < mRight ; i++) {
                    List possibleAnswer = new ArrayList(rsList);
                    possibleAnswer.add(i+1, modList.get(0).get(1));
                    tmpRss.add(possibleAnswer);
//                    System.out.println(possibleAnswer);
                }
                rsList = tmpRss.remove(0);


            }
//            else if(tmpRss.size() > 0){
//                rsList = tmpRss.remove(0);
//
//            }




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

