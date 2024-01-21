package org.example.task6.Fill64;
import java.util.function.Function;
public class BaseFill {
    public static <T> void fill(T[] array, Function<Integer, Integer> function) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (T) function.apply(i);
        }
        for (T value : array) {
            System.out.print(value + ", ");
        }
    }
}
