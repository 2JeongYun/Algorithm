package baekjoon.sort;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class WordSort {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        final int N = Integer.valueOf(br.readLine());
        String words[] = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, (Comparator<String>) (o1, o2) -> {
            if (o1.length() < o2.length())
                return -1;
            else if (o1.length() == o2.length())
                return o1.compareTo(o2);
            else
                return 1;
        });

        sb.append(words[0]).append("\n");
        for (int i = 1; i < words.length; i++) {
            if (words[i].equals(words[i - 1]))
                continue;
            sb.append(words[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
