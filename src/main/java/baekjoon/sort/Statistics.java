package baekjoon.sort;

import java.io.*;
import java.util.ArrayList;

public class Statistics {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.valueOf(br.readLine());
        int[] countArr = new int[8001];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int cur = Integer.valueOf(br.readLine());
            countArr[cur + 4000]++;
            sum += cur;
        }

        double average = (double) sum / N;

        int median = 0;
        int count = 0;
        for (int i = 0; i < countArr.length; i++) {
            count += countArr[i];
            if (count > N / 2) {
                median = i - 4000;
                break;
            }
        }

        ArrayList<Integer> modes = new ArrayList<>();
        int mode;
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] >= maxCount) {
                if (countArr[i] > maxCount)
                    modes.clear();
                modes.add(i);
                maxCount = countArr[i];
            }
        }
        mode = modes.size() >= 2 ? modes.get(1) : modes.get(0);
        mode -= 4000;

        int range;
        int min = -1, max = 8001;
        while (countArr[++min] == 0);
        while (countArr[--max] == 0);
        range = max - min;

        bw.write(String.format("%.0f\n%d\n%d\n%d", average, median, mode, range));
        bw.flush();
        bw.close();
        br.close();
    }
}
