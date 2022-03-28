package opu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Task32();
        System.out.println("----------------------------------------------------");
        //Task57();
        System.out.println("----------------------------------------------------");
        //Task_82();
        System.out.println("----------------------------------------------------");
        //Task_107();
        System.out.println("----------------------------------------------------");
        //Task_132();
    }

    /**
     * Задание
     * Дано вещественное число x. Вычислить (x-1)(x-3)(x-5)...(x-63)/(x-2)(x-4)(x-6)...(x-64)
     */
    public static void Task32() {
        float x;
        float element_up = 0;
        double dobutok_up = 1;
        float element_down = 0;
        double dobutok_down = 1;
        System.out.println("Дано вещественное число x. Вычислить (x-1)(x-3)(x-5)...(x-63)/(x-2)(x-4)(x-6)...(x-64) .Enter X: ");

        /**
         * Перевірка на коректність написання
         */
        do {
            Scanner in = new Scanner(System.in);
            if (!in.hasNextFloat()) {
                System.out.println("Enter correct: ");
            } else {
                x = in.nextFloat();
                break;
            }
        } while (true);

        for (int i = 1; i <= 64; i = i+2){
            element_up = x - i;
            dobutok_up = element_up * dobutok_up;
            element_down = x - (i-1+2);
            dobutok_down = element_down * dobutok_down;
        }
        double result = dobutok_up / dobutok_down;
        System.out.println("Result: " + result);
    }


    /**
     * Задание
     * Вычислить сумму 1-1/2+1/3-1/4... . Условную инструкцию и операцию возведения в степень не использовать.
     */
    public static void Task57() {
        System.out.println("Вычислить сумму 1-1/2+1/3-1/4... . Условную инструкцию и операцию возведения в степень не использовать.Enter X: ");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int stepin = (number + 1);
        int sign = -1;
        float answer;
        float sum = 0;

        for (int i = 1; i <= number ; i++) {
            sign = sign * -1;
            answer = sign * (1f / i);
            System.out.println(answer);
            sum = answer + sum;
        }
        System.out.println("Answer: " + sum);
    }


    /**
     * Задание
     * Даны натуральное число n и вещественные числа а1, a2, …, аn. Определить сумму этих чисел.
     */
    public static void Task_82() {
        int count_elements;
        float first_element;
        float second_element;

        System.out.println("Даны натуральное число n и вещественные числа а1, a2, …, аn. Определить сумму этих чисел.Enter a count of elements(nature number): ");
        do {
            Scanner count = new Scanner(System.in);
            if (!count.hasNextInt()) {
                System.out.println("Enter correct number: ");
            } else {
                count_elements = count.nextInt();
                break;
            }
        } while (true);

        System.out.println("Enter a first element(real number): ");
        do {
            Scanner first = new Scanner(System.in);
            if (!first.hasNextFloat()) {
                System.out.println("Enter correct number: ");
            } else {
                first_element = first.nextFloat();
                break;
            }
        } while (true);

        System.out.println("Enter a second element(real number): ");
        do {
            Scanner second = new Scanner(System.in);
            if (!second.hasNextFloat()) {
                System.out.println("Enter correct number: ");
            } else {
                second_element = second.nextFloat();
                break;
            }
        } while (true);

        float difference = second_element - first_element;
        float sum_elements = 0;
        float one_element = 0;
        for (int i = 0; i < count_elements; i++) {
            one_element = one_element + difference;
            sum_elements = one_element + sum_elements;
        }
        System.out.println("Sum all elements: " + sum_elements);

    }


    /**
     * Задание
     * У гусей и кроликов вместе 64 лапы. Сколько может быть кроликов и гусей (указать все сочетания)?
     */
    public static void Task_107() {
        int rabbits = 4;
        int geese = 2;
        System.out.println("У гусей и кроликов вместе 64 лапы. Сколько может быть кроликов и гусей (указать все сочетания)?");
        for (int i = 0; i < 16; i++) {
            for (int gi = 0; gi < 32; gi++) {
                if (rabbits + geese == 64) {
                    int count_rabbits = rabbits / 4;
                    int count_geese = geese / 2;
                    System.out.println("Rabbits: " + count_rabbits + System.lineSeparator() + "Geese: " + count_geese);
                    System.out.println("================================");
                }
                geese = geese + 2;
            }
            rabbits = rabbits + 4;
            geese = 2;
        }
    }


    /**
     * Задание
     * Знайти числа сума яких дорівнює числу в разів 10 менше ніж добуток цих чисел.
     */
    public static void Task_132() {
        System.out.println("Знайти числа сума яких дорівнює числу в разів 10 менше ніж добуток цих чисел. Такими числами є: ");
        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                if (a * b == (a + b) * 10) {
                    System.out.println(a + " i " + b + ".");
                }
            }
        }
    }
}