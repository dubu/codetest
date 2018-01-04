package com.kakao;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class R1Test {


    /**
     *
     * n1	8
     g1	[[3, 1], [5, 7], [8, 7], [2, 3], [3, 6], [1, 5], [4, 3]]
     n2	9
     g2	[[1, 5], [5, 6], [3, 7], [3, 1], [7, 4], [7, 2], [9, 8], [5, 9]]
     answer	7
     */
    @Test
    public void AsomeObj() {

        int n1 = 8;
        int[][] g1 = new int[][]{{3, 1}, {5, 7}, {8, 7}, {2, 3}, {3, 6}, {1, 5}, {4, 3}};
        int n2 = 9;
        int[][] g2 = new int[][]{{1, 5}, {5, 6}, {3, 7}, {3, 1}, {7, 4}, {7, 2}, {9, 8}, {5, 9}};
//        solution(n1,g1,n2,g2);
        asomeObjSolve(8,g1,9,g2);


//        BinaryTree tree = new BinaryTree();
//        tree.root = new Node(1);
//        tree.root.left = new Node(2);
//        tree.root.right = new Node(3);
//        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(5);
//
//        System.out.println("The size of binary tree is : " + tree.size());
    }

    public int asomeObjSolve(int n1, int[][] g1, int n2, int[][] g2) {

        int answer = 0;
        return answer;
    }


    @Test
    public void sound4Test() {

        // *3
        // +1
        int n = 10;

        solution(n);

    }

    int solution(int n) {
        int answer = 0;

        return answer;
    }
}
