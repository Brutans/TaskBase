package org.example.task2;

import java.util.Arrays;

public class Ex21 {
    public static void main(String[] args){
        int[] arrayNums = {1, 2, 3};
        int[] arrayWeight = {1, 2, 10};
        WeightRand weightRand = new WeightRand();
        double[] arrayChance = weightRand.weightChance(weightRand.weightSum(arrayWeight),arrayWeight);
        System.out.println(weightRand.numChoice(arrayChance,arrayNums));
    }

    public static class WeightRand {
        public int weightSum(int[] arrayWeight) {
            int Weight = 0;
        for (int i = 0; i<arrayWeight.length; i++){
            Weight += arrayWeight[i];
            System.out.println(Weight);
        }
        return Weight; //13
        }
        public double[] weightChance(int Weight,int[] arrayWeight){
            double[] arrayChance = {0, 0, 0};
            for (int i=0; i<arrayWeight.length; i++){
                arrayChance[i] = (double) arrayWeight[i] /Weight;
                System.out.println(arrayChance[i]);
            }
            return arrayChance;
        }
        public int numChoice(double[] arrayChance, int[] arrayNums){
            double num = Math.random();
            System.out.println("Случайное число"+num);
            if (arrayChance[0]>num){
                return arrayNums[0];
            } if (arrayChance[1]>num){
                return arrayNums[1];
            } else{
                return arrayNums[2];
            }
        }
    }
}
