package org.example.task1;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Ex10 {
    public static void main(String[] args) {

        int n = 50;
        double[] array = new double[n];
        for (int i = 0; i < array.length; i++){
        array[i] = Math.random();
        }
        double maxValue = array[0];
        double minValue = array[1];
        for (int i = 0; i < array.length; i++){
            if (maxValue < array[i]){
                maxValue = array[i];
            } if (minValue > array[i]){
                minValue = array[i];
            }
        }
        System.out.println("Минимальное значение:"+minValue);
        System.out.println("Максимальное значение:"+maxValue);
        System.out.println("Среднее значение значение:"+((minValue+maxValue)/2));
    }
}

