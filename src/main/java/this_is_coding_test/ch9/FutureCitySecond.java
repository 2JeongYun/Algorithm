package this_is_coding_test.ch9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FutureCitySecond {
    int[][] weight;
    int vSize, eSize, checkPoint, destination;

    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        line = br.readLine();
        st = new StringTokenizer(line);
        vSize = Integer.parseInt(st.nextToken());
        eSize = Integer.parseInt(st.nextToken());

        weight = new int[vSize + 1][vSize + 1];
        for (int i = 0; i < vSize + 1; i++) {
            Arrays.fill(weight[i], Integer.MAX_VALUE);
            weight[i][i] = 0;
        }

        for (int i = 0; i < eSize; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            weight[a][b] = 1;
            weight[b][a] = 1;
        }

        line = br.readLine();
        st = new StringTokenizer(line);
        destination = Integer.parseInt(st.nextToken());
        checkPoint = Integer.parseInt(st.nextToken());

        for (int i = 1; i < vSize + 1; i++) {
            routing(i);
        }

        if (weight[1][checkPoint] == Integer.MAX_VALUE
                || weight[checkPoint][destination] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(weight[1][checkPoint] + weight[checkPoint][destination]);
        }
    }

    private void routing(int node) {
        for (int i = 1; i < vSize + 1; i++) {
            int weight1 = weight[i][node];
            for (int j = 1; j < vSize + 1; j++) {
                int weight2 = weight[node][j];
                int weight3 = weight1 + weight2;
                if (weight3 > 0 && weight3 < weight[i][j]) {
                    weight[i][j] = weight3;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FutureCitySecond fs = new FutureCitySecond();
        fs.doit();
    }
}
