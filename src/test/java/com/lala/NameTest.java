package com.lala;

import org.junit.Test;

import java.time.LocalDateTime;
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
 곽중상 o
 }


 핑크 은규 은수 희수

 화 목 토 금 수
 동 환  ?

 토 부수
 희 재 균 곤 중 기 배 규 준 은 성 집 견 보 용 원 범

 喆 밝을 철, 쌍길 철
 基 터 기
 在 있을 재


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

//        DateTime now = DateTime.now();
        LocalDateTime timePoint = LocalDateTime.now(
        );
        System.out.println(timePoint);

        System.out.println("lala name ");
//        String [] midNames = {"희","재","균","곤","중","기","배","규","성","집","견","보","원","범","용","요"};
        String [] midNames = {"재","기","철"};
        String [] lstNames= {"혁","건","권","곤","감","구","궁","강","목","남","담","달","덕","동","람","록","량","론","류","민","망","명","목","무","봉","상","수","성","송","수","우","열","양","재","중","철","천","종","탁","택"};
        int times =  10;

        for (int i = 0; i < times; i++) {
            Random rndMid = new Random();
            Random rndLst = new Random();
//            System.out.print(rndMid.nextInt(midNames.length-1));
//            System.out.println(rndLst.nextInt(lstNames.length-1));

            String mid = midNames[rndMid.nextInt(midNames.length)];
            String lst = lstNames[rndLst.nextInt(lstNames.length)];

            System.out.print("곽");
            System.out.print(mid);
            System.out.println(lst);

        }

//        for (int i = 0; i < midNames.length; i++) {
//            String middle = midNames[i];
//            System.out.println(middle);
//        }

    }


    /**
     * 8.30
     곽재철 x
     곽보열 x
     곽재감 x
     곽집천 xx
     곽곤종 x
     곽중재 x
     곽희람 x
     곽보강 xx
     곽규권 발음 힘듬. x
     곽중권 x


     2017-08-31T16:48:00.395
     lala name
     곽배론 x
     곽중동 x
     곽기열 x
     곽보람 x
     곽은동 x
     곽준강 x
     곽집목 x
     곽곤감 x
     곽용명 x
     곽성철 x

     곽재권 x
     곽집철 x
     곽규탁 x
     곽재류 x
     곽집록 x
     곽성민 xx
     곽희수 woman ?
     곽재탁 x
     곽용탁 x
     곽균탁 x

     곽견량 x
     곽원곤 x
     곽중목 x
     곽준탁 x
     곽집양 x
     곽성달 x
     곽준상 oo
     곽집궁 x
     곽희천 x
     곽준곤 x


     곽준재 埈載 뛰어난고, 오르다
     곽규석 奎奭 성하고 큰 붉은 별.. 태양같은 존재. 검색시 많다.
     곽기량 基良 :기본이 좋다.
     곽규상 奎祥 좋은 상서로운 별
     奎相 서로 따르는 별
     奎常 떳떳한 별

     곽성강
     곽규강

     곽성천


     */

}
