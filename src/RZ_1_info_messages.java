import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

class RZ_1_info_messages {

    private static HashMap<String, String> Alphabet = new HashMap<>() {{
        put("0000000", "0");
        put("0000001", "1");
        put("0000010", "2");
        put("0000011", "3");
        put("0000100", "4");
        put("0000101", "5");
        put("0000110", "6");
        put("0000111", "7");
        put("0001000", "8");
        put("0001001", "9");
        put("0001010", "А");
        put("0001011", "Б");
        put("0001100", "В");
        put("0001101", "Г");
        put("0001110", "Д");
        put("0001111", "Е");
        put("0010000", "Ё");
        put("0010001", "Ж");
        put("0010010", "З");
        put("0010011", "И");
        put("0010100", "Й");
        put("0010101", "К");
        put("0010110", "Л");
        put("0010111", "М");
        put("0011000", "Н");
        put("0011001", "О");
        put("0011010", "П");
        put("0011011", "Р");
        put("0011100", "С");
        put("0011101", "Т");
        put("0011110", "У");
        put("0011111", "Ф");
        put("0100000", "Х");
        put("0100001", "Ц");
        put("0100010", "Ч");
        put("0100011", "Ш");
        put("0100100", "Щ");
        put("0100101", "Ь");
        put("0100110", "Ы");
        put("0100111", "Ъ");
        put("0101000", "Э");
        put("0101001", "Ю");
        put("0101010", "Я");
        put("0101011", "а");
        put("0101100", "б");
        put("0101101", "в");
        put("0101110", "г");
        put("0101111", "д");
        put("0110000", "е");
        put("0110001", "ё");
        put("0110010", "ж");
        put("0110011", "з");
        put("0110100", "и");
        put("0110101", "й");
        put("0110110", "к");
        put("0110111", "л");
        put("0111000", "м");
        put("0111001", "н");
        put("0111010", "о");
        put("0111011", "п");
        put("0111100", "р");
        put("0111101", "с");
        put("0111110", "т");
        put("0111111", "у");
        put("1000000", "ф");
        put("1000001", "х");
        put("1000010", "ц");
        put("1000011", "ч");
        put("1000100", "ш");
        put("1000101", "щ");
        put("1000110", "ь");
        put("1000111", "ы");
        put("1001000", "ъ");
        put("1001001", "э");
        put("1001010", "ю");
        put("1001011", "я");
        put("1001100", ".");
        put("1001101", ",");
        put("1001110", "!");
        put("1001111", ":");
        put("1010000", "?");
        put("1010001", "-");
        put("1010010", "_");
        put("1010011", "№");
        put("1010100", "(");
        put("1010101", ")");
        put("1010110", " ");
    }};

    private static String[] messages = new String[] {
            "resources/RZ_1__info_messages/01.txt",
            "resources/RZ_1__info_messages/02.txt",
            "resources/RZ_1__info_messages/03.txt",
            "resources/RZ_1__info_messages/04.txt",
            "resources/RZ_1__info_messages/05.txt",
            "resources/RZ_1__info_messages/06.txt",
            "resources/RZ_1__info_messages/07.txt",
            "resources/RZ_1__info_messages/08.txt",
            "resources/RZ_1__info_messages/09.txt",
            "resources/RZ_1__info_messages/10.txt",
            "resources/RZ_1__info_messages/11.txt",
            "resources/RZ_1__info_messages/12.txt",
            "resources/RZ_1__info_messages/13.txt",
            "resources/RZ_1__info_messages/14.txt",
            "resources/RZ_1__info_messages/15.txt",
            "resources/RZ_1__info_messages/16.txt",
            "resources/RZ_1__info_messages/17.txt",
            "resources/RZ_1__info_messages/18.txt",
            "resources/RZ_1__info_messages/19.txt",
            "resources/RZ_1__info_messages/20.txt",
    };

    private static Random random = new Random();

    static int ex1() throws IOException {

        FileWriter writer = new FileWriter("resources/RZ_1__info_messages/output1.txt");

        int ch;
        int count = 1000;
        StringBuilder word = new StringBuilder();
        StringBuilder wordRes = new StringBuilder();
        StringBuilder message = new StringBuilder();
        FileReader reader;

        for (int n = 0; n < messages.length; n++) {
            reader = new FileReader(messages[n]);
            while ((ch = reader.read()) != -1) {
                do {
                    word.append((char) ch);
                } while ((char) (ch = reader.read()) != ' ' && ch != -1);

                wordRes.append(word);
                while (Alphabet.get(wordRes.toString()) == null && count != 0) {
                    wordRes.delete(0, wordRes.length());
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == '-') {
                            if (random.nextBoolean()) {
                                wordRes.append(0);
                            } else wordRes.append(1);
                        } else wordRes.append(word.charAt(i));
                    }
                    count--;
                }

                message.append(Alphabet.get(wordRes.toString()));
                word.delete(0, word.length());
                count = 1000;
            }
            System.out.println((n + 1) + " " + message + "\n");
            message.delete(0, message.length());
        }

        writer.close();
        return 0;
    }





    static int ex2() {

        return 0;
    }
}
