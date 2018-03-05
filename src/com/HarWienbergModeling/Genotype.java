package com.HarWienbergModeling;

public class Genotype {
    private String allele1;
    private String allele2;

    public Genotype() {
        allele1 = null;
        allele2 = null;
    }

    public Genotype(String allele1, String allele2) {
        this.allele1 = allele1;
        this.allele2 = allele2;
    }
    public String toString() {
        String output = new String(allele1 + "," + allele2);
        return output;

    }
    public String getAllele(int Allele)
    {
        if(Allele == 1)
        {
            return allele1;
        }
        else
        {
            return allele2;
        }
    }
    public String type()
    {
        if(allele1 ==  allele2)
        {
            return "Homozygous: " + allele1 + allele2;
        }
        else
        {
            if(allele1.compareTo(allele2)>0)
            {
                return "Heterozygous: " + allele1 + allele2;
            }
            else
            {
                return "Heterozygous: " + allele2 + allele1;
            }

        }
    }


}
