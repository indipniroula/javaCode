package RecapCode;
//Git Code: f79b


public class PalindromeCubes {

    public static void main(String[] args) {
        palindromeCube();

    }

    public static void palindromeCube() {
        int n = 0;
        int cube;
        while (n <= 2000) {
            cube = n * n * n;
            if (isPalindrome2(String.valueOf(cube))) {
                System.out.println(n + " cubed is " + cube);
            }
            n++;
        }
    }

    private static boolean isPalindrome(int str) {
        String a = String.valueOf(str);
        String reverse = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            reverse += a.charAt(i);
        }
        return (a.equals(reverse));
        //Don't use == to check reference types. - ('Pointers' etc.)
    }

    //isPalindrome2 - a little more elegant and better
    private  static boolean isPalindrome2(String str){

        if (str.length() == 0 || str.length() == 1){
            return true;
        }

        return str.charAt(0) == str.charAt(str.length() - 1) && isPalindrome2(str.substring(1, str.length() - 1));
    }
    //isPalindrome2 - compare first and last elements of string and recursively check if palindrome using substring
    //substring(startIndex, endIndex) start - inclusive, end - exclusive.
}
