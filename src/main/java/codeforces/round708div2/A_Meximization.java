package codeforces.round708div2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A_Meximization {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            solve(br, bw);
        }

        br.close();
        bw.close();
    }

    public void solve(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        ArrayList<Integer> remains = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int min = -1, sum = 0;
        boolean end = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min + 1) {
                min = arr[i];
            } else if (arr[i] == min) {
                remains.add(arr[i]);
                arr[i] = -1;
            } else if (arr[i] > min + 1) {
                break;
            }
        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != -1) {
                result.add(arr[j]);
            }
        }
        result.addAll(remains);

        for (int i = 0; i < arr.length; i++) {
            bw.write(result.get(i) + " ");
        }
        bw.newLine();
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        A_Meximization p = new A_Meximization();
        p.solution();
    }
}
