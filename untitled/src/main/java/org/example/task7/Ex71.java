package org.example.task7;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class Ex71 {
    public static <T> Collection<T> removeDuplicate(Collection<T> collection){
        return new HashSet<>(collection);
    }


    public static void main(String[] args){
        ArrayList<String> people = new ArrayList<String>();
        people.add("Tom");
        people.add("Kate");
        people.add("Alice");
        people.add("Kate");
        people.add("Sam");
        people.add("Tom");
        System.out.println(people);
        System.out.println(removeDuplicate(people));
    }

}
