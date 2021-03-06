package models;

import java.util.Random;

public class model_5_36 {

    // Два игрока условились, что выигрыш получит тот,
    // кто выиграет определенное число партий.
    // Игра была прервана, когда первому игроку осталось
    // до выигрыша m, а второму n партий.
    // Как разделить ставку, если вероятность выигрыша партии
    // для каждого из игроков равна половине?
    // (Задача де Мере)

    private static Random random = new Random();

    // Осуществляем 50% вероятность выигрыша партии
    private static Boolean newDigit () { return random.nextBoolean(); }

    public static int main() {
        int numOfCalc = 1000000;
        int numOfGames = 5;
        int m; // Сколько партий осталось первому игроку до выигрыша первоначально
        int n; // Сколько партий осталось второму игроку до выигрыша первоначально
        int mWon; // Сколько из оставшихся партий выиграл первый игрок
        int nWon; // Сколько из оставшихся партий выиграл второй игрок
        int mLeft; // Сколько партий осталось первому игроку до выигрыша
        int nLeft; // Сколько партий осталось второму игроку до выигрыша

        System.out.println("Допустим, что игроки условились, что выигрыш получит тот, " +
                "кто выиграет " + numOfGames + " партий.\n");

        // Проверяем все возможные комбинации того, сколько партий осталось первому и второму игрокам
        // из определенного количества введенных партий
        for (int gameM = 1; gameM <= numOfGames; gameM++) {
            for (int gameN = 1; gameN <= numOfGames; gameN++) {
                m = gameM;
                n = gameN;
                mWon = 0;
                nWon = 0;

                System.out.println("Количество партий, которое осталось первому игроку до выигрыша = " + m +
                        "\nКоличество партий, которое осталось второму игроку до выигрыша = " + n);

                // Проводим определенное количество испытаний и узнаем, кто выиграет оставшиеся партии по итогу
                for (int i = 0; i < numOfCalc; i++) {
                    mLeft = m;
                    nLeft = n;
                    // Пока один из игроков не выиграет оставшиеся партии
                    while (mLeft != 0 && nLeft != 0) {
                        if (newDigit()) {
                            mLeft--;
                        } else {
                            nLeft--;
                        }
                    }
                    if (nLeft == 0) {
                        nWon++;
                    } else {
                        mWon++;
                    }
                }
                // Делим ставку в соответствии с вероятностью выиграть оставшиеся партии,
                // если вероятность выиграть одну партию равна 50%
                System.out.println("Ставку нужно разделить так:\n" +
                        "Первый игрок получает " + (double) mWon / numOfCalc * 100 + "%\n" +
                        "Второй игрок получает " + (double) nWon / numOfCalc * 100 + "%\n");
            }
        }
        return 0;
    }
}