package com.dubu;

import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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


    public static List<long[]> removNb(long n) {
        // your code
        return null;
    }


}
