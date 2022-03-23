package opu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Task32();
        System.out.println("----------------------------------------------------");
        Task57();
        System.out.println("----------------------------------------------------");
        Task_82();
        System.out.println("----------------------------------------------------");
        Task_107();
        System.out.println("----------------------------------------------------");
        Task_132();
    }

    public static void Task_107(){
        /** Задание
         *  У гусей и кроликов вместе 64 лапы. Сколько может быть кроликов и гусей (указать все сочетания)?
         */
        int[] rabbits = new int[16];
        int[] geese = new int[32];
        System.out.println("У гусей и кроликов вместе 64 лапы. Сколько может быть кроликов и гусей (указать все сочетания)?");
        for (int i = 1; i <16; i++){
            rabbits[0] = 4;
            rabbits[i] = rabbits[i - 1] + 4;
        }
        for (int i = 1; i <32; i++){
            geese[0] = 2;
            geese[i] = geese[i - 1] + 2;
        }
        for (int i = 0; i <16; i++) {
            for (int gi = 0; gi < 32; gi++) {
                if (rabbits[i] + geese[gi] == 64) {
                    int count_rabbits = rabbits[i] / 4;
                    int count_geese = geese[gi] / 2;
                    System.out.println("Rabbits: " + count_rabbits + System.lineSeparator() + "Geese: " + count_geese);
                    System.out.println("================================");
                }
            }
        }
    }
    public static void Task_132(){
        /** Задание
         * Знайти числа сума яких дорівнює числу в 10 менше ніж добуток цих чисел.
         */
        System.out.println("Знайти числа сума яких дорівнює числу в 10 менше ніж добуток цих чисел. Такими числами є: ");
        for (int a = 1; a < 100; a++){
            for (int b = 1; b < 100; b++){
                if ( a * b == ( a + b ) * 10){
                    System.out.println(a + " i " + b + ".");
                }
            }
        }
    }
    public static void Task_82(){
        /** Задание
         * Даны натуральное число n и вещественные числа а1, a2, …, аn. Определить сумму этих чисел.
         */
        int count_elements;
        float first_element;
        float second_element;

        System.out.println("Даны натуральное число n и вещественные числа а1, a2, …, аn. Определить сумму этих чисел.Enter a count of elements(nature number): ");
        do {
            Scanner count = new Scanner(System.in);
            boolean correct_bool = count.hasNextInt();
            if (!correct_bool) {
                System.out.println("Enter correct number: ");
            }else {
                count_elements = count.nextInt();
                break;
            }
        }while (true);


        System.out.println("Enter a first element(real number): ");
        do {
            Scanner first = new Scanner(System.in);
            boolean correct_bool = first.hasNextFloat();
            if (!correct_bool) {
                System.out.println("Enter correct number: ");
            }else {
                first_element = first.nextFloat();
                break;
            }
        }while (true);

        System.out.println("Enter a second element(real number): ");
        do {
            Scanner second = new Scanner(System.in);
            boolean correct_bool = second.hasNextFloat();
            if (!correct_bool) {
                System.out.println("Enter correct number: ");
            }else {
                second_element = second.nextFloat();
                break;
            }
        }while (true);

        float[] elements = new float[count_elements];
        elements[0] = first_element;
        elements[1] = second_element;
        float difference = second_element - first_element;
        for (int i = 2; i < count_elements; i++){
            float one_element = elements[i-1] + difference;
            elements[i] = one_element;
        }
        float sum_elements = first_element + second_element;
        for (int i = 2; i < count_elements; i++){
            sum_elements = sum_elements + elements[i];
        }
        System.out.println("Sum all elements: " + sum_elements);

    }
    public static void Task32(){
        /**Задание
         * Дано вещественное число x. Вычислить (x-1)(x-3)(x-5).../(x-2)(x-4)(x-6)...
         */
        float x;
        float[] up_line_deff = new float[32];
        float[] down_line_deff = new float[32];
        int odd = 1;
        int even = 2;
        double product_up = 1;
        double product_down = 1;
        System.out.println("Дано вещественное число x. Вычислить (x-1)(x-3)(x-5).../(x-2)(x-4)(x-6)... .Enter X: ");
        /**
         * Перевірка нна коректність написання
         */
        do{
            Scanner in = new Scanner(System.in);
            if(!in.hasNextFloat()){
                System.out.println("Enter correct: ");
            }else{
                x = in.nextFloat();
                break;
            }
        }while (true);

        /**
         * Знайшов кожне значення у дужках чисельника
         */
        for (int i = 0; i < 32; i++){
            up_line_deff[i] = x - odd;
            odd = odd + 2;
        }
        /**
         * Знайшов кожне значення у дужках знаменника
         */
        for (int i = 0; i < 32; i++){
            down_line_deff[i] = x - even;
            even = even + 2;
        }
        /**
         * Знайшов добуток всіх дужок чисельника
         */
        for (int i = 0; i < 32; i++){
            product_up = up_line_deff[i] * product_up;
        }
        /**
         * Знайшов добуток всіх дужок знаменника
         */
        for (int i = 0; i<32; i++){
            product_up = down_line_deff[i] * product_down;
        }

        double result = product_up/product_down;
        System.out.println("Result: " + result);
    }
    public static void Task57(){
        /** Задание
         * Вычислить сумму 1-1/2+1/3-1/4... . Условную инструкцию и операцию возведения в степень не использовать.
         */
        System.out.println("Вычислить сумму 1-1/2+1/3-1/4... . Условную инструкцию и операцию возведения в степень не использовать.Enter X: ");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int stepin = (number+1);
        int sign = -1;
        float answer;
        float sum = 0;

        for (int i = 1; i<stepin; i++){
            sign = sign * -1;
            answer = sign*(1f/i);
            System.out.println(answer);
            sum = answer + sum;
        }
        System.out.println("Answer: " + sum);
    }
}