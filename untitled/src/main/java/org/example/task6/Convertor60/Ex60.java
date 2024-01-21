package org.example.task6.Convertor60;

public class Ex60 {
    public static void main(String[] args){
        double temp = 25;
        System.out.println("t = " +
                new BaseConverter.KelvinConverter().getConvertedValue(temp));
        System.out.println("t = " +
                new BaseConverter.FahrenheitConverter().getConvertedValue(temp));

    }
}
