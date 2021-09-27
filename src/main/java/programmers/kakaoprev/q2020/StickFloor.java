package programmers.kakaoprev.q2020;

import java.util.Arrays;

public class StickFloor {

    final int NONE = 0;
    final int STICK = 1;
    final int FLOOR = 2;
    final int ALL = 3;

    final int DELETE = 0;
    final int BUILD = 1;

    public int[][] solution(int n, int[][] build_frame) {
        int[][] map = new int[n + 1][n + 1];
        int buildCnt = 0;

        for (int[] command : build_frame) {
            int x = command[0], y = command[1], type = command[2] + 1, order = command[3];

            int prev = map[y][x];
            int prevCnt = buildCnt;

            if (order == BUILD) {
                map[y][x] += type;
                buildCnt++;
            } else {
                map[y][x] -= type;
                buildCnt--;
            }

            if (!isCorrectMap(map)) {
                map[y][x] = prev;
                buildCnt = prevCnt;
            }
            //System.out.println(buildCnt);
        }

//        for (int i = 0; i < map.length; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
        int[][] answer = makeAnswer(map, buildCnt);
        return answer;
    }

    private int[][] makeAnswer(int[][] map, int buildCnt) {
        int[][] ret = new int[buildCnt][];
        int idx = 0;

        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map.length; y++) {
                if (map[y][x] != NONE) {
                    if (map[y][x] == ALL) {
                        ret[idx++] = new int[]{x, y, STICK - 1};
                        ret[idx++] = new int[]{x, y, FLOOR - 1};
                    } else if (map[y][x] == STICK) {
                        ret[idx++] = new int[]{x, y, STICK - 1};
                    } else if (map[y][x] == FLOOR) {
                        ret[idx++] = new int[]{x, y, FLOOR - 1};
                    }
                }
            }
        }
        return ret;
    }

    private boolean isCorrectMap(int[][] map) {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map.length; x++) {
                int type = map[y][x];
                if (type == ALL) {
                    if (!(isCorrectFloor(y, x, map) && isCorrectStick(y, x, map)))
                        return false;
                } else if (type == STICK) {
                    if (!isCorrectStick(y, x, map))
                        return false;
                } else if (type == FLOOR) {
                    if (!isCorrectFloor(y, x, map))
                        return false;
                }
            }
        }

        return true;
    }

    public boolean isCorrectStick(int y, int x, int[][] map) {
        if (y == 0) return true;
        if (map[y][x] == FLOOR || map[y][x] == ALL) return true;
        if (map[y - 1][x] == STICK || map[y - 1][x] == ALL) return true;

        if (x >= 1) {
            if (map[y][x - 1] == FLOOR || map[y][x - 1] == ALL) return true;
        }

        return false;
    }

    public boolean isCorrectFloor(int y, int x, int[][] map) {
        if (map[y - 1][x] == STICK || map[y - 1][x] == ALL) return true;

        if (x < map.length - 1) {
            if (map[y - 1][x + 1] == STICK || map[y - 1][x + 1] == ALL) return true;

            if (x >= 1) {
                if ((map[y][x - 1] == FLOOR || map[y][x - 1] == ALL) &&
                        (map[y][x + 1] == FLOOR || map[y][x + 1] == ALL)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        StickFloor sf = new StickFloor();
        int[][] ans = sf.solution(5, new int[][] {
                {1, 0, 0, 1},
                {1, 1, 1, 1},
                {2, 1, 0, 1},
                {2, 2, 1, 1},
                {5, 0, 0, 1},
                {5, 1, 0, 1},
                {4, 2, 1, 1},
                {3, 2, 1, 1}
        });

        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
