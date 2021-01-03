package this_is_coding_test.ch12;

public class Building {
    final int STICK = 0;
    final int BOARD = 1;
    final int ALL = 2;
    final int INSERT = 1;
    final int DELETE = 0;

    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        int[][] wall = new int[n][n];
        int structureCnt = 0;


        for (int i = 0; i < build_frame.length; i++) {
            build(wall, build_frame[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (wall[i][j] != -1) {
                    structureCnt++;
                    if (wall[i][j] == ALL) {
                        structureCnt++;
                    }
                }
            }
        }

        answer = new int[structureCnt][3];
        structureCnt = 0;
        for (int i = 0; i < 0; i++) {
            for (int j = 0; j < 0; j++) {
                if (wall[i][j] != -1) {
                    if (wall[i][j] == ALL) {
                        answer[structureCnt++] = new int[] {j, i, 0};
                        answer[structureCnt++] = new int[] {j, i, 1};
                    } else {
                        answer[structureCnt++] = new int[] {j, i, wall[i][j]};
                    }
                }
            }
        }

        return answer;
    }

    public boolean build(int[][] wall, int[] command) {
        int x = command[0];
        int y = command[1];
        int type = command[2];
        int order = command[3];
        int cur;

        cur = wall[y][x];
        if (order == DELETE) {
            if (type == STICK) {
                if (cur == ALL) {
                    wall[y][x] = BOARD;
                } else {
                    wall[y][x] = -1;
                }
            } else if (type == BOARD) {
                if (cur == ALL) {
                    wall[y][x] = STICK;
                } else {
                    wall[y][x] = -1;
                }
            }
        } else if (order == INSERT) {
            if (type == STICK) {
                if (cur == BOARD) {
                    wall[y][x] = ALL;
                } else {
                    wall[y][x] = STICK;
                }
            } else if (type == BOARD) {
                if (cur == BOARD) {
                    wall[y][x] = ALL;
                } else {
                    wall[y][x] = BOARD;
                }
            }
        }

        if (check(wall, x, y, wall[y][x])) {
            return true;
        } else {
            wall[y][x] = cur;
            return false;
        }
    }

    public boolean check(int[][] wall, int x, int y, int type) {
        switch (type) {
            case STICK:
                if (y == 0) {
                    return true;
                } else if (isEndPoint(wall, x, y)) {
                    return true;
                } else if (isSupportedByStick(wall, x, y)) {
                    return true;
                }
            case BOARD:
                if (isEndPoint(wall, x, y) && isSupportedByStick(wall, x, y)) {
                    return true;
                } else if (x > 0 && x < wall.length && isBoard(wall[y][x - 1]) && isBoard(wall[y][x + 1])) {
                    return true;
                }
            case ALL:
                if (check(wall, x, y, STICK) && check(wall, x, y, BOARD)) {
                    return true;
                }
        }
        return false;
    }

    public boolean isSupportedByStick(int[][] wall, int x, int y) {
        boolean under = true;
        if (y - 1 < 0 || !isSTICK(wall[y - 1][x])) {
            under = false;
        }
        return under;
    }

    public boolean isEndPoint(int[][] wall, int x, int y) {
        boolean left = true;
        boolean cur = true;

        if (x - 1 < 0 || !isBoard(wall[y][x - 1])) {
            left = false;
        }
        if (!isBoard(wall[y][x])) {
            cur = false;
        }

        if (left && !cur) {
            return true;
        } else if (!left && cur) {
            return true;
        }

        return false;
    }

    public boolean isSTICK(int type) {
        if (type == STICK || type == ALL) {
            return true;
        }
        return false;
    }

    public boolean isBoard(int type) {
        if (type == BOARD || type == ALL) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Building b = new Building();
        //b.solution();
    }
}
