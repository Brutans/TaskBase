package org.example.task6.Filter63;

import java.util.Arrays;

import static org.example.task6.Filter63.BaseFilter.Main.filter;

public class Ex63 {
    public static void main(String[] args){
        String[] array =
                new String[]{null, "asjdp21", "q123", "1", null, "2", null, "qwa"};
        System.out.println(Arrays.toString(array));

        String[] newArray =  (String[]) filter(array, new BaseFilter.Filter() {

            public boolean apply(Object o) {
                return o != null;
            }
        });
        System.out.println(Arrays.toString(newArray));
    }


}
