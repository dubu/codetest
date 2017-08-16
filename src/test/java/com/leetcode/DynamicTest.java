package com.leetcode;

import org.junit.Test;

/**
 * Created by rigel on 8/3/17.
 *
 */
public class DynamicTest {

    /**
     *
     * https://leetcode.com/problems/climbing-stairs/
     * https://leetcode.com/problems/maximum-subarray
     *
     */

    /**
     *
     * https://leetcode.com/problems/minimum-path-sum/description/
     * @throws Exception
     */
    @Test
    public void min() throws Exception {

//        List<Integer> grid = Arrays.asList(3, 2, 9, 2);
        int [][] grid = new int[5][4];
        grid[0] = new int[]{3, 2, 9, 2};
        grid[1] = new int[]{1,3,2,1};
        grid[2] = new int[]{5,1,10,8};
        grid[3] = new int[]{2,5,6,3};
        grid[4] = new int[]{6,7,4,3};

        int [][] point = new int[5][4];

        for (int i = 0; i < grid.length; i++) {
            int[] ints = grid[i];
//            System.out.println(ints);
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
//                System.out.println(anInt);

                // first row
                if(i == 0 ){
                    if(j == 0) {
                        point[i][j] = grid[i][j];
                    }else {

                        point[i][j] = point[i][j-1] + grid[i][j];
                    }
                }else{

                    // col 0
                    if(j == 0){

                        point[i][j] =  point[i-1][j] + grid[i][j];
                    }else{
                        point[i][j] = Math.min(point[i-1][j] + grid[i][j],point[i][j-1] + grid[i][j]);
                    }
                }
            }
        }

        int lenX = point[0].length - 1;
        int lenY = point.length - 1;

        // max
        int returnVal = point[lenY][lenX];
        System.out.println(returnVal);
    }



}