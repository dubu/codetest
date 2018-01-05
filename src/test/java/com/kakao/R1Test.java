package com.kakao;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * https://programmers.co.kr/learn/challenges/591?language=java
 */
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
        int n = 15;

        //41
        // **++++*++
        // *+**+++++
        // (+ (* (* 1 3) 3) 1) = 41
        // 3으로 나누어 지는가 ? 3보다 큰가?
        // 아니면 1을 뺀다.

        System.out.println(solution(n));

    }

    int solution(int n) {
        int answer = 0;

        List re = new ArrayList();

        while(n != 1 && n !=2 && n !=3 ) {

            if (n % 3 == 0) {
                re.add(n -1);
                n  = n/3;
            }else{
                n = n -1;
            }

            if(n == 1 || n ==2  || n==3){
                answer = answer +1;
                if(re.size() ==  0){
                    break;
                }
                n = (int) re.remove(0);
            }
        }

        return answer;
    }


    @Test
    public void colorBookTest() {

        //6	4	[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]	[4, 5]
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] rs = colorBook(6, 4, picture);

        System.out.println(rs);

    }


    public int[] colorBook(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;


        Map map =  new HashMap();

        List checkTable =  new ArrayList();
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
//                checkTable.add(new int[]{i,j});

                int x = i;
                int y = j;
                int symbol = picture[x][y];
                if (symbol == 0) {
                    continue;
                }

                int up = 0, down = 0, left = 0, right = 0;

                if (y != 0) up = picture[x][y - 1];
                if (y + 1 < n) down = picture[x][y + 1];
                if (x != 0) left = picture[x - 1][y];
                if (x + 1 < m) right = picture[x + 1][y];

//                if (symbol == up || symbol == down || symbol == left || symbol == right) {
                    if (symbol == up  || symbol == left ) {

                    map.put(symbol, (int) (map.get(symbol))+ 1);
                } else {
                        numberOfArea = numberOfArea +1 ;
                        map.put(symbol, 1);
                }
            }


        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int[] colorBook2(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;


        Map map =  new HashMap();

        List checkTable =  new ArrayList();
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                checkTable.add(new int[]{i,j});
            }
        }

        while (checkTable.size() >0){
            int[]  pos = (int[]) checkTable.remove(0);

            int x=  pos[0];
            int y=  pos[1];

            int symbol = picture[x][y];
            if (map.get(symbol)==null) {
                map.put(symbol,1);
            }else{
                // check up, down, left, right

                int up = 0, down = 0,left = 0,right = 0;

                if(y !=0 ) up = picture[x][y - 1];
                if(y+1 <n) down = picture[x][y + 1];
                if(x !=0 )left = picture[x - 1][y];
                if(x+1 < m)right = picture[x + 1][y];

                if(symbol == up || symbol == down || symbol == left || symbol ==right){

                    map.put(symbol,(int)(map.get(symbol))+1);
                }

            }

        }


        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
