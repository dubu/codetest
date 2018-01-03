package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HashTableTest {

    /**
     * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
     *
     */
    @Test
    public void name() {
        int[] num1= {1,2,2,1};

        int[] num2 = {2,2};


//        System.out.println(intersect(num1, num2).length);

        int[] intersect = intersect(num1, num2);

        System.out.println(intersect);

    }

    public int[] intersect(int[] nums1, int[] nums2) {


        Arrays.sort(nums1);
        Arrays.sort(nums2);


        Map m1 = mpaMize(nums1);
        Map m2 = mpaMize(nums2);


        int sum = 0 ;
        List<Integer> rs = new ArrayList<>();
        Iterator iterator = m1.keySet().iterator();
        while (iterator.hasNext()) {
            int k = (int) iterator.next();


            if (m1.get(k) != null && m2.get(k)!= null){
                int i1 = (int) m1.get(k);
                int i2 = (int) m2.get(k);
                sum = sum + Math.min(i1,i2);


                for (int i = 0; i < Math.min(i1,i2); i++) {
                    rs.add(k);

                }
            }

        }

        System.out.println(sum);
        return rs.stream().mapToInt(i->i).toArray();
//        return new int[0];

    }

    private Map mpaMize(int[] nums1) {
        HashMap hashMap = new HashMap();

        for (int i = 0; i < nums1.length; i++) {

             int num = nums1[i];

            if (hashMap.get(num)==null) {
                hashMap.put(num,1);
            }else{
                int cnt = (int) hashMap.get(num)+1;
                hashMap.put(num, cnt);
            }


        }
        return hashMap;
    }


    @Test
    public void toSumTest() {

//        int[] nums = {2,7,11,15};
        int[] nums0 = new int[]{2,7,11,15};
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(ints);

    }


    public int[] twoSum(int[] nums, int target) {


        List<Integer> ansList = new ArrayList();
        for (int i = 0; i <nums.length; i++) {

            int num = nums[i];

            if (ansList.contains(num)) {
                System.out.println(num);
                System.out.printf("빙고");

               return new int[]{ansList.indexOf(num) , i} ;

            }

            int abs = Math.abs(target - num);

            if(target > num){
                ansList.add( abs);
            }else{
                ansList.add(- abs);
            }
        }

        return ansList.stream().mapToInt(i->i).toArray();
    }

}
