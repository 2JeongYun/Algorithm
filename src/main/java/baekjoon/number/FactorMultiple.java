package baekjoon.number;

import java.io.*;
import java.util.StringTokenizer;

public class FactorMultiple {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        String line;
        while (!(line = br.readLine()).startsWith("0 0")) {
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            if (a % b == 0)
                bw.write("multiple\n");
            else if (b % a == 0)
                bw.write("factor\n");
            else
                bw.write("neither\n");
        }
    }

    public static void main(String[] args) throws IOException {
        FactorMultiple sol = new FactorMultiple();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
