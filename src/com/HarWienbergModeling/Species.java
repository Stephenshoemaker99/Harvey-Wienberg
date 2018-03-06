package com.HarWienbergModeling;

import java.util.ArrayList;

public class Species {
    private ArrayList<Generation> generations;
    public Species()
    {
        generations = new ArrayList<Generation>();
    }
    public Species(ArrayList<Generation> initialGenerations)
    {
        generations = initialGenerations;
    }
    public Species(String initialAllele1, String initialAllele2, double allele1Frequency, double allele2Frequency, int generationCount, int generationSize)
    {
        this();
        for (int index = 0; index < generationCount; index++) {
            generations.add( new Generation(initialAllele1,initialAllele2,allele1Frequency,allele2Frequency,generationSize));
        }
    }
    public Species(String initialAllele1, String initialAllele2, double allele1Frequency, int generationCount, int generationSize)
    {
        this(initialAllele1,initialAllele2,allele1Frequency,1 - allele1Frequency, generationCount,generationSize);
    }
    public Generation getGeneration(int generationIndex)
    {
        return generations.get(generationIndex);
    }
    public int getGenerationCount()
    {
        return generations.size();
    }
    public int getSpeciesSize()
    {
        return generations.get(0).getGenerationSize();
    }

    @Override
    public String toString() {
        String output = new String();
        for(int index= 0; index < generations.size(); index++)
        {
            output += "Generation: " + index + "\n";
            output += generations.get(index).output() + "\n\n";
        }
        return output;
    }
}
