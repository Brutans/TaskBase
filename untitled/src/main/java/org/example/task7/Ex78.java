package org.example.task7;
import java.util.*;
import java.util.stream.Collectors;

public class Ex78 {

    public static <K, V> Map<V, List<K>> swapKeysAndValues(Map<K, V> inputMap) {
        if (inputMap == null) {
            return Collections.emptyMap();
        }

        return inputMap.entrySet()
                .stream()
                .collect(Collectors.groupingBy(entry -> entry.getValue(),
                        Collectors.mapping(entry -> entry.getKey(), Collectors.toList())));
    }

    public static void main(String[] args) {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("Один", 1);
        inputMap.put("Два", 2);
        inputMap.put("Три", 3);
        inputMap.put("ЕщёТри", 3);

        Map<Integer, List<String>> result = swapKeysAndValues(inputMap);

        result.forEach((key, values) -> {
            System.out.println(key + ": " + values);
        });
    }
}