package org.example.task7;

import java.util.Arrays;
import java.util.Iterator;

public class Ex74 {
    public static class TwoArrayIterator<T> implements Iterator<T> {

        private final T[][] array;
        private int rowIndex, colIndex;

        public TwoArrayIterator(T[][] array) {
            this.array = array;
            this.rowIndex = 0;
            this.colIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return rowIndex < array.length && colIndex < array[rowIndex].length;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("No more elements in the 2D array.");
            }

            T element = array[rowIndex][colIndex++];
            if (colIndex >= array[rowIndex].length) {
                colIndex = 0;
                rowIndex++;
            }

            return element;
        }
    }


    public static void main(String[] args){
/*        Integer[][] twoArrayInt = {{15,16,17,18},{20,21,22,23},{31,32,33,34}};
        String[][] twoArrayStr ={{"Shla","Sasha"},{"Po","Sosse"},{"And","Lick","Bread"}};

        Iterator<Integer[]> iteratorInt = Arrays.stream(twoArrayInt).iterator();
        while (iteratorInt.hasNext()){
            System.out.println(Arrays.toString(iteratorInt.next()));
        }
        Iterator<String[]> iteratorStr = Arrays.stream(twoArrayStr).iterator();
        while (iteratorStr.hasNext()){
            System.out.println(Arrays.toString(iteratorStr.next()));
        }*/
        Integer[][] twoDArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Integer[][] twoArrayInt = {{15, 16, 17, 18},{20, 21, 22, 23},{31, 32, 33, 34}};
        String[][] twoArrayStr ={{"Shla","Sasha"},{"Po","Sosse"},{"And","Lick","Bread"}};

        TwoArrayIterator<Integer> arrayIteratorInt = new TwoArrayIterator<>(twoArrayInt);

        while (arrayIteratorInt.hasNext()) {
            System.out.println(arrayIteratorInt.next());
        }
        TwoArrayIterator<String> arrayIteratorStr = new TwoArrayIterator<>(twoArrayStr);
        while (arrayIteratorStr.hasNext()){
            System.out.println(arrayIteratorStr.next());
        }

    }
}
