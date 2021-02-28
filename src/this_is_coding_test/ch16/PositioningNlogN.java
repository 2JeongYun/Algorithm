package this_is_coding_test.ch16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class PositioningNlogN {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> atk = new ArrayList<>();
        ArrayList<Integer> lis = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            atk.add(Integer.parseInt(st.nextToken()));
        }
        Collections.reverse(atk);

        for (int i = 0; i < N; i++) {
            if (lis.isEmpty()) {
                lis.add(atk.get(i));
            } else if (atk.get(i) > lis.get(lis.size() - 1)) {
                lis.add(atk.get(i));
            } else {
                modifyLIS(lis, atk, 0, lis.size() - 1, atk.get(i));
            }
        }

        System.out.println(N - lis.size());
    }

    public void modifyLIS(ArrayList<Integer> lis, ArrayList<Integer> atk, int s, int e, int num) {
        if (s == e) {
            if (num < lis.get(s)) {
                lis.set(s, num);
            }
            return;
        }

        int mid = (s + e) / 2;
        if (lis.get(mid) == num) {
            return;
        } else if (lis.get(mid) < num) {
            modifyLIS(lis, atk, mid + 1, e, num);
        } else {
            modifyLIS(lis, atk, s, mid, num);
        }
    }

    public static void main(String[] args) throws IOException {
        PositioningNlogN p = new PositioningNlogN();
        p.solution();
    }
}
