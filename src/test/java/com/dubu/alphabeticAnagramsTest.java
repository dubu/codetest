package com.dubu;

/**
 * Created by rigel on 11/3/16.
 */

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
public class alphabeticAnagramsTest {

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

        assertEquals("Position for 'A' incorrect", BigInteger.ONE, anagram.listPosition("A"));
        assertEquals("Position for 'ABAB' incorrect", BigInteger.valueOf(2), anagram.listPosition("ABAB"));
        assertEquals("Position for 'AAAB' incorrect", BigInteger.ONE, anagram.listPosition("AAAB"));
        assertEquals("Position for 'BAAA' incorrect", BigInteger.valueOf(4), anagram.listPosition("BAAA"));

        //[4, 7, 0, 5, 6, 1, 3, 2] 8
        assertEquals("Position for 'QUESTION' incorrect", BigInteger.valueOf(24572), anagram.listPosition("QUESTION"));
        assertEquals("Position for 'BOOKKEEPER' incorrect", BigInteger.valueOf(10743), anagram.listPosition("BOOKKEEPER"));
    }



    @Test
    public void testConvert() throws Exception {


//        QUESTION
//        [4, 7, 0, 5, 6, 1, 3, 2]


        String str= "BOOKKEEPER";

//        [0, 3, 3, 2, 2, 1, 1, 4, 1, 5]
//        0B
//        1E
//        2K
//        3O
//        4P
//        5R


        Anagrams anagram = new Anagrams();
        ArrayList<Integer> integers = anagram.convertPosition(str);
        System.out.println(integers);

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

        Anagrams anagram = new Anagrams();
        ArrayList<Integer> cba = anagram.convertPosition("BAA");

        System.err.println(cba);
        BigInteger rs = anagram.wordOrder(cba);

        System.out.println(rs);


    }

    @Test
    public void test0101() throws Exception {

        /*
        0011 o
        0101 o
        0110 0
        1001 3
        1010 4
        1100 4
         */


//        assertEquals( BigInteger.valueOf(1L), wordOrder(Lists.newArrayList(0,0,1,1)));
//        assertEquals( BigInteger.valueOf(2L), wordOrder(Lists.newArrayList(0,1,0,1)));
//        assertEquals( BigInteger.valueOf(3L), wordOrder(Lists.newArrayList(0,1,1,0)));
//        assertEquals( BigInteger.valueOf(4L), wordOrder(Lists.newArrayList(1,0,0,1)));
//        assertEquals( BigInteger.valueOf(5L), wordOrder(Lists.newArrayList(1,0,1,0)));
//        assertEquals( BigInteger.valueOf(6L), wordOrder(Lists.newArrayList(1,1,0,0)));


    }


    public class Anagrams {


        public BigInteger listPosition(String str) {

            ArrayList<Integer> integers = convertPosition(str);
            System.err.println(integers);
            BigInteger i = wordOrder(integers);

            return i;
        }



        public ArrayList<Integer> convertPosition(String word) {


            List<Character> oriList = word.chars().mapToObj((i) -> Character.valueOf((char)i)).collect(Collectors.toList());

            List<Character> charList = word.chars().mapToObj((i) -> Character.valueOf((char)i)).collect(Collectors.toList());

            Collections.sort(charList);

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

            for (int i = 0; i < oriList.size(); i++) {
                Character character = oriList.get(i);
                oriIntegerList.add(wordMap.get(character));

            }

            return  oriIntegerList;
        }


        public BigInteger wordOrder(ArrayList<Integer> integers) {
            BigInteger sum = BigInteger.valueOf(0);

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

                    if(i >0){
                        for (int k = 0; k < i; k++) {
                            Integer integerK = integers.get(k);
                            useAbleNumberList.remove(integerK);

                        }
                    }


                    BigInteger lowPostionOrder = BigInteger.ZERO;
                    Integer tmpInt = orderList.get(j);
                    if(useAbleNumberList.contains(tmpInt)){
                        useAbleNumberList.remove(tmpInt);
                        int nextPosion = integers.size() -1 - i;
                        long dupleCount = 1;

                        dupleCount = dupleFactory(useAbleNumberList);

                        if(dupleCount ==0){
//                        System.out.printf(" ");
                        }

                        if(useAbleNumberList.size() == 0){

                        }else{
                            //lowPostionOrder = (positionRankOrder ) * factorial((long) nextPosion) / dupleCount ;
                            lowPostionOrder = factorial((long) nextPosion).divide(BigInteger.valueOf(dupleCount)) ;

                        }

                    }else{
                        lowPostionOrder = BigInteger.ZERO;

                    }
                    sum = sum.add(lowPostionOrder) ;

                }

            }

            return  sum.add(BigInteger.ONE);

        }

        public BigInteger factorial(Long n)
        {
            BigInteger fact = BigInteger.ONE;
            for(int c = 1; c <= n; c++)
                fact = fact.multiply(BigInteger.valueOf(c));
            return fact;
        }

        public Long factorialLong(Long n)
        {
            Long fact = 1L;
            for(int c = 1; c <= n; c++)
                fact = fact * c;
            return fact;
        }

        public Long dupleFactory(ArrayList<Integer> list) {
            Collection<Long> values = list.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting())).values();

            Long reduce = values.stream().reduce(1L, (a, b) -> a * factorialLong(b));

//        System.out.println(reduce);
            return reduce;

        }
    }

}
