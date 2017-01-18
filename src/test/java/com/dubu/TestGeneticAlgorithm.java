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
 * https://en.wikipedia.org/wiki/Genetic_algorithm/
 *
 *
 */



import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.*;
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

        int selectCnt = 2;
        List<String> rsList = new ArrayList<String>();

        double[] fitArr = new double[fitnesses.size()];

        for (int i = 0; i < fitnesses.size(); i++) {
            Double aDouble = fitnesses.get(i);
            fitArr[i] = aDouble;
        }

        for (int i = 0; i < selectCnt; i++) {

//            boolean flag = true;
//            while(flag){
//
//                int idx = rouletteSelect(fitArr);
//                if(rsList.contains(population.get(idx))){
//                    // pass
//                }else{
//                    rsList.add(population.get(idx));
//                    flag = false;
//                }
//            }


            // allow duplication
            int idx = rouletteSelect(fitArr);
            rsList.add(population.get(idx));

        }

        int rsSize = rsList.size();
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

        int defaultLoopCnt = 100;
        String s = this.run(fitness, length, p_c, p_m, defaultLoopCnt);
        return s;
    }

    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m, int iterations) {

        int loopCnt = iterations;
        String rsStr= "";
        double rsFitness = 0;

        for (int ii = 0; ii < iterations; ii++) {

            // 0 init
//            List<String> populationList = new ArrayList<String>();
//            LinkedList<String>(Arrays.asList(from.split("")));

            List<String> populationList = new LinkedList<String>();

            int listSize = 10;
            for (int i = 0; i < listSize; i++) {
                boolean flag = true;
                while (flag){
                    String generate = generate(length);
                    // test
//                    populationList.add("00000000000000000000000000000000000");
//                    flag =false;
//                    System.out.println(generate);

                    if(populationList.contains(generate)){
                        // pass
                    }else{
                        populationList.add(generate);
                        flag =false;
                    }
                }
            }

            List<String> testList = Arrays.asList("11011100101001001101101111001000010"
                    , "01111011100011110000110101110010011"
                    , "00101100111100011011100000010001111"
                    , "00110010010000111110000111001001011"
                    , "00101100011011001111000101000111110"
                    , "10101011010001001010010010011010010"
                    , "01010011001111111111111111000100110"
                    , "01000100000000111010000001010100100"
                    , "10110010001001010110101010101111011"
                    , "10110000011011010000011010001001001"
            );
//            populationList =  testList;

            for (int i = 0; i < populationList.size()/2; i++) {

                // 1 select
                List<Double> fitnessesList = getFitnesses(populationList,fitness);


                if(i == -1 ){
                    populationList.stream().forEach(System.out::println);
                    System.out.println("====");
                    fitnessesList.stream().forEach(System.out::println);
                    System.out.println("--------");

                }

                // 2 crosss

                if(randUniformPositive() <= p_c ){
                    // select two
                    String[] selectArr = select(populationList, fitnessesList);

                    String cro1 = selectArr[0];
                    String cro2 = selectArr[1];
                    String[] crossover = crossover(cro1, cro2);

                    populationList.remove(cro1);
                    populationList.remove(cro2);

                    String mutate0 = mutate(crossover[0], p_m);
                    String mutate1 = mutate(crossover[1], p_m);

                    populationList.add(mutate0);
                    populationList.add(mutate1);
                }

                // score
                // score sort


                // 4 loop
            }

            Collections.sort(populationList, (a, b) -> {

                if (fitness.applyAsDouble(a)>fitness.applyAsDouble(b)) {
                    return -1;
                }else{
                    return 1;
                }

            });

            // store close ideal
            String closeStr = populationList.get(0);
            double fit = fitness.applyAsDouble(closeStr);
//            System.out.println(score);
            if(fit > rsFitness){
                rsFitness = fit;
                rsStr = populationList.get(0);
                System.err.println(String.format("%s %s",rsStr,rsFitness));
            }

            if(fit == 1){
                return rsStr;
            }



        }

        if(Arrays.asList("00110011101110101000011000011100011","10010000001101001001110110110011111","01011000100110100011011100100111111","11111111111000000110010000010011010").contains(rsStr)){
            System.err.println("FOUND!!");
        }


        System.err.println(String.format("close : %s %s", rsStr,rsFitness));
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

    public List<Double> getFitnesses(List<String> population, ToDoubleFunction<String> fitnessFunc) {
        List<Double> fitnesses = new ArrayList<>();

        for (int i = 0; i < population.size(); i++) {
            String s = population.get(i);

//            long sum = getSum(s);
//            int product = getProduct(s);
//            double score = score(sum, product);
//            fitnesses.add(1/(score+1));

            double fit = fitnessFunc.applyAsDouble(s);
            fitnesses.add(fit);


        }

        return fitnesses;
    }


    public double getFitOne(String population){
        long sum = getSum(population);
        int product = getProduct(population);

        double score = score(sum, product);
        return 1/(score+1);

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

        List<Double> fitnesses = ga.getFitnesses(population, new ToDoubleFunction<String>() {
            @Override
            public double applyAsDouble(String s) {
                long sum = ga.getSum(s);
                int product = ga.getProduct(s);
                double score = ga.score(sum, product);
                return 1 / (score + 1);
            }
        });
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


//        List<String> list = Arrays.asList("0010010111", "1110001110", "1111100000", "0000011111");
//        List<String> list = Arrays.asList("00110011101110101000011000011100011","10010000001101001001110110110011111","10010101000000100101110010100010001","10011011011011101100101000000011100");
//        List<String> list = Arrays.asList("01001000000000100010111110101111110","01001001111001110011010100111011011","01100010011111111001010110110100011","11100110100000100101011011010011100");
//        List<String> list = Arrays.asList("00101000100110001000010110100011111","01100010100100011111110001000000110","01111010010110111000111001011010101","11101011011000100010100110001101011");
        List<String> list = Arrays.asList("10110010001000011011100000010011011");

        for (int i = 0; i < list.size(); i++) {
            String s =  list.get(i);

            long sum = ga.getSum(s);
            int product = ga.getProduct(s);

            double score = ga.score(sum, product);
            System.out.println(score);
            System.out.println(1/(score+1));
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

        String s = ga.run(value -> Double.valueOf(value), 10, 0.002,10);
        System.out.println(s);


    }


    @Test
    public void testRunZero35() throws Exception {

        GeneticAlgorithm ga = new GeneticAlgorithm();

        ToDoubleFunction<String> toDoubleFunction = new ToDoubleFunction<String>() {
            @Override
            public double applyAsDouble(String s) {
                long sum = ga.getSum(s);
                int product = ga.getProduct(s);
                double score = ga.score(sum, product);
                return 1 / (score + 1);
            }
        };
        for (int i = 0; i < 10; i++) {
            String s = ga.run(toDoubleFunction, 35, 0.6, 0.002,100);
            System.out.println(s);

        }


    }

    @Test
    public void testCompare() throws Exception {
        List<Integer> integers = Arrays.asList(5, 2, 4, 1, 32, 7);
        Collections.sort(integers, (o1, o2) -> {
            if (o1 > o2) {
                return 1 ;
            }else{
                return -1;
            }
        });

        System.out.println(integers);

    }

}

