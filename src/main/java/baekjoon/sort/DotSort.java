package baekjoon.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DotSort {

    class Dot implements Comparable<Dot> {
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Dot o) {
            if (this.x < o.x) {
                return -1;
            } else if (this.x == o.x) {
                if (this.y < o.y)
                    return -1;
                else
                    return 1;
            } else {
                return 1;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        final int N = Integer.valueOf(br.readLine());
        Dot[] dots = new Dot[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dots[i] = new Dot(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
        }

        Arrays.sort(dots);

        for (int i = 0; i < dots.length; i++)
            sb.append(String.format("%d %d\n", dots[i].x, dots[i].y));
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        DotSort d = new DotSort();
        d.solution();
    }
}
