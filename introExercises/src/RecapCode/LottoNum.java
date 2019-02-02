package RecapCode;
// Git code: 4c70

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LottoNum {
    public static void main(String[] args) {
        lotto();
    }

    //Incomplete, must make lottoNums distinct: use Helper or maybe a Set collection
    public static void lotto(){
        Random generator = new Random();
        final int TOTAL_NUMS = 49;
        final int TOTAL_BALLS = 7;
        List<Integer> lottoNums = new ArrayList<>();
        Integer num = generator.nextInt(TOTAL_NUMS) + 1;
        for (int i = 1; i < TOTAL_BALLS; i++) {
            while (lottoNums.contains(num)) {
                num = generator.nextInt(TOTAL_NUMS) + 1;
            }
            lottoNums.add(num);
            System.out.println("Number " + i + " : " + num);
        }

        //Bonus Num
        while (lottoNums.contains(num)) {
            num = generator.nextInt(TOTAL_NUMS) + 1;
        }
        System.out.println("Bonus Number: " + num);


    }
}
