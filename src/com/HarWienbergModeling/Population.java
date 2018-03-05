package com.HarWienbergModeling;

import com.sun.jdi.ArrayReference;

import java.util.ArrayList;
import java.util.List;

public class Population {
    private Genotype[] individuals;
    public Population()
    {
        individuals = new Genotype[0];

    }
    public Population(Genotype[] initialIndividuals)
    {
        individuals = initialIndividuals;
    }
    public Population(String initialAllele1, String initialAllele2, double p, double q, int populationSize)
    {
        individuals = new Genotype[populationSize];
        for(int index = 0; index < individuals.length; index ++)
        {
            individuals[index] = new Genotype(calculateAllele(initialAllele1, initialAllele2, p, q ), calculateAllele(initialAllele1, initialAllele2, p,q));
        }
    }
    public Genotype[] getOffspring()
    {
        return createNewGeneration(individuals);
    }
    private Genotype[] createNewGeneration( Genotype[] previousGeneration)
    {
        List<Genotype> placeHolder =  replicateGenotype(previousGeneration);
        List<Genotype> output= new ArrayList<Genotype>();
        for (int i = 0; placeHolder.size() != 0 && i < previousGeneration.length ; i++)
        {
           double copyIndex1 = Math.floor(Math.random() * placeHolder.size());
           double copyIndex2 = Math.floor(Math.random() * placeHolder.size()) ;
           while(copyIndex2 == copyIndex1)
           {
               //System.out.println("Stuck Here");
               copyIndex2 = Math.floor(Math.random() * placeHolder.size());
           }
           for(int ctr = 0; ctr < 2; ctr++) {
               output.add(getOffspring(placeHolder.get((int) copyIndex1), placeHolder.get((int) copyIndex2)));
           }
           if(copyIndex1 > copyIndex2)
           {
               placeHolder.remove((int)copyIndex1);
               placeHolder.remove((int)copyIndex2);

           }
           else
           {
               placeHolder.remove((int)copyIndex2);
               placeHolder.remove((int)copyIndex1);
           }

        }
        Genotype[] outputArray = new Genotype[output.size()];
        for(int index = 0; index < outputArray.length;index++)
        {
            outputArray[index] = output.get(index);
        }
        return outputArray;



    }
    private ArrayList<Genotype> replicateGenotype(Genotype[] previousGeneration)
    {
        ArrayList<Genotype> output = new ArrayList<Genotype>();
        for(int index = 0; index < previousGeneration.length; index++)
        {
            output.add(previousGeneration[index]);
        }
        return output;
    }

    public Genotype[] getIndividuals() {
        return individuals;
    }

    private Genotype getOffspring(Genotype daddy, Genotype mommy)
    {
        String allele1 = new String();
        String allele2 = new String();
        if(Math.random() > .5)
        {
            allele1= daddy.getAllele(0);
        }
        else
        {
            allele1 = daddy.getAllele(1);
        }
        if(Math.random() > .5)
        {
            allele2 = mommy.getAllele(0);
        }
        else
        {
            allele2 = mommy.getAllele(1);
        }
        return new Genotype(allele1, allele2);
    }
    private String calculateAllele( String allele1, String allele2, double p, double q)
    {
        if(Math.random() > p)
        {
            return allele1;
        }
        else
        {
            return allele2;
        }
    }
    private List<String> getGenotypeTypes(Genotype[] genotypes)
    {
        List<String> output = new ArrayList<>();
        for(int index = 0; index < genotypes.length; index++)
        {
            boolean found = false;
            if(output.size() == 0)
            {
                output.add(genotypes[index].type());
                found = true;
            }
            for(int index2 = 0; index2<output.size(); index2++)
            {
                if(!found && genotypes[index].type().equals(output.get(index2)))
                {
                    found = true;
                }
            }
            if(!found)
            {
                output.add(genotypes[index].type());
            }
        }
        return output;
    }
    private int[] getGenotypeCount(List<String> genotypes)
    {
        int output[] = new int[genotypes.size()];
        for(int index = 0; index < individuals.length; index++)
        {
            for(int index2 = 0; index2 < genotypes.size(); index2++)
            {
                if(individuals[index].type().equals(genotypes.get(index2)))
                {
                    output[index2]++;
                }
            }
        }
        return output;
    }
    public String outputPopulation()
    {

        List<String> genotypes = getGenotypeTypes(individuals);
        int[] genotypeCount = getGenotypeCount(genotypes);
        String output = "";
        //System.out.println(genotypes.size());
        for(int index = 0; index < genotypeCount.length; index++)
        {
            output += genotypes.get(index) + ": " +genotypeCount[index] +"\n";
        }
        return output;
    }

}
