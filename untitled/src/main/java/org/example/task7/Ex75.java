package org.example.task7;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Ex75 {
    public static class FlatIterator implements Iterator<String> {
        private Iterator<?> currentIterator;
        private String nextString;

        public FlatIterator(Iterator<?> iterator) {
            currentIterator = iterator;
            moveToNextString();
        }

        @Override
        public boolean hasNext() {
            return nextString != null;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String currentString = nextString;
            moveToNextString();
            return currentString;
        }

        private void moveToNextString() {
            nextString = null;
            while (currentIterator != null) {
                if (currentIterator.hasNext()) {
                    Object next = currentIterator.next();
                    if (next instanceof String) {
                        nextString = (String) next;
                        break;
                    } else if (next instanceof Iterator) {
                        currentIterator = (Iterator<?>) next;
                    }
                } else {
                    currentIterator = null;
                }
            }
        }
    }
    public static void main(String[] args){
        Iterator<Object> nestedIterator = Arrays.asList("A", "B", Arrays.asList("C", "D"), "E").iterator();

        // Создаем "плоский" итератор поверх вложенного
        FlatIterator flatIterator = new FlatIterator(nestedIterator);
        // Проверяем работу "плоского" итератора
        while (flatIterator.hasNext()) {
            System.out.println(flatIterator.next());
        }
    }
}
