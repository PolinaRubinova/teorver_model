package models;

import java.util.Random;

public class model_3_11 {

    // На отрезке l независимо одна от другой поставлены две точки,
    // положение каждой из которых равновозможно на этом отрезке.
    // Определить вероятность того, что из трех получившихся
    // частей одного отрезка можно построить треугольник.

    private static Random random = new Random();

    private static double newDigit () { return random.nextDouble(); }

    public static int main() {

        double l = 1.0;
        double a;
        double b;
        double length1;
        double length2;
        double length3;
        int numOfCalc = 1000000;
        int numOfCool = 0;

        for (int i = 0; i < numOfCalc; i++) {
            // Генерируем независимые точки
            a = newDigit();
            b = newDigit();

            // Вычисляем длину отрезков
            length1 = Math.min(a, b);
            length2 = l - Math.max(a, b);
            length3 = Math.max(a, b) - length1;

            // Для определения вероятности воспользуемся правилом:
            // Из трех отрезков можно составить треугольник тогда и только тогда,
            // когда сумма длин меньших из них больше длины большего.
            if (((length1 + length2) > length3)
                    & ((length3 + length2) > length1)
                    & ((length1 + length3) > length2)) {
                numOfCool++;
            }
        }

        System.out.println("Количество подходящих точек, полученных случайным образом = " + numOfCool);
        System.out.println("Количество всех полученных точек = " + numOfCalc);
        System.out.println("Вероятность = " + (double) numOfCool / numOfCalc);
        System.out.println("Вероятность, полученная аналитическим путем = 0.25");
        System.out.println("Разность вероятностей, полученных различными путями = " +
                Math.abs(((double) numOfCool / numOfCalc - 0.25)));

        return 0;
    }
}

