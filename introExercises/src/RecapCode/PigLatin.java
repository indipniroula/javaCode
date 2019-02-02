package RecapCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class PigLatin {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br.readLine();
        String str = "How are you on January 1st? I am fine, thanks.";
        String[] strs = str.split(" ");
        System.out.println(Arrays.deepToString(strs));
        //List<String> ls = Arrays.stream(strs).map(PigLatin::pigLatin).collect(Collectors.toList());



    }

    //Basic Principle:
    // Make a function that will pigLatin a single word - taking care of all edge cases (STUCK ON THIS RN)
    // Split you sentence, using .split. Split at spaces
    // Map the function to each word after splitting.
    // Rejoin the words using spaces.

    public static String pigLatin(String word) {
        List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        List<Character> Vowels = new ArrayList<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));
        char firstChar = word.charAt(0);
        char secondChar = word.charAt(1);
        char lastChar = word.charAt(word.length() - 1);
        String newWord;
        if(Character.isLetter(firstChar)){
            if (vowels.contains(firstChar) || Vowels.contains(firstChar)) {
                if (Character.isLetterOrDigit(lastChar)) {
                    return word + "way";
                } else {
                    return word.substring(0, word.length() - 1) + "way" + lastChar;
                }
            } else {
                if (word.length() == 1) {
                    return word + "ay";
                }
                if (Character.isLetterOrDigit(lastChar)) {
                    newWord = Character.toUpperCase(secondChar) + word.substring(2) + Character.toLowerCase(firstChar) + "ay";
                } else {
                    newWord = Character.toUpperCase(secondChar) + word.substring(2, word.length() - 1) + Character.toLowerCase(firstChar) + "ay";
                }
            }
        } else {
            newWord = word;
        }


       return newWord;
    }
}
