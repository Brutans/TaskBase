package org.example.task7;

import java.util.Iterator;
import java.util.List;

public class CombinedIterator76<T> implements Iterator<T> {

    private Iterator<T> iterator1;
    private Iterator<T> iterator2;
    private boolean useIterator1;

    public CombinedIterator76(Iterator<T> iterator1, Iterator<T> iterator2) {
        this.iterator1 = iterator1;
        this.iterator2 = iterator2;
        this.useIterator1 = true;
    }

    @Override
    public boolean hasNext() {
        return iterator1.hasNext() || iterator2.hasNext();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            return null;
        }

        if (useIterator1 && iterator1.hasNext()) {
            useIterator1 = false;
            return iterator1.next();
        } else {
            useIterator1 = true;
            return iterator2.next();
        }
    }


    public static void main(String[] args) {
        Iterator<Integer> iterator1 = List.of(1, 2, 3).iterator();
        Iterator<Integer> iterator2 = List.of(4, 5, 6).iterator();
        CombinedIterator76<Integer> combinedIterator76 = new CombinedIterator76<>(iterator1, iterator2);
        while (combinedIterator76.hasNext()) {
            System.out.println(combinedIterator76.next());
        }
    }
}