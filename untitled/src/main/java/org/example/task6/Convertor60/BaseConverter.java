package org.example.task6.Convertor60;

public class BaseConverter {
    interface Converter{
        double getConvertedValue (double baseValue);
    }
    static class KelvinConverter implements Converter{
        public double getConvertedValue(double baseValue) {
            return baseValue+273.15;
        }
    }

    static class FahrenheitConverter implements Converter{
        public double getConvertedValue(double baseValue){
            return 1.8*baseValue+32;
        }
    }
}
