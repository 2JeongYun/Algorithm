package this_is_coding_test.ch11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class PlusMulti {
    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(".\\src\\this_is_coding_test\\ch11\\input.txt"));
        StringTokenizer st;
        String line;
        int lineSize;

        line = br.readLine();
        lineSize = line.length();
        int total = line.charAt(0) - 48;
        for (int i = 1; i < lineSize; i++) {
            int num = line.charAt(i) - 48;
            if (total > 1 && num > 1) {
                total = total * num;
            } else {
                total = total + num;
            }
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws IOException {
        PlusMulti pm = new PlusMulti();
        pm.doit();
    }
}
