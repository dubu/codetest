package com.dubu;

/**
 * Created by rigel on 12/19/16.
 * <p>
 * level 4
 * https://www.codewars.com/kata/recover-a-secret-string-from-random-triplets/train/java
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

            for (int j = 0; j < triplet.length; j++) {
                char c = triplet[j];

//                rsMap.put((int) c,String.valueOf(c));
//                rsList.add(String.valueOf(c));
            }

            if (i == 0) {
                for (int j = 0; j < triplet.length; j++) {
                    char c = triplet[j];

//                rsMap.put((int) c,String.valueOf(c));
                    rsList.add(String.valueOf(c));

                }
            }


            if (i > 0) {
                String lEdge = rsList.get(0);
                String rEdge = rsList.get(rsList.size() - 1);

                // left expand
                if (shortWord.indexOf(lEdge) != -1) {
                    int idx = shortWord.indexOf(lEdge);
                    if (idx == 2) {

                        rsList.add(0, shortWord.get(0));
                        rsList.add(0, shortWord.get(1));
                    } else if (idx == 1) {
                        rsList.add(0, shortWord.get(0));
                    }
                }

                // right expand
                if (shortWord.indexOf(rEdge) != -1) {
                    int idx = shortWord.indexOf(rEdge);
                    if (idx == 0) {

                        rsList.add(shortWord.get(1));
                        rsList.add(shortWord.get(2));
                    } else if (idx == 1) {
                        rsList.add(shortWord.get(2));
                    }
                }

//                if(rsList.indexOf(shortWord.get(2)) - rsList.indexOf(shortWord.get(0)) == 2 && rsList.indexOf(shortWord.get(1)) - rsList.indexOf(shortWord.get(0)) == 1 ){

                // insert
                if (rsList.contains(shortWord.get(0)) && rsList.contains(shortWord.get(2))) {

                    if (rsList.indexOf(shortWord.get(2)) - rsList.indexOf(shortWord.get(0)) == 1) {
                        rsList.add(rsList.indexOf(shortWord.get(2)), shortWord.get(1));
                    }


                }


            }


        }


//        for (int i = 0; i < validList.size(); i++) {


        modList = new ArrayList(validList);
        while (modList.size() != 0) {
            modList = new ArrayList(validList);
//            validList = new ArrayList<>(modList);

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

                int posEl0 = rsList.indexOf(el0);
                int posEl1 = rsList.indexOf(el1);
                int posEl2 = rsList.indexOf(el2);

                if (valCnt == 3) {

                    List<Integer> idxList = Arrays.asList(posEl0, posEl1, posEl2);
                    Collections.sort(idxList);

                    if (rsList.indexOf(el2) > rsList.indexOf(el1) && rsList.indexOf(el1) > rsList.indexOf(el0)) {
                        modList.remove(strings);
                    } else if (posEl0 < posEl1 && posEl0 < posEl2) {

                        // 맨왼쪽 맞는경우
                        //switch

                        rsList.remove(el1);
                        rsList.set(idxList.get(1), el1);
                        rsList.add(idxList.get(1) + 1, el2);

                    } else if (posEl2 > posEl1 && posEl2 > posEl1) {
                        // 맨오른쪽만 맞는경우

                        rsList.remove(el0);
                        rsList.set(idxList.get(0), el0);
                        rsList.add(idxList.get(0) + 1, el1);


                    } else if (!(posEl2 > posEl1 && posEl1 > posEl0)) {

//                        System.err.println("all error:" + strings);
                        rsList.set(idxList.get(0), el0);
                        rsList.set(idxList.get(1), el1);
                        rsList.set(idxList.get(2), el2);

                    } else {
                        System.err.println("etc1");
                    }

//                    else if(rsList.indexOf(el2) < rsList.indexOf(el1) && rsList.indexOf(el1) > rsList.indexOf(el0)) {
//                        // 맨왼쪽이 틀린경우
//                        rsList.set(posEl1, el0);
//
//                    }


                } else if (valCnt == 2) {

                    // 남은게
                    // 맨왼쪽
                    // 중간
                    // 맨오른쪽
                    if (!rsList.contains(el0)) {

                        if (posEl1 > posEl2) {
                            rsList.set(posEl1, el2);
                            rsList.set(posEl2, el1);
                        }

//                        int pos = rsList.indexOf(el1);
                        rsList.add(posEl1, el0);


                    } else if (!rsList.contains(el1)) {

                        if (posEl0 > posEl2) {
                            rsList.set(posEl0, el2);
                            rsList.set(posEl2, el0);
                        }

//                        int pos = rsList.indexOf(el2);
                        rsList.add(posEl0 + 1, el1);


                    } else if (!rsList.contains(el2)) {
                        int pos = rsList.indexOf(el1);
                        rsList.add(pos + 1, el2);

                        if (posEl0 > posEl1) {
                            rsList.set(posEl0, el1);
                            rsList.set(posEl1, el0);

                        }
                    } else {
                        System.err.println("etc2");
                    }

                    modList.remove(strings);


                } else if (valCnt == 1) {
                    // 일치하는거 기준
                    // 맨왼쪽일때
                    // 맨오른쪽

                    /*

                    if(rsList.contains(el0)){
                        int pos = rsList.indexOf(el0);

                        rsList.add(pos + 1, el2);
                        rsList.add(pos + 1, el1);


                    }else if(rsList.contains(el1)){
                        int pos = rsList.indexOf(el1);
                        rsList.add(pos+1, el2);
                        rsList.add(pos, el0);

                    }else if(rsList.contains(el2)){
                        int pos = rsList.indexOf(el2);
                        rsList.add(pos, el1);
                        rsList.add(pos, el0);
                    }

                    modList.remove(strings);

*/
                } else if (valCnt == 0) {
                    // pass
                }


//                System.out.println(rsList + "      "+ strings  );

            }


        }

        String collect = rsList
                .stream()
                .map(s -> s)
                .collect(Collectors.joining());

        // System.out.println(collect);
        return collect;
    }

}

public class SecretRecoveryTest {

    private SecretDetective detective;

    @Before
    public void setup() {
        detective = new SecretDetective();
    }

    @Test
    public void secret1() {

//
//        char[][] triplets = {
//            {'t','u','p'},
//            {'w','h','i'},
//            {'t','s','u'},
//            {'a','t','s'},
//            {'h','a','p'},
//            {'t','i','s'},
//            {'w','h','s'}
//        };
//        assertEquals("whatisup", detective.recoverSecret(triplets));


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


//
//        char[][] triplets = {
//            {'g','a','s'},
//            {'o','g','s'},
//            {'c','n','t'},
//            {'c','o','n'},
//            {'a','t','s'},
//            {'g','r','t'},
//            {'r','t','s'},
//            {'c','r','a'},
//            {'g','a','t'},
//            {'n','g','s'},
//            {'o','a','s'},
//
//        };
//        assertEquals("congrats", detective.recoverSecret(triplets));
//


        char[][] triplets = {
                {'o', 'x', 'y'},
                {'h', 'r', 'u'},
                {'b', 'x', 'z'},
                {'r', 'y', 'z'},
                {'v', 'y', 'z'},
                {'v', 'w', 'y'},
                {'o', 's', 'y'},
                {'i', 'u', 'z'},
                {'q', 'y', 'z'},
                {'k', 'p', 'v'},
                {'w', 'x', 'z'},
                {'k', 'x', 'y'},
                {'r', 'w', 'x'},
                {'a', 'n', 'w'},
                {'b', 'd', 't'},
                {'p', 'u', 'y'},
                {'n', 'v', 'z'},
                {'f', 'k', 'q'},
                {'i', 'm', 'z'},
                {'a', 'w', 'y'},
                {'b', 'k', 'n'},
                {'t', 'u', 'w'},
                {'x', 'y', 'z'},
                {'f', 'g', 'j'},
                {'n', 'y', 'z'},
                {'s', 'y', 'z'},
                {'k', 'w', 'x'},
                {'m', 's', 'u'},
                {'h', 'i', 's'},
                {'q', 'w', 'z'},
                {'w', 'y', 'z'},
                {'j', 'o', 'p'},
                {'r', 'v', 'y'},
                {'h', 'p', 'w'},
                {'s', 't', 'z'},
                {'j', 'k', 'r'},
                {'n', 'u', 'w'},
                {'h', 'v', 'w'},
                {'t', 'u', 'y'},
                {'l', 'q', 'y'},
                {'v', 'w', 'x'},
                {'r', 'w', 'z'},
                {'m', 'o', 'w'},
                {'k', 'q', 'x'},
                {'e', 'h', 'r'},
                {'e', 'k', 'l'},
                {'d', 'h', 'p'},
                {'r', 'u', 'w'},
                {'e', 'g', 'n'},
                {'m', 'o', 'y'},
                {'q', 'r', 's'},
                {'d', 'i', 'q'},
                {'u', 'w', 'z'},
                {'u', 'w', 'x'},
                {'u', 'x', 'z'},
                {'e', 'l', 'x'},
                {'p', 't', 'v'},
                {'k', 't', 'w'},
                {'v', 'x', 'y'},
                {'f', 'y', 'z'},
                {'v', 'w', 'z'},
                {'d', 'f', 'h'},
                {'h', 't', 'x'},
                {'c', 'w', 'x'},
                {'v', 'x', 'z'},
                {'f', 'p', 'x'},
                {'g', 'x', 'y'},
                {'g', 'v', 'w'},
                {'f', 'l', 's'},
                {'c', 'f', 'v'},
                {'g', 'q', 's'},
                {'d', 't', 'y'},
                {'j', 'p', 't'},
                {'d', 'k', 's'},
                {'s', 'w', 'x'},
                {'d', 'q', 'x'},
                {'o', 'r', 's'},
                {'l', 'v', 'y'},
                {'r', 't', 'y'},
                {'i', 'y', 'z'},
                {'g', 'r', 'w'},
                {'g', 'h', 'l'},
                {'c', 'x', 'z'},
                {'g', 't', 'v'},
                {'f', 'g', 'n'},
                {'l', 'r', 't'},
                {'r', 'u', 'x'},
                {'u', 'x', 'y'},
                {'s', 'x', 'y'},
                {'b', 'u', 'z'},
                {'l', 'w', 'y'},
                {'a', 'n', 'v'},
                {'k', 'l', 'z'},
                {'n', 'q', 'w'},
                {'m', 'u', 'z'},
                {'k', 'u', 'y'},
                {'t', 'v', 'z'},
                {'o', 'w', 'z'},
                {'c', 'h', 'y'},
                {'h', 's', 'y'},
                {'l', 'r', 'z'},
                {'a', 's', 'z'},
                {'f', 'r', 'v'},
                {'d', 'q', 'v'},
                {'u', 'v', 'y'},
                {'t', 'x', 'y'},
                {'b', 'w', 'y'},
                {'j', 'q', 'u'},
                {'o', 't', 'y'},
                {'p', 'y', 'z'},
                {'l', 'y', 'z'},
                {'n', 's', 'u'},
                {'m', 's', 'x'},
                {'b', 's', 'y'},
                {'l', 's', 'z'},
                {'d', 'm', 'u'},
                {'i', 'o', 'w'},
                {'c', 'v', 'w'},
                {'t', 'y', 'z'},
                {'l', 'n', 'y'},
                {'m', 'x', 'y'},
                {'n', 'v', 'x'},
                {'n', 'u', 'z'},
                {'g', 'h', 's'},
                {'r', 'v', 'w'},
                {'j', 'u', 'x'},
                {'m', 'v', 'z'},
                {'d', 'r', 'z'},
                {'o', 'v', 'x'},
                {'f', 'n', 'q'},
                {'a', 'b', 't'},
                {'h', 'v', 'x'},
                {'e', 'u', 'x'},
                {'o', 'w', 'y'},
                {'d', 'i', 'm'},
                {'a', 'f', 'w'},
                {'f', 'n', 'r'},
                {'d', 'm', 'x'},
                {'p', 'r', 'z'},
                {'p', 'u', 'v'},
                {'e', 'y', 'z'},
                {'c', 'o', 'x'},
                {'c', 'x', 'y'},
                {'a', 'i', 'w'},
                {'q', 'x', 'y'},
                {'c', 'i', 'n'},
                {'u', 'v', 'z'},
                {'u', 'w', 'y'},
                {'f', 'r', 'x'},
                {'t', 'w', 'z'},
                {'e', 'r', 'v'},
                {'o', 'q', 't'},
                {'m', 'w', 'x'},
                {'g', 'v', 'x'},
                {'c', 'j', 'k'},
                {'i', 's', 'y'},
                {'g', 's', 'u'},
                {'i', 'j', 's'},
                {'d', 'm', 'n'},
                {'l', 'n', 'v'},
                {'e', 's', 'w'},
                {'o', 'u', 'w'},
                {'b', 's', 'z'},
                {'a', 'd', 'g'},
                {'l', 'w', 'x'},
                {'m', 'r', 'x'},
                {'j', 'k', 'l'},
                {'f', 'p', 's'},
                {'p', 'r', 'v'},
                {'g', 'x', 'z'},
                {'o', 'u', 'z'},
                {'h', 'k', 's'},
                {'i', 'r', 'w'},
                {'n', 'q', 'y'},
                {'o', 'q', 'r'},
                {'f', 'q', 'y'},
                {'e', 'j', 'z'},
                {'e', 'o', 'u'},
                {'j', 'k', 'z'},
                {'b', 'g', 't'},
                {'f', 'v', 'w'},
                {'w', 'x', 'y'},
                {'t', 'v', 'w'},
                {'a', 'p', 'w'},
                {'c', 'l', 'x'},
                {'q', 's', 'y'},
                {'k', 'n', 'q'},
                {'d', 'y', 'z'},
                {'i', 'p', 'v'},
                {'e', 'k', 'y'},
                {'e', 'w', 'z'},
                {'i', 'm', 'v'},
                {'j', 's', 'v'},
                {'l', 'o', 'u'},
                {'e', 'o', 'q'},
                {'a', 'i', 's'},
                {'e', 'm', 'y'},
                {'b', 'y', 'z'},
                {'c', 'k', 'u'},
                {'a', 'k', 'p'},
                {'p', 'x', 'y'},
                {'h', 'p', 'q'},
                {'p', 't', 'w'},
                {'e', 'x', 'z'},
                {'l', 'p', 'y'},
                {'m', 'y', 'z'},
                {'l', 't', 'v'},
                {'d', 'g', 'n'},
                {'h', 'o', 't'},
                {'c', 't', 'x'},
                {'a', 'o', 'v'},
                {'m', 'v', 'x'},
                {'k', 'o', 'q'},
                {'i', 'v', 'y'},
                {'b', 'm', 's'},
                {'h', 'q', 'w'},
                {'f', 'h', 'x'},
                {'i', 'v', 'z'},
                {'f', 't', 'w'},
                {'l', 'v', 'z'},
                {'f', 'g', 'w'},
                {'s', 'w', 'z'},
                {'j', 'k', 'o'},
                {'d', 'j', 'm'},
                {'r', 't', 'u'},
                {'k', 'm', 'z'},
                {'q', 'w', 'y'},
                {'q', 'u', 'v'},
                {'g', 's', 'x'},
                {'p', 's', 't'},
                {'i', 'm', 't'},
                {'c', 'g', 'y'},
                {'n', 'w', 'z'},
                {'o', 'r', 'z'},
                {'h', 'i', 'm'},
                {'n', 't', 'w'},
                {'s', 'u', 'y'},
                {'s', 'x', 'z'},
                {'h', 'x', 'z'},
                {'e', 'f', 'x'},
                {'a', 'k', 'n'},
                {'h', 's', 'z'},
                {'j', 'o', 'w'},
                {'o', 't', 'x'},
                {'l', 'n', 'r'},
                {'m', 'x', 'z'},
                {'r', 'x', 'y'},
                {'b', 'w', 'z'},
                {'c', 'j', 'q'},
                {'b', 'f', 'o'},
                {'o', 'x', 'z'},
                {'i', 'j', 'r'},
                {'p', 'q', 'y'},
                {'j', 'p', 's'},
                {'m', 'r', 'w'},
                {'a', 'e', 'y'},
                {'u', 'y', 'z'},
                {'j', 'l', 'u'},
                {'j', 's', 'y'},
                {'k', 'x', 'z'},
                {'p', 'v', 'y'},
                {'j', 'l', 'p'},
                {'p', 'v', 'z'},
                {'f', 'h', 't'},
                {'k', 'n', 'x'},
                {'f', 'n', 'o'},
                {'p', 'v', 'w'},
                {'k', 'v', 'y'},
                {'j', 'w', 'y'},
                {'e', 'n', 's'},
                {'f', 'j', 'p'},
                {'f', 'u', 'w'},
                {'g', 'm', 'z'},
                {'n', 's', 'y'},
                {'m', 's', 'z'},
                {'c', 'd', 'x'},
                {'l', 'x', 'y'},
                {'g', 'y', 'z'},
                {'b', 't', 'w'},
                {'n', 'q', 'z'},
                {'r', 'w', 'y'},
                {'r', 't', 'w'},
                {'l', 't', 'x'},
                {'m', 'w', 'y'},
                {'h', 'm', 't'},
                {'k', 'n', 'v'},
                {'a', 'j', 'y'},
                {'f', 'q', 'w'},
                {'s', 'u', 'w'},
                {'p', 't', 'z'},
                {'j', 'l', 'r'},
                {'m', 'n', 'w'},
                {'n', 't', 'v'},
                {'n', 'p', 'r'},
                {'l', 'u', 'w'},
                {'g', 'j', 'o'},
                {'b', 'j', 'v'},
                {'m', 'o', 't'},
                {'k', 'w', 'z'},
                {'f', 'i', 'n'},
                {'i', 'u', 'y'},
                {'p', 'v', 'x'},
                {'k', 'l', 'u'},
                {'b', 'c', 'f'},
                {'f', 'q', 'v'},
                {'c', 'h', 'u'},
                {'i', 'n', 'w'},
                {'q', 's', 't'},
                {'k', 'q', 'w'},
                {'o', 'q', 's'},
                {'o', 'r', 'v'},
                {'m', 't', 'u'},
                {'n', 'u', 'y'},
                {'c', 's', 'z'},
                {'o', 'q', 'x'},
                {'r', 't', 'z'},
                {'a', 'g', 'q'},
                {'g', 's', 'z'},
                {'i', 'w', 'y'},
                {'j', 'l', 'y'},
                {'e', 'v', 'x'},
                {'e', 'n', 't'},
                {'f', 'g', 'v'},
                {'a', 'j', 'n'},
                {'d', 'h', 'r'},
                {'a', 'p', 'u'},
                {'l', 's', 'v'},
                {'l', 'q', 'z'},
                {'k', 'y', 'z'},
                {'r', 's', 'y'},
                {'n', 'x', 'y'},
                {'o', 'u', 'x'},
                {'n', 'q', 't'},
                {'c', 'f', 'h'},
                {'q', 's', 'x'},
                {'a', 'l', 'p'},
                {'l', 's', 'u'},
                {'e', 'r', 'y'},
                {'k', 'v', 'x'},
                {'j', 'o', 's'},
                {'o', 'p', 'q'},
                {'m', 'v', 'w'},
                {'o', 'q', 'v'},
                {'a', 'w', 'z'},
                {'l', 'u', 'x'},
                {'g', 's', 'v'},
                {'p', 'q', 'v'},
                {'b', 'o', 's'},
                {'o', 's', 'v'},
                {'f', 'h', 'y'},
                {'k', 's', 'w'},
                {'h', 't', 'u'},
                {'t', 'v', 'x'},
                {'q', 'v', 'w'},
                {'j', 'p', 'v'},
                {'c', 'l', 'u'},
                {'m', 's', 'w'},
                {'e', 'j', 'p'},
                {'e', 'f', 'h'},
                {'a', 's', 't'},
                {'i', 'k', 't'},
                {'j', 'l', 'm'},
                {'d', 'e', 'x'},
                {'j', 'x', 'y'},
                {'a', 'k', 'v'},
                {'j', 'q', 'v'},
                {'s', 'v', 'y'},
                {'d', 'k', 'q'},
                {'g', 'o', 's'},
                {'a', 'u', 'y'},
                {'h', 'u', 'x'},
                {'e', 'q', 's'},
                {'a', 'f', 'v'},
                {'i', 'r', 'x'},
                {'o', 'y', 'z'},
                {'h', 'v', 'z'},
                {'i', 'u', 'v'},
                {'h', 'p', 'x'},
                {'i', 't', 'z'},
                {'f', 'o', 'q'},
                {'a', 'x', 'y'},
                {'t', 'w', 'x'},
                {'c', 'u', 'w'},
                {'b', 'g', 'u'},
                {'q', 'v', 'y'},
                {'r', 'x', 'z'},
                {'s', 'u', 'x'},
                {'s', 'v', 'z'},
                {'e', 'h', 'l'},
                {'e', 'w', 'y'},
                {'j', 's', 'x'},
                {'q', 'w', 'x'},
                {'q', 'x', 'z'},
                {'f', 'l', 'n'},
                {'d', 'n', 'y'},
                {'j', 'r', 'u'},
                {'u', 'v', 'w'},
                {'t', 'x', 'z'},
                {'m', 'o', 'z'},
                {'f', 'm', 'q'},
                {'k', 'l', 'y'},
                {'f', 's', 'x'},
                {'m', 'w', 'z'},
                {'g', 'w', 'x'},
                {'m', 'u', 'y'},
                {'n', 'q', 'u'},
                {'l', 't', 'w'},
                {'r', 'u', 'z'},
                {'o', 's', 'w'},
                {'d', 's', 'y'},
                {'u', 'v', 'x'},
                {'h', 'y', 'z'},
                {'g', 'm', 'u'},
                {'a', 'c', 'l'},
                {'d', 'e', 'k'},
                {'p', 'q', 's'},
                {'g', 'j', 'l'},
                {'c', 'e', 'g'},
                {'b', 'l', 'v'},
                {'o', 'q', 'z'},
                {'p', 'q', 'u'},
                {'m', 'u', 'w'},
                {'j', 'n', 'y'},
                {'c', 'q', 'v'},
                {'p', 'u', 'w'},
                {'i', 'o', 'y'},
                {'f', 'm', 'x'},
                {'j', 't', 'x'},
                {'h', 'm', 'x'},
                {'c', 's', 'x'},
                {'i', 'q', 'v'},
                {'s', 'v', 'w'},
                {'i', 'w', 'x'},
                {'m', 'p', 't'},
                {'o', 'v', 'y'},
                {'p', 't', 'u'},
                {'e', 'w', 'x'},
                {'n', 'r', 's'},
                {'e', 'l', 'z'},
                {'s', 'u', 'z'},
                {'g', 'm', 't'},
                {'h', 'u', 'v'},
                {'r', 't', 'x'},
                {'l', 's', 'x'},
                {'o', 'p', 'v'},
                {'n', 'v', 'w'},
                {'p', 's', 'u'},
                {'e', 's', 'u'},
                {'j', 'y', 'z'},
                {'f', 'n', 'u'},
                {'h', 's', 'v'},
                {'f', 'm', 'n'},
                {'i', 'q', 'x'},
                {'d', 'j', 'l'},
                {'k', 't', 'v'},
                {'o', 'p', 'w'},
                {'e', 'k', 'm'},
                {'j', 'n', 'v'},
                {'h', 'j', 'p'},
                {'p', 'x', 'z'},
                {'c', 'g', 't'},
                {'i', 'n', 'r'},
                {'h', 'o', 'p'},
                {'c', 'h', 'v'},
                {'l', 'p', 'z'},
                {'q', 'v', 'z'},
                {'e', 't', 'w'},
                {'b', 't', 'x'},
                {'d', 'v', 'x'},
                {'l', 'r', 'u'},
                {'f', 'k', 'y'},
                {'f', 'x', 'y'},
                {'h', 'm', 'n'},
                {'s', 'v', 'x'},

        };
        assertEquals("abcdefghijklmnopqrstuvwxyz", detective.recoverSecret(triplets));


    }
}

