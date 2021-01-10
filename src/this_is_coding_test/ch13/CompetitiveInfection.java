package this_is_coding_test.ch13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class CompetitiveInfection {
    final int[] dx = {0, 1, 0, -1};
    final int[] dy = {1, 0, -1, 0};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./src/this_is_coding_test/ch13/input.txt"));
        StringTokenizer st;

        int mapSize, virusSize, targetX, targetY, targetSec;
        st = new StringTokenizer(br.readLine());
        mapSize = Integer.parseInt(st.nextToken());
        virusSize = Integer.parseInt(st.nextToken());
        int[][] map = new int[mapSize + 1][mapSize + 1];
        PriorityQueue<Virus> viruses = new PriorityQueue<>();

        for (int y = 1; y < map.length; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x < map.length; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] != 0) {
                    viruses.add(new Virus(x, y, map[y][x]));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        targetSec = Integer.parseInt(st.nextToken());
        targetY = Integer.parseInt(st.nextToken());
        targetX = Integer.parseInt(st.nextToken());

        Queue<Virus> que = new LinkedList<>();
        while (!viruses.isEmpty()) {
            que.add(viruses.poll());
        }

        int second = 0;
        Queue<Virus> nextQue = new LinkedList<>();
        while (!que.isEmpty() && second != targetSec) {
            Virus cur = que.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = cur.y + dy[i];
                int nextX = cur.x + dx[i];
                if (nextX < 1 || nextY < 1 || nextX >= map.length || nextY >= map.length) {
                    continue;
                }
                int nextValue = map[nextY][nextX];
                if (nextValue == 0) {
                    map[nextY][nextX] = cur.value;
                    nextQue.add(new Virus(nextX, nextY, cur.value));
                }
            }
            if (que.isEmpty()) {
                Queue<Virus> temp = que;
                que = nextQue;
                nextQue = temp;
                second++;
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++ ){
                System.out.printf("%d ", map[i][j]);
            }
            System.out.println();
        }

        System.out.println(map[targetY][targetX]);
    }

    public class Virus implements Comparable<Virus> {
        int x;
        int y;
        int value;
        Virus(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Virus o) {
            if (o.value < this.value) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        CompetitiveInfection c = new CompetitiveInfection();
        c.solution();
    }
}
