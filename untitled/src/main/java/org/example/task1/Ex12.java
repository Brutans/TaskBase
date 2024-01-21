package org.example.task1;

public class Ex12 {
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            boolean signal = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    signal = false;
                    break;
                }
            }
            if (signal) {
                System.out.println(i);
            }
        }
    }
}
