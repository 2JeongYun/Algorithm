package this_is_coding_test.ch13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FindingCity {
    int n, m, k, x;
    ArrayList<Integer>[] graph;
    Queue<Integer> que;
    int[] dist;
    boolean[] visit;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./src/this_is_coding_test/ch13/input.txt"));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        que = new LinkedList<>();
        visit = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE - 600000);
        dist[x] = 0;
        que.add(x);
        daijstra();

        boolean check = false;
        for (int i = 1; i < n + 1; i++) {
            if (dist[i] == k) {
                check = true;
                System.out.println(i);
            }
        }
        if (!check) {
            System.out.println(-1);
        }
    }

    public void daijstra() {
        if (que.isEmpty()) {
            return;
        }

        int cur = que.poll();
        if (visit[cur]) {
            daijstra();
        }
        visit[cur] = true;

        for (int next : graph[cur]) {
            if (!visit[next]) {
                que.add(next);
            }
            if (dist[next] > dist[cur] + 1) {
                dist[next] = dist[cur] + 1;
            }
        }

        daijstra();
    }

    public static void main(String[] args) throws IOException {
        FindingCity f = new FindingCity();
        f.solution();
    }
}
