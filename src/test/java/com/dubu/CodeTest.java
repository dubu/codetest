package com.dubu;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.math.BigInteger;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by rigel on 10/25/16.
 */
public class CodeTest {

    @Test
    public void testesfdljslf() throws Exception {


        System.out.println("Fixed Tests calculateYears");
        assertEquals(3, calculateYears(1000,0.05,0.18,1100));
        assertEquals(14 , calculateYears(1000,0.01625,0.18,1200));
        assertEquals(0, calculateYears(1000,0.05,0.18,1000));

    }

    public static int calculateYears(double principal, double interest,  double tax, double desired) {
        // your code

        double nowMoney = principal;

        int yearFlag = 0;
        while (true) {
            if (nowMoney >= desired) {
                break;
            }

            double addMoney = nowMoney * interest;
            double minusMoney = addMoney * tax;
            nowMoney = nowMoney + addMoney - minusMoney;



            yearFlag++;

        }

        return yearFlag;
    }

    public static String getMiddle(String word) {
        //Code goes here!
        String rs = "";

        int length = word.length();

        int moc = length / 2 ;
        int nmz = length % 2;


        int centerLen = 2;
        if(nmz == 0){
            //even

            moc = moc -1;
        }else{
            //odd
            centerLen = 1;
        }

        String center = word.substring(moc,moc +centerLen);

        return  center;

    }


    @Test
    public void evenTests() {
        assertEquals("es", getMiddle("test"));
        assertEquals("dd", getMiddle("middle"));
    }

    @Test
    public void oddTests() {
        assertEquals("t", getMiddle("testing"));
        assertEquals("A", getMiddle("A"));
    }


    public static int[] race(int v1, int v2, int g) {

        if(v1 >v2){

            return null;
        }

        double hour = 0;
        long sec = 0;

        // v1 * hour + g =  v2 * hour ;
        //v2 * hour  - v1*hour =  g
        // (v2-v1)*hour =  g ;
        hour =  g/1.0 /(v2 -v1);
        sec  = (int) (hour * 60*60);

        int day  = (int) (sec / 24/60/60);
        LocalTime localTime = LocalTime.ofSecondOfDay(sec%(24*60*60));
        localTime.getHour();

        return new int[]{localTime.getHour() +day*24, localTime.getMinute() , localTime.getSecond()};
    }


    @Test
    public void testBestTests() {
        System.out.println("Basic Tests");
        assertArrayEquals(new int[]{0, 32, 18}, race(720, 850, 70));
        assertArrayEquals(new int[]{3, 21, 49}, race(80, 91, 37));
        assertArrayEquals(new int[]{2, 0, 0}, race(80, 100, 40));

    }

    public long evaluate(String s) {
        // write your magic code here

        String[] splits = s.split(" ");

        List<Long> intQueue = new ArrayList<Long>();

        Integer length = splits.length;


        Long sum = -99999999L ;
        for (int i = 0; i < splits.length; i++) {
            String el = splits[i];
//            System.out.println(el);


            Long lastVal;
            switch (el){
                case "+" :

                    lastVal = intQueue.remove(intQueue.size()-1);
                    if(sum == -99999999){
                        sum = lastVal;
                        lastVal = intQueue.remove(intQueue.size()-1);
                    }
                    sum =  lastVal + sum;
                   break;
                case "-" :

                    lastVal = intQueue.remove(intQueue.size()-1);
                    if(sum == -99999999){
                        sum = lastVal;
                        lastVal = intQueue.remove(intQueue.size()-1);
                    }
                    sum =  lastVal - sum;
                    break;
                case "*" :
                    lastVal = intQueue.remove(intQueue.size()-1);
                    if(sum == -99999999){
                        sum = lastVal;
                        lastVal = intQueue.remove(intQueue.size()-1);
                    }
                    sum =  lastVal * sum;
                    break;
               case "/" :
                    lastVal = intQueue.remove(intQueue.size()-1);
                    if(sum == -99999999){
                        sum = lastVal;
                        lastVal = intQueue.remove(intQueue.size()-1);
                    }
                    sum =  lastVal / sum.intValue();
                    break;

                default:
                    intQueue.add(Long.valueOf(el));
            }


        }

        return sum;

    }


    @Test
    public void test1() throws Exception {

        assertEquals(70, evaluate("25 45 +"));
        assertEquals(3600, evaluate("20 40 + 60 *"));  // (20+40) * 60
        assertEquals(2000, evaluate("20 40 60 + *")); // 20 * (40 + 60)
        assertEquals(10, evaluate("2 3 9 4 / + *"));

        assertEquals(10, evaluate("100 50 10 2 1 / / / /"));


        // fail !

    }

    public int solution(int number) {
        //TODO: Code stuff here

        int sum = 0;
        for (int i = 1; i <number ; i++) {

            if(i % 3  == 0 || i % 5  == 0){
                sum = sum + i;

            }

        }


        return  sum ;
    }


    @Test
    public void test() {
//        assertEquals(23, solution(10));
        assertEquals(23, solution(25));



    }


    public static List<long[]> removNb(long n) {
        // your code
        // 먼소린지
        return null;
    }


    @Test
    public void test12() {
        List<long[]> res = new ArrayList<long[]>();
        res.add(new long[] {15, 21});
        res.add(new long[] {21, 15});
        List<long[]> a = removNb(26);
        assertArrayEquals(res.get(0), a.get(0));
        assertArrayEquals(res.get(1), a.get(1));



    }
    @Test
    public void test14() {
        List<long[]> res = new ArrayList<long[]>();
        List<long[]> a = removNb(100);
        assertTrue(res.size() == a.size());
    }


    public static String[] dirReduc(String[] arr) {
        // Your code here.


        List<String> arrList = Arrays.asList(arr);
        List<String> rs = new ArrayList();

        String reducWord = "";

        for (int i = 0; i < arrList.size(); i++) {

            String bh = arrList.get(i);


            if(bh.equals(reducWord)){

                rs.remove(rs.size()-1);
//                reducWord = "";
                if(rs.size() == 0){
                    reducWord = "";

                }else{
                    reducWord = getString(rs.get(rs.size()-1));

                }

//                bh = rs.get(rs.size()-1);
//                rs.remove(1);
            }else {
                rs.add(bh);

                reducWord = getString(bh);

            }




        }


        //return new String[] {};
        //return (String[]) rs.toArray();
        return  rs.toArray(new String[rs.size()]);
    }

    private static String getString( String bh) {
        String reducWord= "";
        switch (bh){
            case "NORTH":
                reducWord = "SOUTH";
                break;
            case "SOUTH":
                reducWord = "NORTH";
                break;
            case "EAST":
                reducWord = "WEST";
                break;
            case "WEST":
                reducWord = "EAST";
                break;

        }
        return reducWord;
    }

    @Test
    public void testSimpleDirReduc() throws Exception {
        assertEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
            new String[]{"WEST"},
            dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));

        assertEquals("\"NORTH\", \"WEST\", \"SOUTH\", \"EAST\"",
            new String[]{"NORTH", "WEST", "SOUTH", "EAST"},
            dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}));
    }


    public boolean isValid(String braces) {
//        BraceChecker

        // Add code here


        List<Character> arrList = braces.chars().mapToObj((i) -> Character.valueOf((char)i)).collect(Collectors.toList());
        List<Character> rs = new ArrayList();


        Character reducWord = 0;
        for (int i = 0; i < arrList.size(); i++) {

            Character bh = arrList.get(i);


            if(bh.equals(reducWord)){

                rs.remove(rs.size()-1);
                if(rs.size() == 0){
                    reducWord = 0;

                }else{
                    reducWord = getCloseString(rs.get(rs.size()-1));

                }

            }else {
                rs.add(bh);

                reducWord = getCloseString(bh);

            }



        }

        System.out.println(rs.size());

        if(rs.size() > 0 ){

            return false;
        }
        return true;




    }

    private static char getCloseString( char c) {
        char reducWord = 0;
        switch (c) {
            case '(':
                reducWord = ')';
                break;
            case '{':
                reducWord = '}';
                break;
            case '[':
                reducWord = ']';
                break;
        }
        return reducWord;
    }


    @Test
    public void testValid() {
        assertEquals(true, isValid("()"));
    }

    @Test
    public void testInvalid() {
        assertEquals(false, isValid("[(])"));
    }



    public BigInteger listPosition(String word) {

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

        ArrayList<Integer> oriIntegerList = new ArrayList<>();

        for (int i = 0; i < charList.size(); i++) {
            Character character = charList.get(i);
            //System.out.print(wordMap.get(character));
            oriIntegerList.add(wordMap.get(character));
        }

        Collections.sort(oriIntegerList);

        System.out.print(oriIntegerList);

        ArrayList<Integer> baseIntegerList = new ArrayList<>(oriIntegerList);

//        01111111
//        11111110
//        11101111

        // java 8
//        Comparator<Employee> byEmployeeNumber = (e1, e2) -> Integer.compare(
//            e1.getEmployeeNumber(), e2.getEmployeeNumber());
//
//        employees.stream().sorted(byEmployeeNumber)
//            .forEach(e -> System.out.println(e));

//
//        for (int i = 0; i < baseIntegerList.size(); i++) {
//            Integer idx = baseIntegerList.get(i);
//
//            for (int j = 0; j < wordMap.size(); j++) {
//
//                Integer ele = wordMap.get(j);
//            }
//
//
//        }

//        ArrayList<List> all = new ArrayList<>();
//

        //순서를 우찌 찾나요 모르겠다
        //아이디어부제.

//        int [][] all = new int[baseIntegerList.size()][wordMap.size()];
//        for (int i = 0; i < baseIntegerList.size(); i++) {
//            Integer integer1 = baseIntegerList.get(i);
//            for (int j = 0; j < wordMap.size(); j++) {
//                Character keyChar = (Character) wordMap.keySet().toArray()[j];
//                Integer num = wordMap.get(keyChar);
//                all[i][j] = num;
//            }
//        }
//
//        System.out.println(all);

        return BigInteger.ZERO;
    }



    @Test
    public void testKnownInputs() {
        Anagrams anagram = new Anagrams();

//        assertEquals("Position for 'A' incorrect", BigInteger.ONE, listPosition("A"));
//        assertEquals("Position for 'ABAB' incorrect", BigInteger.valueOf(2), listPosition("ABAB"));
//        assertEquals("Position for 'AAAB' incorrect", BigInteger.ONE, listPosition("AAAB"));
//        assertEquals("Position for 'BAAA' incorrect", BigInteger.valueOf(4), listPosition("BAAA"));
//        assertEquals("Position for 'QUESTION' incorrect", BigInteger.valueOf(24572), listPosition("QUESTION"));
        assertEquals("Position for 'BOOKKEEPER' incorrect", BigInteger.valueOf(10743), listPosition("BOOKKEEPER"));
    }

    private class Anagrams {

    }

    @Test
    public void testListsfs() throws Exception {

        ArrayList<String> rsList = new ArrayList<>();
//        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Integer> integers = Lists.newArrayList(1,2,3);
//        Lists.newArrayList(1,integers);

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
                if(hereI != 0){
                    lineTrash = lineTrash.subList(0,hereI);
                }



                 //int startJ = rsList.size() / factorial(integers.size()-i-1);

//                int startJ = 0;
//                if(rsList.size() >=  i * factorial(integers.size()-i-1) ){
//                    startJ = rsList.size() / factorial(integers.size()-i-1);
//                }


/*
                if( i > 0 && i < idx.size()-1  && rsList.size() >= i * factorial(integers.size()-i-1) ){
//                    if(i > 0 && factorial(integers.size()-i-1) != 0 &&  rsList.size() >= j * factorial(integers.size()-i-1) ){
                    continue;
                }
*/







//                maxCapacity = factorial(integers.size()-i-1);

                for (int j = hereJ; j < integers.size(); j++) {
//                    Integer integer = integers.get(j);

//                    if( j > 0 && i < idx.size()-1  && rsList.size() >= j * factorial(integers.size()-i-1) ){
//                    if(i > 0 && factorial(integers.size()-i-1) != 0 &&  rsList.size() >= j * factorial(integers.size()-i-1) ){
//                    if(   rsList.size() >= (j+1) * factorial(integers.size()-i-1)  ){
//                        continue;
//                    }

//                    if(maxCapacity == 0 ){
//                        continue;
//                    }
                    Integer x = idx.get(j);

                    int keyVal = i * 25 + x;
//                    if(trash.contains(keyVal) || lineTrash.contains(j) ){




                    if(lineTrash.contains(j) ){
                        continue; // 숫자를 올린다
                    }else{

//                        Integer capa = maxValueMap.get(keyVal);
//                        if (capa == null) {
//                            maxValueMap.put(keyVal, factorial(integers.size() - 1));
//                        }
//
//                        Integer currentSize = maxValueMap.get(keyVal);
//                        if (currentSize == 0) {
//                            continue;
//                        } else {
//                            maxValueMap.put(keyVal, maxValueMap.get(keyVal) - 1);
//                        }

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

            if(rsList.size() >= factorial(integers.size()) ){
                break;
            }
            //
        }


    }

    @Test
    public void testFactory() throws Exception {

        // 20억
        ArrayList<Integer> intList = new ArrayList<>();

//        fact(intList);
        // num  0~24 25자
        //25진법
    }

    @Test
    public void testPick() throws Exception {


//        int factorial = factorial(25);

        // 20억
        System.out.println(factorial(25));


        System.out.println(Integer.MAX_VALUE);

    }

    int factorial(int n)
    {
        int fact = 1;
        for(int c = 1; c <= n; c++)
            fact = fact * c;
        return fact;
    }

}

