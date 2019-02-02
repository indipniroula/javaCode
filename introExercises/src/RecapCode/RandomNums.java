package RecapCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNums {

    public static void main(String[] args) {
        ranFunc(3);
    }

    public static void ranFunc(int x) {
        Random generator = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            list.add(i);
        }

        System.out.println("Generating random numbers: ");
        int num;
        int counter = 0;
        while (!list.isEmpty()){
            num = generator.nextInt(x);
            if (list.contains((num))) {
                list.remove(Integer.valueOf(num));
            }
            System.out.print(num + " ");
            counter++;
        }

        System.out.println("had to print " + counter + " times.");




    }
}
