package this_is_coding_test.ch13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sneak {
    final int NONE = 0;
    final int STUDENT = 1;
    final int TEACHER = 2;
    final int OBSTACLE = 3;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./src/this_is_coding_test/ch13/input.txt"));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        ArrayList<Pair> empty = new ArrayList<>();
        ArrayList<Pair> teachers = new ArrayList<>();

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                char val = st.nextToken().charAt(0);
                if (val == 'T') {
                    map[y][x] = TEACHER;
                    teachers.add(new Pair(x, y));
                } else if (val == 'S') {
                    map[y][x] = STUDENT;
                } else {
                    empty.add(new Pair(x, y));
                }
            }
        }

        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        getCombinations(empty.size(), 3, 0, new ArrayList<>(), combinations, 0);

        for (ArrayList<Integer> obstacles : combinations) {
            for (Integer idx : obstacles) {
                Pair obstacle = empty.get(idx);
                map[obstacle.y][obstacle.x] = OBSTACLE;
                System.out.printf("%d %d\n", obstacle.y, obstacle.x);
            }
            if (!check(map, teachers)) {
                System.out.println("YES");
                return;
            }
            for (Integer idx : obstacles) {
                Pair obstacle = empty.get(idx);
                map[obstacle.y][obstacle.x] = NONE;
            }
        }
        System.out.println("NO");
        return;
    }

    public boolean check(int[][] map, ArrayList<Pair> teachers) {
        boolean isDetected = false;
        for (Pair teacher : teachers) {
            int x = teacher.x;
            int y = teacher.y;

            while (x > 0) {
                x -= 1;
                int val = map[y][x];
                if (val == STUDENT) {
                    isDetected = true;
                } else if (val == OBSTACLE) {
                    break;
                }
            }

            x = teacher.x;
            y = teacher.y;
            while (y > 0) {
                y -= 1;
                int val = map[y][x];
                if (val == STUDENT) {
                    isDetected = true;
                } else if (val == OBSTACLE) {
                    break;
                }
            }

            x = teacher.x;
            y = teacher.y;
            while (x < map.length - 1) {
                x += 1;
                int val = map[y][x];
                if (val == STUDENT) {
                    isDetected = true;
                } else if (val == OBSTACLE) {
                    break;
                }
            }

            x = teacher.x;
            y = teacher.y;
            while (y < map.length - 1) {
                y += 1;
                int val = map[y][x];
                if (val == STUDENT) {
                    isDetected = true;
                } else if (val == OBSTACLE) {
                    break;
                }
            }
        }
        return isDetected;
    }

    public void getCombinations(int n, int r, int depth, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> res, int curIdx) {
        if (arr.size() == r) {
            ArrayList<Integer> clone = (ArrayList<Integer>) arr.clone();
            res.add(clone);
            return;
        }

        for (int i = depth; i < n; i++) {
            arr.add(i);
            getCombinations(n, r, i + 1, arr, res, curIdx + 1);
            arr.remove(curIdx);
        }
        return;
    }

    public class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        Sneak s = new Sneak();
        s.solution();
    }
}
