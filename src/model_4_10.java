import java.util.Random;

class model_4_10 {

    // Определить вероятность того, что написанная
    // наудачу простая дробь несократима (задача Чебышева).

    // Считать, что числитель и знаменатель - независимые
    // наудачу выбранные числа, каждое из которых с
    // вероятностью 1/N совпадает с любым из чисел
    // 1, 2, ... , N и устремить N к бесконечности.

    private static Random random = new Random();

    private static int newDigit () {
        // Устремляем N в "бесконечность"
        return random.nextInt(1000000);
    }

    static int main() {
        int numOfCalc = 1000000; // Количество вычислений
        int result = 0; // Количество сократимых дробей

        for (int i = 0; i < numOfCalc; i++){
            // Генерируем два независимых числа
            int a = newDigit();
            int b = newDigit();

            if (a % 2 == 0 && b % 2 == 0) {
                result ++; // Исключаем все четные числа - ускоряем вычисления
            } else {
                for (int j = 3; j < Math.min(a, b); j += 2) {
                    if (a % j == 0 && b % j == 0) {
                        result++;
                        break;
                    }
                }
            }
        }

        System.out.println("Количество всех наудачу обазованных дробей = " + numOfCalc);
        System.out.println("Количество сократимых дробей = " + result);
        System.out.println("Вероятность того, что наудачу образованная дробь несократима = "
                + (1 -(double) result / numOfCalc));
        System.out.println("Вероятность, полученная аналитически = 0.608");
        System.out.println("Разность вероятностей, полученных различными путями = " +
                Math.abs(((1 - (double) result / numOfCalc) - 0.608)));

        return 0;
    }
}

