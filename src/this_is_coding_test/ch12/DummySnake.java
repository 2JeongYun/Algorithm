package this_is_coding_test.ch12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DummySnake {
    final int[] dx = {0, 1, 0, -1};
    final int[] dy = {-1, 0, 1, 0};

    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./src/this_is_coding_test/ch12/input.txt"));
        StringTokenizer st;

        int boardSize = Integer.parseInt(br.readLine());
        int appleCnt = Integer.parseInt(br.readLine());
        int[][] appleMap = new int[boardSize][boardSize];

        for (int i = 0; i < appleCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            appleMap[y - 1][x - 1] = 1;
        }

        int commandCnt = Integer.parseInt(br.readLine());
        Queue<Command> commandQue = new LinkedList<>();
        for (int i = 0; i < commandCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            commandQue.add(new Command(time, direction));
        }

        int second = 1;
        Snake snake = new Snake();
        while (snake.move(second, appleMap, commandQue)) {
            second++;
        }

        System.out.println(second);
    }

    public static void main(String[] args) throws IOException {
        DummySnake ds = new DummySnake();
        ds.doit();
    }

    public class Snake {
        public int length = 1;
        public int direction = 1;
        public Location head = new Location(0, 0);
        Queue<Location> snakeSpace = new LinkedList<>();

        Snake() {
            snakeSpace.add(new Location(0, 0));
        }

        public boolean move(int second, int[][] appleMap, Queue<Command> commandQue) {
            int mapSize = appleMap.length;
            int nextY = head.y + dy[direction];
            int nextX = head.x + dx[direction];

            System.out.printf("sec:%d nX:%d, nY:%d, length:%d\n",second, nextX, nextY, length);

            if (nextX >= mapSize || nextX < 0 || nextY >= mapSize || nextY < 0) {
                return false;
            }
            for (Location location : snakeSpace) {
                if (location.x == nextX && location.y == nextY) {
                    return false;
                }
            }

            head.x = nextX;
            head.y = nextY;
            snakeSpace.add(new Location(nextY, nextX));
            if (appleMap[nextY][nextX] == 1) {
                appleMap[nextY][nextX] = 0;
                length++;
            }

            while (snakeSpace.size() != length) {
                snakeSpace.poll();
            }

            if (!commandQue.isEmpty() && commandQue.peek().time == second) {
                Command newDirection = commandQue.poll();
                if (newDirection.direction == 'L') {
                    if (direction == 0) {
                        direction = 3;
                    } else {
                        direction -= 1;
                    }
                } else {
                    direction += 1;
                    direction %= 4;
                }
            }

            return true;
        }
    }

    public class Command {
        public int time;
        public char direction;
        Command(int time, char direction) {
            this.time = time;
            this.direction = direction;
        }
    }

    public class Location {
        public int y;
        public int x;
        Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
