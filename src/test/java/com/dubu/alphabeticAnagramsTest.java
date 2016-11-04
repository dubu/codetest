package com.dubu;

/**
 * Created by rigel on 11/3/16.
 */

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * 3
 * https://www.codewars.com/kata/alphabetic-anagrams/train/java
 * <p/>
 * Consider a "word" as any sequence of capital letters A-Z (not limited to just "dictionary words"). For any word with at least two different letters, there are other words composed of the same letters but in a different order (for instance, STATIONARILY/ANTIROYALIST, which happen to both be dictionary words; for our purposes "AAIILNORSTTY" is also a "word" composed of the same letters as these two).
 * <p/>
 * We can then assign a number to every word, based on where it falls in an alphabetically sorted list of all words made up of the same group of letters. One way to do this would be to generate the entire list of words and find the desired one, but this would be slow if the word is long.
 * <p/>
 * Given a word, return its number. Your function should be able to accept any word 25 letters or less in length (possibly with some letters repeated), and take no more than 500 milliseconds to run. To compare, when the solution code runs the 27 test cases in JS, it takes 101ms.
 * <p/>
 * For very large words, you'll run into number precision issues in JS (if the word's position is greater than 2^53). For the JS tests with large positions, there's some leeway (.000000001%). If you feel like you're getting it right for the smaller ranks, and only failing by rounding on the larger, submit a couple more times and see if it takes.
 * <p/>
 * Python, Java and Haskell have arbitrary integer precision, so you must be precise in those languages (unless someone corrects me).
 * <p/>
 * C# is using a long, which may not have the best precision, but the tests are locked so we can't change it.
 * <p/>
 * Sample words, with their rank:
 * ABAB = 2
 * AAAB = 1
 * BAAA = 4
 * QUESTION = 24572
 * BOOKKEEPER = 10743
 */
public class AlphabeticAnagramsTest {

    @Test
    public void testStep1() throws Exception {

        System.out.println("hello world1");

    }

    @Test
    public void testName() throws Exception {

        System.out.println("hello world2");

    }


    @Test
    public void testsdf() throws Exception {
        System.out.println("hello world3");

    }





    @Test
    public void testKnownInputs() {
        Anagrams anagram = new Anagrams();

        assertEquals("Position for 'A' incorrect", BigInteger.ONE, listPosition("A"));
        assertEquals("Position for 'ABAB' incorrect", BigInteger.valueOf(2), listPosition("ABAB"));
        assertEquals("Position for 'AAAB' incorrect", BigInteger.ONE, listPosition("AAAB"));
        assertEquals("Position for 'BAAA' incorrect", BigInteger.valueOf(4), listPosition("BAAA"));
        assertEquals("Position for 'QUESTION' incorrect", BigInteger.valueOf(24572), listPosition("QUESTION"));
        assertEquals("Position for 'BOOKKEEPER' incorrect", BigInteger.valueOf(10743), listPosition("BOOKKEEPER"));
    }

    private BigInteger listPosition(String str) {

        ArrayList<Integer> integers = convertPosition(str);
        System.err.println(integers);
        BigInteger i = wordOrder(integers);

        return i;
    }




    private class Anagrams {

    }


    public ArrayList<Integer> convertPosition(String word) {

        List<Character> charList = word.chars().mapToObj((i) -> Character.valueOf((char)i)).collect(Collectors.toList());

        int charNum = 0;
        Integer integer = 0;

        Map<Character,Integer> wordMap  = new HashMap<Character, Integer>();
        for (int i = 0; i < charList.size(); i++) {
            Character character = charList.get(i);
            if(i == 0 ){
                wordMap.put(character,charNum);
            }else{
                integer = wordMap.get(character);
                if (integer == null) {
                    wordMap.put(character, ++charNum);
                }
            }
        }


        List<Character> orderList = new ArrayList<Character>();
        Iterator<Character> iterator = wordMap.keySet().iterator();
        while (iterator.hasNext()) {
            Character next = iterator.next();
            orderList.add(next);
        }



        ArrayList<Integer> oriIntegerList = new ArrayList<>();

        for (int i = 0; i < charList.size(); i++) {
            Character character = charList.get(i);
            //System.out.print(wordMap.get(character));
            //oriIntegerList.add(orderList.indexOf(character));
            // oriIntegerList.add(wordMap.get(character));
            oriIntegerList.add(orderList.indexOf(character));
        }

//        Collections.sort(oriIntegerList);
//
//        System.out.print(oriIntegerList);
//
//        ArrayList<Integer> baseIntegerList = new ArrayList<>(oriIntegerList);



//        return BigInteger.ZERO;



//
//        for (int i = 0; i < oriIntegerList.size(); i++) {
//            Integer integer1 = oriIntegerList.get(i);
//
//            oriIntegerList.set(i, orderList.indexOf(integer1));
//        }





        return  oriIntegerList;
    }



    @Test
    public void testD2() throws Exception {

        // 전체 몇 자리 , 몇 번째 , 중복은 몇 개
        // 적은 것을 카운트 함

        // 자기꺼 빼고


        // 11123;


//        012;
//        021;
//        102;
//        120;
//        201;
//        210;
//

        ArrayList<Integer> cba = convertPosition("BAA");

        System.err.println(cba);
        BigInteger rs = wordOrder(cba);

        System.out.println(rs);


    }

    @Test
    public void test0101() throws Exception {

        /*
        0011
        0101
        0110
        1100
         */

        ArrayList<Integer> integers = Lists.newArrayList(1,1,0,0);
        BigInteger bigInteger = wordOrder(integers);

        System.out.println(bigInteger);



    }

    private BigInteger wordOrder(ArrayList<Integer> integers) {
        BigInteger sum = BigInteger.valueOf(1);

//        ArrayList<Integer> integers = Lists.newArrayList(0,1,2);
        ArrayList<Integer> useAbleNumberList = new ArrayList<>();
        ArrayList<Integer> orderListTemp = new ArrayList<>();
        useAbleNumberList.addAll(integers);
        orderListTemp.addAll(integers);
        Collections.sort(orderListTemp);

        Set<Integer> fooSet = new HashSet<Integer>(orderListTemp);
        ArrayList<Integer> orderList = new ArrayList<>();
        Iterator<Integer> iterator = fooSet.iterator();
        while (iterator.hasNext()) {
            Integer next =  iterator.next();
            orderList.add(next);
        }



        for (int i = 0; i < integers.size(); i++) { // 자리수

            Integer integerValue = integers.get(i);

            int positionRankOrder = orderList.indexOf(integerValue);
            for (int j = 0; j < positionRankOrder; j++) {
                useAbleNumberList = new ArrayList<>();
                useAbleNumberList.addAll(integers);

                //useAbleNumberList.remove(j);
//                useAbleNumberList.remove(integers.get(i));
//                useAbleNumberList.remove(integers.get(j));
                if(i >0){
                    for (int k = 0; k <= i; k++) {
                        Integer integerK = integers.get(k);
                        useAbleNumberList.remove(integerK);

                    }
                }


                int nextPosion = integers.size() - 1 - i;
                int dupleCount = 1;

                dupleCount = (int) useAbleNumberList.stream().filter(integer -> integer == integerValue).count();

                if(dupleCount ==0){
                    System.out.printf(" ");
                }
//                int lowPostionOrder = (positionRankOrder ) * factorial(nextPosion) / (dupleCount+1);
                int lowPostionOrder = (positionRankOrder ) * factorial(nextPosion) / factorial(dupleCount) ;

                sum = sum.add(BigInteger.valueOf(lowPostionOrder)) ;

            }

        }


//        System.out.println(sum-1);
        if(sum.intValue()  > 1 ){
           sum =  sum.subtract(BigInteger.valueOf(1));

        }
        return sum ;

    }

    @Test
    public void testListsfs() throws Exception {

        ArrayList<String> rsList = new ArrayList<>();
        ArrayList<Integer> integers = Lists.newArrayList(1,2,3);

        ArrayList<Integer> idx = new ArrayList<>();
        idx.addAll(integers);
        int flag =0;
        int maxCapacity = 0;
        ArrayList<Integer> trash = new ArrayList<>();


        HashMap<Integer, Integer> maxValueMap = new HashMap<>();


        int hereI = 0;
        int hereJ = 0;
        StringBuilder sb  = new StringBuilder();
        List<Integer> lineTrash = new ArrayList<>();
        while(true){
            for (int i = hereI; i < idx.size(); i++) { // 다음 위치로

                sb.setLength(Math.max(i, 0));

                for (int j = hereJ; j < integers.size(); j++) {
                    Integer x = idx.get(j);

                    int keyVal = i * 25 + x;

                    if(lineTrash.contains(j) ){
                        continue; // 숫자를 올린다
                    }else{

                        // 이하 선택처리
                        trash.add(keyVal);
                        lineTrash.add(j);
//                        System.out.print(x);
                        sb.append(x);
                        hereI= i ;
                        hereJ = j ;


                        break;
                    }

                }


            }
            System.out.println(sb.toString());

            rsList.add(sb.toString());
//            maxCapacity = maxCapacity -1;

//            if(rsList.size() >= factorial(integers.size()) ){
//                break;
//            }
            //
        }


    }

    int factorial(int n)
    {
        int fact = 1;
        for(int c = 1; c <= n; c++)
            fact = fact * c;
        return fact;
    }


}
