package models;

import java.util.Random;

public class model_11_13 {

    // Вероятность того, что отказ прибора произойдет при числе
    // неработоспособных элементов X = m равна:

    // а) для прибора А
    // P(X = m) = 1 - e ^ (-am)
    // (a > 0; m = 0, 1, 2, ...);

    // б) для прибора B
    // P(X = m) =
    // = 0, при m = 0;
    // = 1 - e ^ (-a(m - 1)), при m = 1, 2, 3, ...

    // Найти математическое ожидание числа неработоспособных
    // элементов, приводящих к отказам каждого из приборов.

    private static Random random = new Random();

    private static int newDigit () { return random.nextInt(10); }


    public static int main() {







        return 0;
    }
}
