package this_is_coding_test.ch11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ReverseString {
    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(".\\src\\this_is_coding_test\\ch11\\input.txt"));
        StringTokenizer st;
        String line;

        line = br.readLine();
        int lineSize = line.length();
        int prev = line.charAt(0) - 48;
        int oneCnt = 0;
        int zeroCnt = 0;
        for (int i = 1; i < lineSize; i++) {
            int num = line.charAt(i) - 48;
            if (prev != num) {
                if (oneCnt == 0 && zeroCnt == 0) {
                    oneCnt = 1;
                    zeroCnt = 1;
                } else {
                    if (num == 1) {
                        zeroCnt++;
                    } else {
                        oneCnt++;
                    }
                }
            }
            prev = num;
        }
        System.out.println(Integer.min(zeroCnt, oneCnt));
    }

    public static void main(String[] args) throws IOException {
        ReverseString rs = new ReverseString();
        rs.doit();
    }
}
