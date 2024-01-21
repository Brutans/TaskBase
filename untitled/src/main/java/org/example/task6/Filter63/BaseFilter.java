package org.example.task6.Filter63;
import java.util.Arrays;

public class BaseFilter {
    interface Filter{
        boolean apply(Object o);
    }
    static class Main{
        public static Object[] filter(Object[] array, Filter filter){
            int offset = 0;

            for(int i = 0; i<array.length; i++){
                if(filter.apply(array[i])){
                    array[i - offset] = array[i];
                } else{
                    offset++;
                }
            }
            return Arrays.copyOf(array, array.length - offset);

        }
    }
}
