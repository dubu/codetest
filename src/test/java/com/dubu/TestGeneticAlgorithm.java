package com.dubu;

/**
 * Created by dubu on 2017-01-14.
 *
 * https://www.codewars.com/kata/binary-genetic-algorithms/train/java
 *
 * https://namu.wiki/w/%EC%9C%A0%EC%A0%84%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
 *
 *
 * https://en.wikipedia.org/wiki/Fitness_proportionate_selection
 *
 *
 * https://en.wikipedia.org/wiki/Genetic_algorithm
 *
 *
 */
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.ToDoubleFunction;
import java.util.List;
import java.util.Map;

class GeneticAlgorithm {
    /***************************************************************
     * Feel free to change the private methods' signatures (I did) *
     * Only the "run" functions are tested                         *
     ***************************************************************/
    private String generate(int length) {

        return "";
    }

    public String[] select(List<String> population, List<Double> fitnesses) {


        StringBuilder sb = new StringBuilder();

        Double[] dd = new Double[fitnesses.size()];
        fitnesses.toArray(dd);
//        ArrayUtils.toPrimitive(dd);


        for (int i = 0; i < population.size(); i++) {

            int i1 = rouletteSelect(ArrayUtils.toPrimitive(dd));
            sb.append(population.get(i1));

        }

        return sb.toString().split("");

    }

    public String mutate(String chromosome, double p) {

        StringBuilder sb = new StringBuilder(chromosome);
        double [] pArr = {p,1-p};
        int i = rouletteSelect(pArr);

        if(i == 0){
            // do muate
            int pos = (int) (randUniformPositive() * chromosome.length());


            String mut = sb.substring(pos,pos+1);

            if(mut.length() >0 ){
                mut = mut.equals("1") ? "0":"1";
            }

            sb.replace(pos,pos+1,mut);


        }

        return sb.toString();
    }

    public String[] crossover(String chromosome1, String chromosome2) {


        double weight_sum = chromosome1.length();
        int value = (int) (randUniformPositive() * weight_sum);

        String s1 = chromosome1.substring(0, value) + chromosome2.substring(value);
        String s2 = chromosome2.substring(0, value) + chromosome1.substring(value);

        String[] rs = {s1, s2};
        return rs;
    }

    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m) {


        // init


        // select


        // crosss

        // replace


        // loop


        return null;
    }





    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m, int iterations) {



        return null;
    }

    public int rouletteSelect(double[] weight) {
        double weight_sum = 0;
        for(int i=0; i<weight.length; i++) {
            weight_sum += weight[i];
        }
        double value = randUniformPositive() * weight_sum;
        for(int i=0; i<weight.length; i++) {
            value -= weight[i];
            if(value <= 0) return i;
        }
        return weight.length - 1;
    }
    private  double randUniformPositive() {
        // easiest implementation
        return new Random().nextDouble();
    }
}


public class TestGeneticAlgorithm {

    @Test
    public void testRun() {

        GeneticAlgorithm ga = new GeneticAlgorithm();

        double[] list = {1,2,3,4};
//        double[] list = {4,3,2,1};
//        double[] list = {10,11,12,13};
        float cnt1 = 0;
        float cnt2 = 0;
        float cnt3 = 0;
        float cnt4 = 0;
        float cntElse = 0;

        int cnt =  10000;
        for (int i = 0; i < cnt; i++) {


            int i1 = ga.rouletteSelect(list);
            if(i1 == 0){
                cnt1 = ++cnt1;
            }else if(i1 == 1){
                cnt2 = ++cnt2;
            }else if(i1 == 2){
                cnt3 = ++cnt3;
            }else if(i1 == 3){
                cnt4 = ++cnt4;
            }else {
                cntElse = ++cntElse;

            }

        }

        System.out.println(cnt1);
        System.out.println(cnt2);
        System.out.println(cnt3);
        System.out.println(cnt4);
        System.out.println(cntElse);

        assertEquals(0.1,cnt1/cnt,0.1);
        assertEquals(0.2,cnt2/cnt,0.1);
        assertEquals(0.3,cnt3/cnt,0.1);
        assertEquals(0.4,cnt4/cnt,0.1);

        //Your test
    }

    @Test
    public void testSelect() throws Exception {

        List<String> population = Arrays.asList("A", "B", "C", "D", "E");
        List<Double> fitnesses = Arrays.asList(1.0, 2.0, 3.0, 4.0,5.0);

        GeneticAlgorithm ga = new GeneticAlgorithm();
        String[] select = ga.select(population, fitnesses);

        for (int i = 0; i < select.length; i++) {
            String s = select[i];
            System.out.println(s);
        }

    }

    @Test
    public void testSelect2() throws Exception {

        double p = 0.1;
        List<String> population = Arrays.asList("1", "0");
        List<Double> fitnesses = Arrays.asList(p, 1-p);

        GeneticAlgorithm ga = new GeneticAlgorithm();
        String[] select = ga.select(population, fitnesses);

        for (int i = 0; i < select.length; i++) {
            String s = select[i];
            System.out.println(s);
        }
    }

    @Test
    public void testSumAndProduct() throws Exception {

        String s = "0010010111";

        AtomicInteger index = new AtomicInteger();
        long sum = Arrays.stream(s.split("")).map(s1 -> {
            if (s1.equals("0")) {
                return index.incrementAndGet();
            } else {
                index.incrementAndGet();
                return 0;
            }
        }).mapToInt(i1 -> i1).sum();


        assertEquals(19, sum);

        index.set(0);
        int product = Arrays.stream(s.split("")).map(s1 -> {
            if (s1.equals("1")) {
                return index.incrementAndGet();
            } else {
                index.incrementAndGet();
                return 1;
            }
        }).reduce((integer, integer2) -> integer * integer2).get();

        assertEquals(12960, product);
//        System.out.println(sum);
//        System.out.println(product);
    }

    @Test
    public void testScore() throws Exception {

//        sqrt((chromosome sum - ideal sum)^2+(chromosome product - ideal product)^2)

    }

    @Test
    public void testCross() throws Exception {

        GeneticAlgorithm ga = new GeneticAlgorithm();


        for (int i = 0; i < 10000; i++) {

            String[] crossover = ga.crossover("01011010", "11110110");
            Arrays.stream(crossover).forEach((s) -> System.out.println(s));
        }

    }


    @Test
    public void testMutate() throws Exception {

        GeneticAlgorithm ga = new GeneticAlgorithm();


        for (int i = 0; i <100; i++) {

            String rs= ga.mutate("000000", 0.1);
            System.out.println(rs);
        }
    }
}

