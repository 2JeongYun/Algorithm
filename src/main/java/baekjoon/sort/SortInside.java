package baekjoon.sort;

import java.io.*;

public class SortInside {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        int[] countArr = new int[10];
        for (int i = 0; i < input.length(); i++)
            countArr[input.charAt(i) - '0']++;

        for (int i = countArr.length - 1; i >= 0; i--) {
            for (int j = 0; j < countArr[i]; j++)
                sb.append(i);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
