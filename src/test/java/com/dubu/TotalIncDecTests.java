package com.dubu;

/**
 * Created by dubu on 2016-12-22.
 */
import static org.junit.Assert.*;

import java.math.BigInteger;
import org.junit.Test;

class TotalIncreasingOrDecreasingNumbers{
    public static BigInteger totalIncDec(int x){
        // Good Luck!
        return null;
    }
}

public class TotalIncDecTests{
    private static void tester(int inp, BigInteger exp){
        assertEquals("Testing for total below 10<sup>" + inp + "</sup>\n", exp, TotalIncreasingOrDecreasingNumbers.totalIncDec(inp));
    }
    @Test
    public void basicTests(){
        tester(0, BigInteger.valueOf(1));
        tester(1, BigInteger.valueOf(10));
        tester(2, BigInteger.valueOf(100));
        tester(3, BigInteger.valueOf(475));
        tester(4, BigInteger.valueOf(1675));
    }
}