package com.dubu;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rigel on 11/9/16.
 */
public class MathOrderTest {

    @Test
    public void testName() throws Exception {


        List<String> rsList = new ArrayList();

        String str  = "(4+8)*(6-5)/(3-2)*(2+2)";


        List<String> braceList =  Arrays.asList("(", ")", "{", "}", "[", "]");
        List<String> strings = toMathStringArray(str);

        List<String> depthControlCharList = new ArrayList<>();
        String comsumerChar = "0";
        int depth = 0;
        for (int i = 0; i < strings.size(); i++) {
            String s = strings.get(i);

            if (braceList.contains(s)) {
                if(s.equals(comsumerChar)){
                    depthControlCharList.remove(depthControlCharList.size()-1);
                    if(depthControlCharList.size() > 0){
                        comsumerChar = depthControlCharList.get(depthControlCharList.size()-1);
                    }



                }else{
                    depth = depth +1;
                    depthControlCharList.add(s);
                    comsumerChar = String.valueOf(getCloseString(s.charAt(0)));
                }


//                System.out.println(s);

            }else{
                // 숫자 또는 기호

            }


        }

//        System.out.println(strings);





    }


    public List<String> toMathStringArray(String str) {
//        String str = "11 22 443 23429 ";
//        str = "11.121 / { 22 443 23429 ";
//        str = "2 / (2 + 3) * 4.33 - -6";

        List<String> rs = new ArrayList<String>();

        str = str.replace("---", "-");
        str = str.replace("--", "+");

        ArrayList<String> padingCharList = Lists.newArrayList("\\(", "\\)", "\\{", "\\}", "\\[", "\\]", "\\+", "\\-", "\\*", "\\/");


        for (int i = 0; i < padingCharList.size(); i++) {
            String s = padingCharList.get(i);
            str = str.replaceAll(s, " "+s+" ");
        }

//        str = str.replaceAll("\\(", " \\( ");
//        str = str.replaceAll("\\)", " \\) ");
//        str = str.replaceAll("\\-", " \\- ");

//        Pattern p = Pattern.compile("[d.\\/\\+\\*\\/\\]\\(\\)\\[\\]\\]\\{\\}");
//        Pattern pattern = Pattern.compile(".*([\\d.\\/\\+\\*\\/\\]\\(\\)\\[\\]\\]\\{\\}]+).*");
//        Pattern pattern = Pattern.compile("(\\d+)");
        Pattern pattern = Pattern.compile("([\\d.\\/\\+\\*\\/\\]\\(\\)\\[\\]\\]\\{\\}\\-]+)");

        Matcher matcher = pattern.matcher(str);


        int groupCount = matcher.groupCount();


        while(matcher.find()) {


            for (int i = 0; i < groupCount; i++) {


//                System.out.println(matcher.group(i));
                rs.add(matcher.group(i));
            }

        }

        return rs;
    }

    private static char getCloseString( char c) {
        char reducWord = 0;
        switch (c) {
            case '(':
                reducWord = ')';
                break;
            case '{':
                reducWord = '}';
                break;
            case '[':
                reducWord = ']';
                break;
        }
        return reducWord;
    }

}
