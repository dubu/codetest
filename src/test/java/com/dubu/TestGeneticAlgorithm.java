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
import org.junit.Test;
import static org.junit.Assert.assertEquals;

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

    private String[] select(List<String> population, List<Double> fitnesses) {
        return null;
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
}


public class TestGeneticAlgorithm {

    // Returns the selected index based on the weights(probabilities)
    int rouletteSelect(double[] weight) {
        // calculate the total weight
        double weight_sum = 0;
        for(int i=0; i<weight.length; i++) {
            weight_sum += weight[i];
        }
        // get a random value
        double value = randUniformPositive() * weight_sum;
        // locate the random value based on the weights
        for(int i=0; i<weight.length; i++) {
            value -= weight[i];
            if(value <= 0) return i;
        }
        // when rounding errors occur, we return the last item's index
        return weight.length - 1;
    }

    // Returns a uniformly distributed double value between 0.0 and 1.0
    double randUniformPositive() {
        // easiest implementation
        return new Random().nextDouble();
    }



    @Test
    public void testRun() {

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


            int i1 = rouletteSelect(list);
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
}

