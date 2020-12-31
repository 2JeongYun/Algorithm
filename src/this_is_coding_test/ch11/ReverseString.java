package this_is_coding_test.ch11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class ReverseString {
    public void doit() {
        BufferedReader br = new BufferedReader(new FileReader(".\\src\\this_is_coding_test\\ch11\\input.txt"));
        StringTokenizer st;
        String line;
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        rs.doit();
    }
}
