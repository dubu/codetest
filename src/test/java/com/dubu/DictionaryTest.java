package com.dubu;

/**
 * Created by rigel on 12/13/16.
 * <p/>
 * https://www.codewars.com/kata/did-you-mean-dot-dot-dot/train/java
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;



class Dictionary {
    private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

    public Dictionary() {
        this.words = null;

    }

    public String findMostSimilar(String from) {



//        String str = "cherry";
//        String[] strings = {"cherry", "pineapple", "melon", "strawberry", "raspberry"};
        String[] strings = words;

        int storeInt = Integer.MAX_VALUE;
        String storeStr = "";
        for (int i = 0; i < strings.length; i++) {
            String to = strings[i];

//            String swap = "";
//            if(from.length() > to.length()){
//                swap = from;
//                from = to;
//                to = swap;
//
//            }

            //    String from = "coddwars";
            String formatStr = String.format("[^%s]*([%s]*)[^%s]*", from, from, from);
            Pattern pattern = Pattern.compile(formatStr);
            Matcher matcher = pattern.matcher(to);

            int matchCnt = 0;
//            List<String> validStringsList = Arrays.asList(to.split(""));
            List<String> copyFromList = new LinkedList<String>(Arrays.asList(from.split("")));
            List<String> copyToList = new LinkedList<String>(Arrays.asList(to.split("")));


            StringBuilder sb =  new StringBuilder();
            while (matcher.find() && matcher.group(1).length() > 0) {
//            System.out.println(matcher.group());
//            System.out.println(matcher.group(0));
                if ((matcher.groupCount() > 0)) {
//                    int diff = to.length() - matcher.group(1).length();

                    String groupOne = matcher.group(1);
                    Set<String> mySet = new HashSet(Arrays.asList(groupOne.split("")));
                    for (int j = 0; j < mySet.size() ;j++) {
                        char c = groupOne.toCharArray()[j];
                        copyFromList.remove(String.valueOf(c));
                        mySet.remove(String.valueOf(c));
                        copyToList.remove(String.valueOf(c));
                    }
                    String matchStr = matcher.group(1);
                    matchCnt = matchCnt + matchStr.length();


                    if(sb.length() > matchStr.length()){
                       if(sb.substring(sb.length()-matchStr.length(), sb.length()).toString().equals(matchStr)){
                           // pass
                       }else{
                          sb.append(matchStr);
                       }
                    }else{

                        sb.append(matchStr);
                    }
//                    System.err.println(String.format("### %s %s ### ", to, matcher.group(1), matchStr.length()));
                }

                String copyFromListString = copyFromList.stream().map(Object::toString).collect(Collectors.joining());
                String copyToListString = copyToList.stream().map(Object::toString).collect(Collectors.joining());

                if(copyFromListString.length() == 0){
                    break;
                }
                formatStr = String.format("[^%s]*([%s]*)[^%s]*", copyFromListString, copyFromListString, copyFromListString);
                pattern = Pattern.compile(formatStr);
                matcher = pattern.matcher(copyToListString);

            }

            System.out.println("match string : "+ sb.toString());

//            int moveCnt = copyToList.size()+ copyFromList.size();

            // 중복카운트 제거
            // 교화 카운트 추가

            int switchCnt = 0 ;
            int cnt = 0;
            if(sb.toString().length() > 0){
                switchCnt = switchCnt(reverseRegxStr(sb.toString(), from), sb.toString());

//                int fAddCnt = to.indexOf(sb.substring(0, 1));
//                int eAddCnt = new StringBuilder(to).reverse().indexOf(sb.substring(sb.length() - 1, sb.length()));
//                cnt = switchCnt +fAddCnt +eAddCnt;

                int moveCnt = moveCnt(sb.toString(),to.toString());
                cnt = switchCnt + moveCnt;


                if (to.toString().length() > sb.toString().length()) {
                    // inter add or delete count
                    cnt = cnt + to.toString().length() - sb.toString().length();

                }
            }else{
                cnt = to.toString().length();

            }


            System.err.println(String.format("!! ckeck : %s %s ### ",to,cnt));


//            int moveCnt = copyFromList.size();
//            if(copyToList.size() > copyFromList.size()){
//                moveCnt = copyToList.size();
//            }

            if( cnt < storeInt){
                storeInt = cnt;
                storeStr = to;
                System.err.println(String.format("!! change : %s %s ### ",storeStr,storeInt));
            }

        }
        System.out.println(storeStr);

        return storeStr;
    }

    public int moveCnt(String regxStr, String str) {
/*



        from "rkacypviuburk" to "xffrkbdyjveb":

             rkacypviuburk
            xrkacypviuburk // 1
           xfrkacypviuburk // 2
          xffrkacypviuburk // 3
        xffrkb cypviuburk // 4
        xffrkb dypviuburk // 5
        xffrkb dyjviuburk // 6
        xffrkb dyjveuburk // 7
        xffrkb dyjveburk // 8
        xffrkb dyjvebrk // 9
        xffrkb dyjvebk // 10
        xffrkb dyjveb // 11

           rkacypviub urk
           rk  y v  b





        */
        int cnt = 0;
        List<String> strings = Arrays.asList(regxStr.split(""));
        for (int i = 0; i < strings.size(); i++) {
            String c = strings.get(i);

           if(i == 0 ){
               // init
               int aPos = regxStr.indexOf(String.valueOf(c));
               int bPos = str.indexOf(String.valueOf(c));
               cnt = cnt +Math.abs(aPos-bPos);
           }else if(i ==  strings.size()-1){
               // last
               int aPos = regxStr.indexOf(String.valueOf(c));
               int bPos = str.indexOf(String.valueOf(c));
               int aPosTail = regxStr.length() - aPos;
               int bPosTail = str.length() - bPos;
               cnt = cnt +Math.abs(aPosTail-bPosTail);

           }

            //// TODO: 1/5/17
            // 중간
        }




        return cnt;
    }

    public String reverseRegxStr(String regStr, String str) {

        StringBuilder toSb = new StringBuilder();
        toSb.append(str);

        StringBuilder fromSb = new StringBuilder();
        fromSb.append(regStr);

        String formatStr = String.format("[^%s]*([%s]*)[^%s]*", regStr, regStr, regStr);
        Pattern pattern = Pattern.compile(formatStr);
        Matcher matcher = pattern.matcher(str);

        StringBuilder sb = new StringBuilder();
        while(matcher.find() && matcher.group(1).length() > 0 ){
//            System.out.println(matcher.group(1));


            String matchStr =matcher.group(1);
            if(sb.length() > matchStr.length()){
                if(sb.substring(sb.length()-matchStr.length(), sb.length()).toString().equals(matchStr)){
                    // pass
                }else{
                    sb.append(matchStr);
                    int toPos = toSb.indexOf(matchStr);
                    if(toPos > -1){
                        toSb.delete(toPos, toPos+matchStr.length());
                    }
                    for (char c : matchStr.toCharArray()) {
                        int pos = fromSb.indexOf(String.valueOf(c));
                        if(pos > -1){
                            fromSb.deleteCharAt(pos);
                        }
                    }

                }
            }else{
                sb.append(matchStr);
                int toPos = toSb.indexOf(matchStr);
                if(toPos > -1){
                    toSb.delete(toPos, toPos+matchStr.length());
                }
                for (char c : matchStr.toCharArray()) {
                    int pos = fromSb.indexOf(String.valueOf(c));
                    if(pos > -1){
                        fromSb.deleteCharAt(pos);
                    }
                }
            }


            if(fromSb.length() == 0){
                break;
            }

            formatStr = String.format("[^%s]*([%s]*)[^%s]*", fromSb.toString(), fromSb.toString(), fromSb.toString());
            pattern = Pattern.compile(formatStr);
            matcher = pattern.matcher(toSb.toString());
        }


        //sorry ;;
        if (sb.toString().length() != regStr.length()) {
            LinkedList<String> matchList = new LinkedList<>(Arrays.asList(sb.toString().split("")));
            List<String> deduped = matchList.stream().distinct().collect(Collectors.toList());
            return  String.join("", deduped);
        }

        System.out.println(sb.toString());

        return sb.toString();
    }

    public int switchCnt(String a, String b) {


        if(a.equals(b)){
            return  0;
        }

        // a 기분으로 b 정렬

//        String[] strList = b.split("");

//        List<String> copyFromList = new LinkedList<String>(Arrays.asList(from.split("")));
        LinkedList<String> aList = new LinkedList<>(Arrays.asList(a.split("")));
        LinkedList<String> bList = new LinkedList<>(Arrays.asList(b.split("")));
        LinkedList<String> bListCopy = new LinkedList<>(bList);

        int moveCount = 0;
        for (int i = 0; i < bList.size(); i++) {
            String s = bList.get(i);

            int aPos = aList.indexOf(s);
            int bPos = bListCopy.indexOf(s);
            if (aPos -1 > -1) {
                String leftStr = aList.get(aPos -1);
                int leftPos = bListCopy.indexOf(leftStr);

                if (aPos -1  == leftPos) {
                    System.out.println(" == ");
                }else{

                    bListCopy.add(leftPos+1,s);
                    moveCount++;
                    bListCopy.remove(bPos);
                }


            }
        }
        System.out.println(bListCopy.stream().map(Object::toString).collect(Collectors.joining()));
        System.out.println(moveCount);
        return moveCount;
    }
}

public class DictionaryTest {

    @Test
    public void testBerries() {
        Dictionary dictionary = new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});
//        Dictionary dictionary = new Dictionary(new String[]{"strawberry"});
        assertEquals("strawberry", dictionary.findMostSimilar("strawbery"));
        assertEquals("cherry", dictionary.findMostSimilar("berry"));
    }

    @Test
    public void testLanguages() {
        Dictionary dictionary = new Dictionary(new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
        assertEquals("java", dictionary.findMostSimilar("heaven"));
        assertEquals("javascript", dictionary.findMostSimilar("javascript"));
    }

    @Test
    public void testpass() {
        Dictionary dictionary = new Dictionary(new String[]{"codewars", "wars"});
        assertEquals("codewars", dictionary.findMostSimilar("coddwars"));
    }

    @Test
    public void testpassMany() {
        Dictionary dictionary = new Dictionary(new String[]{"zqdrhpviqslik", "karpscdigdvucfr"});
        assertEquals("zqdrhpviqslik", dictionary.findMostSimilar("rkacypviuburk"));
    }

    @Test
    public void testArrayList() throws Exception {

//        List<String> strings = Arrays.asList("a", "a", "c", "d");
        LinkedList<String> strings = new LinkedList<>(Arrays.asList("a", "a", "c", "d"));
        strings.remove(String.valueOf("a"));
        System.out.println(strings);

    }


    @Test
    public void testRegxPattern() throws Exception {
        String regxStr = "karpcivur";
        String str = "rkacypviuburk";

        Dictionary dictionary = new Dictionary();
        assertEquals("rkacpviur",dictionary.reverseRegxStr(regxStr, str));


    }

    @Test
    public void testRegxPattern2() throws Exception {
        String regxStr = "codwars";
        String str = "coddwars";

        Dictionary dictionary = new Dictionary();
        assertEquals("codwars",dictionary.reverseRegxStr(regxStr, str));

    }


    @Test
    public void testSortOrder() throws Exception {

        String a = "abcde";
        String b = "cabed";
        Dictionary dictionary = new Dictionary();
        assertEquals(2, dictionary.switchCnt(a,b) );

    }


    @Test
    public void testSortOrder2() throws Exception {

        String a = "ae";
        String b = "ea";
        Dictionary dictionary = new Dictionary();
        assertEquals(1, dictionary.switchCnt(a,b) );

    }

    @Test
    public void testSortOrder3() throws Exception {

        String a = "strawbery";
        String b = "strawbery";
        Dictionary dictionary = new Dictionary();
        assertEquals(0, dictionary.switchCnt(a,b) );

    }

    @Test
    public void testSortOrder4() throws Exception {

//        karp c i  vu  r     6
//        karpscdigdvucfr

        String a = "karpcivur";
        String b = "karpscdigdvucfr";
        Dictionary dictionary = new Dictionary();
//        assertEquals(6, dictionary.switchCnt(a,b) );

    }

    @Test
    public void testPass2() throws Exception {

//        karp c i  vu  r     6
//        karpscdigdvucfr

        String a = "rpvik";
        String b = "zqdrhpviqslik";
        Dictionary dictionary = new Dictionary();
        assertEquals(9, dictionary.moveCnt(a,b) );

    }
}

