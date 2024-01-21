package org.example.task7;

import java.util.HashMap;
import java.util.Map;

public class Ex70 {
    public static void main(String[] args){
        String text = "Шла Саша по шоссе и сосала сушку. Саша пошла домой без сушки по шоссе.";

        // Создаем частотный словарь
        Map<String, Integer> frequencyMap = new HashMap<>();

        // Разбиваем текст на слова и обновляем частотный словарь
        String[] words = text.split("\\s+");  // Разбиваем текст на слова
        for (String word : words) {
            String cleanWord = word.replaceAll("[^а-яА-Я]", "").toLowerCase();  // Удаляем знаки препинания и приводим к нижнему регистру
            if (!cleanWord.isEmpty()) {
                frequencyMap.put(cleanWord, frequencyMap.getOrDefault(cleanWord, 0) + 1);  // Обновляем частотный словарь
            }
        }
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
