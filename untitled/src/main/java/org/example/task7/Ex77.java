package org.example.task7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Ex77 {
    public static <K> Map<K, Integer> countInMass(K[] ks){
        Map<K, Integer> map = new HashMap<>();
        for (K k:ks){
            map.compute(k, new BiFunction<K, Integer, Integer>() {
                public Integer apply(K k, Integer integer) {
                    return integer == null ? 1 : integer+1;
                }
            });

        }
        return map;
    }


    public static void main(String[] args){
        String[] words = List.of("Один", "Два", "Три", "Четыре", "Восемь","Два","Четыре","Два").toArray(new String[0]);
        List<Integer> values = List.of(1, 2, 1, 2, 1, 5, 4, 2);
        System.out.println(countInMass(words));
        System.out.println(countInMass(values.toArray()));
    }
}
