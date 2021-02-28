package models;

import java.util.Random;

public class model_8_36 {

    // Сколько чисел необходимо взять из таблицы случайных чисел,
    // чтобы с наибольшей вероятностью обеспечивалось появление
    // среди них трех чисел, оканчивающихся цифрой 7?

    private static Random random = new Random();

    // Так как нас интересует лишь последняя цифра,
    // будем искать случайное число в диапазоне от 0 до 9
    private static int newDigit () { return random.nextInt(10); }

    public static int main() {

        int numOfCalc = 1000000; // Количество измерений
        int numOfSteps = 1000; // Количество шагов
        int count; // Количество найденных 7
        int step = 0;  // Количество шагов
        int k; // Предел на шаги

        for (int i = 10; i < numOfSteps; i++) {
            step = 0;
            for (int j = 0; j < numOfCalc; j++) {
                count = 0;
                k = 0;
                while (count != 3 && k != i) {
                    step++;
                    k++;
                    if (newDigit() == 7) count++;
                }
                if (count != 3) step -= k;
            }
            System.out.println("Предел на шаги = " + i +
                    "; Количество шагов, за которые находились три семерки = " + (double) step / numOfCalc
                    + "; Вероятность = " + (double) step / numOfCalc / numOfSteps);
        }

        System.out.println("\nКоличество шагов, которое необходимо проделать,\n" +
                "чтобы среди них с наибольшей вероятностью находились 3 числа, оканчивающиеся на 7 =\n" +
                (double) step / numOfCalc + "\nКоличество шагов, полученное аналитическим путем = " + 29);

        return 0;
    }
}