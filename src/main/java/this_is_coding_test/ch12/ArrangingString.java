package this_is_coding_test.ch12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class ArrangingString {
    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./src/this_is_coding_test/ch12/input.txt"));
        String input = br.readLine();
        PriorityQueue<Integer> alpha = new PriorityQueue<>();
        PriorityQueue<Integer> number = new PriorityQueue<>();

        for (int i = 0; i < input.length(); i++) {
            int cur = input.charAt(i);
            if (cur < 'A') {
                number.add(cur);
            } else {
                alpha.add(cur);
            }
        }

        while (!alpha.isEmpty()) {
            char ch = (char) (int) alpha.poll();
            System.out.printf("%c", ch);
        }
        while (!number.isEmpty()) {
            char ch = (char) (int) number.poll();
            System.out.printf("%c", ch);
        }
    }

    public static void main(String[] args) throws IOException {
        ArrangingString as = new ArrangingString();
        as.doit();
    }
}
