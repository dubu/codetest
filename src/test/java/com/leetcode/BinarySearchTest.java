package com.leetcode;

import org.junit.Test;

/**
 * Created by rigel on 8/14/17.
 */
public class BinarySearchTest {


    @Test
    public void findTest() throws Exception {

        System.out.println("aa      ");


        int[] arr = {1,22,23,24,35,46,57,68,69,610};
        int rs  = binarySearch(arr, 24);

        System.out.println(rs);

    }

    private int binarySearch(int[] arr, int key) {
        int time  = 0 ;
        int min = 0;
        int max =  arr.length -1;

        while(min <=max){

            int mid = (min+max)/2;

            if (arr[mid] < key) {
                min = mid;
            } else if (arr[mid] > key){
                max = mid;
            }else if (arr[mid] == key){
                System.out.println(time);
                return arr[min];
            }
            time = time +1;
        }

//        for (int i = 0; i < arr.length; i++) {
//            int i1 = arr[i];
//
//
//
//            if(i1 < key){
//
//            }else if(i1 > key){
//
//            }else if(i1 ==  key){
//                return i1;
//
//            }
//
//        }

        return  -1;
    }

}
