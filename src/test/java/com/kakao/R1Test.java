package com.kakao;

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
    public void walkTest() throws Exception {

        Random random = new Random();
        int MOD = 20170805;

        int[][] cityMap = {{0, 0, 0},{0, 0, 0},{0, 0, 0}};
        if (walk(3,3,cityMap)==6) {

        }else{
            throw new Exception("fail");
        }

        int[][] cityMap2 = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
        if (walk(3, 6, cityMap2) == 2) {

        } else {
            throw new Exception("fail2");
        }


        int m = 100;
        int n =  random.nextInt(10);
        n = 500;

        int[][] cityMap3 = new int[m][n];
        for (int i = 0; i < m; i++) {

            // 가로
            for (int j = 0; j < n; j++) {

//                cityMap3[i][j] = random.nextInt(3);
                cityMap3[i][j] = 0;

            }
        }

        walk(m, n, cityMap3);

    }



    public int walk(int m, int n, int[][] cityMap) {


        char[][] markTable = new char[m][n];

        // 세로
        for (int i = 0; i < m; i++) {

            // 가로
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    markTable[i][j] = 'W';
                    continue;
                }

                int pos = cityMap[i][j];

                int up = 'X', left = 'X', down = 'X', right = 'X';
                int upVal = '1', downVal = '1', leftVal = '1', rightVal = '1';
                if (j != 0) left = markTable[i][j - 1];
                if (i != 0) up = markTable[i - 1][j];

                if (j != 0) leftVal = cityMap[i][j - 1];
                if (j + 1 != n) rightVal = cityMap[i][j + 1];
                if (i != 0) upVal = cityMap[i - 1][j];
                if (i + 1 != m) downVal = cityMap[i + 1][j];

                if (pos == 1) {
                    markTable[i][j] = 'X';
                } else if (pos == 2) {


                    boolean upable = false;
                    boolean leftable = false;

                    if ((up == 'U' || (up == 'W' && i != m - 1 && downVal != 1)) || (up == 'L' && upVal == 0))
                        upable = true;
                    if ((left == 'L' || (left == 'W' && j != n - 1 && rightVal != 1)) || (left == 'U' && leftVal == 0))
                        leftable = true;

                    if (upable && leftable) {
                        markTable[i][j] = 'W';
                    } else if (upable && !leftable) {
                        markTable[i][j] = 'U';
                    } else if (!upable && leftable) {
                        markTable[i][j] = 'L';
                    } else markTable[i][j] = 'X';

                } else if (pos == 0) {
                    boolean upable = false;
                    boolean leftable = false;

                    if ((up == 'U' && (upVal == 2 || upVal == 0)) || (up == 'W' && upVal == 0) || (up == 'L' && upVal == 0))
                        upable = true;
                    if ((left == 'L' && (leftVal == 2 || leftVal == 0)) || (left == 'W' && leftVal == 0) || (left == 'U' && leftVal == 0))
                        leftable = true;

                    if (upable && leftable) {
                        markTable[i][j] = 'W';
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

                long left = 0;
                long up = 0;
                if (j != 0) left = pointTable[i][j - 1];
                if (i != 0) up = pointTable[i - 1][j];


                switch (s) {
                    case 'U':
                        pointTable[i][j] = up;
                        break;
                    case 'L':
                        pointTable[i][j] = left;
                        break;
                    case 'W':
                        pointTable[i][j] = up + left;
                        break;
                    case 'X':
                        pointTable[i][j] = 0;
                        break;
                    default:

                        break;
                }


            }
            System.out.println("");
        }

        // debug

        answer = pointTable[m-1][n-1];


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


        System.out.println("answer == " + answer % 20170805);
        return (int) (answer % 20170805);

    }

}
