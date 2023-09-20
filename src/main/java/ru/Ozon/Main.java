package ru.Ozon;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
class Sequences {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in);){
            System.out.println("Введите имя последовательности(a-j): ");
            String seq = scanner.next();
            System.out.println("Введите количество элементов последовательности: ");
            Integer n = scanner.nextInt();
        } catch (Exception exception){
            System.out.println("Что-то пошло не так (((");
        }

        interface SequenceGenerator {
            /**
             * Выводит в консоль n первых членов последовательности A
             *
             * @param n число членов последовательности для вывода
             */
            void a(int n);

            /**
             * Выводит в консоль n первых членов последовательности B
             *
             * @param n число членов последовательности для вывода
             */
            void b(int n);

            /**
             * Выводит в консоль n первых членов последовательности C
             *
             * @param n число членов последовательности для вывода
             */
            void c(int n);

            /**
             * Выводит в консоль n первых членов последовательности D
             *
             * @param n число членов последовательности для вывода
             */
            void d(int n);

            /**
             * Выводит в консоль n первых членов последовательности E
             *
             * @param n число членов последовательности для вывода
             */
            void e(int n);

            /**
             * Выводит в консоль n первых членов последовательности F
             *
             * @param n число членов последовательности для вывода
             */
            void f(int n);

            /**
             * Выводит в консоль n первых членов последовательности G
             *
             * @param n число членов последовательности для вывода
             */
            void g(int n);

            /**
             * Выводит в консоль n первых членов последовательности H
             *
             * @param n число членов последовательности для вывода
             */
            void h(int n);

            /**
             * Выводит в консоль n первых членов последовательности I
             *
             * @param n число членов последовательности для вывода
             */
            void i(int n);

            /**
             * Выводит в консоль n первых членов последовательности J
             *
             * @param n число членов последовательности для вывода
             */
            void j(int n);
        }
    }
}

class Test {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            // System.out.println("Введите имя последовательности(a-j): ");
            // String seq = scanner.next();
            System.out.println("Введите количество элементов последовательности: ");
            int n = scanner.nextInt();
        } catch (Exception exception) {
            System.out.println("Что-то пошло не так (((");
        }
        // A
        System.out.print("A. ");
        for (int i = 1; i <= 9; i++) {  // 9-> n
            System.out.print(2 * i + " ");
        }

        // B
        System.out.println();
        System.out.print("B. ");
        int[] result = IntStream.range(1, 30)
                .filter(i -> i % 2 != 0)
                .limit(9)  // n
                .toArray();
        for (int i = 0; i < 9; i++) {  // 9-> n
            System.out.print(result[i] + " ");
        }

        // C
        System.out.println();
        System.out.print("C. ");
        int[] resultC = IntStream.range(3, 30)
                .filter(i -> i % 2 != 0)
                .limit(9)  // n - 1
                .toArray();
        int el = 1;
        System.out.print(el + " ");
        for (int i = 1; i < 9; i++) {
            el = el + resultC[i-1];
            System.out.print(el+ " ");
        }

        // D
        System.out.println();
        System.out.print("D. ");
        for (int i = 1; i <= 9; i++) {
            System.out.print((int)Math.pow(i, 3) + " ");
        }

        // E
        System.out.println();
        System.out.print("E. ");
        int ele = 1;
        System.out.print(ele + " ");
        for (int i = 1; i < 9; i++) {
            ele = ele + ((int)Math.pow(-1, i))*2;
            System.out.print(ele + " ");
        }

        // F
        System.out.println();
        System.out.print("F. ");
        for (int i = 1; i <= 9; i++) {
            if ( i % 2 == 0 ) {
                System.out.print("-" + i+ " ");
            } else {
                System.out.print(i + " ");
            }
        }
        // G
        System.out.println();
        System.out.print("G. ");
        int[] resultG = IntStream.range(3, 30)
                .filter(i -> i % 2 != 0)
                .limit(9)  // n - 1
                .toArray();
        int elg = 1;
        System.out.print(elg + " ");
        for (int i = 1; i < 9; i++) {
            elg = elg + resultG[i - 1];
            if (i % 2 != 0) {
                System.out.print("-" + elg + " ");
            } else {
                System.out.print(elg + " ");
            }
        }
        // H проверить не более п элментов в посл-ти !!!! из-за парного нуля...
        System.out.println();
        System.out.print("H. ");
        for (int i = 1; i <= 9; i++) {
            if (i % 2 != 0) {
            System.out.print(i + " 0 ");
            } else {
                continue;
            }
        }
        //I
        System.out.println();
        System.out.print("I. ");
        int[] resultI = IntStream.range(1, 30)
                .limit(9)  // n - 1
                .toArray();
        int eli = 1;
        for (int i = 0; i <9; i++) {
            if (i == 0) {
                eli = 1;
            } else {
             eli = eli * resultI[i];
            }
            System.out.print(eli + " ");
        }
        //J числа Фибоначчи
        System.out.println();
        System.out.print("J. ");
        int [] fibnum = new int[30];
        fibnum[0] = 1;
        fibnum[1] = 1;
        for (int i = 2; i < 30; i++) {
            fibnum[i] = fibnum[i-2] + fibnum[i-1];
        }
        for (int i = 0; i < 9; i++) {
            System.out.print(fibnum[i] + " ");
        }

    }
}