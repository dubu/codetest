package com.dubu;

/**
 * Created by dubu on 2017-01-14.
 *
 * https://www.codewars.com/kata/binary-genetic-algorithms/train/java
 *
 * https://namu.wiki/w/%EC%9C%A0%EC%A0%84%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
 *
 *
 * https://en.wikipedia.org/wiki/Genetic_algorithm
 *
 *
 */
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.function.ToDoubleFunction;
import java.util.List;
import java.util.Map;

class GeneticAlgorithm {
    /***************************************************************
     * Feel free to change the private methods' signatures (I did) *
     * Only the "run" functions are tested                         *
     ***************************************************************/
    private String generate(int length) {
        // TODO: Implement the generate method

        return "";
    }

    private String[] select(List<String> population, List<Double> fitnesses) {
        // TODO: Implement the select method
        return null;
    }

    private String mutate(String chromosome, double p) {
        // TODO: Implement the mutate method
        return null;
    }

    private String[] crossover(String chromosome1, String chromosome2) {
        // TODO: Implement the crossover method
        return null;
    }

    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m) {
        // TODO: Implement the run method
        return null;
    }

    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m, int iterations) {
        // TODO: Implement the run method
        return null;
    }
}


public class TestGeneticAlgorithm {

    @Test
    public void testRun() {
        //Your test
    }
}

