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

import java.util.Arrays;

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
                {1,0,1},
                {0,1,1},
                {0,1,0}
            }
        };
        System.out.println("Glider");
        LifeDebug.print(gliders[0]);
        int[][] res = ConwayLife.getGeneration(gliders[0], 2);


//        System.out.println(res);
        assertTrue("Got \n" + LifeDebug.htmlize(res) + "\ninstead of\n" + LifeDebug.htmlize(gliders[1]), LifeDebug.equals(res, gliders[1]));


//        assertTrue("hello world", true);
    }



//
//    testGlider(ConwayLifeTest)
//    Log
//        Glider
//    ▓▓░░░░
//    ░░▓▓▓▓
//    ▓▓▓▓░░
//        ✘ Got
//    ░░░░░░
//    ▓▓░░▓▓
//    ░░▓▓▓▓
//    instead of
//    ░░▓▓░░
//    ░░░░▓▓
//    ▓▓▓▓▓▓


}



 class ConwayLife {

     static int LIVE =1;
     static int DIE = 0;

    public static int[][]  getGeneration(int[][] cells, int generations) {

//        System.out.println(generations);
        int lenY = cells.length;
        int lenX = cells[0].length;
        int[][] generated = new int[lenY][lenX];

        for (int j = 0; j <lenY; j++) {

            for (int i = 0; i < lenX; i++) {
                int i1 = cells[j][i];
                generated[j][i] = i1;
            }
        }

        for (int i = 0; i < generations; i++) {

            generated = getGenerationOneTime(generated);
        }
        return generated;
    }

     private static int[][] getGenerationOneTime(int[][] coreCells) {
         int[][] cells  = addBoundry(coreCells);

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

         int[][] cropCell = crop(copyCells);
//         return copyCells;
         return cropCell;
     }

     private static int[][] crop(int[][] cells) {


         // find boundry

         int initY = -1;
         int initX = -1;

         int lenY = cells.length;
         int lenX = cells[0].length;

         int endY = -1;
         int endX = -1;



         // check Y

         for (int j = 0; j < lenY; j++) {

             int rowsum = 0;
             for (int i = 0; i < lenX; i++) {

                 int curVal = cells[j][i];
                 rowsum = rowsum + curVal;
             }

             if(initY == -1 && rowsum >0 ){
                 initY = j;
             }

             if(initY != -1 && rowsum != 0 ){
                 endY = j;
             }


         }

         // ckeck X
         for (int i = 0; i < lenX; i++) {
             int virtSum = 0;
             for (int j = 0; j < lenY; j++) {

                 int curVal = cells[j][i];
                 virtSum = virtSum +curVal;
             }


             if(initX == -1 && virtSum >0 ){
                 initX = i;
             }

             if(initX != -1 && virtSum !=0 ){
                 endX = i;
             }
         }


//         System.err.printf("%d %d %d %d",initX,endX,initY,endY);


         // ??
          int [][] copyCells = new int[endY-initY+1][endX-initX+1];
         for (int j = initY; j < endY+1; j++) {

             for (int i = initX; i < endX+1; i++) {

                 int curVal = cells[j][i];
                 copyCells[j-initY][i-initX] = curVal;
             }
         }
         return copyCells;


//         return new int[0][];
     }

     private static int[][] addBoundry(int[][] cells) {

//         int[][] data = {{1, 2}, {3, 4}};
//         int[][] dataCopy = Arrays.stream(data)
//             .map((int[] row) -> row.clone())
//             .toArray((int length) -> new int[length][]);

         int lenY = cells.length;

         int lenX = cells[0].length;

         int [][] copyCells = new int[lenY+2][lenX+2];

         for (int j = 0; j < lenY; j++) {

             for (int i = 0; i < lenX; i++) {

                 int curVal = cells[j][i];
                 copyCells[j+1][i+1] = curVal;
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
    static int LIVE =1;
    static int DIE = 0;

    public static void print(int[][] cells) {
        int lenY = cells.length;
        int lenX = cells[0].length;

        for (int j = 0; j <lenY; j++) {

            for (int i = 0; i <lenX; i++) {

                System.out.print(cells[j][i]);
            }

            System.out.println("");
        }

    }

    public static String htmlize(int[][] cells) {

        StringBuffer sb = new StringBuffer();
        int lenY = cells.length;
        int lenX = cells[0].length;

        for (int j = 0; j <lenY; j++) {

            for (int i = 0; i <lenX; i++) {

                int i1 = cells[j][i];
                if(i1 == LIVE){
                    //System.out.println("▓▓");
                    sb.append("▓▓");

                }else if (i1 == DIE){
                    sb.append("░░");
                    //System.out.println("░░");

                }
//                System.out.print(cells[j][i]);
            }

            //System.out.println("");
            sb.append("\n");
        }


        return sb.toString();
    }

    public static boolean equals(int[][] res, int[][] cells) {


        boolean isEqual = true;
        int lenY = cells.length;
        int lenX = cells[0].length;

        for (int j = 0; j <lenY; j++) {

            for (int i = 0; i < lenX; i++) {
                int i1 = cells[j][i];
                int i2 = res[j][i];
                if(i1 != i2){
                    isEqual = false;
                    return isEqual;
                }

            }
        }
        return isEqual;
    }
}