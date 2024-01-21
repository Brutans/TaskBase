package org.example.task3;

public class Ex30 {
    public static void main(String[] args){
        int key = 298;
        int n = 100000000;
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++){
            array[i] = i;
        }

        Checker checker = new Checker();
        //System.out.println(checker.lineChecker(key,array));
        System.out.println(checker.binaryChecker(key,array));
    }
    public static class Checker{
        public String lineChecker(int num, int[] array){
            for (int i = 0;i<array.length;i++){

                if (num==array[i]){
                    return "Значение присутствует";
                }
            }return "Значение отсутствует";
        }
        public String binaryChecker(int num, int[] array){
            int low = 0;
            int high = array.length - 1;

            while (low <= high) {
                int avg = (low + high) >>> 1;
                int avgVal = array[avg];

                if (avgVal < num)
                    low = avg + 1;
                else if (avgVal > num)
                    high = avg - 1;
                else
                    return "Значение: "+num+" присутствует";
            }
            return "Значение: "+num+" отсутствует";
        }
    }
}
