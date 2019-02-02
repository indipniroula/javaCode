package RecapCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseInputQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Deque<String> stringDeque = new ArrayDeque<>();

        while (!line.equals("")) {
            stringDeque.push(line);
            line = br.readLine();
        }

        while (!stringDeque.isEmpty()) {
            System.out.print(stringDeque.pop());
        }
    }
}
