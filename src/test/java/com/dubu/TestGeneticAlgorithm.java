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

    private String mutate(String chromosome, double p) {
        return null;
    }

    private String[] crossover(String chromosome1, String chromosome2) {
        return null;
    }

    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m) {
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
}

