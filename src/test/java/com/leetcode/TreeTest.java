package com.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rigel on 8/4/17.
 */
public class TreeTest {

    private int[] mParent;
    private int[] mRank;

    /**
     * https://leetcode.com/problems/number-of-islands/description/
     *
     * @throws Exception
     */
    @Test
    public void disJointSet() throws Exception {

//        mParent = new int[]{ 1, 2, 3, 4, 5, 6, 7,8,9,10};
//        mRank =   new int[]{ 0, 0, 0, 0, 0, 0, 0,0,0,0};
        int[][] grids0 = new int[][]{
            {1, 1, 1, 1, 0}
            , {1, 1, 0, 1, 0}
            , {1, 0, 0, 0, 0}
            , {1, 1, 0, 0, 0}
            , {0, 0, 0, 0, 0}
        };

        int[][] grids1 = new int[][]{
              {1, 1, 0, 0, 0}
            , {1, 1, 0, 0, 0}
            , {1, 0, 0, 0, 0}
            , {0, 0, 1, 0, 0}
            , {0, 0, 0, 1, 1}
        };


        char[][] grids2 = new char[][]{
              {'1' , '0' , '1' , '0' , '1'}
            , {'0' , '1' , '1' , '1' , '0'}
            , {'1' , '0' , '1' , '0' , '1'}
            , {'0' , '1' , '0' , '1' , '0'}
            , {'1' , '0' , '1' , '0' , '1'}
        };

        char[][] grids = new char[][]{
              {'1' , '1' , '1' , '1' , '0'}
            , {'1' , '1' , '0' , '1' , '0'}
            , {'1' , '1' , '0' , '0' , '0'}
            , {'0' , '0' , '0' , '0' , '0'}
        };

//       ["11110","11010","11000","00000"]

        int arrCnt = 25;

        int rs= cal(grids);
        System.out.println( rs);

//        System.out.println("group is " +countset.size());
    }

    private int cal(char[][] grids) {
        int arrCnt = 0;
        if (grids.length > 0) {
            arrCnt = grids.length * grids[0].length;
        }
        mParent = new int[arrCnt];
        mRank = new int[arrCnt];


        for (int i = 0; i < arrCnt; i++) {
            mParent[i] = i;
            mRank[i] = 0;
        }



//        for (int i = 0; i < grids.length; i++) {
//            int[] rows = grids[i];
//            for (int j = 0; j < rows.length; j++) {
//                int col = rows[j];
//                System.out.print(col);
//
//            }
//            System.out.println("");
//
//        }

        for (int i = 0; i < grids.length; i++) {
            char[] rows = grids[i];
            for (int j = 0; j < rows.length; j++) {
                int mynum = i*rows.length +j ;
                int col = rows[j];

                System.out.print(String.format("%d :  %d ",mynum,col));

                int left = -1;
                int up= -1;
                if(j >0){
                    left = grids[i][j - 1];
                }
                if(i > 0 ){
                    up = grids[i - 1][j];
                }

                if(left == col){
                    unionSet( i*rows.length +j,i*rows.length +j-1);
                    System.out.print("LEFT");
                }
                if(up == col){
                    unionSet( i*rows.length +j,(i-1)*rows.length +j);
                    System.out.print("UP");
                }
                System.out.println(" ");
            }
            System.out.println(" ");
        }

        // count(set)

        Set countset = new HashSet<Integer>();

//        for (int i = 1; i < grids.length; i++) {
//            int[] rows = grids[i];
//            for (int j = 1; j < rows.length; j++) {
//                int col = rows[j];
//                int set = findSet(col);
//                countset.add(set);
//            }
//        }

        for (int i = 0; i < mParent.length; i++) {
            int i1 = mParent[i];
            int set = findSet(i1);
            countset.add(set);

        }

        return countset.size();


    }


    @Test
    public void countSetTest() throws Exception {

        Set set = new HashSet<Integer>();
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);




        System.out.println(set.size());
    }

    @Test
    public void unionTest ()  throws Exception {

        mParent = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        mRank =   new int[]{0, 0, 0, 0, 0, 0, 0, 0};

        unionSet(1,3);
        unionSet(3,4);
        unionSet(3,5);

        System.out.println("check");
    }

    @Test
    public void uionFindTest() throws Exception {

//       int [] mParent = new int[7];
//        mParent = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
//        mRank = new int[7];

        mParent = new int[]{0, 1, 1, 1, 4, 4, 4, 6};
        mRank =   new int[]{0, 1, 0, 0, 2, 0, 1, 0};

        int p = findSet(7);
//        int p2 = unionSet(1, 4);

        for (int i = 1; i < mParent.length; i++) {
            int set = findSet(mParent[i]);
            System.out.println(String.format("%d , %d",i,set));

        }

        System.out.println("check sort");

        // union
        int p2 = unionSet(1, 7);
        System.out.println("check sort");
    }

    private int unionSet(int s1, int s2) {

        int set1 = findSet(s1);
        int set2 = findSet(s2);

        int deep1 =  mRank[set1];
        int deep2 =  mRank[set2];

        if(set1 == set2){
            return  set1;
        }

        if(deep1 < deep2){
            mParent[set1] = set2;
            return set2;
        }else if(deep1 > deep2){
            mParent[set2] = set1;
            return set1;
        }else if(deep1 ==  deep2){
            mParent[set1] = set2;
            mRank[set2] = 1;
            return set2;

        }

        return -1;

    }

    private int findSet(int n) {

        if (mParent[n] == n) {
            return n;
        } else {
            int parentSet = findSet(mParent[n]);

            // update 최적화
            if (mRank[n] >= 2) {
                mRank[n] = mRank[n] - 1;
                mParent[n] = parentSet;
            }
            return parentSet;
        }
    }

}
