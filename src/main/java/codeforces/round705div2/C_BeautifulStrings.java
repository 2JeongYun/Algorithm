package codeforces.round705div2;

import java.io.*;
import java.util.StringTokenizer;

public class C_BeautifulStrings {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            solve(br, bw);
        }
    }

    public void solve(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        String origin = br.readLine();

        if (n % k != 0) {
            bw.write("-1\n");
            bw.flush();
            return;
        }

        //바뀌는 위치 찾기
        int[] cnt = new int[26];
        char[] s = origin.toCharArray();
        int availCnt = n / k;
        int inValidIdx = -1;
        for (int i = 0; i < s.length; i++) {
            int cur = s[i] - 'a';
            if (cnt[cur] == 0) {
                cnt[cur]++;
                availCnt--;
            } else {
                cnt[cur]++;
                if (cnt[cur] == k) {
                    cnt[cur] = 0;
                }
            }
            if (availCnt < 0) {
                inValidIdx = i;
                break;
            }
        }

        if (inValidIdx == -1) {
            bw.write(origin);
            bw.newLine();
            bw.flush();
            return;
        }

        if (replace(s, inValidIdx, k)) {
            String ans = makeString(s, inValidIdx, k);
            bw.write(ans);
            bw.newLine();
            bw.flush();
            return;
        }

        s[inValidIdx] = origin.charAt(inValidIdx);
        for (int i = inValidIdx - 1; i >= 0; i--) {
            if (replace(s, i, k)) {
                String ans = makeString(s, i, k);
                bw.write(ans);
                bw.newLine();
                bw.flush();
                return;
            }
            s[inValidIdx] = origin.charAt(inValidIdx);
        }
    }

    public String makeString(char[] s, int inValidIdx, int k) {
        StringBuffer ret = new StringBuffer(new String(s).substring(0, inValidIdx + 1));
        int[] cnt = new int[26];
        for (int i = 0; i < ret.length(); i++) {
            cnt[ret.charAt(i) - 'a']++;
        }
        StringBuffer endString = new StringBuffer();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                while (!(cnt[i] % k == 0)) {
                    cnt[i]++;
                    endString.append((char) (i + 'a'));
                }
            }
        }
        int remain = s.length - ret.length() - endString.length();
        StringBuffer midString = new StringBuffer();
        for (int i = 0; i < remain; i++) {
            midString.append('a');
        }
        return ret.append(midString).append(endString).toString();
    }

    public boolean replace(char[] s, int inValidIdx, int k) {
        for (int ch = s[inValidIdx] + 1; ch <= 'z'; ch++) {
            s[inValidIdx] = (char) ch;
            if (isValid(s, inValidIdx, k)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValid(char[] s, int end, int k) {
        int[] cnt = new int[26];
        int availCnt = s.length / k;
        for (int i = 0; i <= end; i++) {
            int ch = s[i] - 'a';
            if (cnt[ch] == 0) {
                cnt[ch]++;
                availCnt--;
            } else {
                cnt[ch]++;
                if (cnt[ch] == k) {
                    cnt[ch] = 0;
                }
            }
            if (availCnt < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        C_BeautifulStrings c = new C_BeautifulStrings();
        c.solution();
    }
}
