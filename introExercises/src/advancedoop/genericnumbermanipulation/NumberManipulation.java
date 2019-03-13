package advancedoop.genericnumbermanipulation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumberManipulation {
    public static <T extends Number> Set<T> readNumbers(int n, NumberParser<T> parser) throws IOException {
        String message = "Please enter a " + parser.typeParsed() + " :";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Set<T> result = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            System.out.println(message);
            result.add(parser.parseNumber(bufferedReader.readLine()));
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readNumbers(10, new DoubleParser()));

    }
}
