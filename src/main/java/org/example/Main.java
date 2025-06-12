package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj ziarno:");
        int seed = scanner.nextInt();

        System.out.println("Podaj ilosc przedmiotow:");
        int n = scanner.nextInt();

        Problem problem = new Problem(n, seed);
        System.out.println(problem);

        System.out.println("Podaj pojemnosc:");
        int capacity = scanner.nextInt();

        Problem.Result result = problem.solve(capacity);
        System.out.println(result);

    }
}