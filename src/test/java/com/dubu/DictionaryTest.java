package com.dubu;

/**
 * Created by rigel on 12/13/16.
 * <p>
 * https://www.codewars.com/kata/did-you-mean-dot-dot-dot/train/java
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;


class Dictionary {
    private final String[] words;
    private int rsCnt;

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




        }
        System.out.println(storeStr);

        return storeStr;
    }

    public int moveCnt(String from, String to) {
        rsCnt = 0;

        suggestCnt(from, to);
        suggestCnt( to,from);

        return rsCnt;
    }

    private void suggestCnt(String from, String to) {
        StringBuilder fromSb = new StringBuilder(from);
        StringBuilder toSb = new StringBuilder(to);

        int cnt = to.length()-1;
        String emptyList = Stream.generate(() -> " ").limit(cnt).collect(Collectors.joining(""));
        fromSb.insert(0, emptyList);

        for (int i = 0; i < cnt; i++) {

            StringBuilder tmpFromSb = new StringBuilder(from);
            tmpFromSb.delete(0, i);

            int max = tmpFromSb.length() > toSb.length() ?tmpFromSb.length():toSb.length();
            int min = tmpFromSb.length() > toSb.length() ?toSb.length():tmpFromSb.length();

            int equCnt = 0 ;
            for (int j = min; j >0; j = j-1) {
                String sb1 = tmpFromSb.substring(j-1, j);
                String sb2 = toSb.substring(j-1, j);

                if(sb1.equals(sb2)){
                    if(sb1.equals(" ")){
                        // pass
                    }else{
                        equCnt =  ++equCnt;
                    }
                }
            }

            int mvCnt =  max - equCnt;



            if(rsCnt < mvCnt){

                rsCnt =  equCnt;
            }
        }
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
    public void testCnt() throws Exception {

        Dictionary dictionary = new Dictionary();
//        assertEquals(7, dictionary.moveCnt("strawbery","cherry") );
        assertEquals(10, dictionary.moveCnt("strawbery","pineapple") );
        assertEquals(9, dictionary.moveCnt("strawbery","melon") );
        assertEquals(1, dictionary.moveCnt("strawbery","strawbery") );
        assertEquals(6, dictionary.moveCnt("heaven", "php"));
        assertEquals(2, dictionary.moveCnt("berry", "cherry"));
        assertEquals(5, dictionary.moveCnt("berry","melon") );



//        assertEquals(9, dictionary.moveCnt("ia","pineapple") );
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

