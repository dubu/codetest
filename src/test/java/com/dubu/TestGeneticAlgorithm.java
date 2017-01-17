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



import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.ToDoubleFunction;


class GeneticAlgorithm {


    private double idealSum = 38;
    private double idealProduct = 210;

    /***************************************************************
     * Feel free to change the private methods' signatures (I did) *
     * Only the "run" functions are tested                         *
     ***************************************************************/

    private String generate(int length) {

        StringBuilder sb = new StringBuilder();
        double[] pArr = {0.5, 0.5};

        for (int i = 0; i < length; i++) {

            int num = rouletteSelect(pArr);
            if (num == 0) {
                sb.append("0");
            }else{
                sb.append("1");
            }
        }
        return sb.toString();
    }


    public String[] select(List<String> population, List<Double> fitnesses) {


        List<String> rsList = new ArrayList<String>();

//        Double[] dd = new Double[fitnesses.size()];
//        fitnesses.toArray(dd);

        double[] fitArr = new double[fitnesses.size()];

        for (int i = 0; i < fitnesses.size(); i++) {
            Double aDouble = fitnesses.get(i);
            fitArr[i] = aDouble;
        }

        for (int i = 0; i < fitnesses.size(); i++) {

            int idx = rouletteSelect(fitArr);
//            rsArr[i] = population.get(idx);

            rsList.add(population.get(idx));

        }

        // score select
        Collections.sort(rsList, (a, b) -> {

            long sumA = getSum(a);
            long sumB = getSum(b);

            int productA = getProduct(a);
            int productB = getProduct(b);


            if(score(sumA,productA) <  score(sumB,productB)){
                return 1;
            }
            return 0;
        });

        int rsSize = fitnesses.size()/2;
        String [] rsArr = new String[rsSize];
        for (int i = 0; i < rsSize; i++) {
            String s = rsList.get(i);
            rsArr[i] =  s;

        }

        return  rsArr;

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

        int defaultLoop = 100;
        String s = this.run(fitness, length, p_c, p_m, defaultLoop);
        return s;
    }

    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m, int iterations) {

        int loopCnt = iterations;
        String rsStr= "";

        // 0 init
        List<String> population = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            population.add(generate(length));
        }

        for (int i = 0; i < loopCnt; i++) {

            // 1 select
            List<Double> fitnesses = getFitnesses(population);
            String[] selectArr = select(population, fitnesses);

            // 2 crosss
            for (int j = 0; j < selectArr.length * p_c; j++) {
                int idx1 = (int) (randUniformPositive() * selectArr.length);
                String cro1 = selectArr[idx1];

                if(cro1 == null){
                    System.err.println("err");
                }

                int idx2 = (int) (randUniformPositive() * selectArr.length);
                String cro2 = selectArr[idx2];

                if(cro2 == null){
                    System.err.println("err");
                }

                String[] crossover = crossover(cro1, cro2);

                selectArr[idx1] = crossover[0];
                selectArr[idx2] = crossover[1];

            }

            // 3 mutate
            for (int j = 0; j < selectArr.length ; j++) {
                String cromo = selectArr[j];

                String mutate = mutate(cromo, p_m);
                selectArr[j] = mutate;

            }

            // store hight rank
            rsStr = selectArr[0];

            // 4 loop
        }

        return rsStr;
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


    public double score(double sum, double product) {
        return Math.sqrt(Math.pow(sum - idealSum, 2) + Math.pow(product - idealProduct, 2));
    }


    public int getProduct(String s) {
        AtomicInteger index = new AtomicInteger();
        return (int) Arrays.stream(s.split("")).map(s1 -> {
            if (s1.equals("1")) {
                return index.incrementAndGet();
            } else {
                index.incrementAndGet();
                return 1;
            }
        }).reduce((integer, integer2) -> integer * integer2).get();
    }

    public long getSum(String s) {
        AtomicInteger index = new AtomicInteger();
        return (long) Arrays.stream(s.split("")).map(s1 -> {
            if (s1.equals("0")) {
                return index.incrementAndGet();
            } else {
                index.incrementAndGet();
                return 0;
            }
        }).mapToInt(i1 -> i1).sum();
    }

    public List<Double> getFitnesses(List<String> population) {
        List<Double> fitnesses = new ArrayList<>();

        for (int i = 0; i < population.size(); i++) {
            String s = population.get(i);
            long sum = getSum(s);
            int product = getProduct(s);

            double score = score(sum, product);
            fitnesses.add(1/score);

        }

        return fitnesses;
    }
}


public class TestGeneticAlgorithm {

    @Test
    public void testRouletteSelect() {

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


        GeneticAlgorithm  ga = new GeneticAlgorithm();

        List<String> population = Arrays.asList("00001", "00010", "00100", "01000", "10000");
//        List<Double> fitnesses = Arrays.asList(1.0, 2.0, 3.0, 4.0,5.0);
        List<Double> fitnesses = ga.getFitnesses(population);
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

        GeneticAlgorithm  ga = new GeneticAlgorithm();
        String s = "0010010111";

        long sum = ga.getSum(s);
        int product = ga.getProduct(s);

        assertEquals(19, sum);
        assertEquals(12960, product);

//        System.out.println(sum);
//        System.out.println(product);
    }

    @Test
    public void testScore() throws Exception {

//        sqrt((chromosome sum - ideal sum)^2+(chromosome product - ideal product)^2)

        GeneticAlgorithm  ga = new GeneticAlgorithm();
//        String s = "0010010111";


        List<String> list = Arrays.asList("0010010111", "1110001110", "1111100000", "0000011111");

        for (int i = 0; i < list.size(); i++) {
            String s =  list.get(i);

            long sum = ga.getSum(s);
            int product = ga.getProduct(s);

            double score = ga.score(sum, product);
            System.out.println(score);
        }

//        double sum = 10;
//        double product = 20;

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


    @Test
    public void testRun() throws Exception {

        GeneticAlgorithm ga = new GeneticAlgorithm();

        String s = ga.run(value -> Double.valueOf(value + 1), 10, 0.1, 0.2);
        System.out.println(s);


    }
}

