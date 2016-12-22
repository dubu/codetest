package com.dubu;

/**
 * Created by dubu on 2016-12-22.
 */
import org.junit.runners.JUnit4;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.math.BigInteger;


class FKata {

    public static String Factorial(int n) {


        BigInteger rs = Fac(n);

        return String.valueOf(rs);
    }

    private static BigInteger Fac(int n) {
        if (n == 1) {
            return BigInteger.ONE;
        } else {
            return Fac(n - 1).multiply(BigInteger.valueOf(Long.valueOf(n)));
        }

    }

}

public class FKataTests {

    @Test
    public void BasicTests()
    {
        assertEquals("1", FKata.Factorial(1));
        assertEquals("120", FKata.Factorial(5));
        assertEquals("362880", FKata.Factorial(9));
        assertEquals("1307674368000", FKata.Factorial(15));
    }

}

