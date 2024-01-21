package org.example.task1;

import java.util.Arrays;

public class Ex11{
    public static void main(String[] args){
    int n = 10;
    double[] array = new double[n];
    for (int i = 0; i < array.length; i++){
        array[i] = Math.random();
    }
    for (int i = 0; i < array.length; i++){
        for (int j = 0; j < array.length - i - 1; j++){
            if (array[j]>array[j+1]){
                double buffer=array[j];
                array[j] = array[j+1];
                array[j+1]=buffer;
            }
        }
    }
        System.out.println(Arrays.toString(array));
    }
}
