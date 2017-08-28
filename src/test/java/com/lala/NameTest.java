package com.lala;

import org.junit.Test;

import java.util.Random;

/**
 *
 *
 *
 {
 곽기성 다
 곽기준 다
 곽규원 다
 --------------  --- ---  ---
 곽균우 ㅇ
 곽준재 ㅇ
 곽은기 ㅇ
 곽은규 ㅇ
 곽은민 ㅇ
 곽은우 ㅇ
 }


 핑크 은규 은수 희수

 화 목 토 금 수
 동 환  ?

 토 부수
 희 재 균 곤 중 기 배 규 준 은 성 집 견 보 용 원 범

 중간 돌림자
 "희","재","균","곤","중","기","배","규","준","은","성","집","견","보","용","원","범"
 마지막 이름
 "건","권","곤","감","구","궁","강","목","남","담","달","덕","동","달","람","록","량","론","름","류","민","망","명","목","무","봉","상","수","성","송","수","우","열","양","양","재","중","철","천","종","탁","택"

 곽희 희건 희권 희곤 희감 희구 희궁 희강 희목 희남 희담 희달 희덕
 희동 희달 희람 희록 희량 희론 희름 희류 희민 희망 희명 희목 희무 희봉 희상 희수 희성 희송 희수 희우 희열 희양 희용 희재 희중 희철 희천 희종 희탁 희택

 곽재
 곽균
 곽곤
 곽중
 곽기
 곽배
 곽규
 곽준
 곽은 은결
 곽성
 곽집
 곽견
 곽보
 곽용
 곽원
 곽범

 1. 1/100 겹칠 가능성이 높으면 안된다.
 2. 부르기 좋은 이름 발음 중심으로 정하나.
 3. 외자는 싫다.
 4. 오행순환법에의 돌린다. 항렬을 쓴다.

 *
 */
public class NameTest {

    @Test
    public void nameGen() throws Exception {

        System.out.println("lala name ");
        String [] midNames = {"희","재","균","곤","중","기","배","규","준","은","성","집","견","보","용","원","범"};
        String [] lstNames= {"건","권","곤","감","구","궁","강","목","남","담","달","덕","동","람","록","량","론","류","민","망","명","목","무","봉","상","수","성","송","수","우","열","양","재","중","철","천","종","탁","택"};
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
