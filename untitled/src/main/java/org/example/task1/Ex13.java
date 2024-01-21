package org.example.task1;

import java.util.Arrays;

public class Ex13 {
    public static void main(String[] args) {
        int num = 1;
        int[] array = {0, 2, 1, 1, 2, 3, 1, 2, 1, 4};
        System.out.println(Arrays.toString(removeElement(array, num)));
    }

    public static int[] removeElement(int[] arrayNums, int val){
        int entry = 0;
        for (int i = 0; i<arrayNums.length; i++){
            if (arrayNums[i]==1){
                entry++;
            }
        }
        int newArrayLenght = arrayNums.length-entry;
        int[] newArray = new int[newArrayLenght];
        int j = 0;
        for (int i = 0; i<arrayNums.length; i++){
            if (arrayNums[i]!=1){
                newArray[j]=arrayNums[i];
                j++;
            }
        }
        return newArray;
    }
}
