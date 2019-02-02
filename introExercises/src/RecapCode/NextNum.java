package RecapCode;
// Git code: 98e3

public class NextNum {

    public static void main(String[] args) {
        assert args.length == 1 : "Need one command-line argument";
        int parsedArgs = Integer.parseInt(args[0]);
        // args[0] will be a string number. e.g "1". parseInt will parse it to an integer.
        nextContinuous(parsedArgs);


    }


    public static int next(int x) {

        return ((x % 2) == 0) ? (x / 2) : (3 * x + 1);
        //Ternary operator: return ( (x % 2) == 0 ) ? (x/2) : (3 * x + 1);
    }

    public static void nextContinuous(int x) {
        assert x > 0 : "Positive numbers only";
        int num = x;
        System.out.print(num);
        while (num != 1) {
            num = next(num);
            System.out.print(" " + num);
        }

    }
}
