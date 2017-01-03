package com.dubu;

/**
 * Created by rigel on 12/13/16.
 * <p/>
 * https://www.codewars.com/kata/did-you-mean-dot-dot-dot/train/java
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;



class Dictionary {
    private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
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
                    matchCnt = matchCnt + matcher.group(1).length();
                    System.err.println(String.format("### %s %s ### ", to, matcher.group(1), matcher.group(1).length()));
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

            int moveCnt = copyToList.size()+ copyFromList.size();

            // 중복카운트 제거
            // 교화 카운트 추가


//            int moveCnt = copyFromList.size();
//            if(copyToList.size() > copyFromList.size()){
//                moveCnt = copyToList.size();
//            }

            if(moveCnt < storeInt){
                storeInt = moveCnt;
                storeStr = to;
                System.err.println(String.format("### %s %s ### ",storeStr,storeInt));
            }

        }
        System.out.println(storeStr);

        return storeStr;
    }
}

public class DictionaryTest {

    @Test
    public void testBerries() {
        Dictionary dictionary = new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});
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


}

