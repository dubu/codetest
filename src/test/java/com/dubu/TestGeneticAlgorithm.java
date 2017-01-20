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


//    public double idealSum = 337;
//    public double idealProduct = 1.31755793433264E19;


    public double idealSum = 0;
    public double idealProduct = 0;
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


        for (int iii = 0; iii < iterations; iii++) {


            int generationCnt = 100;

            // 0 init
//        List<String> populationList = new LinkedList<String>();
            List<String> populationList = new ArrayList();
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

            List<String> testList = Arrays.asList("01101101010110011100111111000110010"
                , "10101110010011001101101101101010110"
                , "10101010111000011111100111011001001"
                , "11011010101100010000010111100111111"
                , "11001100111111111101110101000100001"
                , "11001100100110011111010110110010011"
                , "01101111100000101110110111000111010"
                , "11011110101101001010110111010110010"
                , "10110010001001010110101010101111011"
                , "10110000011011010000011010001001001"
            );
            populationList =  testList;


            for (int ii = 0; ii < generationCnt; ii++) {

                ArrayList<String> nextPopulationList = new ArrayList<>();
//            for (int i = 0; i < populationList.size()/2; i++) {

                while(nextPopulationList.size() < listSize){
                    // 1 select
                    List<Double> fitnessesList = getFitnesses(populationList,fitness);


                    if(nextPopulationList.size() == -1 ){
                        Collections.sort(populationList, (a, b) -> {

                            if (fitness.applyAsDouble(a)>fitness.applyAsDouble(b)) {
                                return -1;
                            }else{
                                return 1;
                            }

                        });

                        System.out.println("====  "+ nextPopulationList.size());
                        populationList.stream().forEach(System.out::println);
                        System.out.println("====");
                        populationList.stream().map(s ->fitness.applyAsDouble(s)).forEach(System.out::println);

                    }

                    // 2 crosss

                        // select two
                    String[] selectArr = select(populationList, fitnessesList);
                    String cro1 = selectArr[0];
                    String cro2 = selectArr[1];

                    if(randUniformPositive() <= p_c ){
                        String[] crossover = crossover(cro1, cro2);

//                    populationList.remove(cro1);
//                    populationList.remove(cro2);

                        String mutate0 = mutate(crossover[0], p_m);
                        String mutate1 = mutate(crossover[1], p_m);

                        if(nextPopulationList.contains(mutate0)){
                            // pass
                        }else{
                            nextPopulationList.add(mutate0);
                        }

                        if(nextPopulationList.contains(mutate1)){
                            // pass
                        }else{
                            nextPopulationList.add(mutate1);
                        }

                    }else{
                        // not cross
                        if(nextPopulationList.contains(cro1)){
                            // pass
                        }else{
                            nextPopulationList.add(cro1);
                        }

                        if(nextPopulationList.contains(cro2)){
                            // pass
                        }else{
                            nextPopulationList.add(cro2);
                        }

                    }


                   // score
                    // score sort


                    // 4 loop
                }



                // replace next generation !!
                populationList = nextPopulationList;

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
                    System.err.println("for iii "+iii);
                    return rsStr;
                }


                if(ii == generationCnt-1){
                    System.out.println("====  "+ nextPopulationList.size());
                    populationList.stream().forEach(System.out::println);
                    System.out.println("====");
                    populationList.stream().map(s ->fitness.applyAsDouble(s)).forEach(System.out::println);

                }

            }


        }



//        if(Arrays.asList("00110011101110101000011000011100011","10010000001101001001110110110011111","01011000100110100011011100100111111","11111111111000000110010000010011010").contains(rsStr)){
//            System.err.println("FOUND!!");
//        }


//        System.out.println(String.format("close : %s %s", rsStr,rsFitness));

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


    public double getProduct(String s) {
        AtomicInteger index = new AtomicInteger();
        return Arrays.stream(s.split("")).map(s1 -> {
            if (s1.equals("1")) {
                return index.incrementAndGet();
            } else {
                index.incrementAndGet();
                return 1;
            }
        }).mapToDouble(d -> d ).reduce((integer, integer2) -> integer * integer2).getAsDouble();
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
        double product = getProduct(population);

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
                double product = ga.getProduct(s);
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
        double product = ga.getProduct(s);

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
            double product = ga.getProduct(s);

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

            String[] crossover = ga.crossover("0000000000", "1111100000");
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


//        10111110100011110010001010000010111

        GeneticAlgorithm ga = new GeneticAlgorithm();

        ToDoubleFunction<String> toDoubleFunction = new ToDoubleFunction<String>() {
            @Override
            public double applyAsDouble(String s) {
                long sum = ga.getSum(s);
                double product = ga.getProduct(s);
                double score = ga.score(sum, product);
                return 1 / (score + 1);
            }
        };
        for (int i = 0; i < 10; i++) {
            String s = ga.run(toDoubleFunction, 35, 0.6, 0.002,100);
            System.out.println(s);

            if(s.equals("10111110100011110010001010000010111")){
                System.out.printf("#######   found  ##########");
            }

        }

    }

    @Test
    public void testRunX() throws Exception {
//        String str = "00010001000001000100000000010011111";
//        String str = "10011000111011100101100111010100110";
        String str = "10110010010111011101001101111100010";

//        String str = "100111011001"; //36
        GeneticAlgorithm ga = new GeneticAlgorithm();

        long idealSum = ga.getSum(str);
        double idealProduct = ga.getProduct(str);
        ga.idealProduct =  idealProduct;
        ga.idealSum =  idealSum;

        ToDoubleFunction<String> toDoubleFunction = new ToDoubleFunction<String>() {
            @Override
            public double applyAsDouble(String s) {
                long sum = ga.getSum(s);
                double product = ga.getProduct(s);
                double score = ga.score(sum, product);
                return 1 / (score + 1);
            }
        };


        int foundTime = 0;
        for (int i = 0; i < 1; i++) {
            String s = ga.run(toDoubleFunction, str.length(), 0.6, 0.002,1);

            System.err.println(s);
            System.err.println("     ");


            if(s.equals(str)){
                System.err.printf("####### found   ##########   " +i );
                ++foundTime;
                break;
            }

        }

        System.out.println(foundTime);

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

    @Test
    public void testEquation() throws Exception {
        GeneticAlgorithm ga = new GeneticAlgorithm();
//        String s1 = "11011100101001001101101111001000010";
//        String s2 = "01111011100011110000110101110010011";

        String s1 = "";
        String s2 = "";
        double fit1 =  0.0;
        double fit2 =  0.0;

        s1 = "10111110100011110010001010000010111";
        s2 = "10100011000010110100111000100001000";
        fit1 =  0.047619047619047616;
        fit2 =  0.045454545454545456;

        s1 = "000111";
        s2 = "010101";
        fit1 =  0.01036058659323429;
        fit2 =  0.0060395514240891525;

        // ideal s1 = "10111110100011110010001010000010111";

        s1 = "10111110100011110010001000000000000";
        s2 = "10100011000010110100111000100001000";
        fit1 =  ga.getFitOne(s1);
        fit2 =  ga.getFitOne(s2);

        long sum1 =  ga.getSum(s1);
        long sum2 =  ga.getSum(s2);

        double prod1  =  ga.getProduct(s1);
        double prod2  =  ga.getProduct(s2);

        double sco1 = 1/fit1 - 1;
        double sco2 = 1/fit2 - 1;

//        int idealProd = 0;
//        math.sqrt( Math.pow(sum - idealSum, 2) - 0.2^2 ) -product =  - idealProduct


        double min = Double.MAX_VALUE;

        for (int idealSum = 0; idealSum <= 630  ; idealSum++) {

//            idealSum = 630;
            double ip11= Math.sqrt(Math.abs(Math.pow(sco1,2)-Math.pow(sum1-idealSum,2)))-prod1;
            double ip12= Math.sqrt(Math.abs(Math.pow(sco1,2)-Math.pow(sum1-idealSum,2)))+prod1;

            double ip21= Math.sqrt(Math.abs(Math.pow(sco2,2)-Math.pow(sum2-idealSum,2)))-prod2;
            double ip22= Math.sqrt(Math.abs(Math.pow(sco2,2)-Math.pow(sum2-idealSum,2)))+prod2;

//            if(Arrays.asList(Math.abs(ip11),Math.abs(ip12)).contains(Math.abs(ip21))){
            if (Math.abs(ip11) == Math.abs(ip22)) {
                System.out.println(idealSum);
            }

            if(Arrays.asList(ip11,ip12).contains(ip22)){
                System.out.println(idealSum);
            }
        }



    }

    @Test
    public void testName() throws Exception {
        GeneticAlgorithm ga = new GeneticAlgorithm();

        String s1 = "000111";
        String s2 = "010101";

//        s1 = "10111110100011110010001010000010111";
//        s2 = "10100011000010110100111000100001000";

        long sum1 =  ga.getSum(s1);
        long sum2 =  ga.getSum(s2);

        double prod1  =  ga.getProduct(s1);
        double prod2  =  ga.getProduct(s2);

        double sco1 =  ga.score(sum1,prod1);
        double sco2 =  ga.score(sum2,prod2);
//        double v1= Math.sqrt(Math.pow(sum1 - ga.idealSum, 2) - Math.pow(sco1, 2)) - prod1;
        double idProd1= Math.sqrt(Math.pow(sco1,2)-Math.pow(sum1-ga.idealSum,2))-prod1;
        double idProd2= Math.sqrt(Math.pow(sco1,2)-Math.pow(sum1-ga.idealSum,2))+prod1;

        double prod = idProd1;


//        Math.sqrt(Math.pow(sum - idealSum, 2) + Math.pow(product - idealProduct, 2));

        System.out.println(prod);
    }


    @Test
    public void testSqurt() throws Exception {
        System.out.println(Math.sqrt(4));
        System.out.println(Math.pow(3,2));

    }


    @Test
    public void testScore22() throws Exception {
        GeneticAlgorithm ga = new GeneticAlgorithm();
        String s1 = "000111";
        String s2 = "010101";

        long sum1 =  ga.getSum(s1);
        long sum2 =  ga.getSum(s2);

        double prod1  =  ga.getProduct(s1);
        double prod2  =  ga.getProduct(s2);

        double sco1 =  ga.score(sum1,prod1);

        double sco2 =  ga.score(sum2,prod2);

        System.out.println(sco1);
        System.out.println(Math.sqrt(Math.pow(sum1 - ga.idealSum, 2) + Math.pow(prod1 - ga.idealProduct, 2)));



        System.out.println(Math.pow(sco1,2));
        System.out.println(Math.pow(sum1 - ga.idealSum, 2) + Math.pow(prod1 - ga.idealProduct, 2));


        System.out.println(Math.pow(sum1 - ga.idealSum, 2));
        System.out.println(Math.pow(sco1, 2) - Math.pow(prod1 - ga.idealProduct, 2));


        System.out.println(Math.pow(prod1 - ga.idealProduct, 2));
        System.out.println(Math.pow(sco1, 2) - Math.pow(sum1 - ga.idealSum, 2));

        System.out.println(prod1 - ga.idealProduct);
        System.out.println(Math.sqrt(Math.pow(sco1, 2) - Math.pow(sum1 - ga.idealSum, 2)));

        System.out.println("####");
        System.out.println(prod1 +Math.sqrt(Math.pow(sco1, 2) - Math.pow(sum1 - ga.idealSum, 2)) );
        System.out.println(prod1 -Math.sqrt(Math.pow(sco1, 2) - Math.pow(sum1 - ga.idealSum, 2)) );
        System.out.println(Math.abs(- ga.idealProduct));

    }


    @Test
    public void testSum() throws Exception {

        int sum = 0;
        for (int i = 0; i <= 35; i++) {
            sum = sum +i ;
        }
        System.out.println(sum);
    }


    @Test
    public void testProduct() throws Exception {

        GeneticAlgorithm ga = new GeneticAlgorithm();
        String s2 = "10100011000010110100111000100001000";
        System.out.println(ga.getProduct(s2));
    }


    @Test
    public void testEExpress() throws Exception {

        double sum = 1 ;
        for (int i = 0; i < 100; i++) {
           sum  = sum / 100;
        }
        System.out.println(sum);

    }
}


