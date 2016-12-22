package com.dubu;

/**
 * Created by dubu on 2016-12-22.
 */
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


class Conversion {

    public String solution(int n) {
        StringBuffer sb = new StringBuffer();

        int len = (int) Math.log10(Double.valueOf(String.valueOf(n)));
        for (int i = len; i >= 0; i--) {

            int ni = (int) (n % Math.pow(10,i+1));
            int moc = 1 ;
            int nmg = 1 ;
            if(i >0){
                moc = (int) (ni / Math.pow(10,i));
                nmg = (int) (ni % Math.pow(10,i));
            }else{
//                moc = (int) (n / Math.pow(10,i));
                nmg = (int) (ni % 10);
            }


            if (i == 3) {
                switch (moc) {
                    case 1:
                        sb.append("M");
                        break;
                    case 2:
                        sb.append("MM");

                        break;
                    case 3:
                        sb.append("MMM");
                }

            } else if (i == 2) {
                switch (moc) {
                    case 1:
                        sb.append("C");
                        break;
                    case 2:
                        sb.append("CC");
                        break;
                    case 3:
                        sb.append("CC");
                        break;
                    case 4:
                        sb.append("CD");
                        break;
                    case 5:
                        sb.append("D");
                        break;
                    case 6:
                        sb.append("DC");
                        break;
                    case 7:
                        sb.append("DCC");

                        break;
                    case 8:
                        sb.append("DCCC");

                        break;
                    case 9:
                        sb.append("CM");

                        break;
                }

            } else if (i == 1) {
                switch (moc) {
                    case 1:
                        sb.append("X");

                        break;
                    case 2:
                        sb.append("XX");

                        break;
                    case 3:
                        sb.append("XXX");

                        break;
                    case 4:
                        sb.append("XL");

                        break;
                    case 5:
                        sb.append("L");

                        break;
                    case 6:
                        sb.append("LX");

                        break;
                    case 7:
                        sb.append("LXX");

                        break;
                    case 8:
                        sb.append("LXXX");

                        break;
                    case 9:
                        sb.append("XC");

                        break;

                }
            }else if (i == 0) {
                    switch (nmg) {
                        case 1:
                            sb.append("I");

                            break;
                        case 2:
                            sb.append("II");

                            break;
                        case 3:
                            sb.append("III");

                            break;
                        case 4:
                            sb.append("IV");

                            break;
                        case 5:
                            sb.append("V");

                            break;
                        case 6:
                            sb.append("VI");

                            break;
                        case 7:
                            sb.append("VII");

                            break;
                        case 8:
                            sb.append("VIII");

                            break;
                        case 9:
                            sb.append("IX");

                            break;

                    }
                }

            }


        System.out.println(sb.toString());

        return sb.toString();
    }
}

public class ConversionTest {

    private Conversion conversion = new Conversion();

    @Test
    public void shouldCovertToRoman() {
//        assertEquals("solution(1) should equal to I", "I", conversion.solution(1));
//        assertEquals("solution(4) should equal to IV", "IV", conversion.solution(4));
//        assertEquals("solution(6) should equal to VI", "VI", conversion.solution(6));
//        assertEquals("solution(6) should equal to VI", "VI", conversion.solution(721));
//        assertEquals("solution(6) should equal to VI", "XCI", conversion.solution(91));
        assertEquals("solution(6) should equal to VI", "LXXXIX", conversion.solution(89));

    }

}
