import java.util.Random;

class model_9_20 {

    // Определить вероятность того, что при бросании n игральных
    // костей (кубиков) сумма очков на верхних гранях будет:
    // а) равна заданному числу m;
    // б) не больше m.
    // Найти эти вероятности при n = 10, m = 20.

    private static Random random = new Random();

    // Будем искать случайное число в диапазоне от 1 до 6
    private static int newDigit () { return random.nextInt(6) + 1; }

    static int main() {
        int n = 10; // Количество кубиков
        int m = 20; // Сумма очков на верхних гранях

        int numOfCalc = 1000000; // Количество измерений
        int sum; // Сумма результатов подбрасывания
        int sumEqM = 0; // Количество сумм, равных m
        int sumLessOrEqM = 0; // Количество сумм, не больше m

        for (int i = 0; i < numOfCalc; i ++) {
            sum = 0;
            for (int j = 0; j < n; j++) sum += newDigit();

            if (sum == m) sumEqM++;
            if (sum <= m) sumLessOrEqM++;
        }

        System.out.println("Вероятность того, что сумма очков равна 20 = " +
                (double) sumEqM / numOfCalc);
        System.out.println("Вероятность того, что сумма очков не больше 20 = " +
                (double) sumLessOrEqM / numOfCalc);
        System.out.println();

        System.out.println("Вероятность того, что сумма очков равна 20, " +
                "полученная аналитически = 0.0014");
        System.out.println("Вероятность того, что сумма очков не больше 20, " +
                "полученная аналитически = 0.0029");
        System.out.println();

        System.out.println("Разность вероятностей того, что сумма очков равна 20, " +
                "полученных различными путями = " + Math.abs(0.0014 - (double) sumEqM / numOfCalc));
        System.out.println("Разность вероятностей того, что сумма очков не больше 20, " +
                "полученных различными путями = " + Math.abs(0.0029 - (double) sumLessOrEqM / numOfCalc));
        return 0;
    }
}
