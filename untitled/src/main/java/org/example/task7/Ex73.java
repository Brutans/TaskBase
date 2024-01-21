package org.example.task7;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex73 {

    public static class ArrayIterator<T> implements Iterator<T> {

        private final T[] array;
        private int currentIndex;

        public ArrayIterator(T[] array) {
            this.array = array;
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < array.length;
        }


        @Override
        public T next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("No more elements in the array.");
            }
            return array[currentIndex++];
        }
    }


        public static void main(String[] args){
/*        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Яблоко");
        fruits.add("Груша");
        fruits.add("Ананас");
        fruits.add("Персик");

        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
            String[] integerArray = {"Яблоко", "Груша", "Ананас", "Персик"};
            ArrayIterator<String> arrayIterator = new ArrayIterator<>(integerArray);

            while (arrayIterator.hasNext()) {
                System.out.println(arrayIterator.next());
            }
        }
}
