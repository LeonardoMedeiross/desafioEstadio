package org.example;

import java.util.Scanner;

public class Fibonacci {
    // Função para verificar se o número pertence à sequência de Fibonacci
    public static boolean isFibonacci(int number) {
        int a = 0, b = 1, temp;

        // Caso o número seja 0 ou 1, ele já pertence à sequência
        if (number == a || number == b) {
            return true;
        }

        // Gera a sequência até encontrar um número maior ou igual ao informado
        while (b < number) {
            temp = b;
            b = a + b;
            a = temp;
        }

        // Verifica se o número informado é igual a algum valor da sequência
        return b == number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário para informar um número
        System.out.print("Informe um número para verificar se pertence à sequência de Fibonacci: ");
        int number = scanner.nextInt();

        // Verifica se o número pertence à sequência de Fibonacci
        if (isFibonacci(number)) {
            System.out.println("O número " + number + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + number + " NÃO pertence à sequência de Fibonacci.");
        }

        scanner.close();
    }
}
