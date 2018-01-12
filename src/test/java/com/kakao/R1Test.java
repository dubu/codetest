package com.kakao;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * https://programmers.co.kr/learn/challenges/591?language=java
 */
public class R1Test {


    /**
     * n1	8
     * g1	[[3, 1], [5, 7], [8, 7], [2, 3], [3, 6], [1, 5], [4, 3]]
     * n2	9
     * g2	[[1, 5], [5, 6], [3, 7], [3, 1], [7, 4], [7, 2], [9, 8], [5, 9]]
     * answer	7
     */
    @Test
    public void AsomeObj() {

        int n1 = 8;
        int[][] g1 = new int[][]{{3, 1}, {5, 7}, {8, 7}, {2, 3}, {3, 6}, {1, 5}, {4, 3}};
        int n2 = 9;
        int[][] g2 = new int[][]{{1, 5}, {5, 6}, {3, 7}, {3, 1}, {7, 4}, {7, 2}, {9, 8}, {5, 9}};
//        solution(n1,g1,n2,g2);
        asomeObjSolve(8, g1, 9, g2);


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

        while (n != 1 && n != 2 && n != 3) {

            if (n % 3 == 0) {
                re.add(n - 1);
                n = n / 3;
            } else {
                n = n - 1;
            }

            if (n == 1 || n == 2 || n == 3) {
                answer = answer + 1;
                if (re.size() == 0) {
                    break;
                }
                n = (int) re.remove(0);
            }
        }

        return answer;
    }


    @Test
    public void colorBookTest() {

        //	[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]	[4, 5]
//        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
//        int[] rs = colorBook(6, 4, picture);


        int[][] picture = {
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0}
            , {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}
            , {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}
            , {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}
            , {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}
            , {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}
            , {0, 1, 1, 1, 1, 3, 1, 1, 1, 1, 3, 1, 1, 1, 1, 0}
            , {0, 1, 1, 1, 3, 1, 3, 1, 1, 3, 1, 3, 1, 1, 1, 0}
            , {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}
            , {0, 1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 1, 0}
            , {0, 1, 1, 1, 1, 1, 3, 1, 1, 3, 1, 1, 1, 1, 1, 0}
            , {0, 0, 1, 1, 1, 1, 1, 3, 3, 1, 1, 1, 1, 1, 0, 0}
            , {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}
            , {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}
        };
        int[] rs = colorBook(14, 16, picture);

//        System.out.println(rs);
    }


    public int[] colorBook(int m, int n, int[][] picture) {

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;


        int[][] delPicture = new int[m][n];

        List checkList = new ArrayList();
        Map rsMap = new HashMap();
        for (int j = 0; j < m; j++) {

            for (int i = 0; i < n; i++) {

                int[] pos = new int[]{j, i};

                if (picture[j][i] == 0) {
                    delPicture[j][i] = 0;
                    continue;
                }

                delPicture[j][i] = 1;
                checkList.add(pos);


            }
        }

        //recursive


        List<int[]> exp = new ArrayList();
        while (checkList.size() != 0 || exp.size() != 0) {

            int[] point;
            if (exp.size() != 0) {
                point = exp.remove(0);
            } else {
//                numberOfArea = numberOfArea + 1;
                point = (int[]) checkList.remove(0);
                int y = point[0];
                int x = point[1];

                int symbol = picture[y][x];
                if (rsMap.get(symbol) != null) {
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, (Integer) rsMap.get(symbol));
                    rsMap.put(symbol, null);
                }
            }

            int y = point[0];
            int x = point[1];

            if (delPicture[y][x] == 0) {
                continue;
            } else {

                delPicture[y][x] = 0;
            }


            int symbol = picture[y][x];

            if (symbol == 0) {
                continue;
            }
            int up = 0, down = 0, left = 0, right = 0;

            if (y != 0) up = picture[y - 1][x];
            if (y + 1 < m) down = picture[y + 1][x];
            if (x != 0) left = picture[y][x - 1];
            if (x + 1 < n) right = picture[y][x + 1];

            if (symbol == up || symbol == down || symbol == left || symbol == right) {

                if (symbol == up && delPicture[y - 1][x] == 1) exp.add(new int[]{y - 1, x});
                if (symbol == down && delPicture[y + 1][x] == 1) exp.add(new int[]{y + 1, x});
                if (symbol == left && delPicture[y][x - 1] == 1) exp.add(new int[]{y, x - 1});
                if (symbol == right && delPicture[y][x + 1] == 1) exp.add(new int[]{y, x + 1});

                if (rsMap.get(symbol) == null) {

                    numberOfArea = numberOfArea + 1;
                    rsMap.put(symbol, 1);


//                    if (symbol == up && checkList.contains(new int []{up,x})) exp.add(new int []{up,x});
//                    if (symbol == down && checkList.contains(new int []{down,x})) exp.add(new int []{down,x});
//                    if (symbol == left && checkList.contains(new int []{y,left})) exp.add(new int []{y,left});
//                    if (symbol == right && checkList.contains(new int []{y,right})) exp.add(new int []{y,right});


                    //expendable ?


                } else {


                    rsMap.put(symbol, (int) (rsMap.get(symbol)) + 1);
                }
            } else if (exp.size() == 0) {
                numberOfArea = numberOfArea + 1;
            }

        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        // debug
        for (int[] ints : picture) {
            for (int anInt : ints) {

                System.out.print(anInt);
            }
            System.out.println("");
        }


        System.out.println(String.format("%s %s", answer[0], answer[1]));
        return answer;
    }

    public int[] colorBook3(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        Map map = new HashMap();

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int x = i;
                int y = j;
                int symbol = picture[y][x];
                if (symbol == 0) {
                    continue;
                }

                int up = 0, down = 0, left = 0, right = 0;

                if (x != 0) up = picture[y][x - 1];
                if (x + 1 < m) down = picture[y][x + 1];
                if (y != 0) left = picture[y - 1][x];
                if (y + 1 < n) right = picture[y + 1][x];

                if (symbol == up || symbol == down || symbol == left || symbol == right) {
//                if (symbol == up || symbol == left) {

                    if (map.get(symbol) == null) {

                        numberOfArea = numberOfArea + 1;
                        map.put(symbol, 1);
                    } else {

                        map.put(symbol, (int) (map.get(symbol)) + 1);
                    }
                } else {
                    numberOfArea = numberOfArea + 1;

                    if (map.get(symbol) != null) {
                        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, (Integer) map.get(symbol));
                    }
                    map.put(symbol, 1);
                }
            }
        }

        for (Object o : map.values()) {

            maxSizeOfOneArea = Math.max(maxSizeOfOneArea, (Integer) o);

        }


        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;


        // debug
        for (int[] ints : picture) {
            for (int anInt : ints) {

                System.out.print(anInt);
            }
            System.out.println("");
        }


        System.out.println(String.format("%s %s", answer[0], answer[1]));
        return answer;
    }

    public int[] colorBook2(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;


        Map map = new HashMap();

        List checkTable = new ArrayList();
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                checkTable.add(new int[]{i, j});
            }
        }

        while (checkTable.size() > 0) {
            int[] pos = (int[]) checkTable.remove(0);

            int x = pos[0];
            int y = pos[1];

            int symbol = picture[x][y];
            if (map.get(symbol) == null) {
                map.put(symbol, 1);
            } else {
                // check up, down, left, right

                int up = 0, down = 0, left = 0, right = 0;

                if (y != 0) up = picture[x][y - 1];
                if (y + 1 < n) down = picture[x][y + 1];
                if (x != 0) left = picture[x - 1][y];
                if (x + 1 < m) right = picture[x + 1][y];

                if (symbol == up || symbol == down || symbol == left || symbol == right) {

                    map.put(symbol, (int) (map.get(symbol)) + 1);
                }

            }

        }


        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }


    @Test
    public void contaionTest() {

        int m = 2, n = 2;

        List checkList = new ArrayList();
        Map rsMap = new HashMap();
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int[] pos = new int[]{j, i};
                checkList.add(pos);

            }
        }
    }


    @Test
    public void getCaseTest() {

        // test genertation
        Random random = new Random(10);

        random.nextInt(10);

        for (int i = 0; i < 100; i++) {
            System.out.print(random.nextInt(3));

        }

    }


    @Test
    public void modTest() {


        int answer =20170806 ;
        System.out.println(answer % 20170805);

    }

    @Test
    public void walkTest() throws Exception {

        Random random = new Random();
        int MOD = 20170805;

        int m = 10;
        int n =  random.nextInt(10);
        n = 10;

        int[][] cityMap3 = new int[m][n];
        for (int i = 0; i < m; i++) {

            // 가로
            for (int j = 0; j < n; j++) {

//                cityMap3[i][j] = random.nextInt(3);
                cityMap3[i][j] = 0;

            }
        }
        for (int i = 0; i <  random.nextInt(20); i++) {

            cityMap3[random.nextInt(m)][random.nextInt(m)] = 1;
            cityMap3[random.nextInt(m)][random.nextInt(m)] = 2;
        }

        cityMap3[0][0]=0;
        cityMap3[m-1][n-1]=0;



        Assert.assertEquals(6, walk(3,3, new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}));
        Assert.assertEquals(2, walk(3,6 , new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}));
        Assert.assertEquals(1, walk(2, 2, new int[][]{{0, 2}, {0, 0}}));
        Assert.assertEquals(1, walk(2, 2, new int[][]{{0, 2}, {0, 0}}));
        Assert.assertEquals(1, walk(2, 2, new int[][]{{0, 0}, {2, 0}}));
        Assert.assertEquals(0, walk(2, 2, new int[][]{{0, 2}, {2, 0}}));



        Assert.assertEquals(52, walk(5,5, new int[][]{{0,0,0,0,0},{0,0,0,0,0},{0,0,2,0,0},{0,0,0,0,0},{0,0,0,0,0} }));


        Assert.assertEquals(105, walk(5,7, new int[][]{{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,2,2,2,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}}));
        Assert.assertEquals(271, walk(6,7, new int[][]{{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,2,0,0,0},{0,0,0,2,0,0,0},{0,0,0,2,0,0,0},{0,0,0,0,0,0,0}}));




                walk(m, n, cityMap3);
    }


    @Test
    public void walk2Test() {

        Assert.assertEquals(91, walk(5,9, new int[][]{{0,0,0,0,2,0,2,0,0},{0,0,0,1,0,0,0,0,0},{1,1,0,2,0,0,0,0,0},{1,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0}}));


    }

    public int walk(int m, int n, int[][] cityMap) {


        int MOD = 20170805;
        char[][] markTable = new char[m][n];

        // 세로
        for (int i = 0; i < m; i++) {

            // 가로
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    markTable[i][j] = 'W';
                    continue;
                }

//                if (i == m-1 && j == n-1) {
//                    markTable[i][j] = 'W';
//                    continue;
//                }


                // 이하 다시 짜야 할듯.. ;;

                int pos = cityMap[i][j];

                int up = 'X', left = 'X';
                int upVal = 1, leftVal = 1;
                if (j != 0) left = markTable[i][j - 1];
                if (i != 0) up = markTable[i - 1][j];

                if (j != 0) leftVal = cityMap[i][j - 1];
                if (i != 0) upVal = cityMap[i - 1][j];

                if (pos == 1) {
                    markTable[i][j] = 'X';
                } else if (pos == 2 || pos ==0) {

                    boolean upable = false;
                    boolean leftable = false;

//                    if ((up == 'U' || (up == 'W' && i != m - 1 && downVal != 1)) || (up == 'L' && upVal == 0))
//                        upable = true;
//                    if ((left == 'L' || (left == 'W' && j != n - 1 && rightVal != 1)) || (left == 'U' && leftVal == 0))
//                        leftable = true;
                    //  W L U X
                    //  0 1 2
                    //  W 0 2 , L 0 , U 0,2 , 2이면 위에 값이 있어야 한다.

                    // 가장자리 맨바닥 체크

                    // W 0 2 , L 0 2 , U 0 ,
                    if( (up == 'W' && upVal !=1) || (up == 'L' && upVal ==0 ) || (up == 'U' && upVal !=1) ){
                        upable = true;

                        if(upVal ==2){
                            char uup = 'X';
                            if (i > 1) uup = markTable[i - 2][j];
                            if(uup == 'X') upable = false;
                        }
                    }

                    if( (left == 'W' && leftVal !=1) || (left == 'L' && leftVal !=1 ) || (left == 'U' && leftVal ==0) ) {
                        leftable = true;
                        if(leftVal ==2){
                            char lleft = 'X';
                            if (j >1 ) lleft = markTable[i][j-2];
                            if(lleft == 'X') leftable = false;

                        }
                    }


                    if (upable && leftable) {
                        markTable[i][j] = 'W';

                        if(pos == 2){
                            if(j == n-1) markTable[i][j] = 'U';
                            if(i == m-1) markTable[i][j] = 'L';
                        }
                    } else if (upable && !leftable) {
                        markTable[i][j] = 'U';
                    } else if (!upable && leftable) {
                        markTable[i][j] = 'L';
                    } else markTable[i][j] = 'X';

                } else markTable[i][j] = 'X';
            }
        }


        // reverse find
        long answer = 0;

        long[][] pointTable = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int s = markTable[i][j];
                if(i == 0 && j ==0){
                    pointTable[i][j]=1;
                    continue;
                }

                long left = -1000000000;
                long up = -1000000000;
                if (i != 0) up = pointTable[i - 1][j];
                if (j != 0) left = pointTable[i][j - 1];


                if (i > 1 &&  markTable[i][j] == 'W' && cityMap[i-1][j] ==2 ) {
                    int ii =  i;
                    while(cityMap[ii-1][j]  ==2){
                        ii = ii -1;
                    }
                    up = pointTable[ii - 1][j];
                }

                if (j > 1 &&  markTable[i][j] == 'W' && cityMap[i][j-1] ==2 ) {
                    int jj =  j ;
                    while( cityMap[i][jj-1] ==2){
                        jj = jj -1;
                    }
                    left = pointTable[i][jj-1];
                }


                switch (s) {
                    case 'U':
                        pointTable[i][j] = up % MOD;
                        break;
                    case 'L':
                        pointTable[i][j] = left % MOD;
                        break;
                    case 'W':
                        pointTable[i][j] = (up + left) % MOD;
                        break;
                    case 'X':
                        pointTable[i][j] = 0;
                        break;
                    default:

                        break;
                }


            }
        }


        answer = pointTable[m-1][n-1];

        // debug
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(cityMap[i][j]);
            }
            System.out.println("");
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                System.out.print(markTable[i][j]);
            }
            System.out.println("");
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                System.out.print(pointTable[i][j]+",");
            }
            System.out.println("");
        }


        System.out.println("answer == " + answer % MOD);


        /// debug


        return (int) (answer % MOD);


    }


    @Test
    public void rewalkTest() {


        Assert.assertEquals(6, rewalk(3,3, new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}));
        Assert.assertEquals(2, rewalk(3,6 , new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}));
        Assert.assertEquals(1, rewalk(2, 2, new int[][]{{0, 2}, {0, 0}}));
        Assert.assertEquals(1, rewalk(2, 2, new int[][]{{0, 2}, {0, 0}}));
        Assert.assertEquals(1, rewalk(2, 2, new int[][]{{0, 0}, {2, 0}}));
        Assert.assertEquals(0, rewalk(2, 2, new int[][]{{0, 2}, {2, 0}}));



        Assert.assertEquals(52, walk(5,5, new int[][]{{0,0,0,0,0},{0,0,0,0,0},{0,0,2,0,0},{0,0,0,0,0},{0,0,0,0,0} }));


        Assert.assertEquals(105, walk(5,7, new int[][]{{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,2,2,2,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}}));
        Assert.assertEquals(271, walk(6,7, new int[][]{{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,2,0,0,0},{0,0,0,2,0,0,0},{0,0,0,2,0,0,0},{0,0,0,0,0,0,0}}));

    }

    public int rewalk(int m, int n, int[][] cityMap) {
        int MOD = 20170805;

        long answer = 0;

        int[][] cityMap2 = new int[500][500];
        int[][] v = new int[m+1][n+1];
        int[][] h = new int[m+1][n+1];

        // ext 0 set
        for (int i = 0; i < m+1; i++) {

            // 가로
            for (int j = 0; j < n+1; j++) {


                if(i == 0 || j ==0){
                    cityMap2[i][j] = 0;
                }else{
                    cityMap2[i][j] = cityMap[i-1][j-1];
                }

            }
        }


        v[1][1]=1;
        h[1][1]=1;

        // 세로
        for (int i = 1; i <= m; i++) {

            // 가로
            for (int j = 1; j <= n; j++) {

                int pos = cityMap2[i][j];

                if(pos ==1){
                    v[i][j] = 0;
                    h[i][j] = 0;
                }else if(pos ==0){

                    v[i][j] = (v[i][j]+ v[i][j-1]+h[i-1][j]%MOD);
                    h[i][j] = (h[i][j]+h[i-1][j]+v[i][j-1]%MOD);

                }else if(pos ==2 ){
                    v[i][j] = v[i][j-1];
                    h[i][j] = h[i-1][j];
                }



            }
        }



        // debug


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                System.out.print(cityMap2[i][j]);
            }
            System.out.println("");
        }


        System.out.println("=====");


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
//                System.out.print(v[i][j-1] + h[i-1][j]);
                System.out.print(v[i][j]);
//                System.out.print(h[i][j]);
            }
            System.out.println("");
        }




        answer = v[m][n-1] + h[m-1][n];
        return (int) (answer % MOD);
    }


}
