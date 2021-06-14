package this_is_coding_test.ch12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LuckyStraight {
    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./src/this_is_coding_test/ch12/input.txt"));
        String input = br.readLine();
        int mid = input.length() / 2;

        int front = 0;
        for (int i = 0; i < mid; i++) {
            front += input.charAt(i) - 48;
        }
        int rear = 0;
        for (int i = mid; i < input.length(); i++) {
            rear += input.charAt(i) - 48;
        }

        if (front == rear) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }

    public static void main(String[] args) throws IOException {
        LuckyStraight ls = new LuckyStraight();
        ls.doit();
    }
}
