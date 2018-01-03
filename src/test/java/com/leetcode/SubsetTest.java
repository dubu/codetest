package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * https://leetcode.com/problems/subsets/description/
 * Created by rigel on 8/14/17.
 */
public class SubsetTest {


    @Test
    public void passTest() throws Exception {

        int [] nums = {1,2,3,4,5};
//        int [][] arr  = subset(nums);
//        List nums = new ArrayList<Integer>();
//        List arr =  new ArrayList<List<Integer>>();

//        List nums = Arrays.asList(1,2,3,4,5);
        List<List<Integer>>  arr = subset(nums);
        System.out.println(arr);

    }

    private List<List<Integer>> subset(int[] nums) {

        int n ;
        List<Integer>  s;
        List<List<Integer>>  res  =  new ArrayList<>();
        n = 1 << nums.length;
        for (int i = 0; i <n; i++) {
            s = new ArrayList<>();
            for (int j = 0, k = i ; j < i ; j++, k >>=1) {
                if ((k & 1) == 1) {
                    s.add(nums[j]);
                }
            }
            res.add(s);
        }
        return  res;

    }




}
