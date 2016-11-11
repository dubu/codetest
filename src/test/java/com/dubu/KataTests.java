package com.dubu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by rigel on 11/10/16.
 * <p/>
 * <p/>
 * https://www.codewars.com/kata/next-bigger-number-with-the-same-digits/train/java
 */
public class KataTests {
    @Test
    public void basicTests() {
        assertEquals(21, Kata.nextBiggerNumber(12));
        assertEquals(531, Kata.nextBiggerNumber(513));
        assertEquals(2071, Kata.nextBiggerNumber(2017));
        assertEquals(441, Kata.nextBiggerNumber(414));
        assertEquals(414, Kata.nextBiggerNumber(144));



//        assertEquals("21", Kata.nextBiggerNumber(12));



        //  to conver 숫자
        // +1
        // revert 다시 숫자
        // 01  01
        // 210 211 212 220 221 222 301 513

//        110
//            111

    }

    @Test
    public void testConvertNumber() throws Exception {

//        assertEquals("210",convertNumber(531));
//        assertEquals("2031",convertNumber(2071));
//        assertEquals("101",convertNumber(414));
//        assertEquals("011",convertNumber(144));


//        assertEquals("21",convertNumber(12));

        assertEquals(531, convertNumber(513));
        assertEquals(2071, convertNumber(2017));
        assertEquals(441, convertNumber(414));
        assertEquals(414, convertNumber(144));


//        "123345"
//        Set<String> foo = new HashSet<String>(myList);


        String rs = addOne("210");
   }

    private String addOne(String s) {

        char[] chars = s.toCharArray();
        ArrayList<Character> characters = new ArrayList<>();
        List<char[]> chars1 = Arrays.asList(chars);


        Integer integer = Integer.valueOf(s);

        while (true){

            integer = integer +1;

//            Set<Integer> foo = new HashSet<String>(myList);
//
//            covert(integer,s.)




            if(true){


                String rStr = revertNumber(integer);
                break;
            }
      }

        return null;
    }

    @Test
    public void testCovert() throws Exception {


        assertEquals("11" , covert(3, 2));
        assertEquals("21" , covert(9, 4));

    }

    private String covert(int n, int base) {

        List<String> t = Arrays.asList("0","1","2","3","4","5","6","7","8","9");
        int q =  n / base;
        int r =  n % base;
        if(q == 0){
            return t.get(r);
        }else{
            return  covert(q,base) + t.get(r);
        }
    }

    private String revertNumber(Integer num) {
        String numString = String.valueOf(num);

        return null;
    }


    private long convertNumber(long num) {
        String numString = String.valueOf(num);
        char[] chars = numString.toCharArray();

        List<Character> intList =  new ArrayList<>();
        List<Integer> rsList =  new ArrayList<>();
        List<Character> ordList =  new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if( ! ordList.contains(aChar)){
                intList.add(aChar);
            }

        }
        ordList.addAll(intList);
        Collections.sort(ordList);

        for (int i = 0; i < intList.size(); i++) {
            Character integer = intList.get(i);
            rsList.add(ordList.indexOf(integer));
        }

        StringBuilder b = new StringBuilder();
        rsList.stream().forEach(b::append);

///   --- 이하 좀 다름 ---


        char[] chars3 = b.toString().toCharArray();

        int integer = 0;
        for (int i = 0; i < chars3.length; i++) {
            char c = chars3[i];
            integer = (int) (integer  + Integer.valueOf(String.valueOf(c)) *  Math.pow(ordList.size(), chars3.length -1 -i));
        }
//        integer = integer + chars3[chars3.length-1];

        //Integer integer = Integer.valueOf(b.toString());
        while (true) {

            integer = integer + 1;

            String covert = covert(integer, ordList.size() );

//            if(covert.compareTo(numString)){
//
//            }

            char[] chars1 = b.toString().toCharArray();
            char[] chars2 = covert.toCharArray();

            Arrays.sort(chars1);
            Arrays.sort(chars2);

//            boolean areEqual = Arrays.equals(chars1), Arrays.sort(numString.toCharArray()));

            if (Arrays.equals(chars1, chars2)) {


                //String str = String.valueOf(covert);

                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < covert.toCharArray().length; i++) {
                    char c = covert.toCharArray()[i];

                    sb.append(ordList.get(Integer.valueOf(String.valueOf(c))));

                }


                return Long.valueOf(sb.toString());
            }
        }
    }




}


class Kata {


    public static long nextBiggerNumber(long num) {

        String numString = String.valueOf(num);
        char[] chars = numString.toCharArray();

        List<Character> intList = new ArrayList<>();
        List<Integer> rsList = new ArrayList<>();
        List<Integer> nextRsList = new ArrayList<>();
        List<Character> ordList = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (!ordList.contains(aChar)) {
                intList.add(aChar);
            }

        }
        ordList.addAll(intList);
        Collections.sort(ordList);

        for (int i = 0; i < intList.size(); i++) {
            Character integer = intList.get(i);
            rsList.add(ordList.indexOf(integer));
        }

        StringBuilder b = new StringBuilder();
        rsList.stream().forEach(b::append);

        nextRsList.addAll(rsList);

        nextRsList.set(rsList.size() -2 ,nextRsList.size() -1)
        nextRsList.set(nextRsList.size() -1 ,nextRsList.size() -2)







        return  0L;
    }

    public static long nextBiggerNumberOld(long num) {
        String numString = String.valueOf(num);
        char[] chars = numString.toCharArray();

        List<Character> intList = new ArrayList<>();
        List<Integer> rsList = new ArrayList<>();
        List<Character> ordList = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (!ordList.contains(aChar)) {
                intList.add(aChar);
            }

        }
        ordList.addAll(intList);
        Collections.sort(ordList);

        for (int i = 0; i < intList.size(); i++) {
            Character integer = intList.get(i);
            rsList.add(ordList.indexOf(integer));
        }

        StringBuilder b = new StringBuilder();
        rsList.stream().forEach(b::append);

///   --- 이하 좀 다름 ---


        char[] chars3 = b.toString().toCharArray();

        int integer = 0;
        for (int i = 0; i < chars3.length; i++) {
            char c = chars3[i];
            integer = (int) (integer + Integer.valueOf(String.valueOf(c)) * Math.pow(ordList.size(), chars3.length - 1 - i));
        }
        while (true) {

            integer = integer + 1;

            String covert = covert(integer, ordList.size());

            char[] chars1 = b.toString().toCharArray();
            char[] chars2 = covert.toCharArray();

            Arrays.sort(chars1);
            Arrays.sort(chars2);

            if (Arrays.equals(chars1, chars2)) {

                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < covert.toCharArray().length; i++) {
                    char c = covert.toCharArray()[i];

                    sb.append(ordList.get(Integer.valueOf(String.valueOf(c))));

                }
                return Long.valueOf(sb.toString());
            }
        }
    }


    private static String covert(int n, int base) {

        List<String> t = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        int q = n / base;
        int r = n % base;
        if (q == 0) {
            return t.get(r);
        } else {
            return covert(q, base) + t.get(r);
        }
    }

}

