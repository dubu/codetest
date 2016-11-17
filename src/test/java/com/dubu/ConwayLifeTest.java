package com.dubu;

/**
 * Created by rigel on 11/17/16.
 *
 *
 * https://www.codewars.com/kata/conways-game-of-life-unlimited-edition/train/java
 *
 *
 */
import java.io.Console;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConwayLifeTest{

    @Test
    public void testGlider() {
        int[][][] gliders = {
            {{1,0,0},
                {0,1,1},
                {1,1,0}},
            {{0,1,0},
                {0,0,1},
                {1,1,1}}
        };
        System.out.println("Glider");
        LifeDebug.print(gliders[0]);
        int[][] res = ConwayLife.getGeneration(gliders[0], 1);
        assertTrue("Got \n" + LifeDebug.htmlize(res) + "\ninstead of\n" + LifeDebug.htmlize(gliders[1]), LifeDebug.equals(res, gliders[1]));


//        assertTrue("hello world", true);
    }





}



 class ConwayLife {

    public static int[][] getGeneration(int[][] cells, int generations) {
        // your code goes here
        return null;
    }

}

class LifeDebug {


    public static void print(int[][] glider) {

    }

    public static String htmlize(int[][] res) {
        return null;
    }

    public static boolean equals(int[][] res, int[][] glider) {
        return false;
    }
}