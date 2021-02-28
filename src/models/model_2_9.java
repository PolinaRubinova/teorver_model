package models;

import java.util.Random;

public class model_2_9 {

    // 2.9. На десяти одинаковых карточках написаны различные
    // числа от нуля до десяти. Определить вероятность того,
    // что наудачу образованное с помощью данных карточек:
    // а) двузначное число делится на 18;
    // б) трехзначное число делится на 36.

    private static Random random = new Random();

    private static int a;
    private static int b;

    // Расчитываем случайное двузначное число
    private static int twoDigitNumber() {
        a =  random.nextInt(10);
        do {
            b = random.nextInt(10);
        } while (a == b); // Проверяем, чтобы не были одинаковыми
        return 10 * a + b;
    }

    // Расчитываем случайное трехзначное число
    private static int treeDigitNumber() {
        a =  random.nextInt(10);
        do {
            b = random.nextInt(10);
        } while (a == b); // Проверяем, чтобы не были одинаковыми

        int c;
        do {
            c = random.nextInt(10);
        } while (a == c || b == c); // Проверяем, чтобы не были одинаковыми
        return 100 * a + 10 * b + c;
    }

    public static int main() {

        int digA = 18;
        int digB = 36;
        int counterOfCoolA = 0;
        int counterOfCoolB = 0;
        int numOfCalc = 1000000;

        for (int i = 0; i < numOfCalc; i++) {
            // Если остаток от деления на числа 18 и 36 соответсвенно
            // равен нулю, то счетчик количества подходящих чисел увеличивается
            if (twoDigitNumber() % digA == 0) counterOfCoolA++;
            if (treeDigitNumber() % digB == 0) counterOfCoolB++;
        }

        double resultA = (double) counterOfCoolA / (double) numOfCalc;
        double anResA = 1.0 / 18.0;
        System.out.println("а) Двузначное:");
        System.out.println("Количество чисел, полученных случайным образом, которые делятся на 18 = " +
                counterOfCoolA);
        System.out.println("Количество всех полученных чисел = " + numOfCalc);
        System.out.println("Вероятность = " + resultA);
        System.out.println("Вероятность, полученная аналитическим путем = 1/18 = 0,0(5)");
        System.out.println("Разность вероятностей, полученных различными путями = " +
                String.format("%.5f", (Math.abs(anResA - resultA))));
        System.out.println();

        double resultB = (double) counterOfCoolB / (double) numOfCalc;
        double anResB = 11.0 / 360.0;
        System.out.println("б) Трехзначное:");
        System.out.println("Количество чисел, полученных случайным образом, которые делятся на 36 = " +
                counterOfCoolB);
        System.out.println("Количество всех полученных чисел = " + numOfCalc);
        System.out.println("Вероятность = " + resultB);
        System.out.println("Вероятность, полученная аналитическим путем = 11/360 = 0,030(5)");
        System.out.println("Разность вероятностей, полученных различными путями = " +
                String.format("%.5f", (Math.abs(anResB - resultB))));

        return 0;
    }
}