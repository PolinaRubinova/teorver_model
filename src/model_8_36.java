import java.util.Random;

class model_8_36 {

    // Сколько чисел необходимо взять из таблицы случайных чисел,
    // чтобы с наибольшей вероятностью обеспечивалось появление
    // среди них трех чисел, оканчивающихся цифрой 7?

    private static Random random = new Random();

    // Так как нас интересует лишь последняя цифра,
    // будем искать случайное число в диапазоне от 0 до 9
    private static int newDigit () { return random.nextInt(10); }

    static int main() {

        int numOfCalc = 1000000; // Количество измерений
        int count; // Количество найденных 7
        int step = 0;  // Количество шагов

        for (int i = 0; i < numOfCalc; i++) {
            count = 0;
            while (count != 3) {
                // Мы считаем все шаги, которые мы сделали, пока искали 7
                step++;
                if (newDigit() == 7) count++;
            }
        }

        System.out.println("Количество шагов, которое необходимо проделать,\n" +
                "чтобы среди них с наибольшей вероятностью находились 3 числа, оканчивающиеся на 7 =\n" +
                (double) step / numOfCalc);
        System.out.println("Количество шагов, полученное аналитическим путем = " + 29);
        return 0;
    }
}