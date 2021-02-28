package models;

import java.util.Arrays;
import java.util.Random;

public class model_6_18 {

    // В одной из двух урн, в каждой из которых 10 шаров, один шар отмечен.
    // Играющий имеет право последовательно извлечь 20 шаров из
    // любой урны, каждый раз возвращая извлеченный шар обратно.
    // Как следует вести игру, чтобы вероятность извлечения
    // отмеченного шара была наибольшей, если вероятность того,
    // что отмеченный шар находится в первой урне, равна 2/3?
    // Чему равна эта вероятность?

    private static Random random = new Random();

    public static int main() {

        int[] first = new int[10];
        int[] second = new int[10];
        int ch; // Осуществляет вероятность 2 / 3 появления шара в первой урне
        int len = first.length + second.length;
        int[] result = new int[len];
        int[] finale = new int[len];

        // Количество вычислений для каждой стратегии ведения игры
        int numOfCalc = 10000;

        for (int i = 0; i < numOfCalc; i ++) {

            // Кладем помеченный шар в одну из корзин
            // Делаем так, чтобы вероятность появления помеченного
            // шара в первой корзине была 2 / 3
            ch = random.nextInt(3);
            if (ch == 0 || ch == 1) {
                first[random.nextInt(10)] = 1;
            } else {
                second[random.nextInt(10)] = 1;
            }

            for (int j = 0; j < len; j++) { // Для всех вариантов извлечения шаров из урн

                // Каждый из вариантов извлечения проверяем numOfCalc раз
                for (int n = 0; n < numOfCalc; n++) {
                    // Извлекаем из первой урны
                    for (int f = 0; f <= j; f++) {
                        if (first[random.nextInt(10)] == 1) {
                            result[j]++;
                            break;
                        }
                    }
                    // Извлекаем из второй урны
                    for (int s = j + 1; s < len; s++) {
                        if (second[random.nextInt(10)] == 1) {
                            result[j]++;
                            break;
                        }
                    }
                }
            }
            for (int j = 0; j < len; j ++) finale[j] += result[j];

            Arrays.fill(result, 0);
            Arrays.fill(first, 0);
            Arrays.fill(second, 0);
        }

        System.out.println("Все вероятности выигрыша при разных стратегиях:\n");
        for (int i = 0; i < len; i++) {
            System.out.println("Если " + (i + 1) + " раз вытащить шар из первой урны и " + (len - i - 1) +
                    " раз вытащить шар из второй урны =>\nВероятность выигрыша будет составлять " +
                    (double) finale[i] / (numOfCalc * numOfCalc) + "\n");
        }

        // Находим максимальный элемент массива, говорящий нам максимальную вероятность
        int maxInd = 0;
        for (int i = 0; i < len; i++) if (finale[maxInd] < finale[i]) maxInd = i;

        System.out.println("Чтобы вероятность извлечения отмеченного шара была наибольшей, игру следует вести так:" +
                "\nНеобходимо " + (maxInd + 1) + " раз вытащить шар из первой урны и " + (len - maxInd - 1) +
                " раз вытащить шар из второй урны\nТаким образом, вероятность выигрыша будет составлять " +
                (double) finale[maxInd] / (numOfCalc * numOfCalc) +
                "\nВероятность, полученная аналитическим путем, при извлечении шара из первой урны 13 раз = 0.67" +
                "\nРазность вероятностей, полученных различными путями = " +
                Math.abs(((double) finale[maxInd] / (numOfCalc * numOfCalc) - 0.67)));

        return 0;
    }
}