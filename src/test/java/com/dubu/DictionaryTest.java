package com.dubu;

/**
 * Created by rigel on 12/13/16.
 * <p>
 * https://www.codewars.com/kata/did-you-mean-dot-dot-dot/train/java
 */

import org.junit.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

//            int moveCnt = copyToList.size()+ copyFromList.size();
            int cnt = moveCnt(from, to);
            if (cnt < storeInt) {
                storeInt = cnt;
                storeStr = to;
                System.err.println(String.format("!! change : %s %s ### ", storeStr, storeInt));
            }

        }
        System.out.println(storeStr);

        return storeStr;
    }


    public String getString(String from, String to) {
        StringBuilder sb = new StringBuilder();
        from = from.replaceAll(" ", "");
        String formatStr = String.format("[^%s]*([%s]*)[^%s]*", from, from, from);
        Pattern pattern = Pattern.compile(formatStr);
        Matcher matcher = pattern.matcher(to);

        int matchCnt = 0;
        List<String> copyFromList = new LinkedList<String>(Arrays.asList(from.split("")));
        List<String> copyToList = new LinkedList<String>(Arrays.asList(to.split("")));

        while (matcher.find() && matcher.group(1).length() > 0) {
            if ((matcher.groupCount() > 0)) {

                String groupOne = matcher.group(1);
//                Set<String> mySet = new HashSet(Arrays.asList(groupOne.split("")));
                List<String> mySet = new LinkedList<String>(Arrays.asList(groupOne.split("")));
                Arrays.asList(groupOne.split(""));
//                removeDuplicatesNaive(mySet);
                List<String> mySetCopy = new ArrayList(mySet);


                String matchStr = mySet.stream().map(Object::toString).collect(Collectors.joining());


                //todo dup order !!
//                http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-array-java/

                for (int j = 0; j < mySetCopy.size(); j++) {
//                    char c = groupOne.toCharArray()[j];
                    String c = mySetCopy.get(j);
                    copyFromList.remove(String.valueOf(c));
                    mySet.remove(String.valueOf(c));
                    copyToList.remove(String.valueOf(c));
                    break;
                }
//                String matchStr = matcher.group(1);
                matchCnt = matchCnt + matchStr.length();

                if (sb.length() > matchStr.length()) {
                    if (sb.substring(sb.length() - matchStr.length(), sb.length()).toString().equals(matchStr)) {
                        // pass
                    } else {
                        sb.append(matchStr);
                    }
                } else {

//                    sb.append(matchStr);
                    sb.append(matchStr.substring(0,1));
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
        return sb.toString();
    }


    public int moveCnt(String from, String to) {

        int cnt = 0;
        String regxStr = getString(from, to);

        if (regxStr.length() == 0) {
            return to.length() > from.length() ? to.length() : from.length();
        }

        StringBuilder fromRegxSb = new StringBuilder(regxStr);
        StringBuilder toRegxSb = new StringBuilder(regxStr);
        StringBuilder fromSb = new StringBuilder(from);
        StringBuilder toSb = new StringBuilder(to);

        String e1 = regxStr.substring(0, 1);
        String e9 = regxStr.substring(regxStr.length() - 1, regxStr.length());

        int sPos = from.indexOf(e1);
        int tPos = to.indexOf(e1);


//        int n = Math.abs(sPos - tPos);

        // add head blink
        int rPos = toRegxSb.indexOf(e1);
        if (rPos > tPos) {
            toSb.insert(0, Stream.generate(() -> " ").limit(rPos - tPos).collect(Collectors.joining("")));
        }

        // add head
//        int n = (sPos > tPos) ? sPos : tPos;
        if(sPos > tPos){

            fromRegxSb.insert(0, Stream.generate(() -> " ").limit(sPos).collect(Collectors.joining("")));
            toRegxSb.insert(0, Stream.generate(() -> " ").limit(tPos+sPos-tPos).collect(Collectors.joining("")));
        }else{
            fromRegxSb.insert(0, Stream.generate(() -> " ").limit(sPos+tPos-sPos).collect(Collectors.joining("")));
            toRegxSb.insert(0, Stream.generate(() -> " ").limit(tPos).collect(Collectors.joining("")));
        }

        int fromIdx = -1;
        for (String s : regxStr.split("")) {
            int pos = toSb.indexOf(s, fromIdx+1);
            if (fromIdx != -1 && pos - fromIdx - 1 > 0) {

                toRegxSb.insert(fromIdx + 1, Stream.generate(() -> " ").limit(pos - fromIdx - 1).collect(Collectors.joining("")));
            }
            fromIdx = pos;
        }


        fromIdx = -1;
        for (String s : regxStr.split("")) {
            int pos = fromSb.indexOf(s, fromIdx+1);
            if (fromIdx != -1 && pos - fromIdx - 1 > 0) {
                fromRegxSb.insert(fromIdx + 1, Stream.generate(() -> " ").limit(pos - fromIdx - 1).collect(Collectors.joining("")));
            }
            fromIdx = pos;
        }

        // add tail
        int sEndPos = fromRegxSb.lastIndexOf(e9);
        int tEndPos = toRegxSb.lastIndexOf(e9);
        int fromTail = from.length() - sEndPos;
        int tailHead = (sPos > tPos) ? tPos : 0;
        int toTail = tailHead + to.length() - tEndPos - 1;
        if (fromTail > 0) {
            fromRegxSb.append(Stream.generate(() -> " ").limit(fromTail).collect(Collectors.joining("")));
        }

        if (toTail > 0) {
            toRegxSb.append(Stream.generate(() -> " ").limit(toTail).collect(Collectors.joining("")));
        }

        cnt = suggestCnt(fromRegxSb.toString(), toRegxSb.toString());


        System.out.println(String.format(" %s %s %s %s", from, to, toRegxSb, cnt));
        return cnt;
    }

    public int removeDuplicatesNaive(List<String> A) {

        List<String> usedMap = new ArrayList();
        for (int i = 0; i < A.size(); i++) {
            String s = (String) A.get(i);

            if (usedMap.contains(s)) {
                A.remove(i);
            } else {
                usedMap.add(s);
            }

        }


        return 0;
    }


    public int suggestCnt(String from, String to) {

        int cnt = 0;
        String regxStr = getString(from, to);
//        regxStr = "rpvik";

        int idx = 0;
        for (char c : regxStr.toCharArray()) {
            int fromPos = from.indexOf(c, idx);
            int toPos = to.indexOf(c, idx);
            int switchCount = toPos + 1;
            int addAndSubCount = 2 * Math.abs(toPos - fromPos);
            if (fromPos == toPos) {
                // pass

                if (idx == 0 && toPos != 0) {

                    cnt = cnt + toPos - idx;
                } else {

                    cnt = cnt + toPos - idx - 1;
                }

            } else if (switchCount < addAndSubCount) {
                cnt = cnt + switchCount;

            } else {
                cnt = cnt + addAndSubCount;

            }
            idx = toPos;
        }

        // end
        String lstStr = regxStr.substring(regxStr.length() - 1, regxStr.length());
        int lstIdx = to.lastIndexOf(lstStr);


        if (to.length() > lstIdx || to.length() > lstIdx) {
            int tailLen = to.length() > from.length() ? to.length() : from.length();
            cnt = cnt + tailLen - lstIdx - 1;
        }


        return cnt;

    }
}


public class DictionaryTest {


    @Test
    public void testStrigBuild() throws Exception {


        StringBuilder sb = new StringBuilder("abcdef");
        //add
//        sb.append("xxyyzz",2,3);


        sb.insert(2, "AA");
        System.out.println(sb.toString());


    }

    @Test
    public void testLanguages() {
        Dictionary dictionary = new Dictionary(new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
//        Dictionary dictionary = new Dictionary(new String[]{"javascript"});
        assertEquals("java", dictionary.findMostSimilar("heaven"));
//        assertEquals("javascript", dictionary.findMostSimilar("javascript"));
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

        String a = "rkacypviuburk";
        String b = "zqdrhpviqslik";
        Dictionary dictionary = new Dictionary();
        assertEquals(9, dictionary.moveCnt(a, b));

    }

    @Test
    public void testGetString2() throws Exception {

        Dictionary dictionary = new Dictionary();
        assertEquals("av", dictionary.getString("heaven", "javascript"));

    }

    @Test
    public void testAddSubSwitch() throws Exception {
        String a = "r    pvi    k";
        String b = "   r pvi    k";
        Dictionary dictionary = new Dictionary();
        assertEquals(9, dictionary.suggestCnt(a, b));
    }

    @Test
    public void testAddSubSwitch2() throws Exception {
        String a = "  er y";
        String b = "  er y";
        Dictionary dictionary = new Dictionary();
        assertEquals(3, dictionary.suggestCnt(a, b));
    }

    @Test
    public void testGetString3() throws Exception {
        Dictionary dictionary = new Dictionary();
//        assertEquals("codwars",dictionary.getString("coddwars","codewars"));
        assertEquals("erry", dictionary.getString("berry", "cherry"));
    }

    @Test
    public void testCnt() throws Exception {

        Dictionary dictionary = new Dictionary();
        assertEquals(6, dictionary.moveCnt("strawbery","cherry") );
        assertEquals(10, dictionary.moveCnt("strawbery","pineapple") );

        assertEquals(9, dictionary.moveCnt("ia","pineapple") );
        assertEquals(9, dictionary.moveCnt("strawbery","melon") );
        assertEquals(1, dictionary.moveCnt("strawbery","strawbery") );
        assertEquals(6, dictionary.moveCnt("heaven", "php"));
        assertEquals(2, dictionary.moveCnt("berry", "cherry"));
        assertEquals(5, dictionary.moveCnt("berry","melon") );



//        assertEquals(10, dictionary.moveCnt("rkacypviuburk","zqdrhpviqslik") );

//        assertEquals(11, dictionary.moveCnt("heaven", "coffeescript"));
//        assertEquals(3, dictionary.moveCnt("heaven","java") );
//        assertEquals(6, dictionary.moveCnt("strawbery","raspberry") );
    }

    @Test
    public void testBerries() {
        Dictionary dictionary = new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});
//        Dictionary dictionary = new Dictionary(new String[]{"strawberry"});
        assertEquals("strawberry", dictionary.findMostSimilar("strawbery"));
        assertEquals("cherry", dictionary.findMostSimilar("berry"));
    }
}

