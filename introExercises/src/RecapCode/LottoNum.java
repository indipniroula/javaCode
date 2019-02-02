package RecapCode;
// Git code: 4c70

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoNum {
    public static void main(String[] args) {
        lotto();
    }

    public static void lotto() {
        Random generator = new Random();
        final int TOTAL_NUMS = 49;
        final int NUMBER_OF_NUMBERS = 7;
        List<Integer> lottoNums = new ArrayList<>();
        Integer num = generator.nextInt(TOTAL_NUMS) + 1;

        for (int i = 1; i <= NUMBER_OF_NUMBERS; i++) {
            while (lottoNums.contains(num)) {
                num = generator.nextInt(TOTAL_NUMS) + 1;
            }
            lottoNums.add(num);
            if (i < NUMBER_OF_NUMBERS) {
                System.out.println("Number " + i + " : " + num);
            } else {
                System.out.println("Bonus Number: " + num);
            }

        }
    }
}
