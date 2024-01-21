package org.example.task6.Fill64;
import static org.example.task6.Fill64.BaseFill.fill;

public class Ex64 {
    public static void main(String[] args){

            Integer[] squares = new Integer[100];
            fill(squares, integer -> integer * integer);
    }
}
