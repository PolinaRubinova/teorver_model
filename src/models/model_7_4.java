package models;

import java.util.Arrays;
import java.util.Random;

public class model_7_4 {

    // Из партии в пять изделий наудачу взято одно изделие, оказавшееся
    // бракованным. Количество бракованных изделий равновозможно любое.
    // Какое предположение о количестве бракованных изделий наиболее вероятно?

    private static int n = 5; // Количество изделий
    private static Random random = new Random();

    private static int newDigit () { return random.nextInt(n); }

    public static int main() {
        int numOfCalc = 1000000;
        int count = 0; // Количество наудачу взятых бракованных изделий
        boolean[] Mass = new boolean[n]; // "Партия" в 5 изделий
        double p = 1.0 / n; // Так как количество бракованных изделий равновероятно любое
        double PA = 0.0; // Полная вероятность
        double[] PH = new double[n];

        // Заполняем массив в соответствии с количеством бракованных изделий и высчитываем вероятность вытащить из него бракованное
        for (int i = 0; i < n; i++) {
            Arrays.fill(Mass, false);
            for (int j = 0; j < n - i; j++) Mass[j] = true;
            for (int k = 0; k < numOfCalc; k++) if (Mass[newDigit()]) count++;
            PH[i] = (double) count / numOfCalc;
            count = 0;
        }
        for (int i = 0; i < n; i++) PA += PH[i] * p; // Рассчитываем полную вероятность P(A)

        System.out.println("Вероятность вытащить бракованное изделие при условии, что в партии из 5 изделий бракованными являются все"
                + "\n" + "P(A/H6) = " + PH[0] + "\n" +
                "Вероятность вытащить бракованное изделие при условии, что в партии из 5 изделий бракованными являются 4"
                + "\n" + "P(A/H5) = " + PH[1] + "\n" +
                "Вероятность вытащить бракованное изделие при условии, что в партии из 5 изделий бракованными являются 3"
                + "\n" + "P(A/H4) = " + PH[2] + "\n" +
                "Вероятность вытащить бракованное изделие при условии, что в партии из 5 изделий бракованными являются 2"
                + "\n" + "P(A/H3) = " + PH[3] + "\n" +
                "Вероятность вытащить бракованное изделие при условии, что в партии из 5 изделий бракованным является 1"
                + "\n" + "P(A/H2) = " + PH[4] + "\n" +
                "Вероятность вытащить бракованное изделие при условии, что в партии из 5 изделий нет бракованных изделий"
                + "\n" + "P(A/H1) = 0" + "\n\n" +
                "Полная вероятность взять бракованное изделие"
                + "\n" + "P(A) = " + PA + "\n\n" +
                "Вероятность того, что в партии из 5 изделий бракованными являются все, при условии, что мы вытащили бракованное"
                + "\n" + "P(H1/A) = "  + PH[0] * p / PA  + "\n" +
                "Вероятность того, что в партии из 5 изделий бракованными являются 4, при условии, что мы вытащили бракованное"
                + "\n" + "P(H2/A) = " + PH[1] * p / PA + "\n" +
                "Вероятность того, что в партии из 5 изделий бракованными являются 3, при условии, что мы вытащили бракованное"
                + "\n" + "P(H3/A) = " + PH[2] * p / PA + "\n" +
                "Вероятность того, что в партии из 5 изделий бракованными являются 2, при условии, что мы вытащили бракованное"
                + "\n" + "P(H4/A) = " + PH[3] * p / PA + "\n" +
                "Вероятность того, что в партии из 5 изделий бракованными являются 1, при условии, что мы вытащили бракованное"
                + "\n" + "P(H5/A) = " + PH[4] * p / PA + "\n" +
                "Вероятность того, что в партии из 5 изделий нет бракованных, при условии, что мы вытащили бракованное"
                + "\n" + "P(H6/A) = 0" + "\n\n" +
                "Таким образом, наиболее ероятно предположение о том, что все изделия являются бракованными");

        return 0;
    }
}