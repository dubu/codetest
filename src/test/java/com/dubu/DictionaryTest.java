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

        String[] strings = words;

        int storeInt = Integer.MAX_VALUE;
        String storeStr = "";
        for (int i = 0; i < strings.length; i++) {
            String to = strings[i];
            String formatStr = String.format("[^%s]*([%s]*)[^%s]*", from, from, from);
            Pattern pattern = Pattern.compile(formatStr);
            Matcher matcher = pattern.matcher(to);

            int matchCnt = 0;
            List<String> copyFromList = new LinkedList<String>(Arrays.asList(from.split("")));
            List<String> copyToList = new LinkedList<String>(Arrays.asList(to.split("")));

            StringBuilder sb = new StringBuilder();
            while (matcher.find() && matcher.group(1).length() > 0) {
                if ((matcher.groupCount() > 0)) {

                    String groupOne = matcher.group(1);
                    Set<String> mySet = new HashSet(Arrays.asList(groupOne.split("")));
                    for (int j = 0; j < mySet.size(); j++) {
                        char c = groupOne.toCharArray()[j];
                        copyFromList.remove(String.valueOf(c));
                        mySet.remove(String.valueOf(c));
                        copyToList.remove(String.valueOf(c));
                    }
                    String matchStr = matcher.group(1);
                    matchCnt = matchCnt + matchStr.length();

                    if (sb.length() > matchStr.length()) {
                        if (sb.substring(sb.length() - matchStr.length(), sb.length()).toString().equals(matchStr)) {
                            // pass
                        } else {
                            sb.append(matchStr);
                        }
                    } else {

                        sb.append(matchStr);
                    }
//                    System.err.println(String.format("### %s %s ### ", to, matcher.group(1), matchStr.length()));
                }

                String copyFromListString = copyFromList.stream().map(Object::toString).collect(Collectors.joining());
                String copyToListString = copyToList.stream().map(Object::toString).collect(Collectors.joining());

                if (copyFromListString.length() == 0) {
                    break;
                }
                formatStr = String.format("[^%s]*([%s]*)[^%s]*", copyFromListString, copyFromListString, copyFromListString);
                pattern = Pattern.compile(formatStr);
                matcher = pattern.matcher(copyToListString);

            }

            System.out.println("match string : " + sb.toString());

//            int moveCnt = copyToList.size()+ copyFromList.size();

            int cnt = Integer.MAX_VALUE;
            if (cnt < storeInt) {
                storeInt = cnt;
                storeStr = to;
                System.err.println(String.format("!! change : %s %s ### ", storeStr, storeInt));
            }

        }
        System.out.println(storeStr);

        return storeStr;
    }

    public int moveCnt(String regxStr, String str) {

        int cnt = 0;
        return cnt;
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

    @Test
    public void testCnt() throws Exception {

        Dictionary dictionary = new Dictionary();
        String from = "strawbery";
        String[] strings = {"cherry", "pineapple", "melon", "strawberry", "raspberry"};
        Integer[] cntList = {4,5,6,7,8};
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            assertEquals(cntList[i].intValue(), dictionary.moveCnt(from,string) );
        }

    }
}

