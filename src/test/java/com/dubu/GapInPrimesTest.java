package com.dubu;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Created by rigel on 11/17/16.
 *
 * Honor Position:#24013 / 84%
 *
 *
 */
public class GapInPrimesTest {
    @Test
    public void test() {
        System.out.println("Fixed Tests");
        assertEquals("[101, 103]", Arrays.toString(GapInPrimes.gap(2,100,110)));
        assertEquals("[103, 107]", Arrays.toString(GapInPrimes.gap(4,100,110)));
        assertEquals(null, GapInPrimes.gap(6,100,110));
        assertEquals("[359, 367]", Arrays.toString(GapInPrimes.gap(8,300,400)));
        assertEquals("[337, 347]", Arrays.toString(GapInPrimes.gap(10,300,400)));

//        List rs = GapInPrimes.gap(2,100,110);
//        GapInPrimes gapInPrimes = new GapInPrimes();
//        gapInPrimes.gap(2,100,110);

    }


//    @Test
//    public void testIsPrimeNumber() throws Exception {
//        System.out.println(isPrimeNumber(2,1012, 2000));
//
//    }

//    private List<Integer> isPrimeNumber(int g ,int m , int n) {
//
//        List<Integer> primes = new ArrayList<>();
//
//        // loop through the numbers one by one
//        for (int i = m; i < n; i++) {
//            boolean isPrimeNumber = true;
//
//            // check to see if the number is prime
//            for (int j = 2; j < i; j++) {
//                if (i % j == 0) {
//                    isPrimeNumber = false;
//                    break; // exit the inner for loop
//                }
//            }
//
//            // print the number if prime
//            if (isPrimeNumber) {
//                primes.add(i);
//
//                if(primes.size() > 2 ){
//
////                    for (int j = primes.size()-1; j >=0 ; j--) {
////                        primes.get(j);
////
////                    }
//
//                    Integer lstVal = primes.get(primes.size() - 1);
//                    Integer llstVal = primes.get(primes.size() - 2);
//                    if(lstVal - llstVal == g){
//                        return  Arrays.asList(llstVal ,lstVal);
//                    }
//
//                }
//
//            }
//        }
//        System.out.println("The number of prime is: " + primes.size() + ", and they are: " + primes.toString());
//
//
//        return null;
//    }
}

class GapInPrimes {

    public static long[] gap(int g, int m, int n) {


        List<Integer> primes = new ArrayList<>();

        // loop through the numbers one by one
        for (int i = m; i < n; i++) {
            boolean isPrimeNumber = true;

            // check to see if the number is prime
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrimeNumber = false;
                    break; // exit the inner for loop
                }
            }

            // print the number if prime
            if (isPrimeNumber) {
                primes.add(i);

                if(primes.size() >= 2 ){

//                    for (int j = primes.size()-1; j >=0 ; j--) {
//                        primes.get(j);
//
//                    }

                    Integer lstVal = primes.get(primes.size() - 1);
                    Integer llstVal = primes.get(primes.size() - 2);
                    if(lstVal - llstVal == g){
//                        return  Arrays.asList(llstVal ,lstVal);
                        return  new long[]{llstVal,lstVal};
                    }

                }

            }
        }
//        System.out.println("The number of prime is: " + primes.size() + ", and they are: " + primes.toString());
        return null;
    }
}
