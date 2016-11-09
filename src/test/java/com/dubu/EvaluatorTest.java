package com.dubu;


import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

/**
 * https://www.codewars.com/kata/evaluate-a-postfix-expression/train/java
 * <p/>
 * <p/>
 * 25 45 +   // 25 + 45
 * 20 40 + 60 * // (20+40) * 60
 * 20 40 60 + * // 20 * (40 + 60) = 2000
 * 2 3 9 4 / + *  //  2* ( 3 + (9/4))
 */

public class EvaluatorTest {


    @Test
    public void test1() throws Exception {
        Evaluator eval = new Evaluator();
        assertEquals(10, eval.evaluate("2 3 9 4 / + *"));
        assertEquals(5, eval.evaluate("2 3 +"));
        assertEquals(1, eval.evaluate("1"));
        assertEquals(3, eval.evaluate("4, 8, +, 6, 5, -, *, 3, 2, -, 2, 2, +, *, /"));

        assertEquals(-1, eval.evaluate("2 - 3 +"));  // -1

    }

    public class Evaluator {

        public  final Integer POSITIVE = 1;
        private final Integer NEGATIVE = -1;

        public long evaluate(String str) {

            List<String> calMarkList =Arrays.asList("+", "-", "*", "/");

            List<String> strList = toMathStringArray(str);
            List<Integer> numberStack = new ArrayList<>();

            System.out.println(strList);

            Integer leftVal = 0;
            Integer rightVal = 0;
            Integer nextLeftVal = 0 ;
            Integer nextTimeFlag = POSITIVE;
            for (int i = 0; i < strList.size(); i++) {

                String item = strList.get(i);
                if(calMarkList.contains(item)){

                    char charCalMark = item.toCharArray()[0];

                    if(numberStack.size()-3 >= 0){
                        nextLeftVal = numberStack.get(numberStack.size()-3);
                    }
                    if(numberStack.size()-2 >= 0){
                        leftVal  = numberStack.get(numberStack.size()-2);
                    }

                    switch (charCalMark) {
                        case '+':
                            rightVal = leftVal + rightVal;
                            leftVal = nextLeftVal;
                            break;
                        case '-':
                            if(numberStack.size() <= 1){
                                nextTimeFlag = NEGATIVE;

                            }else{
                                rightVal = leftVal - rightVal;
                                leftVal = nextLeftVal;

                            }

                            break;
                        case '*':
                            rightVal = leftVal * rightVal;
                            leftVal = nextLeftVal;
                            break;
                        case '/':
                            rightVal = leftVal / rightVal;
                            leftVal = nextLeftVal;
                            break;
                    }
                    if(numberStack.size() >1) {
                        numberStack.remove(numberStack.size() - 1);
                        numberStack.set(numberStack.size() - 1, rightVal);
                    }

                }else{

                    // 이하 스택에 숫자 추가

                    Integer currentItem = nextTimeFlag * Integer.valueOf(item);

                    numberStack.add(currentItem);
                    nextTimeFlag = POSITIVE;

                    if(i == 0 ){
                        // init
                        rightVal = Integer.valueOf(item);
                        leftVal = rightVal;
                    }else{
                        leftVal = rightVal;
                        rightVal = currentItem;
                    }

                }

//                if(i != 0 && numberStack.size() == 1){
//                    numberStack.set(0, rightVal);
//                }

            }

            return  rightVal;
        }

        public List<String> toMathStringArray(String str) {
            List<String> rs = new ArrayList<String>();

            str = str.replace("---", "-");
            str = str.replace("--", "+");

            List<String> padingCharList = Arrays.asList("\\(", "\\)", "\\{", "\\}", "\\[", "\\]", "\\+", "\\-", "\\*", "\\/");

            for (int i = 0; i < padingCharList.size(); i++) {
                String s = padingCharList.get(i);
                str = str.replaceAll(s, " " + s + " ");
            }

            Pattern pattern = Pattern.compile("([\\d.\\/\\+\\*\\/\\]\\(\\)\\[\\]\\]\\{\\}\\-]+)");

            Matcher matcher = pattern.matcher(str);


            int groupCount = matcher.groupCount();


            while (matcher.find()) {


                for (int i = 0; i < groupCount; i++) {

                    rs.add(matcher.group(i));
                }

            }

            return rs;
        }
    }


}
