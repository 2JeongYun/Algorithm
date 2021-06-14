package this_is_coding_test.ch11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ImpossiblePrice {
    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./src/this_is_coding_test/ch11/input.txt"));
        StringTokenizer st;
        String line;
        int maxNum = 0;

        int coinSize = Integer.parseInt(br.readLine());
        int[] coins = new int[coinSize];
        line = br.readLine();
        st = new StringTokenizer(line);
        for (int i = 0; i < coinSize; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coins);
        int curNum = 0;
        while (curNum < coinSize && !(maxNum + 1 < coins[curNum])) {
            maxNum += coins[curNum];
            curNum++;
        }

        System.out.println(maxNum + 1);
    }

    public static void main(String[] args) throws IOException {
        ImpossiblePrice ip = new ImpossiblePrice();
        ip.doit();
    }
}
