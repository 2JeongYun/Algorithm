package this_is_coding_test.ch12;

import java.util.Arrays;

public class Building {
    final int NONE = -1;
    final int PILLAR = 0;
    final int FLOOR = 1;
    final int BOTH = 2;
    final int CONSTRUCT = 1;
    final int[] dx = {0, 1, 0, -1, 0};
    final int[] dy = {1, 0, -1, 0, 0};

    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        int[][] wall = new int[n + 3][n + 3];
        int structureCnt = 0;

        for (int i = 0; i < wall.length; i++) {
            Arrays.fill(wall[i], -1);
        }

        for (int i = 0; i < build_frame.length; i++) {
            if (build_frame[i][3] == CONSTRUCT) {
                if (construct(wall, build_frame[i])) {
                    structureCnt++;
                }
            } else {
                if (destruct(wall, build_frame[i])) {
                    structureCnt--;
                }
            }
        }

        answer = new int[structureCnt][3];
        int answerIdx = 0;

        for (int i = 1; i < n + 2; i++) {
            for (int j = 1; j < n + 2; j++) {
                if (wall[j][i] == BOTH) {
                    answer[answerIdx++] = new int[] {i - 1, j - 1, 0};
                    answer[answerIdx++] = new int[] {i - 1, j - 1, 1};
                } else if (wall[j][i] != NONE) {
                    answer[answerIdx++] = new int[] {i - 1, j - 1, wall[j][i]};
                }
            }
        }

        return answer;
    }

    public boolean destruct(int[][] wall, int[] order) {
        int x = order[0] + 1;
        int y = order[1] + 1;
        int type = order[2];

        if (canDestruct(wall, x, y, type)) {
            wall[y][x] = (wall[y][x] == BOTH) ? ((type == PILLAR) ? FLOOR : PILLAR) : NONE;
            return true;
        }

        return false;
    }

    public boolean canDestruct(int[][] wall, int x, int y, int dType) {
        boolean ret = true;
        int cur = wall[y][x];

        wall[y][x] = (cur == BOTH) ? ((dType == PILLAR) ? FLOOR : PILLAR) : NONE;
        for (int i = 0; i < wall.length; i++) {
            for (int j = 0; j < wall.length; j++) {
                int otherSpace = wall[i][j];
                if (otherSpace == -1) {
                    continue;
                }
                if (isFloor(otherSpace)) {
                    if (!canExistFloor(wall, j, i)) {
                        ret = false;
                    }
                }
                if (isPillar(otherSpace)) {
                    if (!canExistPillar(wall, j, i)) {
                        ret = false;
                    }
                }

                wall[i][j] = otherSpace;
            }
        }

        wall[y][x] = cur;

        return ret;
    }

    public boolean construct(int[][] wall, int[] order) {
        int x = order[0] + 1;
        int y = order[1] + 1;
        int type = order[2];

        if (type == PILLAR) {
            if (canExistPillar(wall, x, y)) {
                if (wall[y][x] != -1) {
                    wall[y][x] = BOTH;
                } else {
                    wall[y][x] = PILLAR;
                }
                return true;
            }
        } else {
            if (canExistFloor(wall, x, y)) {
                if (wall[y][x] != -1) {
                    wall[y][x] = BOTH;
                } else {
                    wall[y][x] = FLOOR;
                }
                return true;
            }
        }
        return false;
    }

    public boolean canExistPillar(int[][] wall, int x, int y) {
        int under = wall[y - 1][x];
        int bottom = 1;

        if (y == bottom || under == PILLAR || under == BOTH || isEndPoint(wall, x, y)) {
            return true;
        }
        return false;
    }

    public boolean canExistFloor(int[][] wall, int x, int y) {
        int under = wall[y - 1][x];
        int underRight = wall[y - 1][x + 1];
        int right = wall[y][x + 1];
        int left = wall[y][x - 1];

        if ((isFloor(left) && isFloor(right)) ||
                (isPillar(under)) ||
                (isPillar(underRight))) {
            return true;
        }

        return false;
    }

    public boolean isEndPoint(int[][] wall, int x, int y) {
        int left = wall[y][x - 1];
        int cur = wall[y][x];

        if (isFloor(left) || isFloor(cur)) {
            return true;
        }
        return false;
    }

    public boolean isPillar(int type) {
        if (type == PILLAR || type == BOTH) {
            return true;
        }
        return false;
    }

    public boolean isFloor(int type) {
        if (type == FLOOR || type == BOTH) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Building b = new Building();
        int[][] test = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1},
                {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
        int[][] test2 = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1},
                {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};
        int n = 5;
        int[][] answer = b.solution(n, test);
        for (int i = 0; i < answer.length; i++) {
            System.out.printf("answer-----\n%d %d %d\n", answer[i][0], answer[i][1], answer[i][2]);
        }
    }
}

