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


    /**
     * https://leetcode.com/problems/maximum-subarray/description/
     */
    @Test
    public void maxSubArray() {

        int[] ints = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] ints = {1};
//        int[] ints = {-2,1};

//        [8,-19,5,-4,20]
        System.out.println(maxSubArray2(ints));
    }



//    public int maxSubArray(int[] nums) {
//
//        if(nums.length ==0 ){
//            return 0;
//        }
//
//        int res = nums[0];
//        int sum = nums[0];
//
//        for (int i = 0; i <nums.length; i++) {
//            sum = Math.max(sum+nums[i],nums[i]);
//            res =  Math.max(res,sum);
//
//        }
//        return res;
//    }


    public int maxSubArray2(int[] nums) {
        // if minus 이면 다시 시작!

        // 4,-1,2,1, = 6

        int Max = 0;

        if (nums.length>0) {
            Max = nums[0];
        }

        for (int i = 0; i < nums.length; i++) {


            // reset subSum
            int subSum = nums[i];
            for (int j = i; j < nums.length; j++) {

                if (j==i) {
                    subSum = nums[j];
                    Max= Math.max(subSum,Max);
                    continue;
                }

//                int n0 =  nums[j-1];
                int n1 =  nums[j];
                subSum =  subSum +n1;
//                int sum = Max + n1;
                if(n1 <0){

                }else{
                    Max= Math.max(subSum,Max);
                }

                if(subSum < n1){
                    subSum =  n1;
                    i = j-1;
                    break;
                }

            }

        }

        return  Max ;
    }


    /**
     * 516
     * https://leetcode.com/problems/longest-palindromic-subsequence/description/
     * 409
     * https://leetcode.com/problems/longest-palindrome/description/
     */
    @Test
    public void longPaliWord() {

//        "bbbab" 4
//        "cbbd" 2

        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));


    }

    public int longestPalindromeSubseq(String s) {

        if (s.length()==0) {
            return 0;
        }



        return -9;

    }

    /**
     *
     *
     * abccccdd   =  dccaccd 7
     *
     */
    @Test
    public void longPalWord() {


        // mod 짝수 , max 홀 앤 , 나머지는 버림.

        String s = "abccccdd";
        longestPalindrome(s);


    }
    public int longestPalindrome(String s) {

        if (s.length()==0) {
            return 0;
        }



        return -9;
    }

}
