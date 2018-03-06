package com.HarWienbergModeling;

public class Simulation {
    public static void main(String[] args) {
        for (int index = 0; index < 100; index++) {
            Species species = new Species("w", "W", (double) 1/90, 10, 100000);
            System.out.println(species.getGeneration(species.getGenerationCount() - 1));
        }
    }
}
