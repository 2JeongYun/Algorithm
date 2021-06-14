package this_is_coding_test.ch11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BallChoice {
    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./src/this_is_coding_test/ch11/input.txt"));
        StringTokenizer st;
        String line;

        st = new StringTokenizer(br.readLine());
        int ballCnt = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());
        int[] weightCnt = new int[maxWeight + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < ballCnt; i++) {
            int weight = Integer.parseInt(st.nextToken());
            weightCnt[weight]++;
        }

        int result = 0;
        for (int i = 1; i < maxWeight + 1; i++) {
            int others = 0;
            for (int j = i + 1; j < maxWeight + 1; j++) {
                others += weightCnt[j];
            }
            result += others * weightCnt[i];
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BallChoice bc = new BallChoice();
        bc.doit();
    }
}
