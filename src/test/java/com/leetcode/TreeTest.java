package com.leetcode;

import org.junit.Test;

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

        int[][] grids = new int[][]{
            {1, 1, 1, 1, 0}
            , {1, 1, 0, 1, 0}
            , {1, 0, 0, 0, 0}
            , {1, 1, 0, 0, 0}
            , {0, 0, 0, 0, 0}
        };

        int[][] grids2 = new int[][]{
            {1, 1, 0, 0, 0}
            , {1, 1, 0, 0, 0}
            , {1, 0, 0, 0, 0}
            , {0, 0, 1, 0, 0}
            , {0, 0, 0, 1, 1}
        };

        for (int i = 0; i < grids.length; i++) {
            int[] rows = grids[i];
            for (int j = 0; j < rows.length; j++) {
                int col = rows[j];
                System.out.print(col);

            }
            System.out.println("");

        }

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

        if(deep1 < deep2){
            mParent[set1] = set2;
            mRank[set1] = 1;
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
