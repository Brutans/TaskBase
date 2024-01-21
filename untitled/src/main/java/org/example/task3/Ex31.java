package org.example.task3;

public class Ex31 {
    public static void main(String[] args){
        double minValue = 0;
        double maxValue = 10;
//        double n = Math.cos(Math.pow(7.0367431640625,5))+Math.pow(7.0367431640625,4)-345.3*7.0367431640625-23;
//        System.out.println(n);
        SqrtFound sqrtFound = new SqrtFound();
        System.out.println(sqrtFound.sqrt(minValue,maxValue));
    }
    public static class SqrtFound{

        public double sqrt(double minValue, double maxValue){
        double accuracy = 0.001;
        double avg = maxValue-minValue; // length
        if (Math.cos(Math.pow(minValue,5))+Math.pow(minValue,4)-345.3*minValue-23==0){
            return minValue;
        }if (Math.cos(Math.pow(maxValue,5))+Math.pow(maxValue,4)-345.3*maxValue-23==0){
                return maxValue;
            }
            avg = avg/2;
            double sqrt = minValue + avg;
        while (avg>accuracy){
            double n =Math.cos(Math.pow(sqrt,5))+Math.pow(sqrt,4)-345.3*sqrt-23;
            System.out.println(n+"Слева число, справа корень"+sqrt); //проверочка
            if(n<=accuracy&&n>=-accuracy){
                return sqrt;
            } if (n>0){
                sqrt = sqrt-avg/2;
                avg = avg/2;
            } if (n<0){
                sqrt = sqrt+avg/2;
                avg = avg/2;
            }
        }
            return sqrt;
        }
    }
}