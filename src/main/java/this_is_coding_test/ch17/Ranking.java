package this_is_coding_test.ch17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
플루이드 워셜 알고리즘을 사용하여 더 간단하게 풀 수 있다.
아래의 코드는 플루이드 워셜 알고리즘을 생각하기 전에 짠 것으로
코드는 복잡하지만 시간 복잡도는 같은 O(n^3)이다.
 */

public class Ranking {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./src/this_is_coding_test/ch17/input.txt"));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int TC = 0; TC < T; TC++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Node[] students = new Node[N];
            for (int i = 0; i < N; i++) {
                students[i] = new Node(i);
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int down = Integer.parseInt(st.nextToken()) - 1;
                int up = Integer.parseInt(st.nextToken()) - 1;
                students[up].lowerNodes.add(students[down]);
                students[down].upperNodes.add(students[up]);
            }

            int ans = 0;
            for (int no = 0; no < N; no++) {
                int aboveCnt = students[no].computeAboveNodesCount(students[no], new boolean[N]) - 1;
                int belowCnt = students[no].computeBelowNodesCount(students[no], new boolean[N]) - 1;
                if (aboveCnt + belowCnt == N - 1) {
                    ans++;
                }
            }

            br.readLine();
            System.out.println(ans);
        }
        br.close();
    }

    class Node {
        int no;
        List<Node> upperNodes = new LinkedList<>();
        List<Node> lowerNodes = new LinkedList<>();

        Node(int no) {
            this.no = no;
        }

        public int computeAboveNodesCount(Node node, boolean[] visit) {
            if (visit[node.no]) {
                return 0;
            } else {
                visit[node.no] = true;
            }

            if (node.upperNodes.isEmpty()) {
                return 1;
            }

            int ret = 1;
            for (Node next : node.upperNodes) {
                ret += computeAboveNodesCount(next, visit);
            }
            return ret;
        }

        public int computeBelowNodesCount(Node node, boolean[] visit) {
            if (visit[node.no]) {
                return 0;
            } else {
                visit[node.no] = true;
            }

            if (node.lowerNodes.isEmpty()) {
                return 1;
            }

            int ret = 1;
            for (Node next : node.lowerNodes) {
                ret += computeBelowNodesCount(next, visit);
            }
            return ret;
        }
    }

    public static void main(String[] args) throws IOException {
        Ranking r = new Ranking();
        r.solution();
    }
}
