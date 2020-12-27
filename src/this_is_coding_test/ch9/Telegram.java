package this_is_coding_test.ch9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Telegram {
    int vSize, eSize, start;
    boolean visit[];
    ArrayList<Node>[] weights;
    PriorityQueue<Node> pQue;
    int[] distance;

    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(".\\src\\this_is_coding_test\\ch9\\input.txt"));
        StringTokenizer st;
        String line;

        line = br.readLine();
        st = new StringTokenizer(line);
        vSize = Integer.parseInt(st.nextToken());
        eSize = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        weights = new ArrayList[vSize + 1];
        for (int i = 0; i < vSize + 1; i++) {
            weights[i] = new ArrayList<>();
        }

        visit = new boolean[vSize + 1];
        Arrays.fill(visit, false);
        distance = new int[vSize + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pQue = new PriorityQueue<>();

        for (int i = 0; i < eSize; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            weights[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }
        pQue.add(new Node(start, 0));
        routing();

        int possible = -1;
        for (int i = 1; i < vSize + 1; i++) {
            if (visit[i]) {
                possible++;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < vSize + 1; i++) {
            if (distance[i] != Integer.MAX_VALUE) {
                max = Integer.max(max, distance[i]);
            }
        }
        System.out.println(possible + " " + max);
    }

    private void routing() {
        if (pQue.isEmpty()) {
            return;
        }

        Node curNode = pQue.poll();
        visit[curNode.number] = true;

        for (Node nextNode : weights[curNode.number]) {
            int weight = distance[curNode.number] + nextNode.weight;
            if (weight < distance[nextNode.number]) {
                distance[nextNode.number] = weight;
                pQue.add(new Node(nextNode.number, weight));
            }
        }
        routing();
    }

    private class Node implements Comparable<Node> {
        public int number;
        public int weight;
        Node (int number, int weight) {
            this.number = number;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            if (other.weight < this.weight) {
                return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        Telegram tg = new Telegram();
        tg.doit();
    }
}
