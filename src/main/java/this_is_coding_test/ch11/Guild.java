package this_is_coding_test.ch11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Guild {
    int peopleCnt;
    int[] fear;

    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(".\\src\\this_is_coding_test\\ch11\\input.txt"));
        StringTokenizer st;
        String line;

        peopleCnt = Integer.parseInt(br.readLine());
        line = br.readLine();
        st = new StringTokenizer(line);
        fear = new int[peopleCnt];
        for (int i = 0; i < peopleCnt; i++) {
            fear[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(fear);
        int groupSize = 0;
        int groupCnt = 0;
        for (int i = 0; i < peopleCnt; i++) {
            groupSize++;
            if (fear[i] <= groupSize) {
                groupSize = 0;
                groupCnt++;
            }
        }

        System.out.println(groupCnt);
    }

    public static void main(String[] args) throws IOException {
        Guild g = new Guild();
        g.doit();
    }
}
