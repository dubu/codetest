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
    private static final int FROM = 1;
    private static final int TO = 2;
    private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

    public Dictionary() {
        this.words = null;

    }

    public String findMostSimilar(String from) {

        String[] strings = words;

        int rsCnt = Integer.MAX_VALUE;
        String rsStr = "";
        for (int i = 0; i < strings.length; i++) {


            String to = strings[i];
            int mvCnt = moveCnt(from, to);

            if(rsCnt > mvCnt){
                rsCnt = mvCnt;
                rsStr = to;
            }


        }

        return rsStr;
    }

    public int moveCnt(String from, String to) {

        int cntFrom = suggestCnt(from, to, FROM);
        int cntTo = suggestCnt(from, to, TO);

        return (cntFrom > cntTo ) ? cntTo : cntFrom;
    }

    private int suggestCnt(String from, String to, int type) {
        int rsCnt = Integer.MAX_VALUE;
        StringBuilder fromSb = new StringBuilder(from);
        StringBuilder toSb = new StringBuilder(to);

        int cnt = (type == FROM) ? to.length():from.length();
        String emptyList = Stream.generate(() -> " ").limit(cnt).collect(Collectors.joining(""));
        if(type == FROM){
            fromSb.insert(0, emptyList);
        }else{
            toSb.insert(0, emptyList);
        }

        for (int i = 0; i <= cnt; i++) {

            StringBuilder tmpFromSb = new StringBuilder(fromSb);
            StringBuilder tmpToSb = new StringBuilder(toSb);

            if(type == FROM){
                tmpFromSb.delete(0, i);
            }else{
                tmpToSb.delete(0, i);
            }

            int max = tmpFromSb.length() > tmpToSb.length() ?tmpFromSb.length():tmpToSb.length();
            int min = tmpFromSb.length() > tmpToSb.length() ?tmpToSb.length():tmpFromSb.length();

            int equCnt = 0 ;
            for (int j = min-i; j < min; j++) {
                if(j < 0){
                    // pass
                    continue;
                }
                String sb1 = tmpFromSb.substring(j, j+1);
                String sb2 = tmpToSb.substring(j, j+1);

                if(sb1.equals(sb2)){
                    if(sb1.equals(" ")){
                        // pass
                    }else{
                        equCnt =  ++equCnt;
                    }
                }
            }

            int mvCnt =  max - equCnt;

            System.out.println(String.format("%s %s %s", fromSb.toString(), toSb.toString(),mvCnt));


            if(rsCnt > mvCnt){

                rsCnt = mvCnt;
            }
        }
        return rsCnt;
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
        assertEquals(9, dictionary.moveCnt("strawbery","pineapple") );
        assertEquals(9, dictionary.moveCnt("strawbery","melon") );
        assertEquals(0, dictionary.moveCnt("strawbery","strawbery") );
        assertEquals(6, dictionary.moveCnt("heaven", "php"));
        assertEquals(2, dictionary.moveCnt("berry", "cherry"));
        assertEquals(4, dictionary.moveCnt("berry","melon") );


        assertEquals(7, dictionary.moveCnt("strawbery","cherry") );

        assertEquals(8, dictionary.moveCnt("ia","pineapple") );
        assertEquals(9, dictionary.moveCnt("rkacypviuburk","zqdrhpviqslik") );
        assertEquals(11, dictionary.moveCnt("heaven", "coffeescript"));

        assertEquals(4, dictionary.moveCnt("heaven","java") );
        assertEquals(7, dictionary.moveCnt("strawbery","raspberry") );
    }

    @Test
    public void testBerries() {
        Dictionary dictionary = new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});
//        Dictionary dictionary = new Dictionary(new String[]{"strawberry"});
        assertEquals("strawberry", dictionary.findMostSimilar("strawbery"));
        assertEquals("cherry", dictionary.findMostSimilar("berry"));
    }
}

