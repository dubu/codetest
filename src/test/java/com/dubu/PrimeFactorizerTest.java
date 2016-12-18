package com.dubu;

/**
 * Created by dubu on 2016-12-17.
 *
 * https://www.codewars.com/kata/prime-factorization/train/java
 */
import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PrimeFactorizerTest {
    private static PrimeFactorizer worker;

    private final long n;
    private final Map<Long, Integer> factors;

    public PrimeFactorizerTest(long n, Map<Long, Integer> factors) {
        this.n = n;
        this.factors = factors;
    }

    @Parameterized.Parameters
    public static Collection<?> tests() {
        return Arrays.asList(new Object[][] {
                {72057554846356487L, asMap(13, 1)}
//                ,{24L, asMap(2, 3, 3, 1)}
//                ,{343L, asMap(7, 3)}
        });
    }

    private static Map<Long, Integer> asMap(long...data) {
        Map<Long, Integer> result = new HashMap<Long, Integer>(data.length >> 1);
        for (int i = 0; i < data.length; ++i)
            result.put(data[i], (int) data[++i]);
        return result;
    }
    @BeforeClass
    public static void init(){
        worker = new PrimeFactorizer();
    }
    @Test
    public void test() {
        assertEquals(factors, worker.factor(n));
//        worker.factor(n);

    }
}

class PrimeFactorizer{
    public java.util.Map<Long, Integer> factor(long n){

//        System.out.println(n);


        boolean isPrimeNumber = true;

        Map map = new HashMap<Long,Integer>();

        for (Long j = 2L; j <= 2; j++) {
            long nn = n;
            if (nn % j == 0) {
                Integer cnt = 0;

                long mod = nn % j;
                while(mod == 0){
                    nn =  nn /j;
                    cnt = cnt +1;
                    mod = nn % j;
                }

                map.put(j, cnt);

                n = nn;
                isPrimeNumber = false;
                // break; // exit the inner for loop
            }
        }

        for (Long j = 3L; j <= n; j=j+2) {

            if(j > 400000000){
                map.put(n, 1);
                break;

            }
            long nn = n;
            if (nn % j == 0) {
                Integer cnt = 0;

                long mod = nn % j;
                while(mod == 0){
                    nn =  nn /j;
                    cnt = cnt +1;
                    mod = nn % j;
                }

                map.put(j, cnt);

                n = nn;


                isPrimeNumber = false;
               // break; // exit the inner for loop
            }
        }


//        for (int j = 2; j < i; j++) {
//            if (i % j == 0) {
//                isPrimeNumber = false;
//                break; // exit the inner for loop
//            }
//        }


        return map;
    }
}