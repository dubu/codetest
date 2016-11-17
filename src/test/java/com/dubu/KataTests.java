package com.dubu;

    import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by rigel on 11/10/16.
 * <p/>
 * <p/>
 * https://www.codewars.com/kata/next-bigger-number-with-the-same-digits/train/java
 *
 * - 숫자 오더가 있다.
 - 맨뒤를 바꾼다. 안크면
 - 백자리를 올린다. 나머지 값으로 asc 한다.
 - order max 면 다음 자리를 올리면서 asc 한다.

 */
public class KataTests {
    @Test
    public void basicTests() {
        assertEquals(21, Kata.nextBiggerNumber(12));
        assertEquals(531, Kata.nextBiggerNumber(513));
        assertEquals(441, Kata.nextBiggerNumber(414));
        assertEquals(414, Kata.nextBiggerNumber(144));
        assertEquals(214, Kata.nextBiggerNumber(142));
        assertEquals(1534, Kata.nextBiggerNumber(1453));
        assertEquals(3145, Kata.nextBiggerNumber(1543));
        assertEquals(2071, Kata.nextBiggerNumber(2017));
        assertEquals(1962525582, Kata.nextBiggerNumber(1962525528)); // 2122555689
        assertEquals(1962525825, Kata.nextBiggerNumber(1962525582)); //


        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1232567980, Kata.nextBiggerNumber(1232567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1254567980, Kata.nextBiggerNumber(1254567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1232567980, Kata.nextBiggerNumber(1232567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1254567980, Kata.nextBiggerNumber(1254567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1232567980, Kata.nextBiggerNumber(1232567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1254567980, Kata.nextBiggerNumber(1254567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1232567980, Kata.nextBiggerNumber(1232567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1254567980, Kata.nextBiggerNumber(1254567908));

        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(624567980, Kata.nextBiggerNumber(624567908));
        assertEquals(1434567980, Kata.nextBiggerNumber(1434567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1634567980, Kata.nextBiggerNumber(1634567908));
        assertEquals(1235567980, Kata.nextBiggerNumber(1235567908));


//        assertEquals(1234567980, Kata.nextBiggerNumber(1235567908));
//        assertEquals(1234567980, Kata.nextBiggerNumber(1235567908));
//        assertEquals(1234567980, Kata.nextBiggerNumber(1235567908));
//        assertEquals(1234567980, Kata.nextBiggerNumber(1235567908));
//        assertEquals(1234567980, Kata.nextBiggerNumber(1235567908));
//        assertEquals(1234567980, Kata.nextBiggerNumber(1235567908));




//        Process was terminated. It took longer than 12000ms to complete


//        assertEquals(2071, Kata.nextBiggerNumber(1234567890));

//        assertEquals(150990099, Kata.nextBiggerNumber(150909990));




        //  to conver 숫자
        // +1
        // revert 다시 숫자
        // 01  01
        // 210 211 212 220 221 222 301 513

//        110
//            111

    }


    @Test
    public void testOrderMap() throws Exception {

        int num = 252159;

        String numString = String.valueOf(num);
        char[] chars = numString.toCharArray();

        List<Character> orderList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        List<Integer> chkList ;
        List<Integer> tmpList ;
        Map<String,Integer> orderMap = new HashMap<>();
//        List<Integer> nextRsList = new ArrayList<>();
//        List<Character> ordList = new ArrayList<>();

        // init
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            orderList.add(aChar);
            intList.add(Integer.valueOf(String.valueOf(aChar)));

        }
        Collections.sort(orderList);

        for (int i = 0; i < orderList.size(); i++) {
            Character character = orderList.get(i);
            orderMap.put(String.valueOf(character),i);

        }

        System.out.println(orderMap);
        System.out.println(intList);

//        for (int i = intList.size() -2; i >= 0; i--) {
//            tmpList = new ArrayList<>();
//            tmpList.addAll(intList);
//
//            Integer lstVal = intList.get(intList.size() - 1);
//            Integer curVal = intList.get(i);
//
//            tmpList.set(i + 1, curVal);
//            tmpList.set(i, lstVal);
//
//            if (getInterValue(tmpList) > getInterValue(intList)) {
//
//                System.out.println(tmpList);
//            }
//
//        }

        chkList = new ArrayList<>();
        chkList.addAll(intList);


//        tmpList = new ArrayList<>();
//        tmpList.addAll(intList);


        tmpList = new ArrayList<>();
        tmpList.addAll(intList);

        int updatePositon = -1;
        while (true) {

            for (int i = 0; i < intList.size(); i++) {  // 자리수
                Integer integer = intList.get(i);


                Integer idx = 0;

                idx = orderMap.get(String.valueOf(integer));

                if(i < updatePositon){
                    continue;
                }

                if(i == updatePositon){
                    Integer integer1 = tmpList.get(i);
                    idx = orderMap.get(String.valueOf(integer1));
                }


                chkList = new ArrayList<>();
                chkList.addAll(intList);

                for (int j = 0; j < tmpList.size(); j++) {
                    Integer integer1 = tmpList.get(j);
                    chkList.remove(integer1);

                }

                for (int j = idx; j < orderList.size(); j++) {

                    Character character = orderList.get(j);

                    if(chkList.contains(Integer.valueOf(String.valueOf(character)))){

                        tmpList.set(i, Integer.valueOf(String.valueOf(character)));

                        if(getInterValue(tmpList) >getInterValue(intList) ){

                            System.err.println(tmpList);
                        }


                        break;


                    }

                }

                updatePositon = i-1;

                //for
            }
            //while
        }






    }

    public static double getInterValue(List<Integer> rsList) {

        double sum = 0;

        for (int i = 0; i < rsList.size(); i++) {
            Integer integer = rsList.get(i);

            sum = sum + integer * Math.pow(10, (rsList.size()- i -1));

        }
        return sum;
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
    public void testGetIntegerVal() throws Exception {


//        List<Integer> strings = Arrays.asList(2,4,6,1,2,3);
//        double interValue = Kata.getInterValue(strings);
//
//        System.out.println(interValue);


//        assertEquals(Double.parseDouble("12434"), Kata.getInterValue(Arrays.asList(1,2,4,3,4)));
//        assertEquals(942.0, Kata.getInterValue(Arrays.asList(9,4,2)));


        System.out.println(Kata.getInterValue(Arrays.asList(1, 2, 4, 3, 4)));

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

        List<Integer> orderList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        List<Integer> iintList = new ArrayList<>();
        List<Integer> chkList = new ArrayList<>();
        List<Integer> tmpList ;
        Map<String,Integer> orderMap = new HashMap<>();


        List<Integer> markList = new ArrayList<>();

        // init
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            orderList.add(Integer.valueOf(String.valueOf(aChar)));
            intList.add(Integer.valueOf(String.valueOf(aChar)));

        }
        Collections.sort(orderList);

        Set<Integer> hs = new HashSet<>();
        hs.addAll(orderList);
        orderList.clear();
        orderList.addAll(hs);



        for (int i = 0; i < orderList.size(); i++) {
            Integer character = orderList.get(i);
            if( ! orderMap.keySet().contains(String.valueOf(character))){
                orderMap.put(String.valueOf(character),i);
            }
//            orderMap.put(String.valueOf(character),i);

        }

        Integer initVal = getInterValue(intList).intValue();
        // init

        chkList.addAll(intList);

        int endPosition = -99;

        while(true){
            endPosition = -99;

            for (int i = intList.size()-1; i >=0 ; i--) {
                if (!markList.contains(i)){
                    endPosition = i;
                    break;
                }

            }

            boolean chkFlag = true;
            markList = new ArrayList<>();
            for (int i = 0; i < intList.size(); i++) { // 자리수
                Integer integer = intList.get(i);

                if(endPosition != -1 && i < endPosition){
                    continue;
                }

                tmpList= chkList.subList(0,i);
                iintList = new ArrayList<>();
                iintList.addAll(intList);
                for (int k = 0; k < tmpList.size(); k++) {
                    Integer integer1 = tmpList.get(k);
                    iintList.remove(integer1);
                }

                for (int j = 0; j < orderList.size(); j++) {

                    Integer character = orderList.get(j);

                    // validate character
                    // useble charcter ?


                    if(iintList.contains(Integer.valueOf(String.valueOf(character)))){

                    }else{
                        continue;
                    }

                    chkList.set(i,Integer.valueOf(String.valueOf(character)));

//                    if(j == orderList.size()-1){
//                        endPosition =  i -1;
//                    }

//                    Collections.sort(iintList, Collections.reverseOrder());
                    if(iintList.get(iintList.size()-1) == Integer.valueOf(String.valueOf(character))){


                        markList.add(i);
                    }

                    Integer chkVal = getInterValue(chkList).intValue();



//                    if(getInterValue(chkList.subList(0,i+1)) >= getInterValue(intList.subList(0,i+1))){
                    if(chkVal / 10 / (intList.size()-i) >= initVal / 10 / (intList.size()-i )){
                        if(i == endPosition){
                            endPosition = -99;
                            continue;
                        }

                        if(i == intList.size()-1 && chkVal > initVal) {
//                            System.err.println(chkList);
                            return  Long.valueOf(String.valueOf(getInterValue(chkList).intValue()));
                        }

//                        chkFlag =false;
                        break;
                    }

                }

            }

        }
    }

    public static Double getInterValue(List<Integer> rsList) {

        double sum = 0;

        for (int i = 0; i < rsList.size(); i++) {
            Integer integer = rsList.get(i);

            sum = sum + integer * Math.pow(10, (rsList.size()- i -1));

        }
        return sum;
    }


    public static long nextBiggerNumberOld2(long num) {

        List<Integer> dubuList = new ArrayList<>();


        String numString = String.valueOf(num);
        char[] chars = numString.toCharArray();

        List<Character> intList = new ArrayList<>();
        List<Integer> rsList = new ArrayList<>();
        List<Integer> nextRsList = new ArrayList<>();
        List<Character> ordList = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            intList.add(aChar);

        }


        ordList.addAll(intList);
        Collections.sort(ordList);

        for (int i = 0; i < intList.size(); i++) {
            Character integer = intList.get(i);
            rsList.add(Integer.valueOf(String.valueOf(integer)));
        }

        StringBuilder b = new StringBuilder();
        rsList.stream().forEach(b::append);

        nextRsList.addAll(rsList);

//        nextRsList.set(rsList.size() -2 ,nextRsList.size() -1);
//        if(getInterValue(nextRsList) > getInterValue(rsList)){
//
//        }else{
//            nextRsList.set(nextRsList.size() -1 ,nextRsList.size() -2);
//
//        }

        nextRsList = new ArrayList<>();
        nextRsList.addAll(rsList);

        for (int i = ordList.size() -2; i >= 0; i--) {



            Integer lstVal = rsList.get(rsList.size() -1);
            Integer curVal = rsList.get(i);

            nextRsList.set(i+1 ,curVal);
            nextRsList.set(i ,lstVal);

            if(getInterValue(nextRsList) >  getInterValue(rsList)){


//                System.out.println(getInterValue(nextRsList));


                List<Integer> sortAbleList = nextRsList.subList(i+1, nextRsList.size());
                Collections.sort(sortAbleList);
                List<Integer> headList = nextRsList.subList(0, i+1);

                headList.addAll(sortAbleList);

                dubuList = headList;


                break;
//                for (int j = i; j < ordList.size(); j++) {
//
////                    nextRsList.set(rsList.size()-j ,rsList.get(nextRsList.size() -1-i));
////                    nextRsList.set(rsList.size() -1-i ,rsList.get(nextRsList.size() -2-i));
//
//                }


            }

        }








//        return (long) getInterValue(dubuList);
        return 0;
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

