package org.example.task7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Ex72 {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList();

        long addTimeArrayList = addTime(arrayList);
        long addTimeLinkedList = addTime(linkedList);

        System.out.println("Время для добавления 1000000 элементов:");
        System.out.println("ArrayList: " + addTimeArrayList + " мс");
        System.out.println("LinkedList: " + addTimeLinkedList + " мс");

        long getRandomTimeArrayList = getRandomTime(arrayList);
        long getRandomTimeLinkedList = getRandomTime(linkedList);

        System.out.println("\nВремя для получения 1000000 элементов:");
        System.out.println("ArrayList: " + getRandomTimeArrayList + " мс");
        System.out.println("LinkedList: " + getRandomTimeLinkedList + " мс");
    }

    private static long addTime(List<Integer> list) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long getRandomTime(List<Integer> list) {
        Random random = new Random();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            int randomIndex = random.nextInt(list.size());
            list.get(randomIndex);
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
/*
        Время для добавления 1000000 элементов:
        ArrayList: 18 мс
        LinkedList: 205 мс

        Время для получения 1000000 элементов:
        ArrayList: 10 мс
        LinkedList: 110309 мс
*/

/*
AMD Ryzen 3600
16GB RAM
 */

/*
 */
/*      Cлучайный доступ к элементам в ArrayList выполняется за O(1),
        так как он использует массив и может прямо указать на нужный индекс.
        В то время как в LinkedList это выполняется за O(n),
        так как приходится итерироваться от начала или конца списка до нужного индекса.*/

