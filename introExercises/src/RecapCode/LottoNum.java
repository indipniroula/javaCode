package RecapCode;
// Git code: 4c70

import java.util.Arrays;
import java.util.Random;

public class LottoNum {
    public static void main(String[] args) {
        lotto();
    }

    public static void lotto(){
        Random generator = new Random();
        final int TOTAL_NUMS = 49;
        int[] lottoNums = new int[7];
        for (int i = 0; i < lottoNums.length; i++) {
            lottoNums[i] = generator.nextInt(TOTAL_NUMS);
        }

        System.out.println(Arrays.toString(lottoNums));

    }
}
