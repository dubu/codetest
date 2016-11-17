package com.dubu;

    import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by rigel on 11/10/16.
 * <p/>
 * <p/>
 * https://www.codewars.com/kata/next-bigger-number-with-the-same-digits/train/java
 *
 * - 숫자 오더가 있다.
 - 맨뒤를 바꾼다. 안크면
 - 백자리를 올린다. 나머지 값으로 asc 한다.
 - order max 면 다음 자리를 올리면서 asc 한다.

 */
public class KataTests {

    @Test
    public void testMakeTestCase() throws Exception {

//        Kata.makeTestCase(12);
//        Kata.makeTestCase(513);
//        Kata.makeTestCase(2017);
//        Kata.makeTestCase(414);
//        Kata.makeTestCase(144);
//        Kata.makeTestCase(572159231);
//        Kata.makeTestCase(930458268);
//        Kata.makeTestCase(1660602199);
//        Kata.makeTestCase(1013388032);
//        Kata.makeTestCase(1759205111);
//        Kata.makeTestCase(1278754273);
//        Kata.makeTestCase(1142948762);
//        Kata.makeTestCase(1919511783);
//        Kata.makeTestCase(78429885);
//        Kata.makeTestCase(1542978633);
//        Kata.makeTestCase(659842390);
//        Kata.makeTestCase(637972185);
//        Kata.makeTestCase(698658665);
//        Kata.makeTestCase(1202410899);
//        Kata.makeTestCase(1367614518);
//        Kata.makeTestCase(1828309484);
//        Kata.makeTestCase(674994563);
//        Kata.makeTestCase(1487525443);
//        Kata.makeTestCase(1414753002);
//        Kata.makeTestCase(1807041661);
//        Kata.makeTestCase(331690328);
//        Kata.makeTestCase(2024075514);
//        Kata.makeTestCase(855991271);
//        Kata.makeTestCase(915887706);
//        Kata.makeTestCase(569700221);
//        Kata.makeTestCase(1140371586);
//        Kata.makeTestCase(75590407);
//        Kata.makeTestCase(839675576);
//        Kata.makeTestCase(1782265444);
//        Kata.makeTestCase(1651068903);
//        Kata.makeTestCase(957573647);
//        Kata.makeTestCase(1778721157);
//        Kata.makeTestCase(1483219877);
//        Kata.makeTestCase(537050398);
//        Kata.makeTestCase(19159827);
//        Kata.makeTestCase(549747781);
//        Kata.makeTestCase(1184957761);
//        Kata.makeTestCase(1634664554);
//        Kata.makeTestCase(1556608064);
//        Kata.makeTestCase(1890304864);
//        Kata.makeTestCase(1196784100);
//        Kata.makeTestCase(1152946080);
//        Kata.makeTestCase(446462719);
//        Kata.makeTestCase(1279825774);
//        Kata.makeTestCase(813774981);
//        Kata.makeTestCase(151881147);
//        Kata.makeTestCase(2132393692);
//        Kata.makeTestCase(1804239498);
//        Kata.makeTestCase(1982299788);
//        Kata.makeTestCase(901301564);
//        Kata.makeTestCase(1946959208);
//        Kata.makeTestCase(1285877199);
//        Kata.makeTestCase(1385506827);
//        Kata.makeTestCase(1780875485);
//        Kata.makeTestCase(2056875295);
//        Kata.makeTestCase(1522695680);
//        Kata.makeTestCase(529952386);
//        Kata.makeTestCase(1181068497);
//        Kata.makeTestCase(684339227);
//        Kata.makeTestCase(206493958);
//        Kata.makeTestCase(476925943);
//        Kata.makeTestCase(1967511666);
//        Kata.makeTestCase(1043886206);
//        Kata.makeTestCase(1580979147);
//        Kata.makeTestCase(687185696);
//        Kata.makeTestCase(246738655);
//        Kata.makeTestCase(1377624767);
//        Kata.makeTestCase(2034697811);
//        Kata.makeTestCase(1057208655);
//        Kata.makeTestCase(1254318243);
//        Kata.makeTestCase(1201271085);
//        Kata.makeTestCase(165988867);
//        Kata.makeTestCase(665511615);
//        Kata.makeTestCase(1396258138);
//        Kata.makeTestCase(331403227);
//        Kata.makeTestCase(1662361141);
//        Kata.makeTestCase(314073412);
//        Kata.makeTestCase(1800700866);
//        Kata.makeTestCase(1936569974);
//        Kata.makeTestCase(1745548811);
//        Kata.makeTestCase(1397752881);
//        Kata.makeTestCase(585487357);
//        Kata.makeTestCase(1975010472);
//        Kata.makeTestCase(1881173302);
//        Kata.makeTestCase(355967568);
//        Kata.makeTestCase(1537173670);
//        Kata.makeTestCase(978652531);
//        Kata.makeTestCase(1682859308);
//        Kata.makeTestCase(1660815065);
//        Kata.makeTestCase(218918940);
//        Kata.makeTestCase(1910851893);
//        Kata.makeTestCase(886770449);
//        Kata.makeTestCase(1305123591);
//        Kata.makeTestCase(1833245933);
//        Kata.makeTestCase(282178179);
//        Kata.makeTestCase(2041496611);
//        Kata.makeTestCase(1950529202);
//        Kata.makeTestCase(1913956501);
//        Kata.makeTestCase(1005422545);
//        Kata.makeTestCase(391185317);
//        Kata.makeTestCase(110204618);
//        Kata.makeTestCase(2145794893);
//        Kata.makeTestCase(1086240851);
//        Kata.makeTestCase(506628000);
//        Kata.makeTestCase(977271940);
//        Kata.makeTestCase(292404781);
//        Kata.makeTestCase(1776825735);
//        Kata.makeTestCase(1233780246);
//        Kata.makeTestCase(1764259222);
//        Kata.makeTestCase(748786689);
//        Kata.makeTestCase(852717650);
//        Kata.makeTestCase(111678225);
//        Kata.makeTestCase(1400195532);
//        Kata.makeTestCase(389692161);
//        Kata.makeTestCase(1146485328);
//        Kata.makeTestCase(1162339625);
//        Kata.makeTestCase(758453231);
//        Kata.makeTestCase(1854723333);
//        Kata.makeTestCase(1051742864);
//        Kata.makeTestCase(2097210025);
//        Kata.makeTestCase(1152581636);
//        Kata.makeTestCase(204839594);
//        Kata.makeTestCase(602069030);
//        Kata.makeTestCase(1402933106);
//        Kata.makeTestCase(660583222);
//        Kata.makeTestCase(2057777746);
//        Kata.makeTestCase(938861988);
//        Kata.makeTestCase(600224120);
//        Kata.makeTestCase(934795831);
//        Kata.makeTestCase(710144744);
//        Kata.makeTestCase(1668420665);
//        Kata.makeTestCase(1256744687);
//        Kata.makeTestCase(657809763);
//        Kata.makeTestCase(432409771);
//        Kata.makeTestCase(249931519);
//        Kata.makeTestCase(556442265);
//        Kata.makeTestCase(1006129997);
//        Kata.makeTestCase(949721774);
//        Kata.makeTestCase(217325074);
//        Kata.makeTestCase(1301123428);
//        Kata.makeTestCase(123456789);
//        Kata.makeTestCase(1234567890);
        //Kata.makeTestCase(987654321);
//        Kata.makeTestCase(987654);

        Kata.makeTestCase(9876543210l);
        Kata.makeTestCase(9999999999l);
        Kata.makeTestCase(59884848459853l);


        Kata.makeTestCase(5988484845l);


    }

    @Test
    public void basicTests() {

//        assertEquals(21, Kata.nextBiggerNumber(59884848459853L));

        assertEquals(-1, Kata.nextBiggerNumber(9876543210l));
        assertEquals(-1, Kata.nextBiggerNumber(9999999999l));
        assertEquals(59884848483559l, Kata.nextBiggerNumber(59884848459853l));
        assertEquals(5988484854l, Kata.nextBiggerNumber(5988484845l));


        assertEquals(21, Kata.nextBiggerNumber(12));
        assertEquals(531, Kata.nextBiggerNumber(513));
        assertEquals(2071, Kata.nextBiggerNumber(2017));
        assertEquals(441, Kata.nextBiggerNumber(414));
        assertEquals(414, Kata.nextBiggerNumber(144));


        assertEquals(414, Kata.nextBiggerNumber(144));


        assertEquals(214, Kata.nextBiggerNumber(142));
        assertEquals(1534, Kata.nextBiggerNumber(1453));
        assertEquals(3145, Kata.nextBiggerNumber(1543));

        assertEquals(1962525582, Kata.nextBiggerNumber(1962525528)); // 2122555689
        assertEquals(1962525825, Kata.nextBiggerNumber(1962525582)); //


        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1232567980, Kata.nextBiggerNumber(1232567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1254567980, Kata.nextBiggerNumber(1254567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1232567980, Kata.nextBiggerNumber(1232567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1254567980, Kata.nextBiggerNumber(1254567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1232567980, Kata.nextBiggerNumber(1232567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1254567980, Kata.nextBiggerNumber(1254567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1232567980, Kata.nextBiggerNumber(1232567908));
        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
        assertEquals(1254567980, Kata.nextBiggerNumber(1254567908));
//
//        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
//        assertEquals(624567980, Kata.nextBiggerNumber(624567908));
//        assertEquals(1434567980, Kata.nextBiggerNumber(1434567908));
//        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
//        assertEquals(1234567980, Kata.nextBiggerNumber(1234567908));
//        assertEquals(1634567980, Kata.nextBiggerNumber(1634567908));
//        assertEquals(1235567980, Kata.nextBiggerNumber(1235567908));


//        assertEquals(1234567980, Kata.nextBiggerNumber(1235567908));
//        assertEquals(1234567980, Kata.nextBiggerNumber(1235567908));
//        assertEquals(1234567980, Kata.nextBiggerNumber(1235567908));
//        assertEquals(1234567980, Kata.nextBiggerNumber(1235567908));
//        assertEquals(1234567980, Kata.nextBiggerNumber(1235567908));
//        assertEquals(1234567980, Kata.nextBiggerNumber(1235567908));




//        Process was terminated. It took longer than 12000ms to complete


//        assertEquals(2071, Kata.nextBiggerNumber(1234567890));

//        assertEquals(150990099, Kata.nextBiggerNumber(150909990));




        //  to conver 숫자
        // +1
        // revert 다시 숫자
        // 01  01
        // 210 211 212 220 221 222 301 513

//        110
//            111

    }


    @Test
    public void testOrderMap() throws Exception {

        int num = 252159;

        String numString = String.valueOf(num);
        char[] chars = numString.toCharArray();

        List<Character> orderList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        List<Integer> chkList ;
        List<Integer> tmpList ;
        Map<String,Integer> orderMap = new HashMap<>();
//        List<Integer> nextRsList = new ArrayList<>();
//        List<Character> ordList = new ArrayList<>();

        // init
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            orderList.add(aChar);
            intList.add(Integer.valueOf(String.valueOf(aChar)));

        }
        Collections.sort(orderList);

        for (int i = 0; i < orderList.size(); i++) {
            Character character = orderList.get(i);
            orderMap.put(String.valueOf(character),i);

        }

        System.out.println(orderMap);
        System.out.println(intList);

//        for (int i = intList.size() -2; i >= 0; i--) {
//            tmpList = new ArrayList<>();
//            tmpList.addAll(intList);
//
//            Integer lstVal = intList.get(intList.size() - 1);
//            Integer curVal = intList.get(i);
//
//            tmpList.set(i + 1, curVal);
//            tmpList.set(i, lstVal);
//
//            if (getInterValue(tmpList) > getInterValue(intList)) {
//
//                System.out.println(tmpList);
//            }
//
//        }

        chkList = new ArrayList<>();
        chkList.addAll(intList);


//        tmpList = new ArrayList<>();
//        tmpList.addAll(intList);


        tmpList = new ArrayList<>();
        tmpList.addAll(intList);

        int updatePositon = -1;
        while (true) {

            for (int i = 0; i < intList.size(); i++) {  // 자리수
                Integer integer = intList.get(i);


                Integer idx = 0;

                idx = orderMap.get(String.valueOf(integer));

                if(i < updatePositon){
                    continue;
                }

                if(i == updatePositon){
                    Integer integer1 = tmpList.get(i);
                    idx = orderMap.get(String.valueOf(integer1));
                }


                chkList = new ArrayList<>();
                chkList.addAll(intList);

                for (int j = 0; j < tmpList.size(); j++) {
                    Integer integer1 = tmpList.get(j);
                    chkList.remove(integer1);

                }

                for (int j = idx; j < orderList.size(); j++) {

                    Character character = orderList.get(j);

                    if(chkList.contains(Integer.valueOf(String.valueOf(character)))){

                        tmpList.set(i, Integer.valueOf(String.valueOf(character)));

                        if(getInterValue(tmpList) >getInterValue(intList) ){

                            System.err.println(tmpList);
                        }


                        break;


                    }

                }

                updatePositon = i-1;

                //for
            }
            //while
        }






    }

    public static double getInterValue(List<Integer> rsList) {

        double sum = 0;

        for (int i = 0; i < rsList.size(); i++) {
            Integer integer = rsList.get(i);

            sum = sum + integer * Math.pow(10, (rsList.size()- i -1));

        }
        return sum;
    }


    @Test
    public void testConvertNumber() throws Exception {

//        assertEquals("210",convertNumber(531));
//        assertEquals("2031",convertNumber(2071));
//        assertEquals("101",convertNumber(414));
//        assertEquals("011",convertNumber(144));


//        assertEquals("21",convertNumber(12));

        assertEquals(531, convertNumber(513));
        assertEquals(2071, convertNumber(2017));
        assertEquals(441, convertNumber(414));
        assertEquals(414, convertNumber(144));


//        "123345"
//        Set<String> foo = new HashSet<String>(myList);


        String rs = addOne("210");
    }

    private String addOne(String s) {

        char[] chars = s.toCharArray();
        ArrayList<Character> characters = new ArrayList<>();
        List<char[]> chars1 = Arrays.asList(chars);


        Integer integer = Integer.valueOf(s);

        while (true){

            integer = integer +1;

//            Set<Integer> foo = new HashSet<String>(myList);
//
//            covert(integer,s.)




            if(true){


                String rStr = revertNumber(integer);
                break;
            }
        }

        return null;
    }


    @Test
    public void testGetIntegerVal() throws Exception {


//        List<Integer> strings = Arrays.asList(2,4,6,1,2,3);
//        double interValue = Kata.getInterValue(strings);
//
//        System.out.println(interValue);


//        assertEquals(Double.parseDouble("12434"), Kata.getInterValue(Arrays.asList(1,2,4,3,4)));
//        assertEquals(942.0, Kata.getInterValue(Arrays.asList(9,4,2)));


        System.out.println(Kata.getLongValue(Arrays.asList(1, 2, 4, 3, 4)));

    }

    @Test
    public void testCovert() throws Exception {


        assertEquals("11" , covert(3, 2));
        assertEquals("21" , covert(9, 4));

    }

    private String covert(int n, int base) {

        List<String> t = Arrays.asList("0","1","2","3","4","5","6","7","8","9");
        int q =  n / base;
        int r =  n % base;
        if(q == 0){
            return t.get(r);
        }else{
            return  covert(q,base) + t.get(r);
        }
    }

    private String revertNumber(Integer num) {
        String numString = String.valueOf(num);

        return null;
    }


    private long convertNumber(long num) {
        String numString = String.valueOf(num);
        char[] chars = numString.toCharArray();

        List<Character> intList =  new ArrayList<>();
        List<Integer> rsList =  new ArrayList<>();
        List<Character> ordList =  new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if( ! ordList.contains(aChar)){
                intList.add(aChar);
            }

        }
        ordList.addAll(intList);
        Collections.sort(ordList);

        for (int i = 0; i < intList.size(); i++) {
            Character integer = intList.get(i);
            rsList.add(ordList.indexOf(integer));
        }

        StringBuilder b = new StringBuilder();
        rsList.stream().forEach(b::append);

///   --- 이하 좀 다름 ---


        char[] chars3 = b.toString().toCharArray();

        int integer = 0;
        for (int i = 0; i < chars3.length; i++) {
            char c = chars3[i];
            integer = (int) (integer  + Integer.valueOf(String.valueOf(c)) *  Math.pow(ordList.size(), chars3.length -1 -i));
        }
//        integer = integer + chars3[chars3.length-1];

        //Integer integer = Integer.valueOf(b.toString());
        while (true) {

            integer = integer + 1;

            String covert = covert(integer, ordList.size() );

//            if(covert.compareTo(numString)){
//
//            }

            char[] chars1 = b.toString().toCharArray();
            char[] chars2 = covert.toCharArray();

            Arrays.sort(chars1);
            Arrays.sort(chars2);

//            boolean areEqual = Arrays.equals(chars1), Arrays.sort(numString.toCharArray()));

            if (Arrays.equals(chars1, chars2)) {


                //String str = String.valueOf(covert);

                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < covert.toCharArray().length; i++) {
                    char c = covert.toCharArray()[i];

                    sb.append(ordList.get(Integer.valueOf(String.valueOf(c))));

                }


                return Long.valueOf(sb.toString());
            }
        }
    }




}


class Kata {


    public static void makeTestCase(long num) {

        System.out.printf("assertEquals(%d, Kata.nextBiggerNumber(%d)); \n" ,nextBiggerNumber(num) ,num );

    }


    public static long nextBiggerNumber(long num) {

        String numString = String.valueOf(num);
        char[] chars = numString.toCharArray();

        List<Integer> orderList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        List<Integer> iintList = new ArrayList<>();
        List<Integer> chkList = new ArrayList<>();
        List<Integer> tmpList ;
        Map<String,Integer> orderMap = new HashMap<>();


        List<Integer> markList = new ArrayList<>();

        // init
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            orderList.add(Integer.valueOf(String.valueOf(aChar)));
            intList.add(Integer.valueOf(String.valueOf(aChar)));

        }
        Collections.sort(orderList);

        Set<Integer> hs = new HashSet<>();
        hs.addAll(orderList);
        orderList.clear();
        orderList.addAll(hs);



        for (int i = 0; i < orderList.size(); i++) {
            Integer character = orderList.get(i);
            if( ! orderMap.keySet().contains(String.valueOf(character))){
                orderMap.put(String.valueOf(character),i);
            }
//            orderMap.put(String.valueOf(character),i);

        }

        Long initVal = getLongValue(intList);
        // init

        chkList.addAll(intList);

        int endPosition = -99;

        while(true){
            endPosition = -99;

            for (int i = intList.size()-1; i >=0 ; i--) {
                if (!markList.contains(i)){
                    endPosition = i;
                    break;
                }
            }

            if(markList.size() == intList.size()){
                return -1;
            }


            boolean chkFlag = true;
            markList = new ArrayList<>();
            for (int i = 0; i < intList.size(); i++) { // 자리수
                Integer integer = intList.get(i);

                if(endPosition != -1 && i < endPosition){
                    continue;
                }

                tmpList= chkList.subList(0,i);
                iintList = new ArrayList<>();
                iintList.addAll(intList);
                for (int k = 0; k < tmpList.size(); k++) {
                    Integer integer1 = tmpList.get(k);
                    iintList.remove(integer1);
                }

                for (int j = 0; j < orderList.size(); j++) {

                    Integer character = orderList.get(j);

                    // validate character
                    // useble charcter ?


                    if(iintList.contains(Integer.valueOf(String.valueOf(character)))){

                    }else{
                        continue;
                    }

                    chkList.set(i,Integer.valueOf(String.valueOf(character)));

//                    if(j == orderList.size()-1){
//                        endPosition =  i -1;
//                    }

//                    Collections.sort(iintList, Collections.reverseOrder());
                    if(iintList.get(iintList.size()-1) == Integer.valueOf(String.valueOf(character))){


                        markList.add(i);
                    }

                    Long chkVal = getLongValue(chkList);



//                    if(getInterValue(chkList.subList(0,i+1)) >= getInterValue(intList.subList(0,i+1))){
                    if(chkVal / 10 / (intList.size()-i) >= initVal / 10 / (intList.size()-i )){
                        if(i == endPosition){
                            endPosition = -99;
                            continue;
                        }

                        if(i == intList.size()-1 && chkVal > initVal) {
//                            System.err.println(chkList);
                            //return  Long.valueOf(String.valueOf(getLongValue(chkList).intValue()));
                            return chkVal;
                        }

//                        chkFlag =false;
                        break;
                    }

                }

            }

        }
    }


    public static Long getLongValue(List<Integer> rsList) {

        Long sum = 0l;

        for (int i = 0; i < rsList.size(); i++) {
            Integer integer = rsList.get(i);

            sum = sum + integer * (long)Math.pow(10, (rsList.size()- i -1));

        }
        return sum;
    }

//    public static Double getInterValue(List<Integer> rsList) {
//
//        double sum = 0;
//
//        for (int i = 0; i < rsList.size(); i++) {
//            Integer integer = rsList.get(i);
//
//            sum = sum + integer * Math.pow(10, (rsList.size()- i -1));
//
//        }
//        return sum;
//    }





    public static long nextBiggerNumberOld2(long num) {

        List<Integer> dubuList = new ArrayList<>();


        String numString = String.valueOf(num);
        char[] chars = numString.toCharArray();

        List<Character> intList = new ArrayList<>();
        List<Integer> rsList = new ArrayList<>();
        List<Integer> nextRsList = new ArrayList<>();
        List<Character> ordList = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            intList.add(aChar);

        }


        ordList.addAll(intList);
        Collections.sort(ordList);

        for (int i = 0; i < intList.size(); i++) {
            Character integer = intList.get(i);
            rsList.add(Integer.valueOf(String.valueOf(integer)));
        }

        StringBuilder b = new StringBuilder();
        rsList.stream().forEach(b::append);

        nextRsList.addAll(rsList);

//        nextRsList.set(rsList.size() -2 ,nextRsList.size() -1);
//        if(getInterValue(nextRsList) > getInterValue(rsList)){
//
//        }else{
//            nextRsList.set(nextRsList.size() -1 ,nextRsList.size() -2);
//
//        }

        nextRsList = new ArrayList<>();
        nextRsList.addAll(rsList);

        for (int i = ordList.size() -2; i >= 0; i--) {



            Integer lstVal = rsList.get(rsList.size() -1);
            Integer curVal = rsList.get(i);

            nextRsList.set(i+1 ,curVal);
            nextRsList.set(i ,lstVal);

            if(getLongValue(nextRsList) >  getLongValue(rsList)){


//                System.out.println(getInterValue(nextRsList));


                List<Integer> sortAbleList = nextRsList.subList(i+1, nextRsList.size());
                Collections.sort(sortAbleList);
                List<Integer> headList = nextRsList.subList(0, i+1);

                headList.addAll(sortAbleList);

                dubuList = headList;


                break;
//                for (int j = i; j < ordList.size(); j++) {
//
////                    nextRsList.set(rsList.size()-j ,rsList.get(nextRsList.size() -1-i));
////                    nextRsList.set(rsList.size() -1-i ,rsList.get(nextRsList.size() -2-i));
//
//                }


            }

        }








//        return (long) getInterValue(dubuList);
        return 0;
    }



    public static long nextBiggerNumberOld(long num) {
        String numString = String.valueOf(num);
        char[] chars = numString.toCharArray();

        List<Character> intList = new ArrayList<>();
        List<Integer> rsList = new ArrayList<>();
        List<Character> ordList = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (!ordList.contains(aChar)) {
                intList.add(aChar);
            }

        }
        ordList.addAll(intList);
        Collections.sort(ordList);

        for (int i = 0; i < intList.size(); i++) {
            Character integer = intList.get(i);
            rsList.add(ordList.indexOf(integer));
        }

        StringBuilder b = new StringBuilder();
        rsList.stream().forEach(b::append);

///   --- 이하 좀 다름 ---


        char[] chars3 = b.toString().toCharArray();

        int integer = 0;
        for (int i = 0; i < chars3.length; i++) {
            char c = chars3[i];
            integer = (int) (integer + Integer.valueOf(String.valueOf(c)) * Math.pow(ordList.size(), chars3.length - 1 - i));
        }
        while (true) {

            integer = integer + 1;

            String covert = covert(integer, ordList.size());

            char[] chars1 = b.toString().toCharArray();
            char[] chars2 = covert.toCharArray();

            Arrays.sort(chars1);
            Arrays.sort(chars2);

            if (Arrays.equals(chars1, chars2)) {

                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < covert.toCharArray().length; i++) {
                    char c = covert.toCharArray()[i];

                    sb.append(ordList.get(Integer.valueOf(String.valueOf(c))));

                }
                return Long.valueOf(sb.toString());
            }
        }
    }


    private static String covert(int n, int base) {

        List<String> t = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        int q = n / base;
        int r = n % base;
        if (q == 0) {
            return t.get(r);
        } else {
            return covert(q, base) + t.get(r);
        }
    }

}

