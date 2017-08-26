package com.lala;

import org.junit.Test;

import java.util.Random;

public class NameTest {

    @Test
    public void nameGen() throws Exception {

        System.out.println("lala name ");
        String [] midNames = {"희","재","균","곤","중","기","배","규","준","은","성","집","견","보","용","원","범"};
        String [] lstNames= {"건","권","곤","감","구","궁","강","목","남","담","달","덕","동","람","록","량","론","름","류","민","망","명","목","무","봉","상","수","성","송","수","우","열","양","재","중","철","천","종","탁","택"};


        int times =  10;
        for (int i = 0; i < times; i++) {
            Random rndMid = new Random();
            Random rndLst = new Random();
//            System.out.print(rndMid.nextInt(midNames.length-1));
//            System.out.println(rndLst.nextInt(lstNames.length-1));

            String mid = midNames[rndMid.nextInt(midNames.length-1)];
            String lst = lstNames[rndLst.nextInt(lstNames.length-1)];

            System.out.print("곽");
            System.out.print(mid);
            System.out.println(lst);

        }


//        for (int i = 0; i < midNames.length; i++) {
//            String middle = midNames[i];
//            System.out.println(middle);
//        }

    }
}
