package RecapCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ReverseInput {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        List<String> lines = new ArrayList<>();
        while(!line.equals("")) {
            lines.add(line);
            line = br.readLine();
        }
        System.out.println(lines);
        System.out.println("Reversed");
        System.out.println(lines.stream().map(ReverseInput::reverse).collect(Collectors.toList()));



    }

    public static String reverse(String ls){
        String reversed = "";
        for(int i = ls.length() - 1; i >= 0; i--){
            reversed += ls.charAt(i);
        }
        return reversed;
    }
}
