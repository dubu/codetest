package com.dubu;

/**
 * Created by rigel on 11/17/16.
 *
 *
 * https://www.codewars.com/kata/conways-game-of-life-unlimited-edition/train/java
 *
 *
 */

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConwayLifeTest{

    @Test
    public void testGlider() {
        int[][][] gliders = {
            {
                {1,0,0},
                {0,1,1},
                {1,1,0}
            },
            {
                {0,1,0},
                {0,0,1},
                {1,1,1}
            }
        };
        System.out.println("Glider");
        LifeDebug.print(gliders[0]);
        int[][] res = ConwayLife.getGeneration(gliders[0], 1);


        System.out.println(res);
        //assertTrue("Got \n" + LifeDebug.htmlize(res) + "\ninstead of\n" + LifeDebug.htmlize(gliders[1]), LifeDebug.equals(res, gliders[1]));


//        assertTrue("hello world", true);
    }





}



 class ConwayLife {

     static int LIVE =1;
     static int DIE = 0;

    public static int[][]  getGeneration(int[][] cells, int generations) {

        int lenY = cells.length;

        int lenX = cells[0].length;

        int [][] copyCells = new int[lenY][lenX];

        for (int j = 0; j < lenY; j++) {

            for (int i = 0; i < lenX; i++) {

                int curVal = cells[j][i];
                int rsVal = -1;
                if (curVal == LIVE){
                    rsVal = isNextDie(cells,j,i);
                }else if(curVal == DIE){
                    rsVal = isNextLive(cells,j,i);
                }
                copyCells[j][i] = rsVal;

            }
        }

        return copyCells;
    }

     private static int isNextLive(int[][] cells, int y, int x) {
         int startX = x -1;
         int startY = y -1;
         int endX = x +2;
         int endY = y +2;

         if(startX <0){
             startX =0;
         }

         if(startY <0){
             startY =0;
         }

         if(endX > cells[0].length){
             endX= cells[0].length;
         }

         if(endY > cells.length){
             endY= cells.length;
         }

         int sumNeiLive = 0;
         for (int j = startY; j < endY; j++) {
             for (int i = startX; i < endX; i++) {

                 if(i > -1 && j > -1 ){

                     if(j == y && i == x){
                         // nothing
                     }else{
                         int i1 = cells[j][i];
                         sumNeiLive = sumNeiLive +i1;
                     }
                 }
             }
         }

         if(sumNeiLive ==3){
             return LIVE;
         }else{
             return DIE;
         }
     }

     private static int isNextDie(int[][] cells, int y, int x) {

         int startX = x -1;
         int startY = y -1;
         int endX = x +2;
         int endY = y +2;

         if(startX <0){
             startX =0;
         }

         if(startY <0){
             startY =0;
         }

         if(endX > cells[0].length){
             endX= cells[0].length;
         }

         if(endY > cells.length){
             endY= cells.length;
         }



         int sumNeiLive = 0;
         for (int j = startY; j < endY; j++) {
             for (int i = startX; i < endX; i++) {

                 if(i > -1 && j > -1 ){

                     if(j == y && i == x){
                         // nothing
                     }else{
                         int i1 = cells[j][i];
                         sumNeiLive = sumNeiLive +i1;
                     }
                 }
             }
         }

         if(sumNeiLive ==2 || sumNeiLive ==3){
             return LIVE;
         }else{
             return DIE;
         }

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