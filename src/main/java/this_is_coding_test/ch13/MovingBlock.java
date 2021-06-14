package this_is_coding_test.ch13;

import java.util.LinkedList;
import java.util.Queue;

class MovingBlock {
    static final int HORIZON = 0;
    static final int VERTICAL = 1;

    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    public int solution(int[][] board) {
        int mapSize = board.length + 2;
        int[][] map = new int[mapSize][mapSize];
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                if (y == 0 || x == 0 || y == mapSize - 1 || x == mapSize - 1) {
                    map[y][x] = 1;
                } else {
                    map[y][x] = board[y - 1][x - 1];
                }
            }
        }

        boolean[][][] visit = new boolean[mapSize][mapSize][2];
        YX endPoint = new YX(board.length, board.length);

        Robot robot = new Robot(new YX(1, 1), new YX(1, 2), 0);
        Queue<Robot> que = new LinkedList<>();
        que.add(robot);

        while (!que.isEmpty() && !robot.isArrive(endPoint)) {
            robot = que.poll();
            YX leftUp = robot.getLeftUp();
            int axis = robot.getAxis();

            if (visit[leftUp.y][leftUp.x][axis]) {
                continue;
            }
            visit[leftUp.y][leftUp.x][axis] = true;

            for (int d = 0; d < dx.length; d++) {
                YX part1 = new YX(robot.part1.y + dy[d], robot.part1.x + dx[d]);
                YX part2 = new YX(robot.part2.y + dy[d], robot.part2.x + dx[d]);
                Robot candBot = new Robot(part1, part2, robot.time + 1);
                if (candBot.canExist(map) && !candBot.isVisit(visit)) {
                    que.add(candBot);
                }
            }

            for (int r = 0; r < 4; r++) {
                Robot candBot = robot.getRotatedBot(map, visit, r);
                if (candBot != null) {
                    que.add(candBot);
                }
            }
        }

        return robot.time;
    }

    class YX {
        int y;
        int x;

        YX(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getAxis(YX other) {
            return (this.y == other.y) ? HORIZON : VERTICAL;
        }

        public YX getLeftUp(YX other) {
            return (this.x < other.x || this.y < other.y) ? this : other;
        }

        public boolean isEqual(YX other) {
            return (this.x == other.x && this.y == other.y);
        }
    }

    class Robot {
        YX part1;
        YX part2;
        int time;

        Robot(YX part1, YX part2, int time) {
            this.part1 = part1;
            this.part2 = part2;
            this.time = time;
        }

        public boolean canExist(int[][] map) {
            return (map[part1.y][part1.x] == 0 && map[part2.y][part2.x] == 0);
        }

        public boolean isVisit(boolean[][][] visit) {
            int axis = part1.getAxis(part2);
            YX leftUp = part1.getLeftUp(part2);
            return visit[leftUp.y][leftUp.x][axis];
        }

        public boolean isArrive(YX endPoint) {
            return (part1.isEqual(endPoint) || part2.isEqual(endPoint));
        }

        public int getAxis() {
            return part1.getAxis(part2);
        }

        public YX getLeftUp() {
            return part1.getLeftUp(part2);
        }

        public Robot getRotatedBot(int[][] map, boolean[][][] visit, int rotate) {
            int axis = part1.getAxis(part2);
            YX rotatedPart1 = null, rotatedPart2 = null;

            if (axis == HORIZON) {
                switch (rotate) {
                    case 0:
                        rotatedPart1 = part1;
                        rotatedPart2 = new YX(part1.y + 1, part1.x);
                        break;
                    case 1:
                        rotatedPart1 = part1;
                        rotatedPart2 = new YX(part1.y - 1, part1.x);
                        break;
                    case 2:
                        rotatedPart1 = new YX(part2.y + 1, part2.x);
                        rotatedPart2 = part2;
                        break;
                    case 3:
                        rotatedPart1 = new YX(part2.y - 1, part2.x);
                        rotatedPart2 = part2;
                        break;
                }
            } else {
                switch (rotate) {
                    case 0:
                        rotatedPart1 = part1;
                        rotatedPart2 = new YX(part1.y, part1.x + 1);
                        break;
                    case 1:
                        rotatedPart1 = part1;
                        rotatedPart2 = new YX(part1.y, part1.x - 1);
                        break;
                    case 2:
                        rotatedPart1 = new YX(part2.y, part2.x + 1);
                        rotatedPart2 = part2;
                        break;
                    case 3:
                        rotatedPart1 = new YX(part2.y, part2.x - 1);
                        rotatedPart2 = part2;
                        break;
                }
            }

            int diagonalY = 0, diagonalX = 0;
            int sumY = 0, sumX = 0;
            if (rotatedPart1.isEqual(part1)) {
                sumY = part2.y + rotatedPart2.y;
                sumX = part2.x + rotatedPart2.x;
                diagonalY = sumY - part1.y;
                diagonalX = sumX - part1.x;
            } else {
                sumY = part1.y + rotatedPart1.y;
                sumX = part1.x + rotatedPart1.x;
                diagonalY = sumY - part2.y;
                diagonalX = sumX - part2.x;
            }

            if (map[diagonalY][diagonalX] == 0) {
                Robot candBot = new Robot(rotatedPart1, rotatedPart2, time + 1);
                if (candBot.canExist(map) && !candBot.isVisit(visit)) {
                    return candBot;
                }
            }
            return null;
        }
    }
}