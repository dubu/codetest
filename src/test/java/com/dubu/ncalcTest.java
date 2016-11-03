package com.dubu;

import org.junit.Test;

/**
 * Created by rigel on 10/28/16.
 */
public class ncalcTest {


/*
def convert(n, base):
    T = "0123456789ABCDEF"
    q, r = divmod(n, base)
    if q == 0:
        return T[r]
    else:
        return convert(q, base) + T[r]


print convert(233, 2)
print convert(233, 8)
print convert(233, 16)
*/



    @Test
    public void testNN() throws Exception {



        int n  = 0;
        int base  = 0;
        convert(n, base);

    }

    private String convert(int n, int base) {
        //전체 26자

        String T =  "abcdefghijklmnopqrstuvwxyz";

        int q = n / base;
        int r = n % base;

        if(q == 0){
            return String.valueOf(T.toCharArray()[r]);
        }else{
            return  convert(q,base) + T.toCharArray()[r];
        }

    }

    @Test
    public void test10toN() throws Exception {
        System.out.println(convert(233, 2));

    }


    private Integer revert(String S, int base) {

        {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];



        }


        return  0 ;
    }


    @Test
    public void testNto10() throws Exception {


        revert("aaa",11);

    }
}
