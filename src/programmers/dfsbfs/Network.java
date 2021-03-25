package programmers.dfsbfs;

import static programmers.Util.*;

import java.io.IOException;
import java.util.*;

public class Network {

    public int solution(int n, int[][] computers) {
        boolean[] isConnected = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (isConnected[i] == false) {
                connect(isConnected, computers, i);
                ans++;
            }
        }
        return ans;
    }

    public void connect(boolean[] isConnected, int[][] computers, int current) {
        isConnected[current] = true;
        for (int i = 0; i < computers[current].length; i++) {
            if (computers[current][i] == 1 && isConnected[i] == false) {
                connect(isConnected, computers, i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Network p = new Network();

        int t = 1;
        t = getTestCaseCount();

        for (int i = 0; i < t; i++) {
            /*
             * Type var = getTypeArr[]
             * Type ...
             * ...
             * print(p.solution());
             */
            int n = getInt();
            int[][] computers = new int[n][];
            for (int j = 0; j < n; j++) {
                computers[j] = getIntArray();
            }
            print(p.solution(n, computers));
        }
    }
}
