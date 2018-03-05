package com.HarWienbergModeling;

public class Simulation {
    public static void main(String[] args)
    {
        Population population = new Population("Q", "q", .50, .50, 100000);
        System.out.println( "Generation: " + 0 );
        System.out.println(population.outputPopulation());
        Population nextPopulation = new Population(population.getOffspring());
        for(int index  = 0; index < 100000; index ++) {
            System.out.println("Generation: " + (index + 1));
            System.out.println(nextPopulation.outputPopulation());
            nextPopulation = new Population(nextPopulation.getOffspring());
        }
        System.out.println("Done");
    }
}
