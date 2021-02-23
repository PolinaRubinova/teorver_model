import java.util.Random;

class model_10_21 {

    // Любой из 300 абонентов независимо друг от друга звонит на коммутатор.
    // Какова вероятность того, что от них поступит в течение часа четыре
    // вызова, если вероятность ввызова для каждого абонента равна 0.01.

    private static Random random = new Random();

    // Вероятность вызова для каждого абонента в течение часа = 0.01
    // Так что просто сравниваем случайное число из 100 с 1
    private static int newDigit () { return random.nextInt(100); }

    static int main() {
        int numOfCalc = 1000000; // Количество испытаний
        int numOfSubs = 300; // Количество абонентов
        int countOfCalls = 0; // Количество поступивших звонков
        int fourCalls = 0; // Количество испытаний, в которых поступило ровно 4 звонка

        for (int i = 0; i < numOfCalc; i++) {
            for (int j = 0; j < numOfSubs; j++) {
                if (newDigit() == 1) countOfCalls++;
            }
            if (countOfCalls == 4) fourCalls++;
            countOfCalls = 0;
        }

        System.out.println("Вероятность того, что от абонентов поступит в течение часа четыре вызова  = "
                + (double) fourCalls / numOfCalc);
        System.out.println("Вероятность, найденная анаитическим путем  = 0.17");
        System.out.println("Развость вероятностей, найденных различными путями  = "
                + Math.abs(0.17 - (double) fourCalls / numOfCalc));

        return 0;
    }
}