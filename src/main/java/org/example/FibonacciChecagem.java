package org.example;

import java.util.Scanner;

public class FibonacciChecagem {
    public static boolean Fibonacci(int number) {
        int a = 0, b = 1, temp;

        if (number == a || number == b) {
            return true;
        }

        while (b < number) {
            temp = b;
            b = a + b;
            a = temp;
        }

        return b == number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe um número para verificar se pertence à sequência de Fibonacci: ");
        int number = scanner.nextInt();

        if (Fibonacci(number)) {
            System.out.println("O número " + number + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + number + " NÃO pertence à sequência de Fibonacci.");
        }

        scanner.close();
    }
}
