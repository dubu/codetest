package com.dubu;

/**
 * Created by rigel on 12/30/16.
 */
import static org.junit.Assert.*;
import java.text.DecimalFormat;
import org.junit.Test;


class Magnets {

    public static double doubles(int maxk, int maxn) {
        // your code

        double sum = 0;
        for (int i = 1; i <= maxk; i++) {

            double rs = frac(1, i, maxn);
            sum = sum + rs;

        }

        return sum;
    }

    private static double frac(double x, int maxk, int maxn) {

        if(x == maxn){
            return 1 / (maxk * Math.pow(maxn + 1, 2 * maxk));

        }else{
            double value = 1 / (maxk * Math.pow(x + 1, 2 * maxk));
            return  value +frac(x +1,maxk,maxn);
        }

    }
}



public class MagnetsTest {

    private static void assertFuzzyEquals(double act, double exp) {
        boolean inrange = Math.abs(act - exp) <= 1e-6;
        if (inrange == false) {
            DecimalFormat df = new DecimalFormat("#0.000000");
            System.out.println("At 1e-6: Expected must be " + df.format(exp) +", but got " + df.format(act));
        }
        assertEquals(true, inrange);
    }
    @Test
    public void test1() {
        System.out.println("Fixed Tests: doubles");
//        assertFuzzyEquals(Magnets.doubles(1, 10), 0.5580321939764581);
//        assertFuzzyEquals(Magnets.doubles(10, 1000), 0.6921486500921933);
        assertFuzzyEquals(Magnets.doubles(10, 10000), 0.6930471674194457);
        assertFuzzyEquals(Magnets.doubles(20, 10000), 0.6930471955575918);
    }
}
